package p019d.p143b.p144a.p147c;

import android.content.Context;
import android.widget.Toast;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.S */
public class C7108S {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13364a;

    /* renamed from: b */
    private final String f13365b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f13366c;

    public C7108S(C7142c cVar, Context context, String str) {
        this.f13364a = cVar;
        this.f13365b = str;
        this.f13366c = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22950a() {
        C7269s.m15816a((Runnable) new C7111T(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22951a(String str, Throwable th) {
        this.f13364a.mo23049b().mo22919c("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", th);
        Toast.makeText(this.f13366c, str, 1).show();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo22952b() {
        C7142c cVar;
        C7204rb<String> rbVar;
        if (this.f13365b.equals("accepted")) {
            cVar = this.f13364a;
            rbVar = C7196pb.f13798ca;
        } else if (this.f13365b.equals("quota_exceeded")) {
            cVar = this.f13364a;
            rbVar = C7196pb.f13803da;
        } else if (this.f13365b.equals("rejected")) {
            cVar = this.f13364a;
            rbVar = C7196pb.f13808ea;
        } else {
            cVar = this.f13364a;
            rbVar = C7196pb.f13813fa;
        }
        return (String) cVar.mo23039a(rbVar);
    }
}
