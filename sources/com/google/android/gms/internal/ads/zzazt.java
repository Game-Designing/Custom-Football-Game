package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

@zzard
public final class zzazt {

    /* renamed from: a */
    public static final Handler f25042a = new zzdbh(Looper.getMainLooper());

    /* renamed from: b */
    private static final String f25043b = AdView.class.getName();

    /* renamed from: c */
    private static final String f25044c = InterstitialAd.class.getName();

    /* renamed from: d */
    private static final String f25045d = PublisherAdView.class.getName();

    /* renamed from: e */
    private static final String f25046e = PublisherInterstitialAd.class.getName();

    /* renamed from: f */
    private static final String f25047f = SearchAdView.class.getName();

    /* renamed from: g */
    private static final String f25048g = AdLoader.class.getName();

    /* renamed from: h */
    private float f25049h = -1.0f;

    /* renamed from: a */
    public static void m26310a(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static int m26302a(Context context, int i) {
        return m26303a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m26303a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: b */
    public final int mo30315b(Context context, int i) {
        if (this.f25049h < 0.0f) {
            synchronized (this) {
                if (this.f25049h < 0.0f) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.f25049h = displayMetrics.density;
                }
            }
        }
        return Math.round(((float) i) / this.f25049h);
    }

    /* renamed from: b */
    public static int m26312b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    /* renamed from: a */
    public final void mo30314a(ViewGroup viewGroup, zzyd zzyd, String str, String str2) {
        zzbad.m26359d(str2);
        m26309a(viewGroup, zzyd, str, -65536, (int) CtaButton.BACKGROUND_COLOR);
    }

    /* renamed from: a */
    public final void mo30313a(ViewGroup viewGroup, zzyd zzyd, String str) {
        m26309a(viewGroup, zzyd, str, (int) CtaButton.BACKGROUND_COLOR, -1);
    }

    /* renamed from: a */
    private final void m26309a(ViewGroup viewGroup, zzyd zzyd, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m26302a(context, 3);
            frameLayout.addView(textView, new LayoutParams(zzyd.f29773f - a, zzyd.f29770c - a, 17));
            viewGroup.addView(frameLayout, zzyd.f29773f, zzyd.f29770c);
        }
    }

    /* renamed from: a */
    public static String m26304a(Context context) {
        String str;
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Secure.getString(contentResolver, "android_id");
        }
        if (str == null || m26311a()) {
            str = "emulator";
        }
        return m26305a(str);
    }

    /* renamed from: b */
    public static String m26313b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Secure.getString(contentResolver, "android_id");
    }

    /* renamed from: a */
    public static boolean m26311a() {
        return Build.DEVICE.startsWith("generic");
    }

    /* renamed from: b */
    public static boolean m26314b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: a */
    public static String m26305a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            } catch (ArithmeticException e2) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m26318c(Context context, int i) {
        return GoogleApiAvailabilityLight.getInstance().mo27294a(context, i) == 0;
    }

    /* renamed from: c */
    public static boolean m26317c(Context context) {
        int a = GoogleApiAvailabilityLight.getInstance().mo27294a(context, 12451000);
        if (a == 0 || a == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m26319d(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600) {
            return true;
        }
        return false;
    }

    @TargetApi(17)
    /* renamed from: e */
    public static boolean m26320e(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (PlatformVersion.m22110d()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.heightPixels;
            i = displayMetrics.widthPixels;
        } else {
            try {
                i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        int i4 = displayMetrics.widthPixels;
        if (i3 == i2 && i4 == i) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static int m26321f(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @VisibleForTesting
    /* renamed from: a */
    public static String m26306a(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        String str2;
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            if (i >= stackTraceElementArr.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className = stackTraceElement.getClassName();
            if (!"loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) || (!f25043b.equalsIgnoreCase(className) && !f25044c.equalsIgnoreCase(className) && !f25045d.equalsIgnoreCase(className) && !f25046e.equalsIgnoreCase(className) && !f25047f.equalsIgnoreCase(className) && !f25048g.equalsIgnoreCase(className))) {
                i2 = i;
            }
        }
        str2 = stackTraceElementArr[i].getClassName();
        if (str != null) {
            String str3 = ".";
            StringTokenizer stringTokenizer = new StringTokenizer(str, str3);
            StringBuilder sb = new StringBuilder();
            int i3 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0 || !stringTokenizer.hasMoreElements()) {
                        str = sb.toString();
                    } else {
                        sb.append(str3);
                        sb.append(stringTokenizer.nextToken());
                        i3 = i4;
                    }
                }
                str = sb.toString();
            }
            if (str2 == null || str2.contains(str)) {
                return null;
            }
            return str2;
        }
        return null;
    }

    /* renamed from: a */
    public final void mo30312a(Context context, String str, String str2, Bundle bundle, boolean z) {
        m26308a(context, str, str2, bundle, true, new C8826Ec(this));
    }

    /* renamed from: a */
    public static void m26308a(Context context, String str, String str2, Bundle bundle, boolean z, zzazw zzazw) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", VERSION.RELEASE);
        bundle.putString("api", String.valueOf(VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            int b = GoogleApiAvailabilityLight.getInstance().mo27314b(context);
            StringBuilder sb = new StringBuilder(23);
            sb.append(b);
            sb.append(".15000000");
            str = sb.toString();
        }
        bundle.putString("js", str);
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzazw.mo28178a(appendQueryParameter.toString());
    }

    /* renamed from: c */
    public static String m26316c() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    /* renamed from: a */
    public static Throwable m26307a(Throwable th) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24136n)).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th3.getStackTrace();
            ArrayList arrayList = new ArrayList();
            String str = "<filtered>";
            arrayList.add(new StackTraceElement(th3.getClass().getName(), str, str, 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (m26315b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                        arrayList.add(stackTraceElement);
                    } else {
                        arrayList.add(new StackTraceElement(str, str, str, 1));
                    }
                }
            }
            if (z) {
                if (th2 == null) {
                    th2 = new Throwable(th3.getMessage());
                } else {
                    th2 = new Throwable(th3.getMessage(), th2);
                }
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th2;
    }

    @VisibleForTesting
    /* renamed from: b */
    public static boolean m26315b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzyt.m31536e().mo29599a(zzacu.f24142o))) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzard.class);
        } catch (Exception e) {
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            zzbad.m26353a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
            return false;
        }
    }
}
