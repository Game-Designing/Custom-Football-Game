package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.e */
/* compiled from: OpenGraphJSONUtility */
public final class C6794e {

    /* renamed from: com.facebook.share.internal.e$a */
    /* compiled from: OpenGraphJSONUtility */
    public interface C6795a {
        /* renamed from: a */
        JSONObject mo20153a(SharePhoto sharePhoto);
    }

    /* renamed from: a */
    public static JSONObject m13851a(ShareOpenGraphAction action, C6795a photoJSONProcessor) throws JSONException {
        JSONObject result = new JSONObject();
        for (String key : action.mo20176b()) {
            result.put(key, m13849a(action.mo20174a(key), photoJSONProcessor));
        }
        return result;
    }

    /* renamed from: a */
    private static JSONObject m13852a(ShareOpenGraphObject object, C6795a photoJSONProcessor) throws JSONException {
        JSONObject result = new JSONObject();
        for (String key : object.mo20176b()) {
            result.put(key, m13849a(object.mo20174a(key), photoJSONProcessor));
        }
        return result;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.Object>, for r4v0, types: [java.util.List, java.util.List<java.lang.Object>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONArray m13850a(java.util.List<java.lang.Object> r4, com.facebook.share.internal.C6794e.C6795a r5) throws org.json.JSONException {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.Iterator r1 = r4.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x001b
            java.lang.Object r2 = r1.next()
            java.lang.Object r3 = m13849a(r2, r5)
            r0.put(r3)
            goto L_0x0009
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.C6794e.m13850a(java.util.List, com.facebook.share.internal.e$a):org.json.JSONArray");
    }

    /* renamed from: a */
    public static Object m13849a(Object object, C6795a photoJSONProcessor) throws JSONException {
        if (object == null) {
            return JSONObject.NULL;
        }
        if ((object instanceof String) || (object instanceof Boolean) || (object instanceof Double) || (object instanceof Float) || (object instanceof Integer) || (object instanceof Long)) {
            return object;
        }
        if (object instanceof SharePhoto) {
            if (photoJSONProcessor != null) {
                return photoJSONProcessor.mo20153a((SharePhoto) object);
            }
            return null;
        } else if (object instanceof ShareOpenGraphObject) {
            return m13852a((ShareOpenGraphObject) object, photoJSONProcessor);
        } else {
            if (object instanceof List) {
                return m13850a((List) object, photoJSONProcessor);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid object found for JSON serialization: ");
            sb.append(object.toString());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
