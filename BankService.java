// BankService.java
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.*;

public class BankService {

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Account from = session.get(Account.class, fromId);
        Account to = session.get(Account.class, toId);

        if (from.getBalance() < amount) throw new RuntimeException("Insufficient funds");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        Transaction txn = new Transaction();
        txn.setFromAccountId(fromId);
        txn.setToAccountId(toId);
        txn.setAmount(amount);
        txn.setTimestamp(new Date());

        session.save(txn);
        session.update(from);
        session.update(to);
    }
}
