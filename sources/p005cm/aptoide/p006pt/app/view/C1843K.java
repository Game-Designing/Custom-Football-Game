package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.K */
/* compiled from: lambda */
public final /* synthetic */ class C1843K implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4848a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4849b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4850c;

    public /* synthetic */ C1843K(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f4848a = appViewFragment;
        this.f4849b = promotion;
        this.f4850c = walletApp;
    }

    public final void onClick(View view) {
        this.f4848a.mo10465g(this.f4849b, this.f4850c, view);
    }
}
