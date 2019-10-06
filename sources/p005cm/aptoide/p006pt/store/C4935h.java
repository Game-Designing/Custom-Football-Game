package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.store.h */
/* compiled from: lambda */
public final /* synthetic */ class C4935h implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AptoideAccountManager f8585a;

    /* renamed from: b */
    private final /* synthetic */ StoreCredentials f8586b;

    public /* synthetic */ C4935h(AptoideAccountManager aptoideAccountManager, StoreCredentials storeCredentials) {
        this.f8585a = aptoideAccountManager;
        this.f8586b = storeCredentials;
    }

    public final Object call(Object obj) {
        return StoreUtilsProxy.m498a(this.f8585a, this.f8586b, (GetStoreMeta) obj);
    }
}
