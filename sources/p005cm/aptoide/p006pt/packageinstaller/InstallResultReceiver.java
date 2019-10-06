package p005cm.aptoide.p006pt.packageinstaller;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus.Status;

/* renamed from: cm.aptoide.pt.packageinstaller.InstallResultReceiver */
class InstallResultReceiver extends BroadcastReceiver {
    private final PackageInstallerResultCallback packageInstallerResultCallback;

    public InstallResultReceiver(PackageInstallerResultCallback packageInstallerResultCallback2) {
        this.packageInstallerResultCallback = packageInstallerResultCallback2;
    }

    @TargetApi(21)
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if ("install_session_api_complete".equals(intent.getAction())) {
                int status = extras.getInt("android.content.pm.extra.STATUS");
                String message = extras.getString("android.content.pm.extra.STATUS_MESSAGE");
                String packageName = extras.getString("android.content.pm.extra.PACKAGE_NAME");
                String str = ", ";
                String str2 = "Install failed ";
                switch (status) {
                    case -1:
                        this.packageInstallerResultCallback.onPendingUserAction(extras);
                        return;
                    case 0:
                        this.packageInstallerResultCallback.onInstallationResult(new InstallStatus(Status.SUCCESS, "Install succeeded", packageName));
                        return;
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        PackageInstallerResultCallback packageInstallerResultCallback2 = this.packageInstallerResultCallback;
                        Status status2 = Status.FAIL;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(status);
                        sb.append(str);
                        sb.append(message);
                        packageInstallerResultCallback2.onInstallationResult(new InstallStatus(status2, sb.toString(), packageName));
                        return;
                    case 3:
                        PackageInstallerResultCallback packageInstallerResultCallback3 = this.packageInstallerResultCallback;
                        Status status3 = Status.CANCELED;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(status);
                        sb2.append(str);
                        sb2.append(message);
                        packageInstallerResultCallback3.onInstallationResult(new InstallStatus(status3, sb2.toString(), packageName));
                        break;
                }
                this.packageInstallerResultCallback.onInstallationResult(new InstallStatus(Status.UNKNOWN_ERROR, "Unrecognized status received from installer", packageName));
            }
        }
    }
}
