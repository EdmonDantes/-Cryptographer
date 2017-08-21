package mainpackage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.UnsupportedEncodingException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class MainClass extends JFrame{

	/**
	 * Version
	 */
	private static final long serialVersionUID = 3L;
	
	public static void main(String[] args) {
		MainClass frame = new MainClass();
		frame.setBounds(0, 0, 800, 600);
		frame.setResizable(false);
		Rectangle rec = new Rectangle(10,10,10,10);
		Border bord = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.decode("#888888"), Color.decode("#888888"));
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		JTextArea tv = new JTextArea();
		tv.setBounds(rec);
		tv.setBorder(bord);
		tv.setEditable(false);
		tv.setLineWrap(true);
		tv.setText("Напишите строку, ключ и по желанию расположение коммутаторов");
		EditText ed1 = new EditText();
		EditText ed2 = new EditText();
		EditText input = new EditText();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		ed1.setText("Ключ");
		ed2.setText("Коммутаторы");
		input.setText("Строка");
		ed1.setToolTipText("Ключ");
		ed2.setToolTipText("Коммутаторы");
		input.setText("Строка");
		ed1.setHint("Ключ");
		ed2.setHint("Коммутаторы");
		input.setHint("Строка");
		
		ed1.setBounds(rec);
		ed1.setBorder(bord);
		
		ed2.setBounds(rec);
		ed2.setBorder(bord);
		
		input.setBounds(rec);
		input.setBorder(bord);
		
		panel.add(ed1);
		panel.add(ed2);
		main.add(tv);
		main.add(panel);
		 ButtonGroup group = new ButtonGroup();
		 JRadioButtonMenuItem item1 = new JRadioButtonMenuItem();
		 item1.setText("Зашифровать");
		 JRadioButtonMenuItem item2 = new JRadioButtonMenuItem();
		 item2.setText("Дешифровать");
		 group.add(item1);
		 group.add(item2);
		 item1.setSelected(true);
		 main.add(item1);
		 main.add(item2);
		 main.add(input);
		JButton bu = new JButton();
		bu.setText("Выполнить");
		bu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent aer) {
				action(frame,tv,input,ed1,ed2,item1);
			}});
		JButton bu3 = new JButton();
		bu3.setText("Создать пары коммутаторов");
		bu3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ed2.setText(Enigma.getRandomreflectors().toCharArray());
				
			}});
		JButton bu4 = new JButton();
		bu4.setText("Создать ключ");
		bu4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ed1.setText(Enigma.getRandomKey().toCharArray());
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		JPanel buttoms = new JPanel();
		buttoms.setLayout(new BoxLayout(buttoms,BoxLayout.X_AXIS));
		JButton bu2 = new JButton();
		bu2.setText("Сброс");
		bu2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					ed1.deletefocus();
					ed2.deletefocus();
					input.deletefocus();
					item1.setSelected(true);
					tv.setText("Напишите строку, ключ и по желанию расположение коммутаторов");
					tv.transferFocusBackward();
			}});
		buttoms.add(bu);
		buttoms.add(bu2);
		buttoms.add(bu3);
		buttoms.add(bu4);
		input.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER){
					action(frame,tv,input,ed1,ed2,item1);
					SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			            	input.setText(input.getText().substring(0, input.getText().length()-1));
			            }
			        });
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}});
		main.add(buttoms);
		frame.add(main);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public MainClass(){
		super("Шифровщик. Версия " + serialVersionUID);
	}
	
	public static void action(JFrame frame,JTextArea tv,EditText input,EditText ed1,EditText ed2,JRadioButtonMenuItem item1){
		if (item1.isSelected()){
			try{
				long start = System.nanoTime();
				tv.setText(Enigma.encode(input.getText(null), ed1.getText(null), ed2.getText(null)));
				long end = System.nanoTime();
				System.out.println(end - start);
			}catch(MyException e){
				if (e.getID() == 1){
					Object[] options = { "Ок" };
					JOptionPane.showOptionDialog(frame, "Неправильно указан ключ. Он должен быть не больше 10 символов",
                            "Ошибка", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
				}else{
					Object[] options = { "Ок" };
					JOptionPane.showOptionDialog(frame, "Укажите ключ",
                            "Ошибка", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
				}
			}
		}else{
			try{
				long start = System.nanoTime();
				tv.setText(Enigma.decode(input.getText(null), ed1.getText(null), ed2.getText(null)));
				long end = System.nanoTime();
				System.out.println(end - start);
			}catch(MyException e){
				if (e.getID() == 1){
					Object[] options = { "Ок" };
					JOptionPane.showOptionDialog(frame, "Неправильно указан ключ. Он должен быть не больше 10 символов",
                            "Ошибка", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
				}else{
					Object[] options = { "Ок" };
					JOptionPane.showOptionDialog(frame, "Укажите ключ",
                            "Ошибка", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
				}
			}
		}
	}

}
