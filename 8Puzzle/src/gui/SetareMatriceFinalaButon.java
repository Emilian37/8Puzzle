package gui;

import javax.swing.JButton;

import model.Problem;

@SuppressWarnings("serial")
public class SetareMatriceFinalaButon extends JButton implements Command {

	IntroducereMatricePanel panel;

	@Override
	public void execute() {
		Problem.getInstance().setStareFinala(panel.getMatrix());
	}
	
	public SetareMatriceFinalaButon(IntroducereMatricePanel panel) {
		super("Seteaza! ");
		this.panel = panel;
	}
}
