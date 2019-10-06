package com.inmobi.ads;

import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.rendering.p226a.C10738c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.ak */
/* compiled from: NativeAsset */
public class C10400ak {

    /* renamed from: z */
    private static final String f31607z = C10400ak.class.getSimpleName();

    /* renamed from: a */
    String f31608a;

    /* renamed from: b */
    String f31609b;

    /* renamed from: c */
    public C10401al f31610c;

    /* renamed from: d */
    String f31611d;

    /* renamed from: e */
    Object f31612e;

    /* renamed from: f */
    JSONObject f31613f;

    /* renamed from: g */
    String f31614g;

    /* renamed from: h */
    boolean f31615h;

    /* renamed from: i */
    int f31616i = 2;

    /* renamed from: j */
    String f31617j;

    /* renamed from: k */
    int f31618k;

    /* renamed from: l */
    int f31619l;

    /* renamed from: m */
    int f31620m;

    /* renamed from: n */
    int f31621n;

    /* renamed from: o */
    int f31622o;

    /* renamed from: p */
    int f31623p;

    /* renamed from: q */
    String f31624q;

    /* renamed from: r */
    String f31625r;

    /* renamed from: s */
    String f31626s;

    /* renamed from: t */
    C10400ak f31627t;

    /* renamed from: u */
    List<NativeTracker> f31628u;

    /* renamed from: v */
    public Map<String, Object> f31629v;

    /* renamed from: w */
    Object f31630w;

    /* renamed from: x */
    int f31631x;

    /* renamed from: y */
    public C10400ak f31632y;

    public C10400ak() {
        this("", "root", "CONTAINER");
    }

    private C10400ak(String str, String str2, String str3) {
        this(str, str2, str3, new C10401al());
    }

    public C10400ak(String str, String str2, String str3, C10401al alVar) {
        this(str, str2, str3, alVar, new LinkedList());
    }

    public C10400ak(String str, String str2, String str3, C10401al alVar, List<NativeTracker> list) {
        this.f31608a = str;
        this.f31611d = str2;
        this.f31609b = str3;
        this.f31610c = alVar;
        this.f31612e = null;
        String str4 = "";
        this.f31614g = str4;
        this.f31615h = false;
        this.f31616i = 0;
        this.f31617j = str4;
        this.f31619l = 0;
        this.f31618k = 0;
        this.f31620m = 0;
        this.f31621n = 2;
        this.f31631x = 0;
        this.f31622o = -1;
        this.f31624q = str4;
        this.f31625r = str4;
        this.f31613f = new JSONObject();
        this.f31628u = new LinkedList();
        this.f31628u.addAll(list);
        this.f31629v = new HashMap();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34089a(List<NativeTracker> list, TrackerEventType trackerEventType) {
        for (NativeTracker nativeTracker : list) {
            if (trackerEventType == nativeTracker.f31378b) {
                this.f31628u.add(nativeTracker);
            }
        }
    }

    /* renamed from: a */
    public final void mo34086a(TrackerEventType trackerEventType, Map<String, String> map) {
        if (this.f31628u.size() != 0) {
            for (NativeTracker nativeTracker : this.f31628u) {
                if (trackerEventType == nativeTracker.f31378b) {
                    m34047a(nativeTracker, map);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34088a(List<NativeTracker> list) {
        this.f31628u.addAll(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34087a(String str) {
        this.f31625r = str.trim();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo34090b(String str) {
        this.f31626s = str.trim();
    }

    /* renamed from: a */
    public static C10400ak m34046a(String str, String str2, String str3) {
        C10400ak akVar = new C10400ak();
        akVar.mo34087a(str);
        if (str2 != null) {
            akVar.mo34090b(str2);
        }
        akVar.f31630w = str3;
        return akVar;
    }

    /* renamed from: a */
    static void m34047a(NativeTracker nativeTracker, Map<String, String> map) {
        C10738c.m35282a().mo34653a(C10700d.m35142a(nativeTracker.f31377a, map), nativeTracker.f31379c);
    }
}
