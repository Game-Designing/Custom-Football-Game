package p005cm.aptoide.p006pt.install;

import p005cm.aptoide.p006pt.packageinstaller.InstallStatus.Status;

/* renamed from: cm.aptoide.pt.install.InstallerAnalytics */
public interface InstallerAnalytics {
    void installationType(boolean z, boolean z2);

    void logInstallCancelEvent(String str, int i);

    void logInstallErrorEvent(String str, int i, Exception exc);

    void rootInstallCancelled();

    void rootInstallCompleted(int i);

    void rootInstallFail(Exception exc);

    void rootInstallStart();

    void rootInstallTimeout();

    void sendMiuiInstallResultEvent(Status status);
}
