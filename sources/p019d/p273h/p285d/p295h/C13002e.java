package p019d.p273h.p285d.p295h;

import android.content.Context;
import com.ironsource.sdk.data.C10895h;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p274a.C12725c;

/* renamed from: d.h.d.h.e */
/* compiled from: IronSourceStorageUtils */
public class C13002e {
    /* renamed from: a */
    public static String m42421a(Context context) {
        m42428b(context);
        return m42430c(context);
    }

    /* renamed from: c */
    private static String m42430c(Context context) {
        String storedVerison = C13001d.m42395g().mo41904d();
        String sdkVer = C12998a.m42385g();
        String str = "supersonicads";
        if (storedVerison.equalsIgnoreCase(sdkVer)) {
            return m42420a(context, str).getPath();
        }
        C13001d.m42395g().mo41909f(sdkVer);
        File cacheDir = C12725c.m41097f(context);
        if (cacheDir != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cacheDir.getAbsolutePath());
            sb.append(File.separator);
            sb.append(str);
            sb.append(File.separator);
            m42422a(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12725c.m41102h(context));
        sb2.append(File.separator);
        sb2.append(str);
        sb2.append(File.separator);
        m42422a(sb2.toString());
        return m42428b(context);
    }

    /* renamed from: a */
    private static void m42422a(String path) {
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    m42422a(file.getAbsolutePath());
                    file.delete();
                } else {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    private static File m42420a(Context context, String cacheDirName) {
        if (C13004g.m42468k()) {
            File externalCacheDir = C12725c.m41097f(context);
            if (externalCacheDir == null || !externalCacheDir.canWrite()) {
                String cachePath = C12725c.m41102h(context);
                StringBuilder sb = new StringBuilder();
                sb.append(cachePath);
                sb.append(File.separator);
                sb.append(cacheDirName);
                return new File(sb.toString());
            }
            String cachePath2 = externalCacheDir.getPath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cachePath2);
            sb2.append(File.separator);
            sb2.append(cacheDirName);
            return new File(sb2.toString());
        }
        String cachePath3 = C12725c.m41102h(context);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cachePath3);
        sb3.append(File.separator);
        sb3.append(cacheDirName);
        return new File(sb3.toString());
    }

    /* renamed from: b */
    private static String m42428b(Context context) {
        File rootDirectory = m42420a(context, "supersonicads");
        if (!rootDirectory.exists()) {
            rootDirectory.mkdir();
        }
        return rootDirectory.getPath();
    }

    /* renamed from: d */
    public static String m42432d(String cacheRootDirectory, String directory) {
        File dir = new File(cacheRootDirectory, directory);
        if (dir.exists() || dir.mkdirs()) {
            return dir.getPath();
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized boolean m42426a(String rootCacheDir, String filePath, String fileName) {
        synchronized (C13002e.class) {
            File dir = new File(rootCacheDir, filePath);
            if (!dir.exists()) {
                return false;
            }
            File[] files = dir.listFiles();
            if (files == null) {
                return false;
            }
            int length = files.length;
            int i = 0;
            while (i < length) {
                File entry = files[i];
                if (!entry.isFile() || !entry.getName().equalsIgnoreCase(fileName)) {
                    i++;
                } else {
                    boolean delete = entry.delete();
                    return delete;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m42424a(java.lang.String r9, com.ironsource.sdk.data.C10896i r10) {
        /*
            java.lang.Class<d.h.d.h.e> r0 = p019d.p273h.p285d.p295h.C13002e.class
            monitor-enter(r0)
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x003d }
            java.lang.String r2 = r10.mo35664e()     // Catch:{ all -> 0x003d }
            r1.<init>(r9, r2)     // Catch:{ all -> 0x003d }
            java.io.File[] r2 = r1.listFiles()     // Catch:{ all -> 0x003d }
            r3 = 0
            if (r2 == 0) goto L_0x003b
            java.io.File[] r2 = r1.listFiles()     // Catch:{ all -> 0x003d }
            int r4 = r2.length     // Catch:{ all -> 0x003d }
            r5 = 0
        L_0x0019:
            if (r5 >= r4) goto L_0x003b
            r6 = r2[r5]     // Catch:{ all -> 0x003d }
            boolean r7 = r6.isFile()     // Catch:{ all -> 0x003d }
            if (r7 == 0) goto L_0x0038
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x003d }
            java.lang.String r8 = r10.mo35662c()     // Catch:{ all -> 0x003d }
            java.lang.String r8 = p019d.p273h.p285d.p295h.C13004g.m42452b(r8)     // Catch:{ all -> 0x003d }
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ all -> 0x003d }
            if (r7 == 0) goto L_0x0038
            monitor-exit(r0)
            r0 = 1
            return r0
        L_0x0038:
            int r5 = r5 + 1
            goto L_0x0019
        L_0x003b:
            monitor-exit(r0)
            return r3
        L_0x003d:
            r9 = move-exception
            monitor-exit(r0)
            goto L_0x0041
        L_0x0040:
            throw r9
        L_0x0041:
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p285d.p295h.C13002e.m42424a(java.lang.String, com.ironsource.sdk.data.i):boolean");
    }

    /* renamed from: c */
    public static boolean m42431c(String cachRootPath, String path) {
        return new File(cachRootPath, path).exists();
    }

    /* renamed from: a */
    public static synchronized boolean m42425a(String cacheRootDir, String path) {
        boolean z;
        synchronized (C13002e.class) {
            File folder = new File(cacheRootDir, path);
            z = m42423a(folder) && folder.delete();
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m42423a(File dir) {
        File[] files = dir.listFiles();
        boolean success = true;
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    success &= m42423a(file);
                }
                if (!file.delete()) {
                    success = false;
                }
            }
        }
        return success;
    }

    /* renamed from: b */
    public static String m42429b(String cacheRootPath, String path) {
        JSONObject jsnObj = m42434f(cacheRootPath, path);
        try {
            jsnObj.put("path", path);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsnObj.toString();
    }

    /* renamed from: f */
    private static JSONObject m42434f(String cacheRootPath, String path) {
        File dir = new File(cacheRootPath, path);
        JSONObject jsnObj = new JSONObject();
        File[] fileList = dir.listFiles();
        if (fileList != null) {
            for (File entry : fileList) {
                try {
                    Object obj = m42427b(entry);
                    if (obj instanceof JSONArray) {
                        jsnObj.put("files", m42427b(entry));
                    } else if (obj instanceof JSONObject) {
                        jsnObj.put(entry.getName(), m42427b(entry));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    C12999b bVar = new C12999b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                    sb.append(e.getStackTrace()[0].getMethodName());
                    bVar.execute(new String[]{sb.toString()});
                }
            }
        }
        return jsnObj;
    }

    /* renamed from: b */
    private static Object m42427b(File file) {
        File[] listFiles;
        JSONObject arr = new JSONObject();
        JSONArray tempArr = new JSONArray();
        try {
            if (file.isFile()) {
                tempArr.put(file.getName());
                return tempArr;
            }
            for (File fileEntry : file.listFiles()) {
                if (fileEntry.isDirectory()) {
                    arr.put(fileEntry.getName(), m42427b(fileEntry));
                } else {
                    tempArr.put(fileEntry.getName());
                    arr.put("files", tempArr);
                }
            }
            if (file.isDirectory()) {
                String lastUpdate = C13001d.m42395g().mo41891a(file.getName());
                if (lastUpdate != null) {
                    arr.put("lastUpdateTime", lastUpdate);
                }
            }
            String product = file.getName().toLowerCase();
            C10895h type = null;
            if (product.startsWith(C10895h.RewardedVideo.toString().toLowerCase())) {
                type = C10895h.RewardedVideo;
            } else if (product.startsWith(C10895h.OfferWall.toString().toLowerCase())) {
                type = C10895h.OfferWall;
            } else if (product.startsWith(C10895h.Interstitial.toString().toLowerCase())) {
                type = C10895h.Interstitial;
            }
            if (type != null) {
                arr.put(C13004g.m42443a("applicationUserId"), C13004g.m42443a(C13001d.m42395g().mo41899b(type)));
                arr.put(C13004g.m42443a("applicationKey"), C13004g.m42443a(C13001d.m42395g().mo41890a(type)));
            }
            return arr;
        } catch (JSONException e) {
            e.printStackTrace();
            C12999b bVar = new C12999b();
            StringBuilder sb = new StringBuilder();
            sb.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            sb.append(e.getStackTrace()[0].getMethodName());
            bVar.execute(new String[]{sb.toString()});
        }
    }

    /* renamed from: e */
    public static boolean m42433e(String fromName, String toName) throws Exception {
        return new File(fromName).renameTo(new File(toName));
    }

    /* renamed from: a */
    public static int m42419a(byte[] data, String destFileName) throws Exception {
        int totalBytesRead = 0;
        FileOutputStream fos = new FileOutputStream(new File(destFileName));
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try {
            byte[] buffer = new byte[102400];
            while (true) {
                int read = bais.read(buffer);
                int bytesRead = read;
                if (read == -1) {
                    return totalBytesRead;
                }
                fos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
        } finally {
            fos.close();
            bais.close();
        }
    }
}
