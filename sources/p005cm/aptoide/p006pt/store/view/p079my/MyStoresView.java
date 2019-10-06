package p005cm.aptoide.p006pt.store.view.p079my;

import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.store.view.my.MyStoresView */
public interface MyStoresView extends View {
    C0120S<Void> imageClick();

    void scrollToTop();

    void setDefaultUserImage();

    void setUserImage(String str);

    void showAvatar();
}
