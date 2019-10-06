package p019d.p273h.p276c.p284h;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import p019d.p273h.p276c.C12791c;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;

/* renamed from: d.h.c.h.f */
/* compiled from: DailyCappingManager */
public class C12912f {

    /* renamed from: a */
    private Map<String, Integer> f39639a;

    /* renamed from: b */
    private Map<String, Integer> f39640b;

    /* renamed from: c */
    private Map<String, String> f39641c;

    /* renamed from: d */
    private String f39642d;

    /* renamed from: e */
    private Context f39643e;

    /* renamed from: f */
    private Timer f39644f = null;

    /* renamed from: g */
    private C12910d f39645g;

    /* renamed from: h */
    private C12802d f39646h;

    public C12912f(String adUnitName, C12910d listener) {
        this.f39642d = adUnitName;
        this.f39645g = listener;
        this.f39639a = new HashMap();
        this.f39640b = new HashMap();
        this.f39641c = new HashMap();
        this.f39646h = C12802d.m41613c();
        m41910d();
    }

    /* renamed from: a */
    public void mo41686a(Context context) {
        this.f39643e = context;
    }

    /* renamed from: a */
    public void mo41687a(C12791c smash) {
        synchronized (this) {
            try {
                if (smash.mo41399p() != 99) {
                    this.f39639a.put(m41912e(smash), Integer.valueOf(smash.mo41399p()));
                }
            } catch (Exception e) {
                this.f39646h.mo41426a(C12801a.INTERNAL, "addSmash", (Throwable) e);
            }
        }
    }

    /* renamed from: b */
    public void mo41688b(C12791c smash) {
        synchronized (this) {
            try {
                String smashId = m41912e(smash);
                if (this.f39639a.containsKey(smashId)) {
                    m41904a(smashId, m41911e(smashId) + 1);
                }
            } catch (Exception e) {
                this.f39646h.mo41426a(C12801a.INTERNAL, "increaseShowCounter", (Throwable) e);
            }
        }
    }

    /* renamed from: d */
    public boolean mo41690d(C12791c smash) {
        synchronized (this) {
            boolean z = false;
            try {
                String smashId = m41912e(smash);
                if (!this.f39639a.containsKey(smashId)) {
                    return false;
                }
                if (m41902a().equalsIgnoreCase(m41905b(smashId))) {
                    return false;
                }
                if (((Integer) this.f39639a.get(smashId)).intValue() <= m41901a(smashId)) {
                    z = true;
                }
                return z;
            } catch (Exception e) {
                this.f39646h.mo41426a(C12801a.INTERNAL, "shouldSendCapReleasedEvent", (Throwable) e);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public boolean mo41689c(C12791c smash) {
        synchronized (this) {
            boolean z = false;
            try {
                String smashId = m41912e(smash);
                if (!this.f39639a.containsKey(smashId)) {
                    return false;
                }
                if (((Integer) this.f39639a.get(smashId)).intValue() <= m41911e(smashId)) {
                    z = true;
                }
                return z;
            } catch (Exception e) {
                this.f39646h.mo41426a(C12801a.INTERNAL, "isCapped", (Throwable) e);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41908c() {
        synchronized (this) {
            try {
                for (String smashId : this.f39639a.keySet()) {
                    m41913f(smashId);
                }
                this.f39645g.mo41684b();
                m41910d();
            } catch (Exception e) {
                this.f39646h.mo41426a(C12801a.INTERNAL, "onTimerTick", (Throwable) e);
            }
        }
    }

    /* renamed from: d */
    private void m41910d() {
        Timer timer = this.f39644f;
        if (timer != null) {
            timer.cancel();
        }
        this.f39644f = new Timer();
        this.f39644f.schedule(new C12911e(this), m41906b());
    }

    /* renamed from: b */
    private Date m41906b() {
        Random random = new Random();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.US);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, random.nextInt(10));
        gregorianCalendar.set(13, random.nextInt(60));
        gregorianCalendar.set(14, random.nextInt(1000));
        gregorianCalendar.add(5, 1);
        return gregorianCalendar.getTime();
    }

    /* renamed from: e */
    private int m41911e(String smashId) {
        if (!m41902a().equalsIgnoreCase(m41905b(smashId))) {
            m41913f(smashId);
        }
        return m41901a(smashId);
    }

    /* renamed from: b */
    private String m41905b(String smashId) {
        if (this.f39641c.containsKey(smashId)) {
            return (String) this.f39641c.get(smashId);
        }
        String ret = C12916j.m41980c(this.f39643e, m41909d(smashId), m41902a());
        this.f39641c.put(smashId, ret);
        return ret;
    }

    /* renamed from: a */
    private int m41901a(String smashId) {
        if (this.f39640b.containsKey(smashId)) {
            return ((Integer) this.f39640b.get(smashId)).intValue();
        }
        int ret = C12916j.m41956a(this.f39643e, m41907c(smashId), 0);
        this.f39640b.put(smashId, Integer.valueOf(ret));
        return ret;
    }

    /* renamed from: a */
    private void m41904a(String smashId, int counter) {
        this.f39640b.put(smashId, Integer.valueOf(counter));
        this.f39641c.put(smashId, m41902a());
        C12916j.m41976b(this.f39643e, m41907c(smashId), counter);
        C12916j.m41989f(this.f39643e, m41909d(smashId), m41902a());
    }

    /* renamed from: f */
    private void m41913f(String smashId) {
        this.f39640b.put(smashId, Integer.valueOf(0));
        this.f39641c.put(smashId, m41902a());
        C12916j.m41976b(this.f39643e, m41907c(smashId), 0);
        C12916j.m41989f(this.f39643e, m41909d(smashId), m41902a());
    }

    /* renamed from: e */
    private String m41912e(C12791c smash) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39642d);
        String str = "_";
        sb.append(str);
        sb.append(smash.mo41406w());
        sb.append(str);
        sb.append(smash.mo41403t());
        return sb.toString();
    }

    /* renamed from: c */
    private String m41907c(String smashId) {
        StringBuilder sb = new StringBuilder();
        sb.append(smashId);
        sb.append("_counter");
        return sb.toString();
    }

    /* renamed from: d */
    private String m41909d(String smashId) {
        StringBuilder sb = new StringBuilder();
        sb.append(smashId);
        sb.append("_day");
        return sb.toString();
    }

    /* renamed from: a */
    private String m41902a() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date());
    }
}
