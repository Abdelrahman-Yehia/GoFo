package cf.gofo;

/**
 * E-wallet class for players and playground owners that holds their balance and enables online payments
 * @author 20180142
 */
public class eWallet {
    /**
     * E-wallet balance
     */
    private float balance = 0;
    /**
     * E-wallet Account Number
     */
    private String accountNumber;
    /**
     * E-wallet password
     */
    private String password;

    /**
     * Changes E-wallet account number
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Changes E-wallet password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return E-wallet account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     * @return E-wallet Password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return E-wallet balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * adds balance
     * @param amount amount to add
     */
    public void addBalance(float amount){
        balance+=amount;
    }

    /**
     * withdraw from balance
     * @param amount amount to withdraw
     * @return false if Insufficient balance available
     */
    public boolean removeBalance(float amount){
        if(balance>=amount){
            balance-=amount;
            return true;
        }
        else{
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}
