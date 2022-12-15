package programpackage;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;


public class ArchiveManager {
    static String theme = "light"; //TO BE READ FROM FILE
    public static void main(String[] args) {
        if(theme.equals("light")){
            FlatLightLaf.setup();
            new MainWindow();
        }
        else if(theme.equals("dark")){
            FlatDarkLaf.setup();
            new MainWindow();
        }
    }
}
