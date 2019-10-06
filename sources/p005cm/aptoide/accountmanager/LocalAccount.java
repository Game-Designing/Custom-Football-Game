package p005cm.aptoide.accountmanager;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import p005cm.aptoide.accountmanager.Account.Access;

/* renamed from: cm.aptoide.accountmanager.LocalAccount */
public class LocalAccount implements Account {
    private final Store store;

    public LocalAccount(Store store2) {
        this.store = store2;
    }

    public List<Store> getSubscribedStores() {
        return Collections.emptyList();
    }

    public String getId() {
        return "";
    }

    public String getNickname() {
        return "";
    }

    public String getAvatar() {
        return "";
    }

    public boolean isAdultContentEnabled() {
        return false;
    }

    public Access getAccess() {
        return Access.UNLISTED;
    }

    public boolean isAccessConfirmed() {
        return false;
    }

    public boolean isLoggedIn() {
        return false;
    }

    public String getEmail() {
        return "";
    }

    public Store getStore() {
        return this.store;
    }

    public boolean hasStore() {
        Store store2 = this.store;
        return store2 != null && !TextUtils.isEmpty(store2.getName());
    }

    public boolean isPublicUser() {
        return getAccess() == Access.PUBLIC;
    }

    public boolean isPublicStore() {
        Store store2 = this.store;
        return store2 != null && store2.hasPublicAccess();
    }

    public boolean acceptedTermsAndConditions() {
        return false;
    }

    public boolean acceptedPrivacyPolicy() {
        return false;
    }

    public Date getBirthDate() {
        return new Date(1970, 1, 1);
    }
}
