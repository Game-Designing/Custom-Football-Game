package com.flurry.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.flurry.sdk.Ad */
public final class C7354Ad {

    /* renamed from: a */
    private static final String f14374a = C7354Ad.class.getSimpleName();

    /* renamed from: a */
    public static void m16260a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    /* renamed from: a */
    public static String m16258a(String str) {
        if (TextUtils.isEmpty(str) || Uri.parse(str).getScheme() != null) {
            return str;
        }
        return "http://".concat(String.valueOf(str));
    }

    /* renamed from: b */
    public static String m16265b(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 255) {
            return str;
        }
        return str.substring(0, 255);
    }

    /* renamed from: c */
    public static String m16266c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = f14374a;
            StringBuilder sb = new StringBuilder("Cannot encode '");
            sb.append(str);
            sb.append("'");
            C7513ec.m16639a(5, str2, sb.toString());
            return "";
        }
    }

    /* renamed from: a */
    public static void m16261a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: d */
    public static byte[] m16267d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = f14374a;
            StringBuilder sb = new StringBuilder("Unsupported UTF-8: ");
            sb.append(e.getMessage());
            C7513ec.m16639a(5, str2, sb.toString());
            return null;
        }
    }

    /* renamed from: e */
    public static byte[] m16268e(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i += 2) {
            StringBuilder sb = new StringBuilder(2);
            sb.append(charArray[i]);
            sb.append(charArray[i + 1]);
            bArr[i / 2] = (byte) Integer.parseInt(sb.toString(), 16);
        }
        return bArr;
    }

    /* renamed from: a */
    public static boolean m16262a(int i) {
        return VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    public static String m16259a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            String str = f14374a;
            StringBuilder sb = new StringBuilder("Unsupported ISO-8859-1:");
            sb.append(e.getMessage());
            C7513ec.m16639a(5, str, sb.toString());
            return null;
        }
    }

    /* renamed from: f */
    public static long m16269f(String str) {
        if (str == null) {
            return 0;
        }
        long j = 1125899906842597L;
        for (int i = 0; i < str.length(); i++) {
            j = (j * 31) + ((long) str.charAt(i));
        }
        return j;
    }

    /* renamed from: a */
    public static byte[] m16264a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m16257a(inputStream, (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static long m16257a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[Opcodes.ACC_ABSTRACT];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static double m16256a(double d, int i) {
        if (i == -1) {
            return d;
        }
        double d2 = (double) i;
        double round = (double) Math.round(d * Math.pow(10.0d, d2));
        double pow = Math.pow(10.0d, d2);
        Double.isNaN(round);
        return round / pow;
    }

    /* renamed from: a */
    public static boolean m16263a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            String str2 = f14374a;
            StringBuilder sb = new StringBuilder("Error occured when checking if app has permission.  Error: ");
            sb.append(e.getMessage());
            C7513ec.m16639a(6, str2, sb.toString());
            return false;
        }
    }
}
