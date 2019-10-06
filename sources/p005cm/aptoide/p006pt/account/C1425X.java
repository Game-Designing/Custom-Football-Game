package p005cm.aptoide.p006pt.account;

import com.facebook.AccessToken;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.account.X */
/* compiled from: lambda */
public final /* synthetic */ class C1425X implements Callable {

    /* renamed from: a */
    private final /* synthetic */ AccessToken f4341a;

    public /* synthetic */ C1425X(AccessToken accessToken) {
        this.f4341a = accessToken;
    }

    public final Object call() {
        return FacebookSignUpAdapter.m6218a(this.f4341a);
    }
}
