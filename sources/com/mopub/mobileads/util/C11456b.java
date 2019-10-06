package com.mopub.mobileads.util;

import com.mopub.mobileads.util.XmlUtils.NodeProcessor;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.util.b */
/* compiled from: XmlUtils */
class C11456b implements NodeProcessor<String> {
    C11456b() {
    }

    public String process(Node node) {
        return XmlUtils.getNodeValue(node);
    }
}
