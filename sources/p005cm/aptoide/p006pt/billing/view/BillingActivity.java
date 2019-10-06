package p005cm.aptoide.p006pt.billing.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.view.payment.PaymentFragment;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.BackButtonActivity;

/* renamed from: cm.aptoide.pt.billing.view.BillingActivity */
public class BillingActivity extends BackButtonActivity {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String EXTRA_DEVELOPER_PAYLOAD = "cm.aptoide.pt.view.payment.intent.extra.DEVELOPER_PAYLOAD";
    public static final String EXTRA_MERCHANT_NAME = "cm.aptoide.pt.view.payment.intent.extra.MERCHANT_NAME";
    public static final String EXTRA_SERVICE_NAME = "cm.aptoide.pt.view.payment.intent.extra.SERVICE_NAME";
    public static final String EXTRA_SKU = "cm.aptoide.pt.view.payment.intent.extra.SKU";
    private Billing billing;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3343409083806079426L, "cm/aptoide/pt/billing/view/BillingActivity", 19);
        $jacocoData = probes;
        return probes;
    }

    public BillingActivity() {
        $jacocoInit()[0] = true;
    }

    public static Intent getIntent(Context context, String sku, String merchantName, String developerPayload) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(context, BillingActivity.class);
        $jacocoInit[1] = true;
        intent.putExtra(EXTRA_SKU, sku);
        $jacocoInit[2] = true;
        intent.putExtra(EXTRA_MERCHANT_NAME, merchantName);
        $jacocoInit[3] = true;
        intent.putExtra(EXTRA_DEVELOPER_PAYLOAD, developerPayload);
        $jacocoInit[4] = true;
        return intent;
    }

    public static Intent getIntent(Context context, long appId, String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(context, BillingActivity.class);
        $jacocoInit[5] = true;
        intent.putExtra(EXTRA_SKU, String.valueOf(appId));
        $jacocoInit[6] = true;
        intent.putExtra(EXTRA_MERCHANT_NAME, merchantName);
        $jacocoInit[7] = true;
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[8] = true;
        setContentView((int) C1375R.layout.empty_frame);
        if (savedInstanceState != null) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            $jacocoInit[11] = true;
            Fragment create = PaymentFragment.create(getIntent().getExtras());
            $jacocoInit[12] = true;
            fragmentNavigator.navigateToWithoutBackSave(create, true);
            $jacocoInit[13] = true;
        }
        AptoideApplication aptoideApplication = (AptoideApplication) getApplication();
        $jacocoInit[14] = true;
        String stringExtra = getIntent().getStringExtra(EXTRA_MERCHANT_NAME);
        $jacocoInit[15] = true;
        this.billing = aptoideApplication.getBilling(stringExtra);
        $jacocoInit[16] = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.billing.stopSync();
        $jacocoInit[17] = true;
        super.onDestroy();
        $jacocoInit[18] = true;
    }
}
