package p005cm.aptoide.p006pt.billing.view.login;

import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.p006pt.account.view.GooglePlayServicesView;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.billing.view.login.PaymentLoginView */
public interface PaymentLoginView extends GooglePlayServicesView {
    C0120S<AptoideCredentials> aptoideLoginEvent();

    C0120S<AptoideCredentials> aptoideSignUpEvent();

    C0120S<Void> backButtonEvent();

    C0120S<Void> facebookSignUpEvent();

    C0120S<Void> googleSignUpEvent();

    C0120S<Void> grantFacebookRequiredPermissionsEvent();

    void hideLoading();

    C0120S<Void> hidePasswordContainerEvent();

    void hideTCandPP();

    void hideUsernamePasswordContainer(boolean z);

    C0120S<Void> privacyPolicyClickEvent();

    C0120S<Void> recoverPasswordEvent();

    void setCobrandText();

    C0120S<Boolean> showAptoideSignUpAreaClick();

    void showError(String str);

    void showFacebookPermissionsRequiredError();

    void showLoading();

    void showTCandPP();

    void showTermsConditionError();

    void showUsernamePasswordContainer(boolean z, boolean z2);

    C0120S<Void> termsAndConditionsClickEvent();

    C0120S<Void> upNavigationEvent();
}
