package p005cm.aptoide.p006pt.billing.sync;

import p005cm.aptoide.p006pt.billing.authorization.MetadataAuthorization;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.sync.a */
/* compiled from: lambda */
public final /* synthetic */ class C2370a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationSync f5523a;

    /* renamed from: b */
    private final /* synthetic */ String f5524b;

    public /* synthetic */ C2370a(AuthorizationSync authorizationSync, String str) {
        this.f5523a = authorizationSync;
        this.f5524b = str;
    }

    public final Object call(Object obj) {
        return this.f5523a.mo11241a(this.f5524b, (MetadataAuthorization) obj);
    }
}
