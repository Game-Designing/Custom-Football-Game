package p005cm.aptoide.p006pt.billing;

/* renamed from: cm.aptoide.pt.billing.BillingSyncScheduler */
public interface BillingSyncScheduler {
    void cancelAuthorizationSync(String str);

    void stopSyncs();

    void syncAuthorization(String str);

    void syncTransaction(String str);
}
