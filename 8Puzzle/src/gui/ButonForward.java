package gui;

import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Matrix;

public class ButonForward extends JButton implements Command {

	protected Stack<Matrix> btStack;
	protected int curentMatrix;
	protected JPanel panel;
	
	public ButonForward(Stack<Matrix> bStack,JPanel p) {
		this.btStack=bStack;
		this.panel=p;
		this.curentMatrix=0;
	}
	
	@Override
	public void execute() {
		MatrixPanel mxp=new MatrixPanel();
		mxp.setMatrix(this.btStack.get(curentMatrix));
		this.remove(this.getComponentCount()-1);
		this.add(mxp);

	}

}
