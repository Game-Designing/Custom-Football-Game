package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14542r;

/* renamed from: cm.aptoide.pt.wallet.WalletAppProvider$getWalletApp$2 */
/* compiled from: WalletAppProvider.kt */
final class WalletAppProvider$getWalletApp$2<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletAppProvider this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6914421871555878532L, "cm/aptoide/pt/wallet/WalletAppProvider$getWalletApp$2", 9);
        $jacocoData = probes;
        return probes;
    }

    WalletAppProvider$getWalletApp$2(WalletAppProvider walletAppProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletAppProvider;
        $jacocoInit[8] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((WalletApp) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<WalletApp> call(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S walletAppObs = C0120S.m652c(walletApp);
        $jacocoInit[1] = true;
        C0120S isWalletInstalled = this.this$0.getInstalledRepository().isInstalled(walletApp.getPackageName());
        $jacocoInit[2] = true;
        InstallManager installManager = this.this$0.getInstallManager();
        String md5sum = walletApp.getMd5sum();
        String packageName = walletApp.getPackageName();
        $jacocoInit[3] = true;
        int versionCode = walletApp.getVersionCode();
        $jacocoInit[4] = true;
        C0120S walletDownload = installManager.getInstall(md5sum, packageName, versionCode);
        $jacocoInit[5] = true;
        C55661 r5 = new C14542r<T1, T2, T3, R>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WalletAppProvider$getWalletApp$2 this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-8681194229687107515L, "cm/aptoide/pt/wallet/WalletAppProvider$getWalletApp$2$1", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = r3;
                $jacocoInit[2] = true;
            }

            public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
                boolean[] $jacocoInit = $jacocoInit();
                WalletApp call = call((WalletApp) obj, (Boolean) obj2, (Install) obj3);
                $jacocoInit[0] = true;
                return call;
            }

            public final WalletApp call(WalletApp walletApp, Boolean isInstalled, Install walletDownload) {
                boolean[] $jacocoInit = $jacocoInit();
                WalletAppProvider walletAppProvider = this.this$0.this$0;
                C14281f.m45913a((Object) walletApp, "walletApp");
                C14281f.m45913a((Object) isInstalled, "isInstalled");
                boolean booleanValue = isInstalled.booleanValue();
                C14281f.m45913a((Object) walletDownload, "walletDownload");
                WalletAppProvider.access$mergeToWalletApp(walletAppProvider, walletApp, booleanValue, walletDownload);
                $jacocoInit[1] = true;
                return walletApp;
            }
        };
        $jacocoInit[6] = true;
        C0120S walletAppObs2 = C0120S.m640a(walletAppObs, isWalletInstalled, walletDownload, (C14542r<? super T1, ? super T2, ? super T3, ? extends R>) r5);
        $jacocoInit[7] = true;
        return walletAppObs2;
    }
}
