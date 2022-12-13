

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dialogListener3 implements ActionListener{

    MainWindow mainWindow = null;
    String seriesName = null;
    String seriesLink = null;
    
    public dialogListener3(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seriesName = dialogListener1.seriesName;
        seriesLink = dialogListener2.seriesLink;
        String seriesStatusPre = null;
        boolean seriesStatus;
        
        FileHandler fileHandler = new FileHandler(mainWindow);
        
        if(e.getActionCommand().equals("Ok")){
            seriesStatusPre = this.mainWindow.nameField3.getText();
            this.mainWindow.dialog3.setVisible(false);

            seriesStatus = Boolean.parseBoolean(seriesStatusPre);
            TVSeries tvseries = new TVSeries();
            tvseries.setName(seriesName);
            tvseries.setStatus(seriesStatus);
            tvseries.setLink(seriesLink);

            fileHandler.JSONwriter(tvseries);
        }
        
        else if(e.getActionCommand().equals("Cancel")){
            this.mainWindow.nameField1.setText("");
        }
    }
                    
}
    

