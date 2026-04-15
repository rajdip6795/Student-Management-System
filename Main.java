import java.util.*;

class Student{
    int id;
    String name;
    int age;

    Student(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return id+" "+name+" "+age;
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1.Add 2.View 3.Delete 4.Exit");
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
                    break;
                
                case 2:
                    for(Student s : students){
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.println("Enter ID to delete: ");
                    int deleted = sc.nextInt();
                    students.removeIf(s -> s.id == deleted);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
