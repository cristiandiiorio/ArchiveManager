package programpackage;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ArchiveManager {
    static String theme;
    
    public static void main(String[] args) {
        
        try {
            File themeFile = new File("theme.txt");
            if (themeFile.createNewFile()) {
                JOptionPane.showMessageDialog(null, "New theme file created");
            } else {
                
            }
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "There has been an error");
        }
        
        FileHandler fileHandler = new FileHandler(null);
        
        theme = fileHandler.readTheme();
        
        if(ArchiveManager.theme.equals("light")){
            FlatLightLaf.setup();
            new MainWindow();
        }
        else{
            FlatDarkLaf.setup();
            new MainWindow();
        }
            
    }
    
}
