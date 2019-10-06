package p005cm.aptoide.accountmanager;

import android.text.TextUtils;
import java.util.Date;
import java.util.List;
import p005cm.aptoide.accountmanager.Account.Access;

/* renamed from: cm.aptoide.accountmanager.AccountFactory */
public class AccountFactory {
    public Account createAccount(String access, List<Store> stores, String id, String email, String nickname, String avatar, Store store, boolean adultContentEnabled, boolean accessConfirmed, boolean privacyPolicy, boolean termsAndConditions, Date dateOfBirth) {
        AptoideAccount aptoideAccount = new AptoideAccount(id, email, nickname, avatar, store, adultContentEnabled, getAccessFrom(access), accessConfirmed, stores, privacyPolicy, termsAndConditions, dateOfBirth);
        return aptoideAccount;
    }

    private Access getAccessFrom(String serverAccess) {
        if (TextUtils.isEmpty(serverAccess)) {
            return Access.UNLISTED;
        }
        return Access.valueOf(serverAccess.toUpperCase());
    }
}
