package p019d.p314k.p315a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;
import com.tonyodev.fetch.exception.NotUsableException;
import com.tonyodev.fetch.request.Header;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p314k.p315a.p317b.C13157a;
import p019d.p314k.p315a.p317b.C13159c;

/* renamed from: d.k.a.t */
/* compiled from: Utils */
final class C13178t {
    /* renamed from: a */
    static boolean m43095a(long startTime, long stopTime, long onUpdateInterval) {
        if (TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) >= onUpdateInterval) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static int m43087a(long downloadedBytes, long fileSize) {
        if (fileSize < 1 || downloadedBytes < 1) {
            return 0;
        }
        if (downloadedBytes >= fileSize) {
            return 100;
        }
        double d = (double) downloadedBytes;
        double d2 = (double) fileSize;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (int) ((d / d2) * 100.0d);
    }

    /* renamed from: b */
    static String m43099b(List<C13157a> headers, boolean loggingEnabled) {
        String headerString;
        if (headers == null) {
            return "{}";
        }
        try {
            JSONObject headerObject = new JSONObject();
            for (C13157a header : headers) {
                headerObject.put(header.mo42192a(), header.mo42193b());
            }
            headerString = headerObject.toString();
        } catch (JSONException e) {
            if (loggingEnabled) {
                e.printStackTrace();
            }
            headerString = "{}";
        }
        return headerString;
    }

