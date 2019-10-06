package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.oe */
/* compiled from: lambda */
public final /* synthetic */ class C3908oe implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ TopAppViewHolder f7355a;

    /* renamed from: b */
    private final /* synthetic */ Application f7356b;

    /* renamed from: c */
    private final /* synthetic */ int f7357c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7358d;

    /* renamed from: e */
    private final /* synthetic */ int f7359e;

    public /* synthetic */ C3908oe(TopAppViewHolder topAppViewHolder, Application application, int i, HomeBundle homeBundle, int i2) {
        this.f7355a = topAppViewHolder;
        this.f7356b = application;
        this.f7357c = i;
        this.f7358d = homeBundle;
        this.f7359e = i2;
    }

    public final void onClick(View view) {
        this.f7355a.mo14563a(this.f7356b, this.f7357c, this.f7358d, this.f7359e, view);
    }
}
