package p005cm.aptoide.p006pt.account.view.store;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreFragment_MembersInjector */
public final class ManageStoreFragment_MembersInjector implements C13183b<ManageStoreFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ImagePickerPresenter> imagePickerPresenterProvider;
    private final Provider<ManageStorePresenter> manageStorePresenterProvider;
    private final Provider<ScreenOrientationManager> orientationManagerProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5053797575689392537L, "cm/aptoide/pt/account/view/store/ManageStoreFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ManageStoreFragment) obj);
        $jacocoInit[10] = true;
    }

    public ManageStoreFragment_MembersInjector(Provider<ImagePickerPresenter> imagePickerPresenterProvider2, Provider<ManageStorePresenter> manageStorePresenterProvider2, Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.imagePickerPresenterProvider = imagePickerPresenterProvider2;
        this.manageStorePresenterProvider = manageStorePresenterProvider2;
        this.orientationManagerProvider = orientationManagerProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ManageStoreFragment> create(Provider<ImagePickerPresenter> imagePickerPresenterProvider2, Provider<ManageStorePresenter> manageStorePresenterProvider2, Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreFragment_MembersInjector manageStoreFragment_MembersInjector = new ManageStoreFragment_MembersInjector(imagePickerPresenterProvider2, manageStorePresenterProvider2, orientationManagerProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return manageStoreFragment_MembersInjector;
    }

    public void injectMembers(ManageStoreFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectImagePickerPresenter(instance, (ImagePickerPresenter) this.imagePickerPresenterProvider.get());
        $jacocoInit[2] = true;
        injectManageStorePresenter(instance, (ManageStorePresenter) this.manageStorePresenterProvider.get());
        $jacocoInit[3] = true;
        injectOrientationManager(instance, (ScreenOrientationManager) this.orientationManagerProvider.get());
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectImagePickerPresenter(ManageStoreFragment instance, ImagePickerPresenter imagePickerPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.imagePickerPresenter = imagePickerPresenter;
        $jacocoInit[6] = true;
    }

    public static void injectManageStorePresenter(ManageStoreFragment instance, ManageStorePresenter manageStorePresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.manageStorePresenter = manageStorePresenter;
        $jacocoInit[7] = true;
    }

    public static void injectOrientationManager(ManageStoreFragment instance, ScreenOrientationManager orientationManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.orientationManager = orientationManager;
        $jacocoInit[8] = true;
    }

    public static void injectTheme(ManageStoreFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[9] = true;
    }
}
