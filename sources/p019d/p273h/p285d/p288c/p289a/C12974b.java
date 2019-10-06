package p019d.p273h.p285d.p288c.p289a;

import android.app.Application;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.MoatFactory;
import com.moat.analytics.mobile.iro.MoatOptions;
import com.moat.analytics.mobile.iro.TrackerListener;
import com.moat.analytics.mobile.iro.WebAdTracker;
import org.json.JSONObject;

/* renamed from: d.h.d.c.a.b */
/* compiled from: MOATManager */
public class C12974b {

    /* renamed from: a */
    private static WebAdTracker f39929a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static C12975a f39930b;

    /* renamed from: c */
    private static TrackerListener f39931c = new C12973a();

    /* renamed from: d.h.d.c.a.b$a */
    /* compiled from: MOATManager */
    public interface C12975a extends TrackerListener {
    }

    /* renamed from: a */
    public static void m42318a(C12975a eventsListener) {
        f39930b = eventsListener;
    }

    /* renamed from: a */
    public static void m42319a(JSONObject options, Application application) throws Exception {
        MoatOptions o = null;
        if (options != null && options.length() > 0) {
            o = m42315a(options);
        }
        MoatAnalytics.getInstance().start(o, application);
    }

    /* renamed from: a */
    private static MoatOptions m42315a(JSONObject options) {
        MoatOptions mo = new MoatOptions();
        mo.loggingEnabled = options.optBoolean("loggingEnabled");
        mo.autoTrackGMAInterstitials = options.optBoolean("autoTrackGMAInterstitials");
        mo.disableAdIdCollection = options.optBoolean("disableAdIdCollection");
        mo.disableLocationServices = options.optBoolean("disableLocationServices");
        return mo;
    }

    /* renamed from: a */
    public static void m42317a(WebView webView) throws Exception {
        f39929a = MoatFactory.create().createWebAdTracker(webView);
    }

    /* renamed from: b */
    public static void m42320b() throws Exception {
        WebAdTracker webAdTracker = f39929a;
        if (webAdTracker != null) {
            webAdTracker.setListener(f39931c);
            f39929a.startTracking();
        }
    }

    /* renamed from: c */
    public static void m42321c() throws Exception {
        WebAdTracker webAdTracker = f39929a;
        if (webAdTracker != null) {
            webAdTracker.stopTracking();
        }
    }
}
