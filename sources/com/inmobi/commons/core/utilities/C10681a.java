package com.inmobi.commons.core.utilities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.p217a.C10619a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.inmobi.commons.core.utilities.a */
/* compiled from: ApplicationFocusChangeObserver */
public class C10681a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f32598a = C10681a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static List<C10685b> f32599b = new ArrayList();

    /* renamed from: c */
    private static Object f32600c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f32601d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static HandlerThread f32602e = null;

    /* renamed from: f */
    private static final Object f32603f = new Object();

    /* renamed from: g */
    private static volatile C10681a f32604g;

    /* renamed from: com.inmobi.commons.core.utilities.a$a */
    /* compiled from: ApplicationFocusChangeObserver */
    static class C10684a extends Handler {

        /* renamed from: a */
        boolean f32609a = true;

        C10684a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (!C10681a.f32601d) {
                if (message.what != 1001 || !this.f32609a) {
                    if (message.what == 1002 && !this.f32609a) {
                        this.f32609a = true;
                        C10681a.m35068a(true);
                        C10681a.f32598a;
                    }
                    return;
                }
                this.f32609a = false;
                C10681a.m35068a(false);
                C10681a.f32598a;
            }
        }
    }

    /* renamed from: com.inmobi.commons.core.utilities.a$b */
    /* compiled from: ApplicationFocusChangeObserver */
    public interface C10685b {
        /* renamed from: a */
        void mo34519a(boolean z);
    }

    /* renamed from: a */
    public static C10681a m35067a() {
        C10681a aVar = f32604g;
        if (aVar == null) {
            synchronized (f32603f) {
                aVar = f32604g;
                if (aVar == null) {
                    aVar = new C10681a();
                    f32604g = aVar;
                }
            }
        }
        return aVar;
    }

    private C10681a() {
    }

    /* renamed from: a */
    public final void mo34515a(C10685b bVar) {
        Class[] declaredClasses;
        f32599b.add(bVar);
        if (f32599b.size() == 1 && C10619a.m34838a()) {
            HandlerThread handlerThread = new HandlerThread("ApplicationFocusChangeObserverHandler");
            f32602e = handlerThread;
            handlerThread.start();
            Class cls = null;
            for (Class cls2 : Application.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks")) {
                    new Class[1][0] = cls2;
                    cls = cls2;
                }
            }
            f32600c = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {

                /* renamed from: b */
                private final Handler f32606b = new C10684a(C10681a.f32602e.getLooper());

                /* renamed from: c */
                private WeakReference<Activity> f32607c;

                public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if (objArr != null) {
                        String name = method.getName();
                        char c = 65535;
                        int hashCode = name.hashCode();
                        if (hashCode != 195654633) {
                            if (hashCode != 1495889555) {
                                if (hashCode == 1508755423 && name.equals("onActivityStopped")) {
                                    c = 2;
                                }
                            } else if (name.equals("onActivityStarted")) {
                                c = 0;
                            }
                        } else if (name.equals("onActivityResumed")) {
                            c = 1;
                        }
                        if (c == 0 || c == 1) {
                            Activity activity = objArr[0];
                            WeakReference<Activity> weakReference = this.f32607c;
                            if (weakReference == null || weakReference.get() != activity) {
                                this.f32607c = new WeakReference<>(activity);
                            }
                            this.f32606b.removeMessages(1001);
                            this.f32606b.sendEmptyMessage(1002);
                        } else if (c == 2) {
                            Activity activity2 = objArr[0];
                            WeakReference<Activity> weakReference2 = this.f32607c;
                            if (weakReference2 != null && weakReference2.get() == activity2) {
                                this.f32606b.sendEmptyMessageDelayed(1001, 3000);
                            }
                        }
                    }
                    return null;
                }
            });
            Application application = (Application) C10619a.m34839b();
            if (f32600c != null) {
                try {
                    Application.class.getMethod("registerActivityLifecycleCallbacks", new Class[]{cls}).invoke(application, new Object[]{f32600c});
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                } catch (Exception e2) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "GenericException");
                        StringBuilder sb = new StringBuilder();
                        sb.append(e2.getMessage());
                        hashMap.put("message", sb.toString());
                        C10659b.m34983a();
                        C10659b.m34987a("root", "ExceptionCaught", hashMap);
                    } catch (Exception e3) {
                        StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                        sb2.append(e2.getMessage());
                        sb2.append(")");
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m35069b() {
        f32601d = true;
    }

    /* renamed from: c */
    public static void m35070c() {
        f32601d = false;
    }

    /* renamed from: a */
    static /* synthetic */ void m35068a(final boolean z) {
        Context b = C10619a.m34839b();
        if (b != null) {
            new Handler(b.getMainLooper()).post(new Runnable() {
                public final void run() {
                    for (C10685b a : C10681a.f32599b) {
                        try {
                            a.mo34519a(z);
                        } catch (Exception e) {
                            C10681a.f32598a;
                            new StringBuilder("SDK encountered an unexpected error in handling focus change event; ").append(e.getMessage());
                        }
                    }
                }
            });
        }
    }
}
