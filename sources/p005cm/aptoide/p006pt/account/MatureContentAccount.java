package p005cm.aptoide.p006pt.account;

import java.util.Date;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.Account.Access;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.accountmanager.Store;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p401g.C14959b;

/* renamed from: cm.aptoide.pt.account.MatureContentAccount */
public class MatureContentAccount implements Account {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdultContent adultContent;
    private final Account wrappedAccount;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4724297956909406304L, "cm/aptoide/pt/account/MatureContentAccount", 21);
        $jacocoData = probes;
        return probes;
    }

    public MatureContentAccount(Account wrappedAccount2, AdultContent adultContent2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.wrappedAccount = wrappedAccount2;
        this.adultContent = adultContent2;
        $jacocoInit[0] = true;
    }

    public List<Store> getSubscribedStores() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Store> subscribedStores = this.wrappedAccount.getSubscribedStores();
        $jacocoInit[1] = true;
        return subscribedStores;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String id = this.wrappedAccount.getId();
        $jacocoInit[2] = true;
        return id;
    }

    public String getNickname() {
        boolean[] $jacocoInit = $jacocoInit();
        String nickname = this.wrappedAccount.getNickname();
        $jacocoInit[3] = true;
        return nickname;
    }

    public String getAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        String avatar = this.wrappedAccount.getAvatar();
        $jacocoInit[4] = true;
        return avatar;
    }

    public boolean isAdultContentEnabled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S enabled = this.adultContent.enabled();
        $jacocoInit[5] = true;
        C0120S d = enabled.mo3647d();
        $jacocoInit[6] = true;
        Single n = d.mo3678n();
        $jacocoInit[7] = true;
        C14959b a = n.mo3689a();
        $jacocoInit[8] = true;
        boolean booleanValue = ((Boolean) a.mo46175a()).booleanValue();
        $jacocoInit[9] = true;
        return booleanValue;
    }

    public Access getAccess() {
        boolean[] $jacocoInit = $jacocoInit();
        Access access = this.wrappedAccount.getAccess();
        $jacocoInit[10] = true;
        return access;
    }

    public boolean isAccessConfirmed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isAccessConfirmed = this.wrappedAccount.isAccessConfirmed();
        $jacocoInit[11] = true;
        return isAccessConfirmed;
    }

    public boolean isLoggedIn() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isLoggedIn = this.wrappedAccount.isLoggedIn();
        $jacocoInit[12] = true;
        return isLoggedIn;
    }

    public String getEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        String email = this.wrappedAccount.getEmail();
        $jacocoInit[13] = true;
        return email;
    }

    public Store getStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = this.wrappedAccount.getStore();
        $jacocoInit[14] = true;
        return store;
    }

    public boolean hasStore() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasStore = this.wrappedAccount.hasStore();
        $jacocoInit[15] = true;
        return hasStore;
    }

    public boolean isPublicUser() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isPublicUser = this.wrappedAccount.isPublicUser();
        $jacocoInit[16] = true;
        return isPublicUser;
    }

    public boolean isPublicStore() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isPublicStore = this.wrappedAccount.isPublicStore();
        $jacocoInit[17] = true;
        return isPublicStore;
    }

    public boolean acceptedTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean acceptedTermsAndConditions = this.wrappedAccount.acceptedTermsAndConditions();
        $jacocoInit[18] = true;
        return acceptedTermsAndConditions;
    }

    public boolean acceptedPrivacyPolicy() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean acceptedPrivacyPolicy = this.wrappedAccount.acceptedPrivacyPolicy();
        $jacocoInit[19] = true;
        return acceptedPrivacyPolicy;
    }

    public Date getBirthDate() {
        boolean[] $jacocoInit = $jacocoInit();
        Date birthDate = this.wrappedAccount.getBirthDate();
        $jacocoInit[20] = true;
        return birthDate;
    }
}
