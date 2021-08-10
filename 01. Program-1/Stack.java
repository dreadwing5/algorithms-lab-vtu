import java.util.Scanner;

public class Stack {

    private int top = -1;
    private int maxSize;
    private int stackArray[];

    public void createStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
    }

    public void push(int ele) {
        if (this.top == this.maxSize - 1) {
            System.out.println("Stack is Full!");
            return;
        }

        this.stackArray[++this.top] = ele;
    }

    public int pop() {

        if (this.top == -1) {
            System.out.println("Stack is Empty");
            return -1;

        }
        return this.stackArray[this.top--];
    }

    public void displayStack() {

        if (this.top == -1) {
            System.out.println("Stack is Empty");
            return;

        }

        for (int i = this.top; i > -1; i--) {

            System.out.printf("%d\t", this.stackArray[i]);
        }
        System.out.printf("\n\n");
    }

    public static void main(String[] args) {

        Stack st = new Stack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("1.Create Stack\n2.Push\n3.Pop\n4.Display\n5.Exit\n");
            System.out.println("Enter Your Choice:");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter The Size of Stack :");
                    int size = sc.nextInt();
                    st.createStack(size);
                    break;

                case 2:
                    System.out.println("Enter The Element To be Pushed : ");
                    int x = sc.nextInt();
                    st.push(x);
                    break;

                case 3:
                    int ele = st.pop();
                    if (ele != -1)
                        System.out.println("Popped Element is : " + ele);
                    break;

                case 4:
                    System.out.println("The Content of Stack is : ");
                    st.displayStack();
                    break;

                case 5:
                    sc.close();
                    System.exit(0);

                default:
                    System.exit(0);
            }
        }

    }

}
