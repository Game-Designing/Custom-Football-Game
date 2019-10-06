package p005cm.aptoide.p006pt.billing.view.paypal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.view.BillingActivity;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.permission.PermissionServiceFragment;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.billing.view.paypal.PayPalAuthorizationFragment */
public class PayPalAuthorizationFragment extends PermissionServiceFragment implements PayPalView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Billing billing;
    private BillingAnalytics billingAnalytics;
    private BillingNavigator billingNavigator;
    private RxAlertDialog networkErrorDialog;
    private ProgressBar progressBar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2618800105038249978L, "cm/aptoide/pt/billing/view/paypal/PayPalAuthorizationFragment", 33);
        $jacocoData = probes;
        return probes;
    }

    public PayPalAuthorizationFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment create(Bundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        PayPalAuthorizationFragment fragment = new PayPalAuthorizationFragment();
        $jacocoInit[1] = true;
        fragment.setArguments(bundle);
        $jacocoInit[2] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[3] = true;
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[4] = true;
        String string = getArguments().getString(BillingActivity.EXTRA_MERCHANT_NAME);
        $jacocoInit[5] = true;
        this.billing = aptoideApplication.getBilling(string);
        $jacocoInit[6] = true;
        this.billingAnalytics = ((AptoideApplication) getContext().getApplicationContext()).getBillingAnalytics();
        $jacocoInit[7] = true;
        this.billingNavigator = ((ActivityResultNavigator) getContext()).getBillingNavigator();
        $jacocoInit[8] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[9] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.fragment_paypal_progress_bar);
        $jacocoInit[10] = true;
        Builder message = new Builder(getContext()).setMessage(C1375R.string.connection_error);
        $jacocoInit[11] = true;
        Builder positiveButton = message.setPositiveButton(C1375R.string.iab_button_ok);
        $jacocoInit[12] = true;
        this.networkErrorDialog = positiveButton.build();
        Billing billing2 = this.billing;
        BillingAnalytics billingAnalytics2 = this.billingAnalytics;
        BillingNavigator billingNavigator2 = this.billingNavigator;
        $jacocoInit[13] = true;
        C0126V a = C14522a.m46170a();
        String string = getArguments().getString(BillingActivity.EXTRA_SKU);
        $jacocoInit[14] = true;
        PayPalAuthorizationPresenter payPalAuthorizationPresenter = new PayPalAuthorizationPresenter(this, billing2, billingAnalytics2, billingNavigator2, a, string, getArguments().getString(BillingActivity.EXTRA_SERVICE_NAME));
        $jacocoInit[15] = true;
        attachPresenter(payPalAuthorizationPresenter);
        $jacocoInit[16] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[17] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[18] = true;
        ScreenTagHistory build = ScreenTagHistory.Builder.build(simpleName);
        $jacocoInit[19] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_paypal_authorization, container, false);
        $jacocoInit[20] = true;
        return inflate;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar = null;
        $jacocoInit[21] = true;
        this.networkErrorDialog.dismiss();
        this.networkErrorDialog = null;
        $jacocoInit[22] = true;
        super.onDestroyView();
        $jacocoInit[23] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(0);
        $jacocoInit[24] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(8);
        $jacocoInit[25] = true;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.networkErrorDialog.isShowing()) {
            $jacocoInit[26] = true;
        } else {
            $jacocoInit[27] = true;
            this.networkErrorDialog.show();
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
    }

    public C0120S<Void> errorDismisses() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dismisses = this.networkErrorDialog.dismisses();
        C2621a aVar = C2621a.f5783a;
        $jacocoInit[30] = true;
        C0120S<Void> j = dismisses.mo3669j(aVar);
        $jacocoInit[31] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Void m7272a(DialogInterface dialogInterface) {
        $jacocoInit()[32] = true;
        return null;
    }
}
