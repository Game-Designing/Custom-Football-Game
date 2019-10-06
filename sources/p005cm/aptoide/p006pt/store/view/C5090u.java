package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.store.view.u */
/* compiled from: lambda */
public final /* synthetic */ class C5090u implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ BadgeDialogFactory f8792a;

    /* renamed from: b */
    private final /* synthetic */ Badge f8793b;

    /* renamed from: c */
    private final /* synthetic */ Resources f8794c;

    /* renamed from: d */
    private final /* synthetic */ View f8795d;

    /* renamed from: e */
    private final /* synthetic */ boolean f8796e;

    public /* synthetic */ C5090u(BadgeDialogFactory badgeDialogFactory, Badge badge, Resources resources, View view, boolean z) {
        this.f8792a = badgeDialogFactory;
        this.f8793b = badge;
        this.f8794c = resources;
        this.f8795d = view;
        this.f8796e = z;
    }

    public final void onClick(View view) {
        this.f8792a.mo16474a(this.f8793b, this.f8794c, this.f8795d, this.f8796e, view);
    }
}
