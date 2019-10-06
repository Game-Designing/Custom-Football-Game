package com.smaato.soma.p261j;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12150c;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;
import com.smaato.soma.C12371g;
import com.smaato.soma.C12394h;
import com.smaato.soma.C12431j;
import com.smaato.soma.p239c.C12187c;
import com.smaato.soma.p239c.p242c.C12202o;
import com.smaato.soma.p239c.p246f.C12252w;
import com.smaato.soma.p239c.p246f.p248b.C12215b;
import com.smaato.soma.p239c.p246f.p249c.C12229k;
import com.smaato.soma.p239c.p252i.C12279e;
import com.smaato.soma.p239c.p253j.C12285d;
import com.smaato.soma.p257f.C12368a;
import com.smaato.soma.p261j.p262a.C12450b;
import com.smaato.soma.p261j.p262a.C12464l;
import java.util.HashMap;
import java.util.Vector;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.smaato.soma.j.N */
/* compiled from: Video */
public class C12446N implements C12368a, C12367f, C12371g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C12435D f38849a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f38850b = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12322e f38851c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f38852d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12394h f38853e = new C12394h();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12229k f38854f = new C12229k();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C12202o f38855g = new C12202o();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C12285d f38856h;

    /* renamed from: i */
    private boolean f38857i = false;

    /* renamed from: j */
    private boolean f38858j = false;

    /* renamed from: k */
    private boolean f38859k = false;

    /* renamed from: l */
    private int f38860l = 3;

    /* renamed from: m */
    private int f38861m = 15;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f38862n;

    public C12446N(Context context) {
        new C12438F(this, context).execute();
    }

    /* renamed from: g */
    public boolean mo39971g() {
        return this.f38859k;
    }

    /* renamed from: d */
    public int mo39968d() {
        return this.f38860l;
    }

    /* renamed from: e */
    public int mo39969e() {
        return this.f38861m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39963a(Context context, boolean isRewardedVideo) {
        this.f38852d = context;
        this.f38851c = C12187c.m40092b().mo39469a(context, null);
        this.f38851c.mo39602a((C12367f) this);
        if (isRewardedVideo) {
            this.f38853e.mo39883a(C12431j.REWARDED);
        } else {
            this.f38853e.mo39883a(C12431j.f38814h);
        }
        this.f38853e.mo39882a(C12150c.INTERSTITIAL_PORTRAIT);
        C12252w.m40307b().mo39626b(context);
    }

    /* renamed from: a */
    public void mo39962a() {
        new C12439G(this).execute();
    }

    /* renamed from: a */
    public void mo39965a(C12486u vastAdListener) {
        this.f38855g.mo39481a(vastAdListener);
    }

    /* renamed from: c */
    public C12394h mo39967c() {
        return this.f38853e;
    }

    /* renamed from: i */
    public void mo39973i() {
        new C12440H(this).execute();
    }

    public void onReceiveAd(C12322e sender, C12064Na receivedBanner) {
        new C12442J(this, receivedBanner).execute();
    }

    /* renamed from: f */
    public void mo39970f() {
        if (this.f38852d == null || !mo39972h()) {
            new C12279e().execute(new Vector[]{this.f38856h.mo39702d()});
            this.f38855g.mo39480a();
            return;
        }
        C12435D d = new C12435D(this.f38852d, this.f38856h, this.f38857i, this.f38855g.mo39498m(), mo39968d(), mo39971g(), mo39969e());
        this.f38849a = d;
        this.f38855g.mo39482b();
    }

    /* renamed from: h */
    public boolean mo39972h() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(this.f38856h.mo39709i().toString());
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.setOnErrorListener(new C12443K(this));
            mediaPlayer.setOnPreparedListener(new C12445M(this));
            mediaPlayer.prepare();
            mediaPlayer.start();
            return true;
        } catch (Exception e) {
            try {
                mediaPlayer.release();
                Runtime.getRuntime().gc();
            } catch (Exception e2) {
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m40900a(C12285d vastAd) {
        String networkMediaFileUrl = String.valueOf(vastAd.mo39709i());
        if (!C12450b.m40929a(networkMediaFileUrl)) {
            return false;
        }
        vastAd.mo39703d(C12450b.m40934c(networkMediaFileUrl));
        return true;
    }

    /* renamed from: b */
    public void mo39966b() {
        try {
            C12464l.m40999b();
            if (this.f38849a != null) {
                this.f38849a.mo39942h();
                this.f38849a.destroyDrawingCache();
                this.f38849a = null;
            }
            if (this.f38851c != null) {
                this.f38851c.destroy();
                this.f38851c = null;
            }
            this.f38852d = null;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void mo39964a(C12064Na banner) {
        if (banner != null) {
            try {
                HashMap<String, Object> reportData = new HashMap<>();
                reportData.put("platform", "android");
                reportData.put("sdkversion", "sdkandroid_9-1-5");
                if (this.f38853e != null) {
                    reportData.put("publisher", String.valueOf(this.f38853e.mo39891g()));
                    reportData.put("adspace", String.valueOf(this.f38853e.mo39887c()));
                }
                String sessionId = banner.getSessionId();
                String str = AgentOptions.SESSIONID;
                String str2 = "";
                if (sessionId != null) {
                    reportData.put(str, banner.getSessionId());
                } else {
                    reportData.put(str, str2);
                }
                reportData.put("type", "SOMAAdViolationVideoCacheFailed");
                String str3 = "originalurl";
                String str4 = "violatedurl";
                if (banner.mo39300o() != null) {
                    reportData.put(str4, banner.mo39300o().mo39709i());
                    reportData.put(str3, banner.mo39300o().mo39709i());
                } else {
                    reportData.put(str4, str2);
                    reportData.put(str3, str2);
                }
                reportData.put("timestamp", String.valueOf(System.currentTimeMillis()));
                if (this.f38852d != null) {
                    reportData.put("bundleid", this.f38852d.getApplicationContext().getPackageName() != null ? this.f38852d.getApplicationContext().getPackageName() : str2);
                }
                String str5 = "sci";
                if (banner.mo39301p() != null) {
                    str2 = banner.mo39301p();
                }
                reportData.put(str5, str2);
                reportData.put("apikey", BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                reportData.put("apiversion", Integer.valueOf(600));
                new C12215b().execute(new HashMap[]{reportData});
            } catch (Exception e) {
            }
        }
    }
}
