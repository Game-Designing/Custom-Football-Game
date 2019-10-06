package p005cm.aptoide.p006pt.presenter;

import android.content.Context;
import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.p006pt.account.view.GooglePlayServicesView;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.presenter.LoginSignUpCredentialsView */
public interface LoginSignUpCredentialsView extends GooglePlayServicesView {
    C0120S<AptoideCredentials> aptoideLoginEvent();

    C0120S<AptoideCredentials> aptoideSignUpEvent();

    void dismiss();

    C0120S<Void> facebookSignUpEvent();

    C0120S<Void> facebookSignUpWithRequiredPermissionsInEvent();

    C0120S<Void> forgotPasswordClick();

    Context getApplicationContext();

    C0120S<Void> googleSignUpEvent();

    void hideFacebookLogin();

    void hideGoogleLogin();

    void hideKeyboard();

    void hideLoading();

    void hidePassword();

    void hideTCandPP();

    boolean isPasswordVisible();

    void lockScreenRotation();

    C0120S<Void> privacyPolicyClickEvent();

    void setCobrandText();

    void showAptoideLoginArea();

    C0120S<Void> showAptoideLoginAreaClick();

    void showAptoideSignUpArea();

    C0120S<Boolean> showAptoideSignUpAreaClick();

    void showError(String str);

    void showFacebookLogin();

    void showFacebookPermissionsRequiredError(Throwable th);

    void showGoogleLogin();

    C0120S<Void> showHidePasswordClick();

    void showLoading();

    void showPassword();

    void showTCandPP();

    void showTermsConditionError();

    C0120S<Void> termsAndConditionsClickEvent();

    boolean tryCloseLoginBottomSheet(boolean z);

    void unlockScreenRotation();
}
