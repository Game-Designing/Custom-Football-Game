package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VastResourceXmlManager {
    public static final String CREATIVE_TYPE = "creativeType";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String IFRAME_RESOURCE = "IFrameResource";
    public static final String STATIC_RESOURCE = "StaticResource";

    /* renamed from: a */
    private final Node f34998a;

    VastResourceXmlManager(Node resourceNode) {
        Preconditions.checkNotNull(resourceNode);
        this.f34998a = resourceNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo37246c() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f34998a, STATIC_RESOURCE));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo37247d() {
        String attribute = XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(this.f34998a, STATIC_RESOURCE), CREATIVE_TYPE);
        if (attribute != null) {
            return attribute.toLowerCase();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37245b() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f34998a, IFRAME_RESOURCE));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo37244a() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f34998a, HTML_RESOURCE));
    }
}
