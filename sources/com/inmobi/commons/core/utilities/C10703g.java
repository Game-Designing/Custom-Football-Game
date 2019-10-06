package com.inmobi.commons.core.utilities;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.inmobi.commons.core.utilities.g */
/* compiled from: SystemBroadcastObserver */
public class C10703g {

    /* renamed from: a */
    private static final String f32658a = C10703g.class.getSimpleName();

    /* renamed from: b */
    private static HashMap<String, CopyOnWriteArrayList<C10706b>> f32659b = new HashMap<>();

    /* renamed from: c */
    private static HashMap<String, C10705a> f32660c = new HashMap<>();

    /* renamed from: d */
    private static HashMap<String, NetworkCallback> f32661d = new HashMap<>();

    /* renamed from: e */
    private static final Object f32662e = new Object();

    /* renamed from: f */
    private static volatile C10703g f32663f;

    /* renamed from: com.inmobi.commons.core.utilities.g$a */
    /* compiled from: SystemBroadcastObserver */
    static final class C10705a extends BroadcastReceiver {

        /* renamed from: a */
        private static final String f32665a = C10705a.class.getSimpleName();

        C10705a() {
        }

        @SuppressLint({"MissingPermission"})
        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getAction() != null) {
                        boolean z = false;
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager != null) {
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                                    z = true;
                                }
                            }
                        } else if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equalsIgnoreCase(intent.getAction())) {
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager != null && VERSION.SDK_INT >= 23 && powerManager.isDeviceIdleMode()) {
                                z = true;
                            }
                        } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                            z = true;
                        }
                        C10703g.m35156b(z, intent.getAction());
                        StringBuilder sb = new StringBuilder();
                        sb.append(intent.getAction());
                        sb.append(" Availability:");
                        sb.append(z);
                    }
                } catch (Exception e) {
                    new StringBuilder("SDK encountered unexpected error in SystemBroadReceiver.onReceive handler; ").append(e.getMessage());
                }
            }
        }
    }

    /* renamed from: com.inmobi.commons.core.utilities.g$b */
    /* compiled from: SystemBroadcastObserver */
    public interface C10706b {
        /* renamed from: a */
        void mo34229a(boolean z);
    }

    /* renamed from: a */
    public static C10703g m35152a() {
        C10703g gVar = f32663f;
        if (gVar == null) {
            synchronized (f32662e) {
                gVar = f32663f;
                if (gVar == null) {
                    gVar = new C10703g();
                    f32663f = gVar;
                }
            }
        }
        return gVar;
    }

    /* renamed from: a */
    public final void mo34524a(String str, C10706b bVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f32659b.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(bVar);
        } else {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(bVar);
        }
        f32659b.put(str, copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() == 1) {
            Context b = C10619a.m34839b();
            if (b != null) {
                if ("SYSTEM_CONNECTIVITY_CHANGE".equals(str)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        C107041 r0 = new NetworkCallback() {
                            public final void onAvailable(Network network) {
                                super.onAvailable(network);
                                C10703g.m35156b(true, "SYSTEM_CONNECTIVITY_CHANGE");
                            }

                            public final void onLost(Network network) {
                                super.onLost(network);
                                C10703g.m35156b(false, "SYSTEM_CONNECTIVITY_CHANGE");
                            }
                        };
                        f32661d.put(str, r0);
                        connectivityManager.registerDefaultNetworkCallback(r0);
                    }
                    return;
                }
                C10705a aVar = new C10705a();
                f32660c.put(str, aVar);
                b.registerReceiver(aVar, new IntentFilter(str));
            }
        }
    }

    /* renamed from: a */
    public final void mo34523a(C10706b bVar) {
        if (VERSION.SDK_INT < 28) {
            mo34524a("android.net.conn.CONNECTIVITY_CHANGE", bVar);
        } else {
            mo34524a("SYSTEM_CONNECTIVITY_CHANGE", bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m35156b(boolean z, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f32659b.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((C10706b) it.next()).mo34229a(z);
                } catch (Exception e) {
                    new StringBuilder("SDK encountered unexpected error in SystemBroadcastObserver.onServiceChanged event handler; ").append(e.getMessage());
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m35153a(C10706b bVar, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f32659b.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(bVar);
            if (copyOnWriteArrayList.size() == 0) {
                Context b = C10619a.m34839b();
                if (b != null) {
                    if ("SYSTEM_CONNECTIVITY_CHANGE".equals(str) && f32661d.get(str) != null) {
                        ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
                        if (connectivityManager != null) {
                            connectivityManager.unregisterNetworkCallback((NetworkCallback) f32661d.get(str));
                            f32661d.remove(str);
                        }
                    } else if (f32660c.get(str) != null) {
                        b.unregisterReceiver((BroadcastReceiver) f32660c.get(str));
                        f32660c.remove(str);
                    }
                }
            }
        }
    }
}
