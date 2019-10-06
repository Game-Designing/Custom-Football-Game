package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;

public class VastTracker implements Serializable {

    /* renamed from: a */
    private final C11358a f34999a;

    /* renamed from: b */
    private final String f35000b;

    /* renamed from: c */
    private boolean f35001c;

    /* renamed from: d */
    private boolean f35002d;

    /* renamed from: com.mopub.mobileads.VastTracker$a */
    enum C11358a {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    public VastTracker(C11358a messageType, String content) {
        Preconditions.checkNotNull(messageType);
        Preconditions.checkNotNull(content);
        this.f34999a = messageType;
        this.f35000b = content;
    }

    public VastTracker(String trackingUrl) {
        this(C11358a.TRACKING_URL, trackingUrl);
    }

    public VastTracker(String trackingUrl, boolean isRepeatable) {
        this(trackingUrl);
        this.f35002d = isRepeatable;
    }

    public C11358a getMessageType() {
        return this.f34999a;
    }

    public String getContent() {
        return this.f35000b;
    }

    public void setTracked() {
        this.f35001c = true;
    }

    public boolean isTracked() {
        return this.f35001c;
    }

    public boolean isRepeatable() {
        return this.f35002d;
    }
}
