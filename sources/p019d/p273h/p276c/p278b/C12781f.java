package p019d.p273h.p276c.p278b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ironsource.eventsmodule.EventData;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p275b.C12732a;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p275b.C12734c;
import p019d.p273h.p275b.C12735d;
import p019d.p273h.p276c.C12747I;
import p019d.p273h.p276c.C12749J;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12829t;
import p019d.p273h.p276c.p282f.C12870f;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.b.f */
/* compiled from: BaseEventsManager */
public abstract class C12781f implements C12735d {

    /* renamed from: A */
    String f39300A = "outcome";

    /* renamed from: B */
    String f39301B = "RV";

    /* renamed from: C */
    Set<Integer> f39302C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public C12782a f39303D;

    /* renamed from: E */
    private C12749J f39304E;

    /* renamed from: F */
    private C12829t f39305F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C12802d f39306G;

    /* renamed from: a */
    final int f39307a = 1;

    /* renamed from: b */
    final int f39308b = 100;

    /* renamed from: c */
    final int f39309c = 5000;

    /* renamed from: d */
    final int f39310d = 90000;

    /* renamed from: e */
    final int f39311e = 5;

    /* renamed from: f */
    final String f39312f = "supersonic_sdk.db";

    /* renamed from: g */
    final String f39313g = "provider";

    /* renamed from: h */
    final String f39314h = VungleActivity.PLACEMENT_EXTRA;

    /* renamed from: i */
    private final String f39315i = "abt";

    /* renamed from: j */
    private boolean f39316j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f39317k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C12732a f39318l;

    /* renamed from: m */
    private C12776a f39319m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ArrayList<C12733b> f39320n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f39321o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f39322p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f39323q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Context f39324r;

    /* renamed from: s */
    private int f39325s = 100;

    /* renamed from: t */
    private int f39326t = 5000;

    /* renamed from: u */
    private int f39327u = 1;

    /* renamed from: v */
    private int[] f39328v;

    /* renamed from: w */
    private Map<String, String> f39329w = new HashMap();

    /* renamed from: x */
    private Map<String, String> f39330x = new HashMap();

    /* renamed from: y */
    private String f39331y = "";

    /* renamed from: z */
    int f39332z = 3;

    /* renamed from: d.h.c.b.f$a */
    /* compiled from: BaseEventsManager */
    private class C12782a extends HandlerThread {

        /* renamed from: a */
        private Handler f39333a;

