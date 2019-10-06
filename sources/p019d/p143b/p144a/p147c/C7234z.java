package p019d.p143b.p144a.p147c;

import android.graphics.Color;
import android.net.Uri;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p019d.p143b.p144a.p146b.C7018p;
import p019d.p143b.p144a.p146b.C7021qa;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.z */
public abstract class C7234z extends C7071Hc {

    /* renamed from: i */
    private final AtomicBoolean f14056i = new AtomicBoolean();

    public C7234z(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7142c cVar) {
        super(jSONObject, jSONObject2, bc, cVar);
    }

    /* renamed from: a */
    private float m15638a(C7258h hVar, float f, boolean z) {
        if (hVar.equals(C7258h.f14103b)) {
            return 0.5f;
        }
        return (!hVar.equals(C7258h.f14102a) || !z || f != -1.0f) ? 0.0f : 0.5f;
    }

    /* renamed from: a */
    private C7018p m15639a(boolean z) {
        return z ? C7018p.WhiteXOnTransparentGrey : C7018p.WhiteXOnOpaqueBlack;
    }

    /* renamed from: A */
    public int mo23395A() {
        return C7167ia.m15254a(this.f13233a, "countdown_length", 0, (C7267q) this.f13235c);
    }

    /* renamed from: B */
    public int mo23396B() {
        int parseColor = Color.parseColor("#C8FFFFFF");
        String a = C7167ia.m15258a(this.f13233a, "countdown_color", (String) null, (C7267q) this.f13235c);
        if (!C7269s.m15819a(a)) {
            return parseColor;
        }
        try {
            return Color.parseColor(a);
        } catch (Throwable th) {
            this.f13235c.mo23049b().mo22917b("DirectAd", "Unable to parse countdown color", th);
            return parseColor;
        }
    }

    /* renamed from: C */
    public int mo23397C() {
        String a = C7167ia.m15258a(this.f13233a, "video_background_color", (String) null, (C7267q) this.f13235c);
        if (C7269s.m15819a(a)) {
            try {
                return Color.parseColor(a);
            } catch (Throwable th) {
            }
        }
        return CtaButton.BACKGROUND_COLOR;
    }

    /* renamed from: D */
    public int mo23398D() {
        int i = mo22402c() ? CtaButton.BACKGROUND_COLOR : -1157627904;
        String a = C7167ia.m15258a(this.f13233a, "graphic_background_color", (String) null, (C7267q) this.f13235c);
        if (!C7269s.m15819a(a)) {
            return i;
        }
        try {
            return Color.parseColor(a);
        } catch (Throwable th) {
            return i;
        }
    }

    /* renamed from: E */
    public C7040A mo23399E() {
        String a = C7167ia.m15258a(this.f13233a, "poststitial_dismiss_type", (String) null, (C7267q) this.f13235c);
        if (C7269s.m15819a(a)) {
            if ("dismiss".equalsIgnoreCase(a)) {
                return C7040A.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(a)) {
                return C7040A.DO_NOT_DISMISS;
            }
        }
        return C7040A.UNSPECIFIED;
    }

    /* renamed from: F */
    public List<String> mo23400F() {
        String a = C7167ia.m15258a(this.f13233a, "resource_cache_prefix", (String) null, (C7267q) this.f13235c);
        return a != null ? C7178l.m15309a(a) : this.f13235c.mo23050b((C7204rb) C7196pb.f13734O);
    }

    /* renamed from: G */
    public String mo23401G() {
        return C7167ia.m15258a(this.f13233a, "cache_prefix", (String) null, (C7267q) this.f13235c);
    }

