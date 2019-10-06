package p019d.p307j.p308a;

import android.text.TextUtils;
import android.util.SparseArray;
import com.liulishuo.filedownloader.model.C10913c;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.File;
import java.util.ArrayList;
import p019d.p307j.p308a.C13069D.C13070a;
import p019d.p307j.p308a.C13079a.C13080a;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.C13079a.C13082c;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: d.j.a.d */
/* compiled from: DownloadTask */
public class C13103d implements C13079a, C13081b, C13109a {

    /* renamed from: a */
    private final C13069D f40095a;

    /* renamed from: b */
    private final C13070a f40096b;

    /* renamed from: c */
    private int f40097c;

    /* renamed from: d */
    private ArrayList<C13080a> f40098d;

    /* renamed from: e */
    private final String f40099e;

    /* renamed from: f */
    private String f40100f;

    /* renamed from: g */
    private String f40101g;

    /* renamed from: h */
    private boolean f40102h;

    /* renamed from: i */
    private FileDownloadHeader f40103i;

    /* renamed from: j */
    private C13130l f40104j;

    /* renamed from: k */
    private SparseArray<Object> f40105k;

    /* renamed from: l */
    private Object f40106l;

    /* renamed from: m */
    private int f40107m = 0;

    /* renamed from: n */
    private boolean f40108n = false;

    /* renamed from: o */
    private boolean f40109o = false;

    /* renamed from: p */
    private int f40110p = 100;

    /* renamed from: q */
    private int f40111q = 10;

    /* renamed from: r */
    private boolean f40112r = false;

    /* renamed from: s */
    volatile int f40113s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f40114t = false;

    /* renamed from: u */
    private final Object f40115u;

    /* renamed from: v */
    private final Object f40116v = new Object();

    /* renamed from: w */
    private volatile boolean f40117w = false;

    /* renamed from: d.j.a.d$a */
    /* compiled from: DownloadTask */
    private static final class C13104a implements C13082c {

        /* renamed from: a */
        private final C13103d f40118a;

        private C13104a(C13103d task) {
            this.f40118a = task;
            this.f40118a.f40114t = true;
        }

        /* renamed from: a */
        public int mo42054a() {
            int id = this.f40118a.getId();
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            C13128k.m42819b().mo42107b((C13081b) this.f40118a);
            return id;
        }
    }

    C13103d(String url) {
        this.f40099e = url;
        this.f40115u = new Object();
        C13108e hunter = new C13108e(this, this.f40115u);
        this.f40095a = hunter;
        this.f40096b = hunter;
    }

    public C13079a setPath(String path) {
        mo42079a(path, false);
        return this;
    }

