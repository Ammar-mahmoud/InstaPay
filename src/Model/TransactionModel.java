package Model;
import java.util.Date;
import java.util.Vector;

public class TransactionModel {
    private int transactionID;
    private Date date;
    private String source;
    private String destination;

    public TransactionModel(int transactionID, Date date, String source, String destination) {
        this.transactionID = transactionID;
        this.date = date;
        this.source = source;
        this.destination = destination;
    }

    public void saveTransaction() {
        // Save the transaction to the vector
        TransactionModel.transactionVector.add(this);
    }

    public static Vector<TransactionModel> transactionVector = new Vector<>();

    static {
        TransactionModel transaction1 = new TransactionModel(1, new Date(), "01014491245", "01234567890");
        transaction1.saveTransaction();

        TransactionModel transaction2 = new TransactionModel(2, new Date(), "01234567890", "01014491245");
        transaction2.saveTransaction();

        TransactionModel transaction3 = new TransactionModel(3, new Date(), "01122334455", "01987654321");
        transaction3.saveTransaction();

        TransactionModel transaction4 = new TransactionModel(4, new Date(), "01555555555", "01777777777");
        transaction4.saveTransaction();

        TransactionModel transaction5 = new TransactionModel(5, new Date(), "01888888888", "01666666666");
        transaction5.saveTransaction();
    }

}
