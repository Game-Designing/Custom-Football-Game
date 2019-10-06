package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.AppcPromotionNotificationStringProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory */
public final class C5218xf1dd651 implements C13181b<AppcPromotionNotificationStringProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-853895456826224055L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public C5218xf1dd651(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AppcPromotionNotificationStringProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        AppcPromotionNotificationStringProvider providesAppcPromotionNotificationStringProvider = fragmentModule.providesAppcPromotionNotificationStringProvider();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppcPromotionNotificationStringProvider, "Cannot return null from a non-@Nullable @Provides method");
        AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider = providesAppcPromotionNotificationStringProvider;
        $jacocoInit[3] = true;
        return appcPromotionNotificationStringProvider;
    }

    public static C13181b<AppcPromotionNotificationStringProvider> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        C5218xf1dd651 fragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory = new C5218xf1dd651(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory;
    }

    public static AppcPromotionNotificationStringProvider proxyProvidesAppcPromotionNotificationStringProvider(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcPromotionNotificationStringProvider providesAppcPromotionNotificationStringProvider = instance.providesAppcPromotionNotificationStringProvider();
        $jacocoInit[5] = true;
        return providesAppcPromotionNotificationStringProvider;
    }
}
