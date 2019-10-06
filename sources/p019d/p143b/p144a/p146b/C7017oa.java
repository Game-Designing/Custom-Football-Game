package p019d.p143b.p144a.p146b;

import android.net.Uri;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p145a.C6929e;
import p019d.p143b.p144a.p145a.C6932h;
import p019d.p143b.p144a.p145a.C6936l;
import p019d.p143b.p144a.p145a.C6937m;
import p019d.p143b.p144a.p145a.C6938n;
import p019d.p143b.p144a.p145a.C6942r;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.oa */
public class C7017oa extends C6950D {

    /* renamed from: V */
    private final Set<C6936l> f13082V = new HashSet();

    /* renamed from: a */
    private void m14499a(C6929e eVar) {
        m14500a(eVar, C6932h.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m14500a(C6929e eVar, C6932h hVar) {
        m14502a(eVar, "", hVar);
    }

    /* renamed from: a */
    private void m14501a(C6929e eVar, String str) {
        m14502a(eVar, str, C6932h.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m14502a(C6929e eVar, String str, C6932h hVar) {
        if (mo22501h()) {
            m14504a(((C6925a) this.f12865i).mo22396a(eVar, str), hVar);
        }
    }

    /* renamed from: a */
    private void m14503a(Set<C6936l> set) {
        m14504a(set, C6932h.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m14504a(Set<C6936l> set, C6932h hVar) {
        if (mo22501h() && set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.f12844H.getCurrentPosition());
            C6942r qa = m14506da().mo22410qa();
            Uri a = qa != null ? qa.mo22476a() : null;
            C7262l lVar = this.f12862f;
            StringBuilder sb = new StringBuilder();
            sb.append("Firing ");
            sb.append(set.size());
            sb.append(" tracker(s): ");
            sb.append(set);
            lVar.mo22918c("InterstitialActivity", sb.toString());
            C6938n.m14210a(set, seconds, a, hVar, this.f12864h);
        }
    }

    /* renamed from: ca */
    private void m14505ca() {
        if (mo22500g() && !this.f13082V.isEmpty()) {
            C7262l lVar = this.f12862f;
            StringBuilder sb = new StringBuilder();
            sb.append("Firing ");
            sb.append(this.f13082V.size());
            sb.append(" un-fired video progress trackers when video was completed.");
            lVar.mo22913a("InterstitialActivity", sb.toString());
            m14503a(this.f13082V);
        }
    }

    /* renamed from: da */
    private C6925a m14506da() {
        if (this.f12865i instanceof C6925a) {
            return (C6925a) this.f12865i;
        }
        return null;
    }

    /* renamed from: a */
    public void mo22493a() {
        super.mo22493a();
        m14499a(C6929e.VIDEO_CLICK);
    }

    /* renamed from: c */
    public void mo22496c() {
        if (mo22501h()) {
            String str = "close";
            m14501a(C6929e.VIDEO, str);
            m14501a(C6929e.COMPANION, str);
        }
        super.mo22496c();
    }

    /* renamed from: f */
    public void mo22499f() {
        m14500a(C6929e.ERROR, C6932h.MEDIA_FILE_ERROR);
        super.mo22499f();
    }

    /* renamed from: j */
    public void mo22503j() {
        this.f12856T.mo22685a("PROGRESS_TRACKING", this.f12863g.mo23260B(), (C7024s) new C7019pa(this));
        super.mo22503j();
    }

    /* renamed from: m */
    public void mo22506m() {
        if (mo22501h()) {
            m14505ca();
            if (!C6938n.m14217c(m14506da())) {
                mo22496c();
                return;
            } else if (!this.f12875s) {
                m14501a(C6929e.COMPANION, "creativeView");
            } else {
                return;
            }
        }
        super.mo22506m();
    }

    /* renamed from: n */
    public void mo22507n() {
        m14501a(C6929e.VIDEO, "skip");
        super.mo22507n();
    }

    /* renamed from: o */
    public void mo22508o() {
        String str;
        C6929e eVar;
        super.mo22508o();
        if (this.f12877u) {
            eVar = C6929e.VIDEO;
            str = "mute";
        } else {
            eVar = C6929e.VIDEO;
            str = "unmute";
        }
        m14501a(eVar, str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mo22501h()) {
            String b = m14506da().mo22399b(this.f12866j);
            if (C7269s.m15819a(b)) {
                this.f12862f.mo22918c("InterstitialActivity", "Firing AppLovin impression...");
                this.f12864h.mo23077v().mo23085a(b, null, false);
            }
            this.f13082V.addAll(m14506da().mo22397a(C6929e.VIDEO, C6937m.f12805a));
            m14499a(C6929e.IMPRESSION);
            m14501a(C6929e.VIDEO, "creativeView");
        }
    }

    /* renamed from: p */
    public void mo22683p() {
        if (mo22501h()) {
            long seconds = ((long) this.f12881y) - TimeUnit.MILLISECONDS.toSeconds((long) (this.f12844H.getDuration() - this.f12844H.getCurrentPosition()));
            HashSet hashSet = new HashSet();
            for (C6936l lVar : new HashSet(this.f13082V)) {
                if (lVar.mo22460a(seconds, mo22498e())) {
                    hashSet.add(lVar);
                    this.f13082V.remove(lVar);
                }
            }
            m14503a((Set<C6936l>) hashSet);
        }
    }
}
