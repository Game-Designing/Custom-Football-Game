package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class VastExtensionParentXmlManager {

    /* renamed from: a */
    private final Node f34984a;

    VastExtensionParentXmlManager(Node vastExtensionParentNode) {
        Preconditions.checkNotNull(vastExtensionParentNode);
        this.f34984a = vastExtensionParentNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<VastExtensionXmlManager> mo37220a() {
        List<VastExtensionXmlManager> vastExtensionXmlManagers = new ArrayList<>();
        List<Node> vastExtensionNodes = XmlUtils.getMatchingChildNodes(this.f34984a, "Extension");
        if (vastExtensionNodes == null) {
            return vastExtensionXmlManagers;
        }
        for (Node vastExtensionNode : vastExtensionNodes) {
            vastExtensionXmlManagers.add(new VastExtensionXmlManager(vastExtensionNode));
        }
        return vastExtensionXmlManagers;
    }
}
