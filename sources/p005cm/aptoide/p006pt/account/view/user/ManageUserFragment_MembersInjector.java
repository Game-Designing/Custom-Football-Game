package p005cm.aptoide.p006pt.account.view.user;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.account.view.user.ManageUserFragment_MembersInjector */
public final class ManageUserFragment_MembersInjector implements C13183b<ManageUserFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ImagePickerPresenter> imagePickerPresenterProvider;
    private final Provider<ManageUserPresenter> manageUserPresenterProvider;
    private final Provider<NewsletterManager> newsletterManagerProvider;
    private final Provider<ScreenOrientationManager> orientationManagerProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2735289972663437804L, "cm/aptoide/pt/account/view/user/ManageUserFragment_MembersInjector", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ManageUserFragment) obj);
        $jacocoInit[12] = true;
    }

    public ManageUserFragment_MembersInjector(Provider<ImagePickerPresenter> imagePickerPresenterProvider2, Provider<ManageUserPresenter> manageUserPresenterProvider2, Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<NewsletterManager> newsletterManagerProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.imagePickerPresenterProvider = imagePickerPresenterProvider2;
        this.manageUserPresenterProvider = manageUserPresenterProvider2;
        this.orientationManagerProvider = orientationManagerProvider2;
        this.newsletterManagerProvider = newsletterManagerProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ManageUserFragment> create(Provider<ImagePickerPresenter> imagePickerPresenterProvider2, Provider<ManageUserPresenter> manageUserPresenterProvider2, Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<NewsletterManager> newsletterManagerProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserFragment_MembersInjector manageUserFragment_MembersInjector = new ManageUserFragment_MembersInjector(imagePickerPresenterProvider2, manageUserPresenterProvider2, orientationManagerProvider2, newsletterManagerProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return manageUserFragment_MembersInjector;
    }

    public void injectMembers(ManageUserFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectImagePickerPresenter(instance, (ImagePickerPresenter) this.imagePickerPresenterProvider.get());
        $jacocoInit[2] = true;
        injectManageUserPresenter(instance, (ManageUserPresenter) this.manageUserPresenterProvider.get());
        $jacocoInit[3] = true;
        injectOrientationManager(instance, (ScreenOrientationManager) this.orientationManagerProvider.get());
        $jacocoInit[4] = true;
        injectNewsletterManager(instance, (NewsletterManager) this.newsletterManagerProvider.get());
        $jacocoInit[5] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[6] = true;
    }

    public static void injectImagePickerPresenter(ManageUserFragment instance, ImagePickerPresenter imagePickerPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.imagePickerPresenter = imagePickerPresenter;
        $jacocoInit[7] = true;
    }

    public static void injectManageUserPresenter(ManageUserFragment instance, ManageUserPresenter manageUserPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.manageUserPresenter = manageUserPresenter;
        $jacocoInit[8] = true;
    }

    public static void injectOrientationManager(ManageUserFragment instance, ScreenOrientationManager orientationManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.orientationManager = orientationManager;
        $jacocoInit[9] = true;
    }

    public static void injectNewsletterManager(ManageUserFragment instance, NewsletterManager newsletterManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.newsletterManager = newsletterManager;
        $jacocoInit[10] = true;
    }

    public static void injectTheme(ManageUserFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[11] = true;
    }
}
