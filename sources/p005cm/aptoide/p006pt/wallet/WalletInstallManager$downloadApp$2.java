package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.C0117M;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$downloadApp$2 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$downloadApp$2<T, R> implements C0132p<Download, C0117M> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1692411646196305261L, "cm/aptoide/pt/wallet/WalletInstallManager$downloadApp$2", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallManager$downloadApp$2(WalletInstallManager walletInstallManager) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallManager;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M call = call((Download) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0117M call(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M splitInstall = this.this$0.getInstallManager().splitInstall(download);
        $jacocoInit[1] = true;
        return splitInstall;
    }
}
