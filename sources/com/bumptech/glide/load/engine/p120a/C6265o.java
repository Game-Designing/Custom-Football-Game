package com.bumptech.glide.load.engine.p120a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.p107h.C6026k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.load.engine.a.o */
/* compiled from: SizeConfigStrategy */
public class C6265o implements C6262l {

    /* renamed from: a */
    private static final Config[] f11084a;

    /* renamed from: b */
    private static final Config[] f11085b = f11084a;

    /* renamed from: c */
    private static final Config[] f11086c = {Config.RGB_565};

    /* renamed from: d */
    private static final Config[] f11087d = {Config.ARGB_4444};

    /* renamed from: e */
    private static final Config[] f11088e = {Config.ALPHA_8};

    /* renamed from: f */
    private final C6267b f11089f = new C6267b();

    /* renamed from: g */
    private final C6253h<C6266a, Bitmap> f11090g = new C6253h<>();

    /* renamed from: h */
    private final Map<Config, NavigableMap<Integer, Integer>> f11091h = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.a.o$a */
    /* compiled from: SizeConfigStrategy */
    static final class C6266a implements C6263m {

        /* renamed from: a */
        private final C6267b f11092a;

        /* renamed from: b */
        int f11093b;

        /* renamed from: c */
        private Config f11094c;

        public C6266a(C6267b pool) {
            this.f11092a = pool;
        }

        /* renamed from: a */
        public void mo19170a(int size, Config config) {
            this.f11093b = size;
            this.f11094c = config;
        }

        /* renamed from: a */
        public void mo19139a() {
            this.f11092a.mo19146a(this);
        }

        public String toString() {
            return C6265o.m12015a(this.f11093b, this.f11094c);
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (!(o instanceof C6266a)) {
                return false;
            }
            C6266a other = (C6266a) o;
            if (this.f11093b == other.f11093b && C6026k.m11286b((Object) this.f11094c, (Object) other.f11094c)) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            int i = this.f11093b * 31;
            Config config = this.f11094c;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.a.o$b */
    /* compiled from: SizeConfigStrategy */
    static class C6267b extends C6249d<C6266a> {
        C6267b() {
        }

        /* renamed from: a */
        public C6266a mo19174a(int size, Config config) {
            C6266a result = (C6266a) mo19147b();
            result.mo19170a(size, config);
            return result;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C6266a m12028a() {
            return new C6266a(this);
        }
    }

    static {
        Config[] result = {Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            result = (Config[]) Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = Config.RGBA_F16;
        }
        f11084a = result;
    }

    /* renamed from: a */
    public void mo19133a(Bitmap bitmap) {
        C6266a key = this.f11089f.mo19174a(C6026k.m11274a(bitmap), bitmap.getConfig());
        this.f11090g.mo19155a(key, bitmap);
        NavigableMap<Integer, Integer> sizes = m12019b(bitmap.getConfig());
        Integer current = (Integer) sizes.get(Integer.valueOf(key.f11093b));
        Integer valueOf = Integer.valueOf(key.f11093b);
        int i = 1;
        if (current != null) {
            i = 1 + current.intValue();
        }
        sizes.put(valueOf, Integer.valueOf(i));
    }

    /* renamed from: a */
    public Bitmap mo19132a(int width, int height, Config config) {
        C6266a bestKey = m12018b(C6026k.m11272a(width, height, config), config);
        Bitmap result = (Bitmap) this.f11090g.mo19154a(bestKey);
        if (result != null) {
            m12016a(Integer.valueOf(bestKey.f11093b), result);
            result.reconfigure(width, height, result.getConfig() != null ? result.getConfig() : Config.ARGB_8888);
        }
        return result;
    }

    /* renamed from: b */
    private C6266a m12018b(int size, Config config) {
        C6266a result = this.f11089f.mo19174a(size, config);
        Config[] a = m12017a(config);
        int length = a.length;
        int i = 0;
        while (i < length) {
            Config possibleConfig = a[i];
            Integer possibleSize = (Integer) m12019b(possibleConfig).ceilingKey(Integer.valueOf(size));
            if (possibleSize == null || possibleSize.intValue() > size * 8) {
                i++;
            } else {
                if (possibleSize.intValue() == size) {
                    if (possibleConfig == null) {
                        if (config == null) {
                            return result;
                        }
                    } else if (possibleConfig.equals(config)) {
                        return result;
                    }
                }
                this.f11089f.mo19146a(result);
                return this.f11089f.mo19174a(possibleSize.intValue(), possibleConfig);
            }
        }
        return result;
    }

    public Bitmap removeLast() {
        Bitmap removed = (Bitmap) this.f11090g.mo19153a();
        if (removed != null) {
            m12016a(Integer.valueOf(C6026k.m11274a(removed)), removed);
        }
        return removed;
    }

    /* renamed from: a */
    private void m12016a(Integer size, Bitmap removed) {
        NavigableMap<Integer, Integer> sizes = m12019b(removed.getConfig());
        Integer current = (Integer) sizes.get(size);
        if (current == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(size);
            sb.append(", removed: ");
            sb.append(mo19135b(removed));
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (current.intValue() == 1) {
            sizes.remove(size);
        } else {
            sizes.put(size, Integer.valueOf(current.intValue() - 1));
        }
    }

    /* renamed from: b */
    private NavigableMap<Integer, Integer> m12019b(Config config) {
        NavigableMap<Integer, Integer> sizes = (NavigableMap) this.f11091h.get(config);
        if (sizes != null) {
            return sizes;
        }
        NavigableMap<Integer, Integer> sizes2 = new TreeMap<>();
        this.f11091h.put(config, sizes2);
        return sizes2;
    }

    /* renamed from: b */
    public String mo19135b(Bitmap bitmap) {
        return m12015a(C6026k.m11274a(bitmap), bitmap.getConfig());
    }

    /* renamed from: b */
    public String mo19134b(int width, int height, Config config) {
        return m12015a(C6026k.m11272a(width, height, config), config);
    }

    /* renamed from: c */
    public int mo19136c(Bitmap bitmap) {
        return C6026k.m11274a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f11090g);
        StringBuilder sb2 = sb.append(", sortedSizes=(");
        for (Entry<Config, NavigableMap<Integer, Integer>> entry : this.f11091h.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!this.f11091h.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }

    /* renamed from: a */
    static String m12015a(int size, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(size);
        sb.append("](");
        sb.append(config);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    private static Config[] m12017a(Config requested) {
        if (VERSION.SDK_INT >= 26 && Config.RGBA_F16.equals(requested)) {
            return f11085b;
        }
        int i = C6264n.f11083a[requested.ordinal()];
        if (i == 1) {
            return f11084a;
        }
        if (i == 2) {
            return f11086c;
        }
        if (i == 3) {
            return f11087d;
        }
        if (i == 4) {
            return f11088e;
        }
        return new Config[]{requested};
    }
}
