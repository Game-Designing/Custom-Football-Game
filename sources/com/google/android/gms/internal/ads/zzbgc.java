package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzbgc implements zzaho<zzbdf> {
    /* renamed from: a */
    private static Integer m26733a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException e) {
            String str2 = (String) map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzbad.m26359d(sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbft zzbft;
        zzbdf zzbdf = (zzbdf) obj;
        if (zzbad.m26354a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzbad.m26352a(sb.toString());
        }
        zzk.zzmc();
        if (map.containsKey("abort")) {
            if (!zzbfs.m26706a(zzbdf)) {
                zzbad.m26359d("Precache abort but no precache task running.");
            }
            return;
        }
        String str = (String) map.get("src");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException e) {
                    String str3 = "Malformed demuxed URL list for precache: ";
                    String valueOf2 = String.valueOf(str2);
                    zzbad.m26359d(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbfs.m26707b(zzbdf) != null) {
                zzbad.m26359d("Precache task is already running.");
                return;
            } else if (zzbdf.mo28768o() == null) {
                zzbad.m26359d("Precache requires a dependency provider.");
                return;
            } else {
                zzbde zzbde = new zzbde((String) map.get("flags"));
                Integer a = m26733a(map, "player");
                if (a == null) {
                    a = Integer.valueOf(0);
                }
                zzbft = zzbdf.mo28768o().zzbqr.mo30535a(zzbdf, a.intValue(), null, zzbde);
                new zzbfq(zzbdf, zzbft, str, strArr).mo30195b();
            }
        } else {
            zzbfq b = zzbfs.m26707b(zzbdf);
            if (b != null) {
                zzbft = b.f25273e;
            } else {
                zzbad.m26359d("Precache must specify a source.");
                return;
            }
        }
        Integer a2 = m26733a(map, "minBufferMs");
        if (a2 != null) {
            zzbft.mo30550b(a2.intValue());
        }
        Integer a3 = m26733a(map, "maxBufferMs");
        if (a3 != null) {
            zzbft.mo30551c(a3.intValue());
        }
        Integer a4 = m26733a(map, "bufferForPlaybackMs");
        if (a4 != null) {
            zzbft.mo30552d(a4.intValue());
        }
        Integer a5 = m26733a(map, "bufferForPlaybackAfterRebufferMs");
        if (a5 != null) {
            zzbft.mo30553e(a5.intValue());
        }
    }
}
