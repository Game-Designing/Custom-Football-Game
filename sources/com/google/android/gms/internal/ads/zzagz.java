package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mopub.common.Constants;
import com.vungle.warren.p267ui.VungleWebViewActivity;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzagz {

    /* renamed from: a */
    public static final zzaho<zzbgz> f24321a = C9848z.f23554a;

    /* renamed from: b */
    public static final zzaho<zzbgz> f24322b = C8739A.f20365a;

    /* renamed from: c */
    public static final zzaho<zzbgz> f24323c = C8760B.f20491a;

    /* renamed from: d */
    public static final zzaho<zzbgz> f24324d = new C8823E();

    /* renamed from: e */
    public static final zzaho<zzbgz> f24325e = new C8844F();

    /* renamed from: f */
    public static final zzaho<zzbgz> f24326f = C8781C.f20530a;

    /* renamed from: g */
    public static final zzaho<Object> f24327g = new C8865G();

    /* renamed from: h */
    public static final zzaho<zzbgz> f24328h = new C8886H();

    /* renamed from: i */
    public static final zzaho<zzbgz> f24329i = C8802D.f20575a;

    /* renamed from: j */
    public static final zzaho<zzbgz> f24330j = new C8907I();

    /* renamed from: k */
    public static final zzaho<zzbgz> f24331k = new C8928J();

    /* renamed from: l */
    public static final zzaho<zzbdf> f24332l = new zzbfo();

    /* renamed from: m */
    public static final zzaho<zzbdf> f24333m = new zzbfp();

    /* renamed from: n */
    public static final zzaho<zzbgz> f24334n = new zzagy();

    /* renamed from: o */
    public static final zzahu f24335o = new zzahu();

    /* renamed from: p */
    public static final zzaho<zzbgz> f24336p = new C8949K();

    /* renamed from: q */
    public static final zzaho<zzbgz> f24337q = new C8970L();

    /* renamed from: r */
    public static final zzaho<zzbgz> f24338r = new C8991M();

    /* renamed from: a */
    static final /* synthetic */ void m25045a(zzbif zzbif, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzdh e = zzbif.mo28748e();
            if (e != null) {
                e.mo31483a().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e2) {
            zzbad.m26359d("Could not parse touch parameters from gmsg.");
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m25044a(zzbhx zzbhx, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbad.m26359d("URL missing from httpTrack GMSG.");
        } else {
            new zzazi(zzbhx.getContext(), ((zzbig) zzbhx).mo28793z().f25057a, str).mo30195b();
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m25043a(zzaji zzaji, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbad.m26359d("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzdh e = ((zzbif) zzaji).mo28748e();
            if (e != null && e.mo31485a(parse)) {
                parse = e.mo31482a(parse, ((zzbhx) zzaji).getContext(), ((zzbih) zzaji).getView(), ((zzbhx) zzaji).mo28780q());
            }
        } catch (zzdi e2) {
            String str2 = "Unable to append parameter to URL: ";
            String valueOf = String.valueOf(str);
            zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        zzbhx zzbhx = (zzbhx) zzaji;
        new zzazi(zzbhx.getContext(), ((zzbig) zzaji).mo28793z().f25057a, zzavx.m25930a(parse, zzbhx.getContext())).mo30195b();
    }

    /* renamed from: b */
    static final /* synthetic */ void m25046b(zzbhx zzbhx, Map map) {
        String str = "openableIntents";
        PackageManager packageManager = zzbhx.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString(InneractiveMediationDefs.GENDER_MALE);
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString(InneractiveMediationDefs.GENDER_FEMALE);
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString(VungleWebViewActivity.INTENT_URL);
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String str2 = "Error parsing the url: ";
                                String valueOf = String.valueOf(optString7);
                                zzbad.m26356b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzbad.m26356b("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzbad.m26356b("Error parsing the intent data.", e3);
                    }
                }
                ((zzaji) zzbhx).mo28730a(str, jSONObject);
            } catch (JSONException e4) {
                ((zzaji) zzbhx).mo28730a(str, new JSONObject());
            }
        } catch (JSONException e5) {
            ((zzaji) zzbhx).mo28730a(str, new JSONObject());
        }
    }

    /* renamed from: c */
    static final /* synthetic */ void m25047c(zzbhx zzbhx, Map map) {
        String str = (String) map.get(Constants.VIDEO_TRACKING_URLS_KEY);
        if (TextUtils.isEmpty(str)) {
            zzbad.m26359d("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbhx.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzaji) zzbhx).mo28729a("openableURLs", (Map<String, ?>) hashMap);
    }
}
