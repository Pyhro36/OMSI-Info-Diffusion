
public class Numerique {

    // variables static a declarer ici
    public static double yMin=-5;
    public static double yMax=5;
    
    public static double xMin=-5;
    public static double xMax=5;
    
    final static int TAILLE_MATRICE=4;
    final static int NB_POINTS=500;
    public static Point[] pointsCourbe;
    public static Point[] pointsChampsGradient;
    public static double[][] coefficients;

    // parametres du modele a faire evoluer

    /** Methode initDonnees cree les tableaux en memoire, les initialise
    */
   public static void initDonnees(){
        pointsCourbe=new Point[NB_POINTS];
        pointsChampsGradient=new Point[NB_POINTS];
        coefficients= new double [TAILLE_MATRICE][TAILLE_MATRICE];
        for (int i=0; i<NB_POINTS; i++){
            pointsCourbe[i]=new Point(0,0);
            pointsChampsGradient[i]=new Point(0,0);
        }
        initialise_matrice (coefficients);
   } 
   
    public static void initialise_matrice (double[][] mat){
    	
    	initialise_TabPoints(pointsCourbe);
    	initialise_TabPoints(pointsChampsGradient);
    	for(int i=0;i<coefficients.length;i++){
    		for(int j=0;j<coefficients.length;j++)
    			coefficients[i][j]=0.0;
    	}
    	
    }
     
    public static void initialise_TabPoints (Point[] tab){
       for (int i=0; i<tab.length; i++){
                tab[i].setX(0);
                tab[i].setY(0);
            }
            
    }
    
    /** Methode reinitialise permet de mettre a 0 les tableau pour recommencer un nouveau calcul
     */
    
    public static void reinitialise (){ 
    
    	initialise_TabPoints(pointsCourbe);
    	initialise_TabPoints(pointsChampsGradient);
    	for(int i=0;i<coefficients.length;i++){
    		for(int j=0;j<coefficients.length;j++)
    			coefficients[i][j]=0.0;
    	}
    	
    }
    
