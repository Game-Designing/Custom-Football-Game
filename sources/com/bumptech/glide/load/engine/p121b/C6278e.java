package com.bumptech.glide.load.engine.p121b;

import android.util.Log;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.engine.p121b.C6269a.C6271b;
import com.bumptech.glide.p098a.C5911b;
import com.bumptech.glide.p098a.C5911b.C5913b;
import com.bumptech.glide.p098a.C5911b.C5915d;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.engine.b.e */
/* compiled from: DiskLruCacheWrapper */
public class C6278e implements C6269a {

    /* renamed from: a */
    private final C6289l f11103a;

    /* renamed from: b */
    private final File f11104b;

    /* renamed from: c */
    private final long f11105c;

    /* renamed from: d */
    private final C6273c f11106d = new C6273c();

    /* renamed from: e */
    private C5911b f11107e;

    /* renamed from: a */
    public static C6269a m12040a(File directory, long maxSize) {
        return new C6278e(directory, maxSize);
    }

    @Deprecated
    protected C6278e(File directory, long maxSize) {
        this.f11104b = directory;
        this.f11105c = maxSize;
        this.f11103a = new C6289l();
    }

    /* renamed from: a */
    private synchronized C5911b m12039a() throws IOException {
        if (this.f11107e == null) {
            this.f11107e = C5911b.m10815a(this.f11104b, 1, 1, this.f11105c);
        }
        return this.f11107e;
    }

    /* renamed from: a */
    public File mo19176a(C6344g key) {
        String safeKey = this.f11103a.mo19199a(key);
        String str = "DiskLruCacheWrapper";
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(safeKey);
            sb.append(" for for Key: ");
            sb.append(key);
            Log.v(str, sb.toString());
        }
        try {
            C5915d value = m12039a().mo18534b(safeKey);
            if (value != null) {
                return value.mo18545a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, "Unable to get from disk cache", e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo19177a(C6344g key, C6271b writer) {
        C5913b editor;
        String str = "DiskLruCacheWrapper";
        String safeKey = this.f11103a.mo19199a(key);
        this.f11106d.mo19180a(safeKey);
        try {
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Put: Obtained: ");
                sb.append(safeKey);
                sb.append(" for for Key: ");
                sb.append(key);
                Log.v(str, sb.toString());
            }
            try {
                C5911b diskCache = m12039a();
                if (diskCache.mo18534b(safeKey) == null) {
                    editor = diskCache.mo18532a(safeKey);
                    if (editor != null) {
                        if (writer.mo19179a(editor.mo18538a(0))) {
                            editor.mo18541c();
                        }
                        editor.mo18540b();
                        this.f11106d.mo19181b(safeKey);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Had two simultaneous puts for: ");
                    sb2.append(safeKey);
                    throw new IllegalStateException(sb2.toString());
                }
            } catch (IOException e) {
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Unable to put to disk cache", e);
                }
            } catch (Throwable th) {
                editor.mo18540b();
                throw th;
            }
        } finally {
            this.f11106d.mo19181b(safeKey);
        }
    }
}
