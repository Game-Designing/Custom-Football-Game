package com.facebook.p127a.p130b;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.facebook.C6787r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.s */
/* compiled from: InAppPurchaseActivityLifecycleTracker */
public class C6615s {

    /* renamed from: a */
    private static final String f12014a = C6615s.class.getCanonicalName();

    /* renamed from: b */
    private static final AtomicBoolean f12015b = new AtomicBoolean(false);

    /* renamed from: c */
    private static Boolean f12016c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Boolean f12017d = null;

    /* renamed from: e */
    private static ServiceConnection f12018e;

    /* renamed from: f */
    private static ActivityLifecycleCallbacks f12019f;

    /* renamed from: g */
    private static Intent f12020g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static Object f12021h;

    /* renamed from: c */
    public static void m13129c() {
        m13130d();
        if (f12016c.booleanValue() && C6608m.m13118a()) {
            m13131e();
        }
    }

    /* renamed from: d */
    private static void m13130d() {
        if (f12016c == null) {
            try {
                Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                f12016c = Boolean.valueOf(true);
                try {
                    Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                    f12017d = Boolean.valueOf(true);
                } catch (ClassNotFoundException e) {
                    f12017d = Boolean.valueOf(false);
                }
                C6616t.m13145a();
                f12020g = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                f12018e = new C6611o();
                f12019f = new C6614r();
            } catch (ClassNotFoundException e2) {
                f12016c = Boolean.valueOf(false);
            }
        }
    }

    /* renamed from: e */
    private static void m13131e() {
        if (f12015b.compareAndSet(false, true)) {
            Context context = C6787r.m13815e();
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(f12019f);
                context.bindService(f12020g, f12018e, 1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m13127b(Context context, ArrayList<String> purchases) {
        if (!purchases.isEmpty()) {
            Map<String, String> purchaseMap = new HashMap<>();
            ArrayList<String> skuList = new ArrayList<>();
            Iterator it = purchases.iterator();
            while (it.hasNext()) {
                String purchase = (String) it.next();
                try {
                    String sku = new JSONObject(purchase).getString("productId");
                    purchaseMap.put(sku, purchase);
                    skuList.add(sku);
                } catch (JSONException e) {
                    Log.e(f12014a, "Error parsing in-app purchase data.", e);
                }
            }
            for (Entry<String, String> pair : C6616t.m13144a(context, skuList, f12021h, false).entrySet()) {
                C6608m.m13117a((String) purchaseMap.get(pair.getKey()), (String) pair.getValue());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m13128b(Context context, Map<String, C6620x> purchasesSubsTypeMap, Map<String, String> extraParameter) {
        if (!purchasesSubsTypeMap.isEmpty()) {
            Map<String, String> skuPurchaseMap = new HashMap<>();
            ArrayList<String> skuList = new ArrayList<>();
            for (String purchase : purchasesSubsTypeMap.keySet()) {
                try {
                    String sku = new JSONObject(purchase).getString("productId");
                    skuList.add(sku);
                    skuPurchaseMap.put(sku, purchase);
                } catch (JSONException e) {
                    Log.e(f12014a, "Error parsing in-app purchase data.", e);
                }
            }
            Map<String, String> skuDetailsMap = C6616t.m13144a(context, skuList, f12021h, true);
            for (String sku2 : skuDetailsMap.keySet()) {
                String purchase2 = (String) skuPurchaseMap.get(sku2);
                C6608m.m13115a((C6620x) purchasesSubsTypeMap.get(purchase2), purchase2, (String) skuDetailsMap.get(sku2), extraParameter);
            }
        }
    }
}
