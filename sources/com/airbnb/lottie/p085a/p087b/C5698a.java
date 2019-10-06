package com.airbnb.lottie.p085a.p087b;

import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.a */
/* compiled from: BaseKeyframeAnimation */
public abstract class C5698a<K, A> {

    /* renamed from: a */
    final List<C5699a> f9778a = new ArrayList();

    /* renamed from: b */
    private boolean f9779b = false;

    /* renamed from: c */
    private final List<? extends C5831a<K>> f9780c;

    /* renamed from: d */
    private float f9781d = 0.0f;

    /* renamed from: e */
    protected C5833c<A> f9782e;

    /* renamed from: f */
    private C5831a<K> f9783f;

    /* renamed from: com.airbnb.lottie.a.b.a$a */
    /* compiled from: BaseKeyframeAnimation */
    public interface C5699a {
        /* renamed from: a */
        void mo17932a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract A mo17949a(C5831a<K> aVar, float f);

    C5698a(List<? extends C5831a<K>> keyframes) {
        this.f9780c = keyframes;
    }

    /* renamed from: f */
    public void mo17957f() {
        this.f9779b = true;
    }

    /* renamed from: a */
    public void mo17951a(C5699a listener) {
        this.f9778a.add(listener);
    }

    /* renamed from: a */
    public void mo17950a(float progress) {
        if (progress < m10114i()) {
            progress = m10114i();
        } else if (progress > mo17948a()) {
            progress = mo17948a();
        }
        if (progress != this.f9781d) {
            this.f9781d = progress;
            mo17956e();
        }
    }

    /* renamed from: e */
    public void mo17956e() {
        for (int i = 0; i < this.f9778a.size(); i++) {
            ((C5699a) this.f9778a.get(i)).mo17932a();
        }
    }

    /* renamed from: g */
    private C5831a<K> m10112g() {
        C5831a<K> aVar = this.f9783f;
        if (aVar != null && aVar.mo18204a(this.f9781d)) {
            return this.f9783f;
        }
        List<? extends C5831a<K>> list = this.f9780c;
        Keyframe<K> keyframe = (C5831a) list.get(list.size() - 1);
        if (this.f9781d < keyframe.mo18205b()) {
            for (int i = this.f9780c.size() - 1; i >= 0; i--) {
                keyframe = (C5831a) this.f9780c.get(i);
                if (keyframe.mo18204a(this.f9781d)) {
                    break;
                }
            }
        }
        this.f9783f = keyframe;
        return keyframe;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo17953b() {
        if (this.f9779b) {
            return 0.0f;
        }
        Keyframe<K> keyframe = m10112g();
        if (keyframe.mo18206c()) {
            return 0.0f;
        }
        return (this.f9781d - keyframe.mo18205b()) / (keyframe.mo18203a() - keyframe.mo18205b());
    }

    /* renamed from: h */
    private float m10113h() {
        Keyframe<K> keyframe = m10112g();
        if (keyframe.mo18206c()) {
            return 0.0f;
        }
        return keyframe.f10126d.getInterpolation(mo17953b());
    }

    /* renamed from: i */
    private float m10114i() {
        if (this.f9780c.isEmpty()) {
            return 0.0f;
        }
        return ((C5831a) this.f9780c.get(0)).mo18205b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo17948a() {
        if (this.f9780c.isEmpty()) {
            return 1.0f;
        }
        List<? extends C5831a<K>> list = this.f9780c;
        return ((C5831a) list.get(list.size() - 1)).mo18203a();
    }

    /* renamed from: d */
    public A mo17955d() {
        return mo17949a(m10112g(), m10113h());
    }

    /* renamed from: c */
    public float mo17954c() {
        return this.f9781d;
    }

    /* renamed from: a */
    public void mo17952a(C5833c<A> valueCallback) {
        C5833c<A> cVar = this.f9782e;
        if (cVar != null) {
            cVar.mo18211a(null);
        }
        this.f9782e = valueCallback;
        if (valueCallback != null) {
            valueCallback.mo18211a(this);
        }
    }
}
