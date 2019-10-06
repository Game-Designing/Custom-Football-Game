package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

@zzard
public final class zzavg {

    /* renamed from: a */
    private final AtomicReference<ThreadPoolExecutor> f24861a = new AtomicReference<>(null);

    /* renamed from: b */
    private final Object f24862b = new Object();

    /* renamed from: c */
    private String f24863c = null;

    /* renamed from: d */
    private String f24864d = null;
    @VisibleForTesting

    /* renamed from: e */
    private final AtomicBoolean f24865e = new AtomicBoolean(false);
    @VisibleForTesting

    /* renamed from: f */
    private final AtomicInteger f24866f = new AtomicInteger(-1);

    /* renamed from: g */
    private final AtomicReference<Object> f24867g = new AtomicReference<>(null);

    /* renamed from: h */
    private final AtomicReference<Object> f24868h = new AtomicReference<>(null);

    /* renamed from: i */
    private final ConcurrentMap<String, Method> f24869i = new ConcurrentHashMap(9);

    /* renamed from: j */
    private final AtomicReference<zzbjf> f24870j = new AtomicReference<>(null);

    /* renamed from: k */
    private final List<FutureTask> f24871k = new ArrayList();

    /* renamed from: f */
    public final boolean mo30134f(Context context) {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24209za)).booleanValue() || this.f24865e.get()) {
            return false;
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23951Ja)).booleanValue()) {
            return true;
        }
        if (this.f24866f.get() == -1) {
            zzyt.m31532a();
            if (!zzazt.m26318c(context, 12451000)) {
                zzyt.m31532a();
                if (zzazt.m26317c(context)) {
                    zzbad.m26359d("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.f24866f.set(0);
                }
            }
            this.f24866f.set(1);
        }
        if (this.f24866f.get() == 1) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    /* renamed from: i */
    private static boolean m25910i(Context context) {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23933Ga)).booleanValue()) {
            if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23939Ha)).booleanValue()) {
                return false;
            }
        }
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23945Ia)).booleanValue()) {
            return true;
        }
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        }
    }

    /* renamed from: a */
    public final void mo30122a(Context context, String str) {
        if (mo30134f(context)) {
            String str2 = "beginAdUnitExposure";
            if (m25910i(context)) {
                m25905a(str2, (C9118Sb) new C8804Db(str));
            } else {
                m25902a(context, str, str2);
            }
        }
    }

    /* renamed from: b */
    public final void mo30126b(Context context, String str) {
        if (mo30134f(context)) {
            String str2 = "endAdUnitExposure";
            if (m25910i(context)) {
                m25905a(str2, (C9118Sb) new C8825Eb(str));
            } else {
                m25902a(context, str, str2);
            }
        }
    }

    /* renamed from: g */
    public final String mo30135g(Context context) {
        String str = "getCurrentScreenName";
        String str2 = "";
        if (!mo30134f(context)) {
            return str2;
        }
        if (m25910i(context)) {
            return (String) m25899a("getCurrentScreenNameOrScreenClass", (T) str2, C8909Ib.f21240a);
        }
        if (!m25906a(context, "com.google.android.gms.measurement.AppMeasurement", this.f24867g, true)) {
            return str2;
        }
        try {
            String str3 = (String) m25909i(context, str).invoke(this.f24867g.get(), new Object[0]);
            if (str3 == null) {
                str3 = (String) m25909i(context, "getCurrentScreenClass").invoke(this.f24867g.get(), new Object[0]);
            }
            return str3 != null ? str3 : str2;
        } catch (Exception e) {
            m25904a(e, str, false);
            return str2;
        }
    }

    /* renamed from: c */
    public final void mo30128c(Context context, String str) {
        if (!mo30134f(context) || !(context instanceof Activity)) {
            return;
        }
        if (m25910i(context)) {
            m25905a("setScreenName", (C9118Sb) new C8930Jb(context, str));
            return;
        }
        if (m25906a(context, "com.google.firebase.analytics.FirebaseAnalytics", this.f24868h, false)) {
            String str2 = "setCurrentScreen";
            Method j = m25911j(context, str2);
            try {
                Activity activity = (Activity) context;
                j.invoke(this.f24868h.get(), new Object[]{activity, str, context.getPackageName()});
            } catch (Exception e) {
                m25904a(e, str2, false);
            }
        }
    }

    /* renamed from: a */
    public final String mo30121a(Context context) {
        if (!mo30134f(context)) {
            return null;
        }
        synchronized (this.f24862b) {
            if (this.f24863c != null) {
                String str = this.f24863c;
                return str;
            }
            if (m25910i(context)) {
                this.f24863c = (String) m25899a("getGmpAppId", (T) this.f24863c, C8951Kb.f21391a);
            } else {
                this.f24863c = (String) m25898a("getGmpAppId", context);
            }
            String str2 = this.f24863c;
            return str2;
        }
    }

    /* renamed from: b */
    public final String mo30125b(Context context) {
        if (!mo30134f(context)) {
            return null;
        }
        long longValue = ((Long) zzyt.m31536e().mo29599a(zzacu.f23921Ea)).longValue();
        String str = "TIME_OUT";
        String str2 = "getAppInstanceId";
        if (m25910i(context)) {
            if (longValue >= 0) {
                return (String) m25900a(str2, C8993Mb.f21467a).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) m25900a(str2, C8972Lb.f21419a).get();
            } catch (Exception e) {
                if (e instanceof TimeoutException) {
                    return str;
                }
                return null;
            }
        } else if (longValue < 0) {
            return (String) m25898a(str2, context);
        } else {
            Future submit = m25901a().submit(new C9014Nb(this, context));
            try {
                return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
            } catch (Exception e2) {
                submit.cancel(true);
                if (e2 instanceof TimeoutException) {
                    return str;
                }
                return null;
            }
        }
    }

    /* renamed from: c */
    public final String mo30127c(Context context) {
        if (!mo30134f(context)) {
            return null;
        }
        if (m25910i(context)) {
            Long l = (Long) m25899a("getAdEventId", (T) null, C9035Ob.f21530a);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object a = m25898a("generateEventId", context);
        if (a != null) {
            return a.toString();
        }
        return null;
    }

    /* renamed from: d */
    public final String mo30129d(Context context) {
        if (!mo30134f(context)) {
            return null;
        }
        synchronized (this.f24862b) {
            if (this.f24864d != null) {
                String str = this.f24864d;
                return str;
            }
            if (m25910i(context)) {
                this.f24864d = (String) m25899a("getAppIdOrigin", (T) this.f24864d, C9056Pb.f21577a);
            } else {
                this.f24864d = "fa";
            }
            String str2 = this.f24864d;
            return str2;
        }
    }

    /* renamed from: d */
    public final void mo30130d(Context context, String str) {
        m25903a(context, "_ac", str, (Bundle) null);
    }

    /* renamed from: e */
    public final void mo30132e(Context context, String str) {
        m25903a(context, "_ai", str, (Bundle) null);
    }

    /* renamed from: f */
    public final void mo30133f(Context context, String str) {
        m25903a(context, "_aq", str, (Bundle) null);
    }

    /* renamed from: g */
    public final void mo30136g(Context context, String str) {
        m25903a(context, "_aa", str, (Bundle) null);
    }

    /* renamed from: a */
    public final void mo30123a(Context context, String str, String str2, String str3, int i) {
        if (mo30134f(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("type", str3);
            bundle.putInt(DonationsAnalytics.VALUE, i);
            m25903a(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzawz.m26003f(sb.toString());
        }
    }

    /* renamed from: a */
    private final void m25903a(Context context, String str, String str2, Bundle bundle) {
        if (mo30134f(context)) {
            Bundle a = m25897a(str2, str);
            if (bundle != null) {
                a.putAll(bundle);
            }
            String str3 = "logEventInternal";
            if (m25910i(context)) {
                m25905a(str3, (C9118Sb) new C8846Fb(str, a));
                return;
            }
            if (m25906a(context, "com.google.android.gms.measurement.AppMeasurement", this.f24867g, true)) {
                Method h = m25907h(context);
                try {
                    h.invoke(this.f24867g.get(), new Object[]{"am", str, a});
                } catch (Exception e) {
                    m25904a(e, str3, true);
                }
            }
        }
    }

    /* renamed from: a */
    private static Bundle m25897a(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String str3 = "Invalid event ID: ";
            String valueOf = String.valueOf(str);
            zzbad.m26356b(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    /* renamed from: h */
    private final Method m25907h(Context context) {
        String str = "logEventInternal";
        Method method = (Method) this.f24869i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class, String.class, Bundle.class});
            this.f24869i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m25904a(e, str, true);
            return null;
        }
    }

    /* renamed from: h */
    private final Method m25908h(Context context, String str) {
        Method method = (Method) this.f24869i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.f24869i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m25904a(e, str, false);
            return null;
        }
    }

    /* renamed from: i */
    private final Method m25909i(Context context, String str) {
        Method method = (Method) this.f24869i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.f24869i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m25904a(e, str, false);
            return null;
        }
    }

    /* renamed from: j */
    private final Method m25911j(Context context, String str) {
        Method method = (Method) this.f24869i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.f24869i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m25904a(e, str, false);
            return null;
        }
    }

    /* renamed from: a */
    private final void m25902a(Context context, String str, String str2) {
        if (m25906a(context, "com.google.android.gms.measurement.AppMeasurement", this.f24867g, true)) {
            Method h = m25908h(context, str2);
            try {
                h.invoke(this.f24867g.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzawz.m26003f(sb.toString());
            } catch (Exception e) {
                m25904a(e, str2, false);
            }
        }
    }

    /* renamed from: a */
    private final Object m25898a(String str, Context context) {
        if (!m25906a(context, "com.google.android.gms.measurement.AppMeasurement", this.f24867g, true)) {
            return null;
        }
        try {
            return m25909i(context, str).invoke(this.f24867g.get(), new Object[0]);
        } catch (Exception e) {
            m25904a(e, str, true);
            return null;
        }
    }

    /* renamed from: a */
    private final void m25904a(Exception exc, String str, boolean z) {
        if (!this.f24865e.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzbad.m26359d(sb.toString());
            if (z) {
                zzbad.m26359d("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.f24865e.set(true);
            }
        }
    }

    /* renamed from: a */
    private final ThreadPoolExecutor m25901a() {
        if (this.f24861a.get() == null) {
            AtomicReference<ThreadPoolExecutor> atomicReference = this.f24861a;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzyt.m31536e().mo29599a(zzacu.f23927Fa)).intValue(), ((Integer) zzyt.m31536e().mo29599a(zzacu.f23927Fa)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new C9077Qb(this));
            atomicReference.compareAndSet(null, threadPoolExecutor);
        }
        return (ThreadPoolExecutor) this.f24861a.get();
    }

    /* renamed from: a */
    private final boolean m25906a(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        String str2 = "getInstance";
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod(str2, new Class[]{Context.class}).invoke(null, new Object[]{context}));
            } catch (Exception e) {
                m25904a(e, str2, z);
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private final void m25905a(String str, C9118Sb sb) {
        synchronized (this.f24870j) {
            FutureTask futureTask = new FutureTask(new C8867Gb(this, sb, str), null);
            if (this.f24870j.get() != null) {
                futureTask.run();
            } else {
                this.f24871k.add(futureTask);
            }
        }
    }

    /* renamed from: a */
    private final <T> Future<T> m25900a(String str, C9097Rb<T> rb) {
        FutureTask futureTask;
        synchronized (this.f24870j) {
            futureTask = new FutureTask(new C8888Hb(this, rb, str));
            if (this.f24870j.get() != null) {
                m25901a().submit(futureTask);
            } else {
                this.f24871k.add(futureTask);
            }
        }
        return futureTask;
    }

    /* renamed from: a */
    private final <T> T m25899a(String str, T t, C9097Rb<T> rb) {
        synchronized (this.f24870j) {
            if (((zzbjf) this.f24870j.get()) != null) {
                try {
                    T a = rb.mo28345a((zzbjf) this.f24870j.get());
                    return a;
                } catch (Exception e) {
                    m25904a(e, str, false);
                    return t;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ Object mo30120a(C9097Rb rb, String str) throws Exception {
        try {
            return rb.mo28345a((zzbjf) this.f24870j.get());
        } catch (Exception e) {
            m25904a(e, str, false);
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30124a(C9118Sb sb, String str) {
        if (((zzbjf) this.f24870j.get()) != null) {
            try {
                sb.mo28115a((zzbjf) this.f24870j.get());
            } catch (Exception e) {
                m25904a(e, str, false);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final /* synthetic */ String mo30131e(Context context) throws Exception {
        return (String) m25898a("getAppInstanceId", context);
    }
}
