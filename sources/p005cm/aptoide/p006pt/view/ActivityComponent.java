package p005cm.aptoide.p006pt.view;

import p005cm.aptoide.p006pt.FlavourFragmentModule;
import p005cm.aptoide.p006pt.analytics.view.AnalyticsActivity;
import p005cm.aptoide.p006pt.app.view.donations.view.DonateDialogFragment;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p005cm.aptoide.p006pt.view.settings.SettingsFragment;
import p005cm.aptoide.p006pt.wallet.WalletInstallActivity;

@ActivityScope
/* renamed from: cm.aptoide.pt.view.ActivityComponent */
public interface ActivityComponent {
    void inject(AnalyticsActivity analyticsActivity);

    void inject(DonateDialogFragment donateDialogFragment);

    void inject(BottomNavigationActivity bottomNavigationActivity);

    void inject(ActivityResultNavigator activityResultNavigator);

    void inject(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment);

    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);

    void inject(DialogUtils dialogUtils);

    void inject(SettingsFragment settingsFragment);

    void inject(WalletInstallActivity walletInstallActivity);

    FragmentComponent plus(FragmentModule fragmentModule, FlavourFragmentModule flavourFragmentModule);
}
