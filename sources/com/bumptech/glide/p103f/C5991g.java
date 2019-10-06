package com.bumptech.glide.p103f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6345h;
import com.bumptech.glide.load.C6347j;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6326q;
import com.bumptech.glide.load.p113c.p114a.C6153g;
import com.bumptech.glide.load.p113c.p114a.C6154h;
import com.bumptech.glide.load.p113c.p114a.C6160j;
import com.bumptech.glide.load.p113c.p114a.C6169l;
import com.bumptech.glide.load.p113c.p114a.C6173o;
import com.bumptech.glide.load.p113c.p114a.C6174p;
import com.bumptech.glide.load.p113c.p118e.C6208c;
import com.bumptech.glide.load.p113c.p118e.C6212f;
import com.bumptech.glide.load.p113c.p118e.C6219i;
import com.bumptech.glide.p106g.C5999b;
import com.bumptech.glide.p107h.C6017b;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.file.CacheHelper;

/* renamed from: com.bumptech.glide.f.g */
/* compiled from: RequestOptions */
public class C5991g implements Cloneable {

    /* renamed from: a */
    private int f10563a;

    /* renamed from: b */
    private float f10564b = 1.0f;

    /* renamed from: c */
    private C6326q f10565c = C6326q.f11252e;

    /* renamed from: d */
    private C6001h f10566d = C6001h.NORMAL;

    /* renamed from: e */
    private Drawable f10567e;

    /* renamed from: f */
    private int f10568f;

    /* renamed from: g */
    private Drawable f10569g;

    /* renamed from: h */
    private int f10570h;

    /* renamed from: i */
    private boolean f10571i = true;

    /* renamed from: j */
    private int f10572j = -1;

    /* renamed from: k */
    private int f10573k = -1;

    /* renamed from: l */
    private C6344g f10574l = C5999b.m11211a();

    /* renamed from: m */
    private boolean f10575m;

    /* renamed from: n */
    private boolean f10576n = true;

    /* renamed from: o */
    private Drawable f10577o;

    /* renamed from: p */
    private int f10578p;

    /* renamed from: q */
    private C6349k f10579q = new C6349k();

    /* renamed from: r */
    private Map<Class<?>, C6352n<?>> f10580r = new C6017b();

    /* renamed from: s */
    private Class<?> f10581s = Object.class;

    /* renamed from: t */
    private boolean f10582t;

    /* renamed from: u */
    private Theme f10583u;

    /* renamed from: v */
    private boolean f10584v;

    /* renamed from: w */
    private boolean f10585w;

    /* renamed from: x */
    private boolean f10586x;

    /* renamed from: y */
    private boolean f10587y = true;

    /* renamed from: z */
    private boolean f10588z;

    /* renamed from: b */
    public static C5991g m11106b(C6326q diskCacheStrategy) {
        return new C5991g().mo18744a(diskCacheStrategy);
    }

    /* renamed from: b */
    public static C5991g m11107b(C6344g signature) {
        return new C5991g().mo18745a(signature);
    }

    /* renamed from: b */
    public static C5991g m11108b(Class<?> resourceClass) {
        return new C5991g().mo18748a(resourceClass);
    }

    /* renamed from: b */
    public static C5991g m11105b(C6060b format) {
        return new C5991g().mo18741a(format);
    }

    /* renamed from: b */
    private static boolean m11110b(int fields, int flag) {
        return (fields & flag) != 0;
    }

