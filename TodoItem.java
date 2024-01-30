import java.time.LocalTime;

public class TodoItem {

    protected String description;
    protected boolean isCompleted;
    protected LocalTime time;
    
    public TodoItem(String description, boolean isCompleted, LocalTime time){
        this.description = description;
        this.isCompleted = isCompleted;
        this.time = time;
        
    }
    
}
