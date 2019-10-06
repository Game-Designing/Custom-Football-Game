package p005cm.aptoide.p006pt.view.settings;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.settings.MyAccountView */
public interface MyAccountView extends View {
    C0120S<Void> aptoideBackupCardViewClick();

    C0120S<Void> aptoideTvCardViewClick();

    C0120S<Void> aptoideUploaderCardViewClick();

    C0120S<Void> createStoreClick();

    C0120S<Void> editStoreClick();

    C0120S<Void> editUserProfileClick();

    C0120S<GetStore> getStore();

    C0120S<Void> loginClick();

    C0120S<Void> notificationsClicked();

    void refreshUI(Store store);

    C0120S<Void> settingsClicked();

    void showAccount(Account account);

    void showLoginAccountDisplayable();

    C0120S<Void> signOutClick();

    void startAptoideTvWebView();

    C0120S<Void> storeClick();

    C0120S<Void> userClick();
}
