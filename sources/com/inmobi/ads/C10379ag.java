package com.inmobi.ads;

import android.text.TextUtils;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: com.inmobi.ads.ag */
/* compiled from: MoatVastHelper */
class C10379ag {

    /* renamed from: a */
    private static final String f31536a = C10379ag.class.getSimpleName();

    C10379ag() {
    }

    /* renamed from: a */
    static void m33917a(Document document, C10475bx bxVar) {
        List a = C10470bu.m34264a(document, VastExtensionXmlManager.VERIFICATION);
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element element = (Element) it.next();
                NodeList childNodes = element.getChildNodes();
                if (VastExtensionXmlManager.MOAT.equals(element.getAttribute(VastExtensionXmlManager.VENDOR)) && childNodes.getLength() > 0) {
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node item = childNodes.item(i);
                        if ("ViewableImpression".equals(item.getNodeName())) {
                            String a2 = m33916a(item);
                            if (!TextUtils.isEmpty(a2)) {
                                sb.append(a2);
                                sb.append(";");
                                InternalLogLevel internalLogLevel = InternalLogLevel.INTERNAL;
                                String str = f31536a;
                                StringBuilder sb2 = new StringBuilder("Found Moat Verification tag in VAST with value : ");
                                sb2.append(a2);
                                Logger.m35065a(internalLogLevel, str, sb2.toString());
                            }
                        }
                    }
                }
            }
            if (sb.length() != 0) {
                InternalLogLevel internalLogLevel2 = InternalLogLevel.INTERNAL;
                String str2 = f31536a;
                StringBuilder sb3 = new StringBuilder("Moat VastIDs in VAST : ");
                sb3.append(sb.toString());
                Logger.m35065a(internalLogLevel2, str2, sb3.toString());
                bxVar.mo34196a(new NativeTracker(sb.toString(), 0, TrackerEventType.TRACKER_EVENT_TYPE_MOAT, null));
            }
        }
    }

    /* renamed from: a */
    private static String m33916a(Node node) {
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            InternalLogLevel internalLogLevel = InternalLogLevel.INTERNAL;
            String str = f31536a;
            StringBuilder sb = new StringBuilder("Exception while converting Moat node to string : ");
            sb.append(e.getMessage());
            Logger.m35065a(internalLogLevel, str, sb.toString());
        }
        return stringWriter.toString();
    }
}
