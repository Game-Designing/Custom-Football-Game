package p005cm.aptoide.p006pt.editorialList;

import java.util.List;
import p005cm.aptoide.p006pt.home.EditorialHomeEvent;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListView */
public interface EditorialListView extends View {
    C0120S<EditorialHomeEvent> editorialCardClicked();

    void hideLoadMore();

    void hideLoading();

    void hideRefresh();

    C0120S<Void> imageClick();

    C0120S<EditorialHomeEvent> onPopupDismiss();

    void populateView(List<CurationCard> list);

    C0120S<Object> reachesBottom();

    C0120S<EditorialHomeEvent> reactionButtonLongPress();

    C0120S<ReactionsHomeEvent> reactionClicked();

    C0120S<EditorialHomeEvent> reactionsButtonClicked();

    C0120S<Void> refreshes();

    C0120S<Void> retryClicked();

    void setDefaultUserImage();

    void setScrollEnabled(Boolean bool);

    void setUserImage(String str);

    void showAvatar();

    void showGenericError();

    void showGenericErrorToast();

    void showLoadMore();

    void showLoading();

    void showLogInDialog();

    void showNetworkError();

    void showNetworkErrorToast();

    void showReactionsPopup(String str, String str2, int i);

    C0120S<Void> snackLogInClick();

    void update(List<CurationCard> list);

    void updateEditorialCard(CurationCard curationCard);

    C0120S<EditorialListEvent> visibleCards();
}
