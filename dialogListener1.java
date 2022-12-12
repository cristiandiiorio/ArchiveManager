
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


public class dialogListener1 implements ActionListener{

    MainWindow mainWindow = null;
    static String seriesName = null;
    
    public dialogListener1(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Ok")){
            seriesName = this.mainWindow.nameField1.getText();
            this.mainWindow.dialog1.setVisible(false);
            this.mainWindow.dialog2.setVisible(true);
        }
                    
    }
    
    
}
