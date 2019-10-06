package com.facebook.internal;

import com.facebook.C6787r;
import java.util.Collection;

/* renamed from: com.facebook.internal.N */
/* compiled from: ServerProtocol */
public final class C6690N {

    /* renamed from: a */
    private static final String f12211a = C6690N.class.getName();

    /* renamed from: b */
    public static final Collection<String> f12212b = C6694S.m13432b((T[]) new String[]{"service_disabled", "AndroidAuthKillSwitchException"});

    /* renamed from: c */
    public static final Collection<String> f12213c = C6694S.m13432b((T[]) new String[]{"access_denied", "OAuthAccessDeniedException"});

    /* renamed from: b */
    public static final String m13388b() {
        return String.format("m.%s", new Object[]{C6787r.m13823m()});
    }

    /* renamed from: c */
    public static final String m13389c() {
        return String.format("https://graph.%s", new Object[]{C6787r.m13823m()});
    }

    /* renamed from: d */
    public static final String m13390d() {
        return String.format("https://graph-video.%s", new Object[]{C6787r.m13823m()});
    }

    /* renamed from: a */
    public static final String m13387a() {
        return "v3.3";
    }
}
