package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.support.p001v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.C6326q;
import com.bumptech.glide.p103f.C5980b;
import com.bumptech.glide.p103f.C5986c;
import com.bumptech.glide.p103f.C5987d;
import com.bumptech.glide.p103f.C5988e;
import com.bumptech.glide.p103f.C5990f;
import com.bumptech.glide.p103f.C5991g;
import com.bumptech.glide.p103f.C5994j;
import com.bumptech.glide.p103f.C5996k;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p103f.p104a.C5977j;
import com.bumptech.glide.p106g.C5998a;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.request.RequestFutureTarget;

/* renamed from: com.bumptech.glide.k */
/* compiled from: RequestBuilder */
public class C6029k<TranscodeType> implements Cloneable, C5997g<C6029k<TranscodeType>> {

    /* renamed from: a */
    protected static final C5991g f10671a = new C5991g().mo18744a(C6326q.f11250c).mo18740a(C6001h.LOW).mo18749a(true);

    /* renamed from: b */
    private final Context f10672b;

    /* renamed from: c */
    private final C6354n f10673c;

    /* renamed from: d */
    private final Class<TranscodeType> f10674d;

    /* renamed from: e */
    private final C5991g f10675e;

    /* renamed from: f */
    private final C5926c f10676f;

    /* renamed from: g */
    private final C5956e f10677g;

    /* renamed from: h */
    protected C5991g f10678h;

    /* renamed from: i */
    private C6357o<?, ? super TranscodeType> f10679i;

    /* renamed from: j */
    private Object f10680j;

    /* renamed from: k */
    private C5990f<TranscodeType> f10681k;

    /* renamed from: l */
    private C6029k<TranscodeType> f10682l;

    /* renamed from: m */
    private C6029k<TranscodeType> f10683m;

    /* renamed from: n */
    private Float f10684n;

    /* renamed from: o */
    private boolean f10685o = true;

    /* renamed from: p */
    private boolean f10686p;

    /* renamed from: q */
    private boolean f10687q;

    protected C6029k(C5926c glide, C6354n requestManager, Class<TranscodeType> transcodeClass, Context context) {
        this.f10676f = glide;
        this.f10673c = requestManager;
        this.f10674d = transcodeClass;
        this.f10675e = requestManager.mo19326c();
        this.f10672b = context;
        this.f10679i = requestManager.mo19324b(transcodeClass);
        this.f10678h = this.f10675e;
        this.f10677g = glide.mo18584f();
    }

