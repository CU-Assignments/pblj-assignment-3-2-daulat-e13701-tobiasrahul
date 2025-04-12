// ================= HARD LEVEL =================
// Spring + Hibernate with Transaction Management

// Account.java
import javax.persistence.*;

@Entity
public class Account {
    @Id
    private int accountId;
    private double balance;

    // Getters and Setters
}

// Transaction.java
import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private Date timestamp;

    // Getters and Setters
}