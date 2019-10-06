package p363i.p369c.p371b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import p363i.p369c.C14231a;
import p363i.p369c.C14236b;
import p363i.p369c.p370a.C14235d;

/* renamed from: i.c.b.h */
/* compiled from: SubstituteLoggerFactory */
public class C14244h implements C14231a {

    /* renamed from: a */
    boolean f43179a = false;

    /* renamed from: b */
    final Map<String, C14243g> f43180b = new HashMap();

    /* renamed from: c */
    final LinkedBlockingQueue<C14235d> f43181c = new LinkedBlockingQueue<>();

    /* renamed from: a */
    public synchronized C14236b mo44339a(String name) {
        C14243g logger;
        logger = (C14243g) this.f43180b.get(name);
        if (logger == null) {
            logger = new C14243g(name, this.f43181c, this.f43179a);
            this.f43180b.put(name, logger);
        }
        return logger;
    }

    /* renamed from: c */
    public List<C14243g> mo44375c() {
        return new ArrayList(this.f43180b.values());
    }

    /* renamed from: b */
    public LinkedBlockingQueue<C14235d> mo44374b() {
        return this.f43181c;
    }

    /* renamed from: d */
    public void mo44376d() {
        this.f43179a = true;
    }

    /* renamed from: a */
    public void mo44373a() {
        this.f43180b.clear();
        this.f43181c.clear();
    }
}
