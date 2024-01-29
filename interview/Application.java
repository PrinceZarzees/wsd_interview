import java.util.ArrayList;
import java.util.List;

class BankApplication {

    List<Account> accounts;

    public BankApplication() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void printAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public Account check_existed_already(String number)
    {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }

    public Account getAccount(String name, String number) {
        for (Account account : accounts) {
            if (account.getName().equals(name) && account.getNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }





    
}
