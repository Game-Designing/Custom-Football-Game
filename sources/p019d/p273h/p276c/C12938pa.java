package p019d.p273h.p276c;

import android.app.Activity;
import java.util.Timer;
import org.json.JSONObject;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12881ka;
import p019d.p273h.p276c.p282f.C12883la;
import p019d.p273h.p276c.p282f.C12885ma;

/* renamed from: d.h.c.pa */
/* compiled from: RewardedVideoSmash */
public class C12938pa extends C12791c implements C12885ma, C12883la {

    /* renamed from: v */
    private JSONObject f39831v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C12881ka f39832w;

    /* renamed from: x */
    private String f39833x;

    /* renamed from: y */
    private int f39834y;

    /* renamed from: z */
    private final String f39835z;

    C12938pa(C12826q adapterConfigs, int timeout) {
        super(adapterConfigs);
        String str = "requestUrl";
        this.f39835z = str;
        this.f39831v = adapterConfigs.mo41554k();
        this.f39833x = this.f39831v.optString(str);
        this.f39834y = timeout;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo41184k() {
        this.f39360k = 0;
        mo41388a(mo41753F() ? C12792a.AVAILABLE : C12792a.NOT_AVAILABLE);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: H */
    public void mo41755H() {
        try {
            mo41383C();
            this.f39361l = new Timer();
            this.f39361l.schedule(new C12936oa(this), (long) (this.f39834y * 1000));
        } catch (Exception e) {
            mo41390a("startInitTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public String mo41185m() {
        return "rewardedvideo";
    }

    /* renamed from: a */
    public void mo41756a(Activity activity, String appKey, String userId) {
        mo41755H();
        C12775b bVar = this.f39351b;
        if (bVar != null) {
            bVar.addRewardedVideoListener(this);
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41398o());
            sb.append(":initRewardedVideo()");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.initRewardedVideo(activity, appKey, userId, this.f39831v, this);
        }
    }

    /* renamed from: E */
    public void mo41752E() {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41398o());
            sb.append(":fetchRewardedVideo()");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.fetchRewardedVideo(this.f39831v);
        }
    }

    /* renamed from: G */
    public void mo41754G() {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41398o());
            sb.append(":showRewardedVideo()");
            dVar.mo41427b(aVar, sb.toString(), 1);
            mo41382B();
            this.f39351b.showRewardedVideo(this.f39831v, this);
        }
    }

    /* renamed from: F */
    public boolean mo41753F() {
        if (this.f39351b == null) {
            return false;
        }
        C12802d dVar = this.f39367r;
        C12801a aVar = C12801a.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append(mo41398o());
        sb.append(":isRewardedVideoAvailable()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        return this.f39351b.isRewardedVideoAvailable(this.f39831v);
    }

    /* renamed from: a */
    public void mo41757a(C12881ka listener) {
        this.f39832w = listener;
    }

    /* renamed from: c */
    public void mo41414c(C12799b error) {
        C12881ka kaVar = this.f39832w;
        if (kaVar != null) {
            kaVar.mo41645a(error, this);
        }
    }

    public void onRewardedVideoAdOpened() {
        C12881ka kaVar = this.f39832w;
        if (kaVar != null) {
            kaVar.mo41649c(this);
        }
    }

    public void onRewardedVideoAdClosed() {
        C12881ka kaVar = this.f39832w;
        if (kaVar != null) {
            kaVar.mo41651e(this);
        }
        mo41752E();
    }

    /* renamed from: a */
    public void mo41413a(boolean available) {
        mo41383C();
        if (!mo41381A()) {
            return;
        }
        if ((available && this.f39350a != C12792a.AVAILABLE) || (!available && this.f39350a != C12792a.NOT_AVAILABLE)) {
            mo41388a(available ? C12792a.AVAILABLE : C12792a.NOT_AVAILABLE);
            C12881ka kaVar = this.f39832w;
            if (kaVar != null) {
                kaVar.mo41647a(available, this);
            }
        }
    }

    /* renamed from: i */
    public void mo41417i() {
        C12881ka kaVar = this.f39832w;
        if (kaVar != null) {
            kaVar.mo41648b(this);
        }
    }

    /* renamed from: h */
    public void mo41416h() {
        C12881ka kaVar = this.f39832w;
        if (kaVar != null) {
            kaVar.mo41646a(this);
        }
    }

    /* renamed from: g */
    public void mo41415g() {
        C12881ka kaVar = this.f39832w;
        if (kaVar != null) {
            kaVar.mo41650d(this);
        }
    }
}
