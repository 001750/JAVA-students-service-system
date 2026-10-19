import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    service.addStudent(sc);
                    break;
                case 2:
                    service.viewStudents();
                    break;
                case 3:
                    service.searchStudent(sc);
                    break;
                case 4:
                    service.updateStudent(sc);
                    break;
                case 5:
                    service.deleteStudent(sc);
                    break;
                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Select 1 to 6.");
            }
        }
    }
}
