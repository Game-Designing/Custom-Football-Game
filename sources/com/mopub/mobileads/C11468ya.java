package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.ya */
/* compiled from: VastBaseInLineWrapperXmlManager */
abstract class C11468ya {

    /* renamed from: a */
    protected final Node f35452a;

    C11468ya(Node node) {
        Preconditions.checkNotNull(node);
        this.f35452a = node;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<VastTracker> mo37579c() {
        List<Node> impressionNodes = XmlUtils.getMatchingChildNodes(this.f35452a, "Impression");
        List<VastTracker> impressionTrackers = new ArrayList<>();
        for (Node impressionNode : impressionNodes) {
            String uri = XmlUtils.getNodeValue(impressionNode);
            if (!TextUtils.isEmpty(uri)) {
                impressionTrackers.add(new VastTracker(uri));
            }
        }
        return impressionTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<VastTracker> mo37578b() {
        List<VastTracker> errorTrackers = new ArrayList<>();
        List<Node> errorNodes = XmlUtils.getMatchingChildNodes(this.f35452a, "Error");
        if (errorNodes == null) {
            return errorTrackers;
        }
        for (Node error : errorNodes) {
            String tracker = XmlUtils.getNodeValue(error);
            if (!TextUtils.isEmpty(tracker)) {
                errorTrackers.add(new VastTracker(tracker, true));
            }
        }
        return errorTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<C11307Ea> mo37580d() {
        List<VastLinearXmlManager> linearXmlManagers = new ArrayList<>();
        Node creativesNode = XmlUtils.getFirstMatchingChildNode(this.f35452a, "Creatives");
        if (creativesNode == null) {
            return linearXmlManagers;
        }
        List<Node> creativeNodes = XmlUtils.getMatchingChildNodes(creativesNode, "Creative");
        if (creativeNodes == null) {
            return linearXmlManagers;
        }
        for (Node creativeNode : creativeNodes) {
            Node linearNode = XmlUtils.getFirstMatchingChildNode(creativeNode, "Linear");
            if (linearNode != null) {
                linearXmlManagers.add(new C11307Ea(linearNode));
            }
        }
        return linearXmlManagers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C11297Aa> mo37577a() {
        List<VastCompanionAdXmlManager> companionAdXmlManagers = new ArrayList<>();
        Node creativesNode = XmlUtils.getFirstMatchingChildNode(this.f35452a, "Creatives");
        if (creativesNode == null) {
            return companionAdXmlManagers;
        }
        List<Node> creativeNodes = XmlUtils.getMatchingChildNodes(creativesNode, "Creative");
        if (creativeNodes == null) {
            return companionAdXmlManagers;
        }
        for (Node creativeNode : creativeNodes) {
            Node companionAds = XmlUtils.getFirstMatchingChildNode(creativeNode, "CompanionAds");
            if (companionAds != null) {
                List<Node> companionAdsNodes = XmlUtils.getMatchingChildNodes(companionAds, "Companion");
                if (companionAdsNodes != null) {
                    for (Node companionNode : companionAdsNodes) {
                        companionAdXmlManagers.add(new C11297Aa(companionNode));
                    }
                }
            }
        }
        return companionAdXmlManagers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public VastExtensionParentXmlManager mo37581e() {
        Node vastExtensionsNode = XmlUtils.getFirstMatchingChildNode(this.f35452a, "Extensions");
        if (vastExtensionsNode == null) {
            return null;
        }
        return new VastExtensionParentXmlManager(vastExtensionsNode);
    }
}
