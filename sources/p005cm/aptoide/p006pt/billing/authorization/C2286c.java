package p005cm.aptoide.p006pt.billing.authorization;

import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.authorization.c */
/* compiled from: lambda */
public final /* synthetic */ class C2286c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationRepository f5363a;

    /* renamed from: b */
    private final /* synthetic */ String f5364b;

    /* renamed from: c */
    private final /* synthetic */ Status f5365c;

    public /* synthetic */ C2286c(AuthorizationRepository authorizationRepository, String str, Status status) {
        this.f5363a = authorizationRepository;
        this.f5364b = str;
        this.f5365c = status;
    }

    public final Object call(Object obj) {
        return this.f5363a.mo11120a(this.f5364b, this.f5365c, (String) obj);
    }
}
