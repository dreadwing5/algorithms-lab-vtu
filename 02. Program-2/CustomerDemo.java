import java.util.Scanner;
import java.util.StringTokenizer;

class Customer {
    String name, date_of_birth;

    void readData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Customer Name: ");
        name = sc.next();
        System.out.println("Enter date of Birth in dd/mm/yyyy format");
        date_of_birth = sc.next();
        sc.close();

    }

    void display() {
        StringTokenizer st = new StringTokenizer(date_of_birth, "/");
        System.out.println("The details of the customers are: ");
        System.out.print("<" + name);
        while (st.hasMoreTokens())
            System.out.print("," + st.nextToken());
        System.out.println(">");
    }
}

public class CustomerDemo {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.readData();
        c.display();
    }
}