    /** Methode valueFonction retourne la valeur double du calcul de la fonction au point P
     *  @param mat tableau 2D contenant les coefficients de la fonction
     *  @param x double abscisse du point P
     *  @param y double ordonnee du point P
     *  @return double resultat de la fonction en ce point P
     */
    public static double valueFonction(double x, double y, double[][] mat){
	
    	double res=0.0;
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
			
				res+=mat[i][j]*Math.pow(x,i)*Math.pow(y,j);
			}
		}
		
    	return res;
    }
    
    /** Methode calculDeriveXAnalytique retourne le tableau 2D des coefficients derives en X
     *  @param mat tableau 2D contenant les coefficients de la fonction polynome
     *  @return tableau 2D des coefficients derives en X
     */
    
    public static double[][] calculDeriveXAnalytique (double[][] mat){
    	
    	double[][] der=new double[mat.length][mat[0].length];
		
    	for(int i=0;i<mat.length-1;i++){
    		
    		for(int j=0;j<mat[0].length;j++){
			
				der[i][j]=mat[i+1][j]*(i+1);
				
    		}
		}
		
		return der;
	}
    
    /** Methode calculDeriveYAnalytique retourne le tableau 2D des coefficients derives en Y
     *  @param mat tableau 2D contenant les coefficients de la fonction polynome
     *  @return tableau 2D des coefficients derives en Y
     */
    
    public static double[][] calculDeriveYAnalytique (double[][] mat){
    	
    	double[][] der=new double[mat.length][mat[0].length];
		
    	for(int i=0;i<mat.length;i++){
    		
    		for(int j=0;j<mat[0].length-1;j++){
			
				der[i][j]=mat[i][j+1]*(j+1);
				
    		}
		}
		
		return der;
	}
    
    /** Methode calculDeriveXNumerique retourne la valeur double approchee de la derivee en X au point considere
     *  @param mat tableau 2D contenant les coefficients de la fonction polynome
     *  @param h double indiquant le pas tres petit pour le calcul de la variation entre deux valeurs
     *  @param x0 double abscisse du point P0
     *  @param y0 double ordonnee du point P0
     *  @return double resultat de la derivee en X
     */
    
    public static double calculDeriveXNumerique (double[][] mat, double h, double x0, double y0){
    	
    	return (valueFonction(x0+h, y0, mat)-valueFonction(x0, y0, mat))/h;
    	
    }
    
    /** Methode calculDeriveYNumerique retourne la valeur double approchee de la derivee en Y au point considere
     *  @param mat tableau 2D contenant les coefficients de la fonction polynome
     *  @param h double indiquant le pas tres petit pour le calcul de la variation entre deux valeurs
     *  @param x0 double abscisse du point P0
     *  @param y0 double ordonnee du point P0
     *  @return double resultat de la derivee en Y
     */    
    public static double calculDeriveYNumerique (double[][] mat, double h, double x0, double y0){
    	
    	return (valueFonction(x0, y0+h, mat)-valueFonction(x0, y0, mat))/h;
    	
    }

    /** Methode ligneChamp cree un tableau de Point concu pour contenir les points des lignes de champs 
     *  @param indice indique l'indice du point dans le tableau isoCourbe d'ou on part
     *  @param isoCourbe tableau de point de l'isocourbe
     *  @param numerique boolean indique si on choisit une approximation numerique du calcul du gradient ou analytique
     *  @return tableau de Point contenant la liste des points de la ligne de champ de gradient a partir du point isoCourbe[indice]
     */
    public static int ligneChamp(int indice, Point[] isoCourbe, boolean numerique){
	   
	   pointsChampsGradient[0]=isoCourbe[indice];
	   
	   if (numerique){
 
    		for(int i=1;i<pointsChampsGradient.length;i++){
    			
    			pointsChampsGradient[i].setX(pointsChampsGradient[i-1].getX()+(calculDeriveXNumerique(coefficients, 0.01, pointsChampsGradient[i-1].getX(), pointsChampsGradient[i-1].getY())*0.01));
    			pointsChampsGradient[i].setY(pointsChampsGradient[i-1].getY()+(calculDeriveYNumerique(coefficients, 0.01, pointsChampsGradient[i-1].getX(), pointsChampsGradient[i-1].getY())*0.01));
        		
    		}
    		
    	}else{
    		
    		double[][] deriveX=calculDeriveXAnalytique(coefficients);
    		double[][] deriveY=calculDeriveYAnalytique(coefficients);
    		for(int i=1;i<pointsChampsGradient.length;i++){
    			
    			pointsChampsGradient[i].setX(pointsChampsGradient[i-1].getX()+(valueFonction(pointsChampsGradient[i-1].getX(), pointsChampsGradient[i-1].getY(),deriveX)*0.02));
    			pointsChampsGradient[i].setY(pointsChampsGradient[i-1].getY()+(valueFonction(pointsChampsGradient[i-1].getX(), pointsChampsGradient[i-1].getY(),deriveY)*0.02));
        		
    		}
    		
    	}
    	
	   return pointsChampsGradient.length;
    }

    /** Methode calculIsoScalaireNumerique cree un tableau de Point concu pour contenir les points d'une isocourbe 
     *  @param constante int indique la valeur telle que f(x,y)=constante pour l'isocourbe consideree
     *  @return tableau de Point contenant la liste des points de l'isocourbe (contenant au maximum NB_POINTS)
     */
    public static int calculIsoScalaireNumerique(int constante){
    	
    	
    	int nbPointsCourbe=0;
    	
    	double e=0.1;
    	
    	for(double x=-5;x<=5;x+=0.05){
    		
    		for(double y=-5;y<=5;y+=0.05){
    			
    			if(Math.abs(valueFonction(x,y,coefficients)-constante)<e){
    				
    				pointsCourbe[nbPointsCourbe]=new Point(x,y);
    				nbPointsCourbe++;

    			}
    		}
    	}
    	
    	return nbPointsCourbe;
    		
    }
    /**constante int et f(x,y) double donc en prends une petit epsilon tel que const=f(x,y) + ou - epsilon (variable globale)
     *  et donc faire comparraison entre 
     */
}
