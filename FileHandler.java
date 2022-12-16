package programpackage;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                JOptionPane.showMessageDialog(null,"The tv series " + tvseries.getName() + " has been added. \n Status has been set to " +  tvseries.getStatus());
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void JSONreader() {
            this.mainWindow.mainArea.setText("");
            
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
                            if(tvseries.getStatus()){
                                this.mainWindow.mainArea.append("✔ ");
                            }
                            else{
                                this.mainWindow.mainArea.append("✖ ");
                            }
                            this.mainWindow.mainArea.append(tvseries.getName());
                            this.mainWindow.mainArea.append("\n");

                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "There's been an error");
                        }

                    }
                }
                
            }
        }
        
        public void JSONsearch(String searchedSeries) {
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

                            // Convert JSON File to Java Object
                            TVSeries tvseries = gson.fromJson(reader, TVSeries.class);
                                
                            if(properFileName.equals(searchedSeries)){
                                this.mainWindow.mainArea.setText("");
                                String status;
                                if(tvseries.getStatus()){
                                    status = "downloaded";
                                }
                                else{
                                    status = "not downloaded";
                                }
                                this.mainWindow.mainArea.append(tvseries.getName() + ": " + status + "\n");
                                this.mainWindow.mainArea.append(tvseries.getLink() + "\n");
                                break;
                            }
                            else{
                                if(counter >= length){
                                    this.mainWindow.mainArea.setText("");
                                    JOptionPane.showMessageDialog(null,"The tv series " + searchedSeries + " isn't available"+ "\n");
                                }
                            }

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "There's been an error");
                    }
                    }
                }
                
            }
        }

        public void JSONmod(String seriesName, String newSeriesStatus) {
            //finds series
            File curDir = new File(".");
            
            File[] filesList = curDir.listFiles();
            int length = filesList.length;
            int counter = 1;
            for(File f : filesList){
                if(f.isFile()){
                    String fileName = f.getName();
                    if(fileName.contains("json")){
                        counter = counter + 1 ;
                        Gson gson = new Gson();
                        
                        //filename splitting
                        String[] fileNameSplit = fileName.split("\\.");
                        //actual filename
                        String properFileName = fileNameSplit[0];
                        try (Reader reader = new FileReader(f)) {

                        // Convert JSON File to Java Object
                        TVSeries tvseries = gson.fromJson(reader, TVSeries.class);

                        if(properFileName.equals(seriesName)){
                            //search and change
                            GsonBuilder builder = new GsonBuilder(); 
                            builder.setPrettyPrinting();
                            gson = builder.create(); 
                            FileWriter writer;   
                            boolean newStat = Boolean.parseBoolean(newSeriesStatus);
                            tvseries.setStatus(newStat);
                            try {
                                String address = tvseries.getName();
                                writer = new FileWriter(address + ".json");
                                writer.write(gson.toJson(tvseries));
                                //writer.write("\n");
                                writer.flush();
                                writer.close();
                                JOptionPane.showMessageDialog(null,"The tv series " + tvseries.getName() + " status' has been set to " +  tvseries.getStatus());
                                break;
                            } catch (IOException ex) {
                                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else{
                            if(counter >= length){
                                JOptionPane.showMessageDialog(null, "The tv series you are searching for doesn't exist");
                            }
                        }

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "There's been an error");
                    }
                    }
                }
                
            }
        
        
            
        }
        
        static void writeTheme(String newTheme) {
            
            try {
                FileWriter fw = new FileWriter("theme.txt");
                fw.write(newTheme);
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        static String readTheme(){
            String theme = null;
            File themeFile = new File("theme.txt");
            Scanner scanner;
            
            try {
                scanner = new Scanner(themeFile);
                theme = scanner.nextLine();
                scanner.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return theme;
        }
	
}
