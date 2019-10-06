package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.install.Install;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$loadDownloadModel$1 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$loadDownloadModel$1<T, R> implements C0132p<T, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5201360910251672840L, "cm/aptoide/pt/wallet/WalletInstallManager$loadDownloadModel$1", 5);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallManager$loadDownloadModel$1(WalletInstallManager walletInstallManager) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallManager;
        $jacocoInit[4] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel call = call((Install) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final DownloadModel call(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser = this.this$0.getDownloadStateParser();
        C14281f.m45913a((Object) install, "install");
        Action parseDownloadType = downloadStateParser.parseDownloadType(install.getType(), false, false, false);
        $jacocoInit[1] = true;
        int progress = install.getProgress();
        DownloadState parseDownloadState = this.this$0.getDownloadStateParser().parseDownloadState(install.getState());
        $jacocoInit[2] = true;
        DownloadModel downloadModel = new DownloadModel(parseDownloadType, progress, parseDownloadState, null);
        $jacocoInit[3] = true;
        return downloadModel;
    }
}
