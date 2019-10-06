package p005cm.aptoide.p006pt.install.installer;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.RemoteException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p045b.p046a.C1155a.C1156a;
import p005cm.aptoide.p006pt.install.exception.InstallationException;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;

/* renamed from: cm.aptoide.pt.install.installer.SystemInstallOnSubscribe */
public class SystemInstallOnSubscribe implements C0122a<Void> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int INSTALL_REPLACE_EXISTING = 2;
    private static final int INSTALL_SUCCEEDED = 1;
    private final Context context;
    private final PackageManager packageManager;
    private final Uri packageUri;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(573798938671152026L, "cm/aptoide/pt/install/installer/SystemInstallOnSubscribe", 22);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14980ia) obj);
        $jacocoInit[21] = true;
    }

    public SystemInstallOnSubscribe(Context context2, PackageManager packageManager2, Uri packageUri2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.packageManager = packageManager2;
        this.packageUri = packageUri2;
        $jacocoInit[0] = true;
    }

    public void call(final C14980ia<? super Void> subscriber) {
        $jacocoInit();
        new C1156a(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SystemInstallOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6617151793451508800L, "cm/aptoide/pt/install/installer/SystemInstallOnSubscribe$1", 10);
                $jacocoData = probes;
                return probes;
            }

            {
                $jacocoInit();
                this.this$0 = this$0;
                throw null;
            }

            public void packageInstalled(String packageName, int returnCode) throws RemoteException {
                boolean[] $jacocoInit = $jacocoInit();
                if (returnCode == 1) {
                    $jacocoInit[1] = true;
                    if (subscriber.isUnsubscribed()) {
                        $jacocoInit[2] = true;
                    } else {
                        $jacocoInit[3] = true;
                        subscriber.onNext(null);
                        $jacocoInit[4] = true;
                        subscriber.onCompleted();
                        $jacocoInit[5] = true;
                    }
                } else if (subscriber.isUnsubscribed()) {
                    $jacocoInit[6] = true;
                } else {
                    $jacocoInit[7] = true;
                    C14980ia iaVar = subscriber;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Package not installed with error code: ");
                    sb.append(returnCode);
                    iaVar.onError(new InstallationException(sb.toString()));
                    $jacocoInit[8] = true;
                }
                $jacocoInit[9] = true;
            }
        };
        throw null;
    }

    private boolean isSystem(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            boolean z = false;
            if ((this.packageManager.getApplicationInfo(context2.getPackageName(), 0).flags & 1) == 1) {
                $jacocoInit[16] = true;
                z = true;
            } else {
                $jacocoInit[17] = true;
            }
            $jacocoInit[18] = true;
            return z;
        } catch (NameNotFoundException e) {
            $jacocoInit[19] = true;
            AssertionError assertionError = new AssertionError("Aptoide application not found by package manager.");
            $jacocoInit[20] = true;
            throw assertionError;
        }
    }
}
