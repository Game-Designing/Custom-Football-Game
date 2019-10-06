package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.ImagePickerNavigator;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.account.view.ImageValidator;
import p005cm.aptoide.p006pt.account.view.PhotoFileGenerator;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.permission.AccountPermissionProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideImagePickerPresenterFactory */
public final class FragmentModule_ProvideImagePickerPresenterFactory implements C13181b<ImagePickerPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountPermissionProvider> accountPermissionProvider;
    private final Provider<ImagePickerNavigator> imagePickerNavigatorProvider;
    private final Provider<ImageValidator> imageValidatorProvider;
    private final FragmentModule module;
    private final Provider<PhotoFileGenerator> photoFileGeneratorProvider;
    private final Provider<UriToPathResolver> uriToPathResolverProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1380740005086398801L, "cm/aptoide/pt/view/FragmentModule_ProvideImagePickerPresenterFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideImagePickerPresenterFactory(FragmentModule module2, Provider<AccountPermissionProvider> accountPermissionProvider2, Provider<PhotoFileGenerator> photoFileGeneratorProvider2, Provider<ImageValidator> imageValidatorProvider2, Provider<UriToPathResolver> uriToPathResolverProvider2, Provider<ImagePickerNavigator> imagePickerNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountPermissionProvider = accountPermissionProvider2;
        this.photoFileGeneratorProvider = photoFileGeneratorProvider2;
        this.imageValidatorProvider = imageValidatorProvider2;
        this.uriToPathResolverProvider = uriToPathResolverProvider2;
        this.imagePickerNavigatorProvider = imagePickerNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public ImagePickerPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AccountPermissionProvider> provider = this.accountPermissionProvider;
        $jacocoInit[1] = true;
        AccountPermissionProvider accountPermissionProvider2 = (AccountPermissionProvider) provider.get();
        Provider<PhotoFileGenerator> provider2 = this.photoFileGeneratorProvider;
        $jacocoInit[2] = true;
        PhotoFileGenerator photoFileGenerator = (PhotoFileGenerator) provider2.get();
        Provider<ImageValidator> provider3 = this.imageValidatorProvider;
        $jacocoInit[3] = true;
        ImageValidator imageValidator = (ImageValidator) provider3.get();
        Provider<UriToPathResolver> provider4 = this.uriToPathResolverProvider;
        $jacocoInit[4] = true;
        UriToPathResolver uriToPathResolver = (UriToPathResolver) provider4.get();
        Provider<ImagePickerNavigator> provider5 = this.imagePickerNavigatorProvider;
        $jacocoInit[5] = true;
        ImagePickerNavigator imagePickerNavigator = (ImagePickerNavigator) provider5.get();
        $jacocoInit[6] = true;
        ImagePickerPresenter provideImagePickerPresenter = fragmentModule.provideImagePickerPresenter(accountPermissionProvider2, photoFileGenerator, imageValidator, uriToPathResolver, imagePickerNavigator);
        $jacocoInit[7] = true;
        C13182c.m43111a(provideImagePickerPresenter, "Cannot return null from a non-@Nullable @Provides method");
        ImagePickerPresenter imagePickerPresenter = provideImagePickerPresenter;
        $jacocoInit[8] = true;
        return imagePickerPresenter;
    }

    public static C13181b<ImagePickerPresenter> create(FragmentModule module2, Provider<AccountPermissionProvider> accountPermissionProvider2, Provider<PhotoFileGenerator> photoFileGeneratorProvider2, Provider<ImageValidator> imageValidatorProvider2, Provider<UriToPathResolver> uriToPathResolverProvider2, Provider<ImagePickerNavigator> imagePickerNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideImagePickerPresenterFactory fragmentModule_ProvideImagePickerPresenterFactory = new FragmentModule_ProvideImagePickerPresenterFactory(module2, accountPermissionProvider2, photoFileGeneratorProvider2, imageValidatorProvider2, uriToPathResolverProvider2, imagePickerNavigatorProvider2);
        $jacocoInit[9] = true;
        return fragmentModule_ProvideImagePickerPresenterFactory;
    }

    public static ImagePickerPresenter proxyProvideImagePickerPresenter(FragmentModule instance, AccountPermissionProvider accountPermissionProvider2, PhotoFileGenerator photoFileGenerator, ImageValidator imageValidator, UriToPathResolver uriToPathResolver, ImagePickerNavigator imagePickerNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ImagePickerPresenter provideImagePickerPresenter = instance.provideImagePickerPresenter(accountPermissionProvider2, photoFileGenerator, imageValidator, uriToPathResolver, imagePickerNavigator);
        $jacocoInit[10] = true;
        return provideImagePickerPresenter;
    }
}
