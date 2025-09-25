import matplotlib.pyplot as plt
import mpl_toolkits.mplot3d
import numpy as np
import scipy.sparse as scps
import scipy.sparse.linalg as ssl
import math



def M_A_T(triangle,coordinates):
    M=np.zeros((3,3))
    sommets=coordinates[triangle,:]
    x=sommets[:,0]
    y=sommets[:,1]
    a = (x[1]-x[0])*(y[2]-y[0]) - (x[2]-x[0])*(y[1]-y[0])
    for i in range(3):
        for j in range(3):
            grad_i = (1/a) * np.array([y[(i+1)%3]-y[(i+2)%3], x[(i+2)%3]-x[(i+1)%3]])
            grad_j = (1/a) * np.array([y[(j+1)%3]-y[(j+2)%3], x[(j+2)%3]-x[(j+1)%3]])
            M[i,j] = (a/2) * (np.transpose(grad_i)@(grad_j))
    return M, a

def assemblage_A_et_b(coordinates, elements3, f):
    N_T = elements3.shape[0]
    n = coordinates.shape[0]
    b = np.zeros((n,1))
    A = np.zeros((n,n))
    
    for p in range(N_T):
        triangle = elements3[p,:]
        vertices = coordinates[triangle]
        xg, yg = np.sum(vertices/3, axis=0)
        M_T, alpha = M_A_T(triangle, coordinates)
        A[triangle[:,None], triangle] += M_T
        b[triangle] += np.ones((3,1)) * (alpha/6) * f(xg,yg)
        
    return A, b

def M_A_Q(quad, coordinates):
    M=np.zeros((4,4))
    sommets=coordinates[quad,:]
    x=sommets[:,0]
    y=sommets[:,1]

    J = np.array([[x[1]-x[0], x[3]-x[0]], [y[1]-y[0], y[3]-y[0]]])
    C = np.linalg.inv (J.T @ J)

    a = C[0,0]
    b = C[1,0]
    c = C[1,1]

    detJ = np.linalg.det(J)
    
    M = (detJ/6) * np.array([
        [2*a + 3*b + 2*c, -2*a + c, -a - 3*b - c, a - 2*c],
        [-2*a + c, 2*a - 3*b + 2*c, a - 2*c, -a + 3*b - c],
        [-a - 3*b - c, a - 2*c, 2*a + 3*b + 2*c, -2*a + c],
        [a - 2*c, -a + 3*b - c, -2*a + c, 2*a - 3*b + 2*c]
    ])


    return M ,detJ

def assemblage_maille_mixte(coordinates, elements3, elements4, f):
    A, b = assemblage_A_et_b(coordinates, elements3, f)
    
    for q in elements4:
        xg, yg = np.mean(coordinates[q], axis=0)
        M_Q, aire = M_A_Q(q, coordinates)
        A[q[:, None], q] += M_Q
        b[q] += np.ones((4,1)) * (aire / 4) * f(xg, yg)
        
    return A, b


