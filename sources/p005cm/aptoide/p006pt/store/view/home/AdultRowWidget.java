package p005cm.aptoide.p006pt.store.view.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.p001v7.widget.SwitchCompat;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.ReloadInterface;
import p005cm.aptoide.p006pt.view.dialog.EditableTextDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder;
import p005cm.aptoide.p006pt.view.p080rx.RxSwitch;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p005cm.aptoide.p006pt.view.settings.PinDialog;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.store.view.home.AdultRowWidget */
public class AdultRowWidget extends Widget<AdultRowDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager accountManager;
    private AdultContentAnalytics adultContentAnalytics;
    private RxAlertDialog adultContentConfirmationDialog;
    private SwitchCompat adultPinSwitch;
    private SwitchCompat adultSwitch;
    private EditableTextDialog enableAdultContentPinDialog;
    private boolean ignoreCheck;
    private boolean ignorePinCheck;
    private boolean trackAnalytics = true;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8219185998088220286L, "cm/aptoide/pt/store/view/home/AdultRowWidget", Opcodes.LXOR);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((AdultRowDisplayable) displayable, i);
        $jacocoInit[65] = true;
    }

    public AdultRowWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultSwitch = (SwitchCompat) itemView.findViewById(C1375R.C1376id.adult_content);
        $jacocoInit[1] = true;
        this.adultPinSwitch = (SwitchCompat) itemView.findViewById(C1375R.C1376id.pin_adult_content);
        $jacocoInit[2] = true;
        this.adultContentAnalytics = ((AptoideApplication) getContext().getApplicationContext()).getAdultContentAnalytics();
        $jacocoInit[3] = true;
        Builder message = new Builder(getContext()).setMessage(C1375R.string.are_you_adult);
        $jacocoInit[4] = true;
        Builder positiveButton = message.setPositiveButton(C1375R.string.yes);
        $jacocoInit[5] = true;
        Builder negativeButton = positiveButton.setNegativeButton(C1375R.string.f4266no);
        $jacocoInit[6] = true;
        this.adultContentConfirmationDialog = negativeButton.build();
        $jacocoInit[7] = true;
        PinDialog.Builder message2 = new PinDialog.Builder(getContext()).setMessage(C1375R.string.request_adult_pin);
        $jacocoInit[8] = true;
        PinDialog.Builder positiveButton2 = message2.setPositiveButton(C1375R.string.all_button_ok);
        $jacocoInit[9] = true;
        PinDialog.Builder negativeButton2 = positiveButton2.setNegativeButton(C1375R.string.cancel);
        $jacocoInit[10] = true;
        PinDialog.Builder view = negativeButton2.setView(C1375R.layout.dialog_requestpin);
        $jacocoInit[11] = true;
        PinDialog.Builder editText = view.setEditText(C1375R.C1376id.pininput);
        $jacocoInit[12] = true;
        this.enableAdultContentPinDialog = editText.build();
        this.trackAnalytics = true;
        $jacocoInit[13] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[14] = true;
    }

    public void bindView(AdultRowDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.compositeSubscription;
        C0120S pinRequired = this.accountManager.pinRequired();
        $jacocoInit[15] = true;
        C0120S a = pinRequired.mo3616a(C14522a.m46170a());
        C5008i iVar = new C5008i(this);
        $jacocoInit[16] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) iVar);
        $jacocoInit[17] = true;
        C0137ja j = b.mo3670j();
        $jacocoInit[18] = true;
        cVar.mo3713a(j);
        $jacocoInit[19] = true;
        C0136c cVar2 = this.compositeSubscription;
        C0120S checks = RxSwitch.checks(this.adultSwitch);
        C5020u uVar = new C5020u(this);
        $jacocoInit[20] = true;
        C0120S d = checks.mo3653d((C0132p<? super T, Boolean>) uVar);
        C5003d dVar = new C5003d(this, displayable);
        $jacocoInit[21] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dVar);
        $jacocoInit[22] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[23] = true;
        C0137ja j2 = g.mo3670j();
        $jacocoInit[24] = true;
        cVar2.mo3713a(j2);
        $jacocoInit[25] = true;
        C0136c cVar3 = this.compositeSubscription;
        C0120S checks2 = RxSwitch.checks(this.adultPinSwitch);
        C5009j jVar = new C5009j(this);
        $jacocoInit[26] = true;
        C0120S d2 = checks2.mo3653d((C0132p<? super T, Boolean>) jVar);
        C5004e eVar = new C5004e(this, displayable);
        $jacocoInit[27] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eVar);
        $jacocoInit[28] = true;
        C0120S g2 = f2.mo3662g();
        $jacocoInit[29] = true;
        C0137ja j3 = g2.mo3670j();
        $jacocoInit[30] = true;
        cVar3.mo3713a(j3);
        $jacocoInit[31] = true;
        C0136c cVar4 = this.compositeSubscription;
        C0120S positiveClicks = this.adultContentConfirmationDialog.positiveClicks();
        C5007h hVar = new C5007h(this);
        $jacocoInit[32] = true;
        C0120S b2 = positiveClicks.mo3636b((C0129b<? super T>) hVar);
        C5006g gVar = new C5006g(this, displayable);
        $jacocoInit[33] = true;
        C0120S f3 = b2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gVar);
        $jacocoInit[34] = true;
        C0120S g3 = f3.mo3662g();
        $jacocoInit[35] = true;
        C0137ja j4 = g3.mo3670j();
        $jacocoInit[36] = true;
        cVar4.mo3713a(j4);
        $jacocoInit[37] = true;
        C0136c cVar5 = this.compositeSubscription;
        C0120S positiveClicks2 = this.enableAdultContentPinDialog.positiveClicks();
        C5010k kVar = new C5010k(this);
        $jacocoInit[38] = true;
        C0120S b3 = positiveClicks2.mo3636b((C0129b<? super T>) kVar);
        C5017r rVar = new C5017r(this, displayable);
        $jacocoInit[39] = true;
        C0120S f4 = b3.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        $jacocoInit[40] = true;
        C0120S g4 = f4.mo3662g();
        $jacocoInit[41] = true;
        C0137ja j5 = g4.mo3670j();
        $jacocoInit[42] = true;
        cVar5.mo3713a(j5);
        $jacocoInit[43] = true;
        C0136c cVar6 = this.compositeSubscription;
        C0120S enabled = this.accountManager.enabled();
        $jacocoInit[44] = true;
        C0120S a2 = enabled.mo3616a(C14522a.m46170a());
        C5005f fVar = new C5005f(this);
        $jacocoInit[45] = true;
        C0120S b4 = a2.mo3636b((C0129b<? super T>) fVar);
        $jacocoInit[46] = true;
        C0137ja j6 = b4.mo3670j();
        $jacocoInit[47] = true;
        cVar6.mo3713a(j6);
        $jacocoInit[48] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16647a(Boolean pinRequired) {
        boolean[] $jacocoInit = $jacocoInit();
        if (pinRequired.booleanValue()) {
            $jacocoInit[125] = true;
            this.adultPinSwitch.setVisibility(0);
            $jacocoInit[126] = true;
            this.adultSwitch.setVisibility(8);
            $jacocoInit[127] = true;
        } else {
            this.adultSwitch.setVisibility(0);
            $jacocoInit[128] = true;
            this.adultPinSwitch.setVisibility(8);
            $jacocoInit[129] = true;
        }
        $jacocoInit[130] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Boolean mo16650b(Boolean check) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(shouldCheck());
        $jacocoInit[124] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16643a(AdultRowDisplayable displayable, Boolean checked) {
        boolean[] $jacocoInit = $jacocoInit();
        this.ignoreCheck = false;
        $jacocoInit[110] = true;
        rollbackCheck(this.adultSwitch);
        $jacocoInit[111] = true;
        if (checked.booleanValue()) {
            $jacocoInit[112] = true;
            this.adultContentConfirmationDialog.show();
            $jacocoInit[113] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[114] = true;
            return c;
        }
        this.adultSwitch.setEnabled(false);
        $jacocoInit[115] = true;
        C0117M disable = this.accountManager.disable();
        C5014o oVar = new C5014o(this);
        $jacocoInit[116] = true;
        C0117M a = disable.mo3582a((C0128a) oVar);
        $jacocoInit[117] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5016q qVar = new C5016q(this);
        $jacocoInit[118] = true;
        C0117M b = a2.mo3594b((C0128a) qVar);
        C5019t tVar = new C5019t(this, displayable);
        $jacocoInit[119] = true;
        C0117M b2 = b.mo3594b((C0128a) tVar);
        $jacocoInit[120] = true;
        C0120S f = b2.mo3604f();
        $jacocoInit[121] = true;
        return f;
    }

    /* renamed from: j */
    public /* synthetic */ void mo16660j() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultSwitch.setEnabled(true);
        $jacocoInit[123] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16654c(AdultRowDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        reload(displayable);
        $jacocoInit[122] = true;
    }

    /* renamed from: d */
    public /* synthetic */ Boolean mo16656d(Boolean check) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(shouldPinCheck());
        $jacocoInit[109] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16651b(AdultRowDisplayable displayable, Boolean checked) {
        boolean[] $jacocoInit = $jacocoInit();
        rollbackCheck(this.adultPinSwitch);
        $jacocoInit[96] = true;
        if (checked.booleanValue()) {
            $jacocoInit[97] = true;
            this.enableAdultContentPinDialog.show();
            $jacocoInit[98] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[99] = true;
            return c;
        }
        this.adultPinSwitch.setEnabled(false);
        $jacocoInit[100] = true;
        C0117M disable = this.accountManager.disable();
        C5014o oVar = new C5014o(this);
        $jacocoInit[101] = true;
        C0117M a = disable.mo3582a((C0128a) oVar);
        $jacocoInit[102] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5001b bVar = new C5001b(this);
        $jacocoInit[103] = true;
        C0117M b = a2.mo3594b((C0128a) bVar);
        C5015p pVar = new C5015p(this, displayable);
        $jacocoInit[104] = true;
        C0117M b2 = b.mo3594b((C0128a) pVar);
        $jacocoInit[105] = true;
        C0120S f = b2.mo3604f();
        $jacocoInit[106] = true;
        return f;
    }

    /* renamed from: k */
    public /* synthetic */ void mo16661k() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultPinSwitch.setEnabled(true);
        $jacocoInit[108] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16657d(AdultRowDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        reload(displayable);
        $jacocoInit[107] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16645a(DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultSwitch.setEnabled(false);
        $jacocoInit[95] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16642a(AdultRowDisplayable displayable, DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M enable = this.accountManager.enable();
        C5012m mVar = new C5012m(this);
        $jacocoInit[87] = true;
        C0117M a = enable.mo3582a((C0128a) mVar);
        $jacocoInit[88] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5002c cVar = new C5002c(this);
        $jacocoInit[89] = true;
        C0117M b = a2.mo3594b((C0128a) cVar);
        C5013n nVar = new C5013n(this, displayable);
        $jacocoInit[90] = true;
        C0117M b2 = b.mo3594b((C0128a) nVar);
        $jacocoInit[91] = true;
        C0120S f = b2.mo3604f();
        $jacocoInit[92] = true;
        return f;
    }

    /* renamed from: h */
    public /* synthetic */ void mo16658h() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultSwitch.setEnabled(true);
        $jacocoInit[94] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16646a(AdultRowDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        reload(displayable);
        $jacocoInit[93] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16648a(CharSequence clock) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultPinSwitch.setEnabled(false);
        $jacocoInit[86] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16644a(AdultRowDisplayable displayable, CharSequence pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M enable = this.accountManager.enable(Integer.valueOf(pin.toString()).intValue());
        C5012m mVar = new C5012m(this);
        $jacocoInit[73] = true;
        C0117M a = enable.mo3582a((C0128a) mVar);
        $jacocoInit[74] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5000a aVar = new C5000a(this);
        $jacocoInit[75] = true;
        C0117M a3 = a2.mo3583a((C0129b<? super Throwable>) aVar);
        C5011l lVar = new C5011l(this);
        $jacocoInit[76] = true;
        C0117M b = a3.mo3594b((C0128a) lVar);
        C5018s sVar = new C5018s(this, displayable);
        $jacocoInit[77] = true;
        C0117M b2 = b.mo3594b((C0128a) sVar);
        $jacocoInit[78] = true;
        C0120S f = b2.mo3604f();
        $jacocoInit[79] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16649a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(throwable instanceof SecurityException)) {
            $jacocoInit[82] = true;
        } else {
            $jacocoInit[83] = true;
            ShowMessage.asSnack((Activity) getContext(), (int) C1375R.string.adult_pin_wrong);
            $jacocoInit[84] = true;
        }
        $jacocoInit[85] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo16659i() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultPinSwitch.setEnabled(true);
        $jacocoInit[81] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16652b(AdultRowDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        reload(displayable);
        $jacocoInit[80] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16655c(Boolean enabled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (enabled.booleanValue() == this.adultSwitch.isChecked()) {
            $jacocoInit[66] = true;
        } else {
            this.ignoreCheck = true;
            $jacocoInit[67] = true;
            this.adultSwitch.setChecked(enabled.booleanValue());
            $jacocoInit[68] = true;
        }
        if (enabled.booleanValue() == this.adultPinSwitch.isChecked()) {
            $jacocoInit[69] = true;
        } else {
            this.ignorePinCheck = true;
            $jacocoInit[70] = true;
            this.adultPinSwitch.setChecked(enabled.booleanValue());
            $jacocoInit[71] = true;
        }
        $jacocoInit[72] = true;
    }

    private boolean shouldCheck() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.ignoreCheck) {
            $jacocoInit[49] = true;
            return true;
        }
        this.ignoreCheck = false;
        $jacocoInit[50] = true;
        return false;
    }

    private boolean shouldPinCheck() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.ignorePinCheck) {
            $jacocoInit[51] = true;
            return true;
        }
        this.ignorePinCheck = false;
        $jacocoInit[52] = true;
        return false;
    }

    /* access modifiers changed from: private */
    public void trackLock() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.trackAnalytics) {
            $jacocoInit[53] = true;
        } else {
            this.trackAnalytics = false;
            $jacocoInit[54] = true;
            this.adultContentAnalytics.lock();
            $jacocoInit[55] = true;
        }
        $jacocoInit[56] = true;
    }

    /* access modifiers changed from: private */
    public void trackUnlock() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.trackAnalytics) {
            $jacocoInit[57] = true;
        } else {
            this.trackAnalytics = false;
            $jacocoInit[58] = true;
            this.adultContentAnalytics.unlock();
            $jacocoInit[59] = true;
        }
        $jacocoInit[60] = true;
    }

    private void reload(ReloadInterface reloader) {
        boolean[] $jacocoInit = $jacocoInit();
        reloader.load(true, true, null);
        $jacocoInit[61] = true;
    }

    private void rollbackCheck(SwitchCompat adultSwitch2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!adultSwitch2.isChecked()) {
            $jacocoInit[62] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[63] = true;
        }
        adultSwitch2.setChecked(z);
        $jacocoInit[64] = true;
    }
}
