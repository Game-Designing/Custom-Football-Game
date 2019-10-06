package p005cm.aptoide.p006pt.account;

import android.accounts.Account;
import java.util.Date;
import java.util.List;
import p005cm.aptoide.p006pt.networking.Authentication;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.K */
/* compiled from: lambda */
public final /* synthetic */ class C1413K implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AndroidAccountManagerPersistence f4321a;

    /* renamed from: b */
    private final /* synthetic */ String f4322b;

    /* renamed from: c */
    private final /* synthetic */ List f4323c;

    /* renamed from: d */
    private final /* synthetic */ Account f4324d;

    /* renamed from: e */
    private final /* synthetic */ boolean f4325e;

    /* renamed from: f */
    private final /* synthetic */ boolean f4326f;

    /* renamed from: g */
    private final /* synthetic */ Date f4327g;

    public /* synthetic */ C1413K(AndroidAccountManagerPersistence androidAccountManagerPersistence, String str, List list, Account account, boolean z, boolean z2, Date date) {
        this.f4321a = androidAccountManagerPersistence;
        this.f4322b = str;
        this.f4323c = list;
        this.f4324d = account;
        this.f4325e = z;
        this.f4326f = z2;
        this.f4327g = date;
    }

    public final Object call(Object obj) {
        return this.f4321a.mo9599a(this.f4322b, this.f4323c, this.f4324d, this.f4325e, this.f4326f, this.f4327g, (Authentication) obj);
    }
}
