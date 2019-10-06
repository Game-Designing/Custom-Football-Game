package p005cm.aptoide.p006pt.billing.customer;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.billing.Customer;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.customer.AccountCustomer */
public class AccountCustomer implements Customer {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8911617305880331327L, "cm/aptoide/pt/billing/customer/AccountCustomer", 11);
        $jacocoData = probes;
        return probes;
    }

    public AccountCustomer(AptoideAccountManager accountManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountManager = accountManager2;
        $jacocoInit[0] = true;
    }

    public Single<String> getId() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[1] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[2] = true;
        Single n = d.mo3678n();
        C2293b bVar = C2293b.f5379a;
        $jacocoInit[3] = true;
        Single<String> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) bVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6991a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (account.isLoggedIn()) {
            $jacocoInit[8] = true;
            Single a = Single.m734a(account.getId());
            $jacocoInit[9] = true;
            return a;
        }
        Single a2 = Single.m735a((Throwable) new IllegalStateException("User not logged in can not obtain customer id"));
        $jacocoInit[10] = true;
        return a2;
    }

    public C0120S<Boolean> isAuthenticated() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        C2292a aVar = C2292a.f5378a;
        $jacocoInit[5] = true;
        C0120S<Boolean> j = accountStatus.mo3669j(aVar);
        $jacocoInit[6] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m6992b(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(account.isLoggedIn());
        $jacocoInit[7] = true;
        return valueOf;
    }
}
