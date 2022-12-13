
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dialogListener1Mod implements ActionListener{

    MainWindow mainWindow = null;
    static String seriesName = null;
    
    public dialogListener1Mod(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Ok")){
            seriesName = this.mainWindow.nameField1Mod.getText();
            this.mainWindow.dialog1Mod.setVisible(false);
            this.mainWindow.dialog3Mod.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("Cancel")){
            this.mainWindow.nameField1Mod.setText("");
        }
                    
    }
    
    
}
