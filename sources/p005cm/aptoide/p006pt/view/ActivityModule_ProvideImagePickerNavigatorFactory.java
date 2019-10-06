package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.ImagePickerNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideImagePickerNavigatorFactory */
public final class ActivityModule_ProvideImagePickerNavigatorFactory implements C13181b<ImagePickerNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1902886705297115191L, "cm/aptoide/pt/view/ActivityModule_ProvideImagePickerNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideImagePickerNavigatorFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ImagePickerNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        ImagePickerNavigator provideImagePickerNavigator = activityModule.provideImagePickerNavigator();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideImagePickerNavigator, "Cannot return null from a non-@Nullable @Provides method");
        ImagePickerNavigator imagePickerNavigator = provideImagePickerNavigator;
        $jacocoInit[3] = true;
        return imagePickerNavigator;
    }

    public static C13181b<ImagePickerNavigator> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideImagePickerNavigatorFactory activityModule_ProvideImagePickerNavigatorFactory = new ActivityModule_ProvideImagePickerNavigatorFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideImagePickerNavigatorFactory;
    }

    public static ImagePickerNavigator proxyProvideImagePickerNavigator(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ImagePickerNavigator provideImagePickerNavigator = instance.provideImagePickerNavigator();
        $jacocoInit[5] = true;
        return provideImagePickerNavigator;
    }
}
