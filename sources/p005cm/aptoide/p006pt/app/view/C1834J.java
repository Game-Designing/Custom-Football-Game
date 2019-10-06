package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.J */
/* compiled from: lambda */
public final /* synthetic */ class C1834J implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4837a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4838b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4839c;

    public /* synthetic */ C1834J(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f4837a = appViewFragment;
        this.f4838b = promotion;
        this.f4839c = walletApp;
    }

    public final void onClick(View view) {
        this.f4837a.mo10452d(this.f4838b, this.f4839c, view);
    }
}
