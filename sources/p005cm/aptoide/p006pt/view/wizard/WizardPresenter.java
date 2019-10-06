package p005cm.aptoide.p006pt.view.wizard;

import android.support.p000v4.view.ViewPager.C0597f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import rx.Observable;

/* renamed from: cm.aptoide.pt.view.wizard.WizardPresenter */
public class WizardPresenter implements Presenter, C0597f {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReport;
    private final WizardView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7541329578127100206L, "cm/aptoide/pt/view/wizard/WizardPresenter", 28);
        $jacocoData = probes;
        return probes;
    }

    public WizardPresenter(WizardView view2, AptoideAccountManager accountManager2, CrashReport crashReport2, AccountAnalytics accountAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.accountManager = accountManager2;
        this.crashReport = crashReport2;
        this.accountAnalytics = accountAnalytics2;
        $jacocoInit[0] = true;
    }

    private C0117M createViewsAndButtons() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[1] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[2] = true;
        Single n = d.mo3678n();
        $jacocoInit[3] = true;
        Single a = n.mo3686a(C14522a.m46170a());
        C5562i iVar = new C5562i(this);
        $jacocoInit[4] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) iVar);
        $jacocoInit[5] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo17583a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M createWizardAdapter = this.view.createWizardAdapter(account.isLoggedIn());
        $jacocoInit[27] = true;
        return createWizardAdapter;
    }

    private C0120S<Void> setupHandlers() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S skipWizardClick = this.view.skipWizardClick();
        $jacocoInit[6] = true;
        C0120S a = skipWizardClick.mo3616a(C14522a.m46170a());
        C5558e eVar = new C5558e(this);
        $jacocoInit[7] = true;
        Observable<Void> skipWizardClick2 = a.mo3636b((C0129b<? super T>) eVar);
        $jacocoInit[8] = true;
        return skipWizardClick2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17586b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.skipWizard();
        $jacocoInit[26] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5559f fVar = C5559f.f9372a;
        $jacocoInit[9] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) fVar);
        C5561h hVar = new C5561h(this);
        $jacocoInit[10] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hVar);
        WizardView wizardView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[11] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) wizardView.bindUntilEvent(lifecycleEvent2));
        C5557d dVar = C5557d.f9370a;
        C5560g gVar = new C5560g(this);
        $jacocoInit[12] = true;
        a.mo3626a((C0129b<? super T>) dVar, (C0129b<Throwable>) gVar);
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9800a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[23] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[24] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[25] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17585b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = createViewsAndButtons().mo3586a(setupHandlers());
        $jacocoInit[22] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ void m9801a(Void __) {
        $jacocoInit()[21] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17584a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[20] = true;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.handleColorTransitions(position, positionOffset, positionOffsetPixels);
        $jacocoInit[14] = true;
    }

    public void onPageSelected(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (position != this.view.getCount() - 1) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            this.accountAnalytics.enterAccountScreen(AccountOrigins.WIZARD);
            $jacocoInit[17] = true;
        }
        this.view.handleSelectedPage(position);
        $jacocoInit[18] = true;
    }

    public void onPageScrollStateChanged(int state) {
        $jacocoInit()[19] = true;
    }
}
