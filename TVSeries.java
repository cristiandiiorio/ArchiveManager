
public class TVSeries {
    private String seriesName;
    private boolean seriesStatus;
    private String seriesLink;
    
    public TVSeries(){}
    
    public String getName(){
        return seriesName;
    }
    
    public void setName(String name){
        this.seriesName = name;
    }
    
    public boolean getStatus(){
        return seriesStatus;
    }
    
    public void setStatus(boolean status){
        this.seriesStatus = status;
    }
    
    public String getLink(){
        return seriesLink;
    }
    
    public void setLink(String link){
        this.seriesLink = link;
    }
}
