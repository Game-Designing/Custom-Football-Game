package com.bumptech.glide.load.engine.p120a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.engine.a.k */
/* compiled from: LruBitmapPool */
public class C6259k implements C6250e {

    /* renamed from: a */
    private static final Config f11072a = Config.ARGB_8888;

    /* renamed from: b */
    private final C6262l f11073b;

    /* renamed from: c */
    private final Set<Config> f11074c;

    /* renamed from: d */
    private final long f11075d;

    /* renamed from: e */
    private final C6260a f11076e;

    /* renamed from: f */
    private long f11077f;

    /* renamed from: g */
    private long f11078g;

    /* renamed from: h */
    private int f11079h;

    /* renamed from: i */
    private int f11080i;

    /* renamed from: j */
    private int f11081j;

    /* renamed from: k */
    private int f11082k;

    /* renamed from: com.bumptech.glide.load.engine.a.k$a */
    /* compiled from: LruBitmapPool */
    private interface C6260a {
        /* renamed from: a */
        void mo19167a(Bitmap bitmap);

        /* renamed from: b */
        void mo19168b(Bitmap bitmap);
    }

    /* renamed from: com.bumptech.glide.load.engine.a.k$b */
    /* compiled from: LruBitmapPool */
    private static final class C6261b implements C6260a {
        C6261b() {
        }

        /* renamed from: b */
        public void mo19168b(Bitmap bitmap) {
        }

        /* renamed from: a */
        public void mo19167a(Bitmap bitmap) {
        }
    }

    C6259k(long maxSize, C6262l strategy, Set<Config> allowedConfigs) {
        this.f11075d = maxSize;
        this.f11077f = maxSize;
        this.f11073b = strategy;
        this.f11074c = allowedConfigs;
        this.f11076e = new C6261b();
    }

    public C6259k(long maxSize) {
        this(maxSize, m11998g(), m11997f());
    }

    /* renamed from: b */
    public long mo19166b() {
        return this.f11077f;
    }

    /* renamed from: a */
    public synchronized void mo19000a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f11073b.mo19136c(bitmap)) <= this.f11077f) {
                        if (this.f11074c.contains(bitmap.getConfig())) {
                            int size = this.f11073b.mo19136c(bitmap);
                            this.f11073b.mo19133a(bitmap);
                            this.f11076e.mo19168b(bitmap);
                            this.f11081j++;
                            this.f11078g += (long) size;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Put bitmap in pool=");
                                sb.append(this.f11073b.mo19135b(bitmap));
                                Log.v("LruBitmapPool", sb.toString());
                            }
                            m11992c();
                            m11996e();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.f11073b.mo19135b(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.f11074c.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } finally {
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    /* renamed from: e */
    private void m11996e() {
        m11988a(this.f11077f);
    }

    /* renamed from: a */
    public Bitmap mo19148a(int width, int height, Config config) {
        Bitmap result = m11994d(width, height, config);
        if (result == null) {
            return m11991c(width, height, config);
        }
        result.eraseColor(0);
        return result;
    }

    /* renamed from: b */
    public Bitmap mo19151b(int width, int height, Config config) {
        Bitmap result = m11994d(width, height, config);
        if (result == null) {
            return m11991c(width, height, config);
        }
        return result;
    }

    /* renamed from: c */
    private static Bitmap m11991c(int width, int height, Config config) {
        return Bitmap.createBitmap(width, height, config != null ? config : f11072a);
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m11989a(Config config) {
        if (VERSION.SDK_INT >= 26 && config == Config.HARDWARE) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot create a mutable Bitmap with config: ");
            sb.append(config);
            sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: d */
    private synchronized Bitmap m11994d(int width, int height, Config config) {
        Bitmap result;
        m11989a(config);
        result = this.f11073b.mo19132a(width, height, config != null ? config : f11072a);
        if (result == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.f11073b.mo19134b(width, height, config));
                Log.d("LruBitmapPool", sb.toString());
            }
            this.f11080i++;
        } else {
            this.f11079h++;
            this.f11078g -= (long) this.f11073b.mo19136c(result);
            this.f11076e.mo19167a(result);
            m11993c(result);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.f11073b.mo19134b(width, height, config));
            Log.v("LruBitmapPool", sb2.toString());
        }
        m11992c();
        return result;
    }

    /* renamed from: c */
    private static void m11993c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m11990b(bitmap);
    }

    @TargetApi(19)
    /* renamed from: b */
    private static void m11990b(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    /* renamed from: a */
    public void mo19149a() {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "clearMemory");
        }
        m11988a(0);
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo19150a(int level) {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(level);
            Log.d(str, sb.toString());
        }
        if (level >= 40) {
            mo19149a();
        } else if (level >= 20 || level == 15) {
            m11988a(mo19166b() / 2);
        }
    }

    /* renamed from: a */
    private synchronized void m11988a(long size) {
        while (this.f11078g > size) {
            Bitmap removed = this.f11073b.removeLast();
            if (removed == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m11995d();
                }
                this.f11078g = 0;
                return;
            }
            this.f11076e.mo19167a(removed);
            this.f11078g -= (long) this.f11073b.mo19136c(removed);
            this.f11082k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.f11073b.mo19135b(removed));
                Log.d("LruBitmapPool", sb.toString());
            }
            m11992c();
            removed.recycle();
        }
    }

    /* renamed from: c */
    private void m11992c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m11995d();
        }
    }

    /* renamed from: d */
    private void m11995d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.f11079h);
        sb.append(", misses=");
        sb.append(this.f11080i);
        sb.append(", puts=");
        sb.append(this.f11081j);
        sb.append(", evictions=");
        sb.append(this.f11082k);
        sb.append(", currentSize=");
        sb.append(this.f11078g);
        sb.append(", maxSize=");
        sb.append(this.f11077f);
        sb.append("\nStrategy=");
        sb.append(this.f11073b);
        Log.v("LruBitmapPool", sb.toString());
    }

    /* renamed from: g */
    private static C6262l m11998g() {
        if (VERSION.SDK_INT >= 19) {
            return new C6265o();
        }
        return new C6246c();
    }

    @TargetApi(26)
    /* renamed from: f */
    private static Set<Config> m11997f() {
        Set<Config> configs = new HashSet<>(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            configs.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            configs.remove(Config.HARDWARE);
        }
        return Collections.unmodifiableSet(configs);
    }
}
