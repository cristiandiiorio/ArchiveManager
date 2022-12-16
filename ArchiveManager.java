package programpackage;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ArchiveManager {
    static String theme;
    
    public static void main(String[] args) {
        
        FileHandler fileHandler = new FileHandler(null);
        
        try {
            File themeFile = new File("theme.txt");
            if (themeFile.createNewFile()) {
                JOptionPane.showMessageDialog(null, "New theme file created");
                fileHandler.writeTheme("light");
            } else {
                
            }
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "There has been an error");
        }
        
        theme = fileHandler.readTheme();
        
        if(ArchiveManager.theme.equals("light")){
            FlatLightLaf.setup();
            new MainWindow();
        }
        else if(ArchiveManager.theme.equals("dark")){
            FlatDarkLaf.setup();
            new MainWindow();
        }
        else{
            System.out.println(theme);
        }
            
    }
    
}
