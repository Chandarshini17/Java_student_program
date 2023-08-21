import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getGrade(){
        return grade;
    }
    
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
    
}



class Main {
    public static void main(String[] args) {
        List<Student> stu = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter student details or 'exit' to quit:");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Grade: ");
            String grade = scanner.nextLine();

            stu.add(new Student(name, age, grade));
        }

        System.out.println("Student Details:");
        for (Student details : stu) {
            System.out.println(details);
        }
    }
}

