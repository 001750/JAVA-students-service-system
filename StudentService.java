import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            if (findStudent(id) != null) {
                System.out.println("That ID already exists.");
                return;
            }

            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter department: ");
            String department = sc.nextLine().trim();
            System.out.print("Enter CGPA (0-10): ");
            double cgpa = Double.parseDouble(sc.nextLine().trim());

            if (name.isEmpty() || department.isEmpty()) {
                System.out.println("Name and department cannot be empty.");
                return;
            }
            if (cgpa < 0 || cgpa > 10) {
                System.out.println("CGPA must be between 0 and 10.");
                return;
            }

            students.add(new Student(id, name, department, cgpa));
            System.out.println("Student added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric ID and CGPA.");
        }
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    public void searchStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID to search: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Student s = findStudent(id);
            if (s == null) {
                System.out.println("Student not found.");
            } else {
                System.out.println("Student found:");
                s.display();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric ID.");
        }
    }

    public void updateStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID to update: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Student s = findStudent(id);

            if (s == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.println("1. Update name");
            System.out.println("2. Update department");
            System.out.println("3. Update CGPA");
            System.out.print("Choose what to update: ");
            int option = Integer.parseInt(sc.nextLine().trim());

            switch (option) {
                case 1:
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        return;
                    }
                    s.setName(name);
                    break;
                case 2:
                    System.out.print("Enter new department: ");
                    String department = sc.nextLine().trim();
                    if (department.isEmpty()) {
                        System.out.println("Department cannot be empty.");
                        return;
                    }
                    s.setDepartment(department);
                    break;
                case 3:
                    System.out.print("Enter new CGPA (0-10): ");
                    double cgpa = Double.parseDouble(sc.nextLine().trim());
                    if (cgpa < 0 || cgpa > 10) {
                        System.out.println("CGPA must be between 0 and 10.");
                        return;
                    }
                    s.setCgpa(cgpa);
                    break;
                default:
                    System.out.println("Invalid update option.");
                    return;
            }
            System.out.println("Student updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        }
    }

    public void deleteStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Iterator<Student> iterator = students.iterator();

            while (iterator.hasNext()) {
                Student s = iterator.next();
                if (s.getId() == id) {
                    iterator.remove();
                    System.out.println("Student deleted successfully!");
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric ID.");
        }
    }

    private Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
