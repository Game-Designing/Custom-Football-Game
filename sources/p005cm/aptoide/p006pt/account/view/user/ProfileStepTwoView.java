package p005cm.aptoide.p006pt.account.view.user;

import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepTwoView */
interface ProfileStepTwoView extends View {
    C0120S<Boolean> continueButtonClick();

    void dismissWaitDialog();

    C0120S<Boolean> makePrivateProfileButtonClick();

    C0117M showGenericErrorMessage();

    void showWaitDialog();
}
