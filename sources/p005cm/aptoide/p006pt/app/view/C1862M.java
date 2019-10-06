package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.M */
/* compiled from: lambda */
public final /* synthetic */ class C1862M implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4869a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4870b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4871c;

    public /* synthetic */ C1862M(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f4869a = appViewFragment;
        this.f4870b = promotion;
        this.f4871c = walletApp;
    }

    public final void onClick(View view) {
        this.f4869a.mo10418b(this.f4870b, this.f4871c, view);
    }
}
