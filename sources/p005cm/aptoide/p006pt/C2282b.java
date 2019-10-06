package p005cm.aptoide.p006pt;

import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.packageinstaller.InstallResultCallback;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus;

/* renamed from: cm.aptoide.pt.b */
/* compiled from: lambda */
public final /* synthetic */ class C2282b implements InstallResultCallback {

    /* renamed from: a */
    private final /* synthetic */ AppInstallerStatusReceiver f5355a;

    public /* synthetic */ C2282b(AppInstallerStatusReceiver appInstallerStatusReceiver) {
        this.f5355a = appInstallerStatusReceiver;
    }

    public final void onInstallationResult(InstallStatus installStatus) {
        ApplicationModule.m87a(this.f5355a, installStatus);
    }
}
