package p005cm.aptoide.p006pt.store.view;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.account.view.LoginDisplayable;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.store.view.LoginWidget */
public class LoginWidget extends Widget<LoginDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private View loginButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6118040955712906011L, "cm/aptoide/pt/store/view/LoginWidget", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((LoginDisplayable) displayable, i);
        $jacocoInit[7] = true;
    }

    public LoginWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginButton = itemView.findViewById(C1375R.C1376id.login_button);
        $jacocoInit[1] = true;
    }

    public void bindView(LoginDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        $jacocoInit[3] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.loginButton);
        C4999ha haVar = new C4999ha(accountNavigator);
        C4997ga gaVar = C4997ga.f8669a;
        $jacocoInit[4] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) haVar, (C0129b<Throwable>) gaVar);
        $jacocoInit[5] = true;
        cVar.mo3713a(a2);
        $jacocoInit[6] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9327a(AccountNavigator accountNavigator, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        accountNavigator.navigateToAccountView(AccountOrigins.STORE);
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9328a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[8] = true;
        instance.log(throwable);
        $jacocoInit[9] = true;
    }
}
