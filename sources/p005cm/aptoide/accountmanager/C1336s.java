package p005cm.aptoide.accountmanager;

import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.accountmanager.s */
/* compiled from: lambda */
public final /* synthetic */ class C1336s implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AccountService f4230a;

    /* renamed from: b */
    private final /* synthetic */ AptoideCredentials f4231b;

    public /* synthetic */ C1336s(AccountService accountService, AptoideCredentials aptoideCredentials) {
        this.f4230a = accountService;
        this.f4231b = aptoideCredentials;
    }

    public final Object call(Object obj) {
        return AptoideSignUpAdapter.m6125a(this.f4230a, this.f4231b, (Throwable) obj);
    }
}
