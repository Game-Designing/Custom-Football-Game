package p005cm.aptoide.p006pt.packageinstaller;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.Session;
import android.content.pm.PackageInstaller.SessionParams;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus.Status;

/* renamed from: cm.aptoide.pt.packageinstaller.AppInstaller */
public final class AppInstaller {
    static final String INSTALL_SESSION_API_COMPLETE_ACTION = "install_session_api_complete";
    private static final int REQUEST_INSTALL = 22;
    private static final int SESSION_INSTALL_REQUEST_CODE = 18;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final InstallResultCallback installResultCallback;

    public AppInstaller(Context context2, InstallResultCallback installResultCallback2) {
        this.context = context2;
        this.installResultCallback = installResultCallback2;
        registerInstallResultBroadcastReceiver();
    }

    public void install(File file, String packageName) {
        if (VERSION.SDK_INT >= 21) {
            installWithPackageInstaller(file, packageName);
        } else {
            installWithActionInstallPackageIntent(file, packageName);
        }
    }

    private void installWithPackageInstaller(File file, String packageName) {
        Session session = null;
        try {
            PackageInstaller packageInstaller = this.context.getPackageManager().getPackageInstaller();
            session = packageInstaller.openSession(packageInstaller.createSession(new SessionParams(1)));
            addApkToInstallSession(file, session);
            session.commit(PendingIntent.getBroadcast(this.context, 18, new Intent(INSTALL_SESSION_API_COMPLETE_ACTION), 0).getIntentSender());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't install package", e);
        } catch (RuntimeException e2) {
            if (session != null) {
                session.abandon();
            }
            this.installResultCallback.onInstallationResult(new InstallStatus(Status.UNKNOWN_ERROR, e2.getMessage(), packageName));
        }
    }

    private void installWithActionInstallPackageIntent(File file, String packageName) {
        Intent promptInstall = new Intent("android.intent.action.INSTALL_PACKAGE");
        promptInstall.putExtra("android.intent.extra.RETURN_RESULT", true);
        promptInstall.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", this.context.getApplicationContext().getPackageName());
        promptInstall.setData(Uri.fromFile(file));
        promptInstall.setFlags(1);
        promptInstall.setFlags(276824064);
        this.installResultCallback.onInstallationResult(new InstallStatus(Status.INSTALLING, "Installing...", packageName));
        this.context.startActivity(promptInstall);
    }

    private void registerInstallResultBroadcastReceiver() {
        this.context.registerReceiver(new InstallResultReceiver(new PackageInstallerResultCallback() {
            public void onInstallationResult(InstallStatus installStatus) {
                AppInstaller.this.installResultCallback.onInstallationResult(installStatus);
            }

            public void onPendingUserAction(Bundle extras) {
                Intent confirmIntent = (Intent) extras.get("android.intent.extra.INTENT");
                if (confirmIntent != null) {
                    confirmIntent.setFlags(276824064);
                }
                try {
                    AppInstaller.this.context.startActivity(confirmIntent);
                } catch (ActivityNotFoundException e) {
                    AppInstaller.this.installResultCallback.onInstallationResult(new InstallStatus(Status.FAIL, "Context - Activity Not Found", "n/a"));
                }
            }
        }), new IntentFilter(INSTALL_SESSION_API_COMPLETE_ACTION), null, null);
    }

    private void addApkToInstallSession(File file, Session session) {
        try {
            OutputStream packageInSession = session.openWrite("apk-id", 0, file.length());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[Opcodes.ACC_ENUM];
            while (true) {
                int read = fileInputStream.read(buffer);
                int n = read;
                if (read >= 0) {
                    packageInSession.write(buffer, 0, n);
                } else {
                    session.fsync(packageInSession);
                    packageInSession.close();
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int requestCode, int resultCode) {
        if (requestCode == 22) {
            String str = "n/a";
            if (resultCode == -1) {
                this.installResultCallback.onInstallationResult(new InstallStatus(Status.SUCCESS, "Install succeeded", str));
            } else if (resultCode == 0) {
                this.installResultCallback.onInstallationResult(new InstallStatus(Status.CANCELED, "Install canceled", str));
            } else {
                this.installResultCallback.onInstallationResult(new InstallStatus(Status.FAIL, "Install failed", str));
            }
        }
    }
}
