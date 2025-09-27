import java.util.*;

class Account {
    int accNo;
    String name, email, phone;
    double balance;

    Account(int accNo, String name, double balance, String email, String phone) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }

    void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    void withdraw(double amt) {
        if (amt > 0 && amt <= balance) balance -= amt;
    }

    void updateContact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    void display() {
        System.out.println("Acc No: " + accNo + "\nName: " + name + "\nBalance: " + balance + "\nEmail: " + email + "\nPhone: " + phone);
    }
}

 class BankingApp {
    static Scanner sc = new Scanner(System.in);
    static Account[] accounts = new Account[100];
    static int count = 0, nextAccNo = 1001;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.View 5.Update Contact 6.Exit");
            int ch = sc.nextInt(); sc.nextLine();
            if (ch == 6) break;

            System.out.print("Enter Account No: ");
            int accNo = (ch == 1) ? nextAccNo : sc.nextInt(); sc.nextLine();
            Account a = find(accNo);

            switch (ch) {
                case 1:
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Deposit: "); double b = sc.nextDouble(); sc.nextLine();
                    System.out.print("Email: "); String e = sc.nextLine();
                    System.out.print("Phone: "); String p = sc.nextLine();
                    accounts[count++] = new Account(accNo, n, b, e, p);
                    System.out.println("Account created: " + accNo);
                    nextAccNo++;
                    break;
                case 2:
                    if (a != null) {
                        System.out.print("Amount: ");
                        a.deposit(sc.nextDouble()); sc.nextLine();
                    } else System.out.println("Not found");
                    break;
                case 3:
                    if (a != null) {
                        System.out.print("Amount: ");
                        a.withdraw(sc.nextDouble()); sc.nextLine();
                    } else System.out.println("Not found");
                    break;
                case 4:
                    if (a != null) a.display(); else System.out.println("Not found");
                    break;
                case 5:
                    if (a != null) {
                        System.out.print("New Email: "); String em = sc.nextLine();
                        System.out.print("New Phone: "); String ph = sc.nextLine();
                        a.updateContact(em, ph);
                    } else System.out.println("Not found");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static Account find(int accNo) {
        for (int i = 0; i < count; i++)
            if (accounts[i].accNo == accNo) return accounts[i];
        return null;
    }
}
