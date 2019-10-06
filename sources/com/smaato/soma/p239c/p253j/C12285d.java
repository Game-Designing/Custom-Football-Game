package com.smaato.soma.p239c.p253j;

import android.net.Uri;
import com.smaato.soma.p239c.p243d.C12204a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.smaato.soma.c.j.d */
/* compiled from: VASTAd */
public class C12285d {

    /* renamed from: a */
    private String f38442a;

    /* renamed from: b */
    private Map<String, Vector<String>> f38443b = new HashMap();

    /* renamed from: c */
    private String f38444c;

    /* renamed from: d */
    private String f38445d;

    /* renamed from: e */
    private Vector<String> f38446e = new Vector<>();

    /* renamed from: f */
    private C12282a f38447f;

    /* renamed from: g */
    private Vector<String> f38448g = new Vector<>();

    /* renamed from: h */
    private Vector<String> f38449h = new Vector<>();

    /* renamed from: i */
    private List<C12204a> f38450i;

    /* renamed from: a */
    public C12282a mo39691a() {
        return this.f38447f;
    }

    /* renamed from: a */
    public void mo39693a(C12282a companionAd) {
        this.f38447f = companionAd;
    }

    /* renamed from: i */
    public Uri mo39709i() {
        return Uri.parse(this.f38442a);
    }

    /* renamed from: d */
    public void mo39703d(String videoURL) {
        this.f38442a = videoURL;
    }

    /* renamed from: b */
    public void mo39697b(String duration) {
        this.f38444c = duration;
    }

    /* renamed from: b */
    public String mo39696b() {
        return this.f38444c;
    }

    /* renamed from: c */
    public long mo39699c() {
        return ((Long) new C12284c(this).execute()).longValue();
    }

    /* renamed from: a */
    public void mo39694a(String key, String value) {
        if (this.f38443b.containsKey(key)) {
            ((Vector) this.f38443b.get(key)).add(value.trim());
            return;
        }
        Vector<String> v = new Vector<>();
        v.add(value.trim());
        this.f38443b.put(key, v);
    }

    /* renamed from: a */
    public Vector<String> mo39692a(String event) {
        return (Vector) this.f38443b.get(event);
    }

    /* renamed from: g */
    public String mo39707g() {
        return this.f38445d;
    }

    /* renamed from: c */
    public void mo39700c(String url) {
        this.f38445d = url;
    }

    /* renamed from: c */
    public void mo39701c(List<String> videoClickTrackingURLs) {
        this.f38446e.addAll(videoClickTrackingURLs);
    }

    /* renamed from: h */
    public Vector<String> mo39708h() {
        return this.f38446e;
    }

    /* renamed from: f */
    public Vector<String> mo39706f() {
        return this.f38448g;
    }

    /* renamed from: b */
    public void mo39698b(List<String> impressionTrackers) {
        this.f38448g.addAll(impressionTrackers);
    }

    /* renamed from: e */
    public List<C12204a> mo39705e() {
        return this.f38450i;
    }

    /* renamed from: d */
    public void mo39704d(List<C12204a> mExtensions) {
        this.f38450i = mExtensions;
    }

    /* renamed from: d */
    public Vector<String> mo39702d() {
        return this.f38449h;
    }

    /* renamed from: a */
    public void mo39695a(List<String> errorUrls) {
        this.f38449h.addAll(errorUrls);
    }
}
