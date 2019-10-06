package p005cm.aptoide.p006pt.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.internal.C0215a;
import android.support.design.internal.C0218d;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.C0307r.C0308a;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0266a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.mopub.common.MoPub;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.presenter.MainView;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.DeepLinkManager.DeepLinkMessages;
import p019d.p022i.p023b.C0100e;
import p019d.p273h.p276c.C12741D;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.view.MainActivity */
public class MainActivity extends BottomNavigationActivity implements MainView, DeepLinkMessages {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ProgressDialog autoUpdateDialog;
    private C14963c<PermissionService> autoUpdateDialogSubject;
    private C0100e<Void> installErrorsDismissEvent;
    private InstallManager installManager;
    @Inject
    MarketResourceFormatter marketResourceFormatter;
    @Inject
    Presenter presenter;
    @Inject
    Resources resources;
    private View snackBarLayout;
    private Snackbar snackbar;
    private View updatesBadge;
    private TextView updatesNumber;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2689658460535594730L, "cm/aptoide/pt/view/MainActivity", 90);
        $jacocoData = probes;
        return probes;
    }

    public MainActivity() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ C0100e access$000(MainActivity x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Void> eVar = x0.installErrorsDismissEvent;
        $jacocoInit[89] = true;
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getActivityComponent().inject(this);
        $jacocoInit[2] = true;
        AptoideApplication application = (AptoideApplication) getApplicationContext();
        $jacocoInit[3] = true;
        MoPub.onCreate(this);
        $jacocoInit[4] = true;
        this.installManager = application.getInstallManager();
        $jacocoInit[5] = true;
        this.snackBarLayout = findViewById(C1375R.C1376id.snackbar_layout);
        $jacocoInit[6] = true;
        this.installErrorsDismissEvent = C0100e.m565o();
        $jacocoInit[7] = true;
        this.autoUpdateDialogSubject = C14963c.m46753p();
        $jacocoInit[8] = true;
        initializeAdsMediation();
        $jacocoInit[9] = true;
        setupUpdatesNotification();
        $jacocoInit[10] = true;
        attachPresenter(this.presenter);
        $jacocoInit[11] = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.autoUpdateDialogSubject = null;
        this.autoUpdateDialog = null;
        this.installErrorsDismissEvent = null;
        this.installManager = null;
        this.updatesBadge = null;
        this.snackBarLayout = null;
        this.snackbar = null;
        $jacocoInit[12] = true;
        super.onDestroy();
        $jacocoInit[13] = true;
        MoPub.onDestroy(this);
        $jacocoInit[14] = true;
    }

    private void initializeAdsMediation() {
        boolean[] $jacocoInit = $jacocoInit();
        C12741D.m41152a((Activity) this, BuildConfig.MOPUB_IRONSOURCE_APPLICATION_ID);
        $jacocoInit[15] = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onStart();
        $jacocoInit[16] = true;
        MoPub.onStart(this);
        $jacocoInit[17] = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[18] = true;
        MoPub.onResume(this);
        $jacocoInit[19] = true;
        C12741D.m41159b((Activity) this);
        $jacocoInit[20] = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onPause();
        $jacocoInit[21] = true;
        MoPub.onPause(this);
        $jacocoInit[22] = true;
        C12741D.m41151a((Activity) this);
        $jacocoInit[23] = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onStop();
        $jacocoInit[24] = true;
        MoPub.onStop(this);
        $jacocoInit[25] = true;
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onRestart();
        $jacocoInit[26] = true;
        MoPub.onRestart(this);
        $jacocoInit[27] = true;
    }

    private void setupUpdatesNotification() {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        $jacocoInit[28] = true;
        C0218d appsView = (C0218d) bottomNavigationView.getChildAt(0);
        $jacocoInit[29] = true;
        C0215a appsItemView = (C0215a) appsView.getChildAt(4);
        $jacocoInit[30] = true;
        LayoutInflater from = LayoutInflater.from(this);
        $jacocoInit[31] = true;
        this.updatesBadge = from.inflate(C1375R.layout.updates_badge, appsView, false);
        $jacocoInit[32] = true;
        this.updatesNumber = (TextView) this.updatesBadge.findViewById(C1375R.C1376id.updates_badge);
        $jacocoInit[33] = true;
        appsItemView.addView(this.updatesBadge);
        $jacocoInit[34] = true;
        appsItemView.setVisibility(0);
        $jacocoInit[35] = true;
    }

    public void showInstallationError(int numberOfErrors) {
        String title;
        boolean[] $jacocoInit = $jacocoInit();
        if (numberOfErrors == 1) {
            $jacocoInit[36] = true;
            title = getString(C1375R.string.f4265xaa2d1690);
            $jacocoInit[37] = true;
        } else {
            $jacocoInit[38] = true;
            Object[] objArr = {Integer.valueOf(numberOfErrors)};
            $jacocoInit[39] = true;
            title = getString(C1375R.string.generalscreen_short_root_install_timeout_error_message, objArr);
            $jacocoInit[40] = true;
        }
        C0266a snackbarCallback = new C0266a(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ MainActivity this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-5074112066175930612L, "cm/aptoide/pt/view/MainActivity$1", 6);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public /* bridge */ /* synthetic */ void onDismissed(Object obj, int i) {
                boolean[] $jacocoInit = $jacocoInit();
                onDismissed((Snackbar) obj, i);
                $jacocoInit[5] = true;
            }

            public void onDismissed(Snackbar snackbar, int event) {
                boolean[] $jacocoInit = $jacocoInit();
                super.onDismissed(snackbar, event);
                if (event != 0) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    MainActivity.access$000(this.this$0).call(null);
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[41] = true;
        Snackbar a = Snackbar.m1624a(this.snackBarLayout, (CharSequence) title, -2);
        C5217F f = new C5217F(this);
        $jacocoInit[42] = true;
        a.mo4552a((int) C1375R.string.generalscreen_short_root_install_timeout_error_action, (OnClickListener) f);
        $jacocoInit[43] = true;
        a.mo4678a((C0308a<B>) snackbarCallback);
        this.snackbar = a;
        $jacocoInit[44] = true;
        this.snackbar.mo4690h();
        $jacocoInit[45] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16912a(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M retryTimedOutInstallations = this.installManager.retryTimedOutInstallations();
        InstallManager installManager2 = this.installManager;
        $jacocoInit[86] = true;
        C0117M a = retryTimedOutInstallations.mo3580a(installManager2.cleanTimedOutInstalls());
        $jacocoInit[87] = true;
        a.mo3603e();
        $jacocoInit[88] = true;
    }

    public void dismissInstallationError() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar snackbar2 = this.snackbar;
        if (snackbar2 == null) {
            $jacocoInit[46] = true;
        } else {
            $jacocoInit[47] = true;
            snackbar2.mo4683c();
            $jacocoInit[48] = true;
        }
        $jacocoInit[49] = true;
    }

    public void showInstallationSuccessMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        ShowMessage.asSnack(this.snackBarLayout, (int) C1375R.string.generalscreen_short_root_install_success_install);
        $jacocoInit[50] = true;
    }

    public C0120S<Void> getInstallErrorsDismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Void> eVar = this.installErrorsDismissEvent;
        $jacocoInit[51] = true;
        return eVar;
    }

    public Intent getIntentAfterCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = getIntent();
        $jacocoInit[52] = true;
        return intent;
    }

    public void showUpdatesNumber(Integer updates) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updatesBadge.setVisibility(0);
        $jacocoInit[53] = true;
        this.updatesNumber.setText(String.valueOf(updates));
        $jacocoInit[54] = true;
    }

    public void hideUpdatesBadge() {
        boolean[] $jacocoInit = $jacocoInit();
        this.updatesBadge.setVisibility(8);
        $jacocoInit[55] = true;
    }

    public C0120S<PermissionService> autoUpdateDialogCreated() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<PermissionService> cVar = this.autoUpdateDialogSubject;
        $jacocoInit[56] = true;
        return cVar;
    }

    public void requestAutoUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        Builder dialogBuilder = new Builder(this);
        $jacocoInit[57] = true;
        AlertDialog updateSelfDialog = dialogBuilder.create();
        $jacocoInit[58] = true;
        updateSelfDialog.setTitle(getText(C1375R.string.update_self_title));
        $jacocoInit[59] = true;
        updateSelfDialog.setIcon(C1375R.mipmap.ic_launcher);
        MarketResourceFormatter marketResourceFormatter2 = this.marketResourceFormatter;
        $jacocoInit[60] = true;
        String formatString = marketResourceFormatter2.formatString(getApplicationContext(), C1375R.string.update_self_msg, new String[0]);
        $jacocoInit[61] = true;
        updateSelfDialog.setMessage(formatString);
        $jacocoInit[62] = true;
        updateSelfDialog.setCancelable(false);
        $jacocoInit[63] = true;
        updateSelfDialog.setButton(-1, getString(17039379), new C5219G(this));
        $jacocoInit[64] = true;
        updateSelfDialog.setButton(-2, getString(17039369), C5220H.f8990a);
        $jacocoInit[65] = true;
        if (!is_resumed()) {
            $jacocoInit[66] = true;
        } else {
            $jacocoInit[67] = true;
            updateSelfDialog.show();
            $jacocoInit[68] = true;
        }
        $jacocoInit[69] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16911a(DialogInterface arg0, int arg1) {
        boolean[] $jacocoInit = $jacocoInit();
        this.autoUpdateDialog = new ProgressDialog(this);
        $jacocoInit[82] = true;
        this.autoUpdateDialog.setMessage(getString(C1375R.string.retrieving_update));
        $jacocoInit[83] = true;
        this.autoUpdateDialog.show();
        $jacocoInit[84] = true;
        this.autoUpdateDialogSubject.onNext(this);
        $jacocoInit[85] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9514b(DialogInterface dialog, int arg1) {
        boolean[] $jacocoInit = $jacocoInit();
        dialog.dismiss();
        $jacocoInit[81] = true;
    }

    public void showUnknownErrorMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1623a(findViewById(16908290), (int) C1375R.string.unknown_error, -1);
        $jacocoInit[70] = true;
        a.mo4690h();
        $jacocoInit[71] = true;
    }

    public void dismissAutoUpdateDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        ProgressDialog progressDialog = this.autoUpdateDialog;
        if (progressDialog == null) {
            $jacocoInit[72] = true;
        } else if (!progressDialog.isShowing()) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            this.autoUpdateDialog.dismiss();
            $jacocoInit[75] = true;
        }
        $jacocoInit[76] = true;
    }

    public void showStoreAlreadyAdded() {
        boolean[] $jacocoInit = $jacocoInit();
        ShowMessage.asLongSnack((Activity) this, getString(C1375R.string.store_already_added));
        $jacocoInit[77] = true;
    }

    public void showStoreFollowed(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[78] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.store_followed, getResources(), storeName);
        $jacocoInit[79] = true;
        ShowMessage.asLongSnack((Activity) this, formattedString);
        $jacocoInit[80] = true;
    }
}
