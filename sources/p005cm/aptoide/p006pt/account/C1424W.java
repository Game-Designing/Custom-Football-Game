package p005cm.aptoide.p006pt.account;

import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.account.W */
/* compiled from: lambda */
public final /* synthetic */ class C1424W implements Callable {

    /* renamed from: a */
    private final /* synthetic */ FacebookLoginResult f4340a;

    public /* synthetic */ C1424W(FacebookLoginResult facebookLoginResult) {
        this.f4340a = facebookLoginResult;
    }

    public final Object call() {
        return FacebookSignUpAdapter.m6217a(this.f4340a);
    }
}
