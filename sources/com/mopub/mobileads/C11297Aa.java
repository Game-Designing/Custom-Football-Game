package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.Aa */
/* compiled from: VastCompanionAdXmlManager */
class C11297Aa {

    /* renamed from: a */
    private final Node f34624a;

    /* renamed from: b */
    private final VastResourceXmlManager f34625b;

    C11297Aa(Node companionNode) {
        Preconditions.checkNotNull(companionNode, "companionNode cannot be null");
        this.f34624a = companionNode;
        this.f34625b = new VastResourceXmlManager(companionNode);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public Integer mo36845g() {
        return XmlUtils.getAttributeValueAsInt(this.f34624a, "width");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Integer mo36843e() {
        return XmlUtils.getAttributeValueAsInt(this.f34624a, "height");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36839a() {
        return XmlUtils.getAttributeValue(this.f34624a, "adSlotID");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public VastResourceXmlManager mo36844f() {
        return this.f34625b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo36840b() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f34624a, "CompanionClickThrough"));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<VastTracker> mo36841c() {
        List<VastTracker> companionAdClickTrackers = new ArrayList<>();
        List<Node> trackerNodes = XmlUtils.getMatchingChildNodes(this.f34624a, "CompanionClickTracking");
        if (trackerNodes == null) {
            return companionAdClickTrackers;
        }
        for (Node trackerNode : trackerNodes) {
            String uri = XmlUtils.getNodeValue(trackerNode);
            if (!TextUtils.isEmpty(uri)) {
                companionAdClickTrackers.add(new VastTracker(uri));
            }
        }
        return companionAdClickTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<VastTracker> mo36842d() {
        List<VastTracker> companionCreativeViewTrackers = new ArrayList<>();
        Node node = XmlUtils.getFirstMatchingChildNode(this.f34624a, "TrackingEvents");
        if (node == null) {
            return companionCreativeViewTrackers;
        }
        for (Node trackerNode : XmlUtils.getMatchingChildNodes(node, "Tracking", "event", Collections.singletonList("creativeView"))) {
            String trackerUrl = XmlUtils.getNodeValue(trackerNode);
            if (trackerUrl != null) {
                companionCreativeViewTrackers.add(new VastTracker(trackerUrl));
            }
        }
        return companionCreativeViewTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo36846h() {
        return !TextUtils.isEmpty(this.f34625b.mo37246c()) || !TextUtils.isEmpty(this.f34625b.mo37244a()) || !TextUtils.isEmpty(this.f34625b.mo37245b());
    }
}
