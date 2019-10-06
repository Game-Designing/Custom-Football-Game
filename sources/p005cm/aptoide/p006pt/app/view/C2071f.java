package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.f */
/* compiled from: lambda */
public final /* synthetic */ class C2071f implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f5120a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f5121b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f5122c;

    public /* synthetic */ C2071f(AppViewFragment appViewFragment, Promotion promotion, WalletApp walletApp) {
        this.f5120a = appViewFragment;
        this.f5121b = promotion;
        this.f5122c = walletApp;
    }

    public final void onClick(View view) {
        this.f5120a.mo10460e(this.f5121b, this.f5122c, view);
    }
}
