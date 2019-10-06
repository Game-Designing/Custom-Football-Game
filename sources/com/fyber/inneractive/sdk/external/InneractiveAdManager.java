package com.fyber.inneractive.sdk.external;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Pair;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.fyber.inneractive.sdk.C7638a;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p160b.C7649a;
import com.fyber.inneractive.sdk.p160b.C7652b;
import com.fyber.inneractive.sdk.p160b.C7655c;
import com.fyber.inneractive.sdk.p160b.C7658d;
import com.fyber.inneractive.sdk.p164e.C7721a;
import com.fyber.inneractive.sdk.p178k.C7921c;
import com.fyber.inneractive.sdk.util.C7991ae;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8026r;
import com.fyber.inneractive.sdk.util.C8034w;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.io.IOException;

public final class InneractiveAdManager {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static OnConfigurationReadyAndValidListener f15387b;

    /* renamed from: a */
    String f15388a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f15389c;

    /* renamed from: com.fyber.inneractive.sdk.external.InneractiveAdManager$a */
    private static class C7727a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static InneractiveAdManager f15390a = new InneractiveAdManager(0);
    }

    /* synthetic */ InneractiveAdManager(byte b) {
        this();
    }

    private InneractiveAdManager() {
    }

    public static void initialize(Context context, String str) {
        if (context == null || str == null) {
            IAlog.m18024e("InneractiveAdManager:initialize. No context or App Id given");
        } else if (C7727a.f15390a.f15389c != null) {
            IAlog.m18021b("InneractiveAdManager:initialize called, but manager is already initialized. ignoring");
        } else {
            C7727a.f15390a.f15389c = context.getApplicationContext();
            C8006j.m18069a(C7727a.f15390a.f15389c);
            C8026r a = C8028a.f16369a;
            Context applicationContext = context.getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) a));
            sb.append("init called");
            IAlog.m18021b(sb.toString());
            a.f16366c = applicationContext;
            a.f16367d = new BroadcastReceiver() {
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0082, code lost:
                    if ("android.intent.action.USER_PRESENT".equals(r6.getAction()) != false) goto L_0x0084;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onReceive(android.content.Context r5, android.content.Intent r6) {
                    /*
                        r4 = this;
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        com.fyber.inneractive.sdk.util.r r0 = com.fyber.inneractive.sdk.util.C8026r.this
                        java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r0)
                        r5.append(r0)
                        java.lang.String r0 = "onReceive. action = "
                        r5.append(r0)
                        java.lang.String r0 = r6.getAction()
                        r5.append(r0)
                        java.lang.String r5 = r5.toString()
                        com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)
                        com.fyber.inneractive.sdk.util.r r5 = com.fyber.inneractive.sdk.util.C8026r.this
                        android.content.Context r5 = r5.f16366c
                        java.lang.String r0 = "keyguard"
                        java.lang.Object r5 = r5.getSystemService(r0)
                        android.app.KeyguardManager r5 = (android.app.KeyguardManager) r5
                        int r0 = android.os.Build.VERSION.SDK_INT
                        r1 = 0
                        r2 = 1
                        r3 = 16
                        if (r0 < r3) goto L_0x0058
                        boolean r5 = r5.isKeyguardLocked()     // Catch:{ Exception -> 0x003b }
                        goto L_0x0059
                    L_0x003b:
                        r5 = move-exception
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        com.fyber.inneractive.sdk.util.r r0 = com.fyber.inneractive.sdk.util.C8026r.this
                        java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r0)
                        r5.append(r0)
                        java.lang.String r0 = "Failed to get lock screen status"
                        r5.append(r0)
                        java.lang.String r5 = r5.toString()
                        com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)
                        r5 = 0
                        goto L_0x0059
                    L_0x0058:
                        r5 = 1
                    L_0x0059:
                        java.lang.String r0 = r6.getAction()
                        java.lang.String r3 = "android.intent.action.SCREEN_OFF"
                        boolean r0 = r3.equals(r0)
                        if (r0 == 0) goto L_0x006a
                        com.fyber.inneractive.sdk.util.r r5 = com.fyber.inneractive.sdk.util.C8026r.this
                        r5.f16365b = r2
                        goto L_0x0088
                    L_0x006a:
                        java.lang.String r0 = r6.getAction()
                        java.lang.String r2 = "android.intent.action.SCREEN_ON"
                        boolean r0 = r2.equals(r0)
                        if (r0 == 0) goto L_0x0078
                        if (r5 == 0) goto L_0x0084
                    L_0x0078:
                        java.lang.String r5 = r6.getAction()
                        java.lang.String r6 = "android.intent.action.USER_PRESENT"
                        boolean r5 = r6.equals(r5)
                        if (r5 == 0) goto L_0x0088
                    L_0x0084:
                        com.fyber.inneractive.sdk.util.r r5 = com.fyber.inneractive.sdk.util.C8026r.this
                        r5.f16365b = r1
                    L_0x0088:
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        com.fyber.inneractive.sdk.util.r r6 = com.fyber.inneractive.sdk.util.C8026r.this
                        java.lang.String r6 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r6)
                        r5.append(r6)
                        java.lang.String r6 = "New screen state is locked: "
                        r5.append(r6)
                        com.fyber.inneractive.sdk.util.r r6 = com.fyber.inneractive.sdk.util.C8026r.this
                        boolean r6 = r6.f16365b
                        r5.append(r6)
                        java.lang.String r6 = ". number of listeners: "
                        r5.append(r6)
                        com.fyber.inneractive.sdk.util.r r6 = com.fyber.inneractive.sdk.util.C8026r.this
                        java.util.Set<com.fyber.inneractive.sdk.util.r$b> r6 = r6.f16364a
                        int r6 = r6.size()
                        r5.append(r6)
                        java.lang.String r5 = r5.toString()
                        com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)
                        com.fyber.inneractive.sdk.util.r r5 = com.fyber.inneractive.sdk.util.C8026r.this
                        java.util.Set<com.fyber.inneractive.sdk.util.r$b> r5 = r5.f16364a
                        java.util.Iterator r5 = r5.iterator()
                    L_0x00c1:
                        boolean r6 = r5.hasNext()
                        if (r6 == 0) goto L_0x00d5
                        java.lang.Object r6 = r5.next()
                        com.fyber.inneractive.sdk.util.r$b r6 = (com.fyber.inneractive.sdk.util.C8026r.C8029b) r6
                        com.fyber.inneractive.sdk.util.r r0 = com.fyber.inneractive.sdk.util.C8026r.this
                        boolean r0 = r0.f16365b
                        r6.mo24867a(r0)
                        goto L_0x00c1
                    L_0x00d5:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8026r.C80271.onReceive(android.content.Context, android.content.Intent):void");
                }
            };
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            a.f16366c.registerReceiver(a.f16367d, intentFilter);
            C7660b.f15189a.mo24090a(new C7921c());
            Intent intent = new Intent();
            intent.setAction("com.fyber.inneractive.sdk.intent.action.REGISTER_KIT");
            intent.setPackage(C8005i.m18056e());
            C7638a.m16876a(C7727a.f15390a.f15389c, intent);
            C77261 r3 = new OnConfigurationReadyAndValidListener() {
                public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
                    if (C7727a.f15390a.f15389c != null) {
                        InneractiveAdManager.m17129b();
                        IAConfigManager.removeListener(this);
                        InneractiveAdManager.f15387b = null;
                    }
                }
            };
            f15387b = r3;
            IAConfigManager.addListener(r3);
            IAConfigManager.m16968a(C7727a.f15390a.f15389c, str, "Android", "7.2.2");
            try {
                Context context2 = C7727a.f15390a.f15389c;
                C7639a a2 = C7640a.f15157a;
                C7640a.f15157a;
                String e = C8005i.m18056e();
                boolean z = true;
                if (e == null || !e.startsWith("com.inneractive.automation")) {
                    if (e == null || !e.equalsIgnoreCase("com.example.android.snake")) {
                        z = false;
                    }
                }
                a2.f15150a = z;
                if (C7640a.f15157a.f15150a) {
                    C7640a.f15157a.f15151b = context2;
                    try {
                        C7640a.f15157a.f15154e = new File(Environment.getExternalStorageDirectory(), C7640a.f15157a.f15153d);
                        if (C7640a.f15157a.f15154e.exists()) {
                            C7640a.f15157a.f15154e.delete();
                        }
                        C7640a.f15157a.f15151b.deleteFile(C7640a.f15157a.f15153d);
                        try {
                            C7640a.f15157a.f15154e.createNewFile();
                        } catch (IOException e2) {
                        }
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
            }
        }
    }

    public static String getVersion() {
        return "7.2.2";
    }

    public static void destroy() {
        IAlog.m18021b("InneractiveAdManager:destroy called");
        if (C7727a.f15390a.f15389c == null) {
            IAlog.m18021b("InneractiveAdManager:destroy called, but manager is not initialized");
            return;
        }
        C7727a.f15390a.f15389c = null;
        IAConfigManager.removeListener(f15387b);
        f15387b = null;
        C7991ae.m18036a();
        IAConfigManager.m16986c();
        C8034w a = C8034w.m18120a();
        a.f16378c.clear();
        for (Context context : a.f16377b.keySet()) {
            Pair pair = (Pair) a.f16377b.get(context);
            if (((ViewTreeObserver) pair.first).isAlive()) {
                ((ViewTreeObserver) pair.first).removeOnPreDrawListener((OnPreDrawListener) pair.second);
            }
        }
        a.f16377b.clear();
        C8026r a2 = C8028a.f16369a;
        if (a2.f16366c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) a2));
            sb.append("removing screen state receiver and destroying singleton");
            IAlog.m18021b(sb.toString());
            a2.f16366c.unregisterReceiver(a2.f16367d);
            a2.f16366c = null;
            a2.f16367d = null;
            a2.f16364a.clear();
        }
        C7658d dVar = C7660b.f15189a;
        if (dVar != null) {
            dVar.f15188a.clear();
        }
        C7652b bVar = C7653a.f15185a;
        if (bVar != null) {
            bVar.f15184a.clear();
        }
        C7649a aVar = C7651b.f15183a;
        if (aVar != null) {
            aVar.f15182a.clear();
        }
        C7655c cVar = C7657b.f15187a;
        if (cVar != null) {
            cVar.f15186a.clear();
        }
        InneractiveAdSpotManager.destroy();
        C8006j.m18076o();
    }

    public static void setLogLevel(int i) {
        if (!IAConfigManager.m16974a()) {
            IAlog.f16291a = i;
        }
    }

    public static void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        IAConfigManager.m16971a(inneractiveUserConfig);
    }

    public static boolean areNativeAdsSupportedForOS() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean isCurrentDeviceSupportsVideo() {
        return IAConfigManager.m16990d();
    }

    public final Context getAppContext() {
        return this.f15389c;
    }

    public static void setGdprConsent(boolean z) {
        IAConfigManager.m16973a(z);
    }

    public static void useSecureConnections(boolean z) {
        IAConfigManager.m16984b(z);
    }

    @Deprecated
    public static void setDevPlatform(String str) {
        C7727a.f15390a.f15388a = str;
    }

    @Deprecated
    public static String getDevPlatform() {
        return C7727a.f15390a.f15388a;
    }

    public static boolean wasInitialized() {
        return C7727a.f15390a.f15389c != null;
    }

    /* renamed from: b */
    static /* synthetic */ void m17129b() {
        if (IAConfigManager.m16976a(Vendor.MOAT)) {
            C7721a.m17104a(C7727a.f15390a.f15389c);
        }
    }
}