        C12782a(String name) {
            super(name);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41376a(Runnable task) {
            this.f39333a.post(task);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41375a() {
            this.f39333a = new Handler(getLooper());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo41347a(C12733b bVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo41349a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo41363b(C12733b bVar);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract boolean mo41366c(C12733b bVar);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo41367d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract void mo41371e(C12733b bVar);

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract boolean mo41373f(C12733b bVar);

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract boolean mo41374g(C12733b bVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo41370e() {
        this.f39320n = new ArrayList<>();
        this.f39322p = 0;
        this.f39319m = C12783g.m41501a(this.f39300A, this.f39332z);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39301B);
        sb.append("EventThread");
        this.f39303D = new C12782a(sb.toString());
        this.f39303D.start();
        this.f39303D.mo41375a();
        this.f39306G = C12802d.m41613c();
        this.f39323q = C12747I.m41186g().mo41239m();
        this.f39302C = new HashSet();
        mo41367d();
    }

    /* renamed from: a */
    public synchronized void mo41350a(Context context, C12749J segment) {
        this.f39300A = C12916j.m41959a(context, this.f39301B, this.f39300A);
        m41452b(this.f39300A);
        this.f39319m.mo41340a(C12916j.m41973b(context, this.f39301B, (String) null));
        this.f39318l = C12732a.m41117a(context, "supersonic_sdk.db", 5);
        m41459g();
        this.f39328v = C12916j.m41970a(context, this.f39301B);
        this.f39304E = segment;
        this.f39324r = context;
    }

    /* renamed from: a */
    public synchronized void mo41352a(C12829t serverSegment) {
        this.f39305F = serverSegment;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized boolean m41449a(String connectionType, C12733b event) {
        return connectionType.equalsIgnoreCase("none") && this.f39302C.contains(Integer.valueOf(event.mo41158c()));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public synchronized int m41461h(C12733b event) {
        return event.mo41158c() + 90000;
    }

    /* renamed from: d */
    public synchronized void mo41369d(C12733b event) {
        this.f39303D.mo41376a(new C12777b(this, event));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m41463h() {
        this.f39317k = false;
        ArrayList<EventData> combinedEventList = m41443a(this.f39320n, this.f39318l.mo41151b(this.f39301B), this.f39326t);
        this.f39320n.clear();
        this.f39318l.mo41149a(this.f39301B);
        this.f39322p = 0;
        if (combinedEventList.size() > 0) {
            JSONObject generalProperties = C12870f.m41821a().mo41643b();
            try {
                m41444a(generalProperties);
                String abt = mo41348a();
                if (!TextUtils.isEmpty(abt)) {
                    generalProperties.put("abt", abt);
                }
                Map<String, String> batchParams = mo41358b();
                if (!batchParams.isEmpty()) {
                    for (Entry<String, String> entry : batchParams.entrySet()) {
                        if (!generalProperties.has((String) entry.getKey())) {
                            generalProperties.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
            String dataToSend = this.f39319m.mo41337a(combinedEventList, generalProperties);
            new C12734c(new C12779d(this)).execute(new Object[]{dataToSend, this.f39319m.mo41341b(), combinedEventList});
        }
    }

    /* renamed from: a */
    private ArrayList<C12733b> m41443a(ArrayList<C12733b> localEvents, ArrayList<C12733b> storedEvents, int maxSize) {
        ArrayList<EventData> allEvents = new ArrayList<>();
        allEvents.addAll(localEvents);
        allEvents.addAll(storedEvents);
        Collections.sort(allEvents, new C12780e(this));
        if (allEvents.size() <= maxSize) {
            return new ArrayList<>(allEvents);
        }
        ArrayList<EventData> result = new ArrayList<>(allEvents.subList(0, maxSize));
        this.f39318l.mo41150a(allEvents.subList(maxSize, allEvents.size()), this.f39301B);
        return result;
    }

    /* renamed from: b */
    private void m41452b(String formatterType) {
        C12776a aVar = this.f39319m;
        if (aVar == null || !aVar.mo41342c().equals(formatterType)) {
            this.f39319m = C12783g.m41501a(formatterType, this.f39332z);
        }
    }

    /* renamed from: b */
    public void mo41359b(int backupThreshold) {
        if (backupThreshold > 0) {
            this.f39327u = backupThreshold;
        }
    }

    /* renamed from: d */
    public void mo41368d(int maxNumberOfEvents) {
        if (maxNumberOfEvents > 0) {
            this.f39325s = maxNumberOfEvents;
        }
    }

    /* renamed from: c */
    public void mo41365c(int maxEventsPerBatch) {
        if (maxEventsPerBatch > 0) {
            this.f39326t = maxEventsPerBatch;
        }
    }

    /* renamed from: a */
    public void mo41357a(int[] optOutEvents, Context context) {
        this.f39328v = optOutEvents;
        C12916j.m41967a(context, this.f39301B, optOutEvents);
    }

    /* renamed from: a */
    public void mo41354a(String eventsUrl, Context context) {
        if (!TextUtils.isEmpty(eventsUrl)) {
            C12776a aVar = this.f39319m;
            if (aVar != null) {
                aVar.mo41340a(eventsUrl);
            }
            C12916j.m41987e(context, this.f39301B, eventsUrl);
        }
    }

    /* renamed from: b */
    public void mo41360b(String formatterType, Context context) {
        if (!TextUtils.isEmpty(formatterType)) {
            this.f39300A = formatterType;
            C12916j.m41985d(context, this.f39301B, formatterType);
            m41452b(formatterType);
        }
    }

    /* renamed from: b */
    public void mo41362b(boolean isEnabled) {
        this.f39321o = isEnabled;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m41459g() {
        this.f39318l.mo41150a((List<C12733b>) this.f39320n, this.f39301B);
        this.f39320n.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m41465i() {
        return (this.f39322p >= this.f39325s || this.f39317k) && this.f39316j;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m41450a(ArrayList<C12733b> events) {
        if (events == null) {
            return false;
        }
        return events.size() >= this.f39327u;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m41468j(C12733b event) {
        if (event == null) {
            return true;
        }
        int[] iArr = this.f39328v;
        if (iArr == null || iArr.length <= 0) {
            return true;
        }
        int eventId = event.mo41158c();
        int i = 0;
        while (true) {
            int[] iArr2 = this.f39328v;
            if (i >= iArr2.length) {
                return true;
            }
            if (eventId == iArr2[i]) {
                return false;
            }
            i++;
        }
    }

    /* renamed from: a */
    public void mo41356a(boolean hasResponse) {
        this.f39316j = hasResponse;
    }

    /* renamed from: f */
    public void mo41372f() {
        m41463h();
    }

    /* renamed from: a */
    public void mo41351a(C12733b eventData, String url) {
        try {
            ArrayList<EventData> singleEventArray = new ArrayList<>();
            singleEventArray.add(eventData);
            String dataToSend = this.f39319m.mo41337a(singleEventArray, C12870f.m41821a().mo41643b());
            new C12734c().execute(new Object[]{dataToSend, url, null});
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m41444a(JSONObject object) {
        try {
            if (this.f39304E == null) {
                try {
                    if (this.f39305F != null) {
                        String id = this.f39305F.mo41574b();
                        if (!TextUtils.isEmpty(id)) {
                            object.put("segmentId", id);
                        }
                        JSONObject customs = this.f39305F.mo41573a();
                        Iterator<String> iterator = customs.keys();
                        while (iterator.hasNext()) {
                            String key = (String) iterator.next();
                            object.put(key, customs.get(key));
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                }
            } else {
                this.f39304E.mo41241a();
                throw null;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo41353a(String abt) {
        this.f39331y = abt;
    }

    /* renamed from: a */
    public String mo41348a() {
        return this.f39331y;
    }

    /* renamed from: a */
    public void mo41355a(Map<String, String> batchParams) {
        this.f39329w.putAll(batchParams);
    }

    /* renamed from: b */
    public Map<String, String> mo41358b() {
        return this.f39329w;
    }

    /* renamed from: b */
    public void mo41361b(Map<String, String> genericParams) {
        this.f39330x.putAll(genericParams);
    }

    /* renamed from: c */
    public Map<String, String> mo41364c() {
        return this.f39330x;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m41466i(C12733b event) {
        return (event.mo41158c() == 14 || event.mo41158c() == 140 || event.mo41158c() == 40 || event.mo41158c() == 41) ? false : true;
    }
}
