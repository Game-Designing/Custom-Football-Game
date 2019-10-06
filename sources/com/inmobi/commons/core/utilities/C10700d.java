package com.inmobi.commons.core.utilities;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p217a.C10619a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.inmobi.commons.core.utilities.d */
/* compiled from: NetworkUtils */
public class C10700d {

    /* renamed from: a */
    private static final String f32656a = C10700d.class.getSimpleName();

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static boolean m35146a() {
        boolean z = false;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C10619a.m34839b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && !m35149b()) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in checking network availability; ").append(e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m35149b() {
        try {
            PowerManager powerManager = (PowerManager) C10619a.m34839b().getSystemService("power");
            if (VERSION.SDK_INT > 22) {
                return powerManager.isDeviceIdleMode();
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in checking idle mode; ").append(e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static String m35143a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(str);
            }
            sb.append(String.format(Locale.US, "%s=%s", new Object[]{m35141a((String) entry.getKey()), m35141a((String) entry.getValue())}));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m35141a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m35145a(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (Entry entry : map.entrySet()) {
                if (!(entry.getValue() == null || ((String) entry.getValue()).trim().length() == 0 || entry.getKey() == null || ((String) entry.getKey()).trim().length() == 0)) {
                    hashMap.put(((String) entry.getKey()).trim(), ((String) entry.getValue()).trim());
                }
            }
            map.clear();
            map.putAll(hashMap);
        }
    }

    /* renamed from: a */
    public static String m35142a(String str, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return str;
    }

    /* renamed from: a */
    public static byte[] m35148a(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] a = m35147a((InputStream) gZIPInputStream);
                m35144a((Closeable) byteArrayInputStream);
                m35144a((Closeable) gZIPInputStream);
                return a;
            } catch (IOException e) {
                e = e;
                try {
                    Logger.m35066a(InternalLogLevel.DEBUG, f32656a, "Failed to decompress response", e);
                    m35144a((Closeable) byteArrayInputStream);
                    m35144a((Closeable) gZIPInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    m35144a((Closeable) byteArrayInputStream);
                    m35144a((Closeable) gZIPInputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            gZIPInputStream = null;
            Logger.m35066a(InternalLogLevel.DEBUG, f32656a, "Failed to decompress response", e);
            m35144a((Closeable) byteArrayInputStream);
            m35144a((Closeable) gZIPInputStream);
            return null;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            gZIPInputStream = null;
            th = th3;
            m35144a((Closeable) byteArrayInputStream);
            m35144a((Closeable) gZIPInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m35147a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Opcodes.ACC_SYNTHETIC];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                byteArrayOutputStream.close();
            }
        }
    }

    /* renamed from: a */
    public static void m35144a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
