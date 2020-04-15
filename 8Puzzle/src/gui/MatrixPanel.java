package gui;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Matrix;
import model.Pozitie;

@SuppressWarnings("serial")
public class MatrixPanel extends JPanel {
	
	Matrix matrix;
	
	protected JLabel label1;
	protected JLabel label2;
	protected JLabel label3;
	protected JLabel label4;
	protected JLabel label5;
	protected JLabel label6;
	protected JLabel label7;
	protected JLabel label8;
	protected JLabel label9;
	
	public MatrixPanel() {
		matrix=new Matrix();
		Font font=new Font("Times New Roman",Font.BOLD,20);
		Border border=BorderFactory.createRaisedBevelBorder();
		
		label1=new JLabel();
		label1.setFont(font);
		label1.setBorder(border);
		label1.setText(" "+(matrix.getElement(new Pozitie(1,1))!=0?matrix.getElement(new Pozitie(1,1)):" ")+" ");
		
		label2=new JLabel();
		label2.setFont(font);
		label2.setBorder(border);
		label2.setText(" "+(matrix.getElement(new Pozitie(1,2))!=0?matrix.getElement(new Pozitie(1,2)):" ")+" ");
		
		label3=new JLabel();
		label3.setFont(font);
		label3.setBorder(border);
		label3.setText(" "+(matrix.getElement(new Pozitie(1,3))!=0?matrix.getElement(new Pozitie(1,3)):" ")+" ");
		
		label4=new JLabel();
		label4.setFont(font);
		label4.setBorder(border);
		label4.setText(" "+(matrix.getElement(new Pozitie(2,1))!=0?matrix.getElement(new Pozitie(2,1)):" ")+" "); 
		
		label5=new JLabel();
		label5.setFont(font);
		label5.setBorder(border);
		label5.setText(" "+(matrix.getElement(new Pozitie(2,2))!=0?matrix.getElement(new Pozitie(2,2)):" ")+" ");
		
		label6=new JLabel();
		label6.setFont(font);
		label6.setBorder(border);
		label6.setText(" "+(matrix.getElement(new Pozitie(2,3))!=0?matrix.getElement(new Pozitie(2,3)):" ")+" ");
		
		label7=new JLabel();
		label7.setFont(font);
		label7.setBorder(border);
		label7.setText(" "+(matrix.getElement(new Pozitie(3,1))!=0?matrix.getElement(new Pozitie(3,1)):" ")+" ");
		
		label8=new JLabel();
		label8.setFont(font);
		label8.setBorder(border);
		label8.setText(" "+(matrix.getElement(new Pozitie(3,2))!=0?matrix.getElement(new Pozitie(3,2)):" ")+" ");
		
		label9=new JLabel();
		label9.setFont(font);
		label9.setBorder(border);
		label9.setText(" "+(matrix.getElement(new Pozitie(3,3))!=0?matrix.getElement(new Pozitie(3,3)):" ")+" ");
		
		GridLayout layout=new GridLayout(3,3);
		
		this.setLayout(layout);
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(label9);
	}
	
	public void setMatrix(Matrix m) {
		
		this.matrix=m;
		label1.setText(" "+(matrix.getElement(new Pozitie(1,1))!=0?matrix.getElement(new Pozitie(1,1)):" ")+" ");
		label2.setText(" "+(matrix.getElement(new Pozitie(1,2))!=0?matrix.getElement(new Pozitie(1,2)):" ")+" ");
		label3.setText(" "+(matrix.getElement(new Pozitie(1,3))!=0?matrix.getElement(new Pozitie(1,3)):" ")+" ");
		label4.setText(" "+(matrix.getElement(new Pozitie(2,1))!=0?matrix.getElement(new Pozitie(2,1)):" ")+" ");
		label5.setText(" "+(matrix.getElement(new Pozitie(2,2))!=0?matrix.getElement(new Pozitie(2,2)):" ")+" ");
		label6.setText(" "+(matrix.getElement(new Pozitie(2,3))!=0?matrix.getElement(new Pozitie(2,3)):" ")+" ");
		label7.setText(" "+(matrix.getElement(new Pozitie(3,1))!=0?matrix.getElement(new Pozitie(3,1)):" ")+" ");
		label8.setText(" "+(matrix.getElement(new Pozitie(3,2))!=0?matrix.getElement(new Pozitie(3,2)):" ")+" ");
		label9.setText(" "+(matrix.getElement(new Pozitie(3,3))!=0?matrix.getElement(new Pozitie(3,3)):" ")+" ");
		
	}
	
	public Matrix getMatrix() {
		return matrix;
	}
}
