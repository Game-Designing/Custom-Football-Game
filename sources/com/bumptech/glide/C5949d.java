package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.C6328s;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.engine.p120a.C6251f;
import com.bumptech.glide.load.engine.p120a.C6256j;
import com.bumptech.glide.load.engine.p120a.C6259k;
import com.bumptech.glide.load.engine.p121b.C6269a.C6270a;
import com.bumptech.glide.load.engine.p121b.C6280g;
import com.bumptech.glide.load.engine.p121b.C6281h;
import com.bumptech.glide.load.engine.p121b.C6282i;
import com.bumptech.glide.load.engine.p121b.C6284j;
import com.bumptech.glide.load.engine.p121b.C6284j.C6285a;
import com.bumptech.glide.load.engine.p122c.C6295b;
import com.bumptech.glide.p100c.C5931d;
import com.bumptech.glide.p100c.C5934g;
import com.bumptech.glide.p100c.C5942n;
import com.bumptech.glide.p100c.C5942n.C5943a;
import com.bumptech.glide.p103f.C5991g;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.bumptech.glide.d */
/* compiled from: GlideBuilder */
public final class C5949d {

    /* renamed from: a */
    private final Map<Class<?>, C6357o<?, ?>> f10479a = new C1253b();

    /* renamed from: b */
    private C6328s f10480b;

    /* renamed from: c */
    private C6250e f10481c;

    /* renamed from: d */
    private C6245b f10482d;

    /* renamed from: e */
    private C6282i f10483e;

    /* renamed from: f */
    private C6295b f10484f;

    /* renamed from: g */
    private C6295b f10485g;

    /* renamed from: h */
    private C6270a f10486h;

    /* renamed from: i */
    private C6284j f10487i;

    /* renamed from: j */
    private C5931d f10488j;

    /* renamed from: k */
    private int f10489k = 4;

    /* renamed from: l */
    private C5991g f10490l = new C5991g();

    /* renamed from: m */
    private C5943a f10491m;

    /* renamed from: n */
    private C6295b f10492n;

    /* renamed from: o */
    private boolean f10493o;

    /* renamed from: a */
    public C5949d mo18640a(C6250e bitmapPool) {
        this.f10481c = bitmapPool;
        return this;
    }

    /* renamed from: a */
    public C5949d mo18641a(C6282i memoryCache) {
        this.f10483e = memoryCache;
        return this;
    }

    /* renamed from: a */
    public C5949d mo18639a(C5991g requestOptions) {
        this.f10490l = requestOptions;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18642a(C5943a factory) {
        this.f10491m = factory;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C5926c mo18638a(Context context) {
        if (this.f10484f == null) {
            this.f10484f = C6295b.m12086d();
        }
        if (this.f10485g == null) {
            this.f10485g = C6295b.m12085c();
        }
        if (this.f10492n == null) {
            this.f10492n = C6295b.m12083b();
        }
        if (this.f10487i == null) {
            this.f10487i = new C6285a(context).mo19196a();
        }
        if (this.f10488j == null) {
            this.f10488j = new C5934g();
        }
        if (this.f10481c == null) {
            int size = this.f10487i.mo19194b();
            if (size > 0) {
                this.f10481c = new C6259k((long) size);
            } else {
                this.f10481c = new C6251f();
            }
        }
        if (this.f10482d == null) {
            this.f10482d = new C6256j(this.f10487i.mo19193a());
        }
        if (this.f10483e == null) {
            this.f10483e = new C6281h((long) this.f10487i.mo19195c());
        }
        if (this.f10486h == null) {
            this.f10486h = new C6280g(context);
        }
        if (this.f10480b == null) {
            C6328s sVar = new C6328s(this.f10483e, this.f10486h, this.f10485g, this.f10484f, C6295b.m12087e(), C6295b.m12083b(), this.f10493o);
            this.f10480b = sVar;
        }
        C5942n requestManagerRetriever = new C5942n(this.f10491m);
        C6328s sVar2 = this.f10480b;
        C6282i iVar = this.f10483e;
        C6250e eVar = this.f10481c;
        C6245b bVar = this.f10482d;
        C5931d dVar = this.f10488j;
        int i = this.f10489k;
        C5991g gVar = this.f10490l;
        gVar.mo18731J();
        C5926c cVar = new C5926c(context, sVar2, iVar, eVar, bVar, requestManagerRetriever, dVar, i, gVar, this.f10479a);
        return cVar;
    }
}
