package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VideoViewabilityTrackerXmlManager {
    public static final String PERCENT_VIEWABLE = "percentViewable";
    public static final String VIEWABLE_PLAYTIME = "viewablePlaytime";

    /* renamed from: a */
    private final Node f35118a;

    VideoViewabilityTrackerXmlManager(Node videoViewabilityNode) {
        Preconditions.checkNotNull(videoViewabilityNode);
        this.f35118a = videoViewabilityNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Integer mo37394c() {
        String viewablePlaytimeStr = XmlUtils.getAttributeValue(this.f35118a, VIEWABLE_PLAYTIME);
        if (viewablePlaytimeStr == null) {
            return null;
        }
        Integer viewablePlaytimeMS = null;
        if (Strings.isAbsoluteTracker(viewablePlaytimeStr)) {
            try {
                viewablePlaytimeMS = Strings.parseAbsoluteOffset(viewablePlaytimeStr);
            } catch (NumberFormatException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Invalid VAST viewablePlaytime format for \"HH:MM:SS[.mmm]\": %s:", new Object[]{viewablePlaytimeStr}));
            }
        } else {
            try {
                viewablePlaytimeMS = Integer.valueOf((int) (Float.parseFloat(viewablePlaytimeStr) * 1000.0f));
            } catch (NumberFormatException e2) {
                MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Invalid VAST viewablePlaytime format for \"SS[.mmm]\": %s:", new Object[]{viewablePlaytimeStr}));
            }
        }
        if (viewablePlaytimeMS == null || viewablePlaytimeMS.intValue() < 0) {
            return null;
        }
        return viewablePlaytimeMS;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Integer mo37392a() {
        String percentViewableStr = XmlUtils.getAttributeValue(this.f35118a, PERCENT_VIEWABLE);
        if (percentViewableStr == null) {
            return null;
        }
        Integer percentViewable = null;
        try {
            percentViewable = Integer.valueOf((int) Float.parseFloat(percentViewableStr.replace("%", "")));
        } catch (NumberFormatException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Invalid VAST percentViewable format for \"d{1,3}%%\": %s:", new Object[]{percentViewableStr}));
        }
        if (percentViewable == null || percentViewable.intValue() < 0 || percentViewable.intValue() > 100) {
            return null;
        }
        return percentViewable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37393b() {
        return XmlUtils.getNodeValue(this.f35118a);
    }
}
