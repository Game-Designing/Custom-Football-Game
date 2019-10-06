package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.G */
/* compiled from: lambda */
public final /* synthetic */ class C1807G implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4803a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4804b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4805c;

    public /* synthetic */ C1807G(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f4803a = appViewFragment;
        this.f4804b = promotion;
        this.f4805c = walletApp;
    }

    public final void onClick(View view) {
        this.f4803a.mo10409a(this.f4804b, this.f4805c, view);
    }
}
