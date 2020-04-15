package gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptii.InvalidMatrix;
import model.Matrix;

@SuppressWarnings("serial")
public class IntroducereMatricePanel extends JPanel {
	
	public JComboBox<String> combo1;
	public JComboBox<String> combo2;
	public JComboBox<String> combo3;
	public JComboBox<String> combo4;
	public JComboBox<String> combo5;
	public JComboBox<String> combo6;
	public JComboBox<String> combo7;
	public JComboBox<String> combo8;
	public JComboBox<String> combo9;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IntroducereMatricePanel() {
		String[] numere= {" 0 "," 1 "," 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "};
		combo1=new JComboBox(numere);
		combo2=new JComboBox(numere);
		combo3=new JComboBox(numere);
		combo4=new JComboBox(numere);
		combo5=new JComboBox(numere);
		combo6=new JComboBox(numere);
		combo7=new JComboBox(numere);
		combo8=new JComboBox(numere);
		combo9=new JComboBox(numere);
		
		GridLayout layout=new GridLayout(3,3);
		
		this.setLayout(layout);
		
		this.add(combo1);
		this.add(combo2);
		this.add(combo3);
		this.add(combo4);
		this.add(combo5);
		this.add(combo6);
		this.add(combo7);
		this.add(combo8);
		this.add(combo9);
	}
	
	public Matrix getMatrix() {
		int a11=Integer.parseInt(((String)this.combo1.getSelectedItem()).trim());
		int a12=Integer.parseInt(((String)this.combo2.getSelectedItem()).trim());
		int a13=Integer.parseInt(((String)this.combo3.getSelectedItem()).trim());
		int a21=Integer.parseInt(((String)this.combo4.getSelectedItem()).trim());
		int a22=Integer.parseInt(((String)this.combo5.getSelectedItem()).trim());
		int a23=Integer.parseInt(((String)this.combo6.getSelectedItem()).trim());
		int a31=Integer.parseInt(((String)this.combo7.getSelectedItem()).trim());
		int a32=Integer.parseInt(((String)this.combo8.getSelectedItem()).trim());
		int a33=Integer.parseInt(((String)this.combo9.getSelectedItem()).trim());
		try {
			Matrix m=new Matrix(a11,a12,a13,a21,a22,a23,a31,a32,a33);
			return m;
		} catch (InvalidMatrix e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			this.combo1.getModel().setSelectedItem("1");
			this.combo2.getModel().setSelectedItem("1");
			this.combo3.getModel().setSelectedItem("1");
			this.combo4.getModel().setSelectedItem("1");
			this.combo5.getModel().setSelectedItem("1");
			this.combo6.getModel().setSelectedItem("1");
			this.combo7.getModel().setSelectedItem("1");
			this.combo8.getModel().setSelectedItem("1");
			this.combo9.getModel().setSelectedItem("1");
		}
		
		return null;
	}
}
