package p019d.p273h.p276c;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource.AD_UNIT;
import java.util.List;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p019d.p273h.p274a.C12725c;
import p019d.p273h.p276c.p279c.C12794b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12829t;
import p019d.p273h.p276c.p282f.C12870f;

/* renamed from: d.h.c.K */
/* compiled from: MediationInitializer */
class C12750K extends C12755b {

    /* renamed from: e */
    final /* synthetic */ C12753N f39144e;

    C12750K(C12753N this$0) {
        this.f39144e = this$0;
        super();
    }

    public void run() {
        try {
            C12747I ironSourceObject = C12747I.m41186g();
            if (this.f39144e.m41247a(this.f39144e.f39167t).mo41315b()) {
                this.f39144e.f39171x = "userGenerated";
            } else {
                this.f39144e.f39167t = ironSourceObject.mo41202a((Context) this.f39144e.f39166s);
                if (!TextUtils.isEmpty(this.f39144e.f39167t)) {
                    this.f39144e.f39171x = "GAID";
                } else {
                    this.f39144e.f39167t = C12725c.m41105j(this.f39144e.f39166s);
                    if (!TextUtils.isEmpty(this.f39144e.f39167t)) {
                        this.f39144e.f39171x = "UUID";
                    } else {
                        this.f39144e.f39167t = "";
                    }
                }
                ironSourceObject.mo41230f(this.f39144e.f39167t);
            }
            C12870f.m41821a().mo41641a("userIdType", this.f39144e.f39171x);
            if (!TextUtils.isEmpty(this.f39144e.f39167t)) {
                C12870f.m41821a().mo41641a(AndroidAccountManagerPersistence.ACCOUNT_ID, this.f39144e.f39167t);
            }
            if (!TextUtils.isEmpty(this.f39144e.f39168u)) {
                C12870f.m41821a().mo41641a("appKey", this.f39144e.f39168u);
            }
            this.f39144e.f39169v = ironSourceObject.mo41201a((Context) this.f39144e.f39166s, this.f39144e.f39167t, this.f39181c);
            if (this.f39144e.f39169v != null) {
                this.f39144e.f39160m.removeCallbacks(this);
                if (this.f39144e.f39169v.mo41698g()) {
                    this.f39144e.m41251a(C12754a.INITIATED);
                    if (this.f39144e.f39169v.mo41692a().mo41478a().mo41459a()) {
                        C12794b.m41563a(this.f39144e.f39166s);
                    }
                    List<AD_UNIT> adUnits = this.f39144e.f39169v.mo41693b();
                    for (C12756c listener : this.f39144e.f39165r) {
                        listener.mo41214a(adUnits, this.f39144e.m41264e());
                    }
                    if (this.f39144e.f39172y != null) {
                        C12829t data = this.f39144e.f39169v.mo41692a().mo41478a().mo41461c();
                        if (data != null && !TextUtils.isEmpty(data.mo41575c())) {
                            this.f39144e.f39172y.mo41615a(data.mo41575c());
                        }
                    }
                } else if (!this.f39144e.f39158k) {
                    this.f39144e.m41251a(C12754a.INIT_FAILED);
                    this.f39144e.f39158k = true;
                    for (C12756c listener2 : this.f39144e.f39165r) {
                        listener2.mo41212a("serverResponseIsNotValid");
                    }
                }
            } else {
                if (this.f39144e.f39153f == 3) {
                    this.f39144e.f39173z = true;
                    for (C12756c listener3 : this.f39144e.f39165r) {
                        listener3.mo41204a();
                    }
                }
                if (this.f39179a && this.f39144e.f39153f < this.f39144e.f39154g) {
                    this.f39144e.f39157j = true;
                    this.f39144e.f39160m.postDelayed(this, (long) (this.f39144e.f39152e * 1000));
                    if (this.f39144e.f39153f < this.f39144e.f39155h) {
                        this.f39144e.f39152e = this.f39144e.f39152e * 2;
                    }
                }
                if ((!this.f39179a || this.f39144e.f39153f == this.f39144e.f39156i) && !this.f39144e.f39158k) {
                    this.f39144e.f39158k = true;
                    if (TextUtils.isEmpty(this.f39180b)) {
                        this.f39180b = "noServerResponse";
                    }
                    for (C12756c listener4 : this.f39144e.f39165r) {
                        listener4.mo41212a(this.f39180b);
                    }
                    this.f39144e.m41251a(C12754a.INIT_FAILED);
                    C12802d.m41613c().mo41427b(C12801a.API, "Mediation availability false reason: No server response", 1);
                }
                this.f39144e.f39153f = this.f39144e.f39153f + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
