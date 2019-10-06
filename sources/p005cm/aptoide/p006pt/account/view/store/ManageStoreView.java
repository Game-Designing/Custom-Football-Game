package p005cm.aptoide.p006pt.account.view.store;

import p005cm.aptoide.p006pt.account.view.ImagePickerView;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreView */
public interface ManageStoreView extends ImagePickerView {
    C0120S<ManageStoreViewModel> cancelClick();

    void dismissWaitProgressBar();

    void loadImageStateless(String str);

    C0120S<ManageStoreViewModel> saveDataClick();

    void showError(String str);

    void showFacebookError(String str);

    void showSuccessMessage();

    void showTwitchError(String str);

    void showTwitterError(String str);

    void showWaitProgressBar();

    void showYoutubeError(String str);
}
