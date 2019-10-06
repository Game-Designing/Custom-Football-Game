package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallActivity$showRootInstallWarningPopup$1 */
/* compiled from: WalletInstallActivity.kt */
final class WalletInstallActivity$showRootInstallWarningPopup$1<T, R> implements C0132p<T, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallActivity$showRootInstallWarningPopup$1 INSTANCE = new WalletInstallActivity$showRootInstallWarningPopup$1();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1417363169534961723L, "cm/aptoide/pt/wallet/WalletInstallActivity$showRootInstallWarningPopup$1", 4);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
    }

    WalletInstallActivity$showRootInstallWarningPopup$1() {
        $jacocoInit()[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(call((EResponse) obj));
        $jacocoInit[0] = true;
        return valueOf;
    }

    public final boolean call(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = response.equals(EResponse.YES);
        $jacocoInit[1] = true;
        return equals;
    }
}
