package p005cm.aptoide.p006pt.store.view;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.store.view.ba */
/* compiled from: lambda */
public final /* synthetic */ class C4983ba implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ GridStoreMetaWidget f8646a;

    /* renamed from: b */
    private final /* synthetic */ Badge f8647b;

    /* renamed from: c */
    private final /* synthetic */ boolean f8648c;

    public /* synthetic */ C4983ba(GridStoreMetaWidget gridStoreMetaWidget, Badge badge, boolean z) {
        this.f8646a = gridStoreMetaWidget;
        this.f8647b = badge;
        this.f8648c = z;
    }

    public final void onClick(View view) {
        this.f8646a.mo16537a(this.f8647b, this.f8648c, view);
    }
}
