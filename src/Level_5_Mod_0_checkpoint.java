import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Level_5_Mod_0_checkpoint implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea textArea = new JTextArea();
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	String words = "";

	public static void main(String[] args) {
		Level_5_Mod_0_checkpoint l5M0 = new Level_5_Mod_0_checkpoint();
	}

	Level_5_Mod_0_checkpoint() {
		frame.add(panel);
		textArea.setPreferredSize(new Dimension(800,800));
		panel.add(textArea);
		panel.add(save);
		save.addActionListener(this);
		panel.add(load);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("guuiuw.txt", true);
				fw.write(textArea.getText());
				textArea.setText("");
				fw.close();
			} catch (IOException h) {
				h.printStackTrace();
			}
		}
		if (e.getSource().equals(load)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("guuiuw.txt"));
				
				String line = br.readLine();
				while(line != null){
					System.out.println(line);
					words += line;
					line = br.readLine();
				}
				textArea.setText(words);
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
}
