package p005cm.aptoide.p006pt.install;

import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;

/* renamed from: cm.aptoide.pt.install.Oa */
/* compiled from: lambda */
public final /* synthetic */ class C4004Oa implements Callable {

    /* renamed from: a */
    private final /* synthetic */ InstalledIntentService f7491a;

    /* renamed from: b */
    private final /* synthetic */ String f7492b;

    /* renamed from: c */
    private final /* synthetic */ StoredMinimalAd f7493c;

    /* renamed from: d */
    private final /* synthetic */ StoredMinimalAdAccessor f7494d;

    public /* synthetic */ C4004Oa(InstalledIntentService installedIntentService, String str, StoredMinimalAd storedMinimalAd, StoredMinimalAdAccessor storedMinimalAdAccessor) {
        this.f7491a = installedIntentService;
        this.f7492b = str;
        this.f7493c = storedMinimalAd;
        this.f7494d = storedMinimalAdAccessor;
    }

    public final Object call() {
        return this.f7491a.mo15052a(this.f7492b, this.f7493c, this.f7494d);
    }
}
