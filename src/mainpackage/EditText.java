package mainpackage;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
public class EditText extends JEditorPane {
	private static final long serialVersionUID = 1L;
	private boolean bool = false;
	private boolean a = true;
	private String hint = "";
	
	public EditText(){
		super();
		this.setForeground(Color.GRAY);
		this.setCaretColor(Color.BLUE);
		EditText ed = this;
		this.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e) {
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (bool)
				if (ed.getText().length() == 0){
					ed.setForeground(Color.GRAY);
					ed.setText(hint);
					a = true;
				}
				
			}});
		this.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				if (bool)
				if (ed.isCursorSet() == true & a == true){
					SwingUtilities.invokeLater(new Runnable(){

						@Override
						public void run() {
							ed.setText("");
							ed.setForeground(Color.black);
						}});
					
					a = false;
				}
			}});
	}
	
	public void setHint(String text){
		bool = true;
		this.hint = text;
	}
	
	public void deletefocus(){
		if (bool)
			this.setText("");
			if (this.getText().length() == 0){
				this.setForeground(Color.GRAY);
				this.setText(hint);
				a = true;
			}
	}
	
	public String getText(Void vo){
		if (a){
			return "";
		}else{
			return this.getText();
		}
	}
	
	public boolean setText(char[] str){
		if (a){
			this.setForeground(Color.BLACK);
			a = false;
			this.setText(String.valueOf(str));
		}else{
			this.setText(String.valueOf(str));
		}
		return a;
	}

}
