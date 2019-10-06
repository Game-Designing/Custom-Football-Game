package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;
import com.mopub.common.AdType;
import com.vungle.warren.p267ui.VungleWebViewActivity;
import java.net.URISyntaxException;
import java.util.Map;

@zzard
public final class zzahs<T extends zzbhx & zzbhy & zzbic & zzbif & zzbih> implements zzaho<T> {

    /* renamed from: a */
    private final zzb f24344a;

    /* renamed from: b */
    private final zzapr f24345b;

    public zzahs(zzb zzb, zzapr zzapr) {
        this.f24344a = zzb;
        this.f24345b = zzapr;
    }

    /* renamed from: a */
    private static boolean m25053a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: b */
    private static int m25054b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                zzk.zzli();
                return 7;
            } else if ("l".equalsIgnoreCase(str)) {
                zzk.zzli();
                return 6;
            } else if ("c".equalsIgnoreCase(str)) {
                return zzk.zzli().mo30243a();
            }
        }
        return -1;
    }

    /* renamed from: a */
    private final void m25052a(boolean z) {
        zzapr zzapr = this.f24345b;
        if (zzapr != null) {
            zzapr.mo29978a(z);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static String m25051a(Context context, zzdh zzdh, String str, View view, Activity activity) {
        if (zzdh == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzdh.mo31486b(parse)) {
                parse = zzdh.mo31482a(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzdi e) {
            return str;
        } catch (Exception e2) {
            zzk.zzlk().mo30168a((Throwable) e2, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        String str;
        String str2 = "OpenGmsgHandler.onGmsg";
        zzbhx zzbhx = (zzbhx) obj;
        String a = zzavx.m25931a((String) map.get("u"), zzbhx.getContext(), true);
        String str3 = (String) map.get("a");
        if (str3 == null) {
            zzbad.m26359d("Action missing from an open GMSG.");
            return;
        }
        zzb zzb = this.f24344a;
        if (zzb != null && !zzb.zzkx()) {
            this.f24344a.zzbk(a);
        } else if ("expand".equalsIgnoreCase(str3)) {
            if (((zzbhy) zzbhx).mo28791x()) {
                zzbad.m26359d("Cannot expand WebView that is already expanded.");
                return;
            }
            m25052a(false);
            ((zzbic) zzbhx).mo28742b(m25053a(map), m25054b(map));
        } else if ("webapp".equalsIgnoreCase(str3)) {
            m25052a(false);
            if (a != null) {
                ((zzbic) zzbhx).mo28732a(m25053a(map), m25054b(map), a);
            } else {
                ((zzbic) zzbhx).mo28733a(m25053a(map), m25054b(map), (String) map.get(AdType.HTML), (String) map.get("baseurl"));
            }
        } else {
            if ("app".equalsIgnoreCase(str3)) {
                if ("true".equalsIgnoreCase((String) map.get("system_browser"))) {
                    m25052a(true);
                    if (TextUtils.isEmpty(a)) {
                        zzbad.m26359d("Destination url cannot be empty.");
                        return;
                    }
                    try {
                        ((zzbic) zzbhx).mo28717a(new zzc(new zzaht(zzbhx.getContext(), ((zzbif) zzbhx).mo28748e(), ((zzbih) zzbhx).getView()).mo29739a(map)));
                        return;
                    } catch (ActivityNotFoundException e) {
                        zzbad.m26359d(e.getMessage());
                        return;
                    }
                }
            }
            m25052a(true);
            String str4 = (String) map.get(VungleWebViewActivity.INTENT_URL);
            Intent intent = null;
            if (!TextUtils.isEmpty(str4)) {
                try {
                    intent = Intent.parseUri(str4, 0);
                } catch (URISyntaxException e2) {
                    String str5 = "Error parsing the url: ";
                    String valueOf = String.valueOf(str4);
                    zzbad.m26356b(valueOf.length() != 0 ? str5.concat(valueOf) : new String(str5), e2);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                String uri = data.toString();
                if (!TextUtils.isEmpty(uri)) {
                    try {
                        uri = m25051a(zzbhx.getContext(), ((zzbif) zzbhx).mo28748e(), uri, ((zzbih) zzbhx).getView(), zzbhx.mo28780q());
                    } catch (Exception e3) {
                        zzbad.m26356b("Error occurred while adding signals.", e3);
                        zzk.zzlk().mo30168a((Throwable) e3, str2);
                    }
                    try {
                        data = Uri.parse(uri);
                    } catch (Exception e4) {
                        String str6 = "Error parsing the uri: ";
                        String valueOf2 = String.valueOf(uri);
                        zzbad.m26356b(valueOf2.length() != 0 ? str6.concat(valueOf2) : new String(str6), e4);
                        zzk.zzlk().mo30168a((Throwable) e4, str2);
                    }
                }
                intent.setData(data);
            }
            if (intent != null) {
                ((zzbic) zzbhx).mo28717a(new zzc(intent));
                return;
            }
            if (!TextUtils.isEmpty(a)) {
                str = m25051a(zzbhx.getContext(), ((zzbif) zzbhx).mo28748e(), a, ((zzbih) zzbhx).getView(), zzbhx.mo28780q());
            } else {
                str = a;
            }
            zzbic zzbic = (zzbic) zzbhx;
            zzc zzc = new zzc((String) map.get("i"), str, (String) map.get(InneractiveMediationDefs.GENDER_MALE), (String) map.get("p"), (String) map.get("c"), (String) map.get(InneractiveMediationDefs.GENDER_FEMALE), (String) map.get("e"));
            zzbic.mo28717a(zzc);
        }
    }
}
