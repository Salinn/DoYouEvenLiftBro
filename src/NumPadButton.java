import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;


public class NumPadButton extends JButton {

	//The field to enter the information into
	private JTextField fillingField;
	
	public NumPadButton(JTextField fieldToFill, String label){
		this.setText(label);
		fillingField = fieldToFill;
	
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fillingField.setText(fillingField.getText()+getText());
			}
			
		});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
