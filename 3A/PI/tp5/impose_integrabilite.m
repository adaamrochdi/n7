function M1 = impose_integrabilite(M0,mask_integrability)
% B: |\Omega| x 3
% S: 3 x q
% I: |\Omega| x q
% mask_integrability: nrows x ncols
% Reference: Shape and albedo from multiple images using SVD and integrability - Yuille and Snow

B = transpose(M0);

Isize = size(mask_integrability);
Iinds = find(mask_integrability(:)>0);		% Indices of non-masked pixels

B_ = B(Iinds,:);

% Compute dB/dx and dB/dy:
smooth_kernel = fspecial('gaussian',[25 25],2.5);
%~ smooth_kernel = fspecial('disk',3.0);
%~ smooth_kernel = 1;
for i = 1:3
	B_smooth = imfilter(reshape(B(:,i).*mask_integrability(:),Isize),smooth_kernel,'same');
	%~ B_smooth = reshape(B(:,i).*mask_integrability(:),Isize);
	[dBidx dBidy] = gradient(B_smooth);
	dBidy = -dBidy;
	dB_dx(:,i) = dBidx(Iinds);
	dB_dy(:,i) = dBidy(Iinds);
end

% Solve the following system of equations for x_ij and y_ij:
%	 sum_{j=2:3} sum_{i=1:j-1} ( a_ij*x_ij - b_ij*y_ij) = 0
%	where,
%	 a_ij = e(i)*dedx(j)-e(j)*dedx(i)
%	 c_ij = P_3i*P_2j - P_2i*P_3j
%	 b_ij = e(i)*dedy(j)-e(j)*dedy(i)
%	 d_ij = P_3i*P_1j - P_1i*P_3j
a12 = B_(:,1).*dB_dx(:,2) - B_(:,2).*dB_dx(:,1);
a13 = B_(:,1).*dB_dx(:,3) - B_(:,3).*dB_dx(:,1);
a23 = B_(:,2).*dB_dx(:,3) - B_(:,3).*dB_dx(:,2);
b12 = B_(:,1).*dB_dy(:,2) - B_(:,2).*dB_dy(:,1);
b13 = B_(:,1).*dB_dy(:,3) - B_(:,3).*dB_dy(:,1);
b23 = B_(:,2).*dB_dy(:,3) - B_(:,3).*dB_dy(:,2);

% Solve the system A*x = 0:
%	 A = [a12 a13 a23 -b12 -b13 -b23]
%	 x = [c12 c13 c23	d12	d13	d23]
A = [a12 a13 a23 -b12 -b13 -b23 ];
[AU,AS,AV] = svd(A(:,1:6),0);
x = AV(:,size(AV,2));

% Construct the "co-factor matrix" (eqn 12) from the paper:
%	A = 	[-c23	d23	???;
%		c13	-d13	???;
%		-c12	d12	???];
mean_x = mean(abs(x(1:6)));
Ainv =	[-x(3)	x(6)	1.2*mean_x; ...
	x(2)	-x(5)	0.5*mean_x; ...
	-x(1)	x(4)	-mean_x]';

% Invert Ainv to get A:
A = inv(Ainv);

% Compute the B and S matrices from P3 and Q3:
B = B*A;

if (mean(B(:,3)<0))
	B = -B;
end

M1 = transpose(B);

end
