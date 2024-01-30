import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankApplication bank = new BankApplication();
        Scanner sc = new Scanner(System.in);

        CurrentAccount.openBalance = 1000;
        SalaryAccount.openBalance = 1000;
        SavingsAccount.openBalance = 1000;
        CheckingAccount.openBalance = 1000;
        CurrentAccount.minBalance = 500;
        SalaryAccount.minBalance = 500;
        SavingsAccount.minBalance = 500;
        CheckingAccount.minBalance = 500;

        while (true) {
            int choice;
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for an account");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your account name: ");
                    String name = sc.next();
                    String number;

                    Account account = null;
                    while (true) {
                        number = String.valueOf((int) (Math.random() * 1000000000));
                        account = bank.check_existed_already(number);
                        if (account == null) {
                            break;
                        }

                    }
                    System.out.print("Enter your account type(savings,current,salary,checking): ");
                    String type = sc.next();
                    System.out.print("Enter your account balance: ");
                    double balance = sc.nextDouble();

                    if (type.equals("savings")) {
                        if (balance < SavingsAccount.openBalance) {
                            System.out.println("Minimum balance for savings account is " + SavingsAccount.openBalance);
                            break;
                        }
                        account = new SavingsAccount(name, balance, number);

                    } else if (type.equals("current")) {
                        if (balance < CurrentAccount.openBalance) {
                            System.out.println("Minimum balance for current account is " + CurrentAccount.openBalance);
                            break;
                        }
                        account = new CurrentAccount(name, balance, number);

                    } else if (type.equals("salary")) {
                        if (balance < SalaryAccount.openBalance) {
                            System.out.println("Minimum balance for salary account is " + SalaryAccount.openBalance);
                            break;
                        }

                        account = new SalaryAccount(name, balance, number);

                    } else if (type.equals("checking")) {
                        if (balance < CheckingAccount.openBalance) {
                            System.out
                                    .println("Minimum balance for checking account is " + CheckingAccount.openBalance);
                            break;
                        }
                        account = new CheckingAccount(name, balance, number);

                    } else {
                        System.out.println("Invalid account type");
                        break;
                    }

                    account.setDateCreated(new Date());
                    account.setlastUpDated(new Date());
                    bank.addAccount(account);
                    System.out.println("Account created successfully");
                    break;
                case 2:
                    // show all accounts
                    bank.printAccounts();
                    break;
                case 3:
                    System.out.print("Enter your account name: ");
                    name = sc.next();
                    System.out.print("Enter your account number: ");
                    number = sc.next();

                    account = bank.getAccount(name, number);
                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter your new account name: ");
                    name = sc.next();
                    account.setName(name);

                    account.setlastUpDated(new Date());
                    System.out.println("Account updated successfully");
                    break;
                case 4:
                    System.out.print("Enter your account name: ");
                    name = sc.next();
                    System.out.print("Enter your account number: ");
                    number = sc.next();

                    account = bank.getAccount(name, number);
                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }
                    bank.deleteAccount(account);
                    System.out.println("Account deleted successfully");
                    break;
                case 5:
                    System.out.print("Enter your account name: ");
                    name = sc.next();
                    System.out.print("Enter your account number: ");
                    number = sc.next();
                    account = bank.getAccount(name, number);
                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }
                    System.out.print("Enter the amount to be deposited: ");
                    double amount = sc.nextDouble();
                    if (account.deposit(amount)) {
                        account.setlastUpDated(new Date());
                        System.out.println("Amount " + amount + " deposited successfully");
                    }
                    System.out.println(account);
                    break;
                case 6:
                    System.out.print("Enter your account name: ");
                    name = sc.next();
                    System.out.print("Enter your account number: ");
                    number = sc.next();
                    account = bank.getAccount(name, number);
                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }
                    System.out.print("Enter the amount to be withdrawn: ");
                    amount = sc.nextDouble();
                    if (account.withdraw(amount)) {
                        account.setlastUpDated(new Date());
                        System.out.println("Amount " + amount + " withdrawn successfully");
                    }
                    System.out.println(account);
                    break;
                case 7:
                    System.out.print("Enter your account name: ");
                    name = sc.next();
                    System.out.print("Enter your account number: ");
                    number = sc.next();
                    account = bank.getAccount(name, number);
                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }
                    System.out.println(account);
                    break;
                case 8:
                    sc.close();
                    System.exit(0);
                    break;

            }
        }

    }
}
