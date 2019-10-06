package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.P */
/* compiled from: lambda */
public final /* synthetic */ class C1892P implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4901a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4902b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4903c;

    public /* synthetic */ C1892P(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f4901a = appViewFragment;
        this.f4902b = promotion;
        this.f4903c = walletApp;
    }

    public final void onClick(View view) {
        this.f4901a.mo10421c(this.f4902b, this.f4903c, view);
    }
}
