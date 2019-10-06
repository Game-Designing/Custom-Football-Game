package com.fyber.inneractive.sdk.p164e;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;
import com.moat.analytics.mobile.ina.MoatAdEvent;
import com.moat.analytics.mobile.ina.MoatAdEventType;
import com.moat.analytics.mobile.ina.MoatAnalytics;
import com.moat.analytics.mobile.ina.MoatFactory;
import com.moat.analytics.mobile.ina.MoatOptions;
import com.moat.analytics.mobile.ina.WebAdTracker;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.e.a */
public final class C7721a {

    /* renamed from: a */
    private static boolean f15382a = false;

    /* renamed from: com.fyber.inneractive.sdk.e.a$a */
    public static class C7722a {

        /* renamed from: a */
        String f15383a = null;

        /* renamed from: b */
        public Map<String, String> f15384b;

        public C7722a(String str) {
            this.f15383a = str;
            this.f15384b = new HashMap();
        }
    }

    /* renamed from: a */
    public static void m17104a(Context context) {
        String str = "Could not find the MOAT library. MOAT tracking will be disabled";
        if (!f15382a) {
            try {
                MoatAnalytics instance = MoatAnalytics.getInstance();
                MoatOptions moatOptions = new MoatOptions();
                if (m17110b()) {
                    moatOptions.loggingEnabled = true;
                }
                if (instance != null) {
                    instance.start(moatOptions, (Application) context);
                }
                f15382a = true;
                StringBuilder sb = new StringBuilder("MOAT Analytics factory initialized successfully: ");
                sb.append(instance);
                m17109b(sb.toString());
            } catch (Exception e) {
                m17109b(str);
            } catch (NoClassDefFoundError e2) {
                m17109b(str);
            }
        }
    }

    /* renamed from: a */
    public static Object m17100a() {
        String str = "Could not find the MOAT library. MOAT tracking will be disabled";
        MoatFactory moatFactory = null;
        try {
            moatFactory = MoatFactory.create();
            StringBuilder sb = new StringBuilder("MOAT factory initialized successfully: ");
            sb.append(moatFactory);
            m17109b(sb.toString());
            return moatFactory;
        } catch (Exception e) {
            m17109b(str);
            return moatFactory;
        } catch (NoClassDefFoundError e2) {
            m17109b(str);
            return moatFactory;
        }
    }

