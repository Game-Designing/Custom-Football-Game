package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletAppProvider$getWalletApp$1 */
/* compiled from: WalletAppProvider.kt */
final class WalletAppProvider$getWalletApp$1<T, R> implements C0132p<T, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletAppProvider this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5216881759044078394L, "cm/aptoide/pt/wallet/WalletAppProvider$getWalletApp$1", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletAppProvider$getWalletApp$1(WalletAppProvider walletAppProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletAppProvider;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp call = call((DetailedAppRequestResult) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final WalletApp call(DetailedAppRequestResult app) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAppProvider walletAppProvider = this.this$0;
        C14281f.m45913a((Object) app, "app");
        WalletApp access$mapToWalletApp = WalletAppProvider.access$mapToWalletApp(walletAppProvider, app);
        $jacocoInit[1] = true;
        return access$mapToWalletApp;
    }
}
