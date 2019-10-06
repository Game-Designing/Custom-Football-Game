package p005cm.aptoide.p006pt.promotions;

import android.text.Editable;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.presenter.View;
import p019d.p022i.p296a.p306d.C13051f;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionDialogView */
public interface ClaimPromotionDialogView extends View {
    C0120S<String> captchaCancelClick();

    C0120S<ClaimPromotionsClickWrapper> continueWalletClick();

    void dismissDialog();

    C0120S<Void> dismissGenericErrorClick();

    C0120S<ClaimDialogResultWrapper> dismissGenericMessage();

    C0120S<C13051f> editTextChanges();

    void fetchWalletAddressByClipboard();

    void fetchWalletAddressByIntent();

    C0120S<ClaimPromotionsSubmitWrapper> finishClick();

    C0120S<Result> getActivityResults();

    C0120S<String> getWalletClick();

    void handleEmptyEditText(Editable editable);

    void hideLoadingCaptcha(String str);

    C0120S<String> refreshCaptchaClick();

    void sendWalletIntent();

    void showCaptchaView(String str);

    void showClaimSuccess();

    void showGenericError();

    void showInvalidCaptcha(String str);

    void showInvalidWalletAddress();

    void showLoading();

    void showLoadingCaptcha();

    void showPromotionAlreadyClaimed();

    void updateWalletText(String str);

    C0120S<String> walletCancelClick();
}
