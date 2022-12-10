import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
                    String searchedSeries = this.mainWindow.cercaField.getText();
                    fileHandler.JSONsearch(searchedSeries);
		}
		
		else if(e.getActionCommand().equals("List")) {
                    fileHandler.JSONreader();
		}
		
		else if(e.getActionCommand().equals("Add")) {
                    String seriesName = JOptionPane.showInputDialog("Inserisci il nome della serie");
                    boolean seriesStatus = Boolean.parseBoolean(JOptionPane.showInputDialog("Inserisci lo stato della serie"));
                    String seriesLink = JOptionPane.showInputDialog("Inserisci il link della serie");                        
                    TVSeries tvseries = new TVSeries();
                    tvseries.setName(seriesName);
                    tvseries.setStatus(seriesStatus);
                    tvseries.setLink(seriesLink);

                    fileHandler.JSONwriter(tvseries);
                        
		}
		else if(e.getActionCommand().equals("Change")) {
                    String seriesName = JOptionPane.showInputDialog("Inserisci il nome della serie");
                    String seriesStatus = JOptionPane.showInputDialog("Inserisci il nuovo stato della serie");
                    fileHandler.JSONmod(seriesName, seriesStatus);
		}
		
	}

}
