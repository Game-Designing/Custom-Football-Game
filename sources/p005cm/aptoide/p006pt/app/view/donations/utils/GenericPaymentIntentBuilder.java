package p005cm.aptoide.p006pt.app.view.donations.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.asf.appcoins.sdk.contractproxy.AppCoinsAddressProxyBuilder;
import com.asf.appcoins.sdk.contractproxy.AppCoinsAddressProxySdk;
import com.google.android.gms.common.util.Hex;
import com.google.gson.Gson;
import io.reactivex.Single;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Formatter;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p320f.p321a.C13810v;
import p320f.p321a.p344h.C13777b;

/* renamed from: cm.aptoide.pt.app.view.donations.utils.GenericPaymentIntentBuilder */
public class GenericPaymentIntentBuilder {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int MAIN_NETWORK_ID = 1;
    private static final int ROPSTEN_NETWORK_ID = 3;

    /* renamed from: cm.aptoide.pt.app.view.donations.utils.GenericPaymentIntentBuilder$TransactionData */
    public static class TransactionData {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String TYPE_DONATION = "DONATION";
        public static final String TYPE_INAPP = "INAPP";
        String domain;
        String payload;
        String skuId;
        String type;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-1962671442964106978L, "cm/aptoide/pt/app/view/donations/utils/GenericPaymentIntentBuilder$TransactionData", 1);
            $jacocoData = probes;
            return probes;
        }

        public TransactionData(String type2, String domain2, String skuId2, String payload2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            this.domain = domain2;
            this.skuId = skuId2;
            this.payload = payload2;
            $jacocoInit[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4640276507792145326L, "cm/aptoide/pt/app/view/donations/utils/GenericPaymentIntentBuilder", 30);
        $jacocoData = probes;
        return probes;
    }

    public GenericPaymentIntentBuilder() {
        $jacocoInit()[0] = true;
    }

    public static PendingIntent buildBuyIntent(Context context, String skuId, String value, String walletAddress, String packageName, String transferType, String payload, boolean debug) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsAddressProxySdk proxySdk = new AppCoinsAddressProxyBuilder().createAddressProxySdk();
        if (debug) {
            $jacocoInit[1] = true;
            i = 3;
        } else {
            $jacocoInit[2] = true;
            i = 1;
        }
        $jacocoInit[3] = true;
        int networkId = i;
        C13810v appCoinsAddress = proxySdk.getAppCoinsAddress(networkId);
        $jacocoInit[4] = true;
        Single<String> getTokenContractAddress = appCoinsAddress.mo43157b(C13777b.m43847b());
        $jacocoInit[5] = true;
        C13810v iabAddress = proxySdk.getIabAddress(networkId);
        $jacocoInit[6] = true;
        Single<String> getIabContractAddress = iabAddress.mo43157b(C13777b.m43847b());
        $jacocoInit[7] = true;
        C2040a aVar = new C2040a(context, networkId, skuId, value, walletAddress, packageName, transferType, payload);
        C13810v a = C13810v.m43898a(getTokenContractAddress, getIabContractAddress, aVar);
        $jacocoInit[8] = true;
        PendingIntent pendingIntent = (PendingIntent) a.mo43158b();
        $jacocoInit[9] = true;
        return pendingIntent;
    }

    /* renamed from: a */
    static /* synthetic */ PendingIntent m6964a(Context context, int networkId, String skuId, String value, String walletAddress, String packageName, String transferType, String payload, String tokenContractAddress, String iabContractAddress) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        PendingIntent buildPaymentIntent = buildPaymentIntent(context, networkId, skuId, value, tokenContractAddress, iabContractAddress, walletAddress, packageName, transferType, payload);
        $jacocoInit[29] = true;
        return buildPaymentIntent;
    }

    private static PendingIntent buildPaymentIntent(Context context, int networkId, String skuId, String value, String tokenContractAddress, String iabContractAddress, String walletAddress, String packageName, String paymentType, String payload) {
        boolean[] $jacocoInit = $jacocoInit();
        BigDecimal amount = new BigDecimal(value);
        $jacocoInit[10] = true;
        BigDecimal amount2 = amount.multiply(BigDecimal.TEN.pow(18));
        $jacocoInit[11] = true;
        Intent intent = new Intent("android.intent.action.VIEW");
        $jacocoInit[12] = true;
        String buildUriString = buildUriString(tokenContractAddress, iabContractAddress, amount2, walletAddress, skuId, networkId, packageName, paymentType, payload);
        $jacocoInit[13] = true;
        Uri data = Uri.parse(buildUriString);
        $jacocoInit[14] = true;
        intent.setData(data);
        $jacocoInit[15] = true;
        Context context2 = context;
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        $jacocoInit[16] = true;
        return activity;
    }

    private static String buildUriString(String tokenContractAddress, String iabContractAddress, BigDecimal amount, String walletAddress, String skuId, int networkId, String packageName, String paymentType, String payload) {
        Formatter formatter;
        String str;
        Object[] objArr;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder stringBuilder = new StringBuilder(4);
        try {
            $jacocoInit[17] = true;
            try {
                formatter = new Formatter(stringBuilder);
                str = "ethereum:%s@%d/buy?uint256=%s&address=%s&data=%s&iabContractAddress=%s";
                objArr = new Object[6];
                objArr[0] = tokenContractAddress;
                $jacocoInit[18] = true;
                objArr[1] = Integer.valueOf(networkId);
                objArr[2] = amount.toString();
                objArr[3] = walletAddress;
                $jacocoInit[19] = true;
            } catch (UnsupportedEncodingException e) {
                e = e;
                String str2 = skuId;
                String str3 = packageName;
                String str4 = paymentType;
                String str5 = payload;
                $jacocoInit[21] = true;
                RuntimeException runtimeException = new RuntimeException("UTF-8 not supported!", e);
                $jacocoInit[22] = true;
                throw runtimeException;
            }
            try {
                objArr[4] = buildUriData(skuId, packageName, paymentType, payload);
                objArr[5] = iabContractAddress;
                $jacocoInit[20] = true;
                formatter.format(str, objArr);
                String sb = stringBuilder.toString();
                $jacocoInit[23] = true;
                return sb;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                $jacocoInit[21] = true;
                RuntimeException runtimeException2 = new RuntimeException("UTF-8 not supported!", e);
                $jacocoInit[22] = true;
                throw runtimeException2;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            String str6 = skuId;
            String str7 = packageName;
            String str8 = paymentType;
            String str9 = payload;
            $jacocoInit[21] = true;
            RuntimeException runtimeException22 = new RuntimeException("UTF-8 not supported!", e);
            $jacocoInit[22] = true;
            throw runtimeException22;
        }
    }

    private static String buildUriData(String skuId, String packageName, String paymentType, String payload) throws UnsupportedEncodingException {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        Gson gson = new Gson();
        TransactionData transactionData = new TransactionData(paymentType, packageName, skuId, payload);
        $jacocoInit[24] = true;
        String json = gson.toJson((Object) transactionData);
        $jacocoInit[25] = true;
        byte[] bytes = json.getBytes("UTF-8");
        $jacocoInit[26] = true;
        String a = Hex.m22097a(bytes);
        $jacocoInit[27] = true;
        sb.append(a.toLowerCase());
        String sb2 = sb.toString();
        $jacocoInit[28] = true;
        return sb2;
    }
}
