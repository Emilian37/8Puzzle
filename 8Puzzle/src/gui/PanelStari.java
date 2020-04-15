package gui;

import java.util.Stack;

import javax.swing.*;

import model.Matrix;

@SuppressWarnings("serial")
public class PanelStari extends JPanel{
	
	protected Stack<Matrix> btStack;
	
	protected JLabel label=new JLabel("Starile problemei");
	protected MatrixPanel panel;
	
	
	public PanelStari(Stack<Matrix> btStack) {
		this.btStack=btStack;
		BoxLayout layout=new BoxLayout(this,BoxLayout.Y_AXIS);
		this.add(label);
		
	}

	public Stack<Matrix> getBtStack() {
		return btStack;
	}

	public void setBtStack(Stack<Matrix> btStack) {
		this.btStack = btStack;
	}
	
}
