package com.facebook.internal;

import com.facebook.FacebookRequestError.C6541a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.facebook.internal.t */
/* compiled from: FacebookRequestErrorClassification */
public final class C6732t {

    /* renamed from: a */
    private static C6732t f12299a;

    /* renamed from: b */
    private final Map<Integer, Set<Integer>> f12300b;

    /* renamed from: c */
    private final Map<Integer, Set<Integer>> f12301c;

    /* renamed from: d */
    private final Map<Integer, Set<Integer>> f12302d;

    /* renamed from: e */
    private final String f12303e;

    /* renamed from: f */
    private final String f12304f;

    /* renamed from: g */
    private final String f12305g;

    C6732t(Map<Integer, Set<Integer>> otherErrors, Map<Integer, Set<Integer>> transientErrors, Map<Integer, Set<Integer>> loginRecoverableErrors, String otherRecoveryMessage, String transientRecoveryMessage, String loginRecoverableRecoveryMessage) {
        this.f12300b = otherErrors;
        this.f12301c = transientErrors;
        this.f12302d = loginRecoverableErrors;
        this.f12303e = otherRecoveryMessage;
        this.f12304f = transientRecoveryMessage;
        this.f12305g = loginRecoverableRecoveryMessage;
    }

    /* renamed from: a */
    public String mo19970a(C6541a category) {
        int i = C6731s.f12298a[category.ordinal()];
        if (i == 1) {
            return this.f12303e;
        }
        if (i == 2) {
            return this.f12305g;
        }
        if (i != 3) {
            return null;
        }
        return this.f12304f;
    }

    /* renamed from: a */
    public C6541a mo19969a(int errorCode, int errorSubCode, boolean isTransient) {
        if (isTransient) {
            return C6541a.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.f12300b;
        if (map != null && map.containsKey(Integer.valueOf(errorCode))) {
            Set<Integer> subCodes = (Set) this.f12300b.get(Integer.valueOf(errorCode));
            if (subCodes == null || subCodes.contains(Integer.valueOf(errorSubCode))) {
                return C6541a.OTHER;
            }
        }
        Map<Integer, Set<Integer>> map2 = this.f12302d;
        if (map2 != null && map2.containsKey(Integer.valueOf(errorCode))) {
            Set<Integer> subCodes2 = (Set) this.f12302d.get(Integer.valueOf(errorCode));
            if (subCodes2 == null || subCodes2.contains(Integer.valueOf(errorSubCode))) {
                return C6541a.LOGIN_RECOVERABLE;
            }
        }
        Map<Integer, Set<Integer>> map3 = this.f12301c;
        if (map3 != null && map3.containsKey(Integer.valueOf(errorCode))) {
            Set<Integer> subCodes3 = (Set) this.f12301c.get(Integer.valueOf(errorCode));
            if (subCodes3 == null || subCodes3.contains(Integer.valueOf(errorSubCode))) {
                return C6541a.TRANSIENT;
            }
        }
        return C6541a.OTHER;
    }

    /* renamed from: a */
    public static synchronized C6732t m13557a() {
        C6732t tVar;
        synchronized (C6732t.class) {
            if (f12299a == null) {
                f12299a = m13560b();
            }
            tVar = f12299a;
        }
        return tVar;
    }

    /* renamed from: b */
    private static C6732t m13560b() {
        C6732t tVar = new C6732t(null, new C6729q<>(), new C6730r<>(), null, null, null);
        return tVar;
    }

    /* renamed from: a */
    private static Map<Integer, Set<Integer>> m13559a(JSONObject definition) {
        JSONArray itemsArray = definition.optJSONArray(Repo.COLUMN_ITEMS);
        if (itemsArray.length() == 0) {
            return null;
        }
        Map<Integer, Set<Integer>> items = new HashMap<>();
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.optJSONObject(i);
            if (item != null) {
                int code = item.optInt("code");
                if (code != 0) {
                    Set<Integer> subcodes = null;
                    JSONArray subcodesArray = item.optJSONArray("subcodes");
                    if (subcodesArray != null && subcodesArray.length() > 0) {
                        subcodes = new HashSet<>();
                        for (int j = 0; j < subcodesArray.length(); j++) {
                            int subCode = subcodesArray.optInt(j);
                            if (subCode != 0) {
                                subcodes.add(Integer.valueOf(subCode));
                            }
                        }
                    }
                    items.put(Integer.valueOf(code), subcodes);
                }
            }
        }
        return items;
    }

    /* renamed from: a */
    public static C6732t m13558a(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        Map<Integer, Set<Integer>> otherErrors = null;
        Map<Integer, Set<Integer>> transientErrors = null;
        Map<Integer, Set<Integer>> loginRecoverableErrors = null;
        String otherRecoveryMessage = null;
        String transientRecoveryMessage = null;
        String loginRecoverableRecoveryMessage = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject definition = jsonArray.optJSONObject(i);
            if (definition != null) {
                String name = definition.optString("name");
                if (name != null) {
                    String str = "recovery_message";
                    if (name.equalsIgnoreCase("other")) {
                        otherRecoveryMessage = definition.optString(str, null);
                        otherErrors = m13559a(definition);
                    } else if (name.equalsIgnoreCase("transient")) {
                        transientRecoveryMessage = definition.optString(str, null);
                        transientErrors = m13559a(definition);
                    } else if (name.equalsIgnoreCase("login_recoverable")) {
                        loginRecoverableRecoveryMessage = definition.optString(str, null);
                        loginRecoverableErrors = m13559a(definition);
                    }
                }
            }
        }
        C6732t tVar = new C6732t(otherErrors, transientErrors, loginRecoverableErrors, otherRecoveryMessage, transientRecoveryMessage, loginRecoverableRecoveryMessage);
        return tVar;
    }
}
