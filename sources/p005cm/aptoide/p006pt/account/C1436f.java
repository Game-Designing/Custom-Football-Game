package p005cm.aptoide.p006pt.account;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.OAuth;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.f */
/* compiled from: lambda */
public final /* synthetic */ class C1436f implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AccountServiceV3 f4355a;

    /* renamed from: b */
    private final /* synthetic */ String f4356b;

    /* renamed from: c */
    private final /* synthetic */ String f4357c;

    /* renamed from: d */
    private final /* synthetic */ String f4358d;

    public /* synthetic */ C1436f(AccountServiceV3 accountServiceV3, String str, String str2, String str3) {
        this.f4355a = accountServiceV3;
        this.f4356b = str;
        this.f4357c = str2;
        this.f4358d = str3;
    }

    public final Object call(Object obj) {
        return this.f4355a.mo9584a(this.f4356b, this.f4357c, this.f4358d, (OAuth) obj);
    }
}
