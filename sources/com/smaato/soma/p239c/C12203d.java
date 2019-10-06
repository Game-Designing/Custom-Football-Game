package com.smaato.soma.p239c;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12408ia;
import com.smaato.soma.C12431j;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p244e.C12205a;
import com.smaato.soma.p239c.p253j.C12285d;
import com.smaato.soma.p256e.C12331a;
import com.smaato.soma.p256e.C12360w;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/* renamed from: com.smaato.soma.c.d */
/* compiled from: ReceivedBanner */
public class C12203d implements C12064Na {

    /* renamed from: a */
    private C12111b f38230a = C12111b.f37995c;

    /* renamed from: b */
    private C12408ia f38231b = C12408ia.NO_ERROR;

    /* renamed from: c */
    private String f38232c;

    /* renamed from: d */
    private C12431j f38233d;

    /* renamed from: e */
    private String f38234e;

    /* renamed from: f */
    private String f38235f;

    /* renamed from: g */
    private String f38236g;

    /* renamed from: h */
    private String f38237h;

    /* renamed from: i */
    private List<String> f38238i;

    /* renamed from: j */
    private Vector<String> f38239j;

    /* renamed from: k */
    private List<C12204a> f38240k;

    /* renamed from: l */
    private String f38241l;

    /* renamed from: m */
    private C12285d f38242m;

    /* renamed from: n */
    private C12205a f38243n;

    /* renamed from: o */
    private boolean f38244o;

    /* renamed from: p */
    private C12331a f38245p = C12331a.UNDEFINED;

    /* renamed from: q */
    private TreeMap<Integer, C12360w> f38246q;

    /* renamed from: r */
    private String f38247r;

    /* renamed from: i */
    public String mo39294i() {
        return this.f38247r;
    }

    /* renamed from: a */
    public void mo39281a(String passBackUrl) {
        this.f38247r = passBackUrl;
    }

    /* renamed from: e */
    public boolean mo39288e() {
        return this.f38244o;
    }

    /* renamed from: a */
    public void mo39283a(boolean isMediationSuccess) {
        this.f38244o = isMediationSuccess;
    }

    /* renamed from: m */
    public C12331a mo39298m() {
        return this.f38245p;
    }

    /* renamed from: a */
    public void mo39279a(C12331a csmAdFormat) {
        this.f38245p = csmAdFormat;
    }

    public final String getSessionId() {
        return this.f38235f;
    }

    public final void setSessionId(String sessionId) {
        this.f38235f = sessionId;
    }

    public final C12111b getStatus() {
        return this.f38230a;
    }

    /* renamed from: a */
    public final void mo39278a(C12111b status) {
        this.f38230a = status;
    }

    /* renamed from: b */
    public final C12431j mo39284b() {
        return this.f38233d;
    }

    /* renamed from: a */
    public final void mo39501a(C12431j adType) {
        this.f38233d = adType;
    }

    /* renamed from: c */
    public final String mo39286c() {
        return this.f38241l;
    }

    /* renamed from: f */
    public final void mo39508f(String richMediaData) {
        this.f38241l = richMediaData;
    }

    /* renamed from: l */
    public final String mo39297l() {
        return this.f38237h;
    }

    /* renamed from: c */
    public final void mo39505c(String clickUrl) {
        this.f38237h = clickUrl;
    }

    /* renamed from: h */
    public final List<String> mo39293h() {
        return this.f38238i;
    }

    /* renamed from: a */
    public final void mo39502a(List<String> beacons) {
        this.f38238i = beacons;
    }

    /* renamed from: p */
    public String mo39301p() {
        return this.f38234e;
    }

    /* renamed from: b */
    public void mo39285b(String smaatoCreativeId) {
        this.f38234e = smaatoCreativeId;
    }

    /* renamed from: k */
    public final String mo39296k() {
        return this.f38236g;
    }

    /* renamed from: e */
    public final void mo39507e(String imageUrl) {
        this.f38236g = imageUrl;
    }

    /* renamed from: g */
    public final C12408ia mo39290g() {
        return this.f38231b;
    }

    /* renamed from: a */
    public final void mo39280a(C12408ia errorCode) {
        this.f38231b = errorCode;
    }

    /* renamed from: a */
    public final String mo39277a() {
        return this.f38232c;
    }

    /* renamed from: d */
    public final void mo39506d(String errorMessage) {
        this.f38232c = errorMessage;
    }

    /* renamed from: f */
    public List<C12204a> mo39289f() {
        return this.f38240k;
    }

    /* renamed from: b */
    public void mo39504b(List<C12204a> extensions) {
        this.f38240k = extensions;
    }

    /* renamed from: o */
    public C12285d mo39300o() {
        return this.f38242m;
    }

    /* renamed from: a */
    public void mo39500a(C12285d vastAd) {
        this.f38242m = vastAd;
    }

    /* renamed from: j */
    public C12205a mo39295j() {
        return this.f38243n;
    }

    /* renamed from: a */
    public void mo39499a(C12205a nativeAd) {
        this.f38243n = nativeAd;
    }

    /* renamed from: a */
    public void mo39282a(TreeMap<Integer, C12360w> networkInfoMap) {
        this.f38246q = networkInfoMap;
    }

    /* renamed from: n */
    public TreeMap<Integer, C12360w> mo39299n() {
        return this.f38246q;
    }

    /* renamed from: a */
    public void mo39503a(Vector<String> clickTrackingUrls) {
        this.f38239j = clickTrackingUrls;
    }

    /* renamed from: d */
    public Vector<String> mo39287d() {
        return this.f38239j;
    }
}
