package p005cm.aptoide.p006pt.billing.view;

import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingBinder;
import p005cm.aptoide.p006pt.billing.purchase.InAppPurchase;
import p005cm.aptoide.p006pt.billing.purchase.PaidAppPurchase;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;
import p005cm.aptoide.p006pt.billing.purchase.PurchaseFactory;

/* renamed from: cm.aptoide.pt.billing.view.PurchaseBundleMapper */
public class PurchaseBundleMapper {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String APK_PATH = "APK_PATH";
    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String STATUS = "STATUS";
    private static final String TRANSACTION_ID = "TRANSACTION_ID";
    private final PurchaseFactory purchaseFactory;
    private final PaymentThrowableCodeMapper throwableCodeMapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5241429673139393477L, "cm/aptoide/pt/billing/view/PurchaseBundleMapper", 38);
        $jacocoData = probes;
        return probes;
    }

    public PurchaseBundleMapper(PaymentThrowableCodeMapper throwableCodeMapper2, PurchaseFactory purchaseFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.throwableCodeMapper = throwableCodeMapper2;
        this.purchaseFactory = purchaseFactory2;
        $jacocoInit[0] = true;
    }

    public Bundle map(Purchase purchase) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle intent = new Bundle();
        boolean z = purchase instanceof InAppPurchase;
        String str = ExternalBillingBinder.RESPONSE_CODE;
        if (z) {
            InAppPurchase inAppPurchase = (InAppPurchase) purchase;
            $jacocoInit[1] = true;
            String signatureData = inAppPurchase.getSignatureData();
            $jacocoInit[2] = true;
            intent.putString(ExternalBillingBinder.INAPP_PURCHASE_DATA, signatureData);
            $jacocoInit[3] = true;
            intent.putInt(str, 0);
            $jacocoInit[4] = true;
            if (((InAppPurchase) purchase).getSignature() == null) {
                $jacocoInit[5] = true;
            } else {
                InAppPurchase inAppPurchase2 = (InAppPurchase) purchase;
                $jacocoInit[6] = true;
                String signature = inAppPurchase2.getSignature();
                $jacocoInit[7] = true;
                intent.putString(ExternalBillingBinder.INAPP_DATA_SIGNATURE, signature);
                $jacocoInit[8] = true;
            }
        } else if (purchase instanceof PaidAppPurchase) {
            $jacocoInit[9] = true;
            intent.putInt(str, 0);
            $jacocoInit[10] = true;
            intent.putString(APK_PATH, ((PaidAppPurchase) purchase).getApkPath());
            $jacocoInit[11] = true;
            intent.putString(PRODUCT_ID, purchase.getProductId());
            $jacocoInit[12] = true;
            intent.putString(TRANSACTION_ID, purchase.getTransactionId());
            $jacocoInit[13] = true;
            intent.putSerializable(STATUS, purchase.getStatus());
            $jacocoInit[14] = true;
        } else {
            intent.putInt(str, this.throwableCodeMapper.map((Throwable) new IllegalArgumentException("Cannot convert purchase. Only paid app and in app purchases supported.")));
            $jacocoInit[15] = true;
        }
        $jacocoInit[16] = true;
        return intent;
    }

    public Purchase map(int resultCode, Bundle data) throws Throwable {
        int i = resultCode;
        Bundle bundle = data;
        boolean[] $jacocoInit = $jacocoInit();
        if (i != -1) {
            if (i == 0) {
                $jacocoInit[28] = true;
                if (bundle != null) {
                    String str = ExternalBillingBinder.RESPONSE_CODE;
                    if (!bundle.containsKey(str)) {
                        $jacocoInit[30] = true;
                    } else {
                        $jacocoInit[31] = true;
                        Throwable map = this.throwableCodeMapper.map(bundle.getInt(str, -1));
                        $jacocoInit[32] = true;
                        throw map;
                    }
                } else {
                    $jacocoInit[29] = true;
                }
            } else {
                $jacocoInit[27] = true;
            }
            Throwable map2 = this.throwableCodeMapper.map(6);
            $jacocoInit[33] = true;
            throw map2;
        } else if (bundle != null) {
            $jacocoInit[17] = true;
            String str2 = APK_PATH;
            if (bundle.containsKey(str2)) {
                String str3 = PRODUCT_ID;
                if (bundle.containsKey(str3)) {
                    $jacocoInit[20] = true;
                    PurchaseFactory purchaseFactory2 = this.purchaseFactory;
                    String string = bundle.getString(str3);
                    $jacocoInit[21] = true;
                    Status status = (Status) bundle.getSerializable(STATUS);
                    $jacocoInit[22] = true;
                    String string2 = bundle.getString(str2);
                    String string3 = bundle.getString(TRANSACTION_ID);
                    $jacocoInit[23] = true;
                    Purchase create = purchaseFactory2.create(string, null, null, status, null, PurchaseFactory.PAID_APP, string2, string3);
                    $jacocoInit[24] = true;
                    return create;
                }
                $jacocoInit[19] = true;
            } else {
                $jacocoInit[18] = true;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Intent does not contain paid app information");
            $jacocoInit[25] = true;
            throw illegalArgumentException;
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("No purchase provided in result intent.");
            $jacocoInit[26] = true;
            throw illegalArgumentException2;
        }
    }

    public Bundle map(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[34] = true;
        bundle.putInt(ExternalBillingBinder.RESPONSE_CODE, this.throwableCodeMapper.map(throwable));
        $jacocoInit[35] = true;
        return bundle;
    }

    public Bundle mapCancellation() {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[36] = true;
        bundle.putInt(ExternalBillingBinder.RESPONSE_CODE, 1);
        $jacocoInit[37] = true;
        return bundle;
    }
}
