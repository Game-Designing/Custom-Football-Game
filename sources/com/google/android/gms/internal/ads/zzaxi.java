package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.impl.C8581R;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzaxi {

    /* renamed from: a */
    public static final Handler f24961a = new zzaxa(Looper.getMainLooper());

    /* renamed from: b */
    private AtomicReference<Pattern> f24962b = new AtomicReference<>(null);

    /* renamed from: c */
    private AtomicReference<Pattern> f24963c = new AtomicReference<>(null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f24964d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f24965e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f24966f;

    /* renamed from: g */
    private boolean f24967g = false;

    /* renamed from: h */
    private boolean f24968h = false;

    /* renamed from: a */
    public final void mo30233a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", mo30237b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static boolean m26116a(Context context, String str) {
        Context b = zzasq.m25744b(context);
        return Wrappers.m22139a(b).mo27943a(str, b.getPackageName()) == 0;
    }

    /* renamed from: a */
    public static void m26111a(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            new zzazi(context, str, (String) obj).mo30195b();
        }
    }

    /* renamed from: a */
    public static String m26106a(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(Opcodes.ACC_ANNOTATION);
        char[] cArr = new char[Opcodes.ACC_STRICT];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    /* renamed from: a */
    public final boolean mo30234a(Context context) {
        if (this.f24967g) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new C9465hc(this, null), intentFilter);
        this.f24967g = true;
        return true;
    }

    /* renamed from: b */
    public final boolean mo30238b(Context context) {
        if (this.f24968h) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new C9443gc(this, null), intentFilter);
        this.f24968h = true;
        return true;
    }

    /* renamed from: a */
    public final void mo30231a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(mo30237b(context, str));
    }

    /* renamed from: d */
    private static String m26132d() {
        StringBuilder sb = new StringBuilder(Opcodes.ACC_NATIVE);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(VERSION.RELEASE);
        }
        String str = "; ";
        sb.append(str);
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append(str);
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    /* renamed from: b */
    public final String mo30237b(Context context, String str) {
        synchronized (this.f24965e) {
            if (this.f24966f != null) {
                String str2 = this.f24966f;
                return str2;
            } else if (str == null) {
                String d = m26132d();
                return d;
            } else {
                try {
                    this.f24966f = zzk.zzli().mo30249a(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.f24966f)) {
                    zzyt.m31532a();
                    if (!zzazt.m26314b()) {
                        this.f24966f = null;
                        f24961a.post(new C9399ec(this, context));
                        while (this.f24966f == null) {
                            try {
                                this.f24965e.wait();
                            } catch (InterruptedException e2) {
                                this.f24966f = m26132d();
                                String str3 = "Interrupted, use default user agent: ";
                                String valueOf = String.valueOf(this.f24966f);
                                zzbad.m26359d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                            }
                        }
                    } else {
                        this.f24966f = m26127c(context);
                    }
                }
                String valueOf2 = String.valueOf(this.f24966f);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
                sb.append(valueOf2);
                sb.append(" (Mobile; ");
                sb.append(str);
                this.f24966f = sb.toString();
                try {
                    if (Wrappers.m22139a(context).mo27945a()) {
                        this.f24966f = String.valueOf(this.f24966f).concat(";aia");
                    }
                } catch (Exception e3) {
                    zzk.zzlk().mo30168a((Throwable) e3, "AdUtil.getUserAgent");
                }
                this.f24966f = String.valueOf(this.f24966f).concat(")");
                String str4 = this.f24966f;
                return str4;
            }
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    protected static String m26127c(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable th) {
            return m26132d();
        }
    }

    /* renamed from: a */
    public final JSONObject mo30230a(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m26115a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str2 = "Could not convert map to JSON: ";
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    /* renamed from: a */
    public final JSONObject mo30229a(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return mo30228a(bundle);
        } catch (JSONException e) {
            zzbad.m26356b("Error converting Bundle to JSON", e);
            return null;
        }
    }

    /* renamed from: a */
    public final JSONObject mo30228a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m26115a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private final JSONArray m26108a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m26114a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private final void m26114a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(mo30228a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(mo30230a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m26108a((Collection) obj));
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            JSONArray jSONArray2 = new JSONArray();
            for (Object a : objArr) {
                m26114a(jSONArray2, a);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    /* renamed from: a */
    private final void m26115a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, mo30228a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, mo30230a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m26108a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m26108a((Collection<?>) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: a */
    private static int m26097a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        throw new IllegalArgumentException("Invalid Hex.");
    }

    /* renamed from: a */
    public static Map<String, String> m26107a(Uri uri) {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24045Ye)).booleanValue()) {
            if (uri == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            zzk.zzli();
            for (String str : uri.getQueryParameterNames()) {
                hashMap.put(str, uri.getQueryParameter(str));
            }
            return hashMap;
        } else if (uri == null) {
            return null;
        } else {
            HashMap hashMap2 = new HashMap(20);
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return hashMap2;
            }
            int length = encodedQuery.length();
            StringBuilder sb = new StringBuilder(100);
            StringBuilder sb2 = new StringBuilder(length);
            StringBuilder sb3 = sb;
            int i = 0;
            while (i < length) {
                char charAt = encodedQuery.charAt(i);
                if (charAt == '%') {
                    byte[] bArr = new byte[((length - i) / 3)];
                    int i2 = 0;
                    while (i < length - 2 && charAt == '%') {
                        try {
                            bArr[i2] = (byte) ((m26097a(encodedQuery.charAt(i + 1)) << 4) + m26097a(encodedQuery.charAt(i + 2)));
                            i2++;
                        } catch (IllegalArgumentException e) {
                        }
                        i += 3;
                        if (i < length) {
                            charAt = encodedQuery.charAt(i);
                        }
                    }
                    try {
                        sb3.append(new String(bArr, 0, i2, "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                    }
                    if (charAt != '%') {
                    }
                } else if (charAt == '&') {
                    if (sb.length() > 0 && sb3 != sb) {
                        hashMap2.put(sb.toString(), sb2.toString());
                        sb.setLength(0);
                        sb2.setLength(0);
                    }
                    sb3 = sb;
                } else if (charAt == '+') {
                    sb3.append(' ');
                } else if (charAt != '=') {
                    sb3.append(charAt);
                } else if (sb3 != sb2) {
                    sb3 = sb2;
                } else {
                    sb3.append(charAt);
                }
                i++;
            }
            if (sb.length() > 0 && sb3 != sb) {
                hashMap2.put(sb.toString(), sb2.toString());
            }
            return hashMap2;
        }
    }

    /* renamed from: a */
    public static String m26104a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: a */
    public static int m26098a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzbad.m26359d(sb.toString());
            return 0;
        }
    }

    /* renamed from: b */
    public static String m26121b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: e */
    private static int[] m26136e() {
        return new int[]{0, 0};
    }

    /* renamed from: a */
    public static int[] m26119a(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View findViewById = window.findViewById(16908290);
            if (findViewById != null) {
                return new int[]{findViewById.getWidth(), findViewById.getHeight()};
            }
        }
        return m26136e();
    }

    /* renamed from: b */
    public final int[] mo30239b(Activity activity) {
        int[] a = m26119a(activity);
        return new int[]{zzyt.m31532a().mo30315b((Context) activity, a[0]), zzyt.m31532a().mo30315b((Context) activity, a[1])};
    }

    /* renamed from: c */
    public final int[] mo30241c(Activity activity) {
        int[] iArr;
        Window window = activity.getWindow();
        if (window != null) {
            View findViewById = window.findViewById(16908290);
            if (findViewById != null) {
                iArr = new int[]{findViewById.getTop(), findViewById.getBottom()};
                return new int[]{zzyt.m31532a().mo30315b((Context) activity, iArr[0]), zzyt.m31532a().mo30315b((Context) activity, iArr[1])};
            }
        }
        iArr = m26136e();
        return new int[]{zzyt.m31532a().mo30315b((Context) activity, iArr[0]), zzyt.m31532a().mo30315b((Context) activity, iArr[1])};
    }

    /* renamed from: b */
    public static boolean m26124b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    /* renamed from: a */
    public static DisplayMetrics m26100a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: d */
    public static Builder m26131d(Context context) {
        return new Builder(context);
    }

    /* renamed from: e */
    public static zzacf m26134e(Context context) {
        return new zzacf(context);
    }

    /* renamed from: a */
    public static Bitmap m26099a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    /* renamed from: a */
    public static PopupWindow m26102a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    /* renamed from: f */
    public static String m26138f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty()) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    /* renamed from: g */
    public static boolean m26139g(Context context) {
        boolean z;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    Iterator it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                        if (Process.myPid() == runningAppProcessInfo.pid) {
                            if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                                if (powerManager == null) {
                                    z = false;
                                } else {
                                    z = powerManager.isScreenOn();
                                }
                                if (z) {
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public final void mo30232a(Context context, String str, String str2, Bundle bundle, boolean z) {
        zzk.zzlg();
        bundle.putString("device", m26121b());
        bundle.putString("eids", TextUtils.join(",", zzacu.m24781a()));
        zzyt.m31532a();
        zzazt.m26308a(context, str, str2, bundle, true, new C9421fc(this, context, str));
    }

    /* renamed from: a */
    public static void m26113a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzaxg.m26094a(runnable);
        }
    }

    /* renamed from: b */
    public static Bitmap m26120b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap f = m26137f(view);
        if (f == null) {
            f = m26133e(view);
        }
        return f;
    }

    /* renamed from: e */
    private static Bitmap m26133e(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0) {
                if (height != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    view.layout(0, 0, width, height);
                    view.draw(canvas);
                    return createBitmap;
                }
            }
            zzbad.m26359d("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            zzbad.m26356b("Fail to capture the webview", e);
            return null;
        }
    }

    /* renamed from: f */
    private static Bitmap m26137f(View view) {
        Bitmap bitmap = null;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                bitmap = Bitmap.createBitmap(drawingCache);
            }
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e) {
            zzbad.m26356b("Fail to capture the web view", e);
        }
        return bitmap;
    }

    /* renamed from: a */
    public static void m26109a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* renamed from: h */
    public static int m26140h(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    /* renamed from: a */
    public final boolean mo30235a(View view, Context context) {
        PowerManager powerManager;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            powerManager = (PowerManager) applicationContext.getSystemService("power");
        } else {
            powerManager = null;
        }
        return mo30236a(view, powerManager, m26146n(context));
    }

    /* renamed from: n */
    private static KeyguardManager m26146n(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    /* renamed from: a */
    public final boolean mo30236a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        boolean z2;
        if (!zzk.zzlg().f24964d) {
            if (keyguardManager == null) {
                z2 = false;
            } else {
                z2 = keyguardManager.inKeyguardRestrictedInputMode();
            }
            if (z2 && !m26129c(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23976Nb)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23976Nb)).booleanValue()) {
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m26129c(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L_0x0013
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0013
            android.app.Activity r2 = (android.app.Activity) r2
            goto L_0x0014
        L_0x0013:
            r2 = r0
        L_0x0014:
            r1 = 0
            if (r2 != 0) goto L_0x0019
            return r1
        L_0x0019:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L_0x0025:
            if (r0 == 0) goto L_0x0031
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0031
            r2 = 1
            return r2
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxi.m26129c(android.view.View):boolean");
    }

    @TargetApi(16)
    /* renamed from: i */
    public static boolean m26141i(Context context) {
        if (context == null || !PlatformVersion.m22109c()) {
            return false;
        }
        KeyguardManager n = m26146n(context);
        if (n == null || !n.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public static int m26130d(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    /* renamed from: j */
    public static boolean m26142j(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            zzbad.m26356b("Error loading class.", th);
            zzk.zzlk().mo30168a(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    @TargetApi(18)
    /* renamed from: a */
    public static void m26110a(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            m26122b(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzbad.m26352a(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzbad.m26356b("No browser is found.", e);
        }
    }

    @TargetApi(18)
    /* renamed from: b */
    public static void m26122b(Context context, Intent intent) {
        if (intent != null && PlatformVersion.m22111e()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    /* renamed from: b */
    public static void m26123b(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e) {
            zzbad.m26356b("Error writing to file in internal storage.", e);
        }
    }

    /* renamed from: c */
    public static String m26128c(Context context, String str) {
        try {
            return new String(IOUtils.m22103a((InputStream) context.openFileInput(str), true), "UTF-8");
        } catch (IOException e) {
            zzbad.m26352a("Error reading from internal storage.");
            return "";
        }
    }

    /* renamed from: c */
    public final boolean mo30240c(String str) {
        return m26118a(str, this.f24962b, (String) zzyt.m31536e().mo29599a(zzacu.f23897Aa));
    }

    /* renamed from: d */
    public final boolean mo30242d(String str) {
        return m26118a(str, this.f24963c, (String) zzyt.m31536e().mo29599a(zzacu.f23903Ba));
    }

    /* renamed from: a */
    private static boolean m26118a(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = (Pattern) atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /* renamed from: c */
    public static String m26126c() {
        Resources b = zzk.zzlk().mo30169b();
        if (b != null) {
            return b.getString(C8581R.string.f19076s7);
        }
        return "Test Ad";
    }

    /* renamed from: c */
    public static WebResourceResponse m26125c(Context context, String str, String str2) {
        String str3 = "UTF-8";
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", zzk.zzlg().mo30237b(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str4 = (String) new zzayu(context).mo30295a(str2, hashMap).get(60, TimeUnit.SECONDS);
            if (str4 != null) {
                return new WebResourceResponse("application/javascript", str3, new ByteArrayInputStream(str4.getBytes(str3)));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzbad.m26358c("Could not fetch MRAID JS.", e);
        }
        return null;
    }

    /* renamed from: a */
    public static WebResourceResponse m26101a(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        String str2;
        zzk.zzlg();
        String contentType = httpURLConnection.getContentType();
        String str3 = "";
        String str4 = ";";
        if (TextUtils.isEmpty(contentType)) {
            str = str3;
        } else {
            str = contentType.split(str4)[0].trim();
        }
        zzk.zzlg();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(str4);
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str2 = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        str2 = str3;
        Map headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Entry entry : headerFields.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null || ((List) entry.getValue()).size() <= 0)) {
                hashMap.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return zzk.zzli().mo30246a(str, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    /* renamed from: a */
    public static void m26112a(Context context, Throwable th) {
        if (context != null) {
            boolean z = false;
            try {
                z = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24130m)).booleanValue();
            } catch (IllegalStateException e) {
            }
            if (z) {
                CrashUtils.m22085a(context, th);
            }
        }
    }

    /* renamed from: k */
    public static String m26143k(Context context) {
        String str = "";
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23991Pe)).booleanValue()) {
            return str;
        }
        return context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str);
    }

    /* renamed from: l */
    public static Bundle m26144l(Context context) {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23997Qe)).booleanValue()) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Bundle bundle = new Bundle();
        String str = "IABConsent_CMPPresent";
        if (defaultSharedPreferences.contains(str)) {
            bundle.putBoolean(str, defaultSharedPreferences.getBoolean(str, false));
        }
        String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
        for (int i = 0; i < 4; i++) {
            String str2 = strArr[i];
            if (defaultSharedPreferences.contains(str2)) {
                bundle.putString(str2, defaultSharedPreferences.getString(str2, null));
            }
        }
        return bundle;
    }

    /* renamed from: m */
    public static boolean m26145m(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) context).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m26135e(String str) {
        if (!zzazx.m26334a()) {
            return false;
        }
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24008Sd)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzyt.m31536e().mo29599a(zzacu.f24020Ud);
        String str3 = ";";
        if (!str2.isEmpty()) {
            for (String equals : str2.split(str3)) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) zzyt.m31536e().mo29599a(zzacu.f24014Td);
        if (str4.isEmpty()) {
            return true;
        }
        for (String equals2 : str4.split(str3)) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
