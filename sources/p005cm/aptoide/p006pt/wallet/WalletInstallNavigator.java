package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallNavigator */
/* compiled from: WalletInstallNavigator.kt */
public final class WalletInstallNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4451369417415844040L, "cm/aptoide/pt/wallet/WalletInstallNavigator", 4);
        $jacocoData = probes;
        return probes;
    }

    public WalletInstallNavigator(FragmentNavigator fragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(fragmentNavigator2, "fragmentNavigator");
        $jacocoInit[2] = true;
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[3] = true;
    }

    public final FragmentNavigator getFragmentNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[1] = true;
        return fragmentNavigator2;
    }

    public final void navigateToWalletInstallView() {
        $jacocoInit()[0] = true;
    }
}