    /* renamed from: a */
    public C13079a mo42079a(String path, boolean pathAsDirectory) {
        this.f40100f = path;
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "setPath %s", path);
        }
        this.f40102h = pathAsDirectory;
        if (pathAsDirectory) {
            this.f40101g = null;
        } else {
            this.f40101g = new File(path).getName();
        }
        return this;
    }

    /* renamed from: a */
    public C13079a mo42011a(C13130l listener) {
        this.f40104j = listener;
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "setListener %s", listener);
        }
        return this;
    }

    /* renamed from: d */
    public C13079a mo42016d(int callbackProgressCount) {
        this.f40110p = callbackProgressCount;
        return this;
    }

    /* renamed from: a */
    public C13079a mo42010a(int key, Object tag) {
        if (this.f40105k == null) {
            this.f40105k = new SparseArray<>(2);
        }
        this.f40105k.put(key, tag);
        return this;
    }

    /* renamed from: b */
    public C13079a mo42014b(C13080a finishListener) {
        if (this.f40098d == null) {
            this.f40098d = new ArrayList<>();
        }
        if (!this.f40098d.contains(finishListener)) {
            this.f40098d.add(finishListener);
        }
        return this;
    }

    /* renamed from: a */
    public boolean mo42012a(C13080a finishListener) {
        ArrayList<C13080a> arrayList = this.f40098d;
        return arrayList != null && arrayList.remove(finishListener);
    }

    /* renamed from: c */
    public C13079a mo42015c(int autoRetryTimes) {
        this.f40107m = autoRetryTimes;
        return this;
    }

    public C13079a addHeader(String name, String value) {
        m42679J();
        this.f40103i.mo35713a(name, value);
        return this;
    }

    /* renamed from: j */
    public C13082c mo42027j() {
        return new C13104a();
    }

    /* renamed from: I */
    public boolean mo42078I() {
        return this.f40095a.getStatus() != 0;
    }

    /* renamed from: H */
    public boolean mo42077H() {
        if (C13149w.m42916b().mo42164c().mo41972b(this)) {
            return true;
        }
        return C10913c.m35797a((int) getStatus());
    }

    /* renamed from: e */
    public boolean mo42017e() {
        return this.f40113s != 0;
    }

    /* renamed from: K */
    private int m42680K() {
        if (!mo42078I()) {
            if (!mo42017e()) {
                mo42053z();
            }
            this.f40095a.mo41982c();
            return getId();
        } else if (mo42077H()) {
            throw new IllegalStateException(C13121g.m42792a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again.");
            sb.append(this.f40095a.toString());
            throw new IllegalStateException(sb.toString());
        }
    }

    public boolean pause() {
        boolean pause;
        synchronized (this.f40115u) {
            pause = this.f40095a.pause();
        }
        return pause;
    }

    public int getId() {
        int i = this.f40097c;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.f40100f) || TextUtils.isEmpty(this.f40099e)) {
            return 0;
        }
        int a = C13121g.m42787a(this.f40099e, this.f40100f, this.f40102h);
        this.f40097c = a;
        return a;
    }

    public String getUrl() {
        return this.f40099e;
    }

    /* renamed from: o */
    public int mo42032o() {
        return this.f40110p;
    }

    /* renamed from: k */
    public int mo42028k() {
        return this.f40111q;
    }

    public String getPath() {
        return this.f40100f;
    }

    /* renamed from: q */
    public boolean mo42034q() {
        return this.f40102h;
    }

    /* renamed from: s */
    public String mo42035s() {
        return this.f40101g;
    }

    /* renamed from: u */
    public String mo42037u() {
        return C13121g.m42791a(getPath(), mo42034q(), mo42035s());
    }

    /* renamed from: A */
    public C13130l mo42006A() {
        return this.f40104j;
    }

    /* renamed from: n */
    public int mo42031n() {
        if (this.f40095a.mo41981b() > 2147483647L) {
            return MoPubClientPositioning.NO_REPEAT;
        }
        return (int) this.f40095a.mo41981b();
    }

    /* renamed from: w */
    public long mo42038w() {
        return this.f40095a.mo41981b();
    }

    /* renamed from: i */
    public int mo42026i() {
        if (this.f40095a.mo41983d() > 2147483647L) {
            return MoPubClientPositioning.NO_REPEAT;
        }
        return (int) this.f40095a.mo41983d();
    }

    /* renamed from: y */
    public long mo42039y() {
        return this.f40095a.mo41983d();
    }

    /* renamed from: h */
    public int mo42025h() {
        return this.f40095a.mo42060h();
    }

    public byte getStatus() {
        return this.f40095a.getStatus();
    }

    /* renamed from: D */
    public boolean mo42007D() {
        return this.f40112r;
    }

    /* renamed from: f */
    public Throwable mo42018f() {
        return this.f40095a.mo41984f();
    }

    public Object getTag() {
        return this.f40106l;
    }

    /* renamed from: m */
    public int mo42030m() {
        return this.f40107m;
    }

    /* renamed from: a */
    public int mo42009a() {
        return this.f40095a.mo41980a();
    }

    /* renamed from: G */
    public boolean mo42008G() {
        return this.f40108n;
    }

    /* renamed from: g */
    public boolean mo42019g() {
        return this.f40095a.mo41986g();
    }

    /* renamed from: l */
    public boolean mo42029l() {
        return this.f40109o;
    }

    /* renamed from: J */
    private void m42679J() {
        if (this.f40103i == null) {
            synchronized (this.f40116v) {
                if (this.f40103i == null) {
                    this.f40103i = new FileDownloadHeader();
                }
            }
        }
    }

    /* renamed from: p */
    public FileDownloadHeader mo42082p() {
        return this.f40103i;
    }

    /* renamed from: r */
    public void mo42050r() {
        this.f40117w = true;
    }

    public void free() {
        this.f40095a.free();
        if (C13128k.m42819b().mo42110c((C13081b) this)) {
            this.f40117w = false;
        }
    }

    /* renamed from: C */
    public void mo42041C() {
        m42680K();
    }

    /* renamed from: t */
    public void mo42051t() {
        m42680K();
    }

    /* renamed from: d */
    public Object mo42048d() {
        return this.f40115u;
    }

    /* renamed from: B */
    public boolean mo42040B() {
        return this.f40117w;
    }

    /* renamed from: c */
    public C13081b mo42081c() {
        return this;
    }

    /* renamed from: a */
    public void mo42080a(String fileName) {
        this.f40101g = fileName;
    }

    /* renamed from: x */
    public ArrayList<C13080a> mo42084x() {
        return this.f40098d;
    }

    /* renamed from: F */
    public C13079a mo42043F() {
        return this;
    }

    /* renamed from: v */
    public C13070a mo42052v() {
        return this.f40096b;
    }

    /* renamed from: a */
    public boolean mo42044a(int id) {
        return getId() == id;
    }

    /* renamed from: b */
    public boolean mo42047b(C13130l listener) {
        return mo42006A() == listener;
    }

    /* renamed from: E */
    public boolean mo42042E() {
        return C10913c.m35800b(getStatus());
    }

    /* renamed from: b */
    public int mo42045b() {
        return this.f40113s;
    }

    /* renamed from: b */
    public void mo42046b(int key) {
        this.f40113s = key;
    }

    /* renamed from: z */
    public void mo42053z() {
        int attachKey;
        if (mo42006A() != null) {
            attachKey = mo42006A().hashCode();
        } else {
            attachKey = hashCode();
        }
        this.f40113s = attachKey;
    }

    public String toString() {
        return C13121g.m42792a("%d@%s", Integer.valueOf(getId()), super.toString());
    }
}
