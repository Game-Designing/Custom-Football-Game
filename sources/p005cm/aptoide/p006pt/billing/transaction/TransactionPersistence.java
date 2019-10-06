package p005cm.aptoide.p006pt.billing.transaction;

import java.util.List;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.transaction.TransactionPersistence */
public interface TransactionPersistence {
    Single<List<Transaction>> getOtherTransactions(String str, String str2, String str3);

    C0120S<Transaction> getTransaction(String str, String str2);

    C0117M removeTransaction(String str);

    C0117M saveTransaction(Transaction transaction);
}
