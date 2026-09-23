public abstract class Bank {
    int balance;

    void Bank(int balance)
    {
        this.balance = balance;
    }

    public int getBalance()
    {
        return balance;
    }

    public abstract void withdraw();
}

