package p019d.p143b.p144a.p147c;

import android.util.Xml;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.vc */
class C7221vc {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7262l f14002a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Stack<C7229xc> f14003b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StringBuilder f14004c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f14005d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C7229xc f14006e;

    C7221vc(C7267q qVar) {
        if (qVar != null) {
            this.f14002a = qVar.mo23049b();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    static C7217uc m15602a(String str, C7267q qVar) throws SAXException {
        return new C7221vc(qVar).mo23365a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m15606a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C7217uc mo23365a(String str) throws SAXException {
        if (str != null) {
            this.f14004c = new StringBuilder();
            this.f14003b = new Stack<>();
            this.f14006e = null;
            Xml.parse(str, new C7225wc(this));
            C7229xc xcVar = this.f14006e;
            if (xcVar != null) {
                return xcVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
