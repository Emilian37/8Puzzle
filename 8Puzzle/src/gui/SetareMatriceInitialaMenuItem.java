package gui;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SetareMatriceInitialaMenuItem extends JMenuItem implements Command{
	
	IntroducereMatricePanel panel;
	JPanel mainPanel;
	JFrame frame;
	
	public SetareMatriceInitialaMenuItem(JPanel panel,JFrame frame) {
		super("Setare Matrice Initiala");
		this.panel = new IntroducereMatricePanel();
		this.mainPanel=panel;
		this.frame=frame;
	}

	@Override
	public void execute() {
		mainPanel.removeAll();
		JLabel label=new JLabel("Introduceti matricea initiala: ");
		SetareMatriceInitialaButon buton=new SetareMatriceInitialaButon(panel);
		buton.addActionListener((ActionListener)this.frame);
		mainPanel.add(label);
		mainPanel.add(panel);
		mainPanel.add(buton);
		frame.pack();
		frame.repaint();
	}
	
}
