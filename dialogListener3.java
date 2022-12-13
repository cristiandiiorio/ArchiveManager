

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dialogListener3 implements ActionListener{

    MainWindow mainWindow = null;
    String seriesName = null;
    String seriesLink = null;
    boolean seriesStatus;
    
    public dialogListener3(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seriesName = dialogListener1.seriesName;
        seriesLink = dialogListener2.seriesLink;
        
        FileHandler fileHandler = new FileHandler(mainWindow);
        
        if(e.getActionCommand().equals("Downloaded")){
            seriesStatus = true;
        }
        
        else if(e.getActionCommand().equals("Not Downloaded")){
            seriesStatus = false;
        }
        
        this.mainWindow.dialog3.setVisible(false);

        TVSeries tvseries = new TVSeries();
        tvseries.setName(seriesName);
        tvseries.setStatus(seriesStatus);
        tvseries.setLink(seriesLink);

        fileHandler.JSONwriter(tvseries);
    }
                    
}
    

