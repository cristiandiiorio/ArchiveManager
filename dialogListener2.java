
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dialogListener2 implements ActionListener{

    MainWindow mainWindow = null;
    static String seriesLink = null;
    
    public dialogListener2(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Ok")){
            seriesLink = this.mainWindow.nameField2.getText();
            this.mainWindow.dialog2.setVisible(false);
            this.mainWindow.dialog3.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("Cancel")){
            this.mainWindow.nameField1.setText("");
        }
    }
}
