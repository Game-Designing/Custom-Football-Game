package p005cm.aptoide.p006pt.networking;

import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.networking.g */
/* compiled from: lambda */
public final /* synthetic */ class C4149g implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ MultipartBodyInterceptor f7694a;

    /* renamed from: b */
    private final /* synthetic */ HashMapNotNull f7695b;

    public /* synthetic */ C4149g(MultipartBodyInterceptor multipartBodyInterceptor, HashMapNotNull hashMapNotNull) {
        this.f7694a = multipartBodyInterceptor;
        this.f7695b = hashMapNotNull;
    }

    public final Object call(Object obj) {
        return this.f7694a.mo15224a(this.f7695b, (Authentication) obj);
    }
}