    /* renamed from: H */
    public boolean mo23402H() {
        return C7167ia.m15256a(this.f13233a, "progress_bar_enabled", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: I */
    public int mo23403I() {
        String a = C7167ia.m15258a(this.f13233a, "progress_bar_color", "#C8FFFFFF", (C7267q) this.f13235c);
        if (C7269s.m15819a(a)) {
            try {
                return Color.parseColor(a);
            } catch (Throwable th) {
            }
        }
        return 0;
    }

    /* renamed from: J */
    public int mo23404J() {
        return C7209sc.m15462a(this.f13233a);
    }

    /* renamed from: K */
    public int mo23405K() {
        return C7167ia.m15254a(this.f13233a, "poststitial_shown_forward_delay_millis", -1, (C7267q) this.f13235c);
    }

    /* renamed from: L */
    public int mo23406L() {
        return C7167ia.m15254a(this.f13233a, "close_button_size", ((Integer) this.f13235c.mo23039a(C7196pb.f13757Ta)).intValue(), (C7267q) this.f13235c);
    }

    /* renamed from: M */
    public int mo23407M() {
        return C7167ia.m15254a(this.f13233a, "close_button_top_margin", ((Integer) this.f13235c.mo23039a(C7196pb.f13761Ua)).intValue(), (C7267q) this.f13235c);
    }

    /* renamed from: N */
    public int mo23408N() {
        return C7167ia.m15254a(this.f13233a, "close_button_horizontal_margin", ((Integer) this.f13235c.mo23039a(C7196pb.f13765Va)).intValue(), (C7267q) this.f13235c);
    }

    /* renamed from: O */
    public boolean mo23409O() {
        return C7167ia.m15256a(this.f13233a, "lhs_close_button", (Boolean) this.f13235c.mo23039a(C7196pb.f13676Cb), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: P */
    public boolean mo23410P() {
        return C7167ia.m15256a(this.f13233a, "lhs_skip_button", (Boolean) this.f13235c.mo23039a(C7196pb.f13681Db), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: Q */
    public boolean mo23411Q() {
        return C7167ia.m15256a(this.f13233a, "stop_video_player_after_poststitial_render", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: R */
    public boolean mo23412R() {
        return C7167ia.m15256a(this.f13233a, "unhide_adview_on_render", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: S */
    public long mo23413S() {
        long a = C7167ia.m15255a(this.f13233a, "report_reward_duration", -1, (C7267q) this.f13235c);
        if (a >= 0) {
            return TimeUnit.SECONDS.toMillis(a);
        }
        return -1;
    }

    /* renamed from: T */
    public int mo23414T() {
        return C7167ia.m15254a(this.f13233a, "report_reward_percent", -1, (C7267q) this.f13235c);
    }

    /* renamed from: U */
    public boolean mo23415U() {
        return C7167ia.m15256a(this.f13233a, "report_reward_percent_include_close_delay", Boolean.valueOf(true), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: V */
    public AtomicBoolean mo23416V() {
        return this.f14056i;
    }

    /* renamed from: W */
    public boolean mo23417W() {
        return C7167ia.m15256a(this.f13233a, "render_poststitial_on_attach", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: X */
    public boolean mo23418X() {
        return C7167ia.m15256a(this.f13233a, "playback_requires_user_action", Boolean.valueOf(true), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: Y */
    public boolean mo23419Y() {
        return C7167ia.m15256a(this.f13233a, "sanitize_webview", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: Z */
    public String mo23420Z() {
        String a = C7167ia.m15258a(this.f13233a, "base_url", "/", (C7267q) this.f13235c);
        if ("null".equalsIgnoreCase(a)) {
            return null;
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C7018p mo23421a(int i) {
        return i == 1 ? C7018p.WhiteXOnTransparentGrey : i == 2 ? C7018p.Invisible : C7018p.WhiteXOnOpaqueBlack;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C7257g mo22756a() {
        return super.mo22756a();
    }

    /* renamed from: a */
    public String mo23422a(int i, String str, boolean z) {
        String r = mo23437r();
        if (!C7269s.m15819a(r)) {
            return "";
        }
        return C7209sc.m15470a(str, Uri.parse(r.replace("{CLCODE}", mo22761h())).buildUpon().appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", Long.toString(System.currentTimeMillis())).appendQueryParameter("uvs", Boolean.toString(z)).build().toString());
    }

    /* renamed from: a */
    public String mo23423a(String str) {
        String str2 = "";
        String a = C7167ia.m15258a(this.f13233a, "click_tracking_url", str2, (C7267q) this.f13235c);
        if (!C7269s.m15819a(a)) {
            return str2;
        }
        return C7209sc.m15470a(str, a.replace("{CLCODE}", mo22761h()));
    }

    /* renamed from: a */
    public void mo23424a(Uri uri) {
        try {
            synchronized (this.f13238f) {
                this.f13233a.put("mute_image", uri);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: aa */
    public boolean mo23425aa() {
        return C7167ia.m15256a(this.f13233a, "web_contents_debugging_enabled", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ long mo22758b() {
        return super.mo22758b();
    }

    /* renamed from: b */
    public void mo23426b(Uri uri) {
        try {
            synchronized (this.f13238f) {
                this.f13233a.put("unmute_image", uri);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: ba */
    public C7213tc mo23427ba() {
        JSONObject a = C7167ia.m15264a(this.f13233a, "web_view_settings", (JSONObject) null, (C7267q) this.f13235c);
        if (a != null) {
            return new C7213tc(a, this.f13235c);
        }
        return null;
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ boolean mo22402c() {
        return super.mo22402c();
    }

    /* renamed from: ca */
    public List<String> mo23428ca() {
        return C7178l.m15309a(C7167ia.m15258a(this.f13233a, "wls", "", (C7267q) this.f13235c));
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C7258h mo22759d() {
        return super.mo22759d();
    }

    /* renamed from: da */
    public List<String> mo23429da() {
        return C7178l.m15309a(C7167ia.m15258a(this.f13233a, "wlh", (String) null, (C7267q) this.f13235c));
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ boolean mo22845e() {
        return super.mo22845e();
    }

    /* renamed from: ea */
    public boolean mo23430ea() {
        return C7167ia.m15256a(this.f13233a, "tvv", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ long mo22404f() {
        return super.mo22404f();
    }

    /* renamed from: fa */
    public Uri mo23431fa() {
        String a = C7167ia.m15258a(this.f13233a, "mute_image", (String) null, (C7267q) this.f13235c);
        if (!C7269s.m15819a(a)) {
            return null;
        }
        try {
            return Uri.parse(a);
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ C7063Fc mo22760g() {
        return super.mo22760g();
    }

    /* renamed from: ga */
    public Uri mo23432ga() {
        String a = C7167ia.m15258a(this.f13233a, "unmute_image", "", (C7267q) this.f13235c);
        if (C7269s.m15819a(a)) {
            try {
                return Uri.parse(a);
            } catch (Throwable th) {
            }
        }
        return null;
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ String mo22761h() {
        return super.mo22761h();
    }

    /* renamed from: ha */
    public boolean mo22405ha() {
        this.f13235c.mo23049b().mo22916b("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: ia */
    public Uri mo22407ia() {
        this.f13235c.mo23049b().mo22916b("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    /* renamed from: ja */
    public Uri mo22408ja() {
        this.f13235c.mo23049b().mo22916b("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: ka */
    public C7044B mo23433ka() {
        String upperCase = C7167ia.m15258a(this.f13233a, "ad_target", C7044B.DEFAULT.toString(), (C7267q) this.f13235c).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? C7044B.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? C7044B.ACTIVITY_LANDSCAPE : C7044B.DEFAULT;
    }

    /* renamed from: la */
    public float mo23434la() {
        return C7167ia.m15253a(this.f13233a, "close_delay", 0.0f, (C7267q) this.f13235c);
    }

    /* renamed from: ma */
    public float mo23435ma() {
        return C7167ia.m15253a(this.f13233a, "close_delay_graphic", m15638a(mo22759d(), mo23434la(), mo22402c()), (C7267q) this.f13235c);
    }

    /* renamed from: n */
    public /* bridge */ /* synthetic */ C7059Ec mo22762n() {
        return super.mo22762n();
    }

    /* renamed from: na */
    public C7018p mo23436na() {
        int a = C7167ia.m15254a(this.f13233a, "close_style", -1, (C7267q) this.f13235c);
        return a == -1 ? m15639a(mo22402c()) : mo23421a(a);
    }

    /* renamed from: q */
    public C7018p mo22764q() {
        int a = C7167ia.m15254a(this.f13233a, "skip_style", -1, (C7267q) this.f13235c);
        return a == -1 ? mo23436na() : mo23421a(a);
    }

    /* renamed from: r */
    public String mo23437r() {
        return C7167ia.m15258a(this.f13233a, "video_end_url", "", (C7267q) this.f13235c);
    }

    /* renamed from: s */
    public boolean mo23438s() {
        return C7167ia.m15256a(this.f13233a, "dismiss_on_skip", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: t */
    public String mo23439t() {
        JSONObject a = C7167ia.m15264a(this.f13233a, "video_button_properties", (JSONObject) null, (C7267q) this.f13235c);
        String str = "";
        if (a == null) {
            return str;
        }
        return C7167ia.m15258a(a, "video_button_html", str, (C7267q) this.f13235c);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: u */
    public C7021qa mo23440u() {
        return new C7021qa(C7167ia.m15264a(this.f13233a, "video_button_properties", (JSONObject) null, (C7267q) this.f13235c), this.f13235c);
    }

    /* renamed from: v */
    public boolean mo22416v() {
        return C7167ia.m15256a(this.f13233a, "video_clickable", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: w */
    public boolean mo23441w() {
        return C7167ia.m15256a(this.f13233a, "accelerate_hardware", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: x */
    public boolean mo23442x() {
        return C7167ia.m15256a(this.f13233a, "hide_close_on_exit_graphic", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: y */
    public boolean mo23443y() {
        return C7167ia.m15256a(this.f13233a, "hide_close_on_exit", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    /* renamed from: z */
    public boolean mo23444z() {
        return C7167ia.m15256a(this.f13233a, "lock_current_orientation", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }
}
