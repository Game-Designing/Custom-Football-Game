package p019d.p273h.p276c.p278b;

import android.text.TextUtils;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.Map.Entry;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.b.b */
/* compiled from: BaseEventsManager */
class C12777b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12733b f39293a;

    /* renamed from: b */
    final /* synthetic */ C12781f f39294b;

    C12777b(C12781f this$0, C12733b bVar) {
        this.f39294b = this$0;
        this.f39293a = bVar;
    }

    public void run() {
        String str = ",";
        if (this.f39293a != null && this.f39294b.f39321o) {
            this.f39293a.mo41156a("eventSessionId", this.f39294b.f39323q);
            String connectionType = C12916j.m41958a(this.f39294b.f39324r);
            if (!(this.f39293a.mo41158c() == 40 || this.f39293a.mo41158c() == 41)) {
                this.f39293a.mo41156a("connectionType", connectionType);
            }
            if (this.f39294b.m41449a(connectionType, this.f39293a)) {
                C12733b bVar = this.f39293a;
                bVar.mo41155a(this.f39294b.m41461h(bVar));
            }
            if (!this.f39294b.mo41364c().isEmpty()) {
                for (Entry<String, String> entry : this.f39294b.mo41364c().entrySet()) {
                    if (!(this.f39293a.mo41157b().has((String) entry.getKey()) || entry.getKey() == "eventId" || entry.getKey() == "timestamp")) {
                        this.f39293a.mo41156a((String) entry.getKey(), entry.getValue());
                    }
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("{\"eventId\":");
                sb.append(this.f39293a.mo41158c());
                sb.append(",\"timestamp\":");
                sb.append(this.f39293a.mo41159d());
                sb.append(str);
                sb.append(this.f39293a.mo41154a().substring(1));
                this.f39294b.f39306G.mo41427b(C12801a.EVENT, sb.toString().replace(str, "\n"), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f39294b.m41468j(this.f39293a)) {
                if (this.f39294b.m41466i(this.f39293a)) {
                    int sessionDepth = this.f39294b.mo41347a(this.f39293a);
                    if (this.f39294b.mo41363b(this.f39293a)) {
                        sessionDepth = this.f39294b.mo41347a(this.f39293a);
                    }
                    this.f39293a.mo41156a("sessionDepth", Integer.valueOf(sessionDepth));
                }
                if (this.f39294b.mo41373f(this.f39293a)) {
                    this.f39294b.mo41371e(this.f39293a);
                } else if (!TextUtils.isEmpty(this.f39294b.mo41349a(this.f39293a.mo41158c())) && this.f39294b.mo41374g(this.f39293a)) {
                    C12733b bVar2 = this.f39293a;
                    bVar2.mo41156a(VungleActivity.PLACEMENT_EXTRA, this.f39294b.mo41349a(bVar2.mo41158c()));
                }
                this.f39294b.f39320n.add(this.f39293a);
                this.f39294b.f39322p = this.f39294b.f39322p + 1;
            }
            boolean isTopPriority = this.f39294b.mo41366c(this.f39293a);
            if (!this.f39294b.f39317k && isTopPriority) {
                this.f39294b.f39317k = true;
            }
            if (this.f39294b.f39318l != null) {
                if (this.f39294b.m41465i()) {
                    this.f39294b.m41463h();
                } else {
                    C12781f fVar = this.f39294b;
                    if (fVar.m41450a(fVar.f39320n) || isTopPriority) {
                        this.f39294b.m41459g();
                    }
                }
            }
        }
    }
}
