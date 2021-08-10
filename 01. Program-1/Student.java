import java.util.Scanner;

public class Student {

    private String USN;
    private String Name;
    private String Branch;
    private long Phone;

    // Constructor
    public Student(String USN, String Name, String Branch, long Phone) {
        this.USN = USN;
        this.Name = Name;
        this.Branch = Branch;
        this.Phone = Phone;
    }

    public void display() {
        System.out.println("USN is : " + this.USN);
        System.out.println("Name is : " + this.Name);
        System.out.println("Branch is : " + this.Branch);
        System.out.println("Phone Number is : " + this.Phone);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number Student : ");
        int n = sc.nextInt();
        sc.nextLine();
        Student S[] = new Student[n]; // Array of Objects

        System.out.println("\nEnter the details of student ");

        for (int i = 0; i < n; i++) {
            System.out.println("\n\t\t\tStudent " + (i + 1));
            System.out.println("Enter USN : ");
            String USN = sc.nextLine();
            System.out.println("Enter Name : ");
            String Name = sc.nextLine();
            System.out.println("Enter Branch :");
            String Branch = sc.nextLine();
            System.out.println("Enter Phone No : ");
            long Phone = sc.nextLong();
            sc.nextLine(); // Consume the new Line

            S[i] = new Student(USN, Name, Branch, Phone);

        }

        sc.close(); // Prevents memory leaks
        System.out.println("The details of students are : ");

        for (int i = 0; i < n; i++) {
            System.out.println("\n\t\t\tStudent " + (i + 1));
            S[i].display();

        }
    }

}
