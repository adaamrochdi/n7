import java.awt.Color;
/** Mini-Projet 1
 * @author ROCHDI Adam
 */
 public class Cercle implements Mesurable2D{
       private Point centre;    //le centre du cercle
       private double rayon;    // Le rayon de cercle qui est un réel
       private Color couleur;   // Définir la couleur du cercle


       public static final double PI = Math.PI; //Définir la constante PI

    /** Créer un cercle à partir d'un centre c et un rayron r.
     * @param c le centre du cercle
     * @param r rayon du cercle
     */
       public Cercle(Point c, double r) {
           assert(c != null && r > 0);
                Point c1 = new Point(c.getX(), c.getY());
            this.centre = c1;
            this.rayon = r;
            this.couleur = Color.blue;
       }
       
       /** Creer un cercle à partir de 2 points diametralement opposés.
        * sa couleur est bleue
        * @param p1 le premier point
        * @param p2 le deuxieme point
        */
       public Cercle(Point p1, Point p2) {
         assert(p1 != null && p2 != null);
         assert(p1.getX() != p2.getX() || p1.getY() != p2.getY());
        
            double centrex = (p1.getX() + p2.getX()) / 2;
            double centrey = (p1.getY() + p2.getY()) / 2;
            this.centre = new Point(centrex, centrey);
            this.rayon = p1.distance(p2) / 2;
            this.couleur = Color.blue;
       }

       /** Construire un cercle à partir de deux.
       * points diamétralement opposés et de sa couleur
       * @param p1 premier point
       * @param p2 deuxieme point
       * @param nvColeur la couleur du cercle
       */
       public Cercle(Point p1, Point p2, Color nvColeur) {
        assert(p1 != null && p2 != null);
        assert(p1.getX() != p2.getX() || p1.getY() != p2.getY());        
           assert nvColeur != null;
           double centrex = (p1.getX() + p2.getX()) / 2;
           double centrey = (p1.getY() + p2.getY()) / 2;
           this.centre = new Point(centrex, centrey);
           this.rayon = p1.distance(p2) / 2;
           this.couleur = nvColeur;
       }

      /** Créer un cercle à partir de deux points.
       * le premier correspond au centre du cercle
       * et le deuxième est un point du cercle
       * @param p1 le centre
       * @param p2 point appartient au cercle
       * @return un cercle
       */
       public static Cercle creerCercle(Point p1, Point p2) {
            assert(p1 != null && p2 != null && p1 != p2);
            return new Cercle(p1, p1.distance(p2));
        }

        /** Translater le centre.
	    * @param dx déplacement suivant l'axe des X
	    * @param dy déplacement suivant l'axe des Y
	    */
        public void translater(double dx, double dy) {
            this.centre.translater(dx, dy);
        } 
        
        /** obtenir le centre d’un cercle.
       *
       * @return Point
       */ 
        public Point getCentre() {
            return new Point(this.centre.getX(), this.centre.getY());
        }

        /**obtenir le rayon d’un cercle.
       * @return double
       */
        public double getRayon() {
            return this.rayon;
        }

       /** obtenir le diametre d’un cercle.
       * @return double
       */       
        public double getDiametre() {
            return 2 * this.rayon;
        }

       /** Obtenir la couleur du Cercle.
        * @return la couleur du Cercle
        */
        public Color getCouleur() {
                return this.couleur;
        }

       /**Changer le centre d'un cercle.
        * @param nouveauPoint le nouveau centre du cercle
        */        
        public void setCentre(Point nouveauPoint){
            this.centre = nouveauPoint;
        }

       /** Changer le rayon du cercle.
        * @param nouveauRayon nouvel rayon
        */
        public void setRayon(double nouveauRayon) {
            assert nouveauRayon > 0;
            this.rayon = nouveauRayon;
        }
 
        /** Changer le diamètre du cercle.
        * @param nouveauDiam nouvelle Diametre
        */        
        public void setDiametre(double nouveauDiam) {
            assert nouveauDiam > 0;
            this.rayon = nouveauDiam / 2;
        }
 
        /** Changer la couleur du cercle.
	    * @param nouvelleCouleur nouvelle couleur
	    */
        public void setCouleur(Color nouvelleCouleur) {
                assert nouvelleCouleur != null;
                this.couleur = nouvelleCouleur;
        }

       /** savoir si le cercle contient un cercle.
        * @param p
        * @return boolean
        */
        public boolean contient(Point p) {
            assert p != null;
            return p.distance(this.getCentre()) <= this.getRayon();
        }

        /** Le périmètre d’un cercle.
        * @return double
        */
        public double perimetre() {
            double t = 2 * PI * this.rayon;
            return t;
        }
 
       /** L'aire d’un cercle.
        * @return double
        */
        public double aire() {
            double s = PI * Math.pow(this.getRayon(), 2);
            return s;
        }
 
       /**afficher le cercle sous la forme Cr@(a,b).
         *@return la forme d'affichage d'un cercle
        */
        public String toString() {
               return "C" + this.rayon + "@" + this.centre;
           }

 }
 
 
 
 
