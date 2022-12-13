
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dialogListener3Mod implements ActionListener{

    MainWindow mainWindow = null;
    String seriesName = null;
    String seriesStatus;
    
    public dialogListener3Mod(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seriesName = dialogListener1Mod.seriesName;
        
        FileHandler fileHandler = new FileHandler(mainWindow);
        
        if(e.getActionCommand().equals("Downloaded")){
            seriesStatus = "true";
        }
        
        else if(e.getActionCommand().equals("Not Downloaded")){
            seriesStatus = "false";
        }
        
        this.mainWindow.dialog3Mod.setVisible(false);


        fileHandler.JSONmod(seriesName, seriesStatus);
    }
                    
}
    