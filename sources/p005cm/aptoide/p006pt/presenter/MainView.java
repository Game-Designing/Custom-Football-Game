package p005cm.aptoide.p006pt.presenter;

import android.content.Intent;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.presenter.MainView */
public interface MainView extends View {
    C0120S<PermissionService> autoUpdateDialogCreated();

    void dismissAutoUpdateDialog();

    void dismissInstallationError();

    C0120S<Void> getInstallErrorsDismiss();

    Intent getIntentAfterCreate();

    void hideUpdatesBadge();

    void requestAutoUpdate();

    void showInstallationError(int i);

    void showInstallationSuccessMessage();

    void showUnknownErrorMessage();

    void showUpdatesNumber(Integer num);
}
