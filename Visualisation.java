import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Visualisation extends JPanel {

// pour la gestion des affichages en couleur
    public Color[] C = {Color.black,Color.gray,Color.blue,Color.cyan,Color.green, Color.magenta,Color.orange,Color.pink,Color.red,Color.yellow};
// constante isoscalaire f(x,y)=K
    public int k=1;
// constante qui est mise a vrai dans FenetrePrincipale lorsque le bouton "Gradient" est clique
    public boolean traceLigne=false;
    
// appelle la methode de dessin des courbes
    public void dessine(){
        repaint();
    }    
    
// constructeur du graphique
    public Visualisation() {
        super();
	Numerique.initDonnees();         
    }

// pour la recuperation du nombre d'iso courbes souhaitees
    public void integreK(String s){
        k = Integer.parseInt(s);
    }
    
// pour l'integration des coefficients de la fonction polynome saisis a partir de l'interface
    public static void integreCoef(int indiceX,int indiceY, double coef) {
        Numerique.coefficients[indiceX][indiceY]=coef;
    }
    
   public void traceLignesChamps(){
      traceLigne=true;
  }
  
  /** Methode graphique appelee a chaque fois que repaint() est ecrit
   * Ici: exemple d'affichage (juste pour voir les appels de methodes)
   * A MODIFIER INTEGRALEMENT
   * */
  
  public void paintComponent(Graphics g) {
	  	
	  	boolean numerique=true;
	  	boolean relier=true;
        super.paintComponent(g);
        drawAxes(g);
        g.setColor(Color.blue);
  	    //g.drawLine(toScreenX(xold), toScreenY(yold), toScreenX(x), toScreenY(y));  
        
        for(int j=0;j<=k;j++){
        
        	int NbPointsIso=Numerique.calculIsoScalaireNumerique(j);
        
        	for(int i=0;i<NbPointsIso;i++){
        		
        		g.setColor(Color.blue);        	
        		g.drawOval(toScreenX(Numerique.pointsCourbe[i].getX()), toScreenY(Numerique.pointsCourbe[i].getY()), 2, 2);
        	
        		if(traceLigne){
        		
        			int NbPointsGradient=Numerique.ligneChamp(i,Numerique.pointsCourbe,numerique);
        			
        			for(int n=0;n<NbPointsGradient;n++){
    
        				g.setColor(Color.red);
        				g.drawOval(toScreenX(Numerique.pointsChampsGradient[i].getX()), toScreenY(Numerique.pointsChampsGradient[i].getY()), 2, 2);
        			}
        		}
        	}
        }
        
        

  }


  /** Pour avoir la meilleure precision possible sur les calculs de toScreen, 
   *  ils sont faits en double precision puis ensuite convertis en int. 
   *  Pour ce qui est des bornes max, width-1 et height-1 correspondent 
   *  respectivement a l'indice d'abscisse et d'ordonnees maximum.
   * NE PAS TOUCHER!
   * */
  
  private int toScreenX(double x) {
     return (int)((double)((x-Numerique.xMin)*(getWidth()-1))/(double)((Numerique.xMax-Numerique.xMin)));
  }

  private int toScreenY(double y) {
    return getHeight()-1-(int)((double)((y-Numerique.yMin)*(getHeight()-1))/(double)((Numerique.yMax-Numerique.yMin)));
  }
   
  /** Methode dessinant des axes sur un graphics pris en parametre */
    private void drawAxes(Graphics g){
    g.setColor(new Color(0,125,0));
    // Axe horizontal
      g.drawLine(toScreenX(-5),toScreenY(0),toScreenX(5),toScreenY(0));         

    // Axe vertical
      g.drawLine(toScreenX(0),toScreenY(-5),toScreenX(0),toScreenY(5));  
  }
}

