import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
	
	MainWindow mainWindow = null;
	
	public FileHandler(MainWindow mainWindow) {
            this.mainWindow = mainWindow;
	}
	
	public void JSONwriter(TVSeries tvseries){
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();
            Gson gson = builder.create(); 
            FileWriter writer;   
            try {
                String address = tvseries.getName();
                writer = new FileWriter(address + ".json");
                writer.write(gson.toJson(tvseries));
                //writer.write("\n");
                writer.flush();
                writer.close();
                this.mainWindow.mainArea.append("The tv series " + tvseries.getName() + " has been added. \n Status has been set to " +  tvseries.getStatus());
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void JSONreader() {
            this.mainWindow.mainArea.setText("");
            this.mainWindow.mainArea.append("Showing all currently present tv series: \n");
            
            File curDir = new File(".");
            
            File[] filesList = curDir.listFiles();
            
            for(File f : filesList){
                if(f.isFile()){
                    String fileName = f.getName();
                    if(fileName.contains("json")){
                        Gson gson = new Gson();
                        
                        try (Reader reader = new FileReader(f)) {

                        // Convert JSON File to Java Object
                        TVSeries tvseries = gson.fromJson(reader, TVSeries.class);

                        // print details
                        this.mainWindow.mainArea.append(tvseries.getName() + ": " + tvseries.getStatus() + "\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    }
                }
                
            }
        }
        
        public void JSONsearch(String searchedSeries) {
            boolean trovato = false;
            File curDir = new File(".");
            
            File[] filesList = curDir.listFiles();
            for(File f : filesList){
                if(f.isFile()){
                    String fileName = f.getName();
                    if(fileName.contains("json")){
                        Gson gson = new Gson();
                        
                        try (Reader reader = new FileReader(f)) {

                        // Convert JSON File to Java Object
                        TVSeries tvseries = gson.fromJson(reader, TVSeries.class);

                        
                        if(fileName.contains(searchedSeries)){
                            this.mainWindow.mainArea.setText("");
                            this.mainWindow.mainArea.append(tvseries.getName() + ": " + tvseries.getStatus() + "\n");
                            this.mainWindow.mainArea.append(tvseries.getLink() + "\n");
                            trovato = true;
                        }
                        else{
                            if(!trovato){
                                this.mainWindow.mainArea.append("The tv series " + searchedSeries + " isn't available"+ "\n");
                                break;
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    }
                }
                
            }
        }

        public void JSONmod(String seriesName, String seriesStatus) {
            this.mainWindow.mainArea.append("WORK IN PROGRESS");
        }
	
}
