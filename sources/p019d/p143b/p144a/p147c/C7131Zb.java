package p019d.p143b.p144a.p147c;

import org.json.JSONArray;
import org.json.JSONException;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.Zb */
class C7131Zb extends C7184mb implements C7254d {

    /* renamed from: f */
    private final JSONArray f13423f;

    /* renamed from: g */
    private final int f13424g;

    /* renamed from: h */
    final /* synthetic */ C7128Yb f13425h;

    C7131Zb(C7128Yb yb, int i, JSONArray jSONArray) {
        this.f13425h = yb;
        super("TaskProcessNextWaterfallAd", yb.f13625b);
        if (jSONArray == null) {
            throw new IllegalArgumentException("No ad objects array specified");
        } else if (i < 0 || i >= jSONArray.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid ad index specified: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else {
            this.f13423f = jSONArray;
            this.f13424g = i;
        }
    }

    /* renamed from: a */
    private void m14990a(int i) throws JSONException {
        if ("adapter".equals(m14991b(i))) {
            this.f13625b.mo23027C().mo22970a((C7184mb) new C7125Xb(this.f13423f.getJSONObject(i), this.f13425h.f13413f, this.f13625b), C7113Tb.BACKGROUND);
        }
    }

    /* renamed from: b */
    private String m14991b(int i) {
        String str = "undefined";
        if (i >= 0 && i < this.f13423f.length()) {
            try {
                return C7167ia.m15258a(this.f13423f.getJSONObject(i), "type", str, (C7267q) this.f13625b);
            } catch (JSONException e) {
                this.f13626c.mo22916b(this.f13624a, "Unable to parse next ad from the ad response");
            }
        }
        return str;
    }

    /* JADX WARNING: type inference failed for: r1v9, types: [d.b.a.c.Rb] */
    /* JADX WARNING: type inference failed for: r1v13, types: [d.b.a.c._b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14992b() throws org.json.JSONException {
        /*
            r8 = this;
            org.json.JSONArray r0 = r8.f13423f
            int r1 = r8.f13424g
            org.json.JSONObject r3 = r0.getJSONObject(r1)
            int r0 = r8.f13424g
            java.lang.String r0 = r8.m14991b(r0)
            java.lang.String r1 = "applovin"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x003e
            d.b.d.l r0 = r8.f13626c
            java.lang.String r1 = r8.f13624a
            java.lang.String r2 = "Starting task for AppLovin ad..."
            r0.mo22918c(r1, r2)
            d.b.a.c.c r0 = r8.f13625b
            d.b.a.c.Sb r0 = r0.mo23027C()
            d.b.a.c.dc r1 = new d.b.a.c.dc
            d.b.a.c.Yb r2 = r8.f13425h
            org.json.JSONObject r4 = r2.f13413f
            d.b.a.c.Yb r2 = r8.f13425h
            d.b.a.c.Bc r5 = r2.f13415h
            d.b.a.c.c r7 = r8.f13625b
            r2 = r1
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x003a:
            r0.mo22969a(r1)
            goto L_0x00aa
        L_0x003e:
            java.lang.String r1 = "vast"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0068
            d.b.d.l r0 = r8.f13626c
            java.lang.String r1 = r8.f13624a
            java.lang.String r2 = "Starting task for VAST ad..."
            r0.mo22918c(r1, r2)
            d.b.a.c.c r0 = r8.f13625b
            d.b.a.c.Sb r0 = r0.mo23027C()
            d.b.a.c.Yb r1 = r8.f13425h
            org.json.JSONObject r1 = r1.f13413f
            d.b.a.c.Yb r2 = r8.f13425h
            d.b.a.c.Bc r2 = r2.f13415h
            d.b.a.c.c r4 = r8.f13625b
            d.b.a.c._b r1 = p019d.p143b.p144a.p147c.C7133_b.m14994a(r3, r1, r2, r8, r4)
            goto L_0x003a
        L_0x0068:
            java.lang.String r1 = "adapter"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x008d
            d.b.d.l r0 = r8.f13626c
            java.lang.String r1 = r8.f13624a
            java.lang.String r2 = "Starting task for adapter ad..."
            r0.mo22918c(r1, r2)
            d.b.a.c.c r0 = r8.f13625b
            d.b.a.c.Sb r0 = r0.mo23027C()
            d.b.a.c.Rb r1 = new d.b.a.c.Rb
            d.b.a.c.Yb r2 = r8.f13425h
            org.json.JSONObject r2 = r2.f13413f
            d.b.a.c.c r4 = r8.f13625b
            r1.<init>(r3, r2, r4, r8)
            goto L_0x003a
        L_0x008d:
            d.b.d.l r1 = r8.f13626c
            java.lang.String r2 = r8.f13624a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to process ad of unknown type: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.mo22913a(r2, r0)
            r0 = -800(0xfffffffffffffce0, float:NaN)
            r8.failedToReceiveAd(r0)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7131Zb.m14992b():void");
    }

    public void adReceived(C7251a aVar) {
        this.f13425h.m14975a(aVar);
    }

    public void failedToReceiveAd(int i) {
        if (this.f13424g < this.f13423f.length() - 1) {
            C7262l lVar = this.f13626c;
            String str = this.f13624a;
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to load next ad (");
            sb.append(this.f13424g);
            sb.append(") after failure...");
            lVar.mo22920d(str, sb.toString());
            this.f13625b.mo23027C().mo22970a((C7184mb) new C7131Zb(this.f13425h, this.f13424g + 1, this.f13423f), C7113Tb.BACKGROUND);
            return;
        }
        this.f13425h.m14977b();
    }

    public void run() {
        try {
            if (this.f13424g == 0) {
                int intValue = ((Integer) this.f13625b.mo23039a(C7196pb.f13698Gd)).intValue();
                int i = 1;
                while (i <= intValue && i < this.f13423f.length()) {
                    m14990a(i);
                    i++;
                }
            } else {
                int intValue2 = this.f13424g + ((Integer) this.f13625b.mo23039a(C7196pb.f13698Gd)).intValue();
                if (intValue2 < this.f13423f.length()) {
                    m14990a(intValue2);
                }
            }
            m14992b();
        } catch (Throwable th) {
            C7262l lVar = this.f13626c;
            String str = this.f13624a;
            StringBuilder sb = new StringBuilder();
            sb.append("Encountered error while processing ad number ");
            sb.append(this.f13424g);
            lVar.mo22917b(str, sb.toString(), th);
            this.f13425h.m14977b();
        }
    }
}
