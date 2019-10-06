package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.store.view.x */
/* compiled from: lambda */
public final /* synthetic */ class C5096x implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ BadgeDialogFactory f8811a;

    /* renamed from: b */
    private final /* synthetic */ Badge f8812b;

    /* renamed from: c */
    private final /* synthetic */ Resources f8813c;

    /* renamed from: d */
    private final /* synthetic */ View f8814d;

    /* renamed from: e */
    private final /* synthetic */ boolean f8815e;

    public /* synthetic */ C5096x(BadgeDialogFactory badgeDialogFactory, Badge badge, Resources resources, View view, boolean z) {
        this.f8811a = badgeDialogFactory;
        this.f8812b = badge;
        this.f8813c = resources;
        this.f8814d = view;
        this.f8815e = z;
    }

    public final void onClick(View view) {
        this.f8811a.mo16479e(this.f8812b, this.f8813c, this.f8814d, this.f8815e, view);
    }
}
