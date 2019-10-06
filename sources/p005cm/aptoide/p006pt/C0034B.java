package p005cm.aptoide.p006pt;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.B */
/* compiled from: lambda */
public final /* synthetic */ class C0034B implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AptoideApplication f31a;

    /* renamed from: b */
    private final /* synthetic */ AptoideAccountManager f32b;

    public /* synthetic */ C0034B(AptoideApplication aptoideApplication, AptoideAccountManager aptoideAccountManager) {
        this.f31a = aptoideApplication;
        this.f32b = aptoideAccountManager;
    }

    public final Object call(Object obj) {
        return this.f31a.mo607a(this.f32b, (Account) obj);
    }
}
