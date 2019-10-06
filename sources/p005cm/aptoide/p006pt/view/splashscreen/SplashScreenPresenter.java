package p005cm.aptoide.p006pt.view.splashscreen;

import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.splashscreen.SplashScreenPresenter */
public class SplashScreenPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private SplashScreenNavigator splashScreenNavigator;
    private SplashScreenView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7486912645253100562L, "cm/aptoide/pt/view/splashscreen/SplashScreenPresenter", 15);
        $jacocoData = probes;
        return probes;
    }

    public SplashScreenPresenter(SplashScreenView splashScreenView, SplashScreenNavigator splashScreenNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = splashScreenView;
        this.splashScreenNavigator = splashScreenNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleLoad();
        $jacocoInit[1] = true;
    }

    private void handleLoad() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5539d dVar = C5539d.f9350a;
        $jacocoInit[2] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[3] = true;
        C0120S b = d.mo3630b(3000, timeUnit);
        $jacocoInit[4] = true;
        C0120S a = b.mo3616a(C14522a.m46170a());
        C5536a aVar = new C5536a(this);
        $jacocoInit[5] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) aVar);
        SplashScreenView splashScreenView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[6] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) splashScreenView.bindUntilEvent(lifecycleEvent2));
        C5538c cVar = C5538c.f9349a;
        C5537b bVar = C5537b.f9348a;
        $jacocoInit[7] = true;
        a2.mo3626a((C0129b<? super T>) cVar, (C0129b<Throwable>) bVar);
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9785a(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[12] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[13] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[14] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17549b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.splashScreenNavigator.navigateToHome();
        $jacocoInit[11] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9787c(LifecycleEvent created) {
        $jacocoInit()[10] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9786a(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[9] = true;
        throw onErrorNotImplementedException;
    }
}
