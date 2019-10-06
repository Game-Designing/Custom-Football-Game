package p005cm.aptoide.p006pt.billing.transaction;

import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.transaction.TransactionService */
public interface TransactionService {
    Single<Transaction> createTransaction(String str, String str2, String str3, String str4);

    Single<Transaction> createTransaction(String str, String str2, String str3, String str4, String str5);

    Single<Transaction> getTransaction(String str, String str2);
}