    /* renamed from: a */
    public static Object m17102a(Object obj, C7722a aVar, Object obj2, View view) {
        IAlog.m18023d("MoatProxy.trackVideoAd called with MediaPlayer!");
        if (obj == null) {
            IAlog.m18023d("MoatProxy.trackVideoAd: given moatFactory is null!");
            return null;
        } else if (TextUtils.isEmpty(aVar.f15383a)) {
            IAlog.m18023d("MoatProxy.trackVideoAd: Partner code is empty and must be provided");
            return null;
        } else {
            try {
                C7725d a = m17099a((MoatFactory) obj, aVar.f15383a, obj2);
                if (a == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder("MOAT calling trackVideoAd with video tracker: ");
                sb.append(a);
                m17109b(sb.toString());
                StringBuilder sb2 = new StringBuilder("MOAT calling trackVideoAd params map: ");
                sb2.append(aVar.f15384b);
                m17109b(sb2.toString());
                a.mo24242a(aVar.f15384b, obj2, view);
                m17109b("MOAT trackVideoAd finished successfully");
                return a;
            } catch (Exception e) {
                m17109b("MOAT startMoatTracking failed. ");
                return null;
            } catch (NoClassDefFoundError e2) {
                m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
                return null;
            }
        }
    }

    /* renamed from: a */
    public static void m17105a(Object obj) {
        if (obj != null) {
            try {
                ((C7725d) obj).mo24239a();
                m17109b("MOAT videoTracker stopTracking called successfully");
            } catch (Exception e) {
                m17109b("MOAT videoTracker stopTracking failed");
            } catch (NoClassDefFoundError e2) {
                m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
            }
        }
    }

    /* renamed from: a */
    private static C7725d m17099a(MoatFactory moatFactory, String str, Object obj) {
        C7725d dVar;
        try {
            StringBuilder sb = new StringBuilder("MOAT Called MoatFactory.createNativeVideoTracker. partner code = ");
            sb.append(str);
            m17109b(sb.toString());
            if (C7723b.m17112a(obj)) {
                dVar = new C7723b(moatFactory, str);
            } else if (obj instanceof MediaPlayer) {
                dVar = new C7724c(moatFactory, str);
            } else {
                dVar = null;
            }
            StringBuilder sb2 = new StringBuilder("MOAT video tracker might have created successfully (");
            sb2.append(dVar);
            sb2.append(")");
            m17109b(sb2.toString());
            return dVar;
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder("MOAT - MoatFactory.createNativeVideoTracker with partner code = ");
            sb3.append(str);
            sb3.append(" Failed!");
            m17109b(sb3.toString());
            return null;
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
            return null;
        }
    }

    /* renamed from: a */
    public static void m17106a(Object obj, View view) {
        try {
            StringBuilder sb = new StringBuilder("MOAT - switchVideoAdTrackedView called with ");
            sb.append(view);
            m17109b(sb.toString());
            ((C7725d) obj).mo24240a(view);
        } catch (Exception e) {
            m17109b("MOAT - MoatFactory.switchVideoAdTrackedView failed!");
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
        }
    }

    /* renamed from: a */
    public static void m17107a(Object obj, boolean z) {
        Double d = new Double(z ? 0.0d : 1.0d);
        StringBuilder sb = new StringBuilder("MOAT got trackVideoMuteStateChanged with ");
        sb.append(z);
        m17109b(sb.toString());
        try {
            ((C7725d) obj).mo24241a(d);
            StringBuilder sb2 = new StringBuilder("MOAT setPlayerVolume called with ");
            sb2.append(d);
            sb2.append(" successfully");
            m17109b(sb2.toString());
        } catch (Exception e) {
            m17109b("Failed dispatching moat mute/un-mute event!");
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
        }
    }

    /* renamed from: b */
    public static void m17108b(Object obj) {
        Object a = m17103a("AD_EVT_COMPLETE");
        StringBuilder sb = new StringBuilder("MoatProxy.dispatchAdEvent called with tracker: ");
        sb.append(obj);
        sb.append(" event: ");
        sb.append(a);
        m17109b(sb.toString());
        try {
            ((C7725d) obj).mo24243a((MoatAdEvent) a);
        } catch (Exception e) {
            m17109b("Failed dispatching moat event!");
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
        }
    }

    /* renamed from: a */
    private static Object m17103a(String str) {
        try {
            MoatAdEventType valueOf = MoatAdEventType.valueOf(str);
            StringBuilder sb = new StringBuilder("Creating MOAT ad event type = ");
            sb.append(valueOf);
            m17109b(sb.toString());
            return new MoatAdEvent(valueOf);
        } catch (Exception e) {
            m17109b("Failed creating moat event!");
            return null;
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
            return null;
        }
    }

    /* renamed from: a */
    public static Object m17101a(Object obj, WebView webView) {
        try {
            m17109b("MOAT Called MoatFactory.createWebDisplayTracker");
            WebAdTracker createWebAdTracker = ((MoatFactory) obj).createWebAdTracker(webView);
            m17109b("MOAT calling webTracker.startTracking");
            createWebAdTracker.startTracking();
            m17109b("MOAT webTracker.startTracking called successfuly");
            return createWebAdTracker;
        } catch (Exception e) {
            m17109b("failed creating MOAT web tracker");
            return null;
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
            return null;
        }
    }

    /* renamed from: c */
    public static void m17111c(Object obj) {
        try {
            m17109b("MOAT calling webTracker.stopTracking");
            ((WebAdTracker) obj).stopTracking();
            m17109b("MOAT webTracker stopTracking called successfully");
        } catch (Exception e) {
            m17109b("failed stopping MOAT web tracker");
        } catch (NoClassDefFoundError e2) {
            m17109b("Could not find the MOAT library. MOAT tracking will be disabled");
        }
    }

    /* renamed from: b */
    private static void m17109b(String str) {
        if (m17110b()) {
            StringBuilder sb = new StringBuilder("(");
            sb.append(Thread.currentThread().getName());
            sb.append(") ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
        }
    }

    /* renamed from: b */
    private static boolean m17110b() {
        return IAlog.f16291a < 4;
    }
}
