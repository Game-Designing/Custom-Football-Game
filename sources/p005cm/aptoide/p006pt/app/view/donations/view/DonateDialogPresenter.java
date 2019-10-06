package p005cm.aptoide.p006pt.app.view.donations.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.app.view.donations.WalletService;
import p005cm.aptoide.p006pt.app.view.donations.model.DonationsDialogResult;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.app.view.donations.view.DonateDialogPresenter */
public class DonateDialogPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppNavigator appNavigator;
    private DonationsAnalytics donationsAnalytics;
    private C0136c subscriptions;
    private DonateDialogView view;
    private C0126V viewScheduler;
    private WalletService walletService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5202451735924831365L, "cm/aptoide/pt/app/view/donations/view/DonateDialogPresenter", 45);
        $jacocoData = probes;
        return probes;
    }

    public DonateDialogPresenter(DonateDialogView view2, WalletService walletService2, C0136c subscriptions2, C0126V viewScheduler2, AppNavigator appNavigator2, DonationsAnalytics donationsAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.walletService = walletService2;
        this.subscriptions = subscriptions2;
        this.viewScheduler = viewScheduler2;
        this.appNavigator = appNavigator2;
        this.donationsAnalytics = donationsAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleDonateClick();
        $jacocoInit[1] = true;
        handleNoWalletContinueClick();
        $jacocoInit[2] = true;
        handleCancelClick();
        $jacocoInit[3] = true;
    }

    public void dispose() {
        boolean[] $jacocoInit = $jacocoInit();
        this.subscriptions.mo3712a();
        $jacocoInit[4] = true;
    }

    private void handleDonateClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S donateClick = this.view.donateClick();
        C2051h hVar = new C2051h(this);
        $jacocoInit[5] = true;
        C0120S b = donateClick.mo3636b((C0129b<? super T>) hVar);
        C2050g gVar = new C2050g(this);
        $jacocoInit[6] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gVar);
        C2059p pVar = C2059p.f5108a;
        C2056m mVar = new C2056m(this);
        $jacocoInit[7] = true;
        C0137ja a = f.mo3626a((C0129b<? super T>) pVar, (C0129b<Throwable>) mVar);
        $jacocoInit[8] = true;
        cVar.mo3713a(a);
        $jacocoInit[9] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10981c(DonationsDialogResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[44] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo10983d(DonationsDialogResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        Single walletAddress = this.walletService.getWalletAddress(result.getPackageName());
        $jacocoInit[32] = true;
        C0120S c = walletAddress.mo3696c();
        C0126V v = this.viewScheduler;
        $jacocoInit[33] = true;
        C0120S a = c.mo3616a(v);
        C2057n nVar = new C2057n(this, result);
        $jacocoInit[34] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) nVar);
        $jacocoInit[35] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10977a(DonationsDialogResult result, String address) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        DonationsAnalytics donationsAnalytics2 = this.donationsAnalytics;
        String packageName = result.getPackageName();
        float value = result.getValue();
        $jacocoInit[36] = true;
        String nickname = result.getNickname();
        $jacocoInit[37] = true;
        if (!nickname.isEmpty()) {
            $jacocoInit[38] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[39] = true;
        }
        donationsAnalytics2.sendDonateInteractEvent(packageName, value, z);
        $jacocoInit[40] = true;
        DonateDialogView donateDialogView = this.view;
        float value2 = result.getValue();
        String packageName2 = result.getPackageName();
        $jacocoInit[41] = true;
        String nickname2 = result.getNickname();
        $jacocoInit[42] = true;
        donateDialogView.sendWalletIntent(value2, address, packageName2, nickname2);
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6971a(String lifecycleEvent) {
        $jacocoInit()[31] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10980b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showErrorMessage();
        $jacocoInit[30] = true;
    }

    private void handleCancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S cancelClick = this.view.cancelClick();
        C2058o oVar = new C2058o(this);
        $jacocoInit[10] = true;
        C0120S b = cancelClick.mo3636b((C0129b<? super T>) oVar);
        C2054k kVar = C2054k.f5102a;
        C2052i iVar = new C2052i(this);
        $jacocoInit[11] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) kVar, (C0129b<Throwable>) iVar);
        $jacocoInit[12] = true;
        cVar.mo3713a(a);
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10976a(DonationsDialogResult result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        DonationsAnalytics donationsAnalytics2 = this.donationsAnalytics;
        String packageName = result.getPackageName();
        float value = result.getValue();
        $jacocoInit[24] = true;
        String nickname = result.getNickname();
        $jacocoInit[25] = true;
        if (!nickname.isEmpty()) {
            $jacocoInit[26] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[27] = true;
        }
        donationsAnalytics2.sendCancelInteractEvent(packageName, value, z);
        $jacocoInit[28] = true;
        this.view.dismissDialog();
        $jacocoInit[29] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6972b(DonationsDialogResult lifecycleEvent) {
        $jacocoInit()[23] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10978a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showErrorMessage();
        $jacocoInit[22] = true;
    }

    private void handleNoWalletContinueClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S noWalletContinueClick = this.view.noWalletContinueClick();
        C2055l lVar = new C2055l(this);
        $jacocoInit[14] = true;
        C0120S b = noWalletContinueClick.mo3636b((C0129b<? super T>) lVar);
        C2060q qVar = C2060q.f5109a;
        C2053j jVar = new C2053j(this);
        $jacocoInit[15] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) qVar, (C0129b<Throwable>) jVar);
        $jacocoInit[16] = true;
        cVar.mo3713a(a);
        $jacocoInit[17] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10979a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithPackageName("com.appcoins.wallet", OpenType.OPEN_ONLY);
        $jacocoInit[20] = true;
        this.view.dismissDialog();
        $jacocoInit[21] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6973b(Void lifecycleEvent) {
        $jacocoInit()[19] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10982c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showErrorMessage();
        $jacocoInit[18] = true;
    }
}
