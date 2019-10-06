package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesBundleEventFactory */
public final class FragmentModule_ProvidesBundleEventFactory implements C13181b<BundleEvent> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7842063690450274982L, "cm/aptoide/pt/view/FragmentModule_ProvidesBundleEventFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesBundleEventFactory(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public BundleEvent get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        BundleEvent providesBundleEvent = fragmentModule.providesBundleEvent();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBundleEvent, "Cannot return null from a non-@Nullable @Provides method");
        BundleEvent bundleEvent = providesBundleEvent;
        $jacocoInit[3] = true;
        return bundleEvent;
    }

    public static C13181b<BundleEvent> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesBundleEventFactory fragmentModule_ProvidesBundleEventFactory = new FragmentModule_ProvidesBundleEventFactory(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesBundleEventFactory;
    }

    public static BundleEvent proxyProvidesBundleEvent(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        BundleEvent providesBundleEvent = instance.providesBundleEvent();
        $jacocoInit[5] = true;
        return providesBundleEvent;
    }
}
