package p005cm.aptoide.p006pt.actions;

import p026rx.C14980ia;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.actions.d */
/* compiled from: lambda */
public final /* synthetic */ class C1643d implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ C14980ia f4591a;

    public /* synthetic */ C1643d(C14980ia iaVar) {
        this.f4591a = iaVar;
    }

    public final void call() {
        this.f4591a.onError(new SecurityException("Permission denied to download file"));
    }
}
