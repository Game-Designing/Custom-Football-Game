package com.smaato.soma.p261j.p262a;

import android.content.Context;
import android.os.StatFs;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p261j.p262a.C12453e.C12454a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.smaato.soma.j.a.b */
/* compiled from: DiskCacheService */
public class C12450b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C12453e f38865a;

    /* renamed from: b */
    public static boolean m40932b(Context context) {
        if (context == null) {
            return false;
        }
        if (f38865a == null) {
            return ((Boolean) new C12449a(context).execute()).booleanValue();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static File m40933c(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String cachePath = cacheDir.getPath();
        StringBuilder sb = new StringBuilder();
        sb.append(cachePath);
        sb.append(File.separator);
        sb.append("smaato-cache");
        return new File(sb.toString());
    }

    /* renamed from: a */
    public static long m40925a(File dir) {
        return m40926a(dir, 31457280);
    }

    /* renamed from: a */
    public static long m40926a(File dir, long minSize) {
        long size = minSize;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            size = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException e) {
            C12146d.m39965a(new C12147e("DiskCacheService", "DiskCacheServiceUnable to calculate 2% of available disk space, defaulting to minimum", 1, C12143a.DEBUG));
        }
        return Math.max(Math.min(size, 104857600), 31457280);
    }

    /* renamed from: b */
    public static String m40931b(String key) {
        return C12278d.m40415a().mo39672a(key);
    }

    /* renamed from: a */
    public static boolean m40929a(String key) {
        C12453e eVar = f38865a;
        boolean z = false;
        if (eVar == null) {
            return false;
        }
        try {
            if (eVar.mo39978b(m40931b(key)) != null) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    public static String m40934c(String key) {
        if (f38865a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f38865a.mo39980c());
        sb.append(File.separator);
        sb.append(m40931b(key));
        sb.append(".");
        sb.append(0);
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m40930a(String key, InputStream content) {
        C12453e eVar = f38865a;
        if (eVar == null) {
            return false;
        }
        C12454a editor = null;
        try {
            C12454a editor2 = eVar.mo39977a(m40931b(key));
            if (editor2 == null) {
                return false;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(editor2.mo39984a(0));
            C12463k.m40995a(content, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            f38865a.flush();
            editor2.mo39986b();
            return true;
        } catch (Exception e) {
            C12146d.m39965a(new C12147e("DiskCacheService", "DiskCacheServiceUnable to put to DiskLruCache", 1, C12143a.DEBUG));
            if (editor != null) {
                try {
                    editor.mo39985a();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }
}
