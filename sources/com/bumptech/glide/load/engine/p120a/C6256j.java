package com.bumptech.glide.load.engine.p120a;

import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface;
import com.bumptech.glide.p107h.C6024i;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.load.engine.a.j */
/* compiled from: LruArrayPool */
public final class C6256j implements C6245b {

    /* renamed from: a */
    private final C6253h<C6257a, Object> f11063a = new C6253h<>();

    /* renamed from: b */
    private final C6258b f11064b = new C6258b();

    /* renamed from: c */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f11065c = new HashMap();

    /* renamed from: d */
    private final Map<Class<?>, C6244a<?>> f11066d = new HashMap();

    /* renamed from: e */
    private final int f11067e;

    /* renamed from: f */
    private int f11068f;

    /* renamed from: com.bumptech.glide.load.engine.a.j$a */
    /* compiled from: LruArrayPool */
    private static final class C6257a implements C6263m {

        /* renamed from: a */
        private final C6258b f11069a;

        /* renamed from: b */
        int f11070b;

        /* renamed from: c */
        private Class<?> f11071c;

        C6257a(C6258b pool) {
            this.f11069a = pool;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19161a(int length, Class<?> arrayClass) {
            this.f11070b = length;
            this.f11071c = arrayClass;
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (!(o instanceof C6257a)) {
                return false;
            }
            C6257a other = (C6257a) o;
            if (this.f11070b == other.f11070b && this.f11071c == other.f11071c) {
                z = true;
            }
            return z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Key{size=");
            sb.append(this.f11070b);
            sb.append("array=");
            sb.append(this.f11071c);
            sb.append('}');
            return sb.toString();
        }

        /* renamed from: a */
        public void mo19139a() {
            this.f11069a.mo19146a(this);
        }

        public int hashCode() {
            int i = this.f11070b * 31;
            Class<?> cls = this.f11071c;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.a.j$b */
    /* compiled from: LruArrayPool */
    private static final class C6258b extends C6249d<C6257a> {
        C6258b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C6257a mo19165a(int size, Class<?> arrayClass) {
            C6257a result = (C6257a) mo19147b();
            result.mo19161a(size, arrayClass);
            return result;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C6257a m11987a() {
            return new C6257a(this);
        }
    }

    public C6256j(int maxSize) {
        this.f11067e = maxSize;
    }

    public synchronized <T> void put(T array) {
        Class<T> arrayClass = array.getClass();
        ArrayAdapterInterface<T> arrayAdapter = m11968a(arrayClass);
        int size = arrayAdapter.mo19124a(array);
        int arrayBytes = arrayAdapter.mo19123a() * size;
        if (m11978c(arrayBytes)) {
            C6257a key = this.f11064b.mo19165a(size, arrayClass);
            this.f11063a.mo19155a(key, array);
            NavigableMap<Integer, Integer> sizes = m11973b(arrayClass);
            Integer current = (Integer) sizes.get(Integer.valueOf(key.f11070b));
            Integer valueOf = Integer.valueOf(key.f11070b);
            int i = 1;
            if (current != null) {
                i = 1 + current.intValue();
            }
            sizes.put(valueOf, Integer.valueOf(i));
            this.f11068f += arrayBytes;
            m11974b();
        }
    }

    /* renamed from: b */
    public synchronized <T> T mo19130b(int size, Class<T> arrayClass) {
        return m11971a(this.f11064b.mo19165a(size, arrayClass), arrayClass);
    }

    /* renamed from: a */
    public synchronized <T> T mo19127a(int size, Class<T> arrayClass) {
        C6257a key;
        Integer possibleSize = (Integer) m11973b(arrayClass).ceilingKey(Integer.valueOf(size));
        if (m11972a(size, possibleSize)) {
            key = this.f11064b.mo19165a(possibleSize.intValue(), arrayClass);
        } else {
            key = this.f11064b.mo19165a(size, arrayClass);
        }
        return m11971a(key, arrayClass);
    }

    /* renamed from: a */
    private <T> T m11971a(C6257a key, Class<T> arrayClass) {
        ArrayAdapterInterface<T> arrayAdapter = m11968a(arrayClass);
        T result = m11970a(key);
        if (result != null) {
            this.f11068f -= arrayAdapter.mo19124a(result) * arrayAdapter.mo19123a();
            m11976c(arrayAdapter.mo19124a(result), arrayClass);
        }
        if (result != null) {
            return result;
        }
        if (Log.isLoggable(arrayAdapter.getTag(), 2)) {
            String tag = arrayAdapter.getTag();
            StringBuilder sb = new StringBuilder();
            sb.append("Allocated ");
            sb.append(key.f11070b);
            sb.append(" bytes");
            Log.v(tag, sb.toString());
        }
        return arrayAdapter.newArray(key.f11070b);
    }

    /* renamed from: a */
    private <T> T m11970a(C6257a key) {
        return this.f11063a.mo19154a(key);
    }

    /* renamed from: c */
    private boolean m11978c(int byteSize) {
        return byteSize <= this.f11067e / 2;
    }

    /* renamed from: a */
    private boolean m11972a(int requestedSize, Integer actualSize) {
        return actualSize != null && (m11977c() || actualSize.intValue() <= requestedSize * 8);
    }

    /* renamed from: c */
    private boolean m11977c() {
        int i = this.f11068f;
        return i == 0 || this.f11067e / i >= 2;
    }

    /* renamed from: a */
    public synchronized void mo19128a() {
        m11975b(0);
    }

    /* renamed from: a */
    public synchronized void mo19129a(int level) {
        if (level >= 40) {
            try {
                mo19128a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (level >= 20 || level == 15) {
            m11975b(this.f11067e / 2);
        }
    }

    /* renamed from: b */
    private void m11974b() {
        m11975b(this.f11067e);
    }

    /* renamed from: b */
    private void m11975b(int size) {
        while (this.f11068f > size) {
            Object evicted = this.f11063a.mo19153a();
            C6024i.m11264a(evicted);
            ArrayAdapterInterface<Object> arrayAdapter = m11969a((T) evicted);
            this.f11068f -= arrayAdapter.mo19124a(evicted) * arrayAdapter.mo19123a();
            m11976c(arrayAdapter.mo19124a(evicted), evicted.getClass());
            if (Log.isLoggable(arrayAdapter.getTag(), 2)) {
                String tag = arrayAdapter.getTag();
                StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(arrayAdapter.mo19124a(evicted));
                Log.v(tag, sb.toString());
            }
        }
    }

    /* renamed from: c */
    private void m11976c(int size, Class<?> arrayClass) {
        NavigableMap<Integer, Integer> sizes = m11973b(arrayClass);
        Integer current = (Integer) sizes.get(Integer.valueOf(size));
        if (current == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(size);
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (current.intValue() == 1) {
            sizes.remove(Integer.valueOf(size));
        } else {
            sizes.put(Integer.valueOf(size), Integer.valueOf(current.intValue() - 1));
        }
    }

    /* renamed from: b */
    private NavigableMap<Integer, Integer> m11973b(Class<?> arrayClass) {
        NavigableMap<Integer, Integer> sizes = (NavigableMap) this.f11065c.get(arrayClass);
        if (sizes != null) {
            return sizes;
        }
        NavigableMap<Integer, Integer> sizes2 = new TreeMap<>();
        this.f11065c.put(arrayClass, sizes2);
        return sizes2;
    }

    /* renamed from: a */
    private <T> C6244a<T> m11969a(T object) {
        return m11968a(object.getClass());
    }

    /* renamed from: a */
    private <T> C6244a<T> m11968a(Class<T> arrayPoolClass) {
        C6244a<T> aVar = (C6244a) this.f11066d.get(arrayPoolClass);
        if (aVar == null) {
            if (arrayPoolClass.equals(int[].class)) {
                aVar = new C6255i<>();
            } else if (arrayPoolClass.equals(byte[].class)) {
                aVar = new C6252g<>();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("No array pool found for: ");
                sb.append(arrayPoolClass.getSimpleName());
                throw new IllegalArgumentException(sb.toString());
            }
            this.f11066d.put(arrayPoolClass, aVar);
        }
        return aVar;
    }
}
