package graphique;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import maps.Case;
import maps.Grille;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;



public class Windows extends JFrame{
	private static final long serialVersionUID = 4207783445510444454L;
	public String TOUR_JEU = "Fee";
	// public Color selected = new Color(100,100,0);
	
	public void setTOUR_JEU(String tOUR_JEU) {
		TOUR_JEU = tOUR_JEU;
	}

	public Windows() {
		/*fenetre*/
		setTitle("JWinx");  
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/*fenetre*/

	/*barre outils*/
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 784, 16);
		getContentPane().add(toolBar);
	/*barre outils*/


		/* Partie adaptative */

		/* Affichage du tour en cours */
		JTextField textField_tourdejeu = new JTextField("C'est au tour de l'�quipe "+TOUR_JEU);
		textField_tourdejeu.setBounds(10, 27, 185, 20);
		textField_tourdejeu.setEditable(false);
		getContentPane().add(textField_tourdejeu);
		/* Affichage du tour en cours */

		
		/* Affichage de la console */
		JTextArea textField_event = new JTextArea();
		textField_event.setToolTipText("");
		textField_event.setBounds(10, 58, 764, 29);
		textField_event.setEditable(false);
		getContentPane().add(textField_event);
		
		/* 1ere Cr�ation de la grille */
		Grille grille = new Grille(); 
		grille.init_map();

		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(8,8));
		panel.setBounds(10, 98, 764, 652);
		
		/*echiquier starting*/
		Case[] Jcase = new Case[64];
		ButtonGroup bg = new ButtonGroup(); 
		/*echiquier starting*/

		for (int i = 0;i<64;i++) {
			ImageIcon icon = new ImageIcon("art/"+grille.getMap(i).getOccupant().getSymbole()+".png");
			Case Case = grille.getMap(i);
			Case.setIcon(icon);
 
			/*on colorie*/
			if (switch_int()%2==0)
			{
				Case.setBackground(new Color(0,86,27));
			}
			else Case.setBackground(new Color(253,108,158));
			/*on colorie*/

			/*cases deviennent boutons*/
			Jcase[i] = Case;
			bg.add(Case);
			panel.add(Case);


			Case.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						for (int y=0;y<64;y++) {
							if (Jcase[y].isSelected()) {
								setCase_selectionee(Jcase[y]);
								if( Jcase[y].getOccupant().getNom()==""){
									System.out.println("vide");
								}
								else{
								System.out.println(Jcase[y].getPosition());
								/*System.out.println(getCase_selectionee()); */
								System.out.println(Jcase[y].getOccupant().getNom());
								}
							}
						}
					}
				}
			);
		}
		getContentPane().add(panel);
	}
	
	/*une fois sur deux*/
	public int integer = 0;
	public int switch_int() {
		integer++;
		for (int i=0;i<64;i+=9) {
			if (integer == i) {
				integer++;
			}
		}
		return integer;
	}
	
	/*attribut*/
	public Case case_selectionee;
	
	public void setCase_selectionee(Case case_selectionee) {
		this.case_selectionee = case_selectionee;
	}
/*mauvaise idee*/
	public Case getCase_selectionee() {
		return case_selectionee;
	}

	public static void main(String[] args) {
		// EventQueue.invokeLater(new Runnable(){
		// 	public void run() {
		// 		UIManager.put("swing.blodMetal", Boolean.FALSE);
				new Windows().setVisible(true);
			}
		// });
	// }
}
