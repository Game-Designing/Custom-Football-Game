package p005cm.aptoide.p006pt.billing.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.paypal.android.sdk.payments.ProofOfPayment;
import java.math.BigDecimal;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p003c.p049c.C1163b;
import p002b.p003c.p049c.C1163b.C1164a;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFragment;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.CustomTabsNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.billing.view.BillingNavigator */
public class BillingNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityNavigator activityNavigator;
    private final PurchaseBundleMapper bundleMapper;
    private final CustomTabsNavigator customTabsNavigator;
    private final int customTabsToolbarColor;
    private final FragmentNavigator fragmentNavigator;
    private final String marketName;

    /* renamed from: cm.aptoide.pt.billing.view.BillingNavigator$PayPalResult */
    public static class PayPalResult {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final int CANCELLED = 2;
        public static final int ERROR = 1;
        public static final int SUCCESS = 0;
        private final String paymentConfirmationId;
        private final int status;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-4375217854037689423L, "cm/aptoide/pt/billing/view/BillingNavigator$PayPalResult", 3);
            $jacocoData = probes;
            return probes;
        }

        public PayPalResult(int status2, String paymentConfirmationId2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = status2;
            this.paymentConfirmationId = paymentConfirmationId2;
            $jacocoInit[0] = true;
        }

        public int getStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.status;
            $jacocoInit[1] = true;
            return i;
        }

        public String getPaymentConfirmationId() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.paymentConfirmationId;
            $jacocoInit[2] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4078895761682562866L, "cm/aptoide/pt/billing/view/BillingNavigator", 53);
        $jacocoData = probes;
        return probes;
    }

    public BillingNavigator(PurchaseBundleMapper bundleMapper2, ActivityNavigator activityNavigator2, FragmentNavigator fragmentNavigator2, String marketName2, CustomTabsNavigator customTabsNavigator2, int customTabsToolbarColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundleMapper = bundleMapper2;
        this.activityNavigator = activityNavigator2;
        this.fragmentNavigator = fragmentNavigator2;
        this.marketName = marketName2;
        this.customTabsNavigator = customTabsNavigator2;
        this.customTabsToolbarColor = customTabsToolbarColor2;
        $jacocoInit[0] = true;
    }

    public void navigateToCustomerAuthenticationForResult(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateForResult(PaymentLoginFragment.newInstance(), requestCode, true);
        $jacocoInit[1] = true;
    }

    public C0120S<Boolean> customerAuthenticationResults(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.fragmentNavigator.results(requestCode);
        C2382a aVar = C2382a.f5546a;
        $jacocoInit[2] = true;
        C0120S<Boolean> j = results.mo3669j(aVar);
        $jacocoInit[3] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7050a(Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getResultCode() == -1) {
            $jacocoInit[50] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[51] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[52] = true;
        return valueOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void navigateToTransactionAuthorizationView(java.lang.String r7, p005cm.aptoide.p006pt.billing.payment.PaymentService r8, java.lang.String r9) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.String r1 = r8.getType()
            android.os.Bundle r1 = r6.getAuthorizationBundle(r7, r9, r1)
            r2 = 1
            r3 = 4
            r0[r3] = r2
            java.lang.String r3 = r8.getType()
            int r4 = r3.hashCode()
            r5 = -1941875981(0xffffffff8c4152f3, float:-1.4893141E-31)
            if (r4 == r5) goto L_0x0039
            r5 = 62142399(0x3b437bf, float:1.0592248E-36)
            if (r4 == r5) goto L_0x0026
            r3 = 5
            r0[r3] = r2
            goto L_0x0044
        L_0x0026:
            java.lang.String r4 = "ADYEN"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0033
            r3 = 8
            r0[r3] = r2
            goto L_0x0044
        L_0x0033:
            r3 = 9
            r0[r3] = r2
            r3 = 1
            goto L_0x004a
        L_0x0039:
            java.lang.String r4 = "PAYPAL"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0046
            r3 = 6
            r0[r3] = r2
        L_0x0044:
            r3 = -1
            goto L_0x004a
        L_0x0046:
            r3 = 0
            r4 = 7
            r0[r4] = r2
        L_0x004a:
            if (r3 == 0) goto L_0x007b
            if (r3 != r2) goto L_0x005c
            cm.aptoide.pt.navigator.FragmentNavigator r3 = r6.fragmentNavigator
            cm.aptoide.pt.billing.view.card.CreditCardAuthorizationFragment r4 = p005cm.aptoide.p006pt.billing.view.card.CreditCardAuthorizationFragment.create(r1)
            r3.navigateTo(r4, r2)
            r3 = 11
            r0[r3] = r2
            goto L_0x0088
        L_0x005c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r8.getType()
            r4.append(r5)
            java.lang.String r5 = " does not require authorization. Can not navigate to authorization view."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            r4 = 12
            r0[r4] = r2
            throw r3
        L_0x007b:
            cm.aptoide.pt.navigator.FragmentNavigator r3 = r6.fragmentNavigator
            android.support.v4.app.Fragment r4 = p005cm.aptoide.p006pt.billing.view.paypal.PayPalAuthorizationFragment.create(r1)
            r3.navigateTo(r4, r2)
            r3 = 10
            r0[r3] = r2
        L_0x0088:
            r3 = 13
            r0[r3] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.view.BillingNavigator.navigateToTransactionAuthorizationView(java.lang.String, cm.aptoide.pt.billing.payment.PaymentService, java.lang.String):void");
    }

    public void popView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.popBackStack();
        $jacocoInit[14] = true;
    }

    public void navigateToPayPalForResult(int requestCode, String currency, String description, double amount) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[15] = true;
        PayPalConfiguration payPalConfiguration = new PayPalConfiguration();
        $jacocoInit[16] = true;
        payPalConfiguration.mo38887b(BuildConfig.PAYPAL_ENVIRONMENT);
        $jacocoInit[17] = true;
        payPalConfiguration.mo38885a(BuildConfig.PAYPAL_KEY);
        String str = this.marketName;
        $jacocoInit[18] = true;
        payPalConfiguration.mo38889c(str);
        $jacocoInit[19] = true;
        bundle.putParcelable("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        $jacocoInit[20] = true;
        bundle.putParcelable("com.paypal.android.sdk.payment", new PayPalPayment(new BigDecimal(amount), currency, description, "sale"));
        $jacocoInit[21] = true;
        this.activityNavigator.navigateForResult(PaymentActivity.class, requestCode, bundle);
        $jacocoInit[22] = true;
    }

    public C0120S<PayPalResult> payPalResults(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.activityNavigator.results(requestCode);
        C2383b bVar = new C2383b(this);
        $jacocoInit[23] = true;
        C0120S<PayPalResult> j = results.mo3669j(bVar);
        $jacocoInit[24] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ PayPalResult mo11269b(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        PayPalResult map = map(result);
        $jacocoInit[49] = true;
        return map;
    }

    public void popViewWithResult(Purchase purchase) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator.navigateBackWithResult(-1, this.bundleMapper.map(purchase));
        $jacocoInit[25] = true;
    }

    public void popViewWithResult(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator.navigateBackWithResult(0, this.bundleMapper.map(throwable));
        $jacocoInit[26] = true;
    }

    public void popViewWithResult() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityNavigator activityNavigator2 = this.activityNavigator;
        PurchaseBundleMapper purchaseBundleMapper = this.bundleMapper;
        $jacocoInit[27] = true;
        Bundle mapCancellation = purchaseBundleMapper.mapCancellation();
        $jacocoInit[28] = true;
        activityNavigator2.navigateBackWithResult(0, mapCancellation);
        $jacocoInit[29] = true;
    }

    private Bundle getAuthorizationBundle(String merchantName, String sku, String serviceName) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[30] = true;
        bundle.putString(BillingActivity.EXTRA_SKU, sku);
        $jacocoInit[31] = true;
        bundle.putString(BillingActivity.EXTRA_MERCHANT_NAME, merchantName);
        $jacocoInit[32] = true;
        bundle.putString(BillingActivity.EXTRA_SERVICE_NAME, serviceName);
        $jacocoInit[33] = true;
        return bundle;
    }

    private PayPalResult map(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        int resultCode = result.getResultCode();
        if (resultCode == -1) {
            Intent data = result.getData();
            $jacocoInit[34] = true;
            PaymentConfirmation confirmation = (PaymentConfirmation) data.getParcelableExtra("com.paypal.android.sdk.paymentConfirmation");
            $jacocoInit[35] = true;
            if (confirmation == null) {
                $jacocoInit[36] = true;
            } else if (confirmation.mo39021a() == null) {
                $jacocoInit[37] = true;
            } else {
                $jacocoInit[38] = true;
                ProofOfPayment a = confirmation.mo39021a();
                $jacocoInit[39] = true;
                PayPalResult payPalResult = new PayPalResult(0, a.mo39033a());
                $jacocoInit[40] = true;
                return payPalResult;
            }
            PayPalResult payPalResult2 = new PayPalResult(1, null);
            $jacocoInit[41] = true;
            return payPalResult2;
        } else if (resultCode != 0) {
            PayPalResult payPalResult3 = new PayPalResult(1, null);
            $jacocoInit[43] = true;
            return payPalResult3;
        } else {
            PayPalResult payPalResult4 = new PayPalResult(2, null);
            $jacocoInit[42] = true;
            return payPalResult4;
        }
    }

    public void navigateToUriForResult(String redirectUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsNavigator customTabsNavigator2 = this.customTabsNavigator;
        C1164a aVar = new C1164a();
        int i = this.customTabsToolbarColor;
        $jacocoInit[44] = true;
        aVar.mo8781a(i);
        $jacocoInit[45] = true;
        C1163b b = aVar.mo8787b();
        Uri parse = Uri.parse(redirectUrl);
        $jacocoInit[46] = true;
        customTabsNavigator2.navigateToCustomTabs(b, parse);
        $jacocoInit[47] = true;
    }

    public C0120S<Uri> uriResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Uri> customTabResults = this.customTabsNavigator.customTabResults();
        $jacocoInit[48] = true;
        return customTabResults;
    }
}
