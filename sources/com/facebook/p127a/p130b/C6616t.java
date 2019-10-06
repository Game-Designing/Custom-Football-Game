package com.facebook.p127a.p130b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.appevents.internal.SubscriptionType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingBinder;

/* renamed from: com.facebook.a.b.t */
/* compiled from: InAppPurchaseEventManager */
class C6616t {

    /* renamed from: a */
    private static final String f12022a = C6616t.class.getCanonicalName();

    /* renamed from: b */
    private static final HashMap<String, Method> f12023b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, Class<?>> f12024c = new HashMap<>();

    /* renamed from: d */
    private static final String f12025d = C6787r.m13815e().getPackageName();

    /* renamed from: e */
    private static final SharedPreferences f12026e = C6787r.m13815e().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);

    /* renamed from: f */
    private static final SharedPreferences f12027f = C6787r.m13815e().getSharedPreferences("com.facebook.internal.PURCHASE", 0);

    /* renamed from: g */
    private static final SharedPreferences f12028g = C6787r.m13815e().getSharedPreferences("com.facebook.internal.PURCHASE_SUBS", 0);

    C6616t() {
    }

    /* renamed from: a */
    public static Object m13134a(Context context, IBinder service) {
        return m13135a(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{service});
    }

    /* renamed from: a */
    private static String m13137a(Context context, String sku, Object inAppBillingObj, boolean isSubscription) {
        ArrayList<String> skuList = new ArrayList<>();
        skuList.add(sku);
        return (String) m13144a(context, skuList, inAppBillingObj, isSubscription).get(sku);
    }

    /* renamed from: a */
    public static Map<String, String> m13144a(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        Map<String, String> skuDetailsMap = m13150b(skuList);
        ArrayList<String> unresolvedSkuList = new ArrayList<>();
        Iterator it = skuList.iterator();
        while (it.hasNext()) {
            String sku = (String) it.next();
            if (!skuDetailsMap.containsKey(sku)) {
                unresolvedSkuList.add(sku);
            }
        }
        skuDetailsMap.putAll(m13149b(context, unresolvedSkuList, inAppBillingObj, isSubscription));
        return skuDetailsMap;
    }

    /* renamed from: b */
    private static Map<String, String> m13149b(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        Map<String, String> skuDetailsMap = new HashMap<>();
        if (inAppBillingObj == null || skuList.isEmpty()) {
            return skuDetailsMap;
        }
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList(ExternalBillingBinder.ITEM_ID_LIST, skuList);
        Object[] args = new Object[4];
        args[0] = Integer.valueOf(3);
        args[1] = f12025d;
        args[2] = isSubscription ? ExternalBillingBinder.ITEM_TYPE_SUBS : ExternalBillingBinder.ITEM_TYPE_INAPP;
        args[3] = querySkus;
        Object result = m13135a(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", inAppBillingObj, args);
        if (result != null) {
            Bundle bundle = (Bundle) result;
            if (bundle.getInt(ExternalBillingBinder.RESPONSE_CODE) == 0) {
                ArrayList<String> skuDetailsList = bundle.getStringArrayList(ExternalBillingBinder.DETAILS_LIST);
                if (skuDetailsList != null && skuList.size() == skuDetailsList.size()) {
                    for (int i = 0; i < skuList.size(); i++) {
                        skuDetailsMap.put(skuList.get(i), skuDetailsList.get(i));
                    }
                }
                m13146a(skuDetailsMap);
            }
        }
        return skuDetailsMap;
    }

    /* renamed from: b */
    private static Map<String, String> m13150b(ArrayList<String> skuList) {
        Map<String, String> skuDetailsMap = new HashMap<>();
        long nowSec = System.currentTimeMillis() / 1000;
        Iterator it = skuList.iterator();
        while (it.hasNext()) {
            String sku = (String) it.next();
            String rawString = f12026e.getString(sku, null);
            if (rawString != null) {
                String[] splitted = rawString.split(";", 2);
                if (nowSec - Long.parseLong(splitted[0]) < 43200) {
                    skuDetailsMap.put(sku, splitted[1]);
                }
            }
        }
        return skuDetailsMap;
    }

    /* renamed from: a */
    private static void m13146a(Map<String, String> skuDetailsMap) {
        long nowSec = System.currentTimeMillis() / 1000;
        Editor editor = f12026e.edit();
        for (Entry<String, String> pair : skuDetailsMap.entrySet()) {
            String str = (String) pair.getKey();
            StringBuilder sb = new StringBuilder();
            sb.append(nowSec);
            sb.append(";");
            sb.append((String) pair.getValue());
            editor.putString(str, sb.toString());
        }
        editor.apply();
    }

    /* renamed from: c */
    private static Boolean m13151c(Context context, Object inAppBillingObj, String type) {
        boolean z = false;
        if (inAppBillingObj == null) {
            return Boolean.valueOf(false);
        }
        Object result = m13135a(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", inAppBillingObj, new Object[]{Integer.valueOf(3), f12025d, type});
        if (result != null && ((Integer) result).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: b */
    public static ArrayList<String> m13147b(Context context, Object inAppBillingObj) {
        return m13143a(m13148b(context, inAppBillingObj, ExternalBillingBinder.ITEM_TYPE_INAPP));
    }

    /* renamed from: a */
    static ArrayList<String> m13142a(Context context, Object inAppBillingObj, Set<Integer> errorCodes) {
        ArrayList<String> expirePurchases = new ArrayList<>();
        Map<String, ?> keys = f12028g.getAll();
        if (keys.isEmpty()) {
            return expirePurchases;
        }
        ArrayList<String> currPurchases = m13141a(context, inAppBillingObj, ExternalBillingBinder.ITEM_TYPE_SUBS, errorCodes);
        Set<String> currSkuSet = new HashSet<>();
        Iterator it = currPurchases.iterator();
        while (it.hasNext()) {
            try {
                currSkuSet.add(new JSONObject((String) it.next()).getString("productId"));
            } catch (JSONException e) {
                Log.e(f12022a, "Error parsing purchase json", e);
            }
        }
        Set<String> expireSkuSet = new HashSet<>();
        for (Entry<String, ?> entry : keys.entrySet()) {
            String sku = (String) entry.getKey();
            if (!currSkuSet.contains(sku)) {
                expireSkuSet.add(sku);
            }
        }
        Editor editor = f12028g.edit();
        for (String expireSku : expireSkuSet) {
            String str = "";
            String expirePurchase = f12028g.getString(expireSku, str);
            editor.remove(expireSku);
            if (!expirePurchase.isEmpty()) {
                expirePurchases.add(f12028g.getString(expireSku, str));
            }
        }
        editor.apply();
        return expirePurchases;
    }

    /* renamed from: c */
    public static Map<String, C6620x> m13152c(Context context, Object inAppBillingObj) {
        Map<String, SubscriptionType> purchaseMap = new HashMap<>();
        Iterator it = m13148b(context, inAppBillingObj, ExternalBillingBinder.ITEM_TYPE_SUBS).iterator();
        while (it.hasNext()) {
            String purchase = (String) it.next();
            C6620x subsType = m13132a(context, purchase, inAppBillingObj);
            if (!(subsType == C6620x.DUPLICATED || subsType == C6620x.UNKNOWN)) {
                purchaseMap.put(purchase, subsType);
            }
        }
        return purchaseMap;
    }

    /* renamed from: a */
    private static C6620x m13132a(Context context, String purchase, Object inAppBillingObj) {
        C6620x xVar;
        String str = "autoRenewing";
        String str2 = "purchaseToken";
        C6620x subsType = null;
        try {
            long nowSec = System.currentTimeMillis() / 1000;
            try {
                JSONObject purchaseJson = new JSONObject(purchase);
                String sku = purchaseJson.getString("productId");
                String oldPurchase = f12028g.getString(sku, "");
                JSONObject oldPurchaseJson = oldPurchase.isEmpty() ? new JSONObject() : new JSONObject(oldPurchase);
                if (!oldPurchaseJson.optString(str2).equals(purchaseJson.get(str2))) {
                    if (nowSec - (purchaseJson.getLong("purchaseTime") / 1000) < 86400) {
                        try {
                            String skuDetail = m13137a(context, sku, inAppBillingObj, true);
                            if (skuDetail != null) {
                                String freeTrialPeriod = new JSONObject(skuDetail).optString("freeTrialPeriod");
                                if (freeTrialPeriod != null) {
                                    if (!freeTrialPeriod.isEmpty()) {
                                        xVar = C6620x.START_TRIAL;
                                        subsType = xVar;
                                    }
                                }
                                xVar = C6620x.SUBSCRIBE;
                                subsType = xVar;
                            }
                        } catch (JSONException e) {
                            e = e;
                            Log.e(f12022a, "parsing purchase failure: ", e);
                            return C6620x.UNKNOWN;
                        }
                    } else {
                        Context context2 = context;
                        Object obj = inAppBillingObj;
                    }
                    if (subsType == null) {
                        subsType = C6620x.HEARTBEAT;
                    }
                } else {
                    Context context3 = context;
                    Object obj2 = inAppBillingObj;
                }
                if (subsType == null && !oldPurchase.isEmpty()) {
                    boolean oldAutoRenewing = oldPurchaseJson.getBoolean(str);
                    boolean newAutoRenewing = purchaseJson.getBoolean(str);
                    if (!newAutoRenewing && oldAutoRenewing) {
                        subsType = C6620x.CANCEL;
                    } else if (!oldAutoRenewing && newAutoRenewing) {
                        subsType = C6620x.RESTORE;
                    }
                }
                String str3 = "LAST_LOGGED_TIME_SEC";
                if (subsType == null) {
                    if (!oldPurchase.isEmpty()) {
                        if (nowSec - oldPurchaseJson.getLong(str3) > 43200) {
                            subsType = C6620x.HEARTBEAT;
                        } else {
                            subsType = C6620x.DUPLICATED;
                        }
                    }
                }
                if (subsType != C6620x.DUPLICATED) {
                    purchaseJson.put(str3, nowSec);
                    f12028g.edit().putString(sku, purchaseJson.toString()).apply();
                }
                return subsType;
            } catch (JSONException e2) {
                e = e2;
                Context context4 = context;
                Object obj3 = inAppBillingObj;
                Log.e(f12022a, "parsing purchase failure: ", e);
                return C6620x.UNKNOWN;
            }
        } catch (JSONException e3) {
            e = e3;
            Context context5 = context;
            String str4 = purchase;
            Object obj32 = inAppBillingObj;
            Log.e(f12022a, "parsing purchase failure: ", e);
            return C6620x.UNKNOWN;
        }
    }

    /* renamed from: b */
    private static ArrayList<String> m13148b(Context context, Object inAppBillingObj, String type) {
        return m13141a(context, inAppBillingObj, type, (Set<Integer>) new HashSet<Integer>());
    }

    /* renamed from: a */
    private static ArrayList<String> m13141a(Context context, Object inAppBillingObj, String type, Set<Integer> errorCodes) {
        ArrayList<String> purchases = new ArrayList<>();
        if (inAppBillingObj == null) {
            return purchases;
        }
        if (m13151c(context, inAppBillingObj, type).booleanValue()) {
            String continuationToken = null;
            int queriedPurchaseNum = 0;
            do {
                Context context2 = context;
                Object result = m13136a(context2, "com.android.vending.billing.IInAppBillingService", "getPurchases", inAppBillingObj, new Object[]{Integer.valueOf(3), f12025d, type, continuationToken}, errorCodes);
                continuationToken = null;
                if (result != null) {
                    Bundle purchaseDetails = (Bundle) result;
                    if (purchaseDetails.getInt(ExternalBillingBinder.RESPONSE_CODE) == 0) {
                        ArrayList<String> details = purchaseDetails.getStringArrayList(ExternalBillingBinder.INAPP_PURCHASE_DATA_LIST);
                        if (details == null) {
                            break;
                        }
                        queriedPurchaseNum += details.size();
                        purchases.addAll(details);
                        continuationToken = purchaseDetails.getString(ExternalBillingBinder.INAPP_CONTINUATION_TOKEN);
                    }
                } else {
                    errorCodes.add(Integer.valueOf(7));
                }
                if (queriedPurchaseNum >= 30) {
                    break;
                }
            } while (continuationToken != null);
            if (queriedPurchaseNum >= 30) {
                errorCodes.add(Integer.valueOf(6));
            }
        } else {
            errorCodes.add(Integer.valueOf(0));
        }
        return purchases;
    }

    /* renamed from: a */
    public static ArrayList<String> m13139a(Context context, Object inAppBillingObj) {
        ArrayList<String> purchases = new ArrayList<>();
        if (inAppBillingObj == null) {
            return purchases;
        }
        Class<?> iapClass = m13133a(context, "com.android.vending.billing.IInAppBillingService");
        if (iapClass == null || m13138a(iapClass, "getPurchaseHistory") == null) {
            return purchases;
        }
        return m13143a(m13140a(context, inAppBillingObj, ExternalBillingBinder.ITEM_TYPE_INAPP));
    }

    /* renamed from: a */
    private static ArrayList<String> m13140a(Context context, Object inAppBillingObj, String type) {
        ArrayList arrayList = new ArrayList();
        if (m13151c(context, inAppBillingObj, type).booleanValue()) {
            Object obj = null;
            int queriedPurchaseNum = 0;
            char c = 0;
            Boolean reachTimeLimit = Boolean.valueOf(false);
            while (true) {
                Object[] args = new Object[5];
                args[c] = Integer.valueOf(6);
                args[1] = f12025d;
                args[2] = type;
                args[3] = obj;
                args[4] = new Bundle();
                Object result = m13135a(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", inAppBillingObj, args);
                if (result != null) {
                    long j = 1000;
                    long nowSec = System.currentTimeMillis() / 1000;
                    Bundle purchaseDetails = (Bundle) result;
                    if (purchaseDetails.getInt(ExternalBillingBinder.RESPONSE_CODE) == 0) {
                        Iterator it = purchaseDetails.getStringArrayList(ExternalBillingBinder.INAPP_PURCHASE_DATA_LIST).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String detail = (String) it.next();
                            try {
                                try {
                                    if (nowSec - (new JSONObject(detail).getLong("purchaseTime") / j) > 1200) {
                                        reachTimeLimit = Boolean.valueOf(true);
                                        break;
                                    }
                                    arrayList.add(detail);
                                    queriedPurchaseNum++;
                                    j = 1000;
                                } catch (JSONException e) {
                                    e = e;
                                    Log.e(f12022a, "parsing purchase failure: ", e);
                                    j = 1000;
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                Log.e(f12022a, "parsing purchase failure: ", e);
                                j = 1000;
                            }
                        }
                        obj = purchaseDetails.getString(ExternalBillingBinder.INAPP_CONTINUATION_TOKEN);
                        if (queriedPurchaseNum >= 30 || obj == null || reachTimeLimit.booleanValue()) {
                            break;
                        }
                        c = 0;
                    }
                }
                obj = null;
                c = 0;
            }
        } else {
            Context context2 = context;
            Object obj2 = inAppBillingObj;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static ArrayList<String> m13143a(ArrayList<String> purchases) {
        ArrayList arrayList = new ArrayList();
        Editor editor = f12027f.edit();
        long nowSec = System.currentTimeMillis() / 1000;
        Iterator it = purchases.iterator();
        while (it.hasNext()) {
            String purchase = (String) it.next();
            try {
                JSONObject purchaseJson = new JSONObject(purchase);
                String sku = purchaseJson.getString("productId");
                long purchaseTimeMillis = purchaseJson.getLong("purchaseTime");
                String purchaseToken = purchaseJson.getString("purchaseToken");
                if (nowSec - (purchaseTimeMillis / 1000) <= 86400) {
                    if (!f12027f.getString(sku, "").equals(purchaseToken)) {
                        editor.putString(sku, purchaseToken);
                        arrayList.add(purchase);
                    }
                }
            } catch (JSONException e) {
                Log.e(f12022a, "parsing purchase failure: ", e);
            }
        }
        editor.apply();
        return arrayList;
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method m13138a(java.lang.Class<?> r9, java.lang.String r10) {
        /*
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r0 = f12023b
            java.lang.Object r0 = r0.get(r10)
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            r1 = 0
            r2 = -1
            int r3 = r10.hashCode()     // Catch:{ NoSuchMethodException -> 0x00bb }
            r4 = 4
            r5 = 0
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r3) {
                case -1801122596: goto L_0x0042;
                case -1450694211: goto L_0x0038;
                case -1123215065: goto L_0x002e;
                case -594356707: goto L_0x0024;
                case -573310373: goto L_0x001a;
                default: goto L_0x0019;
            }     // Catch:{ NoSuchMethodException -> 0x00bb }
        L_0x0019:
            goto L_0x004b
        L_0x001a:
            java.lang.String r3 = "getSkuDetails"
            boolean r3 = r10.equals(r3)     // Catch:{ NoSuchMethodException -> 0x00bb }
            if (r3 == 0) goto L_0x0019
            r2 = 1
            goto L_0x004b
        L_0x0024:
            java.lang.String r3 = "getPurchaseHistory"
            boolean r3 = r10.equals(r3)     // Catch:{ NoSuchMethodException -> 0x00bb }
            if (r3 == 0) goto L_0x0019
            r2 = 4
            goto L_0x004b
        L_0x002e:
            java.lang.String r3 = "asInterface"
            boolean r3 = r10.equals(r3)     // Catch:{ NoSuchMethodException -> 0x00bb }
            if (r3 == 0) goto L_0x0019
            r2 = 0
            goto L_0x004b
        L_0x0038:
            java.lang.String r3 = "isBillingSupported"
            boolean r3 = r10.equals(r3)     // Catch:{ NoSuchMethodException -> 0x00bb }
            if (r3 == 0) goto L_0x0019
            r2 = 2
            goto L_0x004b
        L_0x0042:
            java.lang.String r3 = "getPurchases"
            boolean r3 = r10.equals(r3)     // Catch:{ NoSuchMethodException -> 0x00bb }
            if (r3 == 0) goto L_0x0019
            r2 = 3
        L_0x004b:
            if (r2 == 0) goto L_0x00a7
            if (r2 == r8) goto L_0x0093
            if (r2 == r7) goto L_0x0083
            if (r2 == r6) goto L_0x006f
            if (r2 == r4) goto L_0x0056
            goto L_0x00af
        L_0x0056:
            r2 = 5
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00bb }
            r2[r5] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r8] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r7] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r6] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<android.os.Bundle> r3 = android.os.Bundle.class
            r2[r4] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            r1 = r2
            goto L_0x00af
        L_0x006f:
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00bb }
            r2[r5] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r8] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r7] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r6] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            r1 = r2
            goto L_0x00af
        L_0x0083:
            java.lang.Class[] r2 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00bb }
            r2[r5] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r8] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r7] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            r1 = r2
            goto L_0x00af
        L_0x0093:
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00bb }
            r2[r5] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r8] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r7] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<android.os.Bundle> r3 = android.os.Bundle.class
            r2[r6] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            r1 = r2
            goto L_0x00af
        L_0x00a7:
            java.lang.Class[] r2 = new java.lang.Class[r8]     // Catch:{ NoSuchMethodException -> 0x00bb }
            java.lang.Class<android.os.IBinder> r3 = android.os.IBinder.class
            r2[r5] = r3     // Catch:{ NoSuchMethodException -> 0x00bb }
            r1 = r2
        L_0x00af:
            java.lang.reflect.Method r2 = r9.getDeclaredMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x00bb }
            r0 = r2
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r2 = f12023b     // Catch:{ NoSuchMethodException -> 0x00bb }
            r2.put(r10, r0)     // Catch:{ NoSuchMethodException -> 0x00bb }
            goto L_0x00de
        L_0x00bb:
            r1 = move-exception
            java.lang.String r2 = f12022a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.getName()
            r3.append(r4)
            java.lang.String r4 = "."
            r3.append(r4)
            r3.append(r10)
            java.lang.String r4 = " method not found"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3, r1)
        L_0x00de:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.p127a.p130b.C6616t.m13138a(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    /* renamed from: a */
    private static Class<?> m13133a(Context context, String className) {
        Class<?> classObj = (Class) f12024c.get(className);
        if (classObj != null) {
            return classObj;
        }
        try {
            classObj = context.getClassLoader().loadClass(className);
            f12024c.put(className, classObj);
        } catch (ClassNotFoundException e) {
            String str = f12022a;
            StringBuilder sb = new StringBuilder();
            sb.append(className);
            sb.append(" is not available, please add ");
            sb.append(className);
            sb.append(" to the project.");
            Log.e(str, sb.toString(), e);
        }
        return classObj;
    }

    /* renamed from: a */
    private static Object m13135a(Context context, String className, String methodName, Object obj, Object[] args) {
        return m13136a(context, className, methodName, obj, args, new HashSet());
    }

    /* renamed from: a */
    private static Object m13136a(Context context, String className, String methodName, Object obj, Object[] args, Set<Integer> errorCodes) {
        Class<?> classObj = m13133a(context, className);
        if (classObj == null) {
            errorCodes.add(Integer.valueOf(1));
            return null;
        }
        Method methodObj = m13138a(classObj, methodName);
        if (methodObj == null) {
            errorCodes.add(Integer.valueOf(2));
            return null;
        }
        if (obj != null) {
            obj = classObj.cast(obj);
        } else {
            errorCodes.add(Integer.valueOf(3));
        }
        try {
            return methodObj.invoke(obj, args);
        } catch (IllegalAccessException e) {
            errorCodes.add(Integer.valueOf(4));
            return null;
        } catch (InvocationTargetException e2) {
            errorCodes.add(Integer.valueOf(5));
            return null;
        }
    }

    /* renamed from: a */
    public static void m13145a() {
        long nowSec = System.currentTimeMillis() / 1000;
        String str = "LAST_CLEARED_TIME";
        long lastClearedTimeSec = f12026e.getLong(str, 0);
        if (lastClearedTimeSec == 0) {
            f12026e.edit().putLong(str, nowSec).apply();
        } else if (nowSec - lastClearedTimeSec > 604800) {
            f12026e.edit().clear().putLong(str, nowSec).apply();
        }
    }
}
