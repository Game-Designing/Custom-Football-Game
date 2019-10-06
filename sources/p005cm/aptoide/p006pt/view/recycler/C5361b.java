package p005cm.aptoide.p006pt.view.recycler;

import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.view.recycler.b */
/* compiled from: lambda */
public final /* synthetic */ class C5361b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ BaseAdapter f9160a;

    /* renamed from: b */
    private final /* synthetic */ int f9161b;

    /* renamed from: c */
    private final /* synthetic */ Displayable f9162c;

    public /* synthetic */ C5361b(BaseAdapter baseAdapter, int i, Displayable displayable) {
        this.f9160a = baseAdapter;
        this.f9161b = i;
        this.f9162c = displayable;
    }

    public final void run() {
        this.f9160a.mo17261a(this.f9161b, this.f9162c);
    }
}
