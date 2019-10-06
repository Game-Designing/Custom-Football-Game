package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.y */
/* compiled from: GraphRequestBatch */
public class C6814y extends AbstractList<GraphRequest> {

    /* renamed from: a */
    private static AtomicInteger f12533a = new AtomicInteger();

    /* renamed from: b */
    private Handler f12534b;

    /* renamed from: c */
    private List<GraphRequest> f12535c = new ArrayList();

    /* renamed from: d */
    private int f12536d = 0;

    /* renamed from: e */
    private final String f12537e = Integer.valueOf(f12533a.incrementAndGet()).toString();

    /* renamed from: f */
    private List<C6815a> f12538f = new ArrayList();

    /* renamed from: g */
    private String f12539g;

    /* renamed from: com.facebook.y$a */
    /* compiled from: GraphRequestBatch */
    public interface C6815a {
        /* renamed from: a */
        void mo19866a(C6814y yVar);
    }

    /* renamed from: com.facebook.y$b */
    /* compiled from: GraphRequestBatch */
    public interface C6816b extends C6815a {
        /* renamed from: a */
        void mo20226a(C6814y yVar, long j, long j2);
    }

    public C6814y(Collection<GraphRequest> requests) {
        this.f12535c = new ArrayList(requests);
    }

    public C6814y(GraphRequest... requests) {
        this.f12535c = Arrays.asList(requests);
    }

    /* renamed from: j */
    public int mo20222j() {
        return this.f12536d;
    }

    /* renamed from: a */
    public void mo20207a(C6815a callback) {
        if (!this.f12538f.contains(callback)) {
            this.f12538f.add(callback);
        }
    }

    /* renamed from: a */
    public final boolean add(GraphRequest request) {
        return this.f12535c.add(request);
    }

    /* renamed from: a */
    public final void add(int location, GraphRequest request) {
        this.f12535c.add(location, request);
    }

    public final void clear() {
        this.f12535c.clear();
    }

    public final GraphRequest get(int i) {
        return (GraphRequest) this.f12535c.get(i);
    }

    public final GraphRequest remove(int location) {
        return (GraphRequest) this.f12535c.remove(location);
    }

    /* renamed from: b */
    public final GraphRequest set(int location, GraphRequest request) {
        return (GraphRequest) this.f12535c.set(location, request);
    }

    public final int size() {
        return this.f12535c.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final String mo20220h() {
        return this.f12537e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final Handler mo20217f() {
        return this.f12534b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo20206a(Handler callbackHandler) {
        this.f12534b = callbackHandler;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final List<GraphRequest> mo20221i() {
        return this.f12535c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final List<C6815a> mo20218g() {
        return this.f12538f;
    }

    /* renamed from: e */
    public final String mo20216e() {
        return this.f12539g;
    }

    /* renamed from: a */
    public final List<C6817z> mo20204a() {
        return mo20212b();
    }

    /* renamed from: c */
    public final C6813x mo20213c() {
        return mo20215d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<C6817z> mo20212b() {
        return GraphRequest.m12880a(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C6813x mo20215d() {
        return GraphRequest.m12896b(this);
    }
}
