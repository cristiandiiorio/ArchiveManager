package programpackage;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;


public class ArchiveManager {
    static String theme;
    
    public static void main(String[] args) {
        
        FileHandler fileHandler = new FileHandler(null);
        
        theme = fileHandler.readTheme();
        
        if(ArchiveManager.theme.equals("light")){
            FlatLightLaf.setup();
            new MainWindow();
        }
        else if(ArchiveManager.theme.equals("dark")){
            FlatDarkLaf.setup();
            new MainWindow();
        }
            
    }
    
}
