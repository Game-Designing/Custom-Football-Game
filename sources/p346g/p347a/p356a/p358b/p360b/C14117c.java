package p346g.p347a.p356a.p358b.p360b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jmdns.impl.DNSStatefulObject;
import p346g.p347a.C13821d;
import p346g.p347a.p356a.C14096C;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14146k;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p357a.C14107h;
import p346g.p347a.p356a.p358b.C14110a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.b.b.c */
/* compiled from: DNSStateTask */
public abstract class C14117c extends C14110a {

    /* renamed from: b */
    static C14236b f42911b = C14246c.m45851a(C14117c.class.getName());

    /* renamed from: c */
    private static int f42912c = 3600;

    /* renamed from: d */
    private final int f42913d;

    /* renamed from: e */
    private C14107h f42914e = null;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C14127g mo43891a(C14096C c, C14127g gVar) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C14127g mo43892a(C14127g gVar) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo43893a(Throwable th);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo43895c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract boolean mo43897d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract C14127g mo43898e();

    /* renamed from: h */
    public abstract String mo43899h();

    /* renamed from: f */
    public static int m45191f() {
        return f42912c;
    }

    public C14117c(C14164v jmDNSImpl, int ttl) {
        super(jmDNSImpl);
        this.f42913d = ttl;
    }

    /* renamed from: g */
    public int mo43905g() {
        return this.f42913d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43902a(C14107h state) {
        synchronized (mo43880a()) {
            mo43880a().mo44105a((C14110a) this, state);
        }
        for (C14096C a : mo43880a().mo44089J().values()) {
            a.mo43796a((C14110a) this, state);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo43907j() {
        synchronized (mo43880a()) {
            mo43880a().mo44114b((C14110a) this);
        }
        for (C14096C b : mo43880a().mo44089J().values()) {
            b.mo43804b((C14110a) this);
        }
    }

    public void run() {
        C14127g out = mo43898e();
        try {
            if (!mo43897d()) {
                cancel();
                return;
            }
            List<DNSStatefulObject> stateObjects = new ArrayList<>();
            synchronized (mo43880a()) {
                if (mo43880a().mo44118b((C14110a) this, mo43906i())) {
                    C14236b bVar = f42911b;
                    StringBuilder sb = new StringBuilder();
                    sb.append(mo43881b());
                    sb.append(".run() JmDNS ");
                    sb.append(mo43899h());
                    sb.append(" ");
                    sb.append(mo43880a().mo44087G());
                    bVar.mo44340a(sb.toString());
                    stateObjects.add(mo43880a());
                    out = mo43892a(out);
                }
            }
            for (C13821d serviceInfo : mo43880a().mo44089J().values()) {
                C14096C info = (C14096C) serviceInfo;
                synchronized (info) {
                    if (info.mo43807b(this, mo43906i())) {
                        C14236b bVar2 = f42911b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(mo43881b());
                        sb2.append(".run() JmDNS ");
                        sb2.append(mo43899h());
                        sb2.append(" ");
                        sb2.append(info.mo43181o());
                        bVar2.mo44340a(sb2.toString());
                        stateObjects.add(info);
                        out = mo43891a(info, out);
                    }
                }
            }
            if (!out.mo43945n()) {
                C14236b bVar3 = f42911b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mo43881b());
                sb3.append(".run() JmDNS ");
                sb3.append(mo43899h());
                sb3.append(" #");
                sb3.append(mo43906i());
                bVar3.mo44340a(sb3.toString());
                mo43880a().mo44109a(out);
                mo43903a(stateObjects);
                mo43895c();
                return;
            }
            mo43903a(stateObjects);
            cancel();
        } catch (Throwable e) {
            C14236b bVar4 = f42911b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo43881b());
            sb4.append(".run() exception ");
            bVar4.mo44344b(sb4.toString(), e);
            mo43893a(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43903a(List<C14146k> list) {
        if (list != null) {
            for (C14146k object : list) {
                synchronized (object) {
                    object.mo43803a(this);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C14107h mo43906i() {
        return this.f42914e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo43904b(C14107h taskState) {
        this.f42914e = taskState;
    }
}
