package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.store.c */
/* compiled from: lambda */
public final /* synthetic */ class C4930c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ GetStoreMeta f8573a;

    /* renamed from: b */
    private final /* synthetic */ AptoideAccountManager f8574b;

    /* renamed from: c */
    private final /* synthetic */ String f8575c;

    /* renamed from: d */
    private final /* synthetic */ String f8576d;

    public /* synthetic */ C4930c(GetStoreMeta getStoreMeta, AptoideAccountManager aptoideAccountManager, String str, String str2) {
        this.f8573a = getStoreMeta;
        this.f8574b = aptoideAccountManager;
        this.f8575c = str;
        this.f8576d = str2;
    }

    public final Object call(Object obj) {
        return StoreUtils.m9265a(this.f8573a, this.f8574b, this.f8575c, this.f8576d, (Account) obj);
    }
}
