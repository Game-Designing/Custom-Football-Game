package p005cm.aptoide.p006pt.wallet;

import kotlin.C14268b;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$showWalletInitialState$1 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$showWalletInitialState$1<T1, T2, R> implements C14541q<T1, T2, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallPresenter$showWalletInitialState$1 INSTANCE = new WalletInstallPresenter$showWalletInitialState$1();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2227080320672026637L, "cm/aptoide/pt/wallet/WalletInstallPresenter$showWalletInitialState$1", 4);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
    }

    WalletInstallPresenter$showWalletInitialState$1() {
        $jacocoInit()[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14268b call = call((String) obj, (WalletApp) obj2);
        $jacocoInit[0] = true;
        return call;
    }

    public final C14268b<String, WalletApp> call(String appIcon, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45913a((Object) walletApp, "walletApp");
        C14268b<String, WalletApp> bVar = new C14268b<>(appIcon, walletApp);
        $jacocoInit[1] = true;
        return bVar;
    }
}
