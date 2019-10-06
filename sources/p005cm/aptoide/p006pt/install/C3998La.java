package p005cm.aptoide.p006pt.install;

import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.install.La */
/* compiled from: lambda */
public final /* synthetic */ class C3998La implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ InstalledIntentService f7482a;

    /* renamed from: b */
    private final /* synthetic */ String f7483b;

    /* renamed from: c */
    private final /* synthetic */ StoredMinimalAdAccessor f7484c;

    public /* synthetic */ C3998La(InstalledIntentService installedIntentService, String str, StoredMinimalAdAccessor storedMinimalAdAccessor) {
        this.f7482a = installedIntentService;
        this.f7483b = str;
        this.f7484c = storedMinimalAdAccessor;
    }

    public final Object call(Object obj) {
        return this.f7482a.mo15053a(this.f7483b, this.f7484c, (StoredMinimalAd) obj);
    }
}
