
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class deleteListener implements ActionListener{

    MainWindow mainWindow = null;
    String seriesName = null;
    Path toBeDeleted = null;
    boolean toDelete = false;
    
    public deleteListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            seriesName = this.mainWindow.deleteDialogNameField.getText();
            
            File curDir = new File(".");
            File[] filesList = curDir.listFiles();
            int length = filesList.length;
            int counter = 1;
            for(File f : filesList){
                if(f.isFile()){
                    String fileName = f.getName();
                    if(fileName.contains("json")){
                        counter = counter + 1;
                        Gson gson = new Gson();
                        
                        //filename splitting
                        String[] fileNameSplit = fileName.split("\\.");
                        //actual filename
                        String properFileName = fileNameSplit[0];
                        
                        try (Reader reader = new FileReader(f)) {
                            if(properFileName.equals(seriesName)){
                                toBeDeleted = Paths.get(fileName);
                                toDelete = true;
                                break;
                            }
                            else{
                                if(counter >= length){
                                    JOptionPane.showMessageDialog(this.mainWindow.deleteDialog,"The tv series " + seriesName + " doesn't exist"+ "\n");
                                    toDelete = false;
                                }
                            }

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                
            }
            
            if(toDelete){
                boolean deleted = false;
                try {
                    Files.delete(toBeDeleted);
                    deleted = true;
                } catch (IOException ex) {
                    Logger.getLogger(deleteListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(deleted){
                    JOptionPane.showMessageDialog(this.mainWindow.deleteDialog,"The file " + seriesName + " has been deleted successfully");
                    this.mainWindow.deleteDialog.setVisible(false);
                }
            }
            
        }
        
        else if(e.getActionCommand().equals("Cancel")){
            this.mainWindow.deleteDialogNameField.setText("");
        }
    }
    
}
