package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import com.mopub.common.AdType;
import com.vungle.warren.model.Advertisement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcau {

    /* renamed from: a */
    private final Context f26285a;

    /* renamed from: b */
    private final zzcan f26286b;

    /* renamed from: c */
    private final zzdh f26287c;

    /* renamed from: d */
    private final zzbai f26288d;

    /* renamed from: e */
    private final zza f26289e;

    /* renamed from: f */
    private final zzwj f26290f;

    /* renamed from: g */
    private final Executor f26291g;

    /* renamed from: h */
    private final zzady f26292h;

    /* renamed from: i */
    private final zzcbi f26293i;

    /* renamed from: j */
    private final ScheduledExecutorService f26294j;

    public zzcau(Context context, zzcan zzcan, zzdh zzdh, zzbai zzbai, zza zza, zzwj zzwj, Executor executor, zzcxv zzcxv, zzcbi zzcbi, ScheduledExecutorService scheduledExecutorService) {
        this.f26285a = context;
        this.f26286b = zzcan;
        this.f26287c = zzdh;
        this.f26288d = zzbai;
        this.f26289e = zza;
        this.f26290f = zzwj;
        this.f26291g = executor;
        this.f26292h = zzcxv.f27605i;
        this.f26293i = zzcbi;
        this.f26294j = scheduledExecutorService;
    }

    /* renamed from: a */
    public static List<zzabj> m28180a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzabj d = m28182d(optJSONArray.optJSONObject(i));
            if (d != null) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static zzabj m28181b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("default_reason");
        if (optJSONObject2 == null) {
            return null;
        }
        return m28182d(optJSONObject2);
    }

    /* renamed from: d */
    private static zzabj m28182d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzabj(optString, optString2);
    }

    /* renamed from: a */
    public final zzbbh<zzadw> mo31091a(JSONObject jSONObject, String str) {
        return m28178a(jSONObject.optJSONObject(str), this.f26292h.f24266b);
    }

    /* renamed from: b */
    public final zzbbh<List<zzadw>> mo31092b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        zzady zzady = this.f26292h;
        return m28177a(optJSONArray, zzady.f24266b, zzady.f24268d);
    }

    /* renamed from: a */
    private final zzbbh<List<zzadw>> m28177a(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzbar.m26376a(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(m28178a(jSONArray.optJSONObject(i), z));
        }
        return zzbar.m26380a(zzbar.m26382a((Iterable<? extends zzbbh<? extends V>>) arrayList), C8894Hh.f21206a, this.f26291g);
    }

    /* renamed from: a */
    private final zzbbh<zzadw> m28178a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzbar.m26376a(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzbar.m26376a(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            zzadw zzadw = new zzadw(null, Uri.parse(optString), optDouble, optInt, optInt2);
            return zzbar.m26376a(zzadw);
        }
        zzbbh a = this.f26286b.mo31087a(optString, optDouble, optBoolean);
        C8915Ih ih = new C8915Ih(optString, optDouble, optInt, optInt2);
        return m28179a(jSONObject.optBoolean("require"), zzbar.m26380a(a, (zzbam<A, B>) ih, this.f26291g), (T) null);
    }

    /* renamed from: c */
    public final zzbbh<zzadt> mo31094c(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzbar.m26376a(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return m28179a(optJSONObject.optBoolean("require"), zzbar.m26380a(m28177a(optJSONArray, false, true), (zzbam<A, B>) new C8936Jh<A,B>(this, optJSONObject), this.f26291g), (T) null);
    }

    /* renamed from: d */
    private static Integer m28183d(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: c */
    public final zzbbh<zzbgz> mo31093c(JSONObject jSONObject) {
        JSONObject a = zzazc.m26266a(jSONObject, "html_containers", "instream");
        if (a == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(Advertisement.KEY_VIDEO);
            if (optJSONObject == null) {
                return zzbar.m26376a(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzbad.m26359d("Required field 'vast_xml' is missing");
                return zzbar.m26376a(null);
            }
            return m28176a(zzbar.m26378a(this.f26293i.mo31099a(optJSONObject), (long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f23953Jc)).intValue(), TimeUnit.SECONDS, this.f26294j), (T) null);
        }
        return m28179a(a.optBoolean("require"), this.f26293i.mo31097a(a.optString("base_url"), a.optString(AdType.HTML)), (T) null);
    }

    /* renamed from: a */
    private static <T> zzbbh<T> m28176a(zzbbh<T> zzbbh, T t) {
        return zzbar.m26381a(zzbbh, Exception.class, (zzbal<? super X, ? extends V>) new C8978Lh<Object,Object>(null), zzbbm.f25065b);
    }

    /* renamed from: a */
    private static <T> zzbbh<T> m28179a(boolean z, zzbbh<T> zzbbh, T t) {
        if (z) {
            return zzbar.m26379a(zzbbh, (zzbal<? super A, ? extends B>) new C9020Nh<Object,Object>(zzbbh), zzbbm.f25065b);
        }
        return m28176a(zzbbh, (T) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31090a(String str, Object obj) throws Exception {
        zzk.zzlh();
        zzbgz a = zzbhf.m26877a(this.f26285a, zzbin.m27015b(), "native-omid", false, false, this.f26287c, this.f26288d, null, null, this.f26289e, this.f26290f);
        zzbbq c = zzbbq.m26396c(a);
        a.mo28714a().mo30597a((zzbij) new C9041Oh(c));
        a.loadData(str, "text/html", "UTF-8");
        return c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzadt mo31089a(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString(CommandHandler.TEXT);
        Integer d = m28183d(jSONObject, "bg_color");
        Integer d2 = m28183d(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        zzadt zzadt = new zzadt(optString, list, d, d2, num, optInt3 + optInt2, this.f26292h.f24269e, optBoolean);
        return zzadt;
    }
}
