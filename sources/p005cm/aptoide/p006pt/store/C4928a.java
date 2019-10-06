package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.store.a */
/* compiled from: lambda */
public final /* synthetic */ class C4928a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AptoideAccountManager f8569a;

    /* renamed from: b */
    private final /* synthetic */ String f8570b;

    /* renamed from: c */
    private final /* synthetic */ String f8571c;

    public /* synthetic */ C4928a(AptoideAccountManager aptoideAccountManager, String str, String str2) {
        this.f8569a = aptoideAccountManager;
        this.f8570b = str;
        this.f8571c = str2;
    }

    public final Object call(Object obj) {
        return StoreUtils.m9264a(this.f8569a, this.f8570b, this.f8571c, (GetStoreMeta) obj);
    }
}
