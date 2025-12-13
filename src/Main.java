import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String address;

    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void updateAddress(String newAddress) {
        this.address = newAddress;
        System.out.println(this.name + " Адрес обновлен на: " + newAddress);
    }
}

public class Account {
    private String accountNumber;
    private double balance;
    private Customer accountHolder;

    public Account(String accountNumber, Customer accountHolder, double initialBalance) { // Порядок аргументов изменен
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Депозит на счет " + accountNumber + ". Новый баланс: " + balance);
        }
    }

}
public class Bank {
    private String name; //
    private List<Account> accounts;
    private List<Customer> customers;
    private int nextAccountNumber = 1000;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        System.out.println("Клиент" + customer.getName() + "добавлен в банк");
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Account openAccount(Customer customer, double initialDeposit) {
        String newNumber = String.valueOf(nextAccountNumber++);
        Account newAccount = new Account(newNumber, customer, initialDeposit);
        this.accounts.add(newAccount);
        System.out.println("Счет №" + newNumber + " открыт для клиента " + customer.getName() + ".");
        return newAccount;
    }

    public String getName() {
        return name;
    }
}
void main() {
    Bank myBank = new Bank("Банк");

    Customer c1 = new Customer(101, "Uali Kylyshbek", "Астана, ул. Е-36");
    Customer c2 = new Customer(102, "Sultan Sansyzbaev", "Астана, Проспект Туран 65а");

    Account acc1 = myBank.openAccount(c1, 15000.00);
    Account acc2 = myBank.openAccount(c2, 3500.50);

    System.out.println("Баланс " + c1.getName() + " по счету " + acc1.getAccountNumber() + ": " + acc1.getBalance());
    c2.updateAddress("Шоссе Коргалжын 2а");

    double balance1 = acc1.getBalance();
    double balance2 = acc2.getBalance();

    if (balance1 > balance2) {
        System.out.println("У " + c1.getName() + " больше денег");
    } else if (balance2 > balance1) {
        System.out.println("У " + c2.getName() + " больше денег");
    } else {
        System.out.println("Балансы равны");
    }
}
