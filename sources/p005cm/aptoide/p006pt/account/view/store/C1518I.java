package p005cm.aptoide.p006pt.account.view.store;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.view.store.I */
/* compiled from: lambda */
public final /* synthetic */ class C1518I implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ StoreManager f4442a;

    /* renamed from: b */
    private final /* synthetic */ String f4443b;

    /* renamed from: c */
    private final /* synthetic */ String f4444c;

    /* renamed from: d */
    private final /* synthetic */ boolean f4445d;

    /* renamed from: e */
    private final /* synthetic */ String f4446e;

    /* renamed from: f */
    private final /* synthetic */ String f4447f;

    /* renamed from: g */
    private final /* synthetic */ List f4448g;

    /* renamed from: h */
    private final /* synthetic */ List f4449h;

    public /* synthetic */ C1518I(StoreManager storeManager, String str, String str2, boolean z, String str3, String str4, List list, List list2) {
        this.f4442a = storeManager;
        this.f4443b = str;
        this.f4444c = str2;
        this.f4445d = z;
        this.f4446e = str3;
        this.f4447f = str4;
        this.f4448g = list;
        this.f4449h = list2;
    }

    public final Object call(Object obj) {
        return this.f4442a.mo9853a(this.f4443b, this.f4444c, this.f4445d, this.f4446e, this.f4447f, this.f4448g, this.f4449h, (CheckUserCredentialsJson) obj);
    }
}
