package gui;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Problem;

@SuppressWarnings("serial")
public class GenerareMatriceFinalaMenuItem extends JMenuItem implements Command {
	
	JPanel mainPanel;
	JFrame frame;
	
	

	public GenerareMatriceFinalaMenuItem(JPanel mainPanel, JFrame frame) {
		super("Generare Matrice Finala");
		this.mainPanel = mainPanel;
		this.frame = frame;
	}



	@Override
	public void execute() {
		MatrixPanel mxp=new MatrixPanel();
		this.mainPanel.removeAll();
		this.mainPanel.add(mxp);
		Problem.getInstance().setStareFinala(mxp.getMatrix());
		frame.pack();
		frame.repaint();
	}

}