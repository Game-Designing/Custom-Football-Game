package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.PhotoFileGenerator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidePhotoFileGeneratorFactory */
public final class ActivityModule_ProvidePhotoFileGeneratorFactory implements C13181b<PhotoFileGenerator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(805267497679429750L, "cm/aptoide/pt/view/ActivityModule_ProvidePhotoFileGeneratorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidePhotoFileGeneratorFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public PhotoFileGenerator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        PhotoFileGenerator providePhotoFileGenerator = activityModule.providePhotoFileGenerator();
        $jacocoInit[2] = true;
        C13182c.m43111a(providePhotoFileGenerator, "Cannot return null from a non-@Nullable @Provides method");
        PhotoFileGenerator photoFileGenerator = providePhotoFileGenerator;
        $jacocoInit[3] = true;
        return photoFileGenerator;
    }

    public static C13181b<PhotoFileGenerator> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidePhotoFileGeneratorFactory activityModule_ProvidePhotoFileGeneratorFactory = new ActivityModule_ProvidePhotoFileGeneratorFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvidePhotoFileGeneratorFactory;
    }

    public static PhotoFileGenerator proxyProvidePhotoFileGenerator(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        PhotoFileGenerator providePhotoFileGenerator = instance.providePhotoFileGenerator();
        $jacocoInit[5] = true;
        return providePhotoFileGenerator;
    }
}
