package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzuo.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzuo<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsx<MessageType, BuilderType> {
    private static Map<Object, zzuo<?, ?>> zzbyh = new ConcurrentHashMap();
    protected zzxe zzbyf = zzxe.m32585c();
    private int zzbyg = -1;

    public static abstract class zza<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsy<MessageType, BuilderType> {

        /* renamed from: a */
        private final MessageType f30325a;

        /* renamed from: b */
        protected MessageType f30326b;

        /* renamed from: c */
        private boolean f30327c;

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public final void mo32902c() {
            if (this.f30327c) {
                MessageType messagetype = (zzuo) this.f30326b.mo32893a(zze.f30331d, (Object) null, (Object) null);
                m32526a(messagetype, this.f30326b);
                this.f30326b = messagetype;
                this.f30327c = false;
            }
        }

        /* renamed from: d */
        public MessageType mo32906v() {
            if (this.f30327c) {
                return this.f30326b;
            }
            MessageType messagetype = this.f30326b;
            C9902Da.m31767a().mo32534a(messagetype).mo32558d(messagetype);
            this.f30327c = true;
            return this.f30326b;
        }

        /* renamed from: e */
        public final MessageType mo32905j() {
            MessageType messagetype = (zzuo) mo32906v();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.mo32893a(zze.f30328a, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = C9902Da.m31767a().mo32534a(messagetype).mo32557c(messagetype);
                    if (booleanValue) {
                        messagetype.mo32893a(zze.f30329b, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzxc(messagetype);
        }

        /* renamed from: a */
        public final BuilderType mo32841a(MessageType messagetype) {
            mo32902c();
            m32526a(this.f30326b, messagetype);
            return this;
        }

        /* renamed from: a */
        private static void m32526a(MessageType messagetype, MessageType messagetype2) {
            C9902Da.m31767a().mo32534a(messagetype).mo32554a(messagetype, messagetype2);
        }

        /* renamed from: a */
        public final /* synthetic */ zzsy mo32840a() {
            return (zza) clone();
        }

        /* renamed from: b */
        public final /* synthetic */ zzvv mo32895b() {
            return this.f30325a;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.f30325a.mo32893a(zze.f30332e, (Object) null, (Object) null);
            zza.mo32841a((MessageType) (zzuo) mo32906v());
            return zza;
        }
    }

    public static class zzb<T extends zzuo<T, ?>> extends zzsz<T> {
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzuo<MessageType, BuilderType> implements zzvx {
        protected C9944Z<Object> zzbyl = C9944Z.m31975g();
    }

    public static class zzd<ContainingType extends zzvv, Type> extends zztz<ContainingType, Type> {
    }

    /* 'enum' access flag removed */
    public static final class zze {

        /* renamed from: a */
        public static final int f30328a = 1;

        /* renamed from: b */
        public static final int f30329b = 2;

        /* renamed from: c */
        public static final int f30330c = 3;

        /* renamed from: d */
        public static final int f30331d = 4;

        /* renamed from: e */
        public static final int f30332e = 5;

        /* renamed from: f */
        public static final int f30333f = 6;

        /* renamed from: g */
        public static final int f30334g = 7;

        /* renamed from: h */
        private static final /* synthetic */ int[] f30335h = {f30328a, f30329b, f30330c, f30331d, f30332e, f30333f, f30334g};

        /* renamed from: i */
        public static final int f30336i = 1;

        /* renamed from: j */
        public static final int f30337j = 2;

        /* renamed from: k */
        private static final /* synthetic */ int[] f30338k = {f30336i, f30337j};

        /* renamed from: l */
        public static final int f30339l = 1;

        /* renamed from: m */
        public static final int f30340m = 2;

        /* renamed from: n */
        private static final /* synthetic */ int[] f30341n = {f30339l, f30340m};
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo32893a(int i, Object obj, Object obj2);

    public String toString() {
        return C10010wa.m32208a(this, super.toString());
    }

    public int hashCode() {
        int i = this.zzbtk;
        if (i != 0) {
            return i;
        }
        this.zzbtk = C9902Da.m31767a().mo32534a(this).mo32552a(this);
        return this.zzbtk;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzuo) mo32893a(zze.f30333f, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return C9902Da.m31767a().mo32534a(this).mo32556b(this, (zzuo) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) mo32893a(zze.f30328a, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c = C9902Da.m31767a().mo32534a(this).mo32557c(this);
        if (booleanValue) {
            mo32893a(zze.f30329b, (Object) c ? this : null, (Object) null);
        }
        return c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final int mo32839f() {
        return this.zzbyg;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32837a(int i) {
        this.zzbyg = i;
    }

    /* renamed from: a */
    public final void mo32894a(zztv zztv) throws IOException {
        C9902Da.m31767a().mo32533a(getClass()).mo32553a(this, (C9986lb) C9934U.m31887a(zztv));
    }

    /* renamed from: a */
    public final int mo32892a() {
        if (this.zzbyg == -1) {
            this.zzbyg = C9902Da.m31767a().mo32534a(this).mo32555b(this);
        }
        return this.zzbyg;
    }

    /* renamed from: a */
    static <T extends zzuo<?, ?>> T m32517a(Class<T> cls) {
        T t = (zzuo) zzbyh.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzuo) zzbyh.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzuo) ((zzuo) C9946_a.m31987a(cls)).mo32893a(zze.f30333f, (Object) null, (Object) null);
            if (t != null) {
                zzbyh.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    /* renamed from: a */
    static Object m32518a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    /* renamed from: c */
    public final /* synthetic */ zzvw mo32896c() {
        zza zza2 = (zza) mo32893a(zze.f30332e, (Object) null, (Object) null);
        zza2.mo32841a(this);
        return zza2;
    }

    /* renamed from: b */
    public final /* synthetic */ zzvv mo32895b() {
        return (zzuo) mo32893a(zze.f30333f, (Object) null, (Object) null);
    }
}
