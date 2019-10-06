package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$startWalletDownload$2 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$startWalletDownload$2<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletApp $walletApp;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5081799808605631488L, "cm/aptoide/pt/wallet/WalletInstallPresenter$startWalletDownload$2", 6);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$startWalletDownload$2(WalletInstallPresenter walletInstallPresenter, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        this.$walletApp = walletApp;
        $jacocoInit[5] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((WalletApp) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<Void> call(WalletApp it) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAllowingMobileData = this.this$0.getPermissionManager().requestDownloadAllowingMobileData(this.this$0.getPermissionService());
        $jacocoInit[1] = true;
        C0120S f = requestDownloadAllowingMobileData.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C0132p<T, C0120S<? extends R>>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WalletInstallPresenter$startWalletDownload$2 this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(9190478847322593766L, "cm/aptoide/pt/wallet/WalletInstallPresenter$startWalletDownload$2$1", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = r3;
                $jacocoInit[2] = true;
            }

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                C0120S call = call((Void) obj);
                $jacocoInit[0] = true;
                return call;
            }

            public final C0120S<Void> call(Void it) {
                boolean[] $jacocoInit = $jacocoInit();
                C0120S<Void> requestExternalStoragePermission = this.this$0.this$0.getPermissionManager().requestExternalStoragePermission(this.this$0.this$0.getPermissionService());
                $jacocoInit[1] = true;
                return requestExternalStoragePermission;
            }
        });
        $jacocoInit[2] = true;
        C0120S a = f.mo3616a(Schedulers.m776io());
        $jacocoInit[3] = true;
        C0120S<Void> g = a.mo3663g((C0132p<? super T, ? extends C0117M>) new C0132p<Void, C0117M>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WalletInstallPresenter$startWalletDownload$2 this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-8683594844988768003L, "cm/aptoide/pt/wallet/WalletInstallPresenter$startWalletDownload$2$2", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = r3;
                $jacocoInit[2] = true;
            }

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                C0117M call = call((Void) obj);
                $jacocoInit[0] = true;
                return call;
            }

            public final C0117M call(Void it) {
                boolean[] $jacocoInit = $jacocoInit();
                C0117M downloadApp = this.this$0.this$0.getWalletInstallManager().downloadApp(this.this$0.$walletApp);
                $jacocoInit[1] = true;
                return downloadApp;
            }
        });
        $jacocoInit[4] = true;
        return g;
    }
}
