package com.google.android.gms.ads.rewarded;

public class ServerSideVerificationOptions {

    /* renamed from: a */
    private final String f19238a;

    /* renamed from: b */
    private final String f19239b;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f19240a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f19241b;

        public Builder() {
            String str = "";
            this.f19240a = str;
            this.f19241b = str;
        }

        public final Builder setUserId(String str) {
            this.f19240a = str;
            return this;
        }

        public final Builder setCustomData(String str) {
            this.f19241b = str;
            return this;
        }

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f19238a = builder.f19240a;
        this.f19239b = builder.f19241b;
    }

    public String getUserId() {
        return this.f19238a;
    }

    public String getCustomData() {
        return this.f19239b;
    }
}
