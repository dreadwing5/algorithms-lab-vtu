import java.util.*;

public class ExceptionHandling {

    public static void main(String[] args) {
        int a, b, result;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the integer a and b");
        a = s.nextInt();
        b = s.nextInt();
        try {
            result = a / b; // division by zero
            System.out.println("The result after division is " + result); // execute

        } catch (Exception e) {
            System.out.println("The result is invalid");
        }

        s.close();

    }

}
