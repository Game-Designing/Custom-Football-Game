package p019d.p143b.p144a.p146b;

import org.json.JSONObject;
import p019d.p143b.p144a.p147c.C7167ia;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.qa */
public class C7021qa {

    /* renamed from: a */
    private final C7262l f13092a;

    /* renamed from: b */
    private int f13093b;

    /* renamed from: c */
    private int f13094c;

    /* renamed from: d */
    private int f13095d;

    /* renamed from: e */
    private int f13096e;

    /* renamed from: f */
    private boolean f13097f;

    /* renamed from: g */
    private int f13098g;

    /* renamed from: h */
    private int f13099h;

    /* renamed from: i */
    private int f13100i;

    /* renamed from: j */
    private float f13101j;

    /* renamed from: k */
    private float f13102k;

    public C7021qa(JSONObject jSONObject, C7267q qVar) {
        this.f13092a = qVar.mo23049b();
        C7262l lVar = this.f13092a;
        StringBuilder sb = new StringBuilder();
        sb.append("Updating video button properties with JSON = ");
        sb.append(jSONObject);
        lVar.mo22920d("VideoButtonProperties", sb.toString());
        this.f13093b = C7167ia.m15254a(jSONObject, "width", 64, qVar);
        this.f13094c = C7167ia.m15254a(jSONObject, "height", 7, qVar);
        this.f13095d = C7167ia.m15254a(jSONObject, "margin", 20, qVar);
        this.f13096e = C7167ia.m15254a(jSONObject, "gravity", 85, qVar);
        this.f13097f = C7167ia.m15256a(jSONObject, "tap_to_fade", Boolean.valueOf(false), qVar).booleanValue();
        this.f13098g = C7167ia.m15254a(jSONObject, "tap_to_fade_duration_milliseconds", 500, qVar);
        this.f13099h = C7167ia.m15254a(jSONObject, "fade_in_duration_milliseconds", 500, qVar);
        this.f13100i = C7167ia.m15254a(jSONObject, "fade_out_duration_milliseconds", 500, qVar);
        this.f13101j = C7167ia.m15253a(jSONObject, "fade_in_delay_seconds", 1.0f, qVar);
        this.f13102k = C7167ia.m15253a(jSONObject, "fade_out_delay_seconds", 6.0f, qVar);
    }

    /* renamed from: a */
    public int mo22688a() {
        return this.f13093b;
    }

    /* renamed from: b */
    public int mo22689b() {
        return this.f13094c;
    }

    /* renamed from: c */
    public int mo22690c() {
        return this.f13095d;
    }

    /* renamed from: d */
    public int mo22691d() {
        return this.f13096e;
    }

    /* renamed from: e */
    public boolean mo22692e() {
        return this.f13097f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || C7021qa.class != obj.getClass()) {
            return false;
        }
        C7021qa qaVar = (C7021qa) obj;
        if (this.f13093b != qaVar.f13093b || this.f13094c != qaVar.f13094c || this.f13095d != qaVar.f13095d || this.f13096e != qaVar.f13096e || this.f13097f != qaVar.f13097f || this.f13098g != qaVar.f13098g || this.f13099h != qaVar.f13099h || this.f13100i != qaVar.f13100i || Float.compare(qaVar.f13101j, this.f13101j) != 0) {
            return false;
        }
        if (Float.compare(qaVar.f13102k, this.f13102k) != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public long mo22694f() {
        return (long) this.f13098g;
    }

    /* renamed from: g */
    public long mo22695g() {
        return (long) this.f13099h;
    }

    /* renamed from: h */
    public long mo22696h() {
        return (long) this.f13100i;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f13093b * 31) + this.f13094c) * 31) + this.f13095d) * 31) + this.f13096e) * 31) + (this.f13097f ? 1 : 0)) * 31) + this.f13098g) * 31) + this.f13099h) * 31) + this.f13100i) * 31;
        float f = this.f13101j;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f13102k;
        if (f2 != 0.0f) {
            i2 = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i2;
    }

    /* renamed from: i */
    public float mo22698i() {
        return this.f13101j;
    }

    /* renamed from: j */
    public float mo22699j() {
        return this.f13102k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoButtonProperties{widthPercentOfScreen=");
        sb.append(this.f13093b);
        sb.append(", heightPercentOfScreen=");
        sb.append(this.f13094c);
        sb.append(", margin=");
        sb.append(this.f13095d);
        sb.append(", gravity=");
        sb.append(this.f13096e);
        sb.append(", tapToFade=");
        sb.append(this.f13097f);
        sb.append(", tapToFadeDurationMillis=");
        sb.append(this.f13098g);
        sb.append(", fadeInDurationMillis=");
        sb.append(this.f13099h);
        sb.append(", fadeOutDurationMillis=");
        sb.append(this.f13100i);
        sb.append(", fadeInDelay=");
        sb.append(this.f13101j);
        sb.append(", fadeOutDelay=");
        sb.append(this.f13102k);
        sb.append('}');
        return sb.toString();
    }
}
