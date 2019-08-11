

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import java.text.NumberFormat;
public class FenetrePrincipale extends JFrame {
    private boolean noFirstPassage;
    private GridLayout gridLayout1 = new GridLayout();
    private BorderLayout layoutMain = new BorderLayout();
        private JPanel jPanel0 = new JPanel();
        private JPanel jPanel1 = new JPanel();
        private JPanel jPanel2 = new JPanel();
        private JPanel jPanel3 = new JPanel();
        private JPanel jPanel4 = new JPanel();
        private JPanel jPanel5 = new JPanel();
        private JPanel jPanel6 = new JPanel();
        private JTextField jText_Resultat = new JTextField();
      
        private GridLayout gridLayout0 = new GridLayout();
        private JLabel jLabel00 = new JLabel("   ");
        private JLabel jLabelY0 = new JLabel("Cste");
        private JLabel jLabelY1 = new JLabel("Y");
        private JLabel jLabelY2 = new JLabel("Y2");
        private JLabel jLabelY3 = new JLabel("Y3");
    
        private GridLayout gridLayout2 = new GridLayout();
        private JLabel jLabelX0 = new JLabel("Cste");
        private JTextField jTextField00 = new JTextField();
        private JTextField jTextField01 = new JTextField();
        private JTextField jTextField02 = new JTextField();
        private JTextField jTextField03 = new JTextField();

    private GridLayout gridLayout3 = new GridLayout();
    private JLabel jLabelX1 = new JLabel("X");
    private JTextField jTextField10 = new JTextField();
    private JTextField jTextField11 = new JTextField();
    private JTextField jTextField12 = new JTextField();
    private JTextField jTextField13 = new JTextField();

    private GridLayout gridLayout4 = new GridLayout();
    private JLabel jLabelX2 = new JLabel("X2");
    private JTextField jTextField20 = new JTextField();
    private JTextField jTextField21 = new JTextField();
    private JTextField jTextField22 = new JTextField();
    private JTextField jTextField23 = new JTextField();

    private GridLayout gridLayout5 = new GridLayout();
    private JLabel jLabelX3 = new JLabel("X3");
    private JTextField jTextField30 = new JTextField();
    private JTextField jTextField31 = new JTextField();
    private JTextField jTextField32 = new JTextField();
    private JTextField jTextField33 = new JTextField();

        private GridLayout gridLayout6 = new GridLayout();
        private JLabel jLabelK = new JLabel("Nb IsoScalaires < 10 ");
        private JTextField jTextFieldK = new JTextField();
        private JButton jButton_TraceIsoCourbe = new JButton("Iso-scalaires");
        private JButton jButton_TraceChampGradient = new JButton("Gradients");
        private JButton jButton_Clear = new JButton("Clear");    
    
    private JTabbedPane jTabbedPane1 = new JTabbedPane();
    private JPanel PanelOnglet1 = new JPanel();
    private JPanel PanelOnglet2 = new JPanel();
    
    private FlowLayout flowLayoutFonction = new FlowLayout();
    private JLabel jLabelFunction = new JLabel("F (x, y)=  ");
   
    
    // preparation de l'onglet de visualisation
    private BorderLayout borderLayout2 = new BorderLayout();
    //private BorderLayout layoutVisu = new BorderLayout();
    private Visualisation isoCourbe = new Visualisation();//" Points isocourbes pour f(x,y)=k");


    public FenetrePrincipale() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        noFirstPassage=false;
        this.getContentPane().setLayout(layoutMain);
        this.setSize( new Dimension(600, 600));//490*490
        this.setTitle( "Fonction f(x,y): isocourbes et champs de gradients" );               
        jTabbedPane1.setBounds(new Rectangle(0, 0, 600, 600));//490*490
        jTabbedPane1.setSize(new Dimension(600,600));//600));
        
        PanelOnglet1.setLayout(gridLayout1);
        PanelOnglet1.setSize(new Dimension(600,600));//450
        
        // grille principale (1 colonne et 6 lignes)
        gridLayout1.setColumns(1);
        gridLayout1.setRows(7);

