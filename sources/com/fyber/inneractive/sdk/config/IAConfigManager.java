package com.fyber.inneractive.sdk.config;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.config.p162a.C7690a;
import com.fyber.inneractive.sdk.config.p162a.C7691b;
import com.fyber.inneractive.sdk.config.p162a.C7692c.C7693a;
import com.fyber.inneractive.sdk.config.p162a.C7695d;
import com.fyber.inneractive.sdk.config.p162a.C7696e;
import com.fyber.inneractive.sdk.config.p162a.C7698g;
import com.fyber.inneractive.sdk.config.p162a.C7699h;
import com.fyber.inneractive.sdk.config.p162a.C7700i;
import com.fyber.inneractive.sdk.config.p162a.C7701j;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p165f.C7737f;
import com.fyber.inneractive.sdk.p165f.C7739h.C7740a;
import com.fyber.inneractive.sdk.p174i.C7907g;
import com.fyber.inneractive.sdk.util.C8001g;
import com.fyber.inneractive.sdk.util.C8001g.C8002a;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8014m;
import com.fyber.inneractive.sdk.util.C8014m.C8015a;
import com.fyber.inneractive.sdk.util.C8016n;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.C8019p;
import com.fyber.inneractive.sdk.util.C8020q;
import com.fyber.inneractive.sdk.util.C8030t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.gson.GsonBuilder;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

public class IAConfigManager {

    /* renamed from: h */
    static int f15230h = 0;

    /* renamed from: i */
    static int f15231i = 0;

    /* renamed from: x */
    private static IAConfigManager f15232x = new IAConfigManager();

    /* renamed from: a */
    Context f15233a;

    /* renamed from: b */
    boolean f15234b = false;

    /* renamed from: c */
    String f15235c;

    /* renamed from: d */
    String f15236d;

    /* renamed from: e */
    C7702b f15237e;

    /* renamed from: f */
    InneractiveUserConfig f15238f;

    /* renamed from: g */
    boolean f15239g = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C8014m f15240j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f15241k = null;

    /* renamed from: l */
    private Map<String, C7710h> f15242l = new HashMap();

    /* renamed from: m */
    private Map<String, C7711i> f15243m = new HashMap();

    /* renamed from: n */
    private C7686c f15244n = new C7686c(0);
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f15245o;

    /* renamed from: p */
    private String f15246p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f15247q;

    /* renamed from: r */
    private List<OnConfigurationReadyAndValidListener> f15248r = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SharedPreferences f15249s;

    /* renamed from: t */
    private String f15250t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f15251u;

    /* renamed from: v */
    private Boolean f15252v = null;

    /* renamed from: w */
    private boolean f15253w = false;

