package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.apps.AppClick */
public class AppClick {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private App app;
    private ClickType clickType;

    /* renamed from: cm.aptoide.pt.home.apps.AppClick$ClickType */
    enum ClickType {
        PAUSE_DOWNLOAD,
        CANCEL_DOWNLOAD,
        RESUME_DOWNLOAD,
        INSTALL_APP,
        RETRY_DOWNLOAD,
        UPDATE_ALL_APPS,
        UPDATE_APP,
        PAUSE_UPDATE,
        CANCEL_UPDATE,
        RESUME_UPDATE,
        UPDATE_CARD_LONG_CLICK,
        CARD_CLICK,
        RETRY_UPDATE,
        APPC_UPGRADE_APP,
        APPC_UPGRADE_RESUME,
        APPC_UPGRADE_CANCEL,
        APPC_UPGRADE_PAUSE,
        APPC_UPGRADE_RETRY;

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
        boolean[] probes = Offline.getProbes(722359714873655237L, "cm/aptoide/pt/home/apps/AppClick", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppClick(App app2, ClickType clickType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.app = app2;
        this.clickType = clickType2;
        $jacocoInit[0] = true;
    }

    public App getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        App app2 = this.app;
        $jacocoInit[1] = true;
        return app2;
    }

    public ClickType getClickType() {
        boolean[] $jacocoInit = $jacocoInit();
        ClickType clickType2 = this.clickType;
        $jacocoInit[2] = true;
        return clickType2;
    }
}
