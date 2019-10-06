package p005cm.aptoide.p006pt.presenter;

import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateManager;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.presenter.a */
/* compiled from: lambda */
public final /* synthetic */ class C4342a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AutoUpdateManager f7938a;

    public /* synthetic */ C4342a(AutoUpdateManager autoUpdateManager) {
        this.f7938a = autoUpdateManager;
    }

    public final Object call(Object obj) {
        return this.f7938a.requestPermissions((PermissionService) obj);
    }
}
