package p005cm.aptoide.p006pt.account.view;

import android.support.design.widget.BottomSheetBehavior.C0231a;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.presenter.LoginSignUpView;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.view.LoginSignUpPresenter */
public class LoginSignUpPresenter extends C0231a implements Presenter, ClickHandler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = LoginSignUpPresenter.class.getName();
    private final boolean dismissToNavigateToMainView;
    private final boolean navigateToHome;
    private final FragmentNavigator navigatorChild;
    private final LoginSignUpView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7067326210623048122L, "cm/aptoide/pt/account/view/LoginSignUpPresenter", 28);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[27] = true;
    }

    public LoginSignUpPresenter(LoginSignUpView view2, FragmentNavigator navigatorChild2, boolean dismissToNavigateToMainView2, boolean navigateToHome2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.navigatorChild = navigatorChild2;
        this.dismissToNavigateToMainView = dismissToNavigateToMainView2;
        this.navigateToHome = navigateToHome2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1496ga gaVar = C1496ga.f4419a;
        $jacocoInit[1] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) gaVar);
        C1494fa faVar = new C1494fa(this);
        $jacocoInit[2] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) faVar);
        LoginSignUpView loginSignUpView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[3] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) loginSignUpView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[4] = true;
        a.mo3670j();
        $jacocoInit[5] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6279a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[24] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[25] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[26] = true;
        return valueOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void mo9766b(p005cm.aptoide.p006pt.presenter.View.LifecycleEvent r9) {
        /*
            r8 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 14
            r2 = 1
            r3 = 0
            r0[r1] = r2     // Catch:{ ClassCastException -> 0x001b }
            r1 = r3
            cm.aptoide.pt.navigator.FragmentNavigator r3 = r8.navigatorChild     // Catch:{ ClassCastException -> 0x0019 }
            android.support.v4.app.Fragment r3 = r3.getFragment()     // Catch:{ ClassCastException -> 0x0019 }
            cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment r3 = (p005cm.aptoide.p006pt.account.view.LoginSignUpCredentialsFragment) r3     // Catch:{ ClassCastException -> 0x0019 }
            r1 = r3
            r3 = 15
            r0[r3] = r2
            goto L_0x0034
        L_0x0019:
            r3 = move-exception
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
        L_0x001f:
            r4 = 16
            r0[r4] = r2
            cm.aptoide.pt.logger.Logger r4 = p005cm.aptoide.p006pt.logger.Logger.getInstance()
            java.lang.String r5 = TAG
            r6 = 17
            r0[r6] = r2
            r4.mo2142e(r5, r3)
            r4 = 18
            r0[r4] = r2
        L_0x0034:
            if (r1 == 0) goto L_0x003b
            r3 = 19
            r0[r3] = r2
            goto L_0x0054
        L_0x003b:
            cm.aptoide.pt.navigator.FragmentNavigator r3 = r8.navigatorChild
            boolean r4 = r8.dismissToNavigateToMainView
            boolean r5 = r8.navigateToHome
            r6 = 20
            r0[r6] = r2
            cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment r4 = p005cm.aptoide.p006pt.account.view.LoginSignUpCredentialsFragment.newInstance(r4, r5)
            r5 = 21
            r0[r5] = r2
            r3.navigateToWithoutBackSave(r4, r2)
            r3 = 22
            r0[r3] = r2
        L_0x0054:
            r3 = 23
            r0[r3] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.LoginSignUpPresenter.mo9766b(cm.aptoide.pt.presenter.View$LifecycleEvent):void");
    }

    public void onStateChanged(View bottomSheet, int newState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (newState == 3) {
            this.view.expandBottomSheet();
            $jacocoInit[8] = true;
        } else if (newState != 4) {
            $jacocoInit[6] = true;
        } else {
            this.view.collapseBottomSheet();
            $jacocoInit[7] = true;
        }
        $jacocoInit[9] = true;
    }

    public void onSlide(View bottomSheet, float slideOffset) {
        $jacocoInit()[10] = true;
    }

    public boolean handle() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.view.bottomSheetIsExpanded()) {
            $jacocoInit[11] = true;
            this.view.setBottomSheetState(4);
            $jacocoInit[12] = true;
            return true;
        }
        $jacocoInit[13] = true;
        return false;
    }
}
