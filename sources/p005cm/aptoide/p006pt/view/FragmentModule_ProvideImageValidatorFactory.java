package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.ImageValidator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideImageValidatorFactory */
public final class FragmentModule_ProvideImageValidatorFactory implements C13181b<ImageValidator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2617305481611307114L, "cm/aptoide/pt/view/FragmentModule_ProvideImageValidatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideImageValidatorFactory(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ImageValidator get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        ImageValidator provideImageValidator = fragmentModule.provideImageValidator();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideImageValidator, "Cannot return null from a non-@Nullable @Provides method");
        ImageValidator imageValidator = provideImageValidator;
        $jacocoInit[3] = true;
        return imageValidator;
    }

    public static C13181b<ImageValidator> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideImageValidatorFactory fragmentModule_ProvideImageValidatorFactory = new FragmentModule_ProvideImageValidatorFactory(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvideImageValidatorFactory;
    }

    public static ImageValidator proxyProvideImageValidator(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageValidator provideImageValidator = instance.provideImageValidator();
        $jacocoInit[5] = true;
        return provideImageValidator;
    }
}
