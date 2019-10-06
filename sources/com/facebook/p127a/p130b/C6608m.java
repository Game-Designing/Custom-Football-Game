package com.facebook.p127a.p130b;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6697T;
import com.facebook.internal.C6737y;
import com.facebook.internal.C6738z;
import com.facebook.p127a.C6638q;
import com.facebook.p127a.C6647y;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingBinder;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.facebook.a.b.m */
/* compiled from: AutomaticAnalyticsLogger */
public class C6608m {

    /* renamed from: a */
    private static final String f12007a = C6608m.class.getCanonicalName();

    /* renamed from: b */
    private static final C6647y f12008b = new C6647y(C6787r.m13815e());

    /* renamed from: com.facebook.a.b.m$a */
    /* compiled from: AutomaticAnalyticsLogger */
    private static class C6609a {

        /* renamed from: a */
        BigDecimal f12009a;

        /* renamed from: b */
        Currency f12010b;

        /* renamed from: c */
        Bundle f12011c;

        C6609a(BigDecimal purchaseAmount, Currency currency, Bundle param) {
            this.f12009a = purchaseAmount;
            this.f12010b = currency;
            this.f12011c = param;
        }
    }

    /* renamed from: b */
    public static void m13120b() {
        Context context = C6787r.m13815e();
        String appId = C6787r.m13816f();
        boolean autoLogAppEvents = C6787r.m13818h();
        C6697T.m13461a((Object) context, "context");
        if (!autoLogAppEvents) {
            return;
        }
        if (context instanceof Application) {
            C6638q.m13215a((Application) context, appId);
        } else {
            Log.w(f12007a, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    /* renamed from: a */
    public static void m13116a(String activityName, long timeSpentInSeconds) {
        Context context = C6787r.m13815e();
        String appId = C6787r.m13816f();
        C6697T.m13461a((Object) context, "context");
        C6738z settings = C6670D.m13301a(appId, false);
        if (settings != null && settings.mo19973a() && timeSpentInSeconds > 0) {
            C6647y logger = new C6647y(context);
            Bundle params = new Bundle(1);
            params.putCharSequence("fb_aa_time_spent_view_name", activityName);
            logger.mo19851a("fb_aa_time_spent_on_view", (double) timeSpentInSeconds, params);
        }
    }

    /* renamed from: a */
    public static void m13117a(String purchase, String skuDetails) {
        if (m13118a()) {
            C6609a loggingParameters = m13119b(purchase, skuDetails);
            if (loggingParameters != null) {
                f12008b.mo19855a(loggingParameters.f12009a, loggingParameters.f12010b, loggingParameters.f12011c);
            }
        }
    }

    /* renamed from: a */
    public static void m13115a(C6620x subsType, String purchase, String skuDetails, Map<String, String> extraParameter) {
        String eventName;
        if (m13118a()) {
            boolean passGK = C6737y.m13573a("app_events_if_auto_log_subs", C6787r.m13816f(), false);
            switch (C6607l.f12006a[subsType.ordinal()]) {
                case 1:
                    if (passGK) {
                        eventName = "Subscribe";
                        break;
                    } else {
                        m13117a(purchase, skuDetails);
                        return;
                    }
                case 2:
                    if (passGK) {
                        eventName = "StartTrial";
                        break;
                    } else {
                        m13117a(purchase, skuDetails);
                        return;
                    }
                case 3:
                    eventName = "SubscriptionRestore";
                    break;
                case 4:
                    eventName = "SubscriptionCancel";
                    break;
                case 5:
                    eventName = "SubscriptionHeartbeat";
                    break;
                case 6:
                    eventName = "SubscriptionExpire";
                    break;
                default:
                    return;
            }
            C6609a loggingParameters = m13114a(purchase, skuDetails, extraParameter);
            if (loggingParameters != null) {
                f12008b.mo19854a(eventName, loggingParameters.f12009a, loggingParameters.f12010b, loggingParameters.f12011c);
            }
        }
    }

    /* renamed from: a */
    public static boolean m13118a() {
        C6738z settings = C6670D.m13306b(C6787r.m13816f());
        return settings != null && C6787r.m13818h() && settings.mo19978f();
    }

    /* renamed from: b */
    private static C6609a m13119b(String purchase, String skuDetails) {
        return m13114a(purchase, skuDetails, new HashMap());
    }

    /* renamed from: a */
    private static C6609a m13114a(String purchase, String skuDetails, Map<String, String> extraParameter) {
        try {
            JSONObject purchaseJSON = new JSONObject(purchase);
            JSONObject skuDetailsJSON = new JSONObject(skuDetails);
            Bundle params = new Bundle(1);
            params.putCharSequence("fb_iap_product_id", purchaseJSON.getString("productId"));
            params.putCharSequence("fb_iap_purchase_time", purchaseJSON.getString("purchaseTime"));
            params.putCharSequence("fb_iap_purchase_token", purchaseJSON.getString("purchaseToken"));
            params.putCharSequence("fb_iap_package_name", purchaseJSON.optString("packageName"));
            params.putCharSequence("fb_iap_product_title", skuDetailsJSON.optString("title"));
            params.putCharSequence("fb_iap_product_description", skuDetailsJSON.optString(Repo.COLUMN_DESCRIPTION));
            String type = skuDetailsJSON.optString("type");
            params.putCharSequence("fb_iap_product_type", type);
            if (type.equals(ExternalBillingBinder.ITEM_TYPE_SUBS)) {
                params.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(purchaseJSON.optBoolean("autoRenewing", false)));
                params.putCharSequence("fb_iap_subs_period", skuDetailsJSON.optString("subscriptionPeriod"));
                params.putCharSequence("fb_free_trial_period", skuDetailsJSON.optString("freeTrialPeriod"));
                String introductoryPriceCycles = skuDetailsJSON.optString("introductoryPriceCycles");
                if (!introductoryPriceCycles.isEmpty()) {
                    params.putCharSequence("fb_intro_price_amount_micros", skuDetailsJSON.optString("introductoryPriceAmountMicros"));
                    params.putCharSequence("fb_intro_price_cycles", introductoryPriceCycles);
                }
            }
            for (String key : extraParameter.keySet()) {
                params.putCharSequence(key, (CharSequence) extraParameter.get(key));
            }
            double d = (double) skuDetailsJSON.getLong("price_amount_micros");
            Double.isNaN(d);
            return new C6609a(new BigDecimal(d / 1000000.0d), Currency.getInstance(skuDetailsJSON.getString("price_currency_code")), params);
        } catch (JSONException e) {
            Log.e(f12007a, "Error parsing in-app subscription data.", e);
            return null;
        }
    }
}
