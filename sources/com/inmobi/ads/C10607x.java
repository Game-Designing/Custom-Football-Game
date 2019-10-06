package com.inmobi.ads;

import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: com.inmobi.ads.x */
/* compiled from: IasVastHelper */
class C10607x {

    /* renamed from: a */
    private static final String f32310a = C10607x.class.getSimpleName();

    C10607x() {
    }

    /* renamed from: a */
    static void m34799a(Document document, C10475bx bxVar) {
        List<Node> a = C10470bu.m34264a(document, VastExtensionXmlManager.AVID);
        if (a != null) {
            for (Node a2 : a) {
                m34800a(a2, bxVar);
            }
        }
    }

    /* renamed from: a */
    private static void m34800a(Node node, C10475bx bxVar) {
        while (true) {
            if (!node.hasChildNodes()) {
                break;
            }
            String nodeName = node.getNodeName();
            char c = 65535;
            int hashCode = nodeName.hashCode();
            String str = "JavaScriptResource";
            String str2 = VastExtensionXmlManager.AD_VERIFICATIONS;
            switch (hashCode) {
                case -2077435339:
                    if (nodeName.equals(str2)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1320080837:
                    if (nodeName.equals(VastExtensionXmlManager.VERIFICATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2021392:
                    if (nodeName.equals(VastExtensionXmlManager.AVID)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1561251035:
                    if (nodeName.equals(str)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                node = C10470bu.m34266a(node, str2);
                if (node != null) {
                }
            } else if (c != 1) {
                if (c == 2) {
                    node = C10470bu.m34266a(node, str);
                    if (node != null) {
                    }
                } else if (c == 3) {
                    String a = C10470bu.m34263a(node);
                    if (a != null) {
                        bxVar.mo34196a(new NativeTracker(a, 0, TrackerEventType.TRACKER_EVENT_TYPE_IAS, null));
                    }
                }
            } else if (node.hasChildNodes()) {
                NodeList childNodes = node.getChildNodes();
                int length = childNodes.getLength();
                for (int i = 0; i < length; i++) {
                    m34800a(childNodes.item(i), bxVar);
                }
                return;
            }
        }
    }
}
