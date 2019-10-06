package p005cm.aptoide.p006pt.account;

import android.accounts.Account;
import java.util.Date;
import java.util.List;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.I */
/* compiled from: lambda */
public final /* synthetic */ class C1411I implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AndroidAccountManagerPersistence f4314a;

    /* renamed from: b */
    private final /* synthetic */ String f4315b;

    /* renamed from: c */
    private final /* synthetic */ Account f4316c;

    /* renamed from: d */
    private final /* synthetic */ boolean f4317d;

    /* renamed from: e */
    private final /* synthetic */ boolean f4318e;

    /* renamed from: f */
    private final /* synthetic */ Date f4319f;

    public /* synthetic */ C1411I(AndroidAccountManagerPersistence androidAccountManagerPersistence, String str, Account account, boolean z, boolean z2, Date date) {
        this.f4314a = androidAccountManagerPersistence;
        this.f4315b = str;
        this.f4316c = account;
        this.f4317d = z;
        this.f4318e = z2;
        this.f4319f = date;
    }

    public final Object call(Object obj) {
        return this.f4314a.mo9598a(this.f4315b, this.f4316c, this.f4317d, this.f4318e, this.f4319f, (List) obj);
    }
}
