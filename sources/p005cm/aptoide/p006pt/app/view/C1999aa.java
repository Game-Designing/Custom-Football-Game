package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.aa */
/* compiled from: lambda */
public final /* synthetic */ class C1999aa implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f5034a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f5035b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f5036c;

    public /* synthetic */ C1999aa(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f5034a = appViewFragment;
        this.f5035b = promotion;
        this.f5036c = walletApp;
    }

    public final void onClick(View view) {
        this.f5034a.mo10468h(this.f5035b, this.f5036c, view);
    }
}
