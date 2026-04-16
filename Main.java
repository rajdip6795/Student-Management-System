import java.util.*;

class Student{
    private int id;
    private String name;
    private int age;

    Student(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public int getId(){
        return id;
    }

    public void update(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "\nID: " + id + "\nName: " + name + "\nAge: " + age + "\n";
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter ID: ");
                    int id =sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();

                    students.add(new Student(id, name, age));
                    System.out.println("\nStudent added successfully!\n");
                    break;
                
                case 2:
                    System.out.println("\n--- Student List ---");
                    if(students.isEmpty()){ 
                        System.out.println("No students found.\n");
                    } else {
                        for(Student s : students){
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nEnter ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean removed = students.removeIf(s -> s.getId() == deleteId);
                    
                     System.out.println(removed ?
                            "\nStudent deleted successfully!\n" :
                            "\nStudent not found.\n");
                    break;

                case 4:
                    System.out.print("\nEnter ID to search: ");
                    int searchId = sc.nextInt();

                    for (Student s : students) {
                        if (s.getId() == searchId) {
                            System.out.println("\nStudent Found:");
                            System.out.println(s);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("\nEnter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new age: ");
                            int newAge = sc.nextInt();

                            s.update(newName, newAge);
                            System.out.println("\nStudent updated successfully!\n");
                            break;
                        }
                    }
                    break;

                case 6:
                    sc.close();
                    System.out.println("\nExiting program... Thank you!\n");
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.\n");
            }
        }
    }
}
