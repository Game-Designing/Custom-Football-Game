package p005cm.aptoide.p006pt.app.view.donations.view;

import p005cm.aptoide.p006pt.app.view.donations.model.DonationsDialogResult;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.app.view.donations.view.DonateDialogView */
public interface DonateDialogView {
    C0120S<DonationsDialogResult> cancelClick();

    void dismissDialog();

    C0120S<DonationsDialogResult> donateClick();

    C0120S<Void> noWalletContinueClick();

    void sendWalletIntent(float f, String str, String str2, String str3);

    void showErrorMessage();

    void showLoading();

    void showNoWalletView();
}