        gridLayout6.setColumns(5);
        gridLayout6.setRows(1);
        jButton_TraceIsoCourbe.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton_TraceIsoCourbe_actionPerformed(e);
                }
            });
        jButton_TraceChampGradient.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton_TraceChampGradient_actionPerformed(e);
                }
            });
        jButton_Clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton_Clear_actionPerformed(e);
                }
            });
        jPanel2.setLayout(gridLayout6);

        gridLayout2.setColumns(5);
        gridLayout2.setRows(1);
        jPanel3.setLayout(gridLayout2);

        gridLayout3.setColumns(5);
        gridLayout3.setRows(1);
        jPanel4.setLayout(gridLayout3);

        gridLayout4.setColumns(5);
        gridLayout4.setRows(1);
        jPanel5.setLayout(gridLayout4);

        gridLayout5.setColumns(5);
        gridLayout5.setRows(1);
        jPanel6.setLayout(gridLayout5);

        gridLayout0.setColumns(5);
        gridLayout0.setRows(1);
        jPanel0.setLayout(gridLayout0);
        
        this.setSize(new Dimension(600,600));//(443, 442));
        this.setTitle("Isoscalaires de fonctions a 2 variables et champs de gradients");
       
        jTabbedPane1.add("Creation de la fonction", PanelOnglet1);
        jTabbedPane1.add("Visualisation", PanelOnglet2);
        this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
        
        jTextField00.setText("0");
        jTextField00.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField00_mouseExited(e);
                }
            });
        jTextField01.setText("0");
        jTextField01.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField01_mouseExited(e);
                }
            });
        jTextField02.setText("0");
        jTextField02.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField02_mouseExited(e);
                }
            });
        jTextField03.setText("0");
        jTextField03.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField03_mouseExited(e);
                }
            });
        jTextField10.setText("0");
        jTextField10.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField10_mouseExited(e);
                }
            });
        jTextField11.setText("0");
        jTextField11.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField11_mouseExited(e);
                }
            });
        jTextField12.setText("0");
        jTextField12.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField12_mouseExited(e);
                }
            });
        jTextField13.setText("0");
        jTextField13.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField13_mouseExited(e);
                }
            });
        jTextField20.setText("0");
        jTextField20.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField20_mouseExited(e);
                }
            });
        jTextField21.setText("0");
        jTextField21.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField21_mouseExited(e);
                }
            });
        jTextField22.setText("0");
        jTextField22.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField22_mouseExited(e);
                }
            });
        jTextField23.setText("0");
        jTextField23.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField23_mouseExited(e);
                }
            });
        jTextField30.setText("0");
        jTextField30.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField30_mouseExited(e);
                }
            });
        jTextField31.setText("0");
        jTextField31.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField31_mouseExited(e);
                }
            });
        jTextField32.setText("0");
        jTextField32.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField32_mouseExited(e);
                }
            });
        jTextField33.setText("0");

        jTextField33.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jTextField33_mouseExited(e);
                }
            });
        jPanel1.add(jLabelFunction, null);
                this.PanelOnglet1.add(jPanel1, null);
                
                jPanel2.add(jLabelK, null);
                jPanel2.add(jTextFieldK, null);
                jPanel2.add(jButton_TraceIsoCourbe, null);
                //jPanel2.add(jButton_TraceChampGradient, null);
                jPanel2.add(jButton_Clear, null);
                this.PanelOnglet1.add(jPanel2, null);
                
                jPanel0.add(jLabel00, null);
                jPanel0.add(jLabelY0, null);
                jPanel0.add(jLabelY1, null);
                jPanel0.add(jLabelY2, null);
                jPanel0.add(jLabelY3, null);
                this.PanelOnglet1.add(jPanel0, null);

                jPanel3.add(jLabelX0, null);
                jPanel3.add(jTextField00, null);
                jPanel3.add(jTextField01, null);
                jPanel3.add(jTextField02, null);
                jPanel3.add(jTextField03, null);
                this.PanelOnglet1.add(jPanel3, null);
        
                jPanel4.add(jLabelX1, null);
                jPanel4.add(jTextField10, null);
                jPanel4.add(jTextField11, null);
                jPanel4.add(jTextField12, null);
                jPanel4.add(jTextField13, null);
                this.PanelOnglet1.add(jPanel4, null);
        
                jPanel5.add(jLabelX2, null);
                jPanel5.add(jTextField20, null);
                jPanel5.add(jTextField21, null);
                jPanel5.add(jTextField22, null);
                jPanel5.add(jTextField23, null);
                this.PanelOnglet1.add(jPanel5, null);
        
                jPanel6.add(jLabelX3, null);
                jPanel6.add(jTextField30, null);
                jPanel6.add(jTextField31, null);
                jPanel6.add(jTextField32, null);
                jPanel6.add(jTextField33, null);
                //this.getContentPane().add(jPanel6, null);
                this.PanelOnglet1.add(jPanel6, null);

        
        // ajouter ici la facon de visualiser la courbe
        PanelOnglet2.setSize(new Dimension(485, 183));
        PanelOnglet2.setLayout(borderLayout2);
        PanelOnglet2.add(jButton_TraceChampGradient,BorderLayout.SOUTH);
        
        jLabelFunction.setFont(new Font("Tahoma", 1, 14));
        PanelOnglet2.add(isoCourbe, BorderLayout.CENTER);
        this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
        
    }

    private void jButton_TraceIsoCourbe_actionPerformed(ActionEvent e) {
        jLabelFunction.setText( "F (x, y) =");
        if (jTextFieldK.getText()!=""){
            isoCourbe.integreK(jTextFieldK.getText());                                        
        }
        else isoCourbe.integreK("1");
          try{
             for (int j=0; j< Numerique.coefficients[0].length; j++){
                 for (int i=0; i<Numerique.coefficients.length;i++){                 
                     if (Numerique.coefficients[i][j]!=0){
                         NumberFormat format=NumberFormat.getInstance();
                         format.setMinimumFractionDigits(0); //nb de chiffres apres la virgule
                         String s=format.format(Numerique.coefficients[i][j]);
                          if (noFirstPassage) jLabelFunction.setText(jLabelFunction.getText()+ "+ ");                         
                          if ((i==0)&&(j==0)) jLabelFunction.setText(jLabelFunction.getText()+s);
                          if ((i==1)&&(j==1)) jLabelFunction.setText(jLabelFunction.getText()+s+"xy");
                          if ((i==2)&&(j==2)) jLabelFunction.setText(jLabelFunction.getText()+s+"x2y2");
                          if ((i==3)&&(j==3)) jLabelFunction.setText(jLabelFunction.getText()+s+"x3y3");
                          
                          if ((i==0)&&(j==1)) jLabelFunction.setText(jLabelFunction.getText()+s+"y");
                          if ((i==0)&&(j==2)) jLabelFunction.setText(jLabelFunction.getText()+s+"y2");
                          if ((i==0)&&(j==3)) jLabelFunction.setText(jLabelFunction.getText()+s+"y3");
                          
                          if ((i==1)&&(j==0)) jLabelFunction.setText(jLabelFunction.getText()+s+"x");
                          if ((i==1)&&(j==2)) jLabelFunction.setText(jLabelFunction.getText()+s+"xy2");
                          if ((i==1)&&(j==3)) jLabelFunction.setText(jLabelFunction.getText()+s+"xy3");
                          
                          if ((i==2)&&(j==0)) jLabelFunction.setText(jLabelFunction.getText()+s+"x2");
                          if ((i==2)&&(j==1)) jLabelFunction.setText(jLabelFunction.getText()+s+"x2y");
                          if ((i==2)&&(j==3)) jLabelFunction.setText(jLabelFunction.getText()+s+"x2y3");
                             
                          if ((i==3)&&(j==0)) jLabelFunction.setText(jLabelFunction.getText()+s+"x3");                             
                          if ((i==3)&&(j==1)) jLabelFunction.setText(jLabelFunction.getText()+s+"x3y");                             
                          if ((i==3)&&(j==2)) jLabelFunction.setText(jLabelFunction.getText()+s+"x3y2");                             
                          noFirstPassage=true;
                     }
                 }      
                                                                                             }
             isoCourbe.dessine();                        
         }
         catch (NumberFormatException excep){
            JOptionPane.showMessageDialog(this, " Il manque des valeurs dans les JTextFields !"," ATTENTION Saisie!! ",JOptionPane.WARNING_MESSAGE);
        }           
    }


    private void jButton_Clear_actionPerformed(ActionEvent e) {
        jTextField10.setText("");
        noFirstPassage=false;
        jTextField00.setText("0");jTextField01.setText("0");jTextField02.setText("0");jTextField03.setText("0");
        jTextField10.setText("0");jTextField11.setText("0");jTextField12.setText("0");jTextField13.setText("0");
        jTextField20.setText("0");jTextField21.setText("0");jTextField22.setText("0");jTextField23.setText("0");
        jTextField30.setText("0");jTextField31.setText("0");jTextField32.setText("0");jTextField33.setText("0");
        Numerique.reinitialise();
        jLabelFunction.setText("F(x,y)=");
    }

    private void jTextField00_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField00.getText());
        Visualisation.integreCoef(0,0,(double)constante);
    }

    private void jTextField01_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField01.getText());
        Visualisation.integreCoef(0,1,(double)constante);

    }

    private void jTextField02_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField02.getText());
        Visualisation.integreCoef(0,2,(double)constante);

    }

    private void jTextField03_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField03.getText());
       Visualisation.integreCoef(0,3,(double)constante);

    }

    private void jTextField10_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField10.getText());
        Visualisation.integreCoef(1,0,(double)constante);

    }

    private void jTextField11_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField11.getText());
        Visualisation.integreCoef(1,1,(double)constante);

    }

    private void jTextField12_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField12.getText());
        Visualisation.integreCoef(1,2,(double)constante);

    }

    private void jTextField13_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField13.getText());
        Visualisation.integreCoef(1,3,(double)constante);

    }

    private void jTextField20_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField20.getText());
        Visualisation.integreCoef(2,0,(double)constante);

    }

    private void jTextField21_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField21.getText());
        Visualisation.integreCoef(2,1,(double)constante);

    }

    private void jTextField22_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField22.getText());
        Visualisation.integreCoef(2,2,(double)constante);

    }

    private void jTextField23_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField23.getText());
        Visualisation.integreCoef(2,3,(double)constante);

    }

    private void jTextField30_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField30.getText());
        Visualisation.integreCoef(3,0,(double)constante);

    }

    private void jTextField31_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField31.getText());
        Visualisation.integreCoef(3,1,(double)constante);

    }

    private void jTextField32_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField32.getText());
        Visualisation.integreCoef(3,2,(double)constante);

    }

    private void jTextField33_mouseExited(MouseEvent e) {
        Double constante = Double.parseDouble(jTextField33.getText());
        Visualisation.integreCoef(3,3,(double)constante);

    }

    private void jButton_TraceChampGradient_actionPerformed(ActionEvent e) {
        isoCourbe.traceLignesChamps();
        isoCourbe.dessine();                                
    }
}
