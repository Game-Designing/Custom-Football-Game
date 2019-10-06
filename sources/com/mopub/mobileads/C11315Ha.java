package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.Ha */
/* compiled from: VastMediaXmlManager */
class C11315Ha {

    /* renamed from: a */
    private final Node f34782a;

    C11315Ha(Node mediaNode) {
        Preconditions.checkNotNull(mediaNode, "mediaNode cannot be null");
        this.f34782a = mediaNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Integer mo37021d() {
        return XmlUtils.getAttributeValueAsInt(this.f34782a, "width");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Integer mo37018a() {
        return XmlUtils.getAttributeValueAsInt(this.f34782a, "height");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo37020c() {
        return XmlUtils.getAttributeValue(this.f34782a, "type");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37019b() {
        return XmlUtils.getNodeValue(this.f34782a);
    }
}
