package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.ma */
/* compiled from: MoatBuyerTagXmlManager */
class C11425ma {

    /* renamed from: a */
    private final List<Node> f35315a;

    C11425ma(List<Node> moatVerificationNodes) {
        Preconditions.checkNotNull(moatVerificationNodes);
        this.f35315a = moatVerificationNodes;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Set<String> mo37486a() {
        Set<String> impressionPixelsXml = new HashSet<>();
        for (Node verification : this.f35315a) {
            if (verification != null) {
                String viewableImpressionXml = m37825a(XmlUtils.getFirstMatchingChildNode(verification, "ViewableImpression"));
                if (viewableImpressionXml != null) {
                    impressionPixelsXml.add(viewableImpressionXml);
                }
            }
        }
        return impressionPixelsXml;
    }

    /* renamed from: a */
    private String m37825a(Node viewableImpression) {
        if (viewableImpression == null || !viewableImpression.hasAttributes()) {
            return null;
        }
        String idAttribute = XmlUtils.getAttributeValue(viewableImpression, "id");
        String content = XmlUtils.getNodeValue(viewableImpression);
        return String.format(Locale.US, "<ViewableImpression id=\"%s\"><![CDATA[%s]]</ViewableImpression>", new Object[]{idAttribute, content});
    }
}
