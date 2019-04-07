package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton("add task");
	JButton viewTasks = new JButton("view tasks");
	JButton removeTask = new JButton("remove task");
	JButton saveList = new JButton("save list");
	JButton loadList = new JButton("load list");
	ArrayList<String> taskList = new ArrayList<String>();
	public static void main(String[] args) {
		ToDoList to = new ToDoList();
	}
	ToDoList(){
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
		try {
			BufferedReader br = new BufferedReader(new FileReader("list"));
			
			String line = br.readLine();
			while(line != null){
				taskList.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addTask)) {
			String task = JOptionPane.showInputDialog("Input a task");
			taskList.add(task);
		}
		if (e.getSource().equals(viewTasks)) {
			for (int i = 0; i < taskList.size(); i++) {
				JOptionPane.showMessageDialog(null, taskList.get(i));
			}
		}
		if(e.getSource().equals(removeTask)) {
			String taskRemoved = JOptionPane.showInputDialog("Which task do you want to remove?");
			if(taskList.contains(taskRemoved)) {
				taskList.remove(taskRemoved);
			}
		}
		if (e.getSource().equals(saveList)) {
			try {
				FileWriter fw = new FileWriter("list");
				for (int i = 0; i < taskList.size(); i++) {
				fw.write(taskList.get(i));	
				fw.write("\n");
				taskList.remove(i);
				}
				fw.close();

			} catch (IOException r) {
				// TODO Auto-generated catch block
				r.printStackTrace();
			}
		}
		if(e.getSource().equals(loadList)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("list"));
				
				String line = br.readLine();
				while(line != null){
					taskList.add(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
