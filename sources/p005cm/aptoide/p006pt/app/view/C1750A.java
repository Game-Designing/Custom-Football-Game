package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.A */
/* compiled from: lambda */
public final /* synthetic */ class C1750A implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4742a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4743b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4744c;

    public /* synthetic */ C1750A(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f4742a = appViewFragment;
        this.f4743b = promotion;
        this.f4744c = walletApp;
    }

    public final void onClick(View view) {
        this.f4742a.mo10464f(this.f4743b, this.f4744c, view);
    }
}
