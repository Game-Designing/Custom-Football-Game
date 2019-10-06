package p005cm.aptoide.p006pt.account.view;

import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.LoginBottomSheet */
public interface LoginBottomSheet {

    /* renamed from: cm.aptoide.pt.account.view.LoginBottomSheet$State */
    public enum State {
        EXPANDED,
        COLLAPSED;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    void collapse();

    void expand();

    C0120S<State> state();
}
