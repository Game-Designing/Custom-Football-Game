package p019d.p143b.p144a.p147c;

import android.net.Uri;
import com.mopub.common.AdType;
import com.vungle.warren.model.Advertisement;
import org.json.JSONObject;
import p019d.p143b.p144a.p146b.C7018p;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Ac */
public final class C7043Ac extends C7234z {
    public C7043Ac(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7142c cVar) {
        super(jSONObject, jSONObject2, bc, cVar);
    }

    /* renamed from: va */
    private String m14577va() {
        return C7167ia.m15258a(this.f13233a, "stream_url", "", (C7267q) this.f13235c);
    }

    /* renamed from: b */
    public void mo22738b(String str) {
        try {
            synchronized (this.f13238f) {
                this.f13233a.put(AdType.HTML, str);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public void mo22739c(Uri uri) {
        try {
            synchronized (this.f13238f) {
                this.f13233a.put(Advertisement.KEY_VIDEO, uri.toString());
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public boolean mo22402c() {
        return mo22407ia() != null;
    }

    /* renamed from: ha */
    public boolean mo22405ha() {
        return this.f13233a.has("stream_url");
    }

    /* renamed from: ia */
    public Uri mo22407ia() {
        String va = m14577va();
        if (C7269s.m15819a(va)) {
            return Uri.parse(va);
        }
        String qa = mo22742qa();
        if (C7269s.m15819a(qa)) {
            return Uri.parse(qa);
        }
        return null;
    }

    /* renamed from: ja */
    public Uri mo22408ja() {
        String a = C7167ia.m15258a(this.f13233a, "click_url", "", (C7267q) this.f13235c);
        if (C7269s.m15819a(a)) {
            return Uri.parse(a);
        }
        return null;
    }

    /* renamed from: oa */
    public String mo22740oa() {
        return C7167ia.m15258a(this.f13233a, AdType.HTML, (String) null, (C7267q) this.f13235c);
    }

    /* renamed from: pa */
    public void mo22741pa() {
        synchronized (this.f13238f) {
            this.f13233a.remove("stream_url");
        }
    }

    /* renamed from: qa */
    public String mo22742qa() {
        return C7167ia.m15258a(this.f13233a, Advertisement.KEY_VIDEO, "", (C7267q) this.f13235c);
    }

    /* renamed from: ra */
    public float mo22743ra() {
        return C7167ia.m15253a(this.f13233a, "mraid_close_delay_graphic", 0.0f, (C7267q) this.f13235c);
    }

    /* renamed from: sa */
    public boolean mo22744sa() {
        return C7167ia.m15256a(this.f13233a, "close_button_graphic_hidden", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: ta */
    public boolean mo22745ta() {
        String str = "close_button_expandable_hidden";
        if (this.f13233a.has(str)) {
            return C7167ia.m15256a(this.f13233a, str, Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
        }
        return true;
    }

    /* renamed from: ua */
    public C7018p mo22746ua() {
        return mo23421a(C7167ia.m15254a(this.f13233a, "expandable_style", C7018p.Invisible.ordinal(), (C7267q) this.f13235c));
    }
}
