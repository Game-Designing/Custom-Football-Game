package p005cm.aptoide.p006pt.billing.authorization;

import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.authorization.f */
/* compiled from: lambda */
public final /* synthetic */ class C2289f implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationRepository f5370a;

    /* renamed from: b */
    private final /* synthetic */ String f5371b;

    /* renamed from: c */
    private final /* synthetic */ Status f5372c;

    /* renamed from: d */
    private final /* synthetic */ String f5373d;

    public /* synthetic */ C2289f(AuthorizationRepository authorizationRepository, String str, Status status, String str2) {
        this.f5370a = authorizationRepository;
        this.f5371b = str;
        this.f5372c = status;
        this.f5373d = str2;
    }

    public final Object call(Object obj) {
        return this.f5370a.mo11121a(this.f5371b, this.f5372c, this.f5373d, (String) obj);
    }
}