    /* renamed from: a */
    public C5991g mo18736a(float sizeMultiplier) {
        if (this.f10584v) {
            return clone().mo18736a(sizeMultiplier);
        }
        if (sizeMultiplier < 0.0f || sizeMultiplier > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f10564b = sizeMultiplier;
        this.f10563a |= 2;
        m11101N();
        return this;
    }

    /* renamed from: b */
    public C5991g mo18753b(boolean flag) {
        if (this.f10584v) {
            return clone().mo18753b(flag);
        }
        this.f10588z = flag;
        this.f10563a |= CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES;
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18744a(C6326q strategy) {
        if (this.f10584v) {
            return clone().mo18744a(strategy);
        }
        C6024i.m11264a(strategy);
        this.f10565c = strategy;
        this.f10563a |= 4;
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18740a(C6001h priority) {
        if (this.f10584v) {
            return clone().mo18740a(priority);
        }
        C6024i.m11264a(priority);
        this.f10566d = priority;
        this.f10563a |= 8;
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18737a(int resourceId) {
        if (this.f10584v) {
            return clone().mo18737a(resourceId);
        }
        this.f10570h = resourceId;
        this.f10563a |= 128;
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18749a(boolean skip) {
        if (this.f10584v) {
            return clone().mo18749a(true);
        }
        this.f10571i = !skip;
        this.f10563a |= Opcodes.ACC_NATIVE;
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18738a(int width, int height) {
        if (this.f10584v) {
            return clone().mo18738a(width, height);
        }
        this.f10573k = width;
        this.f10572j = height;
        this.f10563a |= 512;
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18745a(C6344g signature) {
        if (this.f10584v) {
            return clone().mo18745a(signature);
        }
        C6024i.m11264a(signature);
        this.f10574l = signature;
        this.f10563a |= Opcodes.ACC_ABSTRACT;
        m11101N();
        return this;
    }

    public C5991g clone() {
        try {
            C5991g result = (C5991g) super.clone();
            result.f10579q = new C6349k();
            result.f10579q.mo19311a(this.f10579q);
            result.f10580r = new C6017b();
            result.f10580r.putAll(this.f10580r);
            result.f10582t = false;
            result.f10584v = false;
            return result;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public <T> C5991g mo18746a(C6347j<T> option, T value) {
        if (this.f10584v) {
            return clone().mo18746a(option, value);
        }
        C6024i.m11264a(option);
        C6024i.m11264a(value);
        this.f10579q.mo19309a(option, value);
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18748a(Class<?> resourceClass) {
        if (this.f10584v) {
            return clone().mo18748a(resourceClass);
        }
        C6024i.m11264a(resourceClass);
        this.f10581s = resourceClass;
        this.f10563a |= Opcodes.ACC_SYNTHETIC;
        m11101N();
        return this;
    }

    /* renamed from: F */
    public final boolean mo18727F() {
        return this.f10576n;
    }

    /* renamed from: H */
    public final boolean mo18729H() {
        return m11109b((int) Opcodes.ACC_STRICT);
    }

    /* renamed from: a */
    public C5991g mo18741a(C6060b format) {
        C6024i.m11264a(format);
        return mo18746a(C6169l.f10877a, (T) format).mo18746a(C6219i.f10976a, (T) format);
    }

    /* renamed from: c */
    public C5991g mo18754c() {
        return mo18746a(C6169l.f10880d, (T) Boolean.valueOf(false));
    }

    /* renamed from: a */
    public C5991g mo18742a(C6160j strategy) {
        C6347j<C6160j> jVar = C6160j.f10873h;
        C6024i.m11264a(strategy);
        return mo18746a(jVar, (T) strategy);
    }

    /* renamed from: K */
    public C5991g mo18732K() {
        return mo18743a(C6160j.f10867b, (C6352n<Bitmap>) new C6153g<Bitmap>());
    }

    /* renamed from: b */
    public C5991g mo18751b() {
        return mo18752b(C6160j.f10867b, (C6352n<Bitmap>) new C6153g<Bitmap>());
    }

    /* renamed from: M */
    public C5991g mo18734M() {
        return m11111c(C6160j.f10866a, new C6174p());
    }

    /* renamed from: L */
    public C5991g mo18733L() {
        return m11111c(C6160j.f10870e, new C6154h());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C5991g mo18743a(C6160j downsampleStrategy, C6352n<Bitmap> transformation) {
        if (this.f10584v) {
            return clone().mo18743a(downsampleStrategy, transformation);
        }
        mo18742a(downsampleStrategy);
        return m11103a(transformation, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C5991g mo18752b(C6160j downsampleStrategy, C6352n<Bitmap> transformation) {
        if (this.f10584v) {
            return clone().mo18752b(downsampleStrategy, transformation);
        }
        mo18742a(downsampleStrategy);
        return mo18747a(transformation);
    }

    /* renamed from: c */
    private C5991g m11111c(C6160j strategy, C6352n<Bitmap> transformation) {
        return m11102a(strategy, transformation, false);
    }

    /* renamed from: a */
    private C5991g m11102a(C6160j strategy, C6352n<Bitmap> transformation, boolean isTransformationRequired) {
        C5991g result = isTransformationRequired ? mo18752b(strategy, transformation) : mo18743a(strategy, transformation);
        result.f10587y = true;
        return result;
    }

    /* renamed from: a */
    public C5991g mo18747a(C6352n<Bitmap> transformation) {
        return m11103a(transformation, true);
    }

    /* renamed from: a */
    public C5991g mo18750a(C6352n<Bitmap>... transformations) {
        return m11103a((C6352n<Bitmap>) new C6345h<Bitmap>(transformations), true);
    }

    /* renamed from: a */
    private C5991g m11103a(C6352n<Bitmap> transformation, boolean isRequired) {
        if (this.f10584v) {
            return clone().m11103a(transformation, isRequired);
        }
        C6173o drawableTransformation = new C6173o(transformation, isRequired);
        m11104a(Bitmap.class, transformation, isRequired);
        m11104a(Drawable.class, (C6352n<T>) drawableTransformation, isRequired);
        drawableTransformation.mo19001a();
        m11104a(BitmapDrawable.class, (C6352n<T>) drawableTransformation, isRequired);
        m11104a(C6208c.class, (C6352n<T>) new C6212f<T>(transformation), isRequired);
        m11101N();
        return this;
    }

    /* renamed from: a */
    private <T> C5991g m11104a(Class<T> resourceClass, C6352n<T> transformation, boolean isRequired) {
        if (this.f10584v) {
            return clone().m11104a(resourceClass, transformation, isRequired);
        }
        C6024i.m11264a(resourceClass);
        C6024i.m11264a(transformation);
        this.f10580r.put(resourceClass, transformation);
        this.f10563a |= Opcodes.ACC_STRICT;
        this.f10576n = true;
        this.f10563a |= 65536;
        this.f10587y = false;
        if (isRequired) {
            this.f10563a |= Opcodes.ACC_DEPRECATED;
            this.f10575m = true;
        }
        m11101N();
        return this;
    }

    /* renamed from: a */
    public C5991g mo18739a(C5991g other) {
        if (this.f10584v) {
            return clone().mo18739a(other);
        }
        if (m11110b(other.f10563a, 2)) {
            this.f10564b = other.f10564b;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ASM4)) {
            this.f10585w = other.f10585w;
        }
        if (m11110b(other.f10563a, (int) CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES)) {
            this.f10588z = other.f10588z;
        }
        if (m11110b(other.f10563a, 4)) {
            this.f10565c = other.f10565c;
        }
        if (m11110b(other.f10563a, 8)) {
            this.f10566d = other.f10566d;
        }
        if (m11110b(other.f10563a, 16)) {
            this.f10567e = other.f10567e;
        }
        if (m11110b(other.f10563a, 32)) {
            this.f10568f = other.f10568f;
        }
        if (m11110b(other.f10563a, 64)) {
            this.f10569g = other.f10569g;
        }
        if (m11110b(other.f10563a, 128)) {
            this.f10570h = other.f10570h;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_NATIVE)) {
            this.f10571i = other.f10571i;
        }
        if (m11110b(other.f10563a, 512)) {
            this.f10573k = other.f10573k;
            this.f10572j = other.f10572j;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_ABSTRACT)) {
            this.f10574l = other.f10574l;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_SYNTHETIC)) {
            this.f10581s = other.f10581s;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_ANNOTATION)) {
            this.f10577o = other.f10577o;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_ENUM)) {
            this.f10578p = other.f10578p;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_MANDATED)) {
            this.f10583u = other.f10583u;
        }
        if (m11110b(other.f10563a, 65536)) {
            this.f10576n = other.f10576n;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_DEPRECATED)) {
            this.f10575m = other.f10575m;
        }
        if (m11110b(other.f10563a, (int) Opcodes.ACC_STRICT)) {
            this.f10580r.putAll(other.f10580r);
            this.f10587y = other.f10587y;
        }
        if (m11110b(other.f10563a, 524288)) {
            this.f10586x = other.f10586x;
        }
        if (!this.f10576n) {
            this.f10580r.clear();
            this.f10563a &= -2049;
            this.f10575m = false;
            this.f10563a &= -131073;
            this.f10587y = true;
        }
        this.f10563a |= other.f10563a;
        this.f10579q.mo19311a(other.f10579q);
        m11101N();
        return this;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C5991g)) {
            return false;
        }
        C5991g other = (C5991g) o;
        if (Float.compare(other.f10564b, this.f10564b) == 0 && this.f10568f == other.f10568f && C6026k.m11286b((Object) this.f10567e, (Object) other.f10567e) && this.f10570h == other.f10570h && C6026k.m11286b((Object) this.f10569g, (Object) other.f10569g) && this.f10578p == other.f10578p && C6026k.m11286b((Object) this.f10577o, (Object) other.f10577o) && this.f10571i == other.f10571i && this.f10572j == other.f10572j && this.f10573k == other.f10573k && this.f10575m == other.f10575m && this.f10576n == other.f10576n && this.f10585w == other.f10585w && this.f10586x == other.f10586x && this.f10565c.equals(other.f10565c) && this.f10566d == other.f10566d && this.f10579q.equals(other.f10579q) && this.f10580r.equals(other.f10580r) && this.f10581s.equals(other.f10581s) && C6026k.m11286b((Object) this.f10574l, (Object) other.f10574l) && C6026k.m11286b((Object) this.f10583u, (Object) other.f10583u)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return C6026k.m11275a((Object) this.f10583u, C6026k.m11275a((Object) this.f10574l, C6026k.m11275a((Object) this.f10581s, C6026k.m11275a((Object) this.f10580r, C6026k.m11275a((Object) this.f10579q, C6026k.m11275a((Object) this.f10566d, C6026k.m11275a((Object) this.f10565c, C6026k.m11276a(this.f10586x, C6026k.m11276a(this.f10585w, C6026k.m11276a(this.f10576n, C6026k.m11276a(this.f10575m, C6026k.m11271a(this.f10573k, C6026k.m11271a(this.f10572j, C6026k.m11276a(this.f10571i, C6026k.m11275a((Object) this.f10577o, C6026k.m11271a(this.f10578p, C6026k.m11275a((Object) this.f10569g, C6026k.m11271a(this.f10570h, C6026k.m11275a((Object) this.f10567e, C6026k.m11271a(this.f10568f, C6026k.m11269a(this.f10564b)))))))))))))))))))));
    }

    /* renamed from: J */
    public C5991g mo18731J() {
        this.f10582t = true;
        return this;
    }

    /* renamed from: a */
    public C5991g mo18735a() {
        if (!this.f10582t || this.f10584v) {
            this.f10584v = true;
            mo18731J();
            return this;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    /* renamed from: N */
    private C5991g m11101N() {
        if (!this.f10582t) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    /* renamed from: z */
    public final Map<Class<?>, C6352n<?>> mo18774z() {
        return this.f10580r;
    }

    /* renamed from: G */
    public final boolean mo18728G() {
        return this.f10575m;
    }

    /* renamed from: o */
    public final C6349k mo18764o() {
        return this.f10579q;
    }

    /* renamed from: u */
    public final Class<?> mo18770u() {
        return this.f10581s;
    }

    /* renamed from: d */
    public final C6326q mo18756d() {
        return this.f10565c;
    }

    /* renamed from: k */
    public final Drawable mo18760k() {
        return this.f10567e;
    }

    /* renamed from: h */
    public final int mo18758h() {
        return this.f10568f;
    }

    /* renamed from: s */
    public final int mo18768s() {
        return this.f10570h;
    }

    /* renamed from: r */
    public final Drawable mo18767r() {
        return this.f10569g;
    }

    /* renamed from: m */
    public final int mo18762m() {
        return this.f10578p;
    }

    /* renamed from: l */
    public final Drawable mo18761l() {
        return this.f10577o;
    }

    /* renamed from: y */
    public final Theme mo18773y() {
        return this.f10583u;
    }

    /* renamed from: C */
    public final boolean mo18724C() {
        return this.f10571i;
    }

    /* renamed from: w */
    public final C6344g mo18771w() {
        return this.f10574l;
    }

    /* renamed from: D */
    public final boolean mo18725D() {
        return m11109b(8);
    }

    /* renamed from: t */
    public final C6001h mo18769t() {
        return this.f10566d;
    }

    /* renamed from: q */
    public final int mo18766q() {
        return this.f10573k;
    }

    /* renamed from: I */
    public final boolean mo18730I() {
        return C6026k.m11285b(this.f10573k, this.f10572j);
    }

    /* renamed from: p */
    public final int mo18765p() {
        return this.f10572j;
    }

    /* renamed from: x */
    public final float mo18772x() {
        return this.f10564b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public boolean mo18726E() {
        return this.f10587y;
    }

    /* renamed from: b */
    private boolean m11109b(int flag) {
        return m11110b(this.f10563a, flag);
    }

    /* renamed from: B */
    public final boolean mo18723B() {
        return this.f10585w;
    }

    /* renamed from: A */
    public final boolean mo18722A() {
        return this.f10588z;
    }

    /* renamed from: n */
    public final boolean mo18763n() {
        return this.f10586x;
    }
}
