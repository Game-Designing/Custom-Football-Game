package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p144a.p145a.C6931g;
import p019d.p143b.p144a.p145a.C6932h;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.bc */
final class C7141bc extends C7133_b {

    /* renamed from: h */
    private final JSONObject f13449h;

    C7141bc(C6931g gVar, C7254d dVar, C7142c cVar) {
        super(gVar, dVar, cVar);
        if (dVar != null) {
            this.f13449h = gVar.mo22440c();
            return;
        }
        throw new IllegalArgumentException("No callback specified.");
    }

    public void run() {
        C6932h hVar;
        this.f13626c.mo22918c(this.f13624a, "Processing SDK JSON response...");
        String a = C7167ia.m15258a(this.f13449h, "xml", (String) null, (C7267q) this.f13625b);
        if (!C7269s.m15819a(a)) {
            this.f13626c.mo22916b(this.f13624a, "No VAST response received.");
            hVar = C6932h.NO_WRAPPER_RESPONSE;
        } else if (a.length() < ((Integer) this.f13625b.mo23039a(C7196pb.f13911yd)).intValue()) {
            try {
                mo23001a(C7221vc.m15602a(a, (C7267q) this.f13625b));
                return;
            } catch (Throwable th) {
                this.f13626c.mo22917b(this.f13624a, "Unable to parse VAST response", th);
            }
        } else {
            this.f13626c.mo22916b(this.f13624a, "VAST response is over max length");
            hVar = C6932h.XML_PARSING;
        }
        mo23000a(hVar);
    }
}
