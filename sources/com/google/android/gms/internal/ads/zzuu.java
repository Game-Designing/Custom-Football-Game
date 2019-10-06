package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@zzard
public final class zzuu extends Thread {

    /* renamed from: a */
    private boolean f29490a;

    /* renamed from: b */
    private boolean f29491b;

    /* renamed from: c */
    private boolean f29492c;

    /* renamed from: d */
    private final Object f29493d;

    /* renamed from: e */
    private final zzup f29494e;

    /* renamed from: f */
    private final int f29495f;

    /* renamed from: g */
    private final int f29496g;

    /* renamed from: h */
    private final int f29497h;

    /* renamed from: i */
    private final int f29498i;

    /* renamed from: j */
    private final int f29499j;

    /* renamed from: k */
    private final int f29500k;

    /* renamed from: l */
    private final int f29501l;

    /* renamed from: m */
    private final int f29502m;

    /* renamed from: n */
    private final String f29503n;

    /* renamed from: o */
    private final boolean f29504o;

    /* renamed from: p */
    private final boolean f29505p;

    /* renamed from: q */
    private final boolean f29506q;

    public zzuu() {
        this(new zzup());
    }

    @VisibleForTesting
    private zzuu(zzup zzup) {
        this.f29490a = false;
        this.f29491b = false;
        this.f29492c = false;
        this.f29494e = zzup;
        this.f29493d = new Object();
        this.f29496g = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24107ia)).intValue();
        this.f29497h = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24113ja)).intValue();
        this.f29498i = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24119ka)).intValue();
        this.f29499j = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24125la)).intValue();
        this.f29500k = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24137na)).intValue();
        this.f29501l = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24143oa)).intValue();
        this.f29502m = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24149pa)).intValue();
        this.f29495f = ((Integer) zzyt.m31536e().mo29599a(zzacu.f24131ma)).intValue();
        this.f29503n = (String) zzyt.m31536e().mo29599a(zzacu.f24161ra);
        this.f29504o = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24167sa)).booleanValue();
        this.f29505p = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24191wa)).booleanValue();
        this.f29506q = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24197xa)).booleanValue();
        setName("ContentFetchTask");
    }

    /* renamed from: b */
    public final void mo32291b() {
        synchronized (this.f29493d) {
            if (this.f29490a) {
                zzbad.m26352a("Content hash thread already started, quiting...");
                return;
            }
            this.f29490a = true;
            start();
        }
    }

    public final void run() {
        while (true) {
            try {
                if (m31265e()) {
                    Activity a = zzk.zzlj().mo32284a();
                    if (a == null) {
                        zzbad.m26352a("ContentFetchThread: no activity. Sleeping.");
                        m31266f();
                    } else if (a != null) {
                        View view = null;
                        try {
                            if (!(a.getWindow() == null || a.getWindow().getDecorView() == null)) {
                                view = a.getWindow().getDecorView().findViewById(16908290);
                            }
                        } catch (Exception e) {
                            zzk.zzlk().mo30168a((Throwable) e, "ContentFetchTask.extractContent");
                            zzbad.m26352a("Failed getting root view of activity. Content not extracted.");
                        }
                        if (!(view == null || view == null)) {
                            view.post(new C9805wt(this, view));
                        }
                    }
                } else {
                    zzbad.m26352a("ContentFetchTask: sleeping");
                    m31266f();
                }
                Thread.sleep((long) (this.f29495f * 1000));
            } catch (InterruptedException e2) {
                zzbad.m26356b("Error in ContentFetchTask", e2);
            } catch (Exception e3) {
                zzbad.m26356b("Error in ContentFetchTask", e3);
                zzk.zzlk().mo30168a((Throwable) e3, "ContentFetchTask.run");
            }
            synchronized (this.f29493d) {
                while (this.f29491b) {
                    try {
                        zzbad.m26352a("ContentFetchTask: waiting");
                        this.f29493d.wait();
                    } catch (InterruptedException e4) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public final void mo32289a(View view) {
        try {
            zzuo zzuo = new zzuo(this.f29496g, this.f29497h, this.f29498i, this.f29499j, this.f29500k, this.f29501l, this.f29502m, this.f29505p);
            Context b = zzk.zzlj().mo32287b();
            if (b != null && !TextUtils.isEmpty(this.f29503n)) {
                String str = (String) view.getTag(b.getResources().getIdentifier((String) zzyt.m31536e().mo29599a(zzacu.f24155qa), "id", b.getPackageName()));
                if (str != null && str.equals(this.f29503n)) {
                    return;
                }
            }
            C9868zt a = m31264a(view, zzuo);
            zzuo.mo32277j();
            if (a.f23791a != 0 || a.f23792b != 0) {
                if (a.f23792b != 0 || zzuo.mo32278k() != 0) {
                    if (a.f23792b != 0 || !this.f29494e.mo32281a(zzuo)) {
                        this.f29494e.mo32283c(zzuo);
                    }
                }
            }
        } catch (Exception e) {
            zzbad.m26356b("Exception in fetchContentOnUIThread", e);
            zzk.zzlk().mo30168a((Throwable) e, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    /* renamed from: e */
    private static boolean m31265e() {
        boolean z;
        try {
            Context b = zzk.zzlj().mo32287b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    Iterator it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                        if (Process.myPid() == runningAppProcessInfo.pid) {
                            if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                PowerManager powerManager = (PowerManager) b.getSystemService("power");
                                if (powerManager == null) {
                                    z = false;
                                } else {
                                    z = powerManager.isScreenOn();
                                }
                                if (z) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzk.zzlk().mo30168a(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private final C9868zt m31264a(View view, zzuo zzuo) {
        boolean z;
        if (view == null) {
            return new C9868zt(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C9868zt(this, 0, 0);
            }
            zzuo.mo32266b(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new C9868zt(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbgz)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.m22112f()) {
                z = false;
            } else {
                zzuo.mo32274h();
                webView.post(new C9826xt(this, zzuo, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new C9868zt(this, 0, 1);
            }
            return new C9868zt(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C9868zt(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                C9868zt a = m31264a(viewGroup.getChildAt(i3), zzuo);
                i += a.f23791a;
                i2 += a.f23792b;
            }
            return new C9868zt(this, i, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public final void mo32290a(zzuo zzuo, WebView webView, String str, boolean z) {
        zzuo.mo32273g();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(CommandHandler.TEXT);
                if (this.f29504o || TextUtils.isEmpty(webView.getTitle())) {
                    zzuo.mo32265a(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzuo.mo32265a(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzuo.mo32267b()) {
                this.f29494e.mo32282b(zzuo);
            }
        } catch (JSONException e) {
            zzbad.m26352a("Json string may be malformed.");
        } catch (Throwable th) {
            zzbad.m26353a("Failed to get webview content.", th);
            zzk.zzlk().mo30168a(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* renamed from: c */
    public final zzuo mo32292c() {
        return this.f29494e.mo32280a(this.f29506q);
    }

    /* renamed from: a */
    public final void mo32288a() {
        synchronized (this.f29493d) {
            this.f29491b = false;
            this.f29493d.notifyAll();
            zzbad.m26352a("ContentFetchThread: wakeup");
        }
    }

    /* renamed from: f */
    private final void m31266f() {
        synchronized (this.f29493d) {
            this.f29491b = true;
            boolean z = this.f29491b;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzbad.m26352a(sb.toString());
        }
    }

    /* renamed from: d */
    public final boolean mo32293d() {
        return this.f29491b;
    }
}
