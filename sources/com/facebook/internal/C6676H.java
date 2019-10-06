package com.facebook.internal;

import android.util.Log;
import com.facebook.C6537C;
import com.facebook.C6787r;
import java.util.HashMap;
import java.util.Map.Entry;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;

/* renamed from: com.facebook.internal.H */
/* compiled from: Logger */
public class C6676H {

    /* renamed from: a */
    private static final HashMap<String, String> f12186a = new HashMap<>();

    /* renamed from: b */
    private final C6537C f12187b;

    /* renamed from: c */
    private final String f12188c;

    /* renamed from: d */
    private StringBuilder f12189d;

    /* renamed from: e */
    private int f12190e = 3;

    /* renamed from: a */
    public static synchronized void m13324a(String original, String replace) {
        synchronized (C6676H.class) {
            f12186a.put(original, replace);
        }
    }

    /* renamed from: c */
    public static synchronized void m13326c(String accessToken) {
        synchronized (C6676H.class) {
            if (!C6787r.m13808a(C6537C.INCLUDE_ACCESS_TOKENS)) {
                m13324a(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    /* renamed from: a */
    public static void m13322a(C6537C behavior, String tag, String string) {
        m13320a(behavior, 3, tag, string);
    }

    /* renamed from: a */
    public static void m13323a(C6537C behavior, String tag, String format, Object... args) {
        if (C6787r.m13808a(behavior)) {
            m13320a(behavior, 3, tag, String.format(format, args));
        }
    }

    /* renamed from: a */
    public static void m13321a(C6537C behavior, int priority, String tag, String format, Object... args) {
        if (C6787r.m13808a(behavior)) {
            m13320a(behavior, priority, tag, String.format(format, args));
        }
    }

    /* renamed from: a */
    public static void m13320a(C6537C behavior, int priority, String tag, String string) {
        if (C6787r.m13808a(behavior)) {
            String string2 = m13327d(string);
            String str = "FacebookSDK.";
            if (!tag.startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(tag);
                tag = sb.toString();
            }
            Log.println(priority, tag, string2);
            if (behavior == C6537C.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private static synchronized String m13327d(String string) {
        synchronized (C6676H.class) {
            for (Entry<String, String> entry : f12186a.entrySet()) {
                string = string.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return string;
    }

    public C6676H(C6537C behavior, String tag) {
        C6697T.m13462a(tag, BundleCons.TAG);
        this.f12187b = behavior;
        StringBuilder sb = new StringBuilder();
        sb.append("FacebookSDK.");
        sb.append(tag);
        this.f12188c = sb.toString();
        this.f12189d = new StringBuilder();
    }

    /* renamed from: a */
    public void mo19887a() {
        mo19891b(this.f12189d.toString());
        this.f12189d = new StringBuilder();
    }

    /* renamed from: b */
    public void mo19891b(String string) {
        m13320a(this.f12187b, this.f12190e, this.f12188c, string);
    }

    /* renamed from: a */
    public void mo19888a(String string) {
        if (m13325b()) {
            this.f12189d.append(string);
        }
    }

    /* renamed from: a */
    public void mo19890a(String format, Object... args) {
        if (m13325b()) {
            this.f12189d.append(String.format(format, args));
        }
    }

    /* renamed from: a */
    public void mo19889a(String key, Object value) {
        mo19890a("  %s:\t%s\n", key, value);
    }

    /* renamed from: b */
    private boolean m13325b() {
        return C6787r.m13808a(this.f12187b);
    }
}
