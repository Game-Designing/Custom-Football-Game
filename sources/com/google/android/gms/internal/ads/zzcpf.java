package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcpf {

    /* renamed from: a */
    private final zzclc f27155a;

    /* renamed from: b */
    private final Map<String, zzcpk> f27156b = new ConcurrentHashMap();

    /* renamed from: c */
    private final Map<String, List<zzcpk>> f27157c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Executor f27158d;

    /* renamed from: e */
    private final Context f27159e;

    public zzcpf(zzclc zzclc, Executor executor, Context context) {
        this.f27155a = zzclc;
        this.f27158d = executor;
        this.f27159e = context;
    }

    /* renamed from: a */
    public final void mo31222a() {
        zzk.zzlk().mo30177i().mo30202a((Runnable) new C8981Lk(this));
        this.f27158d.execute(new C9002Mk(this));
    }

    /* renamed from: b */
    public final Map<String, List<zzcpk>> mo31224b() {
        return this.f27157c;
    }

    /* renamed from: a */
    public final void mo31223a(String str) {
        if (!TextUtils.isEmpty(str) && !this.f27156b.containsKey(str)) {
            try {
                this.f27156b.put(str, new zzcpk(str, "", new Bundle(), this.f27155a.mo31201a(str)));
            } catch (RemoteException e) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final synchronized void mo31227e() {
        synchronized (this) {
            JSONObject f = zzk.zzlk().mo30177i().mo30222k().mo30164f();
            if (f != null) {
                try {
                    JSONArray optJSONArray = f.optJSONArray("ad_unit_id_settings");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject = optJSONArray.getJSONObject(i);
                            String optString = jSONObject.optString("ad_unit_id", "");
                            String optString2 = jSONObject.optString("format", "");
                            ArrayList arrayList = new ArrayList();
                            JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("ad_networks");
                                if (optJSONArray2 != null) {
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                        ArrayList arrayList2 = new ArrayList();
                                        if (jSONObject2 != null) {
                                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                            Bundle bundle = new Bundle();
                                            if (optJSONObject2 != null) {
                                                Iterator keys = optJSONObject2.keys();
                                                while (keys.hasNext()) {
                                                    String str = (String) keys.next();
                                                    bundle.putString(str, optJSONObject2.optString(str, ""));
                                                }
                                            }
                                            JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                            if (optJSONArray3 != null) {
                                                ArrayList arrayList3 = new ArrayList();
                                                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                                    String optString3 = optJSONArray3.optString(i3, "");
                                                    if (!TextUtils.isEmpty(optString3)) {
                                                        arrayList3.add(optString3);
                                                    }
                                                }
                                                int size = arrayList3.size();
                                                int i4 = 0;
                                                while (i4 < size) {
                                                    Object obj = arrayList3.get(i4);
                                                    i4++;
                                                    String str2 = (String) obj;
                                                    mo31223a(str2);
                                                    zzcpk zzcpk = (zzcpk) this.f27156b.get(str2);
                                                    if (zzcpk != null) {
                                                        arrayList2.add(new zzcpk(str2, optString2, bundle, zzcpk.f27166d));
                                                    }
                                                }
                                            }
                                        }
                                        arrayList.addAll(arrayList2);
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(optString)) {
                                this.f27157c.put(optString, arrayList);
                            }
                        }
                    }
                } catch (JSONException e) {
                    zzawz.m26002e("Malformed config loading JSON.", e);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ void mo31226d() {
        this.f27158d.execute(new C9023Nk(this));
    }
}
