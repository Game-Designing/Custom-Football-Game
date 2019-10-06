package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.HomeEvent */
public class HomeEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final HomeBundle bundle;
    private final int bundlePosition;
    private final Type clickType;

    /* renamed from: cm.aptoide.pt.home.HomeEvent$Type */
    public enum Type {
        MORE,
        MORE_TOP,
        APP,
        AD,
        SCROLL_RIGHT,
        REWARD_APP,
        KNOW_MORE,
        DISMISS_BUNDLE,
        SOCIAL_INSTALL,
        EDITORIAL,
        INSTALL_WALLET,
        NO_OP,
        REACT_SINGLE_PRESS,
        REACT_LONG_PRESS,
        REACTION,
        POPUP_DISMISS;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(185734571992248437L, "cm/aptoide/pt/home/HomeEvent", 4);
        $jacocoData = probes;
        return probes;
    }

    public HomeEvent(HomeBundle bundle2, int bundlePosition2, Type clickType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundle = bundle2;
        this.bundlePosition = bundlePosition2;
        this.clickType = clickType2;
        $jacocoInit[0] = true;
    }

    public HomeBundle getBundle() {
        boolean[] $jacocoInit = $jacocoInit();
        HomeBundle homeBundle = this.bundle;
        $jacocoInit[1] = true;
        return homeBundle;
    }

    public int getBundlePosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.bundlePosition;
        $jacocoInit[2] = true;
        return i;
    }

    public Type getType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = this.clickType;
        $jacocoInit[3] = true;
        return type;
    }
}
