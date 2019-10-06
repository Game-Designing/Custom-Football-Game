package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class VastIconXmlManager {
    public static final String DURATION = "duration";
    public static final String HEIGHT = "height";
    public static final String ICON_CLICKS = "IconClicks";
    public static final String ICON_CLICK_THROUGH = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING = "IconClickTracking";
    public static final String ICON_VIEW_TRACKING = "IconViewTracking";
    public static final String OFFSET = "offset";
    public static final String WIDTH = "width";

    /* renamed from: a */
    private final Node f34988a;

    /* renamed from: b */
    private final VastResourceXmlManager f34989b;

    VastIconXmlManager(Node iconNode) {
        Preconditions.checkNotNull(iconNode);
        this.f34988a = iconNode;
        this.f34989b = new VastResourceXmlManager(iconNode);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public Integer mo37236h() {
        return XmlUtils.getAttributeValueAsInt(this.f34988a, "width");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Integer mo37232d() {
        return XmlUtils.getAttributeValueAsInt(this.f34988a, "height");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Integer mo37233e() {
        String iconOffsetStr = XmlUtils.getAttributeValue(this.f34988a, OFFSET);
        try {
            return Strings.parseAbsoluteOffset(iconOffsetStr);
        } catch (NumberFormatException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Invalid VAST icon offset format: %s:", new Object[]{iconOffsetStr}));
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Integer mo37231c() {
        String iconDurationStr = XmlUtils.getAttributeValue(this.f34988a, DURATION);
        try {
            return Strings.parseAbsoluteOffset(iconDurationStr);
        } catch (NumberFormatException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Invalid VAST icon duration format: %s:", new Object[]{iconDurationStr}));
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public VastResourceXmlManager mo37234f() {
        return this.f34989b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<VastTracker> mo37230b() {
        Node iconClicksNode = XmlUtils.getFirstMatchingChildNode(this.f34988a, ICON_CLICKS);
        List<VastTracker> iconClickTrackingUris = new ArrayList<>();
        if (iconClicksNode == null) {
            return iconClickTrackingUris;
        }
        for (Node iconClickTrackingNode : XmlUtils.getMatchingChildNodes(iconClicksNode, ICON_CLICK_TRACKING)) {
            String uri = XmlUtils.getNodeValue(iconClickTrackingNode);
            if (uri != null) {
                iconClickTrackingUris.add(new VastTracker(uri));
            }
        }
        return iconClickTrackingUris;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo37229a() {
        Node iconClicksNode = XmlUtils.getFirstMatchingChildNode(this.f34988a, ICON_CLICKS);
        if (iconClicksNode == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(iconClicksNode, ICON_CLICK_THROUGH));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public List<VastTracker> mo37235g() {
        List<Node> iconViewTrackingNodes = XmlUtils.getMatchingChildNodes(this.f34988a, ICON_VIEW_TRACKING);
        List<VastTracker> iconViewTrackingUris = new ArrayList<>();
        for (Node iconViewTrackingNode : iconViewTrackingNodes) {
            String uri = XmlUtils.getNodeValue(iconViewTrackingNode);
            if (uri != null) {
                iconViewTrackingUris.add(new VastTracker(uri));
            }
        }
        return iconViewTrackingUris;
    }
}
