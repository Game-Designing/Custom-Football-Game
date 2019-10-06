package com.bumptech.glide.load.engine;

import com.bumptech.glide.C5956e;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.Registry.NoSourceEncoderAvailableException;
import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p121b.C6269a;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.load.p113c.C6193b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.engine.h */
/* compiled from: DecodeHelper */
final class C6309h<Transcode> {

    /* renamed from: a */
    private final List<C6129a<?>> f11172a = new ArrayList();

    /* renamed from: b */
    private final List<C6344g> f11173b = new ArrayList();

    /* renamed from: c */
    private C5956e f11174c;

    /* renamed from: d */
    private Object f11175d;

    /* renamed from: e */
    private int f11176e;

    /* renamed from: f */
    private int f11177f;

    /* renamed from: g */
    private Class<?> f11178g;

    /* renamed from: h */
    private C6315d f11179h;

    /* renamed from: i */
    private C6349k f11180i;

    /* renamed from: j */
    private Map<Class<?>, C6352n<?>> f11181j;

    /* renamed from: k */
    private Class<Transcode> f11182k;

    /* renamed from: l */
    private boolean f11183l;

    /* renamed from: m */
    private boolean f11184m;

    /* renamed from: n */
    private C6344g f11185n;

    /* renamed from: o */
    private C6001h f11186o;

    /* renamed from: p */
    private C6326q f11187p;

    /* renamed from: q */
    private boolean f11188q;

    /* renamed from: r */
    private boolean f11189r;

    C6309h() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <R> void mo19232a(C5956e glideContext, Object model, C6344g signature, int width, int height, C6326q diskCacheStrategy, Class<?> resourceClass, Class<R> transcodeClass, C6001h priority, C6349k options, Map<Class<?>, C6352n<?>> transformations, boolean isTransformationRequired, boolean isScaleOnlyOrNoTransform, C6315d diskCacheProvider) {
        this.f11174c = glideContext;
        this.f11175d = model;
        this.f11185n = signature;
        this.f11176e = width;
        this.f11177f = height;
        this.f11187p = diskCacheStrategy;
        this.f11178g = resourceClass;
        this.f11179h = diskCacheProvider;
        this.f11182k = transcodeClass;
        this.f11186o = priority;
        this.f11180i = options;
        this.f11181j = transformations;
        this.f11188q = isTransformationRequired;
        this.f11189r = isScaleOnlyOrNoTransform;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19231a() {
        this.f11174c = null;
        this.f11175d = null;
        this.f11185n = null;
        this.f11178g = null;
        this.f11182k = null;
        this.f11180i = null;
        this.f11186o = null;
        this.f11181j = null;
        this.f11187p = null;
        this.f11172a.clear();
        this.f11183l = false;
        this.f11173b.clear();
        this.f11184m = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C6269a mo19239d() {
        return this.f11179h.mo19266a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C6326q mo19240e() {
        return this.f11187p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C6001h mo19244i() {
        return this.f11186o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C6349k mo19243h() {
        return this.f11180i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public C6344g mo19246k() {
        return this.f11185n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public int mo19248m() {
        return this.f11176e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo19241f() {
        return this.f11177f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C6245b mo19234b() {
        return this.f11174c.mo18648a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public Class<?> mo19247l() {
        return this.f11182k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public List<Class<?>> mo19245j() {
        return this.f11174c.mo18654f().mo18526b(this.f11175d.getClass(), this.f11178g, this.f11182k);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo19238c(Class<?> dataClass) {
        return mo19228a(dataClass) != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <Data> C6233B<Data, ?, Transcode> mo19228a(Class<Data> dataClass) {
        return this.f11174c.mo18654f().mo18521a(dataClass, this.f11178g, this.f11182k);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo19249n() {
        return this.f11189r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <Z> C6352n<Z> mo19235b(Class<Z> resourceClass) {
        Transformation<Z> result = (C6352n) this.f11181j.get(resourceClass);
        if (result == null) {
            Iterator it = this.f11181j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry<Class<?>, Transformation<?>> entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(resourceClass)) {
                    result = (C6352n) entry.getValue();
                    break;
                }
            }
        }
        if (result != null) {
            return result;
        }
        if (!this.f11181j.isEmpty() || !this.f11188q) {
            return C6193b.m11761a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing transformation for ");
        sb.append(resourceClass);
        sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo19236b(C6236E<?> resource) {
        return this.f11174c.mo18654f().mo18527b(resource);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <Z> C6351m<Z> mo19229a(C6236E<Z> resource) {
        return this.f11174c.mo18654f().mo18522a(resource);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C6128u<File, ?>> mo19230a(File file) throws NoModelLoaderAvailableException {
        return this.f11174c.mo18654f().mo18524a(file);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19233a(C6344g key) {
        List<LoadData<?>> loadData = mo19242g();
        int size = loadData.size();
        for (int i = 0; i < size; i++) {
            if (((C6129a) loadData.get(i)).f10814a.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public List<C6129a<?>> mo19242g() {
        if (!this.f11183l) {
            this.f11183l = true;
            this.f11172a.clear();
            List<ModelLoader<Object, ?>> modelLoaders = this.f11174c.mo18654f().mo18524a(this.f11175d);
            int size = modelLoaders.size();
            for (int i = 0; i < size; i++) {
                LoadData<?> current = ((C6128u) modelLoaders.get(i)).mo18889a(this.f11175d, this.f11176e, this.f11177f, this.f11180i);
                if (current != null) {
                    this.f11172a.add(current);
                }
            }
        }
        return this.f11172a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<C6344g> mo19237c() {
        if (!this.f11184m) {
            this.f11184m = true;
            this.f11173b.clear();
            List<LoadData<?>> loadData = mo19242g();
            int size = loadData.size();
            for (int i = 0; i < size; i++) {
                LoadData<?> data = (C6129a) loadData.get(i);
                if (!this.f11173b.contains(data.f10814a)) {
                    this.f11173b.add(data.f10814a);
                }
                for (int j = 0; j < data.f10815b.size(); j++) {
                    if (!this.f11173b.contains(data.f10815b.get(j))) {
                        this.f11173b.add(data.f10815b.get(j));
                    }
                }
            }
        }
        return this.f11173b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <X> C6229d<X> mo19227a(X data) throws NoSourceEncoderAvailableException {
        return this.f11174c.mo18654f().mo18528c(data);
    }
}
