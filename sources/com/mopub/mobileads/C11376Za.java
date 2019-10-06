package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.Za */
/* compiled from: VastWrapperXmlManager */
class C11376Za extends C11468ya {
    C11376Za(Node wrapperNode) {
        super(wrapperNode);
        Preconditions.checkNotNull(wrapperNode);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo37436f() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f35452a, "VASTAdTagURI"));
    }
}
