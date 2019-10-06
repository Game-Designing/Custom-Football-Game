package com.bumptech.glide.load.engine.p121b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.bumptech.glide.load.engine.b.j */
/* compiled from: MemorySizeCalculator */
public final class C6284j {

    /* renamed from: a */
    private final int f11111a;

    /* renamed from: b */
    private final int f11112b;

    /* renamed from: c */
    private final Context f11113c;

    /* renamed from: d */
    private final int f11114d;

    /* renamed from: com.bumptech.glide.load.engine.b.j$a */
    /* compiled from: MemorySizeCalculator */
    public static final class C6285a {

        /* renamed from: a */
        static final int f11115a = (VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: b */
        final Context f11116b;

        /* renamed from: c */
        ActivityManager f11117c;

        /* renamed from: d */
        C6287c f11118d;

        /* renamed from: e */
        float f11119e = 2.0f;

        /* renamed from: f */
        float f11120f = ((float) f11115a);

        /* renamed from: g */
        float f11121g = 0.4f;

        /* renamed from: h */
        float f11122h = 0.33f;

        /* renamed from: i */
        int f11123i = 4194304;

        public C6285a(Context context) {
            this.f11116b = context;
            this.f11117c = (ActivityManager) context.getSystemService("activity");
            this.f11118d = new C6286b(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && C6284j.m12059a(this.f11117c)) {
                this.f11120f = 0.0f;
            }
        }

        /* renamed from: a */
        public C6284j mo19196a() {
            return new C6284j(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.b.j$b */
    /* compiled from: MemorySizeCalculator */
    private static final class C6286b implements C6287c {

        /* renamed from: a */
        private final DisplayMetrics f11124a;

        C6286b(DisplayMetrics displayMetrics) {
            this.f11124a = displayMetrics;
        }

        /* renamed from: b */
        public int mo19198b() {
            return this.f11124a.widthPixels;
        }

        /* renamed from: a */
        public int mo19197a() {
            return this.f11124a.heightPixels;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.b.j$c */
    /* compiled from: MemorySizeCalculator */
    interface C6287c {
        /* renamed from: a */
        int mo19197a();

        /* renamed from: b */
        int mo19198b();
    }

    C6284j(C6285a builder) {
        int i;
        this.f11113c = builder.f11116b;
        if (m12059a(builder.f11117c)) {
            i = builder.f11123i / 2;
        } else {
            i = builder.f11123i;
        }
        this.f11114d = i;
        int maxSize = m12057a(builder.f11117c, builder.f11121g, builder.f11122h);
        int screenSize = builder.f11118d.mo19198b() * builder.f11118d.mo19197a() * 4;
        int targetBitmapPoolSize = Math.round(((float) screenSize) * builder.f11120f);
        int targetMemoryCacheSize = Math.round(((float) screenSize) * builder.f11119e);
        int availableSize = maxSize - this.f11114d;
        if (targetMemoryCacheSize + targetBitmapPoolSize <= availableSize) {
            this.f11112b = targetMemoryCacheSize;
            this.f11111a = targetBitmapPoolSize;
        } else {
            float f = (float) availableSize;
            float f2 = builder.f11120f;
            float f3 = builder.f11119e;
            float part = f / (f2 + f3);
            this.f11112b = Math.round(f3 * part);
            this.f11111a = Math.round(builder.f11120f * part);
        }
        String str = "MemorySizeCalculator";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m12058a(this.f11112b));
            sb.append(", pool size: ");
            sb.append(m12058a(this.f11111a));
            sb.append(", byte array size: ");
            sb.append(m12058a(this.f11114d));
            sb.append(", memory class limited? ");
            sb.append(targetMemoryCacheSize + targetBitmapPoolSize > maxSize);
            sb.append(", max size: ");
            sb.append(m12058a(maxSize));
            sb.append(", memoryClass: ");
            sb.append(builder.f11117c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m12059a(builder.f11117c));
            Log.d(str, sb.toString());
        }
    }

    /* renamed from: c */
    public int mo19195c() {
        return this.f11112b;
    }

    /* renamed from: b */
    public int mo19194b() {
        return this.f11111a;
    }

    /* renamed from: a */
    public int mo19193a() {
        return this.f11114d;
    }

    /* renamed from: a */
    private static int m12057a(ActivityManager activityManager, float maxSizeMultiplier, float lowMemoryMaxSizeMultiplier) {
        float f;
        float memoryClass = (float) (activityManager.getMemoryClass() * Opcodes.ACC_ABSTRACT * Opcodes.ACC_ABSTRACT);
        if (m12059a(activityManager)) {
            f = lowMemoryMaxSizeMultiplier;
        } else {
            f = maxSizeMultiplier;
        }
        return Math.round(memoryClass * f);
    }

    /* renamed from: a */
    private String m12058a(int bytes) {
        return Formatter.formatFileSize(this.f11113c, (long) bytes);
    }

    @TargetApi(19)
    /* renamed from: a */
    static boolean m12059a(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
