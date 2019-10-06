package p005cm.aptoide.p006pt.wallet;

import android.content.pm.PackageInfo;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$getAppIcon$1 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$getAppIcon$1<V> implements Callable<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9046994029593613197L, "cm/aptoide/pt/wallet/WalletInstallManager$getAppIcon$1", 4);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallManager$getAppIcon$1(WalletInstallManager walletInstallManager) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallManager;
        $jacocoInit[3] = true;
    }

    public final String call() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageInfo packageInfo = this.this$0.getPackageManager().getPackageInfo(this.this$0.getConfiguration().getAppPackageName(), 0);
        $jacocoInit[1] = true;
        String apkIconPath = SystemU.getApkIconPath(packageInfo);
        $jacocoInit[2] = true;
        return apkIconPath;
    }
}
