import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class TodoListApp extends ToDoList {
    public static void main(String[] args) {

        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        
        

        while (true){
            System.out.println ("1. Add task");
            System.out.println ("2. Edit task");
            System.out.println ("3. Delete task");
            System.out.println ("4. Edit time");
            System.out.println ("5. Mark as complete");
            System.out.println ("6. Display list");
            System.out.println ("7. Exit");

            System.out.print ("Enter your choice: ");
            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    System.out.print("Enter task description: ");
                    scanner.nextLine();
                    String description = scanner.nextLine();
                    LocalDate date = getDateInput();
                    LocalTime time = getTimeInptu();
                    todoList.declare(time, description, comp);
                    TodoItem task = new TodoItem(description, comp, time);
                    todoList.AddTask(date, task);
                    break;

                case 2:
                    System.out.println("You need to declare date(month, day), hour and minute for which task you wanna alter ");
                    date = getDateInput();
                    time = getTimeInptu();
                    System.out.print("What would be new task for specified date?: ");
                    scanner.nextLine();
                    description = scanner.nextLine();
                    todoList.editTask(date, time, description);
                    break;

                case 3:
                    System.out.println("which task do you wanna delete?");
                    date = getDateInput();
                    time = getTimeInptu();
                    todoList.deleteTask(date, time);
                    break;

                case 4:
                    System.out.print("which task time do  you wanna alter?: ");
                    date = getDateInput();
                    time = getTimeInptu();
                    System.out.print("Enter new time for a task: ");
                    LocalTime newtime = getTimeInptu();
                    todoList.EditTime(date, time, newtime);
                    break;

                case 5:
                    System.out.print("which task did you complete?:");
                    date = getDateInput();
                    time = getTimeInptu();
                    todoList.markAsCompleted(date, time);
                    break;

                case 6:
                    todoList.displayTodoList();
                    break;

                case 7:
                    System.out.print ("Have a nice day :)");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option");
                    break;
            }  
        }
         
    }

    private static LocalDate getDateInput(){
        System.out.print("Enter month, day:");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        return LocalDate.of(LocalDate.now().getYear(), month, day);
    }

    private static LocalTime getTimeInptu(){
        System.out.print("Enter hours, minutes:");
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        return LocalTime.of(hours, minutes);
    }
}