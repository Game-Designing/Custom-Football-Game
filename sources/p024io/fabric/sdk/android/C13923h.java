package p024io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: io.fabric.sdk.android.h */
/* compiled from: FabricKitsFinder */
class C13923h implements Callable<Map<String, C13928n>> {

    /* renamed from: a */
    final String f42245a;

    C13923h(String apkFileName) {
        this.f42245a = apkFileName;
    }

    public Map<String, C13928n> call() throws Exception {
        Map<String, KitInfo> kitInfos = new HashMap<>();
        long startScan = SystemClock.elapsedRealtime();
        kitInfos.putAll(m44262b());
        kitInfos.putAll(m44263c());
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("finish scanning in ");
        sb.append(SystemClock.elapsedRealtime() - startScan);
        e.mo43330e("Fabric", sb.toString());
        return kitInfos;
    }

    /* renamed from: b */
    private Map<String, C13928n> m44262b() {
        Map<String, KitInfo> implicitKits = new HashMap<>();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            C13928n admobKitInfo = new C13928n("com.google.firebase.firebase-ads", "0.0.0", "binary");
            implicitKits.put(admobKitInfo.mo43362b(), admobKitInfo);
            C13920f.m44245e().mo43330e("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception e) {
        }
        return implicitKits;
    }

    /* renamed from: c */
    private Map<String, C13928n> m44263c() throws Exception {
        Map<String, KitInfo> registeredKits = new HashMap<>();
        ZipFile apkFile = mo43354a();
        Enumeration<? extends ZipEntry> entries = apkFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String str = "fabric/";
            if (entry.getName().startsWith(str) && entry.getName().length() > str.length()) {
                C13928n kitInfo = m44261a(entry, apkFile);
                if (kitInfo != null) {
                    registeredKits.put(kitInfo.mo43362b(), kitInfo);
                    C13920f.m44245e().mo43330e("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{kitInfo.mo43362b(), kitInfo.mo43363c()}));
                }
            }
        }
        if (apkFile != null) {
            try {
                apkFile.close();
            } catch (IOException e) {
            }
        }
        return registeredKits;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private C13928n m44261a(ZipEntry fabricFile, ZipFile apk) {
        InputStream inputStream = null;
        try {
            inputStream = apk.getInputStream(fabricFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            String id = properties.getProperty("fabric-identifier");
            String version = properties.getProperty("fabric-version");
            String buildType = properties.getProperty("fabric-build-type");
            if (TextUtils.isEmpty(id) || TextUtils.isEmpty(version)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid format of fabric file,");
                sb.append(fabricFile.getName());
                throw new IllegalStateException(sb.toString());
            }
            C13928n nVar = new C13928n(id, version, buildType);
            C13852l.m44035a((Closeable) inputStream);
            return nVar;
        } catch (IOException ie) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error when parsing fabric properties ");
            sb2.append(fabricFile.getName());
            C13920f.m44245e().mo43325b("Fabric", sb2.toString(), ie);
            C13852l.m44035a((Closeable) inputStream);
            return null;
        } catch (Throwable th) {
            C13852l.m44035a((Closeable) inputStream);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ZipFile mo43354a() throws IOException {
        return new ZipFile(this.f42245a);
    }
}
