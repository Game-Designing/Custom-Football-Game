package p005cm.aptoide.p006pt.billing.external;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.Merchant;
import p005cm.aptoide.p006pt.billing.exception.MerchantNotFoundException;
import p005cm.aptoide.p006pt.billing.purchase.InAppPurchase;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.view.BillingActivity;
import p005cm.aptoide.p006pt.billing.view.PaymentThrowableCodeMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.iab.AptoideInAppBillingService.Stub;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0132p;
import p026rx.p401g.C14959b;

/* renamed from: cm.aptoide.pt.billing.external.ExternalBillingBinder */
public class ExternalBillingBinder extends Stub {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String BUY_INTENT = "BUY_INTENT";
    public static final String DETAILS_LIST = "DETAILS_LIST";
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String INAPP_DATA_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String INAPP_DATA_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    public static final String INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String INAPP_PURCHASE_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final int RESULT_BILLING_UNAVAILABLE = 3;
    public static final int RESULT_DEVELOPER_ERROR = 5;
    public static final int RESULT_ERROR = 6;
    public static final int RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int RESULT_ITEM_NOT_OWNED = 8;
    public static final int RESULT_ITEM_UNAVAILABLE = 4;
    public static final int RESULT_OK = 0;
    public static final int RESULT_SERVICE_UNAVAILABLE = 2;
    public static final int RESULT_USER_CANCELLED = 1;
    public static final String SERVICES_LIST = "SERVICES_LIST";
    private final BillingAnalytics analytics;
    private Billing billing;
    private final Context context;
    private final CrashReport crashReport;
    private final PaymentThrowableCodeMapper errorCodeFactory;
    private String merchantName;
    private final PackageManager packageManager;
    private final ExternalBillingSerializer serializer;
    private final int supportedApiVersion;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1013408676043022902L, "cm/aptoide/pt/billing/external/ExternalBillingBinder", 82);
        $jacocoData = probes;
        return probes;
    }

    public ExternalBillingBinder(Context context2, ExternalBillingSerializer serializer2, PaymentThrowableCodeMapper errorCodeFactory2, CrashReport crashReport2, int apiVersion, BillingAnalytics analytics2, PackageManager packageManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.serializer = serializer2;
        this.errorCodeFactory = errorCodeFactory2;
        this.packageManager = packageManager2;
        this.crashReport = crashReport2;
        this.supportedApiVersion = apiVersion;
        this.analytics = analytics2;
        $jacocoInit[0] = true;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        boolean[] $jacocoInit = $jacocoInit();
        this.merchantName = this.packageManager.getPackagesForUid(Binder.getCallingUid())[0];
        $jacocoInit[1] = true;
        this.billing = ((AptoideApplication) this.context.getApplicationContext()).getBilling(this.merchantName);
        $jacocoInit[2] = true;
        boolean onTransact = super.onTransact(code, data, reply, flags);
        $jacocoInit[3] = true;
        return onTransact;
    }

    public int isBillingSupported(int apiVersion, String packageName, String type) throws RemoteException {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            if (apiVersion == this.supportedApiVersion) {
                $jacocoInit[4] = true;
                Single merchant = this.billing.getMerchant();
                C2296a aVar = C2296a.f5383a;
                $jacocoInit[6] = true;
                Single d = merchant.mo3698d(aVar);
                C2298c cVar = C2298c.f5385a;
                $jacocoInit[7] = true;
                Single e = d.mo3699e(cVar);
                $jacocoInit[8] = true;
                C14959b a = e.mo3689a();
                $jacocoInit[9] = true;
                int intValue = ((Integer) a.mo46175a()).intValue();
                $jacocoInit[10] = true;
                return intValue;
            }
            $jacocoInit[5] = true;
            return 3;
        } catch (Exception exception) {
            $jacocoInit[11] = true;
            this.crashReport.log(exception);
            $jacocoInit[12] = true;
            int map = this.errorCodeFactory.map(exception.getCause());
            $jacocoInit[13] = true;
            return map;
        }
    }

    /* renamed from: a */
    static /* synthetic */ Integer m6993a(Merchant merchant) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(0);
        $jacocoInit[81] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6994a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof MerchantNotFoundException) {
            $jacocoInit[78] = true;
            Single a = Single.m734a(Integer.valueOf(3));
            $jacocoInit[79] = true;
            return a;
        }
        Single a2 = Single.m735a(throwable);
        $jacocoInit[80] = true;
        return a2;
    }

    public Bundle getSkuDetails(int apiVersion, String packageName, String type, Bundle skusBundle) throws RemoteException {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle result = new Bundle();
        $jacocoInit[14] = true;
        String str = ITEM_ID_LIST;
        boolean containsKey = skusBundle.containsKey(str);
        String str2 = RESPONSE_CODE;
        if (!containsKey) {
            $jacocoInit[15] = true;
        } else if (apiVersion != this.supportedApiVersion) {
            $jacocoInit[16] = true;
        } else {
            List<String> skus = skusBundle.getStringArrayList(str);
            $jacocoInit[18] = true;
            if (skus == null) {
                $jacocoInit[19] = true;
            } else if (skus.size() > 0) {
                $jacocoInit[20] = true;
                try {
                    Single products = this.billing.getProducts(skus);
                    C2297b bVar = new C2297b(this);
                    $jacocoInit[23] = true;
                    Single a = products.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) bVar);
                    $jacocoInit[24] = true;
                    C14959b a2 = a.mo3689a();
                    $jacocoInit[25] = true;
                    List<String> serializedProducts = (List) a2.mo46175a();
                    $jacocoInit[26] = true;
                    result.putInt(str2, 0);
                    $jacocoInit[27] = true;
                    result.putStringArrayList(DETAILS_LIST, new ArrayList(serializedProducts));
                    $jacocoInit[28] = true;
                    return result;
                } catch (Exception exception) {
                    $jacocoInit[29] = true;
                    this.crashReport.log(exception);
                    $jacocoInit[30] = true;
                    result.putInt(str2, this.errorCodeFactory.map(exception.getCause()));
                    $jacocoInit[31] = true;
                    return result;
                }
            } else {
                $jacocoInit[21] = true;
            }
            result.putInt(str2, 5);
            $jacocoInit[22] = true;
            return result;
        }
        result.putInt(str2, 5);
        $jacocoInit[17] = true;
        return result;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11137a(List products) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            Single a = Single.m734a(this.serializer.serializeProducts(products));
            $jacocoInit[75] = true;
            return a;
        } catch (IOException e) {
            $jacocoInit[76] = true;
            Single a2 = Single.m735a((Throwable) e);
            $jacocoInit[77] = true;
            return a2;
        }
    }

    public Bundle getBuyIntent(int apiVersion, String packageName, String sku, String type, String developerPayload) throws RemoteException {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle result = new Bundle();
        int i = this.supportedApiVersion;
        String str = RESPONSE_CODE;
        if (apiVersion == i) {
            $jacocoInit[32] = true;
            try {
                result.putInt(str, 0);
                String str2 = BUY_INTENT;
                Context context2 = this.context;
                Context context3 = this.context;
                String str3 = this.merchantName;
                $jacocoInit[35] = true;
                Intent intent = BillingActivity.getIntent(context3, sku, str3, developerPayload);
                $jacocoInit[36] = true;
                result.putParcelable(str2, PendingIntent.getActivity(context2, 0, intent, 134217728));
                $jacocoInit[37] = true;
                this.analytics.sendPaymentViewShowEvent();
                $jacocoInit[38] = true;
            } catch (Exception exception) {
                $jacocoInit[39] = true;
                this.crashReport.log(exception);
                $jacocoInit[40] = true;
                result.putInt(str, this.errorCodeFactory.map(exception.getCause()));
                $jacocoInit[41] = true;
            }
            $jacocoInit[42] = true;
            return result;
        }
        $jacocoInit[33] = true;
        result.putInt(str, 5);
        $jacocoInit[34] = true;
        return result;
    }

    public Bundle getPurchases(int apiVersion, String packageName, String type, String continuationToken) throws RemoteException {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle result = new Bundle();
        int i = this.supportedApiVersion;
        String str = RESPONSE_CODE;
        if (apiVersion != i) {
            $jacocoInit[43] = true;
            result.putInt(str, 5);
            $jacocoInit[44] = true;
            return result;
        }
        ArrayList arrayList = new ArrayList();
        $jacocoInit[45] = true;
        ArrayList arrayList2 = new ArrayList();
        $jacocoInit[46] = true;
        ArrayList arrayList3 = new ArrayList();
        $jacocoInit[47] = true;
        if (!type.equals(ITEM_TYPE_INAPP)) {
            $jacocoInit[48] = true;
        } else {
            try {
                $jacocoInit[49] = true;
                Single purchases = this.billing.getPurchases();
                $jacocoInit[50] = true;
                C14959b a = purchases.mo3689a();
                $jacocoInit[51] = true;
                List<Purchase> purchases2 = (List) a.mo46175a();
                $jacocoInit[52] = true;
                $jacocoInit[53] = true;
                for (Purchase purchase : purchases2) {
                    $jacocoInit[54] = true;
                    arrayList.add(((InAppPurchase) purchase).getSignatureData());
                    $jacocoInit[55] = true;
                    arrayList2.add(((InAppPurchase) purchase).getSignature());
                    $jacocoInit[56] = true;
                    arrayList3.add(((InAppPurchase) purchase).getSku());
                    $jacocoInit[57] = true;
                }
                $jacocoInit[58] = true;
            } catch (Exception exception) {
                $jacocoInit[59] = true;
                this.crashReport.log(exception);
                $jacocoInit[60] = true;
                result.putInt(str, this.errorCodeFactory.map(exception.getCause()));
                $jacocoInit[61] = true;
                return result;
            }
        }
        result.putStringArrayList(INAPP_PURCHASE_DATA_LIST, arrayList);
        $jacocoInit[62] = true;
        result.putStringArrayList(INAPP_PURCHASE_ITEM_LIST, arrayList3);
        $jacocoInit[63] = true;
        result.putStringArrayList(INAPP_DATA_SIGNATURE_LIST, arrayList2);
        $jacocoInit[64] = true;
        result.putInt(str, 0);
        $jacocoInit[65] = true;
        return result;
    }

    public int consumePurchase(int apiVersion, String packageName, String purchaseToken) throws RemoteException {
        boolean[] $jacocoInit = $jacocoInit();
        if (apiVersion == this.supportedApiVersion) {
            $jacocoInit[66] = true;
            try {
                C0117M consumePurchase = this.billing.consumePurchase(purchaseToken);
                $jacocoInit[68] = true;
                Single a = consumePurchase.mo3587a(Single.m734a(Integer.valueOf(0)));
                $jacocoInit[69] = true;
                C14959b a2 = a.mo3689a();
                $jacocoInit[70] = true;
                int intValue = ((Integer) a2.mo46175a()).intValue();
                $jacocoInit[71] = true;
                return intValue;
            } catch (Exception exception) {
                $jacocoInit[72] = true;
                this.crashReport.log(exception);
                $jacocoInit[73] = true;
                int map = this.errorCodeFactory.map(exception.getCause());
                $jacocoInit[74] = true;
                return map;
            }
        } else {
            $jacocoInit[67] = true;
            return 5;
        }
    }
}
