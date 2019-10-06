package p005cm.aptoide.p006pt.networking;

import android.accounts.Account;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.networking.c */
/* compiled from: lambda */
public final /* synthetic */ class C4145c implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AuthenticationPersistence f7687a;

    /* renamed from: b */
    private final /* synthetic */ String f7688b;

    public /* synthetic */ C4145c(AuthenticationPersistence authenticationPersistence, String str) {
        this.f7687a = authenticationPersistence;
        this.f7688b = str;
    }

    public final void call(Object obj) {
        this.f7687a.mo2173a(this.f7688b, (Account) obj);
    }
}
