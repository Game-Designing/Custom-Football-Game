package com.integralads.avid.library.mopub.session;

public class ExternalAvidAdSessionContext {
    private boolean isDeferred;
    private String partnerVersion;

    public ExternalAvidAdSessionContext(String partnerVersion2) {
        this(partnerVersion2, false);
    }

    public ExternalAvidAdSessionContext(String partnerVersion2, boolean isDeferred2) {
        this.partnerVersion = partnerVersion2;
        this.isDeferred = isDeferred2;
    }

    public String getPartnerVersion() {
        return this.partnerVersion;
    }

    public boolean isDeferred() {
        return this.isDeferred;
    }
}
