import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== โปรแกรม To-Do List ===");
        System.out.println("คำสั่งที่ใช้ได้:");
        System.out.println("- add  : เพิ่มงานใหม่");
        System.out.println("- list : ดูรายการงานทั้งหมด");
        System.out.println("- remove <หมายเลข> : ลบงานตามหมายเลข");
        System.out.println("- exit : ออกจากโปรแกรม");
        System.out.println("=========================");
        
        while (true) {
            System.out.print("\nกรุณาใส่คำสั่ง: ");
            String input = scanner.nextLine().trim();
            
            if (input.equals("exit")) {
                System.out.println("ขอบคุณที่ใช้โปรแกรม To-Do List!");
                break;
            } else if (input.startsWith("add ")) {
                addTask(input);
            } else if (input.equals("list")) {
                listTasks();
            } else if (input.startsWith("remove ")) {
                removeTask(input);
            } else {
                System.out.println("คำสั่งไม่ถูกต้อง กรุณาลองใหม่");
            }
        }
        
        scanner.close();
    }
    
    private static void addTask(String input) {
        String task = input.substring(4).trim();
        if (task.isEmpty()) {
            System.out.println("กรุณาระบุงานที่ต้องการเพิ่ม");
            return;
        }
        tasks.add(task);
        System.out.println("เพิ่มงาน '" + task + "' เรียบร้อยแล้ว");
    }
    
    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("ไม่มีงานในรายการ");
            return;
        }
        
        System.out.println("รายการงานทั้งหมด:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    
    private static void removeTask(String input) {
        try {
            String numberStr = input.substring(7).trim();
            int taskNumber = Integer.parseInt(numberStr);
            
            if (taskNumber < 1 || taskNumber > tasks.size()) {
                System.out.println("หมายเลขงานไม่ถูกต้อง กรุณาระบุหมายเลข 1-" + tasks.size());
                return;
            }
            
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("ลบงาน '" + removedTask + "' เรียบร้อยแล้ว");
            
        } catch (NumberFormatException e) {
            System.out.println("กรุณาระบุหมายเลขงานที่ถูกต้อง");
        }
    }
}