    public interface OnConfigurationReadyAndValidListener {
        void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc);
    }

    /* renamed from: com.fyber.inneractive.sdk.config.IAConfigManager$a */
    static class C7684a {

        /* renamed from: a */
        String f15259a;

        /* renamed from: b */
        String f15260b;

        /* renamed from: c */
        Map<String, C7710h> f15261c = new HashMap();

        /* renamed from: d */
        Map<String, C7711i> f15262d = new HashMap();

        /* renamed from: e */
        C7686c f15263e = new C7686c(0);

        C7684a() {
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.config.IAConfigManager$b */
    public static class C7685b extends Exception {
        /* synthetic */ C7685b(byte b) {
            this();
        }

        private C7685b() {
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.config.IAConfigManager$c */
    private static class C7686c {

        /* renamed from: a */
        Set<Vendor> f15264a;

        private C7686c() {
            this.f15264a = new HashSet();
        }

        /* synthetic */ C7686c(byte b) {
            this();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo24179a(Set<Vendor> set) {
            if (set != null) {
                for (Vendor vendor : set) {
                    if (vendor != null && !this.f15264a.contains(vendor)) {
                        this.f15264a.add(vendor);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m16970a(IAConfigManager iAConfigManager, Exception exc) {
        for (OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener : iAConfigManager.f15248r) {
            if (onConfigurationReadyAndValidListener != null) {
                boolean J = m16959J();
                IAlog.m18019a("notifying listener configuration state has been resolved");
                onConfigurationReadyAndValidListener.onConfigurationReadyAndValid(iAConfigManager, J, !J ? exc : null);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m16972a(Throwable th) {
        String name = th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        C7740a aVar = new C7740a(C7737f.FATAL_CONFIGURATION_ERROR, (InneractiveAdRequest) null, (C7907g) null);
        Object[] objArr = new Object[4];
        objArr[0] = "exception";
        if (name == null) {
            name = "Unknown";
        }
        objArr[1] = name;
        objArr[2] = "message";
        if (localizedMessage == null) {
            localizedMessage = "No message";
        }
        objArr[3] = localizedMessage;
        aVar.mo24313a(objArr).mo24314a();
    }

    static {
        System.setProperty("ia.testEnvironmentConfiguration.removeInClose", "true");
    }

    IAConfigManager() {
    }

    /* renamed from: a */
    public static void m16971a(InneractiveUserConfig inneractiveUserConfig) {
        f15232x.f15238f = inneractiveUserConfig;
        StringBuilder sb = new StringBuilder("config manager: setUserParams called with: age:");
        sb.append(inneractiveUserConfig.getAge());
        sb.append(" gender: ");
        sb.append(inneractiveUserConfig.getGender());
        sb.append(" zip: ");
        sb.append(inneractiveUserConfig.getZipCode());
        IAlog.m18021b(sb.toString());
    }

    /* renamed from: a */
    public static boolean m16974a() {
        IAConfigManager iAConfigManager = f15232x;
        if (iAConfigManager != null) {
            C7702b bVar = iAConfigManager.f15237e;
            if (bVar != null) {
                return bVar.f15335n;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m16968a(Context context, String str, String str2, String str3) {
        IAConfigManager iAConfigManager = f15232x;
        if (!iAConfigManager.f15234b) {
            IAlog.m18021b("Initializing config manager");
            StringBuilder sb = new StringBuilder("Config manager: lib name = ");
            sb.append(str2);
            IAlog.m18021b(sb.toString());
            StringBuilder sb2 = new StringBuilder("Config manager: app version = ");
            sb2.append(str3);
            IAlog.m18021b(sb2.toString());
            C8020q a = C8025a.f16363a;
            a.f16351a = context.getApplicationContext();
            if (a.f16351a != null) {
                a.f16353c = new C8002a() {
                    /* renamed from: a */
                    public final void mo24840a(Location location) {
                        C8020q.this.f16352b = location;
                    }
                };
                C8001g.m18045a(a.f16351a, a.f16353c);
            }
            a.f16354d = new Handler(context.getMainLooper());
            C7687a aVar = C7688a.f15267a;
            if (aVar.f15265a == null) {
                aVar.f15265a = context;
                aVar.mo24180a();
                if (aVar.f15266b == null) {
                    aVar.f15266b = new C7689b(0);
                    aVar.mo24182b();
                }
                new Thread(new Runnable(context, aVar) {

                    /* renamed from: a */
                    final /* synthetic */ Context f15352a;

                    /* renamed from: b */
                    final /* synthetic */ C7707a f15353b;

                    {
                        this.f15352a = r1;
                        this.f15353b = r2;
                    }

                    public final void run() {
                        if (C7705e.m17041a(this.f15352a)) {
                            try {
                                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f15352a);
                                String id = advertisingIdInfo.getId();
                                StringBuilder sb = new StringBuilder("advertising id: ");
                                sb.append(id);
                                IAlog.m18019a(sb.toString());
                                boolean isLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                                StringBuilder sb2 = new StringBuilder("limit ad tracking: ");
                                sb2.append(isLimitAdTrackingEnabled);
                                IAlog.m18019a(sb2.toString());
                                this.f15353b.mo24181a(id, isLimitAdTrackingEnabled);
                            } catch (NoClassDefFoundError e) {
                                StringBuilder sb3 = new StringBuilder("SDK internal error: Make sure that Google Play Services for Mobile Ads is added to the compile dependencies of your project");
                                sb3.append(e.toString());
                                IAlog.m18024e(sb3.toString());
                            } catch (Exception e2) {
                                IAlog.m18019a("Handled Exception:");
                                IAlog.m18019a(C8017o.m18096a((Throwable) e2));
                                IAlog.m18022c("Advertising ID is not available. Please add Google Play Services library (v 4.0+) to improve your ad targeting. (relevant for devices running Android API 2.3 and above)");
                            }
                        }
                    }
                }).start();
            }
            iAConfigManager.f15233a = context;
            iAConfigManager.f15245o = str;
            iAConfigManager.f15235c = str2;
            iAConfigManager.f15236d = str3;
            iAConfigManager.f15239g = VERSION.SDK_INT >= 14;
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    String i = C8005i.m18060i();
                    if (C7640a.f15157a.f15150a) {
                        String str = "REQUEST_HEADER ";
                        StringBuilder sb = new StringBuilder(str);
                        String str2 = "User-Agent";
                        sb.append(str2);
                        String str3 = " : ";
                        sb.append(str3);
                        sb.append(i);
                        Log.v("IA_CI_LOG", sb.toString());
                        C7639a a = C7640a.f15157a;
                        StringBuilder sb2 = new StringBuilder(str);
                        sb2.append(str2);
                        sb2.append(str3);
                        sb2.append(i);
                        a.mo24033b(sb2.toString());
                    }
                }
            });
            iAConfigManager.f15238f = new InneractiveUserConfig();
            iAConfigManager.f15234b = true;
            iAConfigManager.f15237e = new C7702b();
            final Context applicationContext = context.getApplicationContext();
            C8019p pVar = new C8019p(context, new C8015a<C7684a>() {
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Object mo24177a(String str, String str2) throws Exception {
                    return m17015a(str);
                }

                /* renamed from: a */
                public final /* synthetic */ void mo24178a(Object obj) {
                    C7684a aVar = (C7684a) obj;
                    IAConfigManager.this.f15240j = null;
                    if (aVar == null) {
                        IAlog.m18022c("No parsed local configuration obtained");
                    } else {
                        IAConfigManager.this.mo24174a(aVar);
                        IAConfigManager.m16970a(IAConfigManager.this, (Exception) null);
                    }
                    IAConfigManager.this.mo24175g();
                }

                /* renamed from: a */
                private C7684a m17015a(String str) throws Exception {
                    try {
                        IAConfigManager.this.f15249s = applicationContext.getSharedPreferences("IAConfigurationPreferences", 0);
                        IAConfigManager.m16983b(IAConfigManager.this, IAConfigManager.this.f15249s);
                        IAConfigManager.this.f15251u = IAConfigManager.this.m16961L();
                        IAConfigManager.this.f15241k = str;
                        C7695d dVar = (C7695d) new GsonBuilder().create().fromJson(str, C7695d.class);
                        if (dVar != null && IAConfigManager.this.f15245o.equals(dVar.f15281a.f15270a)) {
                            return IAConfigManager.m16964a(dVar);
                        }
                    } catch (NoClassDefFoundError e) {
                        StringBuilder sb = new StringBuilder("SDK internal error: Make sure that Gson is added to the compile dependencies of your project");
                        sb.append(e.toString());
                        IAlog.m18024e(sb.toString());
                    } catch (Throwable th) {
                        IAConfigManager.m16972a(th);
                        IAlog.m18024e("Error while parsing local configuration");
                    }
                    IAConfigManager.this.f15249s.edit().remove("IALastModifiedFromHeader").apply();
                    return null;
                }
            });
            iAConfigManager.f15240j = pVar;
            C8006j.m18070a((AsyncTask<P, ?, ?>) pVar, (P[]) new String[]{"inneractive.config"});
            iAConfigManager.f15250t = m16960K();
        }
    }

    /* renamed from: b */
    public static String m16979b() {
        return f15232x.f15241k;
    }

    /* renamed from: a */
    public static C7711i m16965a(String str) {
        IAConfigManager iAConfigManager = f15232x;
        Map<String, C7711i> map = iAConfigManager.f15243m;
        if (map != null && map.containsKey(str)) {
            return (C7711i) iAConfigManager.f15243m.get(str);
        }
        StringBuilder sb = new StringBuilder("Requested unit config doesn't exists - ");
        sb.append(str);
        IAlog.m18022c(sb.toString());
        return null;
    }

    /* renamed from: b */
    public static C7710h m16978b(String str) {
        return f15232x.m16988d(str);
    }

    /* renamed from: c */
    public static boolean m16987c(String str) {
        C7710h d = f15232x.m16988d(str);
        if (d != null) {
            Iterator it = d.iterator();
            while (it.hasNext()) {
                if (((C7711i) it.next()).f15365e != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static void m16986c() {
        f15232x.f15234b = false;
        C8020q a = C8025a.f16363a;
        IAlog.m18021b("Location Manager: destroy called");
        if (a.f16354d != null) {
            a.mo24854a();
            a.f16354d = null;
        }
        a.mo24855a(a.f16356f);
        a.mo24855a(a.f16357g);
        a.f16356f = null;
        a.f16357g = null;
        a.f16351a = null;
        a.f16353c = null;
    }

    public static void addListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        f15232x.f15248r.add(onConfigurationReadyAndValidListener);
    }

    public static void removeListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        f15232x.f15248r.remove(onConfigurationReadyAndValidListener);
    }

    /* renamed from: d */
    public static boolean m16990d() {
        return f15232x.f15239g;
    }

    /* renamed from: a */
    static C7684a m16964a(C7695d dVar) {
        boolean z;
        C7684a aVar;
        Iterator it;
        Iterator it2;
        Set<Track> set;
        Set<Track> set2;
        Set<Track> set3;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Set<Vendor> set4;
        Set<Vendor> set5;
        Set<Vendor> set6;
        Boolean bool;
        Boolean bool2;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Boolean bool3;
        Boolean bool4;
        Orientation orientation;
        Orientation orientation2;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Skip skip;
        Skip skip2;
        TapAction tapAction;
        TapAction tapAction2;
        Integer num15;
        Integer num16;
        Boolean bool5;
        Boolean bool6;
        Integer num17;
        Integer num18;
        C7695d dVar2 = dVar;
        C7684a aVar2 = new C7684a();
        aVar2.f15260b = dVar2.f15283c;
        aVar2.f15259a = dVar2.f15281a.f15271b;
        Iterator it3 = dVar2.f15282b.iterator();
        while (it3.hasNext()) {
            C7698g gVar = (C7698g) it3.next();
            Map<String, C7710h> map = aVar2.f15261c;
            String str = gVar.f15286a;
            C7690a aVar3 = dVar2.f15281a;
            Map<String, C7711i> map2 = aVar2.f15262d;
            C7686c cVar = aVar2.f15263e;
            C7710h hVar = new C7710h();
            hVar.f15358a = gVar.f15286a;
            int i = 2;
            C7693a[] aVarArr = {aVar3, gVar};
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                C7693a aVar4 = aVarArr[i2];
                if (aVar4 != null) {
                    String b = aVar4.mo24184b();
                    if (b != null && b.equals(AdultContentAnalytics.UNLOCK)) {
                        z = false;
                        break;
                    }
                }
                i2++;
                i = 2;
            }
            hVar.f15360c = z;
            Iterator it4 = gVar.f15291f.iterator();
            while (it4.hasNext()) {
                C7699h hVar2 = (C7699h) it4.next();
                C7711i iVar = new C7711i();
                String str2 = hVar2.f15293a;
                if (str2 != null) {
                    String str3 = hVar2.f15294b;
                    if (str3 != null) {
                        iVar.f15361a = str2;
                        iVar.f15362b = str3;
                        if (hVar2.f15297e != null) {
                            C7709g gVar2 = new C7709g();
                            UnitDisplayType unitDisplayType = hVar2.f15297e.f15285a;
                            if (unitDisplayType == UnitDisplayType.DEFAULT) {
                                gVar2.f15357a = unitDisplayType;
                                iVar.f15365e = gVar2;
                            }
                        }
                        C7691b bVar = hVar2.f15295c;
                        if (bVar != null) {
                            C7691b bVar2 = gVar.f15287b;
                            C7691b bVar3 = aVar3.f15272c;
                            C7703c cVar2 = new C7703c();
                            it2 = it3;
                            UnitDisplayType unitDisplayType2 = bVar.f15277a;
                            it = it4;
                            if (unitDisplayType2 == UnitDisplayType.BANNER || unitDisplayType2 == UnitDisplayType.MRECT || unitDisplayType2 == UnitDisplayType.INTERSTITIAL) {
                                cVar2.f15349b = bVar.f15277a;
                                Object[] objArr = new Object[3];
                                objArr[0] = bVar.f15278b;
                                if (bVar2 != null) {
                                    num15 = bVar2.f15278b;
                                } else {
                                    num15 = null;
                                }
                                objArr[1] = num15;
                                if (bVar3 != null) {
                                    num16 = bVar3.f15278b;
                                } else {
                                    num16 = null;
                                }
                                objArr[2] = num16;
                                Integer num19 = (Integer) m16966a((Object) null, objArr);
                                if (num19 != null) {
                                    aVar = aVar2;
                                    if (num19.intValue() >= 5 && num19.intValue() <= 60) {
                                        cVar2.f15348a = num19;
                                    }
                                } else {
                                    aVar = aVar2;
                                }
                                Boolean valueOf = Boolean.valueOf(true);
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = bVar.f15279c;
                                if (bVar2 != null) {
                                    bool5 = bVar2.f15279c;
                                } else {
                                    bool5 = null;
                                }
                                objArr2[1] = bool5;
                                if (bVar3 != null) {
                                    bool6 = bVar3.f15279c;
                                } else {
                                    bool6 = null;
                                }
                                objArr2[2] = bool6;
                                cVar2.mo24186a(((Boolean) m16966a((Object) valueOf, objArr2)).booleanValue());
                                Object[] objArr3 = new Object[3];
                                objArr3[0] = bVar.f15280d;
                                if (bVar2 != null) {
                                    num17 = bVar2.f15280d;
                                } else {
                                    num17 = null;
                                }
                                objArr3[1] = num17;
                                if (bVar3 != null) {
                                    num18 = bVar3.f15280d;
                                } else {
                                    num18 = null;
                                }
                                objArr3[2] = num18;
                                Integer num20 = (Integer) m16966a((Object) null, objArr3);
                                if (num20 != null && num20.intValue() >= 5 && num20.intValue() <= 60) {
                                    cVar2.f15351d = num20;
                                }
                                if (cVar2.f15351d == null && !cVar2.f15350c.booleanValue()) {
                                    UnitDisplayType unitDisplayType3 = bVar.f15277a;
                                    if (unitDisplayType3 == UnitDisplayType.INTERSTITIAL || unitDisplayType3 == UnitDisplayType.REWARDED) {
                                        cVar2.mo24186a(true);
                                    }
                                }
                                iVar.f15363c = cVar2;
                            } else {
                                C7695d dVar3 = dVar;
                                it3 = it2;
                                it4 = it;
                            }
                        } else {
                            aVar = aVar2;
                            it2 = it3;
                            it = it4;
                        }
                        if (hVar2.f15298f != null) {
                            C7713k kVar = new C7713k();
                            C7700i iVar2 = hVar2.f15298f;
                            C7700i iVar3 = gVar.f15289d;
                            C7700i iVar4 = aVar3.f15274e;
                            UnitDisplayType unitDisplayType4 = iVar2.f15309j;
                            if (unitDisplayType4 == UnitDisplayType.LANDSCAPE || unitDisplayType4 == UnitDisplayType.SQUARE || unitDisplayType4 == UnitDisplayType.INTERSTITIAL || unitDisplayType4 == UnitDisplayType.VERTICAL || unitDisplayType4 == UnitDisplayType.REWARDED || unitDisplayType4 == UnitDisplayType.MRECT) {
                                kVar.f15377j = iVar2.f15309j;
                            } else if (iVar.f15365e != null) {
                                kVar.f15377j = UnitDisplayType.INTERSTITIAL;
                            } else {
                                C7695d dVar4 = dVar;
                                it3 = it2;
                                it4 = it;
                                aVar2 = aVar;
                            }
                            Object[] objArr4 = new Object[3];
                            objArr4[0] = iVar2.f15300a;
                            if (iVar3 != null) {
                                bool = iVar3.f15300a;
                            } else {
                                bool = null;
                            }
                            objArr4[1] = bool;
                            if (iVar4 != null) {
                                bool2 = iVar4.f15300a;
                            } else {
                                bool2 = null;
                            }
                            objArr4[2] = bool2;
                            Object a = m16966a((Object) null, objArr4);
                            if (a != null) {
                                kVar.f15368a = (Boolean) a;
                                Integer valueOf2 = Integer.valueOf(5000);
                                Object[] objArr5 = new Object[3];
                                objArr5[0] = iVar2.f15301b;
                                if (iVar3 != null) {
                                    num7 = iVar3.f15301b;
                                } else {
                                    num7 = null;
                                }
                                objArr5[1] = num7;
                                if (iVar4 != null) {
                                    num8 = iVar4.f15301b;
                                } else {
                                    num8 = null;
                                }
                                objArr5[2] = num8;
                                kVar.f15369b = (Integer) m16966a((Object) valueOf2, objArr5);
                                Integer valueOf3 = Integer.valueOf(0);
                                Object[] objArr6 = new Object[3];
                                objArr6[0] = iVar2.f15302c;
                                if (iVar3 != null) {
                                    num9 = iVar3.f15302c;
                                } else {
                                    num9 = null;
                                }
                                objArr6[1] = num9;
                                if (iVar4 != null) {
                                    num10 = iVar4.f15302c;
                                } else {
                                    num10 = null;
                                }
                                objArr6[2] = num10;
                                Integer num21 = (Integer) m16966a((Object) valueOf3, objArr6);
                                kVar.f15370c = Integer.valueOf(num21.intValue() < 0 ? 0 : num21.intValue());
                                Boolean valueOf4 = Boolean.valueOf(true);
                                Object[] objArr7 = new Object[3];
                                objArr7[0] = iVar2.f15303d;
                                if (iVar3 != null) {
                                    bool3 = iVar3.f15303d;
                                } else {
                                    bool3 = null;
                                }
                                objArr7[1] = bool3;
                                if (iVar4 != null) {
                                    bool4 = iVar4.f15303d;
                                } else {
                                    bool4 = null;
                                }
                                objArr7[2] = bool4;
                                kVar.f15371d = (Boolean) m16966a((Object) valueOf4, objArr7);
                                Orientation orientation3 = Orientation.USER;
                                Object[] objArr8 = new Object[3];
                                objArr8[0] = iVar2.f15304e;
                                if (iVar3 != null) {
                                    orientation = iVar3.f15304e;
                                } else {
                                    orientation = null;
                                }
                                objArr8[1] = orientation;
                                if (iVar4 != null) {
                                    orientation2 = iVar4.f15304e;
                                } else {
                                    orientation2 = null;
                                }
                                objArr8[2] = orientation2;
                                kVar.f15372e = (Orientation) m16966a((Object) orientation3, objArr8);
                                Integer valueOf5 = Integer.valueOf(0);
                                Object[] objArr9 = new Object[3];
                                objArr9[0] = iVar2.f15305f;
                                if (iVar3 != null) {
                                    num11 = iVar3.f15305f;
                                } else {
                                    num11 = null;
                                }
                                objArr9[1] = num11;
                                if (iVar4 != null) {
                                    num12 = iVar4.f15305f;
                                } else {
                                    num12 = null;
                                }
                                objArr9[2] = num12;
                                Integer num22 = (Integer) m16966a((Object) valueOf5, objArr9);
                                kVar.f15373f = Integer.valueOf(num22.intValue() < 0 ? 0 : num22.intValue());
                                Integer valueOf6 = Integer.valueOf(Opcodes.ACC_STRICT);
                                Object[] objArr10 = new Object[3];
                                objArr10[0] = iVar2.f15306g;
                                if (iVar3 != null) {
                                    num13 = iVar3.f15306g;
                                } else {
                                    num13 = null;
                                }
                                objArr10[1] = num13;
                                if (iVar4 != null) {
                                    num14 = iVar4.f15306g;
                                } else {
                                    num14 = null;
                                }
                                objArr10[2] = num14;
                                Integer num23 = (Integer) m16966a((Object) valueOf6, objArr10);
                                if (num23.intValue() > kVar.f15369b.intValue()) {
                                    num23 = kVar.f15369b;
                                }
                                kVar.f15374g = num23;
                                Skip skip3 = Skip._0;
                                Object[] objArr11 = new Object[3];
                                objArr11[0] = iVar2.f15307h;
                                if (iVar3 != null) {
                                    skip = iVar3.f15307h;
                                } else {
                                    skip = null;
                                }
                                objArr11[1] = skip;
                                if (iVar4 != null) {
                                    skip2 = iVar4.f15307h;
                                } else {
                                    skip2 = null;
                                }
                                objArr11[2] = skip2;
                                kVar.f15375h = (Skip) m16966a((Object) skip3, objArr11);
                                TapAction tapAction3 = TapAction.DO_NOTHING;
                                Object[] objArr12 = new Object[3];
                                objArr12[0] = iVar2.f15308i;
                                if (iVar3 != null) {
                                    tapAction = iVar3.f15308i;
                                } else {
                                    tapAction = null;
                                }
                                objArr12[1] = tapAction;
                                if (iVar4 != null) {
                                    tapAction2 = iVar4.f15308i;
                                } else {
                                    tapAction2 = null;
                                }
                                objArr12[2] = tapAction2;
                                kVar.f15376i = (TapAction) m16966a((Object) tapAction3, objArr12);
                                kVar.mo24214a(new ArrayList(), hVar2);
                                iVar.f15366f = kVar;
                            } else {
                                C7695d dVar5 = dVar;
                                it3 = it2;
                                it4 = it;
                                aVar2 = aVar;
                            }
                        }
                        C7708f fVar = new C7708f();
                        HashSet hashSet = new HashSet();
                        Object[] objArr13 = new Object[3];
                        C7696e eVar = hVar2.f15296d;
                        if (eVar != null) {
                            set = eVar.f15284a;
                        } else {
                            set = null;
                        }
                        objArr13[0] = set;
                        C7696e eVar2 = gVar.f15288c;
                        if (eVar2 != null) {
                            set2 = eVar2.f15284a;
                        } else {
                            set2 = null;
                        }
                        objArr13[1] = set2;
                        C7696e eVar3 = aVar3.f15273d;
                        if (eVar3 != null) {
                            set3 = eVar3.f15284a;
                        } else {
                            set3 = null;
                        }
                        objArr13[2] = set3;
                        fVar.f15356a = (Set) m16966a((Object) hashSet, objArr13);
                        iVar.f15364d = fVar;
                        C7715m mVar = new C7715m();
                        C7701j jVar = hVar2.f15299g;
                        C7701j jVar2 = gVar.f15290e;
                        C7701j jVar3 = aVar3.f15275f;
                        Integer valueOf7 = Integer.valueOf(1);
                        Object[] objArr14 = new Object[3];
                        if (jVar != null) {
                            num = jVar.f15311a;
                        } else {
                            num = null;
                        }
                        objArr14[0] = num;
                        if (jVar2 != null) {
                            num2 = jVar2.f15311a;
                        } else {
                            num2 = null;
                        }
                        objArr14[1] = num2;
                        if (jVar3 != null) {
                            num3 = jVar3.f15311a;
                        } else {
                            num3 = null;
                        }
                        objArr14[2] = num3;
                        Integer num24 = (Integer) m16966a((Object) valueOf7, objArr14);
                        if (num24.intValue() > 0 || num24.intValue() <= 100) {
                            mVar.f15379a = num24;
                        } else {
                            mVar.f15379a = Integer.valueOf(1);
                        }
                        Integer valueOf8 = Integer.valueOf(0);
                        Object[] objArr15 = new Object[3];
                        if (jVar != null) {
                            num4 = jVar.f15312b;
                        } else {
                            num4 = null;
                        }
                        objArr15[0] = num4;
                        if (jVar2 != null) {
                            num5 = jVar2.f15312b;
                        } else {
                            num5 = null;
                        }
                        objArr15[1] = num5;
                        if (jVar3 != null) {
                            num6 = jVar3.f15312b;
                        } else {
                            num6 = null;
                        }
                        objArr15[2] = num6;
                        Integer num25 = (Integer) m16966a((Object) valueOf8, objArr15);
                        if (num25.intValue() >= 0 || num25.intValue() <= 100) {
                            mVar.f15380b = num25;
                        } else {
                            mVar.f15380b = Integer.valueOf(0);
                        }
                        HashSet hashSet2 = new HashSet();
                        Object[] objArr16 = new Object[3];
                        if (jVar != null) {
                            set4 = jVar.f15313c;
                        } else {
                            set4 = null;
                        }
                        objArr16[0] = set4;
                        if (jVar2 != null) {
                            set5 = jVar2.f15313c;
                        } else {
                            set5 = null;
                        }
                        objArr16[1] = set5;
                        if (jVar3 != null) {
                            set6 = jVar3.f15313c;
                        } else {
                            set6 = null;
                        }
                        objArr16[2] = set6;
                        mVar.f15381c = (Set) m16966a((Object) hashSet2, objArr16);
                        iVar.f15367g = mVar;
                        if (cVar != null) {
                            cVar.mo24179a(mVar.f15381c);
                        }
                        hVar.f15359b.add(iVar);
                        map2.put(iVar.f15361a, iVar);
                        C7695d dVar6 = dVar;
                        it3 = it2;
                        it4 = it;
                        aVar2 = aVar;
                    }
                }
                C7695d dVar7 = dVar;
                it3 = it3;
                it4 = it4;
                aVar2 = aVar2;
            }
            C7684a aVar5 = aVar2;
            Iterator it5 = it3;
            map.put(str, hVar);
            dVar2 = dVar;
        }
        return aVar2;
    }

    /* renamed from: e */
    public static Boolean m16991e() {
        IAConfigManager iAConfigManager = f15232x;
        if (iAConfigManager == null) {
            return null;
        }
        return iAConfigManager.f15252v;
    }

    /* renamed from: a */
    public static void m16973a(boolean z) {
        IAConfigManager iAConfigManager = f15232x;
        String str = "SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.";
        if (iAConfigManager == null) {
            IAlog.m18023d(str);
            return;
        }
        iAConfigManager.f15252v = Boolean.valueOf(z);
        IAConfigManager iAConfigManager2 = f15232x;
        if (iAConfigManager2.f15249s == null) {
            Context context = iAConfigManager2.f15233a;
            Context applicationContext = context == null ? null : context.getApplicationContext();
            if (applicationContext != null) {
                f15232x.f15249s = applicationContext.getSharedPreferences("IAConfigurationPreferences", 0);
            }
        }
        SharedPreferences sharedPreferences = f15232x.f15249s;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("IAGDPRBool", z).apply();
        } else {
            IAlog.m18023d(str);
        }
    }

    /* renamed from: a */
    private static Object m16966a(Object obj, Object... objArr) {
        for (int i = 0; i < 3; i++) {
            Object obj2 = objArr[i];
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    /* renamed from: d */
    private C7710h m16988d(String str) {
        Map<String, C7710h> map = this.f15242l;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (C7710h) this.f15242l.get(str);
    }

    /* renamed from: f */
    public static void m16993f() {
        f15232x.mo24175g();
    }

    /* renamed from: g */
    public final void mo24175g() {
        if (this.f15240j == null) {
            final Context applicationContext = this.f15233a.getApplicationContext();
            SharedPreferences sharedPreferences = this.f15249s;
            String str = null;
            if (sharedPreferences != null) {
                str = sharedPreferences.getString("IALastModifiedFromHeader", null);
            }
            C8030t tVar = new C8030t(this.f15233a, new C8015a<C7684a>() {
                /* renamed from: a */
                public final /* synthetic */ void mo24178a(Object obj) {
                    boolean z;
                    C7684a aVar = (C7684a) obj;
                    IAConfigManager.this.f15240j = null;
                    if (aVar != null || IAConfigManager.m16959J()) {
                        IAConfigManager.this.f15249s.edit().putLong("IAConfigUpdateTime", System.currentTimeMillis()).apply();
                        z = true;
                    } else {
                        z = false;
                    }
                    IAConfigManager iAConfigManager = IAConfigManager.this;
                    if (aVar != null) {
                        IAlog.m18021b("Got new remote configuration from server:");
                        iAConfigManager.mo24174a(aVar);
                    }
                    IAConfigManager.m16970a(IAConfigManager.this, z ? null : new C7685b(0));
                }

                /* access modifiers changed from: private */
                /* renamed from: b */
                public C7684a mo24177a(String str, String str2) throws Exception {
                    try {
                        if (IAConfigManager.this.f15249s == null) {
                            IAConfigManager.this.f15249s = applicationContext.getSharedPreferences("IAConfigurationPreferences", 0);
                            IAConfigManager.m16983b(IAConfigManager.this, IAConfigManager.this.f15249s);
                            IAConfigManager.this.f15251u = IAConfigManager.this.m16961L();
                        }
                        C7695d dVar = (C7695d) new GsonBuilder().create().fromJson(str, C7695d.class);
                        StringBuilder sb = new StringBuilder("Current config version = ");
                        sb.append(IAConfigManager.this.f15247q);
                        sb.append(" Remote config version = ");
                        sb.append(dVar);
                        IAlog.m18021b(sb.toString() == null ? "null" : dVar.f15283c);
                        if (str2 != null) {
                            IAConfigManager.this.f15249s.edit().putString("IALastModifiedFromHeader", str2).apply();
                        }
                        if (dVar != null && dVar.f15283c.equals(IAConfigManager.this.f15247q)) {
                            IAlog.m18021b("Remote Json configuration didn't change.");
                            return null;
                        } else if (dVar == null || !IAConfigManager.this.f15245o.equals(dVar.f15281a.f15270a)) {
                            return null;
                        } else {
                            IAlog.m18021b("New Json configuration. Caching");
                            IAConfigManager.this.m16977a("inneractive.config", str);
                            return IAConfigManager.m16964a(dVar);
                        }
                    } catch (NoClassDefFoundError e) {
                        StringBuilder sb2 = new StringBuilder("SDK internal error: Make sure that Gson is added to the compile dependencies of your project");
                        sb2.append(e.toString());
                        IAlog.m18024e(sb2.toString());
                        return null;
                    } catch (Throwable th) {
                        IAConfigManager.m16972a(th);
                        IAlog.m18024e("Error while parsing local configuration");
                        return null;
                    }
                }
            }, str);
            this.f15240j = tVar;
            String[] strArr = new String[1];
            String str2 = this.f15245o;
            StringBuilder sb = new StringBuilder("https://");
            String property = System.getProperty("ia.testEnvironmentConfiguration.baseConfigUrl");
            if (TextUtils.isEmpty(property)) {
                sb.append("cdn2.inner-active.mobi/ia-sdk-config/apps/");
            } else {
                sb.append(property);
            }
            sb.append(str2);
            sb.append('/');
            sb.append(str2);
            sb.append(".json");
            strArr[0] = sb.toString();
            C8006j.m18070a((AsyncTask<P, ?, ?>) tVar, (P[]) strArr);
        }
    }

    /* renamed from: h */
    public static String m16994h() {
        return f15232x.f15245o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24174a(C7684a aVar) {
        this.f15247q = aVar.f15260b;
        this.f15246p = aVar.f15259a;
        this.f15242l = aVar.f15261c;
        this.f15243m = aVar.f15262d;
        this.f15244n = aVar.f15263e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16977a(String str, String str2) {
        StringBuilder sb = new StringBuilder("caching json to file ");
        sb.append(str);
        IAlog.m18021b(sb.toString());
        this.f15241k = str2;
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.f15233a.openFileOutput(str, 0);
            fileOutputStream.write(str2.getBytes());
            z = true;
            IAlog.m18021b("Json cached succesfully");
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("Failed caching json to file: ");
            sb2.append(e2.getMessage());
            IAlog.m18023d(sb2.toString());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                }
            }
        }
        return z;
    }

    /* renamed from: i */
    public static String m16995i() {
        return System.getProperty("ia.testEnvironmentConfiguration.device");
    }

    /* renamed from: j */
    public static String m16996j() {
        return System.getProperty("ia.testEnvironmentConfiguration.assetResponse");
    }

    /* renamed from: k */
    public static String m16997k() {
        return System.getProperty("ia.testEnvironmentConfiguration.player");
    }

    /* renamed from: l */
    public static String m16998l() {
        return System.getProperty("ia.testEnvironmentConfiguration.chosenUnitId");
    }

    /* renamed from: m */
    public static String m16999m() {
        return System.getProperty("ia.testEnvironmentConfiguration.tagUrl");
    }

    /* renamed from: n */
    public static boolean m17000n() {
        boolean z;
        boolean J = m16959J();
        if (J) {
            SharedPreferences sharedPreferences = f15232x.f15249s;
            long j = 0;
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("IAConfigUpdateTime", 0);
            }
            if (System.currentTimeMillis() - j > 3600000) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                f15232x.mo24175g();
            }
        }
        return J;
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public static boolean m16959J() {
        return f15232x.f15247q != null;
    }

    /* renamed from: o */
    public static int m17001o() {
        return f15232x.f15237e.f15323b;
    }

    /* renamed from: p */
    public static int m17002p() {
        return f15232x.f15237e.f15324c;
    }

    /* renamed from: q */
    public static int m17003q() {
        return f15232x.f15237e.f15325d;
    }

    /* renamed from: r */
    public static int m17004r() {
        return f15232x.f15237e.f15326e;
    }

    /* renamed from: s */
    public static float m17005s() {
        return (float) f15232x.f15237e.f15327f;
    }

    /* renamed from: t */
    public static int m17006t() {
        return f15232x.f15237e.f15336o;
    }

    /* renamed from: u */
    public static int m17007u() {
        return f15232x.f15237e.f15337p;
    }

    /* renamed from: y */
    public static int m17011y() {
        return f15232x.f15237e.f15328g;
    }

    /* renamed from: z */
    public static boolean m17012z() {
        return f15232x.f15237e.f15329h;
    }

    /* renamed from: A */
    public static boolean m16950A() {
        return f15232x.f15237e.f15330i;
    }

    /* renamed from: B */
    public static int m16951B() {
        return f15232x.f15237e.f15331j;
    }

    /* renamed from: b */
    private static String m16982b(String str, String str2) {
        String str3 = "https://";
        if (Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(str3);
            sb.append(str);
            sb.append("/simpleM2M/");
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(str3);
        sb2.append(str);
        sb2.append(".inner-active.mobi/simpleM2M/");
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: K */
    private static String m16960K() {
        try {
            String language = Locale.getDefault().getLanguage();
            try {
                StringBuilder sb = new StringBuilder("Available device language: ");
                sb.append(language);
                IAlog.m18021b(sb.toString());
                return language;
            } catch (Exception e) {
                return language;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: F */
    public static String m16955F() {
        return f15232x.f15250t;
    }

    /* access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: L */
    public String m16961L() {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f15233a.getSystemService("input_method");
        List<InputMethodInfo> enabledInputMethodList = inputMethodManager.getEnabledInputMethodList();
        StringBuilder sb = new StringBuilder();
        if (enabledInputMethodList != null) {
            int i = 0;
            for (InputMethodInfo enabledInputMethodSubtypeList : enabledInputMethodList) {
                for (InputMethodSubtype inputMethodSubtype : inputMethodManager.getEnabledInputMethodSubtypeList(enabledInputMethodSubtypeList, true)) {
                    if (inputMethodSubtype.getMode().equals("keyboard") && i < 10) {
                        String locale = inputMethodSubtype.getLocale();
                        if (!TextUtils.isEmpty(locale)) {
                            try {
                                String replace = locale.replace("_", "-");
                                if (sb.length() > 0) {
                                    sb.append(",");
                                    sb.append(replace);
                                } else {
                                    sb.append(replace);
                                }
                                StringBuilder sb2 = new StringBuilder("Available input language: ");
                                sb2.append(replace);
                                IAlog.m18021b(sb2.toString());
                                i++;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: G */
    public static String m16956G() {
        return f15232x.f15251u;
    }

    /* renamed from: a */
    public static boolean m16976a(Vendor vendor) {
        return f15232x.f15244n.f15264a.contains(vendor);
    }

    /* renamed from: b */
    public static void m16984b(boolean z) {
        f15232x.f15253w = z;
        StringBuilder sb = new StringBuilder("config manager: useSecureConnections called with: isSecured: + ");
        sb.append(z);
        IAlog.m18021b(sb.toString());
        if (!C8016n.m18093a() && !z) {
            String str = "************************************************************************************************************************";
            IAlog.m18023d(str);
            IAlog.m18023d("*** useSecureConnections was set to false while secure traffic is enabled in the netwrok security config");
            IAlog.m18023d("***  The traffic will be Secured  ");
            IAlog.m18023d(str);
        }
    }

    /* renamed from: H */
    public static boolean m16957H() {
        return f15232x.f15253w;
    }

    /* renamed from: v */
    public static String m17008v() {
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (!TextUtils.isEmpty(property)) {
            return m16982b(property, "clientRequestEnhancedXmlAd");
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(f15232x.f15237e.f15332k);
        return sb.toString();
    }

    /* renamed from: w */
    public static String m17009w() {
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (!TextUtils.isEmpty(property)) {
            return m16982b(property, "clientRequestNativeAd");
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(f15232x.f15237e.f15333l);
        return sb.toString();
    }

    /* renamed from: x */
    public static String m17010x() {
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (!TextUtils.isEmpty(property)) {
            return m16982b(property, "Event");
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(f15232x.f15237e.f15334m);
        return sb.toString();
    }

    /* renamed from: C */
    public static String m16952C() {
        String property = System.getProperty("ia.testEnvironmentConfiguration.number");
        if (!TextUtils.isEmpty(property) && property.contains(".")) {
            String[] split = property.split("\\.");
            if (split != null && split.length > 1) {
                property = split[f15230h];
            }
            int i = f15230h + 1;
            f15230h = i;
            if (i == split.length) {
                f15230h = 0;
            }
        }
        return property;
    }

    /* renamed from: D */
    public static String m16953D() {
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        if (!TextUtils.isEmpty(property) && property.contains(".")) {
            String[] split = property.split("\\.");
            if (split != null && split.length > 1) {
                property = split[f15231i];
            }
            int i = f15231i + 1;
            f15231i = i;
            if (i == split.length) {
                f15231i = 0;
            }
        }
        return property;
    }

    /* renamed from: E */
    public static String m16954E() {
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (TextUtils.isEmpty(property)) {
            return "wv.inner-active.mobi/simpleM2M/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        sb.append(".inner-active.mobi/simpleM2M/");
        return sb.toString();
    }

    /* renamed from: b */
    static /* synthetic */ void m16983b(IAConfigManager iAConfigManager, SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            String str = "IAGDPRBool";
            if (sharedPreferences.contains(str)) {
                iAConfigManager.f15252v = Boolean.valueOf(sharedPreferences.getBoolean(str, false));
            }
        }
    }
}
