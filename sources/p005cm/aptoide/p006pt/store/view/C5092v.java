package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.store.view.v */
/* compiled from: lambda */
public final /* synthetic */ class C5092v implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ BadgeDialogFactory f8798a;

    /* renamed from: b */
    private final /* synthetic */ Badge f8799b;

    /* renamed from: c */
    private final /* synthetic */ Resources f8800c;

    /* renamed from: d */
    private final /* synthetic */ View f8801d;

    /* renamed from: e */
    private final /* synthetic */ boolean f8802e;

    public /* synthetic */ C5092v(BadgeDialogFactory badgeDialogFactory, Badge badge, Resources resources, View view, boolean z) {
        this.f8798a = badgeDialogFactory;
        this.f8799b = badge;
        this.f8800c = resources;
        this.f8801d = view;
        this.f8802e = z;
    }

    public final void onClick(View view) {
        this.f8798a.mo16476c(this.f8799b, this.f8800c, this.f8801d, this.f8802e, view);
    }
}
