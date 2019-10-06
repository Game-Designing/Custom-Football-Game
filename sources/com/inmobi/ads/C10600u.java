package com.inmobi.ads;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.inmobi.ads.C10598t.C10599a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.inmobi.ads.u */
/* compiled from: GifMovieObject */
public final class C10600u implements C10598t {

    /* renamed from: a */
    Movie f32283a;

    /* renamed from: b */
    int f32284b = 0;

    /* renamed from: c */
    private long f32285c;

    /* renamed from: d */
    private volatile boolean f32286d = false;

    /* renamed from: e */
    private C10599a f32287e;

    /* renamed from: f */
    private ExecutorService f32288f;

    /* renamed from: g */
    private Runnable f32289g;

    public C10600u(String str) throws IOException {
        File file = new File(str);
        byte[] bArr = new byte[((int) file.length())];
        FileInputStream fileInputStream = new FileInputStream(file);
        int read = fileInputStream.read(bArr);
        fileInputStream.close();
        this.f32283a = Movie.decodeByteArray(bArr, 0, read);
    }

    /* renamed from: a */
    public final void mo34336a() {
        this.f32288f = Executors.newSingleThreadExecutor();
        this.f32289g = new Runnable() {
            public final void run() {
                C10600u uVar = C10600u.this;
                if (uVar.f32284b + 20 >= uVar.f32283a.duration()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            C10600u uVar = C10600u.this;
                            uVar.f32284b = 0;
                            uVar.mo34339a(false);
                        }
                    });
                }
            }
        };
    }

    /* renamed from: a */
    public final void mo34339a(boolean z) {
        this.f32286d = z;
        if (!this.f32286d) {
            this.f32285c = SystemClock.uptimeMillis() - ((long) this.f32284b);
        }
        C10599a aVar = this.f32287e;
        if (aVar != null) {
            aVar.mo33695a();
        }
    }

    /* renamed from: b */
    public final int mo34340b() {
        return this.f32283a.width();
    }

    /* renamed from: c */
    public final int mo34341c() {
        return this.f32283a.height();
    }

    /* renamed from: a */
    public final void mo34337a(Canvas canvas, float f, float f2) {
        this.f32283a.draw(canvas, f, f2);
        this.f32288f.execute(this.f32289g);
    }

    /* renamed from: d */
    public final boolean mo34342d() {
        return !this.f32286d;
    }

    /* renamed from: e */
    public final void mo34343e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f32285c == 0) {
            this.f32285c = uptimeMillis;
        }
        int duration = this.f32283a.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f32284b = (int) ((uptimeMillis - this.f32285c) % ((long) duration));
        this.f32283a.setTime(this.f32284b);
    }

    /* renamed from: a */
    public final void mo34338a(C10599a aVar) {
        this.f32287e = aVar;
    }
}
