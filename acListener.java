import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class acListener implements ActionListener{

	MainWindow mainWindow = null;
	
	public acListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileHandler  fileHandler = new FileHandler(mainWindow);
		
		if(e.getActionCommand().equals("x")) {
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
                    String seriesName = null;
                    String seriesStatusPre = null;
                    String seriesLink = null;
                    boolean seriesStatus;
                    
                    while(seriesName == null){
                        seriesName = JOptionPane.showInputDialog("Series' name: (ᵖʳᵉˢˢ﹡ᵗᵒ ᵃᵇᵒʳᵗ)");

                    }
                    while(seriesStatusPre == null){
                        seriesStatusPre = JOptionPane.showInputDialog("Series' status: (ᵖʳᵉˢˢ﹡ᵗᵒ ᵃᵇᵒʳᵗ)");

                    }
                    while(seriesLink == null){
                        seriesLink = JOptionPane.showInputDialog("Series' link: (ᵖʳᵉˢˢ﹡ᵗᵒ ᵃᵇᵒʳᵗ)");

                    }

                    seriesStatus = Boolean.parseBoolean(seriesStatusPre);
                    TVSeries tvseries = new TVSeries();
                    tvseries.setName(seriesName);
                    tvseries.setStatus(seriesStatus);
                    tvseries.setLink(seriesLink);

                    fileHandler.JSONwriter(tvseries);  
                    
		}
		else if(e.getActionCommand().equals("Change")) {
                    String seriesName = JOptionPane.showInputDialog("Series' name: (ᵖʳᵉˢˢ﹡ᵗᵒ ᵃᵇᵒʳᵗ)");
                    String newSeriesStatus = JOptionPane.showInputDialog("Series' status: (ᵖʳᵉˢˢ﹡ᵗᵒ ᵃᵇᵒʳᵗ)");
                    fileHandler.JSONmod(seriesName, newSeriesStatus);
		}
                
                else if(e.getActionCommand().equals("About")){
                    JDialog dialog = new JDialog(this.mainWindow.mainFrame, "About");
                    JTextArea dialogArea = new JTextArea("This is a simple Java Swing GUI \n that uses JSON files to track \n my downloaded tv series." + "\n\n\n\n\n\n" + "            ©Cristian Di Iorio 2022");
                    
                    dialogArea.setSize(190,190);
                    dialogArea.setEditable(false);
                    dialog.add(dialogArea);
                    
                    dialog.setSize(200,200);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
		
	}

}
