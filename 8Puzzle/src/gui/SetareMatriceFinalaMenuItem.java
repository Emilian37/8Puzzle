package gui;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SetareMatriceFinalaMenuItem extends JMenuItem implements Command {

	IntroducereMatricePanel panel;
	JPanel mainPanel;
	JFrame frame;
	public SetareMatriceFinalaMenuItem(JPanel pan,JFrame frame) {
		super("Setare Matrice Finala");
		this.panel = new IntroducereMatricePanel();
		this.mainPanel=pan;
		this.frame=frame;
	}

	@Override
	public void execute() {
		mainPanel.removeAll();
		JLabel label=new JLabel("Introduceti matricea finala: ");
		SetareMatriceFinalaButon buton=new SetareMatriceFinalaButon(panel);
		buton.addActionListener((ActionListener)this.frame);
		mainPanel.add(label);
		mainPanel.add(panel);
		mainPanel.add(buton);
		frame.pack();
		frame.repaint();
	}

}
