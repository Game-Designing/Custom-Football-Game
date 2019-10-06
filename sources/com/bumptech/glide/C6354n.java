package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.C6326q;
import com.bumptech.glide.load.p113c.p118e.C6208c;
import com.bumptech.glide.p100c.C5929c;
import com.bumptech.glide.p100c.C5929c.C5930a;
import com.bumptech.glide.p100c.C5931d;
import com.bumptech.glide.p100c.C5936i;
import com.bumptech.glide.p100c.C5937j;
import com.bumptech.glide.p100c.C5944o;
import com.bumptech.glide.p100c.C5945p;
import com.bumptech.glide.p100c.C5948r;
import com.bumptech.glide.p103f.C5986c;
import com.bumptech.glide.p103f.C5991g;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p103f.p104a.C5977j;
import com.bumptech.glide.p103f.p105b.C5983b;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.request.target.Target;

/* renamed from: com.bumptech.glide.n */
/* compiled from: RequestManager */
public class C6354n implements C5937j, C5997g<C6029k<Drawable>> {

    /* renamed from: a */
    private static final C5991g f11328a;

    /* renamed from: b */
    private static final C5991g f11329b;

    /* renamed from: c */
    private static final C5991g f11330c = C5991g.m11106b(C6326q.f11250c).mo18740a(C6001h.LOW).mo18749a(true);

    /* renamed from: d */
    protected final C5926c f11331d;

    /* renamed from: e */
    protected final Context f11332e;

    /* renamed from: f */
    final C5936i f11333f;

    /* renamed from: g */
    private final C5945p f11334g;

    /* renamed from: h */
    private final C5944o f11335h;

    /* renamed from: i */
    private final C5948r f11336i;

    /* renamed from: j */
    private final Runnable f11337j;

    /* renamed from: k */
    private final Handler f11338k;

    /* renamed from: l */
    private final C5929c f11339l;

    /* renamed from: m */
    private C5991g f11340m;

    /* renamed from: com.bumptech.glide.n$a */
    /* compiled from: RequestManager */
    private static class C6355a extends C5977j<View, Object> {
        C6355a(View view) {
            super(view);
        }

        public void onResourceReady(Object resource, C5983b<? super Object> bVar) {
        }
    }

    /* renamed from: com.bumptech.glide.n$b */
    /* compiled from: RequestManager */
    private static class C6356b implements C5930a {

        /* renamed from: a */
        private final C5945p f11341a;

        C6356b(C5945p requestTracker) {
            this.f11341a = requestTracker;
        }

        /* renamed from: a */
        public void mo18595a(boolean isConnected) {
            if (isConnected) {
                this.f11341a.mo18625c();
            }
        }
    }

    static {
        C5991g b = C5991g.m11108b(Bitmap.class);
        b.mo18731J();
        f11328a = b;
        C5991g b2 = C5991g.m11108b(C6208c.class);
        b2.mo18731J();
        f11329b = b2;
    }

    public C6354n(C5926c glide, C5936i lifecycle, C5944o treeNode, Context context) {
        this(glide, lifecycle, treeNode, new C5945p(), glide.mo18582d(), context);
    }

    C6354n(C5926c glide, C5936i lifecycle, C5944o treeNode, C5945p requestTracker, C5931d factory, Context context) {
        this.f11336i = new C5948r();
        this.f11337j = new C6030l(this);
        this.f11338k = new Handler(Looper.getMainLooper());
        this.f11331d = glide;
        this.f11333f = lifecycle;
        this.f11335h = treeNode;
        this.f11334g = requestTracker;
        this.f11332e = context;
        this.f11339l = factory.mo18596a(context.getApplicationContext(), new C6356b(requestTracker));
        if (C6026k.m11287c()) {
            this.f11338k.post(this.f11337j);
        } else {
            lifecycle.mo18593b(this);
        }
        lifecycle.mo18593b(this.f11339l);
        mo19322a(glide.mo18584f().mo18650b());
        glide.mo18577a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19322a(C5991g toSet) {
        C5991g clone = toSet.clone();
        clone.mo18735a();
        this.f11340m = clone;
    }

    /* renamed from: d */
    public void mo19327d() {
        C6026k.m11283b();
        this.f11334g.mo18623b();
    }

    /* renamed from: e */
    public void mo19328e() {
        C6026k.m11283b();
        this.f11334g.mo18626d();
    }

    public void onStart() {
        mo19328e();
        this.f11336i.onStart();
    }

    public void onStop() {
        mo19327d();
        this.f11336i.onStop();
    }

    public void onDestroy() {
        this.f11336i.onDestroy();
        for (Target<?> target : this.f11336i.mo18636b()) {
            mo19320a((C5976i<?>) target);
        }
        this.f11336i.mo18634a();
        this.f11334g.mo18621a();
        this.f11333f.mo18591a(this);
        this.f11333f.mo18591a(this.f11339l);
        this.f11338k.removeCallbacks(this.f11337j);
        this.f11331d.mo18580b(this);
    }

    /* renamed from: a */
    public C6029k<Bitmap> mo19314a() {
        C6029k<Bitmap> a = mo19316a(Bitmap.class);
        a.mo18838a(f11328a);
        return a;
    }

    /* renamed from: b */
    public C6029k<Drawable> mo19323b() {
        return mo19316a(Drawable.class);
    }

    /* renamed from: a */
    public C6029k<Drawable> mo19318a(String string) {
        C6029k<Drawable> b = mo19323b();
        b.mo18841a(string);
        return b;
    }

    /* renamed from: a */
    public C6029k<Drawable> mo19315a(Uri uri) {
        C6029k<Drawable> b = mo19323b();
        b.mo18837a(uri);
        return b;
    }

    /* renamed from: a */
    public C6029k<Drawable> mo19317a(Integer resourceId) {
        C6029k<Drawable> b = mo19323b();
        b.mo18839a(resourceId);
        return b;
    }

    /* renamed from: a */
    public <ResourceType> C6029k<ResourceType> mo19316a(Class<ResourceType> resourceClass) {
        return new C6029k<>(this.f11331d, this, resourceClass, this.f11332e);
    }

    /* renamed from: a */
    public void mo19319a(View view) {
        mo19320a((C5976i<?>) new C6355a<Object>(view));
    }

    /* renamed from: a */
    public void mo19320a(C5976i<?> target) {
        if (target != null) {
            if (C6026k.m11288d()) {
                m12259c(target);
            } else {
                this.f11338k.post(new C6353m(this, target));
            }
        }
    }

    /* renamed from: c */
    private void m12259c(C5976i<?> target) {
        if (!mo19325b(target) && !this.f11331d.mo18578a(target) && target.getRequest() != null) {
            C5986c request = target.getRequest();
            target.setRequest(null);
            request.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo19325b(C5976i<?> target) {
        C5986c request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f11334g.mo18622a(request)) {
            return false;
        }
        this.f11336i.mo18637b(target);
        target.setRequest(null);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19321a(C5976i<?> target, C5986c request) {
        this.f11336i.mo18635a(target);
        this.f11334g.mo18624b(request);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C5991g mo19326c() {
        return this.f11340m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <T> C6357o<?, T> mo19324b(Class<T> transcodeClass) {
        return this.f11331d.mo18584f().mo18649a(transcodeClass);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{tracker=");
        sb.append(this.f11334g);
        sb.append(", treeNode=");
        sb.append(this.f11335h);
        sb.append("}");
        return sb.toString();
    }
}
