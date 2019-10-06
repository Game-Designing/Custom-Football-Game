package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.hc */
class C7165hc implements C7198q<T> {

    /* renamed from: a */
    final /* synthetic */ String f13590a;

    /* renamed from: b */
    final /* synthetic */ C7142c f13591b;

    /* renamed from: c */
    final /* synthetic */ C7161gc f13592c;

    C7165hc(C7161gc gcVar, String str, C7142c cVar) {
        this.f13592c = gcVar;
        this.f13590a = str;
        this.f13591b = cVar;
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        C7204rb rbVar;
        C7161gc gcVar;
        boolean z = false;
        boolean z2 = i < 200 || i >= 500;
        if (i != -103) {
            z = true;
        }
        if (z2 && z) {
            if (this.f13592c.f13556n > 0) {
                C7262l lVar = this.f13592c.f13626c;
                String str = this.f13590a;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to send request due to server failure (code ");
                sb.append(i);
                sb.append("). ");
                sb.append(this.f13592c.f13556n);
                sb.append(" attempts left, retrying in ");
                double b = (double) this.f13592c.f13557o;
                Double.isNaN(b);
                sb.append(b / 1000.0d);
                sb.append(" seconds...");
                lVar.mo22913a(str, sb.toString());
                C7161gc gcVar2 = this.f13592c;
                gcVar2.f13556n = gcVar2.f13556n - 1;
                if (this.f13592c.f13556n == 0) {
                    C7161gc gcVar3 = this.f13592c;
                    gcVar3.m15223c(gcVar3.f13558p);
                    if (!TextUtils.isEmpty(this.f13592c.f13552j) && this.f13592c.f13552j.length() >= 4) {
                        C7161gc gcVar4 = this.f13592c;
                        gcVar4.f13551i = gcVar4.f13552j;
                        C7161gc gcVar5 = this.f13592c;
                        C7262l lVar2 = gcVar5.f13626c;
                        String a = gcVar5.mo23203a();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Switching to backup endpoint ");
                        sb2.append(this.f13592c.f13552j);
                        lVar2.mo22920d(a, sb2.toString());
                    }
                }
                C7110Sb C = this.f13591b.mo23027C();
                C7161gc gcVar6 = this.f13592c;
                C.mo22971a((C7184mb) gcVar6, C7113Tb.BACKGROUND, gcVar6.f13557o);
                return;
            }
            if (this.f13592c.f13552j == null || !this.f13592c.f13552j.equals(this.f13592c.f13551i)) {
                gcVar = this.f13592c;
                rbVar = gcVar.f13558p;
            } else {
                gcVar = this.f13592c;
                rbVar = gcVar.f13559q;
            }
            gcVar.m15223c(rbVar);
        }
        this.f13592c.mo22856a(i);
    }

    /* renamed from: a */
    public void mo22857a(T t, int i) {
        this.f13592c.f13556n = 0;
        this.f13592c.mo22857a(t, i);
    }
}
