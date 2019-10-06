package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.store.view.s */
/* compiled from: lambda */
public final /* synthetic */ class C5083s implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ BadgeDialogFactory f8778a;

    /* renamed from: b */
    private final /* synthetic */ Badge f8779b;

    /* renamed from: c */
    private final /* synthetic */ Resources f8780c;

    /* renamed from: d */
    private final /* synthetic */ View f8781d;

    /* renamed from: e */
    private final /* synthetic */ boolean f8782e;

    public /* synthetic */ C5083s(BadgeDialogFactory badgeDialogFactory, Badge badge, Resources resources, View view, boolean z) {
        this.f8778a = badgeDialogFactory;
        this.f8779b = badge;
        this.f8780c = resources;
        this.f8781d = view;
        this.f8782e = z;
    }

    public final void onClick(View view) {
        this.f8778a.mo16475b(this.f8779b, this.f8780c, this.f8781d, this.f8782e, view);
    }
}
