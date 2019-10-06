package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.q */
/* compiled from: AvidBuyerTagXmlManager */
class C11439q {

    /* renamed from: a */
    private final Node f35352a;

    C11439q(Node avidNode) {
        Preconditions.checkNotNull(avidNode);
        this.f35352a = avidNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Set<String> mo37503a() {
        Set<String> avidJavaScriptResources = new HashSet<>();
        Node adVerification = XmlUtils.getFirstMatchingChildNode(this.f35352a, VastExtensionXmlManager.AD_VERIFICATIONS);
        if (adVerification == null) {
            return avidJavaScriptResources;
        }
        List<Node> verifications = XmlUtils.getMatchingChildNodes(adVerification, VastExtensionXmlManager.VERIFICATION);
        if (verifications == null) {
            return avidJavaScriptResources;
        }
        for (Node verification : verifications) {
            Node javaScriptResource = XmlUtils.getFirstMatchingChildNode(verification, "JavaScriptResource");
            if (javaScriptResource != null) {
                avidJavaScriptResources.add(XmlUtils.getNodeValue(javaScriptResource));
            }
        }
        return avidJavaScriptResources;
    }
}
