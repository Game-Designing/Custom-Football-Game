package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.xa */
/* compiled from: VastAdXmlManager */
class C11466xa {

    /* renamed from: a */
    private final Node f35450a;

    C11466xa(Node adNode) {
        Preconditions.checkNotNull(adNode);
        this.f35450a = adNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C11305Da mo37574a() {
        Node inLineNode = XmlUtils.getFirstMatchingChildNode(this.f35450a, "InLine");
        if (inLineNode != null) {
            return new C11305Da(inLineNode);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C11376Za mo37576c() {
        Node wrapperNode = XmlUtils.getFirstMatchingChildNode(this.f35450a, "Wrapper");
        if (wrapperNode != null) {
            return new C11376Za(wrapperNode);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37575b() {
        return XmlUtils.getAttributeValue(this.f35450a, "sequence");
    }
}
