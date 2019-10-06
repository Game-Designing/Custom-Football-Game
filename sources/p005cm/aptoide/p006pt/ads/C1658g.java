package p005cm.aptoide.p006pt.ads;

import java.util.List;
import p005cm.aptoide.accountmanager.Account;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.ads.g */
/* compiled from: lambda */
public final /* synthetic */ class C1658g implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AdsRepository f4605a;

    /* renamed from: b */
    private final /* synthetic */ List f4606b;

    /* renamed from: c */
    private final /* synthetic */ String f4607c;

    public /* synthetic */ C1658g(AdsRepository adsRepository, List list, String str) {
        this.f4605a = adsRepository;
        this.f4606b = list;
        this.f4607c = str;
    }

    public final Object call(Object obj) {
        return this.f4605a.mo783a(this.f4606b, this.f4607c, (Account) obj);
    }
}
