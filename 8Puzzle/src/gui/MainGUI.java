package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainGUI extends JFrame implements ActionListener{
	
	JPanel mainPanel;
	JPanel panel;
	JMenuBar meniuPrincipal;
	
	JMenu meniuSetari;
	SetareMatriceInitialaMenuItem menu11;
	SetareMatriceFinalaMenuItem menu12;
	GenerareMatriceInitialaMenuItem menu13;
	GenerareMatriceFinalaMenuItem menu14;
	
	JMenu meniuAlgoritmi;
	GreedyManhattanMenuItem menu20;
	GreedyProstPlasateMenuItem menu21;
	BFRezolvareMenuItem menu22;
	DFRezolvareMenuItem menu23;
	DFIRezolvareMenuItem menu24;
	DLRezolvareMenuItem menu25;
	
	
	public MainGUI() {
		
		mainPanel=new JPanel();
		
		panel=new JPanel();
		panel.setPreferredSize(new Dimension(300,600));
		
		meniuPrincipal=new JMenuBar();
		
		meniuSetari=new JMenu("Setari");
		meniuSetari.setMnemonic(KeyEvent.VK_S);
		meniuPrincipal.add(meniuSetari);
		menu11=new SetareMatriceInitialaMenuItem(panel,this);
		menu11.setMnemonic(KeyEvent.VK_I);
		menu11.addActionListener(this);
		menu12=new SetareMatriceFinalaMenuItem(panel,this);
		menu12.setMnemonic(KeyEvent.VK_F);
		menu12.addActionListener(this);
		menu13=new GenerareMatriceInitialaMenuItem(panel,this);
		menu13.addActionListener(this);
		menu14=new GenerareMatriceFinalaMenuItem(panel,this);
		menu14.addActionListener(this);
		meniuSetari.add(menu11);
		meniuSetari.add(menu12);
		meniuSetari.add(menu13);
		meniuSetari.add(menu14);
		
		meniuAlgoritmi=new JMenu("Algoritmi");
		meniuPrincipal.add(meniuAlgoritmi);
		
		menu20=new GreedyManhattanMenuItem(panel,this);
		menu20.addActionListener(this);
		meniuAlgoritmi.add(menu20);
		
		menu21=new GreedyProstPlasateMenuItem(panel,this);
		menu21.addActionListener(this);
		meniuAlgoritmi.add(menu21);
		
		menu22=new BFRezolvareMenuItem(panel,this);
		menu22.addActionListener(this);
		meniuAlgoritmi.add(menu22);
		
		menu23=new DFRezolvareMenuItem(panel,this);
		menu23.addActionListener(this);
		meniuAlgoritmi.add(menu23);
		
		menu24=new DFIRezolvareMenuItem(panel,this);
		menu24.addActionListener(this);
		meniuAlgoritmi.add(menu24);
		
		menu25=new DLRezolvareMenuItem(panel,this);
		menu25.addActionListener(this);
		meniuAlgoritmi.add(menu25);
		
		this.setJMenuBar(meniuPrincipal);
		mainPanel.add(panel);
		
		this.add(mainPanel);
		//this.add(matrice);
		//this.add(introducerePanel);
		
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String ...strings) {
		MainGUI main=new MainGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
}
