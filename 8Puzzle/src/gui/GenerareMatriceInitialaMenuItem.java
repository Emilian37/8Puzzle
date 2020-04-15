package gui;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Problem;

@SuppressWarnings("serial")
public class GenerareMatriceInitialaMenuItem extends JMenuItem implements Command {
	
	JPanel mainPanel;
	JFrame frame;
	
	

	public GenerareMatriceInitialaMenuItem(JPanel mainPanel, JFrame frame) {
		super("Generare Matrice Initiala");
		this.mainPanel = mainPanel;
		this.frame = frame;
	}



	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MatrixPanel mxp=new MatrixPanel();
		this.mainPanel.removeAll();
		this.mainPanel.add(mxp);
		Problem.getInstance().setStareInitiala(mxp.getMatrix());
		frame.pack();
		frame.repaint();

	}

}
