package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzbfo implements zzaho<zzbdf> {

    /* renamed from: a */
    private boolean f25271a;

    /* renamed from: a */
    private static int m26701a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzyt.m31532a();
            return zzazt.m26302a(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzbad.m26359d(sb.toString());
            return i;
        }
    }

    /* renamed from: a */
    private static void m26702a(zzbcq zzbcq, Map<String, String> map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbcq.mo30398b(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                zzbad.m26359d(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzbcq.mo30400c(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbcq.mo30402d(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbcq.mo30403e(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbcq.mo30404f(Integer.parseInt(str5));
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        int i;
        String[] split;
        zzbdf zzbdf = (zzbdf) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzbad.m26359d("Action missing from video GMSG.");
            return;
        }
        if (zzbad.m26354a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzbad.m26352a(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzbad.m26359d("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbdf.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException e) {
                zzbad.m26359d("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzbad.m26359d("No MIME types specified for decoder properties inspection.");
                    zzbcq.m26460a(zzbdf, "missingMimeTypes");
                } else if (VERSION.SDK_INT < 16) {
                    zzbad.m26359d("Video decoder properties available on API versions >= 16.");
                    zzbcq.m26460a(zzbdf, "deficientApiVersion");
                } else {
                    HashMap hashMap = new HashMap();
                    for (String str4 : str3.split(",")) {
                        hashMap.put(str4, zzazr.m26292a(str4.trim()));
                    }
                    zzbcq.m26461a(zzbdf, (Map<String, List<Map<String, Object>>>) hashMap);
                }
            } else {
                zzbcw E = zzbdf.mo28709E();
                if (E == null) {
                    zzbad.m26359d("Could not get underlay container for a video GMSG.");
                    return;
                }
                boolean equals = "new".equals(str);
                boolean equals2 = "position".equals(str);
                String str5 = "y";
                String str6 = "x";
                if (equals || equals2) {
                    Context context = zzbdf.getContext();
                    int a = m26701a(context, map, str6, 0);
                    int a2 = m26701a(context, map, str5, 0);
                    int a3 = m26701a(context, map, "w", -1);
                    int a4 = m26701a(context, map, "h", -1);
                    int min = Math.min(a3, zzbdf.mo28712H() - a);
                    int min2 = Math.min(a4, zzbdf.mo28713I() - a2);
                    try {
                        i = Integer.parseInt((String) map.get("player"));
                    } catch (NumberFormatException e2) {
                        i = 0;
                    }
                    boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                    if (!equals || E.mo30416c() != null) {
                        E.mo30413a(a, a2, min, min2);
                        return;
                    }
                    E.mo30414a(a, a2, min, min2, i, parseBoolean, new zzbde((String) map.get("flags")));
                    zzbcq c = E.mo30416c();
                    if (c != null) {
                        m26702a(c, map);
                    }
                    return;
                }
                zzbhq g = zzbdf.mo28754g();
                String str7 = "currentTime";
                if (g != null) {
                    if ("timeupdate".equals(str)) {
                        String str8 = (String) map.get(str7);
                        if (str8 == null) {
                            zzbad.m26359d("currentTime parameter missing from timeupdate video GMSG.");
                            return;
                        }
                        try {
                            g.mo30630b(Float.parseFloat(str8));
                            return;
                        } catch (NumberFormatException e3) {
                            String str9 = "Could not parse currentTime parameter from timeupdate video GMSG: ";
                            String valueOf = String.valueOf(str8);
                            zzbad.m26359d(valueOf.length() != 0 ? str9.concat(valueOf) : new String(str9));
                            return;
                        }
                    } else if ("skip".equals(str)) {
                        g.mo30633ib();
                        return;
                    }
                }
                zzbcq c2 = E.mo30416c();
                if (c2 == null) {
                    zzbcq.m26459a(zzbdf);
                } else if ("click".equals(str)) {
                    Context context2 = zzbdf.getContext();
                    int a5 = m26701a(context2, map, str6, 0);
                    int a6 = m26701a(context2, map, str5, 0);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a6, 0);
                    c2.mo30394a(obtain);
                    obtain.recycle();
                } else if (str7.equals(str)) {
                    String str10 = (String) map.get("time");
                    if (str10 == null) {
                        zzbad.m26359d("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        c2.mo30392a((int) (Float.parseFloat(str10) * 1000.0f));
                    } catch (NumberFormatException e4) {
                        String str11 = "Could not parse time parameter from currentTime video GMSG: ";
                        String valueOf2 = String.valueOf(str10);
                        zzbad.m26359d(valueOf2.length() != 0 ? str11.concat(valueOf2) : new String(str11));
                    }
                } else if ("hide".equals(str)) {
                    c2.setVisibility(4);
                } else if ("load".equals(str)) {
                    c2.mo30401d();
                } else if ("loadControl".equals(str)) {
                    m26702a(c2, map);
                } else {
                    String str12 = "muted";
                    if (str12.equals(str)) {
                        if (Boolean.parseBoolean((String) map.get(str12))) {
                            c2.mo30406l();
                        } else {
                            c2.mo30407m();
                        }
                    } else if ("pause".equals(str)) {
                        c2.mo30397b();
                    } else if ("play".equals(str)) {
                        c2.mo30399c();
                    } else if ("show".equals(str)) {
                        c2.setVisibility(0);
                    } else {
                        String str13 = "src";
                        if (str13.equals(str)) {
                            String str14 = (String) map.get(str13);
                            String[] strArr = {str14};
                            String str15 = (String) map.get("demuxed");
                            if (str15 != null) {
                                try {
                                    JSONArray jSONArray = new JSONArray(str15);
                                    String[] strArr2 = new String[jSONArray.length()];
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        strArr2[i2] = jSONArray.getString(i2);
                                    }
                                    strArr = strArr2;
                                } catch (JSONException e5) {
                                    String str16 = "Malformed demuxed URL list for playback: ";
                                    String valueOf3 = String.valueOf(str15);
                                    zzbad.m26359d(valueOf3.length() != 0 ? str16.concat(valueOf3) : new String(str16));
                                    strArr = new String[]{str14};
                                }
                            }
                            c2.mo30395a(str14, strArr);
                        } else if ("touchMove".equals(str)) {
                            Context context3 = zzbdf.getContext();
                            c2.mo30391a((float) m26701a(context3, map, "dx", 0), (float) m26701a(context3, map, "dy", 0));
                            if (!this.f25271a) {
                                zzbdf.mo28708D();
                                this.f25271a = true;
                            }
                        } else {
                            String str17 = "volume";
                            if (str17.equals(str)) {
                                String str18 = (String) map.get(str17);
                                if (str18 == null) {
                                    zzbad.m26359d("Level parameter missing from volume video GMSG.");
                                    return;
                                }
                                try {
                                    c2.setVolume(Float.parseFloat(str18));
                                } catch (NumberFormatException e6) {
                                    String str19 = "Could not parse volume parameter from volume video GMSG: ";
                                    String valueOf4 = String.valueOf(str18);
                                    zzbad.m26359d(valueOf4.length() != 0 ? str19.concat(valueOf4) : new String(str19));
                                }
                            } else if ("watermark".equals(str)) {
                                c2.mo30408n();
                            } else {
                                String str20 = "Unknown video action: ";
                                String valueOf5 = String.valueOf(str);
                                zzbad.m26359d(valueOf5.length() != 0 ? str20.concat(valueOf5) : new String(str20));
                            }
                        }
                    }
                }
            }
        }
    }
}
