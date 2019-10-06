package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.store.view.w */
/* compiled from: lambda */
public final /* synthetic */ class C5094w implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ BadgeDialogFactory f8804a;

    /* renamed from: b */
    private final /* synthetic */ Badge f8805b;

    /* renamed from: c */
    private final /* synthetic */ Resources f8806c;

    /* renamed from: d */
    private final /* synthetic */ View f8807d;

    /* renamed from: e */
    private final /* synthetic */ boolean f8808e;

    public /* synthetic */ C5094w(BadgeDialogFactory badgeDialogFactory, Badge badge, Resources resources, View view, boolean z) {
        this.f8804a = badgeDialogFactory;
        this.f8805b = badge;
        this.f8806c = resources;
        this.f8807d = view;
        this.f8808e = z;
    }

    public final void onClick(View view) {
        this.f8804a.mo16478d(this.f8805b, this.f8806c, this.f8807d, this.f8808e, view);
    }
}