    /* renamed from: a */
    static List<C13157a> m43092a(String headers, boolean loggingEnabled) {
        List<Header> headerList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(headers);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                headerList.add(new C13157a(key, jsonObject.getString(key)));
            }
        } catch (JSONException e) {
            if (loggingEnabled) {
                e.printStackTrace();
            }
        }
        return headerList;
    }

    /* renamed from: b */
    static boolean m43101b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = false;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    static boolean m43096a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: b */
    static boolean m43102b(String path) throws IOException, NullPointerException {
        File file = new File(path);
        if (!file.exists()) {
            return file.createNewFile();
        }
        return true;
    }

    /* renamed from: a */
    static boolean m43097a(String path) throws NullPointerException {
        File dir = new File(path);
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return true;
    }

    /* renamed from: d */
    static boolean m43105d(String filePath) {
        return new File(filePath).delete();
    }

    /* renamed from: g */
    static long m43108g(String filePath) {
        return new File(filePath).length();
    }

    /* renamed from: e */
    static boolean m43106e(String filePath) {
        return new File(filePath).exists();
    }

    /* renamed from: f */
    static File m43107f(String filePath) {
        return new File(filePath);
    }

    /* renamed from: c */
    static void m43104c(String filePath) throws IOException, NullPointerException {
        File file = m43107f(filePath);
        boolean parentDirCreated = m43097a(file.getParentFile().getAbsolutePath());
        boolean fileCreated = m43102b(file.getAbsolutePath());
        if (!parentDirCreated || !fileCreated) {
            StringBuilder sb = new StringBuilder();
            sb.append("File could not be created for the filePath:");
            sb.append(filePath);
            throw new IOException(sb.toString());
        }
    }

    /* renamed from: a */
    static void m43094a(C13163f fetch) {
        if (fetch == null) {
            throw new NullPointerException("Fetch cannot be null");
        } else if (fetch.mo42215a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fetch instance: ");
            sb.append(fetch.toString());
            sb.append(" cannot be reused after calling its release() method.Call Fetch.getInstance() for a new instance of Fetch.");
            throw new NotUsableException(sb.toString(), -115);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r4 != false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        if (r4 != false) goto L_0x001d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static p019d.p314k.p315a.p317b.C13159c m43098b(android.database.Cursor r3, boolean r4, boolean r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0038
            boolean r1 = r3.isClosed()     // Catch:{ Exception -> 0x0023 }
            if (r1 != 0) goto L_0x0038
            int r1 = r3.getCount()     // Catch:{ Exception -> 0x0023 }
            r2 = 1
            if (r1 >= r2) goto L_0x0011
            goto L_0x0038
        L_0x0011:
            r3.moveToFirst()     // Catch:{ Exception -> 0x0023 }
            d.k.a.b.c r1 = m43089a(r3, r5)     // Catch:{ Exception -> 0x0023 }
            r0 = r1
            if (r3 == 0) goto L_0x0037
            if (r4 == 0) goto L_0x0037
        L_0x001d:
            r3.close()
            goto L_0x0037
        L_0x0021:
            r1 = move-exception
            goto L_0x002a
        L_0x0023:
            r1 = move-exception
            if (r5 == 0) goto L_0x0032
            r1.printStackTrace()     // Catch:{ all -> 0x0021 }
            goto L_0x0032
        L_0x002a:
            if (r3 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0031
            r3.close()
        L_0x0031:
            throw r1
        L_0x0032:
            if (r3 == 0) goto L_0x0037
            if (r4 == 0) goto L_0x0037
            goto L_0x001d
        L_0x0037:
            return r0
        L_0x0038:
            if (r3 == 0) goto L_0x0040
            if (r4 == 0) goto L_0x0040
            r3.close()
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13178t.m43098b(android.database.Cursor, boolean, boolean):d.k.a.b.c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r4 != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        if (r4 != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        r3.close();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<p019d.p314k.p315a.p317b.C13159c> m43103c(android.database.Cursor r3, boolean r4, boolean r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0047
            boolean r1 = r3.isClosed()     // Catch:{ Exception -> 0x0030 }
            if (r1 != 0) goto L_0x0047
            int r1 = r3.getCount()     // Catch:{ Exception -> 0x0030 }
            r2 = 1
            if (r1 >= r2) goto L_0x0015
            goto L_0x0047
        L_0x0015:
            r3.moveToFirst()     // Catch:{ Exception -> 0x0030 }
        L_0x0018:
            boolean r1 = r3.isAfterLast()     // Catch:{ Exception -> 0x0030 }
            if (r1 != 0) goto L_0x0029
            d.k.a.b.c r1 = m43089a(r3, r5)     // Catch:{ Exception -> 0x0030 }
            r0.add(r1)     // Catch:{ Exception -> 0x0030 }
            r3.moveToNext()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0018
        L_0x0029:
            if (r3 == 0) goto L_0x0046
            if (r4 == 0) goto L_0x0046
            goto L_0x0043
        L_0x002e:
            r1 = move-exception
            goto L_0x0037
        L_0x0030:
            r1 = move-exception
            if (r5 == 0) goto L_0x003f
            r1.printStackTrace()     // Catch:{ all -> 0x002e }
            goto L_0x003f
        L_0x0037:
            if (r3 == 0) goto L_0x003e
            if (r4 == 0) goto L_0x003e
            r3.close()
        L_0x003e:
            throw r1
        L_0x003f:
            if (r3 == 0) goto L_0x0046
            if (r4 == 0) goto L_0x0046
        L_0x0043:
            r3.close()
        L_0x0046:
            return r0
        L_0x0047:
            if (r3 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x004f
            r3.close()
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13178t.m43103c(android.database.Cursor, boolean, boolean):java.util.List");
    }

    /* renamed from: a */
    static C13159c m43089a(Cursor cursor, boolean loggingEnabled) {
        Cursor cursor2 = cursor;
        if (cursor2 == null || cursor.isClosed() || cursor.getCount() < 1) {
            return null;
        }
        long id = cursor2.getLong(0);
        int status = cursor2.getInt(3);
        String url = cursor2.getString(1);
        String filePath = cursor2.getString(2);
        int error = cursor2.getInt(7);
        long fileSize = cursor2.getLong(6);
        int priority = cursor2.getInt(8);
        long downloadedBytes = cursor2.getLong(5);
        String headers = cursor2.getString(4);
        String str = headers;
        long j = downloadedBytes;
        long j2 = fileSize;
        C13159c cVar = new C13159c(id, status, url, filePath, m43087a(downloadedBytes, fileSize), downloadedBytes, fileSize, error, m43092a(headers, loggingEnabled), priority);
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a2, code lost:
        if (r20 != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
        if (r20 != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
        r19.close();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.ArrayList<android.os.Bundle> m43091a(android.database.Cursor r19, boolean r20, boolean r21) {
        /*
            r1 = r19
            r2 = r21
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = r0
            if (r1 == 0) goto L_0x00be
            boolean r0 = r19.isClosed()     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x0014
            goto L_0x00be
        L_0x0014:
            r19.moveToFirst()     // Catch:{ Exception -> 0x00a7 }
        L_0x0017:
            boolean r0 = r19.isAfterLast()     // Catch:{ Exception -> 0x00a7 }
            if (r0 != 0) goto L_0x00a0
            r0 = 0
            long r4 = r1.getLong(r0)     // Catch:{ Exception -> 0x00a7 }
            r0 = 3
            int r0 = r1.getInt(r0)     // Catch:{ Exception -> 0x00a7 }
            r6 = 1
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x00a7 }
            r7 = 2
            java.lang.String r7 = r1.getString(r7)     // Catch:{ Exception -> 0x00a7 }
            r8 = 7
            int r8 = r1.getInt(r8)     // Catch:{ Exception -> 0x00a7 }
            r9 = 6
            long r9 = r1.getLong(r9)     // Catch:{ Exception -> 0x00a7 }
            r11 = 8
            int r11 = r1.getInt(r11)     // Catch:{ Exception -> 0x00a7 }
            r12 = 5
            long r12 = r1.getLong(r12)     // Catch:{ Exception -> 0x00a7 }
            r14 = 4
            java.lang.String r14 = r1.getString(r14)     // Catch:{ Exception -> 0x00a7 }
            java.util.ArrayList r15 = m43100b(r14, r2)     // Catch:{ Exception -> 0x00a7 }
            int r16 = m43087a(r12, r9)     // Catch:{ Exception -> 0x00a7 }
            r17 = r16
            android.os.Bundle r16 = new android.os.Bundle     // Catch:{ Exception -> 0x00a7 }
            r16.<init>()     // Catch:{ Exception -> 0x00a7 }
            r18 = r16
            r16 = r14
            java.lang.String r14 = "com.tonyodev.fetch.extra_id"
            r2 = r18
            r2.putLong(r14, r4)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_status"
            r2.putInt(r14, r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_url"
            r2.putString(r14, r6)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_file_path"
            r2.putString(r14, r7)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_error"
            r2.putInt(r14, r8)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_downloaded_bytes"
            r2.putLong(r14, r12)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_file_size"
            r2.putLong(r14, r9)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_progress"
            r18 = r0
            r0 = r17
            r2.putInt(r14, r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_priority"
            r2.putInt(r14, r11)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r14 = "com.tonyodev.fetch.extra_headers"
            r2.putParcelableArrayList(r14, r15)     // Catch:{ Exception -> 0x00a7 }
            r3.add(r2)     // Catch:{ Exception -> 0x00a7 }
            r19.moveToNext()     // Catch:{ Exception -> 0x00a7 }
            r2 = r21
            goto L_0x0017
        L_0x00a0:
            if (r1 == 0) goto L_0x00bd
            if (r20 == 0) goto L_0x00bd
            goto L_0x00ba
        L_0x00a5:
            r0 = move-exception
            goto L_0x00ae
        L_0x00a7:
            r0 = move-exception
            if (r21 == 0) goto L_0x00b6
            r0.printStackTrace()     // Catch:{ all -> 0x00a5 }
            goto L_0x00b6
        L_0x00ae:
            if (r1 == 0) goto L_0x00b5
            if (r20 == 0) goto L_0x00b5
            r19.close()
        L_0x00b5:
            throw r0
        L_0x00b6:
            if (r1 == 0) goto L_0x00bd
            if (r20 == 0) goto L_0x00bd
        L_0x00ba:
            r19.close()
        L_0x00bd:
            return r3
        L_0x00be:
            if (r1 == 0) goto L_0x00c6
            if (r20 == 0) goto L_0x00c6
            r19.close()
        L_0x00c6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13178t.m43091a(android.database.Cursor, boolean, boolean):java.util.ArrayList");
    }

    /* renamed from: a */
    static long m43088a() {
        return System.nanoTime();
    }

    /* renamed from: a */
    static void m43093a(C0515e broadcastManager, long id, int status, int progress, long downloadedBytes, long fileSize, int error) {
        if (broadcastManager != null) {
            Intent intent = new Intent("com.tonyodev.fetch.event_action_update");
            intent.putExtra("com.tonyodev.fetch.extra_id", id);
            intent.putExtra("com.tonyodev.fetch.extra_status", status);
            intent.putExtra("com.tonyodev.fetch.extra_progress", progress);
            intent.putExtra("com.tonyodev.fetch.extra_downloaded_bytes", downloadedBytes);
            intent.putExtra("com.tonyodev.fetch.extra_file_size", fileSize);
            intent.putExtra("com.tonyodev.fetch.extra_error", error);
            broadcastManager.mo5314a(intent);
        }
    }

    /* renamed from: b */
    static ArrayList<Bundle> m43100b(String headers, boolean loggingEnabled) {
        ArrayList<Bundle> headerList = new ArrayList<>();
        if (headers == null) {
            return headerList;
        }
        try {
            JSONObject jsonObject = new JSONObject(headers);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Bundle bundle = new Bundle();
                bundle.putString("com.tonyodev.fetch.extra_header_name", key);
                bundle.putString("com.tonyodev.fetch.extra_header_value", jsonObject.getString(key));
                headerList.add(bundle);
            }
        } catch (JSONException e) {
            if (loggingEnabled) {
                e.printStackTrace();
            }
        }
        return headerList;
    }

    /* renamed from: a */
    static String m43090a(List<Bundle> headers, boolean loggingEnabled) {
        if (headers == null) {
            return "{}";
        }
        JSONObject headerObject = new JSONObject();
        try {
            for (Bundle headerBundle : headers) {
                String headerName = headerBundle.getString("com.tonyodev.fetch.extra_header_name");
                String headerValue = headerBundle.getString("com.tonyodev.fetch.extra_header_value");
                if (headerValue == null) {
                    headerValue = "";
                }
                if (headerName != null) {
                    headerObject.put(headerName, headerValue);
                }
            }
            return headerObject.toString();
        } catch (JSONException e) {
            if (loggingEnabled) {
                e.printStackTrace();
            }
            return "{}";
        }
    }
}
