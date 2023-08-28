import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_details.txt"))) {
            for (Student student : stu) {
                writer.write(student.getName() + "," + student.getAge() + "," + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Student details saved to 'student_details.txt'");

        try (BufferedReader reader = new BufferedReader(new FileReader("student_details.txt"))) {
            System.out.println("\nReading and displaying student details:");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String grade = parts[2];
                    Student student = new Student(name, age, grade);
                    System.out.println(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
