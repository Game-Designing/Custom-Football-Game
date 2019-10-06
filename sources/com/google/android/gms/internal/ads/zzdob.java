package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import com.google.android.gms.internal.ads.zzdob.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzdob<MessageType extends zzdob<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmi<MessageType, BuilderType> {
    private static Map<Object, zzdob<?, ?>> zzhhf = new ConcurrentHashMap();
    protected zzdqu zzhhd = zzdqu.m29974c();
    private int zzhhe = -1;

    public static abstract class zza<MessageType extends zzdob<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmj<MessageType, BuilderType> {

        /* renamed from: a */
        private final MessageType f28066a;

        /* renamed from: b */
        protected MessageType f28067b;

        /* renamed from: c */
        private boolean f28068c = false;

        protected zza(MessageType messagetype) {
            this.f28066a = messagetype;
            this.f28067b = (zzdob) messagetype.mo30637a(zze.f28073d, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: j */
        public final void mo31614j() {
            if (this.f28068c) {
                MessageType messagetype = (zzdob) this.f28067b.mo30637a(zze.f28073d, (Object) null, (Object) null);
                m29898a(messagetype, this.f28067b);
                this.f28067b = messagetype;
                this.f28068c = false;
            }
        }

        /* renamed from: k */
        public MessageType mo31613i() {
            if (this.f28068c) {
                return this.f28067b;
            }
            MessageType messagetype = this.f28067b;
            C9717sp.m24069a().mo29170a(messagetype).mo29088d(messagetype);
            this.f28068c = true;
            return this.f28067b;
        }

        /* renamed from: l */
        public final MessageType mo31612g() {
            MessageType messagetype = (zzdob) mo31613i();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.mo30637a(zze.f28070a, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = C9717sp.m24069a().mo29170a(messagetype).mo29087c(messagetype);
                    if (booleanValue) {
                        messagetype.mo30637a(zze.f28071b, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzdqs(messagetype);
        }

        /* renamed from: a */
        public final BuilderType mo31534a(MessageType messagetype) {
            mo31614j();
            m29898a(this.f28067b, messagetype);
            return this;
        }

        /* renamed from: a */
        private static void m29898a(MessageType messagetype, MessageType messagetype2) {
            C9717sp.m24069a().mo29170a(messagetype).mo29083a(messagetype, messagetype2);
        }

        /* renamed from: b */
        private final BuilderType m29899b(byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
            mo31614j();
            try {
                C9717sp.m24069a().mo29170a(this.f28067b).mo29084a(this.f28067b, bArr, 0, i2 + 0, new C9631oo(zzdno));
                return this;
            } catch (zzdok e) {
                throw e;
            } catch (IndexOutOfBoundsException e2) {
                throw zzdok.m29928a();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        /* renamed from: a */
        public final /* synthetic */ zzdmj mo31610a(byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
            m29899b(bArr, 0, i2, zzdno);
            return this;
        }

        /* renamed from: h */
        public final /* synthetic */ zzdmj mo31537h() {
            return (zza) clone();
        }

        /* renamed from: a */
        public final /* synthetic */ zzdpk mo31601a() {
            return this.f28066a;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.f28066a.mo30637a(zze.f28074e, (Object) null, (Object) null);
            zza.mo31534a((MessageType) (zzdob) mo31613i());
            return zza;
        }
    }

    public static class zzb<T extends zzdob<T, ?>> extends zzdmk<T> {

        /* renamed from: b */
        private final T f28069b;

        public zzb(T t) {
            this.f28069b = t;
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzdob<MessageType, BuilderType> implements zzdpm {
        protected C8985Lo<Object> zzhhj = C8985Lo.m22789g();
    }

    public static class zzd<ContainingType extends zzdpk, Type> extends zzdnm<ContainingType, Type> {
    }

    /* 'enum' access flag removed */
    public static final class zze {

        /* renamed from: a */
        public static final int f28070a = 1;

        /* renamed from: b */
        public static final int f28071b = 2;

        /* renamed from: c */
        public static final int f28072c = 3;

        /* renamed from: d */
        public static final int f28073d = 4;

        /* renamed from: e */
        public static final int f28074e = 5;

        /* renamed from: f */
        public static final int f28075f = 6;

        /* renamed from: g */
        public static final int f28076g = 7;

        /* renamed from: h */
        private static final /* synthetic */ int[] f28077h = {f28070a, f28071b, f28072c, f28073d, f28074e, f28075f, f28076g};

        /* renamed from: i */
        public static final int f28078i = 1;

        /* renamed from: j */
        public static final int f28079j = 2;

        /* renamed from: k */
        private static final /* synthetic */ int[] f28080k = {f28078i, f28079j};

        /* renamed from: l */
        public static final int f28081l = 1;

        /* renamed from: m */
        public static final int f28082m = 2;

        /* renamed from: n */
        private static final /* synthetic */ int[] f28083n = {f28081l, f28082m};

        /* renamed from: a */
        public static int[] m29910a() {
            return (int[]) f28077h.clone();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo30637a(int i, Object obj, Object obj2);

    public String toString() {
        return C9566lp.m23859a(this, super.toString());
    }

    public int hashCode() {
        int i = this.zzhcf;
        if (i != 0) {
            return i;
        }
        this.zzhcf = C9717sp.m24069a().mo29170a(this).mo29078a(this);
        return this.zzhcf;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzdob) mo30637a(zze.f28075f, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return C9717sp.m24069a().mo29170a(this).mo29086b(this, (zzdob) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) mo30637a(zze.f28070a, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c = C9717sp.m24069a().mo29170a(this).mo29087c(this);
        if (booleanValue) {
            mo30637a(zze.f28071b, (Object) c ? this : null, (Object) null);
        }
        return c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final int mo31532h() {
        return this.zzhhe;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31530a(int i) {
        this.zzhhe = i;
    }

    /* renamed from: a */
    public final void mo31602a(zzdni zzdni) throws IOException {
        C9717sp.m24069a().mo29169a(getClass()).mo29081a(this, (C9435fq) C8859Fo.m22501a(zzdni));
    }

    /* renamed from: c */
    public final int mo31603c() {
        if (this.zzhhe == -1) {
            this.zzhhe = C9717sp.m24069a().mo29170a(this).mo29085b(this);
        }
        return this.zzhhe;
    }

    /* renamed from: a */
    static <T extends zzdob<?, ?>> T m29884a(Class<T> cls) {
        T t = (zzdob) zzhhf.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzdob) zzhhf.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzdob) ((zzdob) C9132Sp.m22978a(cls)).mo30637a(zze.f28075f, (Object) null, (Object) null);
            if (t != null) {
                zzhhf.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    /* renamed from: a */
    protected static <T extends zzdob<?, ?>> void m29887a(Class<T> cls, T t) {
        zzhhf.put(cls, t);
    }

    /* renamed from: a */
    protected static Object m29885a(zzdpk zzdpk, String str, Object[] objArr) {
        return new C9759up(zzdpk, str, objArr);
    }

    /* renamed from: a */
    static Object m29886a(Method method, Object obj, Object... objArr) {
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

    /* renamed from: j */
    protected static zzdoh m29888j() {
        return C9156To.m23091b();
    }

    /* renamed from: k */
    protected static <E> zzdoj<E> m29889k() {
        return C9738tp.m24099b();
    }

    /* renamed from: a */
    private static <T extends zzdob<T, ?>> T m29880a(T t, zzdnd zzdnd, zzdno zzdno) throws zzdok {
        T t2 = (zzdob) t.mo30637a(zze.f28073d, (Object) null, (Object) null);
        try {
            C9717sp.m24069a().mo29170a(t2).mo29082a(t2, C8817Do.m22419a(zzdnd), zzdno);
            C9717sp.m24069a().mo29170a(t2).mo29088d(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzdok) {
                throw ((zzdok) e.getCause());
            }
            throw new zzdok(e.getMessage()).mo31617a(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzdok) {
                throw ((zzdok) e2.getCause());
            }
            throw e2;
        }
    }

    /* renamed from: a */
    private static <T extends zzdob<T, ?>> T m29882a(T t, byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
        T t2 = (zzdob) t.mo30637a(zze.f28073d, (Object) null, (Object) null);
        try {
            C9717sp.m24069a().mo29170a(t2).mo29084a(t2, bArr, 0, i2, new C9631oo(zzdno));
            C9717sp.m24069a().mo29170a(t2).mo29088d(t2);
            if (t2.zzhcf == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzdok) {
                throw ((zzdok) e.getCause());
            }
            throw new zzdok(e.getMessage()).mo31617a(t2);
        } catch (IndexOutOfBoundsException e2) {
            throw zzdok.m29928a().mo31617a(t2);
        }
    }

    /* renamed from: a */
    protected static <T extends zzdob<T, ?>> T m29878a(T t, zzdmr zzdmr) throws zzdok {
        boolean z;
        T a = m29879a(t, zzdmr, zzdno.m29866b());
        boolean z2 = false;
        if (a != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) a.mo30637a(zze.f28070a, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue == 0) {
                z = false;
            } else {
                z = C9717sp.m24069a().mo29170a(a).mo29087c(a);
                if (booleanValue) {
                    a.mo30637a(zze.f28071b, (Object) z ? a : null, (Object) null);
                }
            }
            if (!z) {
                throw new zzdqs(a).mo31646a().mo31617a(a);
            }
        }
        if (a != null) {
            boolean booleanValue2 = Boolean.TRUE.booleanValue();
            byte byteValue2 = ((Byte) a.mo30637a(zze.f28070a, (Object) null, (Object) null)).byteValue();
            if (byteValue2 == 1) {
                z2 = true;
            } else if (byteValue2 != 0) {
                z2 = C9717sp.m24069a().mo29170a(a).mo29087c(a);
                if (booleanValue2) {
                    a.mo30637a(zze.f28071b, (Object) z2 ? a : null, (Object) null);
                }
            }
            if (!z2) {
                throw new zzdqs(a).mo31646a().mo31617a(a);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static <T extends zzdob<T, ?>> T m29879a(T t, zzdmr zzdmr, zzdno zzdno) throws zzdok {
        T a;
        try {
            zzdnd d = zzdmr.mo29331d();
            a = m29880a(t, d, zzdno);
            d.mo28081a(0);
            return a;
        } catch (zzdok e) {
            throw e.mo31617a(a);
        } catch (zzdok e2) {
            throw e2;
        }
    }

    /* renamed from: a */
    protected static <T extends zzdob<T, ?>> T m29881a(T t, byte[] bArr) throws zzdok {
        boolean z = false;
        T a = m29882a(t, bArr, 0, bArr.length, zzdno.m29866b());
        if (a != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) a.mo30637a(zze.f28070a, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = C9717sp.m24069a().mo29170a(a).mo29087c(a);
                if (booleanValue) {
                    a.mo30637a(zze.f28071b, (Object) z ? a : null, (Object) null);
                }
            }
            if (!z) {
                throw new zzdqs(a).mo31646a().mo31617a(a);
            }
        }
        return a;
    }

    /* renamed from: a */
    protected static <T extends zzdob<T, ?>> T m29883a(T t, byte[] bArr, zzdno zzdno) throws zzdok {
        boolean z = false;
        T a = m29882a(t, bArr, 0, bArr.length, zzdno);
        if (a != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) a.mo30637a(zze.f28070a, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = C9717sp.m24069a().mo29170a(a).mo29087c(a);
                if (booleanValue) {
                    a.mo30637a(zze.f28071b, (Object) z ? a : null, (Object) null);
                }
            }
            if (!z) {
                throw new zzdqs(a).mo31646a().mo31617a(a);
            }
        }
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ zzdpl mo31604d() {
        zza zza2 = (zza) mo30637a(zze.f28074e, (Object) null, (Object) null);
        zza2.mo31534a(this);
        return zza2;
    }

    /* renamed from: e */
    public final /* synthetic */ zzdpl mo31605e() {
        return (zza) mo30637a(zze.f28074e, (Object) null, (Object) null);
    }

    /* renamed from: a */
    public final /* synthetic */ zzdpk mo31601a() {
        return (zzdob) mo30637a(zze.f28075f, (Object) null, (Object) null);
    }
}
