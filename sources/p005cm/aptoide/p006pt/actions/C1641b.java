package p005cm.aptoide.p006pt.actions;

import p026rx.C14980ia;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.actions.b */
/* compiled from: lambda */
public final /* synthetic */ class C1641b implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ C14980ia f4589a;

    public /* synthetic */ C1641b(C14980ia iaVar) {
        this.f4589a = iaVar;
    }

    public final void call() {
        this.f4589a.onError(new SecurityException("Permission denied to access to external storage."));
    }
}
