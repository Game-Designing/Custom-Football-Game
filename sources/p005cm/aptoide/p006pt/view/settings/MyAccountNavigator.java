package p005cm.aptoide.p006pt.view.settings;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreViewModel;
import p005cm.aptoide.p006pt.account.view.user.ManageUserFragment;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.notification.view.InboxFragment;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.view.StoreFragment;
import p005cm.aptoide.p006pt.store.view.StoreFragment.OpenType;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.settings.MyAccountNavigator */
public class MyAccountNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String BACKUP_APPS_UNAME = "aptoide-backup-apps";
    private final String UPLOADER_UNAME = "aptoide-uploader";
    private final AppNavigator appNavigator;
    private final FragmentNavigator fragmentNavigator;
    private final AccountNavigator navigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5901548428790996774L, "cm/aptoide/pt/view/settings/MyAccountNavigator", 27);
        $jacocoData = probes;
        return probes;
    }

    public MyAccountNavigator(FragmentNavigator fragmentNavigator2, AccountNavigator navigator2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.navigator = navigator2;
        this.appNavigator = appNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToAppView(String uname) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithUname(uname);
        $jacocoInit[1] = true;
    }

    public void navigateToUploader() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithUname("aptoide-uploader");
        $jacocoInit[2] = true;
    }

    public void navigateToBackupApps() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithUname("aptoide-backup-apps");
        $jacocoInit[3] = true;
    }

    public void navigateToEditStoreView(Store store, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        long id = store.getId();
        $jacocoInit[4] = true;
        Appearance appearance = store.getAppearance();
        $jacocoInit[5] = true;
        String theme = appearance.getTheme();
        $jacocoInit[6] = true;
        StoreTheme fromName = StoreTheme.fromName(theme);
        $jacocoInit[7] = true;
        String name = store.getName();
        Appearance appearance2 = store.getAppearance();
        $jacocoInit[8] = true;
        ManageStoreViewModel manageStoreViewModel = new ManageStoreViewModel(id, fromName, name, appearance2.getDescription(), store.getAvatar(), store.getSocialChannels());
        $jacocoInit[9] = true;
        this.fragmentNavigator.navigateForResult(ManageStoreFragment.newInstance(manageStoreViewModel, false), requestCode, true);
        $jacocoInit[10] = true;
    }

    public C0120S<Boolean> editStoreResult(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.fragmentNavigator.results(requestCode);
        C5464c cVar = C5464c.f9275a;
        $jacocoInit[11] = true;
        C0120S<Boolean> j = results.mo3669j(cVar);
        $jacocoInit[12] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9649a(Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getResultCode() == -1) {
            $jacocoInit[24] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[25] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[26] = true;
        return valueOf;
    }

    public void navigateToEditProfileView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(ManageUserFragment.newInstanceToEdit(), true);
        $jacocoInit[13] = true;
    }

    public void navigateToUserView(String userId, String storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        OpenType openType = OpenType.GetHome;
        $jacocoInit[14] = true;
        StoreFragment newInstance = StoreFragment.newInstance(userId, storeTheme, openType);
        $jacocoInit[15] = true;
        fragmentNavigator2.navigateTo(newInstance, true);
        $jacocoInit[16] = true;
    }

    public void navigateToStoreView(String storeName, String storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        OpenType openType = OpenType.GetStore;
        $jacocoInit[17] = true;
        StoreFragment newInstance = StoreFragment.newInstance(storeName, storeTheme, openType);
        $jacocoInit[18] = true;
        fragmentNavigator2.navigateTo(newInstance, true);
        $jacocoInit[19] = true;
    }

    public void navigateToLoginView(AccountOrigins accountOrigins) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.navigateToAccountView(accountOrigins);
        $jacocoInit[20] = true;
    }

    public void navigateToCreateStore() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(ManageStoreFragment.newInstance(new ManageStoreViewModel(), false), true);
        $jacocoInit[21] = true;
    }

    public void navigateToSettings() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(SettingsFragment.newInstance(), true);
        $jacocoInit[22] = true;
    }

    public void navigateToNotificationHistory() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new InboxFragment(), true);
        $jacocoInit[23] = true;
    }
}