    /* renamed from: a */
    public C6029k<TranscodeType> mo18838a(C5991g requestOptions) {
        C6024i.m11264a(requestOptions);
        this.f10678h = mo18836a().mo18739a(requestOptions);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5991g mo18836a() {
        C5991g gVar = this.f10675e;
        C5991g gVar2 = this.f10678h;
        if (gVar == gVar2) {
            return gVar2.clone();
        }
        return gVar2;
    }

    /* renamed from: a */
    public C6029k<TranscodeType> mo18840a(Object model) {
        m11296b(model);
        return this;
    }

    /* renamed from: b */
    private C6029k<TranscodeType> m11296b(Object model) {
        this.f10680j = model;
        this.f10686p = true;
        return this;
    }

    /* renamed from: a */
    public C6029k<TranscodeType> mo18841a(String string) {
        m11296b(string);
        return this;
    }

    /* renamed from: a */
    public C6029k<TranscodeType> mo18837a(Uri uri) {
        m11296b(uri);
        return this;
    }

    /* renamed from: a */
    public C6029k<TranscodeType> mo18839a(Integer resourceId) {
        m11296b(resourceId);
        mo18838a(C5991g.m11107b(C5998a.m11207a(this.f10672b)));
        return this;
    }

    public C6029k<TranscodeType> clone() {
        try {
            RequestBuilder<TranscodeType> result = (C6029k) super.clone();
            result.f10678h = result.f10678h.clone();
            result.f10679i = result.f10679i.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public <Y extends C5976i<TranscodeType>> Y mo18832a(Y target) {
        mo18833a(target, null);
        return target;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <Y extends C5976i<TranscodeType>> Y mo18833a(Y target, C5990f<TranscodeType> targetListener) {
        m11294b(target, targetListener, mo18836a());
        return target;
    }

    /* renamed from: b */
    private <Y extends C5976i<TranscodeType>> Y m11294b(Y target, C5990f<TranscodeType> targetListener, C5991g options) {
        C6026k.m11283b();
        C6024i.m11264a(target);
        if (this.f10686p) {
            C5991g options2 = options.mo18735a();
            C5986c request = m11290a(target, targetListener, options2);
            C5986c previous = target.getRequest();
            if (!request.mo18675a(previous) || m11293a(options2, previous)) {
                this.f10673c.mo19320a((C5976i<?>) target);
                target.setRequest(request);
                this.f10673c.mo19321a(target, request);
                return target;
            }
            request.mo18676b();
            C6024i.m11264a(previous);
            if (!previous.isRunning()) {
                previous.mo18673a();
            }
            return target;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* renamed from: a */
    private boolean m11293a(C5991g options, C5986c previous) {
        return !options.mo18724C() && previous.isComplete();
    }

    /* renamed from: a */
    public C5977j<ImageView, TranscodeType> mo18834a(ImageView view) {
        C6026k.m11283b();
        C6024i.m11264a(view);
        C5991g requestOptions = this.f10678h;
        if (!requestOptions.mo18729H() && requestOptions.mo18727F() && view.getScaleType() != null) {
            switch (C6028j.f10669a[view.getScaleType().ordinal()]) {
                case 1:
                    requestOptions = requestOptions.clone().mo18732K();
                    break;
                case 2:
                    requestOptions = requestOptions.clone().mo18733L();
                    break;
                case 3:
                case 4:
                case 5:
                    requestOptions = requestOptions.clone().mo18734M();
                    break;
                case 6:
                    requestOptions = requestOptions.clone().mo18733L();
                    break;
            }
        }
        C5977j<ImageView, TranscodeType> a = this.f10677g.mo18647a(view, this.f10674d);
        m11294b(a, null, requestOptions);
        return a;
    }

    @Deprecated
    /* renamed from: a */
    public C5980b<TranscodeType> mo18835a(int width, int height) {
        return mo18843b(width, height);
    }

    /* renamed from: b */
    public C5980b<TranscodeType> mo18842b() {
        return mo18843b(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: b */
    public C5980b<TranscodeType> mo18843b(int width, int height) {
        RequestFutureTarget<TranscodeType> target = new C5988e<>(this.f10677g.mo18653e(), width, height);
        if (C6026k.m11287c()) {
            this.f10677g.mo18653e().post(new C6027i(this, target));
        } else {
            mo18833a((Y) target, (C5990f<TranscodeType>) target);
        }
        return target;
    }

    /* renamed from: a */
    private C6001h m11292a(C6001h current) {
        int i = C6028j.f10670b[current.ordinal()];
        if (i == 1) {
            return C6001h.NORMAL;
        }
        if (i == 2) {
            return C6001h.HIGH;
        }
        if (i == 3 || i == 4) {
            return C6001h.IMMEDIATE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown priority: ");
        sb.append(this.f10678h.mo18769t());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private C5986c m11290a(C5976i<TranscodeType> target, C5990f<TranscodeType> targetListener, C5991g requestOptions) {
        return m11289a(target, targetListener, (C5987d) null, this.f10679i, requestOptions.mo18769t(), requestOptions.mo18766q(), requestOptions.mo18765p(), requestOptions);
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.f.d] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r1v9, types: [com.bumptech.glide.f.a] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.p103f.C5986c m11289a(com.bumptech.glide.p103f.p104a.C5976i<TranscodeType> r16, com.bumptech.glide.p103f.C5990f<TranscodeType> r17, com.bumptech.glide.p103f.C5987d r18, com.bumptech.glide.C6357o<?, ? super TranscodeType> r19, com.bumptech.glide.C6001h r20, int r21, int r22, com.bumptech.glide.p103f.C5991g r23) {
        /*
            r15 = this;
            r9 = r15
            r0 = 0
            com.bumptech.glide.k<TranscodeType> r1 = r9.f10683m
            if (r1 == 0) goto L_0x0011
            com.bumptech.glide.f.a r1 = new com.bumptech.glide.f.a
            r2 = r18
            r1.<init>(r2)
            r0 = r1
            r11 = r0
            r10 = r1
            goto L_0x0015
        L_0x0011:
            r2 = r18
            r11 = r0
            r10 = r2
        L_0x0015:
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r10
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            com.bumptech.glide.f.c r12 = r0.m11295b(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != 0) goto L_0x002d
            return r12
        L_0x002d:
            com.bumptech.glide.k<TranscodeType> r0 = r9.f10683m
            com.bumptech.glide.f.g r0 = r0.f10678h
            int r0 = r0.mo18766q()
            com.bumptech.glide.k<TranscodeType> r1 = r9.f10683m
            com.bumptech.glide.f.g r1 = r1.f10678h
            int r1 = r1.mo18765p()
            boolean r2 = com.bumptech.glide.p107h.C6026k.m11285b(r21, r22)
            if (r2 == 0) goto L_0x0058
            com.bumptech.glide.k<TranscodeType> r2 = r9.f10683m
            com.bumptech.glide.f.g r2 = r2.f10678h
            boolean r2 = r2.mo18730I()
            if (r2 != 0) goto L_0x0058
            int r0 = r23.mo18766q()
            int r1 = r23.mo18765p()
            r13 = r0
            r14 = r1
            goto L_0x005a
        L_0x0058:
            r13 = r0
            r14 = r1
        L_0x005a:
            com.bumptech.glide.k<TranscodeType> r0 = r9.f10683m
            com.bumptech.glide.o<?, ? super TranscodeType> r4 = r0.f10679i
            com.bumptech.glide.f.g r1 = r0.f10678h
            com.bumptech.glide.h r5 = r1.mo18769t()
            com.bumptech.glide.k<TranscodeType> r1 = r9.f10683m
            com.bumptech.glide.f.g r8 = r1.f10678h
            r1 = r16
            r2 = r17
            r3 = r11
            r6 = r13
            r7 = r14
            com.bumptech.glide.f.c r0 = r0.m11289a(r1, r2, r3, r4, r5, r6, r7, r8)
            r11.mo18674a(r12, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.C6029k.m11289a(com.bumptech.glide.f.a.i, com.bumptech.glide.f.f, com.bumptech.glide.f.d, com.bumptech.glide.o, com.bumptech.glide.h, int, int, com.bumptech.glide.f.g):com.bumptech.glide.f.c");
    }

    /* renamed from: b */
    private C5986c m11295b(C5976i<TranscodeType> target, C5990f<TranscodeType> targetListener, C5987d parentCoordinator, C6357o<?, ? super TranscodeType> transitionOptions, C6001h priority, int overrideWidth, int overrideHeight, C5991g requestOptions) {
        C6357o<?, ? super TranscodeType> oVar;
        int thumbOverrideHeight;
        int thumbOverrideWidth;
        C5987d dVar = parentCoordinator;
        C6001h hVar = priority;
        C6029k<TranscodeType> kVar = this.f10682l;
        if (kVar != null) {
            if (!this.f10687q) {
                C6357o<?, ? super TranscodeType> oVar2 = kVar.f10679i;
                if (kVar.f10685o) {
                    oVar = transitionOptions;
                } else {
                    oVar = oVar2;
                }
                C6001h thumbPriority = this.f10682l.f10678h.mo18725D() ? this.f10682l.f10678h.mo18769t() : m11292a(hVar);
                int thumbOverrideWidth2 = this.f10682l.f10678h.mo18766q();
                int thumbOverrideHeight2 = this.f10682l.f10678h.mo18765p();
                if (!C6026k.m11285b(overrideWidth, overrideHeight) || this.f10682l.f10678h.mo18730I()) {
                    thumbOverrideWidth = thumbOverrideWidth2;
                    thumbOverrideHeight = thumbOverrideHeight2;
                } else {
                    thumbOverrideWidth = requestOptions.mo18766q();
                    thumbOverrideHeight = requestOptions.mo18765p();
                }
                C5996k coordinator = new C5996k(dVar);
                C5986c fullRequest = m11291a(target, targetListener, requestOptions, (C5987d) coordinator, transitionOptions, priority, overrideWidth, overrideHeight);
                this.f10687q = true;
                C6029k<TranscodeType> kVar2 = this.f10682l;
                C5996k coordinator2 = coordinator;
                C5986c thumbRequest = kVar2.m11289a(target, targetListener, (C5987d) coordinator, oVar, thumbPriority, thumbOverrideWidth, thumbOverrideHeight, kVar2.f10678h);
                this.f10687q = false;
                coordinator2.mo18780a(fullRequest, thumbRequest);
                return coordinator2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.f10684n == null) {
            return m11291a(target, targetListener, requestOptions, parentCoordinator, transitionOptions, priority, overrideWidth, overrideHeight);
        } else {
            C5996k coordinator3 = new C5996k(dVar);
            C5990f<TranscodeType> fVar = targetListener;
            C5996k kVar3 = coordinator3;
            C6357o<?, ? super TranscodeType> oVar3 = transitionOptions;
            int i = overrideWidth;
            int i2 = overrideHeight;
            coordinator3.mo18780a(m11291a(target, fVar, requestOptions, (C5987d) kVar3, oVar3, priority, i, i2), m11291a(target, fVar, requestOptions.clone().mo18736a(this.f10684n.floatValue()), (C5987d) kVar3, oVar3, m11292a(hVar), i, i2));
            return coordinator3;
        }
    }

    /* renamed from: a */
    private C5986c m11291a(C5976i<TranscodeType> target, C5990f<TranscodeType> targetListener, C5991g requestOptions, C5987d requestCoordinator, C6357o<?, ? super TranscodeType> transitionOptions, C6001h priority, int overrideWidth, int overrideHeight) {
        Context context = this.f10672b;
        C5956e eVar = this.f10677g;
        return C5994j.m11166a(context, eVar, this.f10680j, this.f10674d, requestOptions, overrideWidth, overrideHeight, priority, target, targetListener, this.f10681k, requestCoordinator, eVar.mo18651c(), transitionOptions.mo19330a());
    }
}
