package p005cm.aptoide.p006pt.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Build.VERSION;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0117M;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.account.AndroidAccountProvider */
public class AndroidAccountProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String accountType;
    private final AccountManager androidAccountManager;
    private final C0126V scheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(101179135971633941L, "cm/aptoide/pt/account/AndroidAccountProvider", 17);
        $jacocoData = probes;
        return probes;
    }

    public AndroidAccountProvider(AccountManager androidAccountManager2, String accountType2, C0126V scheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.androidAccountManager = androidAccountManager2;
        this.accountType = accountType2;
        this.scheduler = scheduler2;
        $jacocoInit[0] = true;
    }

    public Single<Account> getAndroidAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        Single a = Single.m736a((Callable<Single<T>>) new C1416N<Single<T>>(this));
        C0126V v = this.scheduler;
        $jacocoInit[1] = true;
        Single<Account> a2 = a.mo3686a(v);
        $jacocoInit[2] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9602a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        Account[] accounts = this.androidAccountManager.getAccountsByType(this.accountType);
        if (accounts.length == 0) {
            $jacocoInit[14] = true;
            Single a = Single.m735a((Throwable) new IllegalStateException("No account found."));
            $jacocoInit[15] = true;
            return a;
        }
        Single a2 = Single.m734a(accounts[0]);
        $jacocoInit[16] = true;
        return a2;
    }

    public Single<Account> createAndroidAccount(String email) {
        boolean[] $jacocoInit = $jacocoInit();
        Account androidAccount = new Account(email, this.accountType);
        try {
            $jacocoInit[3] = true;
            try {
                this.androidAccountManager.addAccountExplicitly(androidAccount, null, null);
                Single<Account> a = Single.m734a(androidAccount);
                $jacocoInit[6] = true;
                return a;
            } catch (SecurityException e) {
                e = e;
                $jacocoInit[4] = true;
                Single<Account> a2 = Single.m735a((Throwable) e);
                $jacocoInit[5] = true;
                return a2;
            }
        } catch (SecurityException e2) {
            e = e2;
            $jacocoInit[4] = true;
            Single<Account> a22 = Single.m735a((Throwable) e);
            $jacocoInit[5] = true;
            return a22;
        }
    }

    public C0117M removeAndroidAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = getAndroidAccount().mo3695b((C0129b<? super T>) new C1417O<Object>(this));
        $jacocoInit[7] = true;
        C0117M b2 = b.mo3692b();
        $jacocoInit[8] = true;
        C0117M d = b2.mo3602d();
        $jacocoInit[9] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9603a(Account androidAccount) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 22) {
            $jacocoInit[10] = true;
            this.androidAccountManager.removeAccountExplicitly(androidAccount);
            $jacocoInit[11] = true;
        } else {
            this.androidAccountManager.removeAccount(androidAccount, null, null);
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
    }
}
