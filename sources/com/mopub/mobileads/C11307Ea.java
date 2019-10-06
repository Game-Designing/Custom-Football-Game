package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.Ea */
/* compiled from: VastLinearXmlManager */
class C11307Ea {
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";

    /* renamed from: a */
    private final Node f34742a;

    C11307Ea(Node linearNode) {
        Preconditions.checkNotNull(linearNode);
        this.f34742a = linearNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<VastFractionalProgressTracker> mo36998d() {
        List<VastFractionalProgressTracker> percentTrackers = new ArrayList<>();
        m37347a(percentTrackers, m37346a("firstQuartile"), 0.25f);
        m37347a(percentTrackers, m37346a("midpoint"), 0.5f);
        m37347a(percentTrackers, m37346a("thirdQuartile"), 0.75f);
        Node trackingEvents = XmlUtils.getFirstMatchingChildNode(this.f34742a, "TrackingEvents");
        if (trackingEvents != null) {
            for (Node progressNode : XmlUtils.getMatchingChildNodes(trackingEvents, "Tracking", "event", Collections.singletonList("progress"))) {
                String offsetString = XmlUtils.getAttributeValue(progressNode, VastIconXmlManager.OFFSET);
                if (offsetString != null) {
                    String offsetString2 = offsetString.trim();
                    if (Strings.isPercentageTracker(offsetString2)) {
                        String trackingUrl = XmlUtils.getNodeValue(progressNode);
                        try {
                            float trackingFraction = Float.parseFloat(offsetString2.replace("%", "")) / 100.0f;
                            if (trackingFraction >= 0.0f) {
                                percentTrackers.add(new VastFractionalProgressTracker(trackingUrl, trackingFraction));
                            }
                        } catch (NumberFormatException e) {
                            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Failed to parse VAST progress tracker %s", new Object[]{offsetString2}));
                        }
                    }
                }
            }
        }
        Collections.sort(percentTrackers);
        return percentTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<VastAbsoluteProgressTracker> mo36995a() {
        List<VastAbsoluteProgressTracker> trackers = new ArrayList<>();
        for (String url : m37346a("start")) {
            trackers.add(new VastAbsoluteProgressTracker(url, 0));
        }
        Node trackingEvents = XmlUtils.getFirstMatchingChildNode(this.f34742a, "TrackingEvents");
        if (trackingEvents != null) {
            String str = "event";
            String str2 = "Tracking";
            for (Node progressNode : XmlUtils.getMatchingChildNodes(trackingEvents, str2, str, Collections.singletonList("progress"))) {
                String offsetString = XmlUtils.getAttributeValue(progressNode, VastIconXmlManager.OFFSET);
                if (offsetString != null) {
                    String offsetString2 = offsetString.trim();
                    if (Strings.isAbsoluteTracker(offsetString2)) {
                        String trackingUrl = XmlUtils.getNodeValue(progressNode);
                        try {
                            Integer trackingMilliseconds = Strings.parseAbsoluteOffset(offsetString2);
                            if (trackingMilliseconds != null && trackingMilliseconds.intValue() >= 0) {
                                trackers.add(new VastAbsoluteProgressTracker(trackingUrl, trackingMilliseconds.intValue()));
                            }
                        } catch (NumberFormatException e) {
                            NumberFormatException numberFormatException = e;
                            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Failed to parse VAST progress tracker %s", new Object[]{offsetString2}));
                        }
                    }
                }
            }
            for (Node creativeViewNode : XmlUtils.getMatchingChildNodes(trackingEvents, str2, str, Collections.singletonList("creativeView"))) {
                String creativeNodeValue = XmlUtils.getNodeValue(creativeViewNode);
                if (creativeNodeValue != null) {
                    trackers.add(new VastAbsoluteProgressTracker(creativeNodeValue, 0));
                }
            }
        }
        Collections.sort(trackers);
        return trackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public List<VastTracker> mo37005k() {
        return m37348b("complete");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public List<VastTracker> mo37001g() {
        List<String> trackers = m37346a("pause");
        List<VastTracker> vastRepeatableTrackers = new ArrayList<>();
        for (String tracker : trackers) {
            vastRepeatableTrackers.add(new VastTracker(tracker, true));
        }
        return vastRepeatableTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public List<VastTracker> mo37002h() {
        List<String> trackers = m37346a("resume");
        List<VastTracker> vastRepeatableTrackers = new ArrayList<>();
        for (String tracker : trackers) {
            vastRepeatableTrackers.add(new VastTracker(tracker, true));
        }
        return vastRepeatableTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public List<VastTracker> mo37004j() {
        List<VastTracker> closeTrackers = m37348b("close");
        closeTrackers.addAll(m37348b("closeLinear"));
        return closeTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public List<VastTracker> mo37006l() {
        return m37348b("skip");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo36996b() {
        Node videoClicks = XmlUtils.getFirstMatchingChildNode(this.f34742a, "VideoClicks");
        if (videoClicks == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(videoClicks, "ClickThrough"));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<VastTracker> mo36997c() {
        List<VastTracker> clickTrackers = new ArrayList<>();
        Node videoClicks = XmlUtils.getFirstMatchingChildNode(this.f34742a, "VideoClicks");
        if (videoClicks == null) {
            return clickTrackers;
        }
        for (Node clickTrackerNode : XmlUtils.getMatchingChildNodes(videoClicks, "ClickTracking")) {
            String tracker = XmlUtils.getNodeValue(clickTrackerNode);
            if (tracker != null) {
                clickTrackers.add(new VastTracker(tracker));
            }
        }
        return clickTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public String mo37003i() {
        String skipOffsetString = XmlUtils.getAttributeValue(this.f34742a, "skipoffset");
        if (skipOffsetString != null && !skipOffsetString.trim().isEmpty()) {
            return skipOffsetString.trim();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public List<C11315Ha> mo37000f() {
        List<VastMediaXmlManager> mediaXmlManagers = new ArrayList<>();
        Node mediaFiles = XmlUtils.getFirstMatchingChildNode(this.f34742a, "MediaFiles");
        if (mediaFiles == null) {
            return mediaXmlManagers;
        }
        for (Node mediaNode : XmlUtils.getMatchingChildNodes(mediaFiles, "MediaFile")) {
            mediaXmlManagers.add(new C11315Ha(mediaNode));
        }
        return mediaXmlManagers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public List<VastIconXmlManager> mo36999e() {
        List<VastIconXmlManager> iconXmlManagers = new ArrayList<>();
        Node icons = XmlUtils.getFirstMatchingChildNode(this.f34742a, ICONS);
        if (icons == null) {
            return iconXmlManagers;
        }
        for (Node iconNode : XmlUtils.getMatchingChildNodes(icons, ICON)) {
            iconXmlManagers.add(new VastIconXmlManager(iconNode));
        }
        return iconXmlManagers;
    }

    /* renamed from: b */
    private List<VastTracker> m37348b(String attributeValue) {
        List<String> trackers = m37346a(attributeValue);
        List<VastTracker> vastTrackers = new ArrayList<>(trackers.size());
        for (String tracker : trackers) {
            vastTrackers.add(new VastTracker(tracker));
        }
        return vastTrackers;
    }

    /* renamed from: a */
    private List<String> m37346a(String attributeValue) {
        Preconditions.checkNotNull(attributeValue);
        List<String> videoTrackers = new ArrayList<>();
        Node trackingEvents = XmlUtils.getFirstMatchingChildNode(this.f34742a, "TrackingEvents");
        if (trackingEvents == null) {
            return videoTrackers;
        }
        for (Node videoTrackerNode : XmlUtils.getMatchingChildNodes(trackingEvents, "Tracking", "event", Collections.singletonList(attributeValue))) {
            String tracker = XmlUtils.getNodeValue(videoTrackerNode);
            if (tracker != null) {
                videoTrackers.add(tracker);
            }
        }
        return videoTrackers;
    }

    /* renamed from: a */
    private void m37347a(List<VastFractionalProgressTracker> trackers, List<String> urls, float fraction) {
        Preconditions.checkNotNull(trackers, "trackers cannot be null");
        Preconditions.checkNotNull(urls, "urls cannot be null");
        for (String url : urls) {
            trackers.add(new VastFractionalProgressTracker(url, fraction));
        }
    }
}
