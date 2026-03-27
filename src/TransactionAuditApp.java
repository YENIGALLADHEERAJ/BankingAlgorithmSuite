import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ":$" + fee + " @ " + timestamp;
    }
}

public class TransactionAuditApp {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        System.out.println("Original Transactions: " + transactions);

        // Problem 1: Bubble Sort (By Fee Ascending)
        bubbleSort(transactions);
        System.out.println("After Bubble Sort (Fee): " + transactions);

        // Flag High-Fee Outliers
        System.out.print("High-fee outliers (> $50): ");
        boolean found = false;
        for(Transaction t : transactions) {
            if(t.fee > 50) { System.out.print(t.id + " "); found = true; }
        }
        if(!found) System.out.println("none");
    }

    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int swaps = 0;
        int passes = 0;
        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break; // Early exit optimization
        }
        System.out.println("// " + passes + " passes, " + swaps + " swaps");
    }
}