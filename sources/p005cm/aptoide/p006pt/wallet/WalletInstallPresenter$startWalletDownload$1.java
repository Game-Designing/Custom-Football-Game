package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$startWalletDownload$1 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$startWalletDownload$1<R> implements C0131o<C0120S<T>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletApp $walletApp;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7986148027735538869L, "cm/aptoide/pt/wallet/WalletInstallPresenter$startWalletDownload$1", 8);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$startWalletDownload$1(WalletInstallPresenter walletInstallPresenter, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        this.$walletApp = walletApp;
        $jacocoInit[7] = true;
    }

    public final C0120S<WalletApp> call() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.this$0.getWalletInstallManager().shouldShowRootInstallWarningPopup()) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            C0120S showRootInstallWarningPopup = this.this$0.getView().showRootInstallWarningPopup();
            if (showRootInstallWarningPopup != null) {
                $jacocoInit[3] = true;
                showRootInstallWarningPopup.mo3636b((C0129b<? super T>) new C0129b<Boolean>(this) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ WalletInstallPresenter$startWalletDownload$1 this$0;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(-4166109986328054856L, "cm/aptoide/pt/wallet/WalletInstallPresenter$startWalletDownload$1$1", 3);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$0 = r3;
                        $jacocoInit[2] = true;
                    }

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        boolean[] $jacocoInit = $jacocoInit();
                        call((Boolean) obj);
                        $jacocoInit[0] = true;
                    }

                    public final void call(Boolean answer) {
                        boolean[] $jacocoInit = $jacocoInit();
                        WalletInstallManager walletInstallManager = this.this$0.this$0.getWalletInstallManager();
                        C14281f.m45913a((Object) answer, "answer");
                        walletInstallManager.allowRootInstall(answer.booleanValue());
                        $jacocoInit[1] = true;
                    }
                });
                $jacocoInit[4] = true;
            } else {
                $jacocoInit[5] = true;
            }
        }
        C0120S<WalletApp> c = C0120S.m652c(this.$walletApp);
        $jacocoInit[6] = true;
        return c;
    }
}
