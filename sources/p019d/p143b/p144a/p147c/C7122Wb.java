package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Wb */
class C7122Wb implements Runnable {

    /* renamed from: a */
    private final String f13399a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C7184mb f13400b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C7113Tb f13401c;

    /* renamed from: d */
    final /* synthetic */ C7110Sb f13402d;

    C7122Wb(C7110Sb sb, C7184mb mbVar, C7113Tb tb) {
        this.f13402d = sb;
        this.f13399a = mbVar.mo23203a();
        this.f13400b = mbVar;
        this.f13401c = tb;
    }

    public void run() {
        StringBuilder sb;
        long j;
        C7262l lVar;
        String str = "ms.";
        String str2 = " with queue size ";
        String str3 = " queue finished task ";
        String str4 = "TaskManager";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C7182m.m15318a();
            if (this.f13402d.f13368b.mo23065j()) {
                if (!this.f13400b.f13628e) {
                    this.f13402d.f13369c.mo22920d(this.f13399a, "Task re-scheduled...");
                    this.f13402d.mo22971a(this.f13400b, this.f13401c, 2000);
                    j = this.f13402d.m14919a(this.f13401c) - 1;
                    lVar = this.f13402d.f13369c;
                    sb = new StringBuilder();
                    sb.append(this.f13401c);
                    sb.append(str3);
                    sb.append(this.f13400b.mo23203a());
                    sb.append(str2);
                    sb.append(j);
                    lVar.mo22920d(str4, sb.toString());
                }
            }
            this.f13402d.f13369c.mo22920d(this.f13399a, "Task started execution...");
            this.f13400b.run();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            C7262l b = this.f13402d.f13369c;
            String str5 = this.f13399a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Task executed successfully in ");
            sb2.append(currentTimeMillis2);
            sb2.append(str);
            b.mo22920d(str5, sb2.toString());
            C7076J f = this.f13402d.f13368b.mo23061f();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f13399a);
            sb3.append("_count");
            f.mo22861a(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.f13399a);
            sb4.append("_time");
            f.mo22862a(sb4.toString(), currentTimeMillis2);
            j = this.f13402d.m14919a(this.f13401c) - 1;
            lVar = this.f13402d.f13369c;
            sb = new StringBuilder();
        } catch (Throwable th) {
            long a = this.f13402d.m14919a(this.f13401c) - 1;
            C7262l b2 = this.f13402d.f13369c;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f13401c);
            sb5.append(str3);
            sb5.append(this.f13400b.mo23203a());
            sb5.append(str2);
            sb5.append(a);
            b2.mo22920d(str4, sb5.toString());
            throw th;
        }
        sb.append(this.f13401c);
        sb.append(str3);
        sb.append(this.f13400b.mo23203a());
        sb.append(str2);
        sb.append(j);
        lVar.mo22920d(str4, sb.toString());
    }
}
