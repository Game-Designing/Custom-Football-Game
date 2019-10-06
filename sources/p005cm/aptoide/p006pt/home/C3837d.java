package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.home.d */
/* compiled from: lambda */
public final /* synthetic */ class C3837d implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AdInBundleViewHolder f7254a;

    /* renamed from: b */
    private final /* synthetic */ AdClick f7255b;

    /* renamed from: c */
    private final /* synthetic */ int f7256c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7257d;

    /* renamed from: e */
    private final /* synthetic */ int f7258e;

    public /* synthetic */ C3837d(AdInBundleViewHolder adInBundleViewHolder, AdClick adClick, int i, HomeBundle homeBundle, int i2) {
        this.f7254a = adInBundleViewHolder;
        this.f7255b = adClick;
        this.f7256c = i;
        this.f7257d = homeBundle;
        this.f7258e = i2;
    }

    public final void onClick(View view) {
        this.f7254a.mo14199a(this.f7255b, this.f7256c, this.f7257d, this.f7258e, view);
    }
}
