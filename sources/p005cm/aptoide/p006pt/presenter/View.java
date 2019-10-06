package p005cm.aptoide.p006pt.presenter;

import com.trello.rxlifecycle.C0096f;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.presenter.View */
public interface View {

    /* renamed from: cm.aptoide.pt.presenter.View$LifecycleEvent */
    public enum LifecycleEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    void attachPresenter(Presenter presenter);

    <T> C0096f<T> bindUntilEvent(LifecycleEvent lifecycleEvent);

    C0120S<LifecycleEvent> getLifecycleEvent();
}
