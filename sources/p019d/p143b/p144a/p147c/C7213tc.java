package p019d.p143b.p144a.p147c;

import android.webkit.WebSettings.PluginState;
import org.json.JSONObject;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.tc */
public final class C7213tc {

    /* renamed from: a */
    private C7267q f13966a;

    /* renamed from: b */
    private JSONObject f13967b;

    C7213tc(JSONObject jSONObject, C7267q qVar) {
        this.f13966a = qVar;
        this.f13967b = jSONObject;
    }

    /* renamed from: a */
    public Integer mo23329a() {
        int i;
        String a = C7167ia.m15258a(this.f13967b, "mixed_content_mode", (String) null, this.f13966a);
        if (C7269s.m15819a(a)) {
            if ("always_allow".equalsIgnoreCase(a)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(a)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(a)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* renamed from: b */
    public PluginState mo23330b() {
        String a = C7167ia.m15258a(this.f13967b, "plugin_state", (String) null, this.f13966a);
        if (C7269s.m15819a(a)) {
            if ("on".equalsIgnoreCase(a)) {
                return PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(a)) {
                return PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(a)) {
                return PluginState.OFF;
            }
        }
        return null;
    }

    /* renamed from: c */
    public Boolean mo23331c() {
        return C7167ia.m15256a(this.f13967b, "allow_file_access", (Boolean) null, this.f13966a);
    }

    /* renamed from: d */
    public Boolean mo23332d() {
        return C7167ia.m15256a(this.f13967b, "load_with_overview_mode", (Boolean) null, this.f13966a);
    }

    /* renamed from: e */
    public Boolean mo23333e() {
        return C7167ia.m15256a(this.f13967b, "use_wide_view_port", (Boolean) null, this.f13966a);
    }

    /* renamed from: f */
    public Boolean mo23334f() {
        return C7167ia.m15256a(this.f13967b, "allow_content_access", (Boolean) null, this.f13966a);
    }

    /* renamed from: g */
    public Boolean mo23335g() {
        return C7167ia.m15256a(this.f13967b, "use_built_in_zoom_controls", (Boolean) null, this.f13966a);
    }

    /* renamed from: h */
    public Boolean mo23336h() {
        return C7167ia.m15256a(this.f13967b, "display_zoom_controls", (Boolean) null, this.f13966a);
    }

    /* renamed from: i */
    public Boolean mo23337i() {
        return C7167ia.m15256a(this.f13967b, "save_form_data", (Boolean) null, this.f13966a);
    }

    /* renamed from: j */
    public Boolean mo23338j() {
        return C7167ia.m15256a(this.f13967b, "geolocation_enabled", (Boolean) null, this.f13966a);
    }

    /* renamed from: k */
    public Boolean mo23339k() {
        return C7167ia.m15256a(this.f13967b, "need_initial_focus", (Boolean) null, this.f13966a);
    }

    /* renamed from: l */
    public Boolean mo23340l() {
        return C7167ia.m15256a(this.f13967b, "allow_file_access_from_file_urls", (Boolean) null, this.f13966a);
    }

    /* renamed from: m */
    public Boolean mo23341m() {
        return C7167ia.m15256a(this.f13967b, "allow_universal_access_from_file_urls", (Boolean) null, this.f13966a);
    }

    /* renamed from: n */
    public Boolean mo23342n() {
        return C7167ia.m15256a(this.f13967b, "offscreen_pre_raster", (Boolean) null, this.f13966a);
    }
}
