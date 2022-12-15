package programpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class acListener implements ActionListener{

	MainWindow mainWindow = null;
	
	public acListener(MainWindow mainWindow){
            this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileHandler  fileHandler = new FileHandler(mainWindow);
		
		if(e.getActionCommand().equals("⌫")) {
                    this.mainWindow.cercaField.setText("");
		}
		
		else if(e.getActionCommand().equals("Search")) {
                    String searchedSeries = null;
                    
                    while(searchedSeries == null){
                        searchedSeries = this.mainWindow.cercaField.getText();
                    }
                    fileHandler.JSONsearch(searchedSeries);
		}
		
		else if(e.getActionCommand().equals("List")) {
                    fileHandler.JSONreader();
		}
		
		else if(e.getActionCommand().equals("Add")) {
                    this.mainWindow.dialog1.setVisible(true);
                }        
		
		else if(e.getActionCommand().equals("Change")) {
                    this.mainWindow.dialog1Mod.setVisible(true);
		}
                
                else if(e.getActionCommand().equals("Delete")){
                    this.mainWindow.deleteDialog.setVisible(true);
                }
                
                else if(e.getActionCommand().equals("Light theme")){
                    ArchiveManager.theme = "light";
                    this.mainWindow.lightButton.setEnabled(false);
                    this.mainWindow.darkButton.setEnabled(true);
                }
                
                else if(e.getActionCommand().equals("Dark theme")){
                    ArchiveManager.theme = "dark";
                    this.mainWindow.lightButton.setEnabled(true);
                    this.mainWindow.darkButton.setEnabled(false);
                }
		
                else if(e.getActionCommand().equals("About")){
                    JDialog dialog = new JDialog(this.mainWindow.mainFrame, "About");
                    JTextArea dialogArea = new JTextArea("This is a simple Java Swing GUI \n that uses JSON files to track \n my downloaded tv series." + "\n\n\n\n\n\n" + "            Cristian Di Iorio 2022");
                    
                    dialogArea.setSize(190,190);
                    dialogArea.setEditable(false);
                    dialog.add(dialogArea);
                    
                    dialog.setSize(200,200);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
	}

}
