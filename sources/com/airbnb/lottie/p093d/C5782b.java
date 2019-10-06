package com.airbnb.lottie.p093d;

import android.content.Context;
import com.airbnb.lottie.C5718c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p053g.p061f.C1268l;
import p005cm.aptoide.p006pt.utils.MultiDexHelper;

/* renamed from: com.airbnb.lottie.d.b */
/* compiled from: NetworkCache */
class C5782b {

    /* renamed from: a */
    private final Context f10073a;

    /* renamed from: b */
    private final String f10074b;

    C5782b(Context appContext, String url) {
        this.f10073a = appContext.getApplicationContext();
        this.f10074b = url;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1268l<C5781a, InputStream> mo18136a() {
        C5781a extension;
        try {
            File cachedFile = m10403a(this.f10074b);
            if (cachedFile == null) {
                return null;
            }
            try {
                FileInputStream inputStream = new FileInputStream(cachedFile);
                if (cachedFile.getAbsolutePath().endsWith(MultiDexHelper.EXTRACTED_SUFFIX)) {
                    extension = C5781a.Zip;
                } else {
                    extension = C5781a.Json;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Cache hit for ");
                sb.append(this.f10074b);
                sb.append(" at ");
                sb.append(cachedFile.getAbsolutePath());
                C5718c.m10177b(sb.toString());
                return new C1268l<>(extension, inputStream);
            } catch (FileNotFoundException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo18137a(InputStream stream, C5781a extension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(this.f10073a.getCacheDir(), m10404a(this.f10074b, extension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
            while (true) {
                int read = stream.read(buffer);
                int read2 = read;
                if (read != -1) {
                    fileOutputStream.write(buffer, 0, read2);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    stream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            stream.close();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18138a(C5781a extension) {
        File file = new File(this.f10073a.getCacheDir(), m10404a(this.f10074b, extension, true));
        File newFile = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renamed = file.renameTo(newFile);
        StringBuilder sb = new StringBuilder();
        sb.append("Copying temp file to real file (");
        sb.append(newFile);
        sb.append(")");
        C5718c.m10177b(sb.toString());
        if (!renamed) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to rename cache file ");
            sb2.append(file.getAbsolutePath());
            sb2.append(" to ");
            sb2.append(newFile.getAbsolutePath());
            sb2.append(".");
            C5718c.m10179d(sb2.toString());
        }
    }

    /* renamed from: a */
    private File m10403a(String url) throws FileNotFoundException {
        File jsonFile = new File(this.f10073a.getCacheDir(), m10404a(url, C5781a.Json, false));
        if (jsonFile.exists()) {
            return jsonFile;
        }
        File zipFile = new File(this.f10073a.getCacheDir(), m10404a(url, C5781a.Zip, false));
        if (zipFile.exists()) {
            return zipFile;
        }
        return null;
    }

    /* renamed from: a */
    private static String m10404a(String url, C5781a extension, boolean isTemp) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(url.replaceAll("\\W+", ""));
        sb.append(isTemp ? extension.f10072d : extension.mo18134e());
        return sb.toString();
    }
}
