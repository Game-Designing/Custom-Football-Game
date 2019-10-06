package p005cm.aptoide.p006pt.account;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AccountPersistence;
import p005cm.aptoide.accountmanager.AdultContent;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.MatureContentPersistence */
public class MatureContentPersistence implements AccountPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdultContent adultContent;
    private final AccountPersistence wrappedAccountPersistence;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5960898519698864502L, "cm/aptoide/pt/account/MatureContentPersistence", 15);
        $jacocoData = probes;
        return probes;
    }

    public MatureContentPersistence(AccountPersistence persistence, AdultContent adultContent2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.wrappedAccountPersistence = persistence;
        this.adultContent = adultContent2;
        $jacocoInit[0] = true;
    }

    public C0117M saveAccount(Account account) {
        C0117M saveAdultSwitch;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        if (account.isAdultContentEnabled()) {
            saveAdultSwitch = this.adultContent.enable(account.isLoggedIn());
            $jacocoInit[2] = true;
        } else {
            AdultContent adultContent2 = this.adultContent;
            $jacocoInit[3] = true;
            saveAdultSwitch = adultContent2.disable(account.isLoggedIn());
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
        C0117M saveAccount = this.wrappedAccountPersistence.saveAccount(account);
        $jacocoInit[6] = true;
        C0117M a = saveAccount.mo3580a(saveAdultSwitch);
        C1433ca caVar = new C1433ca(saveAdultSwitch);
        $jacocoInit[7] = true;
        C0117M b = a.mo3596b((C0132p<? super Throwable, ? extends C0117M>) caVar);
        $jacocoInit[8] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m6221a(C0117M saveAdultSwitch, Throwable err) {
        $jacocoInit()[14] = true;
        return saveAdultSwitch;
    }

    public Single<Account> getAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        Single account = this.wrappedAccountPersistence.getAccount();
        C1431ba baVar = new C1431ba(this);
        $jacocoInit[9] = true;
        Single<Account> d = account.mo3698d(baVar);
        $jacocoInit[10] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Account mo9630a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        MatureContentAccount matureContentAccount = new MatureContentAccount(account, this.adultContent);
        $jacocoInit[13] = true;
        return matureContentAccount;
    }

    public C0117M removeAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAccount = this.wrappedAccountPersistence.removeAccount();
        AdultContent adultContent2 = this.adultContent;
        $jacocoInit[11] = true;
        C0117M a = removeAccount.mo3580a(adultContent2.disable(false));
        $jacocoInit[12] = true;
        return a;
    }
}
