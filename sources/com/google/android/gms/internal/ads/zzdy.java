package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbp.zza;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzdy {

    /* renamed from: a */
    private static final String f28323a = zzdy.class.getSimpleName();

    /* renamed from: b */
    protected Context f28324b;

    /* renamed from: c */
    private ExecutorService f28325c;

    /* renamed from: d */
    private DexClassLoader f28326d;

    /* renamed from: e */
    private zzdj f28327e;

    /* renamed from: f */
    private byte[] f28328f;

    /* renamed from: g */
    private volatile AdvertisingIdClient f28329g = null;

    /* renamed from: h */
    private volatile boolean f28330h = false;

    /* renamed from: i */
    private Future f28331i = null;

    /* renamed from: j */
    private boolean f28332j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile zza f28333k = null;

    /* renamed from: l */
    private Future f28334l = null;

    /* renamed from: m */
    private zzda f28335m;

    /* renamed from: n */
    protected boolean f28336n = false;

    /* renamed from: o */
    private boolean f28337o = false;

    /* renamed from: p */
    private Map<Pair<String, String>, zzfi> f28338p;

    /* renamed from: q */
    private boolean f28339q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f28340r;

    /* renamed from: s */
    private boolean f28341s;

    /* renamed from: com.google.android.gms.internal.ads.zzdy$a */
    final class C9879a extends BroadcastReceiver {
        private C9879a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdy.this.f28340r = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdy.this.f28340r = false;
            }
        }

        /* synthetic */ C9879a(zzdy zzdy, C9802wq wqVar) {
            this();
        }
    }

    /* renamed from: a */
    public static zzdy m30133a(Context context, String str, String str2, boolean z) {
        File cacheDir;
        String str3;
        File file;
        String str4 = "%s/%s.dex";
        zzdy zzdy = new zzdy(context);
        try {
            zzdy.f28325c = Executors.newCachedThreadPool(new C9802wq());
            zzdy.f28330h = z;
            if (z) {
                zzdy.f28331i = zzdy.f28325c.submit(new C9844yq(zzdy));
            }
            zzdy.f28325c.execute(new C8756Aq(zzdy));
            try {
                GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
                zzdy.f28336n = instance.mo27314b(zzdy.f28324b) > 0;
                zzdy.f28337o = instance.isGooglePlayServicesAvailable(zzdy.f28324b) == 0;
            } catch (Throwable th) {
            }
            zzdy.mo31711a(0, true);
            if (zzef.m30168a()) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24169sc)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzdy.f28327e = new zzdj(null);
            zzdy.f28328f = zzdy.f28327e.mo31520a(str);
            try {
                cacheDir = zzdy.f28324b.getCacheDir();
                if (cacheDir == null) {
                    cacheDir = zzdy.f28324b.getDir("dex", 0);
                    if (cacheDir == null) {
                        throw new zzdv();
                    }
                }
                str3 = "1542658731108";
                file = new File(String.format("%s/%s.jar", new Object[]{cacheDir, str3}));
                if (!file.exists()) {
                    byte[] a = zzdy.f28327e.mo31521a(zzdy.f28328f, str2);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(a, 0, a.length);
                    fileOutputStream.close();
                }
                zzdy.m30141b(cacheDir, str3);
                zzdy.f28326d = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdy.f28324b.getClassLoader());
                m30135a(file);
                zzdy.m30136a(cacheDir, str3);
                m30137a(String.format(str4, new Object[]{cacheDir, str3}));
                if (!zzdy.f28341s) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    zzdy.f28324b.registerReceiver(new C9879a(zzdy, null), intentFilter);
                    zzdy.f28341s = true;
                }
                zzdy.f28335m = new zzda(zzdy);
                zzdy.f28339q = true;
            } catch (FileNotFoundException e) {
                throw new zzdv(e);
            } catch (IOException e2) {
                throw new zzdv(e2);
            } catch (zzdk e3) {
                throw new zzdv(e3);
            } catch (NullPointerException e4) {
                throw new zzdv(e4);
            } catch (Throwable th2) {
                m30135a(file);
                zzdy.m30136a(cacheDir, str3);
                m30137a(String.format(str4, new Object[]{cacheDir, str3}));
                throw th2;
            }
        } catch (zzdk e5) {
            throw new zzdv(e5);
        } catch (zzdv e6) {
        }
        return zzdy;
    }

    /* renamed from: a */
    public final Context mo31709a() {
        return this.f28324b;
    }

    /* renamed from: b */
    public final boolean mo31714b() {
        return this.f28339q;
    }

    /* renamed from: d */
    public final ExecutorService mo31716d() {
        return this.f28325c;
    }

    /* renamed from: e */
    public final DexClassLoader mo31717e() {
        return this.f28326d;
    }

    /* renamed from: f */
    public final zzdj mo31718f() {
        return this.f28327e;
    }

    /* renamed from: g */
    public final byte[] mo31719g() {
        return this.f28328f;
    }

    /* renamed from: h */
    public final boolean mo31720h() {
        return this.f28336n;
    }

    /* renamed from: i */
    public final zzda mo31721i() {
        return this.f28335m;
    }

    /* renamed from: j */
    public final boolean mo31722j() {
        return this.f28337o;
    }

    /* renamed from: k */
    public final boolean mo31723k() {
        return this.f28340r;
    }

    /* renamed from: l */
    public final zza mo31724l() {
        return this.f28333k;
    }

    /* renamed from: m */
    public final Future mo31725m() {
        return this.f28334l;
    }

    private zzdy(Context context) {
        boolean z = true;
        this.f28340r = true;
        this.f28341s = false;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            z = false;
        }
        this.f28332j = z;
        if (this.f28332j) {
            context = applicationContext;
        }
        this.f28324b = context;
        this.f28338p = new HashMap();
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e6 A[SYNTHETIC, Splitter:B:41:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ef A[SYNTHETIC, Splitter:B:45:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0102 A[SYNTHETIC, Splitter:B:53:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010b A[SYNTHETIC, Splitter:B:57:0x010b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m30136a(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "test"
            java.io.File r1 = new java.io.File
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r3 = new java.io.File
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r2)
            r3.<init>(r10)
            boolean r10 = r3.exists()
            if (r10 != 0) goto L_0x0035
            return
        L_0x0035:
            long r5 = r3.length()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0042
            return
        L_0x0042:
            int r10 = (int) r5
            byte[] r10 = new byte[r10]
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00fc, zzdk -> 0x00fa, all -> 0x00e2 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00fc, zzdk -> 0x00fa, all -> 0x00e2 }
            int r6 = r5.read(r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            if (r6 > 0) goto L_0x005a
            r5.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0056
        L_0x0055:
            r10 = move-exception
        L_0x0056:
            m30135a(r3)
            return
        L_0x005a:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            r6.print(r0)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            r6.print(r0)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            r6.print(r0)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r0 = com.google.android.gms.internal.ads.zzbp.zzd.m27603p()     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzdmr r6 = com.google.android.gms.internal.ads.zzdmr.m29656b(r6)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r0 = r0.mo30846d(r6)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            byte[] r11 = r11.getBytes()     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzdmr r11 = com.google.android.gms.internal.ads.zzdmr.m29656b(r11)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r11 = r0.mo30845c(r11)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzdj r0 = r9.f28327e     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            byte[] r6 = r9.f28328f     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            java.lang.String r10 = r0.mo31519a(r6, r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzdmr r0 = com.google.android.gms.internal.ads.zzdmr.m29656b(r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r0 = r11.mo30843a(r0)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            byte[] r10 = com.google.android.gms.internal.ads.C9318aj.m23434a(r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzdmr r10 = com.google.android.gms.internal.ads.zzdmr.m29656b(r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            r0.mo30844b(r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            r1.createNewFile()     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            r10.<init>(r1)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00da }
            com.google.android.gms.internal.ads.zzdpk r11 = r11.mo31612g()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdob r11 = (com.google.android.gms.internal.ads.zzdob) r11     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbp$zzd r11 = (com.google.android.gms.internal.ads.zzbp.zzd) r11     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            byte[] r11 = r11.toByteArray()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            int r0 = r11.length     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            r10.write(r11, r4, r0)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            r10.close()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzdk -> 0x00d3, all -> 0x00d0 }
            r5.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00c7
        L_0x00c6:
            r11 = move-exception
        L_0x00c7:
            r10.close()     // Catch:{ IOException -> 0x00cb }
            goto L_0x00cc
        L_0x00cb:
            r10 = move-exception
        L_0x00cc:
            m30135a(r3)
            return
        L_0x00d0:
            r11 = move-exception
            r2 = r10
            goto L_0x00e4
        L_0x00d3:
            r11 = move-exception
            goto L_0x00d8
        L_0x00d5:
            r11 = move-exception
            goto L_0x00d8
        L_0x00d7:
            r11 = move-exception
        L_0x00d8:
            r2 = r10
            goto L_0x0100
        L_0x00da:
            r11 = move-exception
            goto L_0x00e4
        L_0x00dc:
            r10 = move-exception
            goto L_0x0100
        L_0x00de:
            r10 = move-exception
            goto L_0x0100
        L_0x00e0:
            r10 = move-exception
            goto L_0x0100
        L_0x00e2:
            r11 = move-exception
            r5 = r2
        L_0x00e4:
            if (r5 == 0) goto L_0x00ec
            r5.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ec
        L_0x00ea:
            r10 = move-exception
            goto L_0x00ed
        L_0x00ec:
        L_0x00ed:
            if (r2 == 0) goto L_0x00f5
            r2.close()     // Catch:{ IOException -> 0x00f3 }
            goto L_0x00f5
        L_0x00f3:
            r10 = move-exception
            goto L_0x00f6
        L_0x00f5:
        L_0x00f6:
            m30135a(r3)
            throw r11
        L_0x00fa:
            r10 = move-exception
            goto L_0x00ff
        L_0x00fc:
            r10 = move-exception
            goto L_0x00ff
        L_0x00fe:
            r10 = move-exception
        L_0x00ff:
            r5 = r2
        L_0x0100:
            if (r5 == 0) goto L_0x0108
            r5.close()     // Catch:{ IOException -> 0x0106 }
            goto L_0x0108
        L_0x0106:
            r10 = move-exception
            goto L_0x0109
        L_0x0108:
        L_0x0109:
            if (r2 == 0) goto L_0x0111
            r2.close()     // Catch:{ IOException -> 0x010f }
            goto L_0x0111
        L_0x010f:
            r10 = move-exception
            goto L_0x0112
        L_0x0111:
        L_0x0112:
            m30135a(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.m30136a(java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    private static void m30137a(String str) {
        m30135a(new File(str));
    }

    /* renamed from: a */
    private static void m30135a(File file) {
        if (!file.exists()) {
            Log.d(f28323a, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f8 A[SYNTHETIC, Splitter:B:54:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101 A[SYNTHETIC, Splitter:B:58:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0111 A[SYNTHETIC, Splitter:B:65:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011a A[SYNTHETIC, Splitter:B:69:0x011a] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m30141b(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r10
            r4 = 1
            r2[r4] = r11
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001b
            return r3
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r10
            r1[r4] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r1)
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x0033
            return r3
        L_0x0033:
            r10 = 0
            long r5 = r0.length()     // Catch:{ IOException -> 0x010d, NoSuchAlgorithmException -> 0x010b, zzdk -> 0x0109, all -> 0x00f4 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0044
            m30135a(r0)     // Catch:{ IOException -> 0x010d, NoSuchAlgorithmException -> 0x010b, zzdk -> 0x0109, all -> 0x00f4 }
            return r3
        L_0x0044:
            int r1 = (int) r5     // Catch:{ IOException -> 0x010d, NoSuchAlgorithmException -> 0x010b, zzdk -> 0x0109, all -> 0x00f4 }
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x010d, NoSuchAlgorithmException -> 0x010b, zzdk -> 0x0109, all -> 0x00f4 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x010d, NoSuchAlgorithmException -> 0x010b, zzdk -> 0x0109, all -> 0x00f4 }
            r5.<init>(r0)     // Catch:{ IOException -> 0x010d, NoSuchAlgorithmException -> 0x010b, zzdk -> 0x0109, all -> 0x00f4 }
            int r6 = r5.read(r1)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            if (r6 > 0) goto L_0x0062
            java.lang.String r11 = f28323a     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            m30135a(r0)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            r5.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0061
        L_0x0060:
            r10 = move-exception
        L_0x0061:
            return r3
        L_0x0062:
            com.google.android.gms.internal.ads.zzdno r6 = com.google.android.gms.internal.ads.zzdno.m29867c()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            com.google.android.gms.internal.ads.zzbp$zzd r1 = com.google.android.gms.internal.ads.zzbp.zzd.m27594a(r1, r6)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            com.google.android.gms.internal.ads.zzdmr r7 = r1.mo30841n()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r7 = r7.mo31539a()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            boolean r11 = r11.equals(r6)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            if (r11 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzdmr r11 = r1.mo30840m()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r11 = r11.mo31539a()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            com.google.android.gms.internal.ads.zzdmr r6 = r1.mo30839l()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r6 = r6.mo31539a()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r6 = com.google.android.gms.internal.ads.C9318aj.m23434a(r6)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            if (r11 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzdmr r11 = r1.mo30842o()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r11 = r11.mo31539a()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            if (r11 != 0) goto L_0x00ac
            goto L_0x00e3
        L_0x00ac:
            com.google.android.gms.internal.ads.zzdj r11 = r9.f28327e     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r0 = r9.f28328f     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            com.google.android.gms.internal.ads.zzdmr r1 = r1.mo30839l()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r1 = r1.mo31539a()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            r6.<init>(r1)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            byte[] r11 = r11.mo31521a(r0, r6)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            r2.createNewFile()     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            r0.<init>(r2)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            int r10 = r11.length     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00d9 }
            r0.write(r11, r3, r10)     // Catch:{ IOException -> 0x00e0, NoSuchAlgorithmException -> 0x00de, zzdk -> 0x00dc, all -> 0x00d9 }
            r5.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d2
        L_0x00d1:
            r10 = move-exception
        L_0x00d2:
            r0.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00d8
        L_0x00d6:
            r10 = move-exception
        L_0x00d8:
            return r4
        L_0x00d9:
            r11 = move-exception
            r10 = r0
            goto L_0x00f6
        L_0x00dc:
            r10 = move-exception
            goto L_0x00e1
        L_0x00de:
            r10 = move-exception
            goto L_0x00e1
        L_0x00e0:
            r10 = move-exception
        L_0x00e1:
            r10 = r0
            goto L_0x010f
        L_0x00e3:
            m30135a(r0)     // Catch:{ IOException -> 0x00f2, NoSuchAlgorithmException -> 0x00f0, zzdk -> 0x00ee, all -> 0x00ec }
            r5.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00eb
        L_0x00ea:
            r10 = move-exception
        L_0x00eb:
            return r3
        L_0x00ec:
            r11 = move-exception
            goto L_0x00f6
        L_0x00ee:
            r11 = move-exception
            goto L_0x010f
        L_0x00f0:
            r11 = move-exception
            goto L_0x010f
        L_0x00f2:
            r11 = move-exception
            goto L_0x010f
        L_0x00f4:
            r11 = move-exception
            r5 = r10
        L_0x00f6:
            if (r5 == 0) goto L_0x00fe
            r5.close()     // Catch:{ IOException -> 0x00fc }
            goto L_0x00fe
        L_0x00fc:
            r0 = move-exception
            goto L_0x00ff
        L_0x00fe:
        L_0x00ff:
            if (r10 == 0) goto L_0x0107
            r10.close()     // Catch:{ IOException -> 0x0105 }
            goto L_0x0107
        L_0x0105:
            r10 = move-exception
            goto L_0x0108
        L_0x0107:
        L_0x0108:
            throw r11
        L_0x0109:
            r11 = move-exception
            goto L_0x010e
        L_0x010b:
            r11 = move-exception
            goto L_0x010e
        L_0x010d:
            r11 = move-exception
        L_0x010e:
            r5 = r10
        L_0x010f:
            if (r5 == 0) goto L_0x0117
            r5.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0117
        L_0x0115:
            r11 = move-exception
            goto L_0x0118
        L_0x0117:
        L_0x0118:
            if (r10 == 0) goto L_0x0120
            r10.close()     // Catch:{ IOException -> 0x011e }
            goto L_0x0120
        L_0x011e:
            r10 = move-exception
            goto L_0x0121
        L_0x0120:
        L_0x0121:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.m30141b(java.io.File, java.lang.String):boolean");
    }

    /* renamed from: a */
    public final boolean mo31712a(String str, String str2, Class<?>... clsArr) {
        if (this.f28338p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f28338p.put(new Pair(str, str2), new zzfi(this, str, str2, clsArr));
        return true;
    }

    /* renamed from: a */
    public final Method mo31710a(String str, String str2) {
        zzfi zzfi = (zzfi) this.f28338p.get(new Pair(str, str2));
        if (zzfi == null) {
            return null;
        }
        return zzfi.mo31747a();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m30142o() {
        try {
            if (this.f28329g == null && this.f28332j) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f28324b);
                advertisingIdClient.start();
                this.f28329g = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.f28329g = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31711a(int i, boolean z) {
        if (this.f28337o) {
            Future submit = this.f28325c.submit(new C9865zq(this, i, z));
            if (i == 0) {
                this.f28334l = submit;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final zza mo31713b(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException e) {
            }
        }
        return m30143p();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m30140b(int i, zza zza) {
        if (i >= 4 || (zza != null && zza.mo30759m() && !zza.mo30758l().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza.mo30760n() && zza.mo30761o().mo30847l() && zza.mo30761o().mo30848m() != -2)) {
            return false;
        }
        return true;
    }

    /* renamed from: p */
    private final zza m30143p() {
        try {
            return zzdal.m29091a(this.f28324b, this.f28324b.getPackageName(), Integer.toString(this.f28324b.getPackageManager().getPackageInfo(this.f28324b.getPackageName(), 0).versionCode));
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: n */
    public final AdvertisingIdClient mo31726n() {
        if (!this.f28330h) {
            return null;
        }
        if (this.f28329g != null) {
            return this.f28329g;
        }
        Future future = this.f28331i;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.f28331i = null;
            } catch (InterruptedException | ExecutionException e) {
            } catch (TimeoutException e2) {
                this.f28331i.cancel(true);
            }
        }
        return this.f28329g;
    }

    /* renamed from: c */
    public final int mo31715c() {
        if (this.f28335m != null) {
            return zzda.m29063a();
        }
        return LinearLayoutManager.INVALID_OFFSET;
    }
}
