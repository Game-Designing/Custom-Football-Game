package p005cm.aptoide.p006pt.account;

import p005cm.aptoide.accountmanager.AccountService;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.Y */
/* compiled from: lambda */
public final /* synthetic */ class C1426Y implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AccountService f4342a;

    /* renamed from: b */
    private final /* synthetic */ FacebookLoginResult f4343b;

    public /* synthetic */ C1426Y(AccountService accountService, FacebookLoginResult facebookLoginResult) {
        this.f4342a = accountService;
        this.f4343b = facebookLoginResult;
    }

    public final Object call(Object obj) {
        return FacebookSignUpAdapter.m6216a(this.f4342a, this.f4343b, (String) obj);
    }
}
