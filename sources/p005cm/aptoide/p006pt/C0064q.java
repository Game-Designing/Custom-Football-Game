package p005cm.aptoide.p006pt;

import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.q */
/* compiled from: lambda */
public final /* synthetic */ class C0064q implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AptoideApplication f73a;

    /* renamed from: b */
    private final /* synthetic */ StoreCredentialsProviderImpl f74b;

    /* renamed from: c */
    private final /* synthetic */ StoreUtilsProxy f75c;

    public /* synthetic */ C0064q(AptoideApplication aptoideApplication, StoreCredentialsProviderImpl storeCredentialsProviderImpl, StoreUtilsProxy storeUtilsProxy) {
        this.f73a = aptoideApplication;
        this.f74b = storeCredentialsProviderImpl;
        this.f75c = storeUtilsProxy;
    }

    public final Object call(Object obj) {
        return this.f73a.mo608a(this.f74b, this.f75c, (String) obj);
    }
}
