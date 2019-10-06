package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.me */
/* compiled from: lambda */
public final /* synthetic */ class C3896me implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ RewardAppInBundleViewHolder f7338a;

    /* renamed from: b */
    private final /* synthetic */ Application f7339b;

    /* renamed from: c */
    private final /* synthetic */ int f7340c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7341d;

    /* renamed from: e */
    private final /* synthetic */ int f7342e;

    public /* synthetic */ C3896me(RewardAppInBundleViewHolder rewardAppInBundleViewHolder, Application application, int i, HomeBundle homeBundle, int i2) {
        this.f7338a = rewardAppInBundleViewHolder;
        this.f7339b = application;
        this.f7340c = i;
        this.f7341d = homeBundle;
        this.f7342e = i2;
    }

    public final void onClick(View view) {
        this.f7338a.mo14562a(this.f7339b, this.f7340c, this.f7341d, this.f7342e, view);
    }
}
