package p005cm.aptoide.p006pt.install;

import android.content.Context;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.install.xa */
/* compiled from: lambda */
public final /* synthetic */ class C4132xa implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ InstallService f7665a;

    /* renamed from: b */
    private final /* synthetic */ Context f7666b;

    /* renamed from: c */
    private final /* synthetic */ boolean f7667c;

    /* renamed from: d */
    private final /* synthetic */ boolean f7668d;

    public /* synthetic */ C4132xa(InstallService installService, Context context, boolean z, boolean z2) {
        this.f7665a = installService;
        this.f7666b = context;
        this.f7667c = z;
        this.f7668d = z2;
    }

    public final Object call(Object obj) {
        return this.f7665a.mo15037b(this.f7666b, this.f7667c, this.f7668d, (Download) obj);
    }
}
