package p005cm.aptoide.p006pt.billing;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.billing.payment.Payment;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.InAppProduct;
import p005cm.aptoide.p006pt.billing.product.Product;

/* renamed from: cm.aptoide.pt.billing.BillingAnalytics */
public class BillingAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String PAYMENT_AUTH = "Payment_Authorization_Page";
    public static final String PAYMENT_LOGIN = "Payment_Login";
    public static final String PAYMENT_POPUP = "Payment_Pop_Up";
    private final AnalyticsManager analyticsManager;
    private final String aptoidePackageName;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-316398134895788116L, "cm/aptoide/pt/billing/BillingAnalytics", 59);
        $jacocoData = probes;
        return probes;
    }

    public BillingAnalytics(String aptoidePackageName2, AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoidePackageName = aptoidePackageName2;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void sendPaymentViewShowEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[1] = true;
        map.put("action", "Show");
        $jacocoInit[2] = true;
        this.analyticsManager.logEvent(map, PAYMENT_POPUP, Action.CLICK, getViewName(true));
        $jacocoInit[3] = true;
    }

    public void sendPaymentViewCancelEvent(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = getProductMap(payment.getProduct());
        $jacocoInit[4] = true;
        map.put("action", "Cancel");
        $jacocoInit[5] = true;
        this.analyticsManager.logEvent(map, PAYMENT_POPUP, Action.CLICK, getViewName(true));
        $jacocoInit[6] = true;
    }

    public void sendPaymentViewBuyEvent(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = getProductMap(payment.getProduct());
        $jacocoInit[7] = true;
        PaymentService selectedPaymentService = payment.getSelectedPaymentService();
        $jacocoInit[8] = true;
        String type = selectedPaymentService.getType();
        $jacocoInit[9] = true;
        map.put("payment_method", type);
        $jacocoInit[10] = true;
        map.put("action", "Buy");
        $jacocoInit[11] = true;
        this.analyticsManager.logEvent(map, PAYMENT_POPUP, Action.CLICK, getViewName(true));
        $jacocoInit[12] = true;
    }

    public void sendPaymentSuccessEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[13] = true;
        map.put("action", AccountAnalytics.SUCCESS);
        $jacocoInit[14] = true;
        this.analyticsManager.logEvent(map, PAYMENT_POPUP, Action.CLICK, getViewName(true));
        $jacocoInit[15] = true;
    }

    public void sendPaymentErrorEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[16] = true;
        map.put("action", "Error");
        $jacocoInit[17] = true;
        this.analyticsManager.logEvent(map, PAYMENT_POPUP, Action.CLICK, getViewName(true));
        $jacocoInit[18] = true;
    }

    public void sendCustomerAuthenticatedEvent(boolean customerAuthenticated) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!customerAuthenticated) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            Map<String, Object> map = new HashMap<>();
            $jacocoInit[21] = true;
            map.put("action", AccountAnalytics.SUCCESS);
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Action action = Action.CLICK;
            $jacocoInit[22] = true;
            String viewName = getViewName(true);
            $jacocoInit[23] = true;
            analyticsManager2.logEvent(map, PAYMENT_LOGIN, action, viewName);
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }

    public void sendCustomerAuthenticationResultEvent(boolean customerAuthenticated) {
        String action;
        boolean[] $jacocoInit = $jacocoInit();
        if (customerAuthenticated) {
            action = AccountAnalytics.SUCCESS;
            $jacocoInit[26] = true;
        } else {
            action = "Cancel";
            $jacocoInit[27] = true;
        }
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[28] = true;
        map.put("action", action);
        $jacocoInit[29] = true;
        this.analyticsManager.logEvent(map, PAYMENT_LOGIN, Action.CLICK, getViewName(true));
        $jacocoInit[30] = true;
    }

    public void sendAuthorizationSuccessEvent(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[31] = true;
        PaymentService selectedPaymentService = payment.getSelectedPaymentService();
        $jacocoInit[32] = true;
        String type = selectedPaymentService.getType();
        $jacocoInit[33] = true;
        map.put("payment_method", type);
        $jacocoInit[34] = true;
        map.put("action", AccountAnalytics.SUCCESS);
        $jacocoInit[35] = true;
        this.analyticsManager.logEvent(map, PAYMENT_AUTH, Action.CLICK, getViewName(true));
        $jacocoInit[36] = true;
    }

    public void sendAuthorizationCancelEvent(String serviceName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[37] = true;
        map.put("payment_method", serviceName);
        $jacocoInit[38] = true;
        map.put("action", "Cancel");
        $jacocoInit[39] = true;
        this.analyticsManager.logEvent(map, PAYMENT_AUTH, Action.CLICK, getViewName(true));
        $jacocoInit[40] = true;
    }

    public void sendAuthorizationErrorEvent(String serviceName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[41] = true;
        map.put("payment_method", serviceName);
        $jacocoInit[42] = true;
        map.put("action", "Error");
        $jacocoInit[43] = true;
        this.analyticsManager.logEvent(map, PAYMENT_AUTH, Action.CLICK, getViewName(true));
        $jacocoInit[44] = true;
    }

    private Map<String, Object> getProductMap(Product product) {
        String packageName;
        boolean[] $jacocoInit = $jacocoInit();
        if (product instanceof InAppProduct) {
            $jacocoInit[45] = true;
            packageName = ((InAppProduct) product).getPackageName();
            $jacocoInit[46] = true;
        } else {
            packageName = this.aptoidePackageName;
            $jacocoInit[47] = true;
        }
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[48] = true;
        Price price = product.getPrice();
        $jacocoInit[49] = true;
        double amount = price.getAmount();
        $jacocoInit[50] = true;
        map.put("purchase_value", String.valueOf(amount));
        $jacocoInit[51] = true;
        Price price2 = product.getPrice();
        $jacocoInit[52] = true;
        String currency = price2.getCurrency();
        $jacocoInit[53] = true;
        map.put("purchase_currency", currency);
        $jacocoInit[54] = true;
        map.put("package_name_seller", packageName);
        $jacocoInit[55] = true;
        String valueOf = String.valueOf(product.getPackageVersionCode());
        $jacocoInit[56] = true;
        map.put("package_version_code_seller", valueOf);
        $jacocoInit[57] = true;
        return map;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[58] = true;
        return viewName;
    }
}
