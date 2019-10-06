package com.mopub.mobileads.util;

import com.mopub.mobileads.util.XmlUtils.NodeProcessor;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.util.c */
/* compiled from: XmlUtils */
class C11457c implements NodeProcessor<String> {
    C11457c() {
    }

    public String process(Node node) {
        return XmlUtils.getNodeValue(node);
    }
}
