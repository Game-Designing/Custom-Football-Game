package p005cm.aptoide.p006pt.editorial;

import java.util.List;
import p005cm.aptoide.p006pt.editorial.EditorialViewModel.Error;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.reactions.ReactionEvent;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.editorial.EditorialView */
public interface EditorialView extends View {
    C0120S<EditorialEvent> actionButtonClicked();

    void addBottomCardAnimation();

    C0120S<EditorialEvent> appCardClicked(EditorialViewModel editorialViewModel);

    C0120S<EditorialDownloadEvent> cancelDownload(EditorialViewModel editorialViewModel);

    C0120S<Boolean> handleMovingCollapse();

    void hideLoading();

    C0120S<EditorialDownloadEvent> installButtonClick(EditorialViewModel editorialViewModel);

    C0120S<Void> isViewReady();

    void manageMediaListDescriptionAnimationVisibility(EditorialEvent editorialEvent);

    void managePlaceHolderVisibity();

    C0120S<EditorialEvent> mediaContentClicked();

    C0120S<EditorialEvent> mediaListDescriptionChanged();

    void openApp(String str);

    C0120S<EditorialDownloadEvent> pauseDownload(EditorialViewModel editorialViewModel);

    C0120S<ScrollEvent> placeHolderVisibilityChange();

    void populateView(EditorialViewModel editorialViewModel);

    C0120S<ReactionEvent> reactionClicked();

    C0120S<Void> reactionsButtonClicked();

    C0120S<Void> reactionsButtonLongPressed();

    void removeBottomCardAnimation();

    C0120S<EditorialDownloadEvent> resumeDownload(EditorialViewModel editorialViewModel);

    C0120S<Void> retryClicked();

    void setMediaListDescriptionsVisible(EditorialEvent editorialEvent);

    void setUserReaction(String str);

    C0120S<Boolean> showDowngradeMessage();

    void showDowngradingMessage();

    void showDownloadModel(EditorialDownloadModel editorialDownloadModel);

    void showError(Error error);

    void showGenericErrorToast();

    void showLoading();

    void showLoginDialog();

    void showNetworkErrorToast();

    void showReactionsPopup(String str, String str2);

    C0120S<Boolean> showRootInstallWarningPopup();

    void showTopReactions(String str, List<TopReaction> list, int i);

    C0120S<Void> snackLoginClick();
}
