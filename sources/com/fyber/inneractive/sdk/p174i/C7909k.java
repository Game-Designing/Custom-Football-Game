package com.fyber.inneractive.sdk.p174i;

import android.util.Xml;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.fyber.inneractive.sdk.i.k */
public final class C7909k {

    /* renamed from: a */
    boolean f16050a = false;

    /* renamed from: b */
    public String f16051b;

    public C7909k(String str) throws Exception {
        try {
            m17837a(str);
            this.f16050a = true;
            IAlog.m18021b("parser: Parsing finished. parser is ready");
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error parsing Ad XML: ");
            sb.append(e.getMessage());
            IAlog.m18024e(sb.toString());
            throw e;
        }
    }

    /* renamed from: a */
    private void m17837a(String str) throws XmlPullParserException, IOException {
        String str2;
        IAlog.m18021b("Start reading Response");
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(new StringReader(str));
        newPullParser.nextTag();
        newPullParser.require(2, null, "tns:Response");
        while (newPullParser.next() != 3) {
            if (newPullParser.getEventType() == 2) {
                String str3 = "tns:Ad";
                if (newPullParser.getName().equals(str3)) {
                    newPullParser.require(2, null, str3);
                    IAlog.m18021b("Start reading Ad");
                    if (newPullParser.next() == 4) {
                        str2 = newPullParser.getText();
                        newPullParser.nextTag();
                    } else {
                        StringBuilder sb = new StringBuilder("No text: ");
                        sb.append(newPullParser.getName());
                        IAlog.m18023d(sb.toString());
                        str2 = "";
                    }
                    String trim = str2.trim();
                    StringBuilder sb2 = new StringBuilder("Ad content: ");
                    sb2.append(trim);
                    IAlog.m18019a(sb2.toString());
                    this.f16051b = trim;
                } else {
                    m17838a(newPullParser);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m17838a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }
}
