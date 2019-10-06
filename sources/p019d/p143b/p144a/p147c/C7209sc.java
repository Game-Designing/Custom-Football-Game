package p019d.p143b.p144a.p147c;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.sc */
public class C7209sc extends C7269s {

    /* renamed from: b */
    private static final char[] f13957b = "0123456789abcdef".toCharArray();

    /* renamed from: c */
    private static final char[] f13958c = "-'".toCharArray();

    /* renamed from: a */
    public static double m15459a(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return d / 1000.0d;
    }

    /* renamed from: a */
    public static float m15460a(float f) {
        return f * 1000.0f;
    }

    /* renamed from: a */
    public static int m15461a(String str, int i) {
        return m15490e(str) ? Integer.parseInt(str) : i;
    }

    /* renamed from: a */
    public static int m15462a(JSONObject jSONObject) {
        int a = C7167ia.m15254a(jSONObject, "video_completion_percent", -1, (C7267q) null);
        if (a < 0 || a > 100) {
            return 95;
        }
        return a;
    }

    /* renamed from: a */
    public static Activity m15463a(View view, C7267q qVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                qVar.mo23049b().mo22917b("AppLovinUtils", "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Bitmap m15464a(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Options options;
        FileInputStream fileInputStream3 = null;
        try {
            Options options2 = new Options();
            int i2 = 1;
            options2.inJustDecodeBounds = true;
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream, null, options2);
                fileInputStream.close();
                if (options2.outHeight > i || options2.outWidth > i) {
                    double d = (double) i;
                    double max = (double) Math.max(options2.outHeight, options2.outWidth);
                    Double.isNaN(d);
                    Double.isNaN(max);
                    i2 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(d / max) / Math.log(0.5d))));
                }
                options = new Options();
                options.inSampleSize = i2;
                fileInputStream2 = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream2 = null;
                try {
                    fileInputStream.close();
                    fileInputStream2.close();
                } catch (Exception e2) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                try {
                    fileInputStream.close();
                    fileInputStream3.close();
                } catch (Exception e3) {
                }
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                fileInputStream2.close();
                try {
                    fileInputStream.close();
                    fileInputStream2.close();
                } catch (Exception e4) {
                }
                return decodeStream;
            } catch (Exception e5) {
                fileInputStream.close();
                fileInputStream2.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream2;
                fileInputStream.close();
                fileInputStream3.close();
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream2 = null;
            fileInputStream = null;
            fileInputStream.close();
            fileInputStream2.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileInputStream.close();
            fileInputStream3.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static C7059Ec m15465a(JSONObject jSONObject, C7142c cVar) {
        return C7059Ec.m14671a(C7257g.m15776a(C7167ia.m15258a(jSONObject, "ad_size", (String) null, (C7267q) cVar)), C7258h.m15781a(C7167ia.m15258a(jSONObject, "ad_type", (String) null, (C7267q) cVar)), C7063Fc.m14702a(C7167ia.m15258a(jSONObject, "type", C7063Fc.f13210b.toString(), (C7267q) cVar)), C7167ia.m15258a(jSONObject, "zone_id", (String) null, (C7267q) cVar), cVar);
    }

    /* renamed from: a */
    public static C7251a m15466a(C7251a aVar, C7267q qVar) {
        if (!(aVar instanceof C7048C)) {
            return aVar;
        }
        C7048C c = (C7048C) aVar;
        C7251a a = ((C7134a) qVar.mo23037a()).mo23002a(c.mo22762n());
        C7262l b = qVar.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Dequeued ad for dummy ad: ");
        sb.append(a);
        b.mo22918c("AppLovinUtils", sb.toString());
        if (a != null) {
            c.mo22757a(a);
            ((C7071Hc) a).mo22844a(c);
        }
        return a;
    }

    /* renamed from: a */
    public static String m15467a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (i > str.length()) {
            i = str.length();
        }
        return str.substring(0, i);
    }

    /* renamed from: a */
    public static String m15468a(String str, C7142c cVar) {
        return m15469a(str, (Integer) cVar.mo23039a(C7196pb.f13902x), (String) cVar.mo23039a(C7196pb.f13897w));
    }

    /* renamed from: a */
    private static String m15469a(String str, Integer num, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("No algorithm specified");
        } else if (str == null || str.length() < 1) {
            return "";
        } else {
            if (str2.length() < 1 || "none".equals(str2)) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes("UTF-8"));
                String a = m15472a(instance.digest());
                if (a != null && num.intValue() > 0) {
                    a = a.substring(0, Math.min(num.intValue(), a.length()));
                }
                return a;
            } catch (NoSuchAlgorithmException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown algorithm \"");
                sb.append(str2);
                sb.append("\"");
                throw new RuntimeException(sb.toString(), e);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Programming error: UTF-8 is not know encoding", e2);
            }
        }
    }

    /* renamed from: a */
    public static String m15470a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return str2.replace("{PLACEMENT}", m15487d(str));
    }

    /* renamed from: a */
    static String m15471a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m15472a(byte[] bArr) {
        if (bArr != null) {
            char[] cArr = new char[(bArr.length * 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                char[] cArr2 = f13957b;
                cArr[i2] = cArr2[(bArr[i] & 240) >>> 4];
                cArr[i2 + 1] = cArr2[bArr[i] & 15];
            }
            return new String(cArr);
        }
        throw new IllegalArgumentException("No data specified");
    }

    /* renamed from: a */
    public static void m15473a(C7254d dVar, C7059Ec ec, int i, C7267q qVar) {
        if (dVar != null) {
            try {
                if (dVar instanceof C7060F) {
                    ((C7060F) dVar).mo22816a(ec, i);
                } else {
                    dVar.failedToReceiveAd(i);
                }
            } catch (Throwable th) {
                qVar.mo23049b().mo22917b("AppLovinUtils", "Unable process a failure to receive an ad", th);
            }
        }
    }

    /* renamed from: a */
    static void m15474a(String str, Boolean bool, Map<String, String> map) {
        if (bool.booleanValue()) {
            map.put(str, Boolean.toString(true));
        }
    }

    /* renamed from: a */
    static void m15475a(String str, String str2, Map<String, String> map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static boolean m15476a() {
        Context B = C7142c.m15040B();
        if (B == null) {
            return false;
        }
        Bundle e = m15489e(B);
        return e != null && e.containsKey("applovin.sdk.verbose_logging");
    }

    /* renamed from: a */
    public static boolean m15477a(int i, int i2) {
        return (i & i2) != 0;
    }

    /* renamed from: a */
    public static boolean m15478a(C7234z zVar, Context context, C7142c cVar) {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        boolean z = zVar != null && (zVar.mo22405ha() || zVar.mo22407ia() == null || cVar.mo23072q().mo22833a(zVar.mo22407ia().getLastPathSegment(), context));
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z;
    }

    /* renamed from: a */
    public static boolean m15479a(C7251a aVar, C7142c cVar) {
        C7262l b;
        String str;
        String str2 = "AppLovinUtils";
        if (aVar == null) {
            b = cVar.mo23049b();
            str = "Failing ad display - ad is null.";
        } else if (((C7071Hc) aVar).mo22760g() == C7063Fc.f13210b || C7202r.m15406a(cVar.mo23068m(), cVar) || ((Boolean) cVar.mo23039a(C7196pb.f13697Gc)).booleanValue()) {
            return true;
        } else {
            b = cVar.mo23049b();
            str = "Failing ad display due to no internet connection.";
        }
        b.mo22921e(str2, str);
        return false;
    }

    /* renamed from: a */
    public static boolean m15480a(String str, List<String> list) {
        for (String startsWith : list) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m15481b(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                Configuration configuration = resources.getConfiguration();
                if (configuration != null) {
                    return configuration.orientation;
                }
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static long m15482b(float f) {
        return (long) Math.round(f);
    }

    /* renamed from: b */
    public static String m15483b(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    /* renamed from: c */
    public static long m15484c(float f) {
        return m15482b(m15460a(f));
    }

    /* renamed from: c */
    public static String m15485c(String str) {
        return m15469a(str, Integer.valueOf(-1), "SHA-1");
    }

    /* renamed from: c */
    public static boolean m15486c(Context context) {
        if (context == null) {
            context = C7142c.m15040B();
        }
        if (context == null) {
            return false;
        }
        Bundle e = m15489e(context);
        return e != null && e.getBoolean("applovin.sdk.test_ads", false);
    }

    /* renamed from: d */
    public static String m15487d(String str) {
        if (!C7269s.m15819a(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /* renamed from: d */
    public static boolean m15488d(Context context) {
        if (context == null) {
            context = C7142c.m15040B();
        }
        if (context == null) {
            return false;
        }
        Bundle e = m15489e(context);
        return e != null && e.getBoolean("applovin.sdk.verbose_logging", false);
    }

    /* renamed from: e */
    public static Bundle m15489e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NameNotFoundException e) {
            Log.e("AppLovinSdk", "Unable to retrieve application metadata", e);
            return null;
        }
    }

    /* renamed from: e */
    public static boolean m15490e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i = (charAt == '-' || charAt == '+') ? 1 : 0;
        int length = str.length();
        if (i == 1 && length == 1) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: f */
    public static int m15491f(String str) {
        return m15461a(str, 0);
    }
}
