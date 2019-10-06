package p005cm.aptoide.p006pt.promotions;

import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.promotions.ClaimStatusWrapper.Error;
import p005cm.aptoide.p006pt.promotions.ClaimStatusWrapper.Status;
import p019d.p022i.p296a.p306d.C13051f;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionDialogPresenter */
public class ClaimPromotionDialogPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String WALLET_ADDRESS = "WALLET_ADDRESS";
    private ClaimPromotionsManager claimPromotionsManager;
    private ClaimPromotionsNavigator navigator;
    private final String promotionId;
    private PromotionsAnalytics promotionsAnalytics;
    private boolean shouldSendIntent = true;
    private C0136c subscriptions;
    private ClaimPromotionDialogView view;
    private C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-203126960704757577L, "cm/aptoide/pt/promotions/ClaimPromotionDialogPresenter", Opcodes.IRETURN);
        $jacocoData = probes;
        return probes;
    }

    public ClaimPromotionDialogPresenter(ClaimPromotionDialogView view2, C0136c subscriptions2, C0126V viewScheduler2, ClaimPromotionsManager claimPromotionsManager2, PromotionsAnalytics promotionsAnalytics2, ClaimPromotionsNavigator navigator2, String promotionId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.subscriptions = subscriptions2;
        this.viewScheduler = viewScheduler2;
        this.claimPromotionsManager = claimPromotionsManager2;
        this.promotionsAnalytics = promotionsAnalytics2;
        this.navigator = navigator2;
        this.promotionId = promotionId2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleOnResumeEvent();
        $jacocoInit[1] = true;
        handleOnActivityResult();
        $jacocoInit[2] = true;
        handleFindAddressClick();
        $jacocoInit[3] = true;
        handleContinueClick();
        $jacocoInit[4] = true;
        handleRefreshCaptcha();
        $jacocoInit[5] = true;
        handleSubmitClick();
        $jacocoInit[6] = true;
        handleOnEditTextChanged();
        $jacocoInit[7] = true;
        handleDismissGenericError();
        $jacocoInit[8] = true;
        handleWalletCancelClick();
        $jacocoInit[9] = true;
        handleCaptchaCancelClick();
        $jacocoInit[10] = true;
        handleDismissGenericMessage();
        $jacocoInit[11] = true;
    }

    public void dispose() {
        boolean[] $jacocoInit = $jacocoInit();
        this.subscriptions.mo3712a();
        $jacocoInit[12] = true;
    }

    private void handleOnResumeEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4512ba baVar = C4512ba.f8129a;
        $jacocoInit[13] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) baVar);
        C4502Z z = new C4502Z(this);
        $jacocoInit[14] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) z);
        ClaimPromotionDialogView claimPromotionDialogView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[15] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) claimPromotionDialogView.bindUntilEvent(lifecycleEvent2));
        C4490V v = C4490V.f8098a;
        C4442G g = C4442G.f8044a;
        $jacocoInit[16] = true;
        a.mo3626a((C0129b<? super T>) v, (C0129b<Throwable>) g);
        $jacocoInit[17] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8806c(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.RESUME) {
            $jacocoInit[169] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[170] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[171] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15545d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.shouldSendIntent) {
            $jacocoInit[165] = true;
        } else {
            $jacocoInit[166] = true;
            this.view.fetchWalletAddressByClipboard();
            $jacocoInit[167] = true;
        }
        $jacocoInit[168] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8808e(LifecycleEvent __) {
        $jacocoInit()[164] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m8811h(Throwable throwable) {
        $jacocoInit()[163] = true;
    }

    private void handleOnActivityResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S activityResults = this.view.getActivityResults();
        C4599x xVar = new C4599x(this);
        $jacocoInit[18] = true;
        C0120S b = activityResults.mo3636b((C0129b<? super T>) xVar);
        ClaimPromotionDialogView claimPromotionDialogView = this.view;
        LifecycleEvent lifecycleEvent = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) claimPromotionDialogView.bindUntilEvent(lifecycleEvent));
        C4493W w = C4493W.f8102a;
        C4428C c = new C4428C(this);
        $jacocoInit[20] = true;
        a.mo3626a((C0129b<? super T>) w, (C0129b<Throwable>) c);
        $jacocoInit[21] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15532a(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getRequestCode() != 123) {
            $jacocoInit[147] = true;
            return;
        }
        if (result.getResultCode() == -1) {
            $jacocoInit[148] = true;
            Intent resultIntent = result.getData();
            $jacocoInit[149] = true;
            if (resultIntent == null) {
                $jacocoInit[150] = true;
            } else if (resultIntent.getExtras() == null) {
                $jacocoInit[151] = true;
            } else {
                $jacocoInit[152] = true;
                ClaimPromotionDialogView claimPromotionDialogView = this.view;
                Bundle extras = resultIntent.getExtras();
                $jacocoInit[153] = true;
                String string = extras.getString(WALLET_ADDRESS);
                $jacocoInit[154] = true;
                claimPromotionDialogView.updateWalletText(string);
                $jacocoInit[155] = true;
                $jacocoInit[158] = true;
            }
            this.shouldSendIntent = false;
            $jacocoInit[156] = true;
            this.view.sendWalletIntent();
            $jacocoInit[157] = true;
            $jacocoInit[158] = true;
        } else if (result.getResultCode() == 0) {
            $jacocoInit[159] = true;
        } else {
            this.shouldSendIntent = false;
            $jacocoInit[160] = true;
            this.view.sendWalletIntent();
            $jacocoInit[161] = true;
        }
        $jacocoInit[162] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8801b(Result __) {
        $jacocoInit()[146] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15549f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.shouldSendIntent = false;
        $jacocoInit[144] = true;
        this.view.sendWalletIntent();
        $jacocoInit[145] = true;
    }

    private void handleFindAddressClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4454K k = C4454K.f8058a;
        $jacocoInit[22] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) k);
        C0126V v = this.viewScheduler;
        $jacocoInit[23] = true;
        C0120S a = d.mo3616a(v);
        C4424B b = new C4424B(this);
        $jacocoInit[24] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) b);
        ClaimPromotionDialogView claimPromotionDialogView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[25] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) claimPromotionDialogView.bindUntilEvent(lifecycleEvent2));
        C4583t tVar = C4583t.f8212a;
        C4516ca caVar = C4516ca.f8133a;
        $jacocoInit[26] = true;
        a2.mo3626a((C0129b<? super T>) tVar, (C0129b<Throwable>) caVar);
        $jacocoInit[27] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8800b(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[141] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[142] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[143] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15530a(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S walletClick = this.view.getWalletClick();
        C4476Q q = new C4476Q(this);
        $jacocoInit[133] = true;
        C0120S b = walletClick.mo3636b((C0129b<? super T>) q);
        C4466O o = new C4466O(this);
        $jacocoInit[134] = true;
        C0120S a = b.mo3621a((C0129b<? super Throwable>) o);
        $jacocoInit[135] = true;
        C0120S g = a.mo3662g();
        $jacocoInit[136] = true;
        return g;
    }

    /* renamed from: p */
    public /* synthetic */ void mo15560p(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendClickOnWalletDialogFindWallet(packageName);
        $jacocoInit[139] = true;
        this.view.fetchWalletAddressByIntent();
        $jacocoInit[140] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo15558l(Throwable ___) {
        boolean[] $jacocoInit = $jacocoInit();
        this.shouldSendIntent = false;
        $jacocoInit[137] = true;
        this.view.sendWalletIntent();
        $jacocoInit[138] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8809e(String __) {
        $jacocoInit()[132] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8810e(Throwable throwable) {
        $jacocoInit()[131] = true;
    }

    private void handleContinueClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S continueWalletClick = this.view.continueWalletClick();
        C4607z zVar = new C4607z(this);
        $jacocoInit[28] = true;
        C0120S b = continueWalletClick.mo3636b((C0129b<? super T>) zVar);
        C4457L l = new C4457L(this);
        $jacocoInit[29] = true;
        C0120S i = b.mo3668i(l);
        C0126V v = this.viewScheduler;
        $jacocoInit[30] = true;
        C0120S a = i.mo3616a(v);
        C4575r rVar = new C4575r(this);
        $jacocoInit[31] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) rVar);
        C4436E e = C4436E.f8038a;
        C4579s sVar = new C4579s(this);
        $jacocoInit[32] = true;
        C0137ja a2 = b2.mo3626a((C0129b<? super T>) e, (C0129b<Throwable>) sVar);
        $jacocoInit[33] = true;
        cVar.mo3713a(a2);
        $jacocoInit[34] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15534a(ClaimPromotionsClickWrapper wrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendClickOnWalletDialogNext(wrapper.getPackageName());
        $jacocoInit[128] = true;
        this.claimPromotionsManager.saveWalletAddress(wrapper.getWalletAddress());
        $jacocoInit[129] = true;
        this.view.showLoading();
        $jacocoInit[130] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo15540b(ClaimPromotionsClickWrapper __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single captcha = this.claimPromotionsManager.getCaptcha();
        $jacocoInit[127] = true;
        return captcha;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15543c(String captcha) {
        boolean[] $jacocoInit = $jacocoInit();
        this.claimPromotionsManager.saveCaptchaUrl(captcha);
        $jacocoInit[125] = true;
        this.view.showCaptchaView(captcha);
        $jacocoInit[126] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8807d(String __) {
        $jacocoInit()[124] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15542b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[123] = true;
    }

    private void handleRefreshCaptcha() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S refreshCaptchaClick = this.view.refreshCaptchaClick();
        C4439F f = new C4439F(this);
        $jacocoInit[35] = true;
        C0120S b = refreshCaptchaClick.mo3636b((C0129b<? super T>) f);
        C4432D d = new C4432D(this);
        $jacocoInit[36] = true;
        C0120S i = b.mo3668i(d);
        C0126V v = this.viewScheduler;
        $jacocoInit[37] = true;
        C0120S a = i.mo3616a(v);
        C4463N n = new C4463N(this);
        $jacocoInit[38] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) n);
        C4555m mVar = C4555m.f8181a;
        C4595w wVar = new C4595w(this);
        $jacocoInit[39] = true;
        C0137ja a2 = b2.mo3626a((C0129b<? super T>) mVar, (C0129b<Throwable>) wVar);
        $jacocoInit[40] = true;
        cVar.mo3713a(a2);
        $jacocoInit[41] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15548f(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendRefreshCaptchaEvent(packageName);
        $jacocoInit[121] = true;
        this.view.showLoadingCaptcha();
        $jacocoInit[122] = true;
    }

    /* renamed from: g */
    public /* synthetic */ Single mo15550g(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single captcha = this.claimPromotionsManager.getCaptcha();
        $jacocoInit[120] = true;
        return captcha;
    }

    /* renamed from: h */
    public /* synthetic */ void mo15552h(String captcha) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoadingCaptcha(captcha);
        $jacocoInit[119] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m8812i(String __) {
        $jacocoInit()[118] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo15553i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[117] = true;
    }

    private void handleSubmitClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S finishClick = this.view.finishClick();
        C4563o oVar = new C4563o(this);
        $jacocoInit[42] = true;
        C0120S b = finishClick.mo3636b((C0129b<? super T>) oVar);
        C4496X x = new C4496X(this);
        $jacocoInit[43] = true;
        C0120S i = b.mo3668i(x);
        C0126V v = this.viewScheduler;
        $jacocoInit[44] = true;
        C0120S a = i.mo3616a(v);
        C4603y yVar = new C4603y(this);
        $jacocoInit[45] = true;
        C0120S i2 = a.mo3668i(yVar);
        C4420A a2 = C4420A.f8016a;
        $jacocoInit[46] = true;
        C0120S d = i2.mo3653d((C0132p<? super T, Boolean>) a2);
        C4551l lVar = new C4551l(this);
        $jacocoInit[47] = true;
        C0120S i3 = d.mo3668i(lVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[48] = true;
        C0120S a3 = i3.mo3616a(v2);
        C4451J j = new C4451J(this);
        $jacocoInit[49] = true;
        C0120S b2 = a3.mo3636b((C0129b<? super T>) j);
        C4587u uVar = C4587u.f8216a;
        C4448I i4 = new C4448I(this);
        $jacocoInit[50] = true;
        C0137ja a4 = b2.mo3626a((C0129b<? super T>) uVar, (C0129b<Throwable>) i4);
        $jacocoInit[51] = true;
        cVar.mo3713a(a4);
        $jacocoInit[52] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15535a(ClaimPromotionsSubmitWrapper wrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendClickOnCaptchaDialogClaim(wrapper.getPackageName());
        $jacocoInit[115] = true;
        this.view.showLoading();
        $jacocoInit[116] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo15541b(ClaimPromotionsSubmitWrapper wrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionsManager claimPromotionsManager2 = this.claimPromotionsManager;
        String packageName = wrapper.getPackageName();
        $jacocoInit[112] = true;
        String captcha = wrapper.getCaptcha();
        String str = this.promotionId;
        $jacocoInit[113] = true;
        Single claimPromotion = claimPromotionsManager2.claimPromotion(packageName, captcha, str);
        $jacocoInit[114] = true;
        return claimPromotion;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo15531a(ClaimStatusWrapper response) {
        boolean[] $jacocoInit = $jacocoInit();
        Status status = response.getStatus();
        Status status2 = Status.OK;
        $jacocoInit[107] = true;
        if (status.equals(status2)) {
            $jacocoInit[108] = true;
            this.view.showClaimSuccess();
            $jacocoInit[109] = true;
            Single a = Single.m734a(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION);
            $jacocoInit[110] = true;
            return a;
        }
        Single a2 = Single.m734a(handleErrors(response.getErrors()));
        $jacocoInit[111] = true;
        return a2;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m8813j(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(error.equals("captcha"));
        $jacocoInit[106] = true;
        return valueOf;
    }

    /* renamed from: k */
    public /* synthetic */ Single mo15555k(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single captcha = this.claimPromotionsManager.getCaptcha();
        $jacocoInit[105] = true;
        return captcha;
    }

    /* renamed from: l */
    public /* synthetic */ void mo15557l(String captcha) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showInvalidCaptcha(captcha);
        $jacocoInit[104] = true;
    }

    /* renamed from: m */
    static /* synthetic */ void m8814m(String __) {
        $jacocoInit()[103] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo15554j(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[102] = true;
    }

    private void handleOnEditTextChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S editTextChanges = this.view.editTextChanges();
        C4445H h = new C4445H(this);
        $jacocoInit[53] = true;
        C0120S b = editTextChanges.mo3636b((C0129b<? super T>) h);
        C4469P p = C4469P.f8079a;
        C4487U u = new C4487U(this);
        $jacocoInit[54] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) p, (C0129b<Throwable>) u);
        $jacocoInit[55] = true;
        cVar.mo3713a(a);
        $jacocoInit[56] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15536a(C13051f change) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.handleEmptyEditText(change.mo41940b());
        $jacocoInit[101] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8803b(C13051f __) {
        $jacocoInit()[100] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo15551g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[99] = true;
    }

    private void handleDismissGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S dismissGenericErrorClick = this.view.dismissGenericErrorClick();
        C4508aa aaVar = new C4508aa(this);
        $jacocoInit[57] = true;
        C0120S b = dismissGenericErrorClick.mo3636b((C0129b<? super T>) aaVar);
        C4484T t = C4484T.f8092a;
        C4520da daVar = new C4520da(this);
        $jacocoInit[58] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) t, (C0129b<Throwable>) daVar);
        $jacocoInit[59] = true;
        cVar.mo3713a(a);
        $jacocoInit[60] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15539a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissDialog();
        $jacocoInit[98] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8805b(Void __) {
        $jacocoInit()[97] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15544c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[96] = true;
    }

    private void handleWalletCancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S walletCancelClick = this.view.walletCancelClick();
        C4499Y y = new C4499Y(this);
        $jacocoInit[61] = true;
        C0120S b = walletCancelClick.mo3636b((C0129b<? super T>) y);
        C4547k kVar = C4547k.f8171a;
        C4591v vVar = new C4591v(this);
        $jacocoInit[62] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) kVar, (C0129b<Throwable>) vVar);
        $jacocoInit[63] = true;
        cVar.mo3713a(a);
        $jacocoInit[64] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo15559n(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendClickOnWalletDialogCancel(packageName);
        $jacocoInit[93] = true;
        this.navigator.popDialogWithResult(packageName, 0);
        $jacocoInit[94] = true;
        this.view.dismissDialog();
        $jacocoInit[95] = true;
    }

    /* renamed from: o */
    static /* synthetic */ void m8815o(String __) {
        $jacocoInit()[92] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo15556k(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[91] = true;
    }

    private void handleCaptchaCancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S captchaCancelClick = this.view.captchaCancelClick();
        C4543j jVar = new C4543j(this);
        $jacocoInit[65] = true;
        C0120S b = captchaCancelClick.mo3636b((C0129b<? super T>) jVar);
        C4481S s = C4481S.f8089a;
        C4567p pVar = new C4567p(this);
        $jacocoInit[66] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) s, (C0129b<Throwable>) pVar);
        $jacocoInit[67] = true;
        cVar.mo3713a(a);
        $jacocoInit[68] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15537a(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendClickOnCaptchaDialogCancel(packageName);
        $jacocoInit[89] = true;
        this.view.dismissDialog();
        $jacocoInit[90] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8804b(String __) {
        $jacocoInit()[88] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15538a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[87] = true;
    }

    private void handleDismissGenericMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S dismissGenericMessage = this.view.dismissGenericMessage();
        C4559n nVar = new C4559n(this);
        $jacocoInit[69] = true;
        C0120S b = dismissGenericMessage.mo3636b((C0129b<? super T>) nVar);
        C4571q qVar = C4571q.f8199a;
        C4460M m = new C4460M(this);
        $jacocoInit[70] = true;
        C0137ja a = b.mo3626a((C0129b<? super T>) qVar, (C0129b<Throwable>) m);
        $jacocoInit[71] = true;
        cVar.mo3713a(a);
        $jacocoInit[72] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15533a(ClaimDialogResultWrapper message) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionsNavigator claimPromotionsNavigator = this.navigator;
        String packageName = message.getPackageName();
        $jacocoInit[82] = true;
        if (message.isOk()) {
            i = -1;
            $jacocoInit[83] = true;
        } else {
            i = 0;
            $jacocoInit[84] = true;
        }
        claimPromotionsNavigator.popDialogWithResult(packageName, i);
        $jacocoInit[85] = true;
        this.view.dismissDialog();
        $jacocoInit[86] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8802b(ClaimDialogResultWrapper __) {
        $jacocoInit()[81] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15546d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showGenericError();
        $jacocoInit[80] = true;
    }

    private String handleErrors(List<Error> errors) {
        boolean[] $jacocoInit = $jacocoInit();
        if (errors.contains(Error.PROMOTION_CLAIMED)) {
            $jacocoInit[73] = true;
            this.view.showPromotionAlreadyClaimed();
            $jacocoInit[74] = true;
        } else if (errors.contains(Error.WRONG_ADDRESS)) {
            $jacocoInit[75] = true;
            this.view.showInvalidWalletAddress();
            $jacocoInit[76] = true;
        } else if (errors.contains(Error.WRONG_CAPTCHA)) {
            $jacocoInit[77] = true;
            return "captcha";
        } else {
            this.view.showGenericError();
            $jacocoInit[78] = true;
        }
        $jacocoInit[79] = true;
        return "error";
    }
}
