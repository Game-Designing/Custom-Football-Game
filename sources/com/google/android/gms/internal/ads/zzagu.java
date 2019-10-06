package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzagu implements zzaho<Object> {

    /* renamed from: a */
    private final zzagv f24319a;

    public zzagu(zzagv zzagv) {
        this.f24319a = zzagv;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        if (this.f24319a != null) {
            String str = (String) map.get("name");
            if (str == null) {
                zzbad.m26357c("Ad metadata with no name parameter.");
                str = "";
            }
            String str2 = "info";
            Bundle bundle = null;
            if (map.containsKey(str2)) {
                try {
                    bundle = m25038a(new JSONObject((String) map.get(str2)));
                } catch (JSONException e) {
                    zzbad.m26356b("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzbad.m26355b("Failed to convert ad metadata to Bundle.");
            } else {
                this.f24319a.mo29003a(str, bundle);
            }
        }
    }

    /* renamed from: a */
    private static Bundle m25038a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    bundle.putString(str, (String) obj);
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    if (!(jSONArray == null || jSONArray.length() == 0)) {
                        int length = jSONArray.length();
                        int i = 0;
                        Object obj2 = null;
                        int i2 = 0;
                        while (obj2 == null && i2 < length) {
                            obj2 = !jSONArray.isNull(i2) ? jSONArray.get(i2) : null;
                            i2++;
                        }
                        if (obj2 == null) {
                            String str2 = "Expected JSONArray with at least 1 non-null element for key:";
                            String valueOf = String.valueOf(str);
                            zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                        } else if (obj2 instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i < length) {
                                bundleArr[i] = !jSONArray.isNull(i) ? m25038a(jSONArray.optJSONObject(i)) : null;
                                i++;
                            }
                            bundle.putParcelableArray(str, bundleArr);
                        } else if (obj2 instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i < length) {
                                dArr[i] = jSONArray.optDouble(i);
                                i++;
                            }
                            bundle.putDoubleArray(str, dArr);
                        } else if (obj2 instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i < length) {
                                strArr[i] = !jSONArray.isNull(i) ? jSONArray.optString(i) : null;
                                i++;
                            }
                            bundle.putStringArray(str, strArr);
                        } else if (obj2 instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i < length) {
                                zArr[i] = jSONArray.optBoolean(i);
                                i++;
                            }
                            bundle.putBooleanArray(str, zArr);
                        } else {
                            zzbad.m26359d(String.format("JSONArray with unsupported type %s for key:%s", new Object[]{obj2.getClass().getCanonicalName(), str}));
                        }
                    }
                } else if (obj instanceof JSONObject) {
                    bundle.putBundle(str, m25038a((JSONObject) obj));
                } else {
                    String str3 = "Unsupported type for key:";
                    String valueOf2 = String.valueOf(str);
                    zzbad.m26359d(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                }
            }
        }
        return bundle;
    }
}
