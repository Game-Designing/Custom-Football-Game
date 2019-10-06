package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.g */
/* compiled from: lambda */
public final /* synthetic */ class C4934g implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AptoideAccountManager f8581a;

    /* renamed from: b */
    private final /* synthetic */ String f8582b;

    /* renamed from: c */
    private final /* synthetic */ StoreCredentialsProvider f8583c;

    /* renamed from: d */
    private final /* synthetic */ StoreAccessor f8584d;

    public /* synthetic */ C4934g(AptoideAccountManager aptoideAccountManager, String str, StoreCredentialsProvider storeCredentialsProvider, StoreAccessor storeAccessor) {
        this.f8581a = aptoideAccountManager;
        this.f8582b = str;
        this.f8583c = storeCredentialsProvider;
        this.f8584d = storeAccessor;
    }

    public final void call(Object obj) {
        StoreUtils.m9266a(this.f8581a, this.f8582b, this.f8583c, this.f8584d, (Boolean) obj);
    }
}
