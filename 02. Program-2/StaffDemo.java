import java.util.Scanner;

class Staff {
    String name, phone;
    String staffid;
    float salary;

    Staff(String S, String N, String P, float Sa) {
        staffid = S;
        phone = P;
        salary = Sa;
        name = N;
    }

    void display() {
        System.out.println("Staff ID: " + staffid);
        System.out.println("Staff Phone number: " + phone);
        System.out.println("Staff Salary: " + salary);
        System.out.println("Staff Name: " + name);

    }
}

class Teaching extends Staff {
    String domain;
    String publications;

    public Teaching(String S, String N, String P, float Sa, String d, String p) {
        super(S, N, P, Sa);
        domain = d;
        publications = p;
    }

    public void display() {
        super.display();
        System.out.println("Domain: " + domain);
        System.out.println("Publication: " + publications);
    }
}

class Technical extends Staff {
    String skills;

    public Technical(String S, String N, String P, float Sa, String Sk) {
        super(S, N, P, Sa);
        skills = Sk;
    }

    public void display() {
        super.display();
        System.out.println("Skills: " + skills);

    }
}

class Contract extends Staff {
    float period;

    public Contract(String S, String N, String P, float Sa, float p) {
        super(S, N, P, Sa);
        period = p;
    }

    public void display() {
        super.display();
        System.out.println("Period: " + period);
    }
}

public class StaffDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String staffid[] = new String[3];
        String name[] = new String[3];
        String phone[] = new String[3];
        float salary[] = new float[3];
        String domain[] = new String[3];
        String publications[] = new String[3];
        System.out.println("Enter the Details for teachers");
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Staff ID : ");
            staffid[i] = s.next();
            System.out.println("Enter Name: ");
            name[i] = s.next();

            System.out.println("Enter Phone: ");
            phone[i] = s.next();
            System.out.println("Enter Salary: ");
            salary[i] = s.nextFloat();

            System.out.println("Enter Domain: ");
            domain[i] = s.next();

            System.out.println("Enter Publications: ");
            publications[i] = s.next();
        }
        Teaching T1[] = new Teaching[3];
        for (int k = 0; k < 3; k++) {
            T1[k] = new Teaching(staffid[k], name[k], phone[k], salary[k], domain[k], publications[k]);
            T1[k].display();
        }
        Scanner s2 = new Scanner(System.in);
        String staffidT[] = new String[3];
        String nameT[] = new String[3];
        String phoneT[] = new String[3];
        float salaryT[] = new float[3];
        String skills[] = new String[3];
        System.out.println("Enter the Details for Technical: ");
        for (int j = 0; j < 3; j++) {
            System.out.println("Enter Staff ID: ");
            staffidT[j] = s2.next();
            System.out.println("Enter Name: ");
            nameT[j] = s2.next();
            System.out.println("Enter Phone number: ");
            phoneT[j] = s2.next();

            System.out.println("Enter Salary: ");
            salaryT[j] = s2.nextFloat();
            System.out.println("Enter Skills: ");
            skills[j] = s2.next();

        }

        Technical Tel[] = new Technical[3];
        for (int x = 0; x < 3; x++) {
            Tel[x] = new Technical(staffid[x], name[x], phone[x], salary[x], skills[x]);
            Tel[x].display();
        }

        Scanner s3 = new Scanner(System.in);
        String staffidC[] = new String[3];
        String nameC[] = new String[3];
        String phoneC[] = new String[3];
        float salaryC[] = new float[3];
        float period[] = new float[3];
        System.out.println("Enter the Details for Contract: ");
        for (int k = 0; k < 3; k++) {
            System.out.println("Enter Staff ID: ");
            staffidC[k] = s3.next();
            System.out.println("Enter Name: ");
            nameC[k] = s3.next();
            System.out.println("Enter Phone number: ");
            phoneC[k] = s3.next();

            System.out.println("Enter Salary: ");
            salaryC[k] = s3.nextFloat();
            System.out.println("Enter Period: ");
            period[k] = s3.nextFloat();
        }
        Contract C1[] = new Contract[3];
        for (int y = 0; y < 3; y++) {
            C1[y] = new Contract(staffidC[y], nameC[y], phoneC[y], salaryC[y], period[y]);
            C1[y].display();
        }
        s.close();
        s2.close();
        s3.close();
    }
}
