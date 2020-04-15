package gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import algoritmi.Greedy;
import algoritmi.SolvingStrategy;
import euristici.Euristica;
import euristici.Manhattan;
import euristici.NumarCasuteProstPlasate;
import model.Problem;

@SuppressWarnings("serial")
public class GreedyProstPlasateMenuItem extends JMenuItem implements Command {

	public JPanel mainPanel;
	public JFrame frame;
	
	public GreedyProstPlasateMenuItem(JPanel p,JFrame f) {
		super("Greedy+ProstPlasateEuristica !");
		this.mainPanel=p;
		this.frame=f;
	}
	
	@Override
	public void execute() {
		Euristica em=new NumarCasuteProstPlasate(Problem.getInstance().getStareFinala());
		SolvingStrategy strategieRezolvare=new Greedy(Problem.getInstance().getStareInitiala(),Problem.getInstance().getStareFinala(),em);
		
		mainPanel.removeAll();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		JLabel label=new JLabel("Cautare cu Greedy si euristica care numara cate casute sunt prost plasate");
		JLabel label1=new JLabel("Stare initiala: ");
		MatrixPanel panelMatrix1=new MatrixPanel();
		panelMatrix1.setMatrix(Problem.getInstance().getStareInitiala());
		JLabel label2=new JLabel("Stare finala: ");
		MatrixPanel panelMatrix2=new MatrixPanel();
		panelMatrix2.setMatrix(Problem.getInstance().getStareFinala());
	
		strategieRezolvare.setStareInitiala(Problem.getInstance().getStareInitiala());
		strategieRezolvare.setStareFinala(Problem.getInstance().getStareFinala());
		Problem.getInstance().setAlgoritm(strategieRezolvare);
		Problem.getInstance().rezolvare();
		
		mainPanel.add(label);
		mainPanel.add(label1);
		mainPanel.add(panelMatrix1);
		mainPanel.add(label2);
		mainPanel.add(panelMatrix2);
		
		frame.pack();
		frame.repaint();
	}

}
