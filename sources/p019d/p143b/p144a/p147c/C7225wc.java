package p019d.p143b.p144a.p147c;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.wc */
class C7225wc implements ContentHandler {

    /* renamed from: a */
    final /* synthetic */ C7221vc f14016a;

    C7225wc(C7221vc vcVar) {
        this.f14016a = vcVar;
    }

    public void characters(char[] cArr, int i, int i2) throws SAXException {
        String trim = new String(Arrays.copyOfRange(cArr, 0, i2)).trim();
        if (C7269s.m15819a(trim)) {
            this.f14016a.f14004c.append(trim);
        }
    }

    public void endDocument() throws SAXException {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - this.f14016a.f14005d;
        C7262l a = this.f14016a.f14002a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finished parsing in ");
        sb.append(seconds);
        sb.append(" seconds");
        a.mo22918c("XmlParser", sb.toString());
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        C7221vc vcVar = this.f14016a;
        vcVar.f14006e = (C7229xc) vcVar.f14003b.pop();
        this.f14016a.f14006e.mo23382d(this.f14016a.f14004c.toString().trim());
        this.f14016a.f14004c.setLength(0);
    }

    public void endPrefixMapping(String str) throws SAXException {
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    public void processingInstruction(String str, String str2) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) throws SAXException {
    }

    public void startDocument() throws SAXException {
        this.f14016a.f14002a.mo22918c("XmlParser", "Begin parsing...");
        this.f14016a.f14005d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        C7229xc xcVar = null;
        try {
            if (!this.f14016a.f14003b.isEmpty()) {
                xcVar = (C7229xc) this.f14016a.f14003b.peek();
            }
            C7229xc xcVar2 = new C7229xc(str2, this.f14016a.m15606a(attributes), xcVar);
            if (xcVar != null) {
                xcVar.mo23381a(xcVar2);
            }
            this.f14016a.f14003b.push(xcVar2);
        } catch (Exception e) {
            C7262l a = this.f14016a.f14002a;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to process element <");
            sb.append(str2);
            sb.append(">");
            a.mo22917b("XmlParser", sb.toString(), e);
            throw new SAXException("Failed to start element", e);
        }
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
    }
}
