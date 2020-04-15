package gui;

import javax.swing.JButton;

import model.Problem;

@SuppressWarnings("serial")
public class SetareMatriceInitialaButon extends JButton implements Command {

	IntroducereMatricePanel panel;


	@Override
	public void execute() {
		Problem.getInstance().setStareInitiala(panel.getMatrix());
	}
	
	public SetareMatriceInitialaButon(IntroducereMatricePanel panel) {
		super("Seteaza !");
		this.panel = panel;
}
}