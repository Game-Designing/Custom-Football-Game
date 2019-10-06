package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$downloadApp$1 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$downloadApp$1<T, R> implements C0132p<T, Single<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletApp $walletApp;
    final /* synthetic */ WalletInstallManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6401310266064957187L, "cm/aptoide/pt/wallet/WalletInstallManager$downloadApp$1", 4);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallManager$downloadApp$1(WalletInstallManager walletInstallManager, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallManager;
        this.$walletApp = walletApp;
        $jacocoInit[3] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single call = call((Download) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final Single<Download> call(final Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = this.this$0.getMoPubAdsManager().getAdsVisibilityStatus().mo3695b((C0129b<? super T>) new C0129b<OfferResponseStatus>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WalletInstallManager$downloadApp$1 this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(298628611473403283L, "cm/aptoide/pt/wallet/WalletInstallManager$downloadApp$1$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = r2;
                $jacocoInit[4] = true;
            }

            public /* bridge */ /* synthetic */ void call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                call((OfferResponseStatus) obj);
                $jacocoInit[0] = true;
            }

            public final void call(OfferResponseStatus responseStatus) {
                boolean[] $jacocoInit = $jacocoInit();
                WalletInstallManager walletInstallManager = this.this$0.this$0;
                Download download = download;
                C14281f.m45913a((Object) download, "download");
                Action action = Action.INSTALL;
                long id = this.this$0.$walletApp.getId();
                $jacocoInit[1] = true;
                C14281f.m45913a((Object) responseStatus, "responseStatus");
                String packageName = this.this$0.$walletApp.getPackageName();
                String developer = this.this$0.$walletApp.getDeveloper();
                $jacocoInit[2] = true;
                WalletInstallManager.access$setupDownloadEvents(walletInstallManager, download, action, id, responseStatus, packageName, developer);
                $jacocoInit[3] = true;
            }
        });
        $jacocoInit[1] = true;
        Single<Download> d = b.mo3698d(new C0132p<T, R>() {
            private static transient /* synthetic */ boolean[] $jacocoData;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-7896682954192612652L, "cm/aptoide/pt/wallet/WalletInstallManager$downloadApp$1$2", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                $jacocoInit[2] = true;
            }

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                Download call = call((OfferResponseStatus) obj);
                $jacocoInit[0] = true;
                return call;
            }

            public final Download call(OfferResponseStatus it) {
                boolean[] $jacocoInit = $jacocoInit();
                Download download = download;
                $jacocoInit[1] = true;
                return download;
            }
        });
        $jacocoInit[2] = true;
        return d;
    }
}
