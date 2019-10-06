package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.internal.extensions.Extension;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p252i.C12280f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.smaato.soma.c.g.d */
/* compiled from: JsonResponseParser */
abstract class C12257d {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C12064Na mo39631a(JSONObject jSONObject) throws ParserException;

    C12257d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Vector<String> mo39633a(JSONArray jsonArray) {
        Vector<String> values = new Vector<>();
        if (jsonArray != null && jsonArray.length() > 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                values.add(C12280f.m40426a(jsonArray.optString(i)));
            }
        }
        return values;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo39632a(String jsonParams) throws JSONException {
        Map<String, String> jsonMap = new HashMap<>();
        if (C12280f.m40428a((CharSequence) jsonParams)) {
            return jsonMap;
        }
        JSONObject jsonObject = (JSONObject) new JSONTokener(jsonParams).nextValue();
        Iterator<?> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            jsonMap.put(key, jsonObject.getString(key));
        }
        return jsonMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<C12204a> mo39634b(JSONObject rootJsonObject) throws JSONException {
        JSONObject extensionJsonObject = rootJsonObject.optJSONObject("ext");
        if (extensionJsonObject != null) {
            JSONArray smaatoExtensionsObject = extensionJsonObject.optJSONArray("smaatoexts");
            if (smaatoExtensionsObject != null && smaatoExtensionsObject.length() > 0) {
                return m40325b(smaatoExtensionsObject);
            }
        }
        return null;
    }

    /* renamed from: b */
    private List<C12204a> m40325b(JSONArray extensions) throws JSONException {
        List<Extension> result = new ArrayList<>();
        for (int i = 0; i < extensions.length(); i++) {
            JSONObject extension = extensions.getJSONObject(i);
            String name = extension.optString("name");
            String script = extension.optString("script");
            JSONObject conf = extension.optJSONObject("conf");
            HashMap hashMap = null;
            if (conf != null) {
                hashMap = new HashMap();
                Iterator<String> confKeys = conf.keys();
                while (confKeys.hasNext()) {
                    String key = (String) confKeys.next();
                    hashMap.put(key, conf.optString(key));
                }
            }
            result.add(new C12204a(name, script, hashMap));
        }
        return result;
    }
}
