package p019d.p143b.p144a.p146b;

import android.os.Handler;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.q */
public final class C7020q {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7262l f13088a;

    /* renamed from: b */
    private final Handler f13089b;

    /* renamed from: c */
    private final Set<C7026t> f13090c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicInteger f13091d = new AtomicInteger();

    public C7020q(Handler handler, C7267q qVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (qVar != null) {
            this.f13089b = handler;
            this.f13088a = qVar.mo23049b();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14519a(C7026t tVar, int i) {
        this.f13089b.postDelayed(new C7022r(this, tVar, i), tVar.m14541b());
    }

    /* renamed from: a */
    public void mo22684a() {
        HashSet<C7026t> hashSet = new HashSet<>(this.f13090c);
        C7262l lVar = this.f13088a;
        StringBuilder sb = new StringBuilder();
        sb.append("Starting ");
        sb.append(hashSet.size());
        sb.append(" countdowns...");
        String str = "CountdownManager";
        lVar.mo22918c(str, sb.toString());
        int incrementAndGet = this.f13091d.incrementAndGet();
        for (C7026t tVar : hashSet) {
            C7262l lVar2 = this.f13088a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Starting countdown: ");
            sb2.append(tVar.m14539a());
            sb2.append(" for generation ");
            sb2.append(incrementAndGet);
            sb2.append("...");
            lVar2.mo22918c(str, sb2.toString());
            m14519a(tVar, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void mo22685a(String str, long j, C7024s sVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f13089b != null) {
            C7262l lVar = this.f13088a;
            StringBuilder sb = new StringBuilder();
            sb.append("Adding countdown: ");
            sb.append(str);
            lVar.mo22918c("CountdownManager", sb.toString());
            C7026t tVar = new C7026t(str, j, sVar, null);
            this.f13090c.add(tVar);
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    /* renamed from: b */
    public void mo22686b() {
        this.f13088a.mo22918c("CountdownManager", "Removing all countdowns...");
        mo22687c();
        this.f13090c.clear();
    }

    /* renamed from: c */
    public void mo22687c() {
        this.f13088a.mo22918c("CountdownManager", "Stopping countdowns...");
        this.f13091d.incrementAndGet();
        this.f13089b.removeCallbacksAndMessages(null);
    }
}
