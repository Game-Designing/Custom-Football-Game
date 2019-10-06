package p005cm.aptoide.p006pt.networking;

import android.accounts.Account;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.networking.b */
/* compiled from: lambda */
public final /* synthetic */ class C4144b implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AuthenticationPersistence f7682a;

    /* renamed from: b */
    private final /* synthetic */ String f7683b;

    /* renamed from: c */
    private final /* synthetic */ String f7684c;

    /* renamed from: d */
    private final /* synthetic */ String f7685d;

    /* renamed from: e */
    private final /* synthetic */ String f7686e;

    public /* synthetic */ C4144b(AuthenticationPersistence authenticationPersistence, String str, String str2, String str3, String str4) {
        this.f7682a = authenticationPersistence;
        this.f7683b = str;
        this.f7684c = str2;
        this.f7685d = str3;
        this.f7686e = str4;
    }

    public final void call(Object obj) {
        this.f7682a.mo2174a(this.f7683b, this.f7684c, this.f7685d, this.f7686e, (Account) obj);
    }
}
