import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class ToDoList {
    
    private Map<LocalDate, List<TodoItem>> taskMap;
    public static final boolean comp = false;
    public static final LocalDate currentDate = LocalDate.now();
    public ToDoList() {
        this.taskMap = new HashMap<>();
    }
    
    public void declare (LocalTime time, String description, boolean complete){
        TodoItem item = new TodoItem(description, comp, time);
    }

    public void AddTask(LocalDate date, TodoItem task){

        List<TodoItem> tasks = taskMap.get(date);

        if (tasks == null){
            tasks = new ArrayList<>();
            taskMap.put(date, tasks);
        }

        tasks.add(task);
    }

    private boolean isTimeTaken(List<TodoItem> tasks, LocalTime oldTime, LocalTime newTime) {
        for (TodoItem task : tasks) {
            if (!task.time.equals(oldTime) && task.time.equals(newTime)) {
                return true;
            }
        }
        return false;
    }
    
    public void EditTime(LocalDate date, LocalTime oldTime, LocalTime newTime) {
        List<TodoItem> tasks = taskMap.get(date);
    
        if (tasks != null) {
            if (isTimeTaken(tasks, oldTime, newTime)) {
                System.out.println("Time conflict. Time not edited.");
                return;
            }
    
            for (int i = 0; i < tasks.size(); i++) {
                TodoItem existingTime = tasks.get(i);
                if (existingTime.time.equals(oldTime)) {
                    if (isTimeTaken(tasks, oldTime, newTime)) {
                        System.out.println("Time conflict. Time not edited.");
                        return;
                    }
                    TodoItem updatedTime = new TodoItem(existingTime.description, existingTime.isCompleted, newTime);
                    tasks.set(i, updatedTime);
                    System.out.println("Time edited successfully.");
                    return;
                }
            }
        }
        System.out.println("Task not found for the specified input");
    }
    

    public void editTask (LocalDate date, LocalTime time, String desc){
        List<TodoItem> tasks = taskMap.get(date);

        if (tasks != null){
            for (int i = 0; i < tasks.size(); i++){
                TodoItem existingTask = tasks.get(i);

                if (existingTask.time.equals(time)){
                    TodoItem newTask = new TodoItem (desc, existingTask.isCompleted, existingTask.time);
                    tasks.set(i, newTask);
                    System.out.println("Task edited successfully.");
                    return;
                }
            }
        }
        System.out.println("Tas not found for the specified input");

    }

    public void deleteTask(LocalDate date, LocalTime time){
        List<TodoItem> tasks = taskMap.get(date);

        if (tasks != null){
            for (Iterator<TodoItem> iterator = tasks.iterator(); iterator.hasNext();){
                TodoItem existingTask = iterator.next();

                if(existingTask.time.equals(time)){
                    iterator.remove();
                    System.out.println("Task deleted successfully");
                    return;
                }
            }
        }
        System.out.println("Task not found for the specified input");
    }

    public void markAsCompleted (LocalDate date, LocalTime time){
        List <TodoItem> tasks = taskMap.get(date);

        if (tasks != null){
            for (int i = 0; i < tasks.size(); i++){
                TodoItem existingTask = tasks.get(i);

                if (existingTask.time.equals(time)){
                    existingTask.isCompleted = true;
                    System.out.println("Tas marked as completed");
                    return;
                }
            } 
        }
        System.out.println("Task not found for the specified input");
    }

    public void displayTodoList(){
        for (Map.Entry<LocalDate, List<TodoItem>> entry: taskMap.entrySet()){
            LocalDate date = entry.getKey();
            List<TodoItem> tasks = entry.getValue();

            System.out.println(date + ":");
            for (TodoItem task : tasks){
                System.out.print(task.time + " " + task.description + " ");
                if (task.isCompleted == false)
                {
                    System.out.println("Not completed");
                }
                else {
                    System.out.println("Completed");
                }
            }
        }
    }

    }
