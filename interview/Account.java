import java.util.Date;

class Account {
    private String name;
    private String number;
    private double balance;
    private Date dateCreated;
    private Date lastUpDated;
    protected String type;
    public double minBalance;


    public Account(String name, double balance, String number) {
        this.name = name;
        this.balance = balance;
        this.number = number;
    }

    public Boolean deposit(double amount) {
        double tmp = balance;
        tmp += amount;
        balance = tmp;
        return true;
    }

    public Boolean withdraw(double amount) {
        double tmp = getBalance();
        if (tmp - amount < minBalance) {
            System.out.println("Minimum balance exceeded");
            return false;
        } else {
            tmp -= amount;
            setBalance(tmp);
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public void setlastUpDated(Date lastUpDated) {
        this.lastUpDated = lastUpDated;
    }

    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account [name=" + name + ", number=" + number + ", balance=" + balance + ", dateCreated=" + dateCreated
                + ", type=" + type + ",date last updated="+ lastUpDated +"]";
    }
}

class CurrentAccount extends Account {

    public static double openBalance = 1000;
    public static double minBalance = 500;

    public CurrentAccount(String name, double balance, String number) {
        super(name, balance, number);
        this.type = "Current";
    }

    
}

class CheckingAccount extends Account {
    public static double openBalance = 1000;
    public static double minBalance = 500;

    public CheckingAccount(String name, double balance, String number) {
        super(name, balance, number);
        this.type = "Checking";
        super.minBalance = minBalance;
    }

    
}

class SavingsAccount extends Account {
    public static double openBalance = 1000;
    public static double minBalance = 500;

    public SavingsAccount(String name, double balance, String number) {
        super(name, balance, number);
        this.type = "Savings";
        super.minBalance = minBalance;
    }

    
}

class SalaryAccount extends Account {
    public static double openBalance = 1000;
    public static double minBalance = 500;

    public SalaryAccount(String name, double balance, String number) {
        super(name, balance, number);
        this.type = "Salary";
        super.minBalance = minBalance;
    }


}