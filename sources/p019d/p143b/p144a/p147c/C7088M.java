package p019d.p143b.p144a.p147c;

import java.util.Map;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.M */
class C7088M implements C7255e {

    /* renamed from: a */
    final /* synthetic */ C7080K f13298a;

    C7088M(C7080K k) {
        this.f13298a = k;
    }

    public void userDeclinedToViewAd(C7251a aVar) {
        this.f13298a.f13259a.mo23049b().mo22918c("IncentivizedAdController", "User declined to view");
    }

    public void userOverQuota(C7251a aVar, Map<String, String> map) {
        C7262l b = this.f13298a.f13259a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("User over quota: ");
        sb.append(map);
        b.mo22918c("IncentivizedAdController", sb.toString());
    }

    public void userRewardRejected(C7251a aVar, Map<String, String> map) {
        C7262l b = this.f13298a.f13259a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Reward rejected: ");
        sb.append(map);
        b.mo22918c("IncentivizedAdController", sb.toString());
    }

    public void userRewardVerified(C7251a aVar, Map<String, String> map) {
        C7262l b = this.f13298a.f13259a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Reward validated: ");
        sb.append(map);
        b.mo22918c("IncentivizedAdController", sb.toString());
    }

    public void validationRequestFailed(C7251a aVar, int i) {
        C7262l b = this.f13298a.f13259a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Reward validation failed: ");
        sb.append(i);
        b.mo22918c("IncentivizedAdController", sb.toString());
    }
}
