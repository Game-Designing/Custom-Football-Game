package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.home.HomeContainerFragment.ChipsEvents;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.HomeContainerView */
public interface HomeContainerView extends View {
    C0120S<Boolean> appsChipClicked();

    void dismissPromotionsDialog();

    void expandChips();

    C0120S<Boolean> gamesChipClicked();

    C0120S<String> gdprDialogClicked();

    void hidePromotionsIcon();

    C0120S<ChipsEvents> isChipChecked();

    C0120S<String> promotionsHomeDialogClicked();

    void setDefaultUserImage();

    void setUserImage(String str);

    void showAvatar();

    void showPromotionsHomeDialog(HomePromotionsWrapper homePromotionsWrapper);

    void showPromotionsHomeIcon(HomePromotionsWrapper homePromotionsWrapper);

    void showTermsAndConditionsDialog();

    C0120S<Void> toolbarPromotionsClick();

    C0120S<Void> toolbarUserClick();

    void uncheckChips();
}
