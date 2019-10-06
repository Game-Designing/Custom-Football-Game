package p005cm.aptoide.accountmanager;

import android.text.TextUtils;
import java.util.Date;
import java.util.List;
import p005cm.aptoide.accountmanager.Account.Access;

/* renamed from: cm.aptoide.accountmanager.AptoideAccount */
public final class AptoideAccount implements Account {
    private final Access access;
    private final boolean accessConfirmed;
    private final boolean adultContentEnabled;
    private final String avatar;
    private final Date dateOfBirth;
    private final String email;

    /* renamed from: id */
    private final String f4202id;
    private final String nickname;
    private final boolean privacyPolicy;
    private final Store store;
    private final List<Store> subscribedStores;
    private final boolean termsAndConditions;

    public AptoideAccount(String id, String email2, String nickname2, String avatar2, Store store2, boolean adultContentEnabled2, Access access2, boolean accessConfirmed2, List<Store> subscribedStores2, boolean privacyPolicy2, boolean termsAndConditions2, Date dateOfBirth2) {
        this.f4202id = id;
        this.email = email2;
        this.nickname = nickname2;
        this.avatar = avatar2;
        this.store = store2;
        this.adultContentEnabled = adultContentEnabled2;
        this.access = access2;
        this.accessConfirmed = accessConfirmed2;
        this.subscribedStores = subscribedStores2;
        this.privacyPolicy = privacyPolicy2;
        this.termsAndConditions = termsAndConditions2;
        this.dateOfBirth = dateOfBirth2;
    }

    public List<Store> getSubscribedStores() {
        return this.subscribedStores;
    }

    public String getId() {
        return this.f4202id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public boolean isAdultContentEnabled() {
        return this.adultContentEnabled;
    }

    public Access getAccess() {
        return this.access;
    }

    public boolean isAccessConfirmed() {
        return this.accessConfirmed;
    }

    public boolean isLoggedIn() {
        return true;
    }

    public String getEmail() {
        return this.email;
    }

    public Store getStore() {
        return this.store;
    }

    public boolean hasStore() {
        Store store2 = this.store;
        return store2 != null && !TextUtils.isEmpty(store2.getName());
    }

    public boolean isPublicUser() {
        return this.access == Access.PUBLIC;
    }

    public boolean isPublicStore() {
        Store store2 = this.store;
        return store2 != null && store2.hasPublicAccess();
    }

    public boolean acceptedTermsAndConditions() {
        return this.termsAndConditions;
    }

    public boolean acceptedPrivacyPolicy() {
        return this.privacyPolicy;
    }

    public Date getBirthDate() {
        return this.dateOfBirth;
    }
}
