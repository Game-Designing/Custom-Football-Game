package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.h */
/* compiled from: lambda */
public final /* synthetic */ class C3861h implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppInBundleViewHolder f7287a;

    /* renamed from: b */
    private final /* synthetic */ Application f7288b;

    /* renamed from: c */
    private final /* synthetic */ int f7289c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7290d;

    /* renamed from: e */
    private final /* synthetic */ int f7291e;

    public /* synthetic */ C3861h(AppInBundleViewHolder appInBundleViewHolder, Application application, int i, HomeBundle homeBundle, int i2) {
        this.f7287a = appInBundleViewHolder;
        this.f7288b = application;
        this.f7289c = i;
        this.f7290d = homeBundle;
        this.f7291e = i2;
    }

    public final void onClick(View view) {
        this.f7287a.mo14214a(this.f7288b, this.f7289c, this.f7290d, this.f7291e, view);
    }
}
