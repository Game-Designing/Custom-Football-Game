package p019d.p143b.p144a.p147c;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: d.b.a.c.nb */
public class C7188nb {

    /* renamed from: a */
    private static final String[] f13634a;

    /* renamed from: b */
    private static final String[] f13635b;

    /* renamed from: c */
    private static final String[] f13636c;

    /* renamed from: d */
    private static final String[] f13637d;

    /* renamed from: e */
    private final C7142c f13638e;

    /* renamed from: f */
    private final List<String> f13639f = new ArrayList();

    /* renamed from: g */
    private final AtomicBoolean f13640g = new AtomicBoolean();

    /* renamed from: h */
    private final AtomicBoolean f13641h = new AtomicBoolean();

    /* renamed from: i */
    private final AtomicBoolean f13642i = new AtomicBoolean();

    /* renamed from: j */
    private Date f13643j;

    /* renamed from: k */
    private Date f13644k;

    static {
        String str = "paused";
        String str2 = "saved_instance_state";
        f13634a = new String[]{str, str2};
        String str3 = "stopped";
        String str4 = "started";
        f13635b = new String[]{str, str2, str3, str4};
        f13636c = new String[]{str, str3, str2, str4};
        f13637d = new String[]{str2, str, str3, str4};
    }

    C7188nb(C7142c cVar) {
        this.f13638e = cVar;
    }

    /* renamed from: a */
    private static boolean m15341a(List<String> list, String[] strArr) {
        int size = list.size();
        int length = strArr.length;
        if (size == 0 || length == 0 || size < strArr.length) {
            return false;
        }
        int i = size - length;
        for (int i2 = i; i2 < length; i2++) {
            if (!((String) list.get(i2)).equals(strArr[i2 - i])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15345e() {
        this.f13639f.add("paused");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m15347f() {
        this.f13639f.add("saved_instance_state");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m15349g() {
        if (!this.f13642i.get()) {
            if (((Boolean) this.f13638e.mo23039a(C7196pb.f13861od)).booleanValue() && m15341a(this.f13639f, f13634a)) {
                boolean booleanValue = ((Boolean) this.f13638e.mo23039a(C7196pb.f13846ld)).booleanValue();
                long millis = TimeUnit.MINUTES.toMillis(((Long) this.f13638e.mo23039a(C7196pb.f13856nd)).longValue());
                if (this.f13643j == null || System.currentTimeMillis() - this.f13643j.getTime() >= millis) {
                    ((C7146d) this.f13638e.mo23071p()).mo23091a("paused", false);
                    if (booleanValue) {
                        this.f13643j = new Date();
                    }
                }
                if (!booleanValue) {
                    this.f13643j = new Date();
                }
            }
            this.f13639f.add("stopped");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m15350h() {
        if (!this.f13639f.isEmpty()) {
            List<String> list = this.f13639f;
            String str = (String) list.get(list.size() - 1);
            if ("stopped".equals(str) || "saved_instance_state".equals(str)) {
                this.f13639f.add("started");
            } else {
                this.f13639f.clear();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m15351i() {
        if (!this.f13642i.getAndSet(false)) {
            if (m15341a(this.f13639f, f13635b) || m15341a(this.f13639f, f13636c) || m15341a(this.f13639f, f13637d)) {
                boolean booleanValue = ((Boolean) this.f13638e.mo23039a(C7196pb.f13846ld)).booleanValue();
                long millis = TimeUnit.MINUTES.toMillis(((Long) this.f13638e.mo23039a(C7196pb.f13851md)).longValue());
                if (this.f13644k == null || System.currentTimeMillis() - this.f13644k.getTime() >= millis) {
                    ((C7146d) this.f13638e.mo23071p()).mo23091a("resumed", false);
                    if (booleanValue) {
                        this.f13644k = new Date();
                    }
                }
                if (!booleanValue) {
                    this.f13644k = new Date();
                }
                this.f13638e.mo23061f().mo22861a("app_paused_and_resumed");
                this.f13641h.set(true);
            }
            this.f13639f.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m15352j() {
        this.f13639f.clear();
    }

    /* renamed from: a */
    public void mo23206a() {
        this.f13642i.set(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23207a(Context context) {
        if (context != null && C7182m.m15325c() && ((Boolean) this.f13638e.mo23039a(C7196pb.f13841kd)).booleanValue() && !this.f13640g.getAndSet(true)) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            ((Application) context).registerActivityLifecycleCallbacks(new C7192ob(this));
        }
    }

    /* renamed from: b */
    public void mo23208b() {
        this.f13642i.set(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo23209c() {
        return this.f13640g.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo23210d() {
        return this.f13641h.getAndSet(false);
    }
}
