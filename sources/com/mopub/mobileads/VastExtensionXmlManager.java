package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;

public class VastExtensionXmlManager {
    public static final String AD_VERIFICATIONS = "AdVerifications";
    public static final String AVID = "AVID";

    /* renamed from: ID */
    public static final String f34985ID = "id";
    public static final String MOAT = "Moat";
    public static final String TYPE = "type";
    public static final String VENDOR = "vendor";
    public static final String VERIFICATION = "Verification";
    public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";

    /* renamed from: a */
    private final Node f34986a;

    public VastExtensionXmlManager(Node extensionNode) {
        Preconditions.checkNotNull(extensionNode);
        this.f34986a = extensionNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public VideoViewabilityTracker mo37224d() {
        Node videoViewabilityTrackerNode = XmlUtils.getFirstMatchingChildNode(this.f34986a, VIDEO_VIEWABILITY_TRACKER);
        if (videoViewabilityTrackerNode == null) {
            return null;
        }
        VideoViewabilityTrackerXmlManager videoViewabilityTrackerXmlManager = new VideoViewabilityTrackerXmlManager(videoViewabilityTrackerNode);
        Integer viewablePlaytime = videoViewabilityTrackerXmlManager.mo37394c();
        Integer percentViewable = videoViewabilityTrackerXmlManager.mo37392a();
        String videoViewabilityTrackerUrl = videoViewabilityTrackerXmlManager.mo37393b();
        if (viewablePlaytime == null || percentViewable == null || TextUtils.isEmpty(videoViewabilityTrackerUrl)) {
            return null;
        }
        return new VideoViewabilityTracker(viewablePlaytime.intValue(), percentViewable.intValue(), videoViewabilityTrackerUrl);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Set<String> mo37221a() {
        Node avidNode = XmlUtils.getFirstMatchingChildNode(this.f34986a, AVID);
        if (avidNode == null) {
            return null;
        }
        return new C11439q(avidNode).mo37503a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Set<String> mo37222b() {
        Node adVerification = XmlUtils.getFirstMatchingChildNode(this.f34986a, AD_VERIFICATIONS);
        if (adVerification == null) {
            return null;
        }
        List<Node> moatNodes = XmlUtils.getMatchingChildNodes(adVerification, VERIFICATION, VENDOR, Collections.singletonList(MOAT));
        if (moatNodes == null || moatNodes.isEmpty()) {
            return null;
        }
        return new C11425ma(moatNodes).mo37486a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo37223c() {
        return XmlUtils.getAttributeValue(this.f34986a, "type");
    }
}
