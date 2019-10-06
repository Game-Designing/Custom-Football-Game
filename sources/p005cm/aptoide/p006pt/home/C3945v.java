package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.view.app.FeatureGraphicApplication;

/* renamed from: cm.aptoide.pt.home.v */
/* compiled from: lambda */
public final /* synthetic */ class C3945v implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ FeatureGraphicInBundleViewHolder f7421a;

    /* renamed from: b */
    private final /* synthetic */ FeatureGraphicApplication f7422b;

    /* renamed from: c */
    private final /* synthetic */ int f7423c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7424d;

    /* renamed from: e */
    private final /* synthetic */ int f7425e;

    public /* synthetic */ C3945v(FeatureGraphicInBundleViewHolder featureGraphicInBundleViewHolder, FeatureGraphicApplication featureGraphicApplication, int i, HomeBundle homeBundle, int i2) {
        this.f7421a = featureGraphicInBundleViewHolder;
        this.f7422b = featureGraphicApplication;
        this.f7423c = i;
        this.f7424d = homeBundle;
        this.f7425e = i2;
    }

    public final void onClick(View view) {
        this.f7421a.mo14269a(this.f7422b, this.f7423c, this.f7424d, this.f7425e, view);
    }
}
