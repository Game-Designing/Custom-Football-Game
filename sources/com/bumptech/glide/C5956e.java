package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.C6328s;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.p103f.C5991g;
import com.bumptech.glide.p103f.p104a.C5972e;
import com.bumptech.glide.p103f.p104a.C5977j;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.e */
/* compiled from: GlideContext */
public class C5956e extends ContextWrapper {

    /* renamed from: a */
    static final C6357o<?, ?> f10495a = new C5919b();

    /* renamed from: b */
    private final Handler f10496b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private final C6245b f10497c;

    /* renamed from: d */
    private final Registry f10498d;

    /* renamed from: e */
    private final C5972e f10499e;

    /* renamed from: f */
    private final C5991g f10500f;

    /* renamed from: g */
    private final Map<Class<?>, C6357o<?, ?>> f10501g;

    /* renamed from: h */
    private final C6328s f10502h;

    /* renamed from: i */
    private final int f10503i;

    public C5956e(Context context, C6245b arrayPool, Registry registry, C5972e imageViewTargetFactory, C5991g defaultRequestOptions, Map<Class<?>, C6357o<?, ?>> defaultTransitionOptions, C6328s engine, int logLevel) {
        super(context.getApplicationContext());
        this.f10497c = arrayPool;
        this.f10498d = registry;
        this.f10499e = imageViewTargetFactory;
        this.f10500f = defaultRequestOptions;
        this.f10501g = defaultTransitionOptions;
        this.f10502h = engine;
        this.f10503i = logLevel;
    }

    /* renamed from: b */
    public C5991g mo18650b() {
        return this.f10500f;
    }

    /* renamed from: a */
    public <T> C6357o<?, T> mo18649a(Class<T> transcodeClass) {
        TransitionOptions<?, ?> result = (C6357o) this.f10501g.get(transcodeClass);
        if (result == null) {
            for (Entry<Class<?>, TransitionOptions<?, ?>> value : this.f10501g.entrySet()) {
                if (((Class) value.getKey()).isAssignableFrom(transcodeClass)) {
                    result = (C6357o) value.getValue();
                }
            }
        }
        if (result == null) {
            return f10495a;
        }
        return result;
    }

    /* renamed from: a */
    public <X> C5977j<ImageView, X> mo18647a(ImageView imageView, Class<X> transcodeClass) {
        return this.f10499e.mo18699a(imageView, transcodeClass);
    }

    /* renamed from: e */
    public Handler mo18653e() {
        return this.f10496b;
    }

    /* renamed from: c */
    public C6328s mo18651c() {
        return this.f10502h;
    }

    /* renamed from: f */
    public Registry mo18654f() {
        return this.f10498d;
    }

    /* renamed from: d */
    public int mo18652d() {
        return this.f10503i;
    }

    /* renamed from: a */
    public C6245b mo18648a() {
        return this.f10497c;
    }
}
