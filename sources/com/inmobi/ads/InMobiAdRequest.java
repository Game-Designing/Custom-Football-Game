package com.inmobi.ads;

import java.util.Map;

public class InMobiAdRequest {

    /* renamed from: a */
    final long f31254a;

    /* renamed from: b */
    final MonetizationContext f31255b;

    /* renamed from: c */
    final int f31256c;

    /* renamed from: d */
    final int f31257d;

    /* renamed from: e */
    final String f31258e;

    /* renamed from: f */
    final Map<String, String> f31259f;

    public static class Builder {

        /* renamed from: a */
        int f31260a;

        /* renamed from: b */
        int f31261b;

        /* renamed from: c */
        String f31262c;

        /* renamed from: d */
        Map<String, String> f31263d;

        /* renamed from: e */
        private long f31264e;

        /* renamed from: f */
        private MonetizationContext f31265f = MonetizationContext.MONETIZATION_CONTEXT_OTHER;

        public Builder(long j) {
            this.f31264e = j;
        }

        public Builder setMonetizationContext(MonetizationContext monetizationContext) {
            this.f31265f = monetizationContext;
            return this;
        }

        public Builder setSlotSize(int i, int i2) {
            this.f31260a = i;
            this.f31261b = i2;
            return this;
        }

        public Builder setKeywords(String str) {
            this.f31262c = str;
            return this;
        }

        public Builder setExtras(Map<String, String> map) {
            this.f31263d = map;
            return this;
        }

        public InMobiAdRequest build() {
            InMobiAdRequest inMobiAdRequest = new InMobiAdRequest(this.f31264e, this.f31265f, this.f31260a, this.f31261b, this.f31262c, this.f31263d, 0);
            return inMobiAdRequest;
        }
    }

    public enum MonetizationContext {
        MONETIZATION_CONTEXT_ACTIVITY("activity"),
        MONETIZATION_CONTEXT_OTHER("others");
        

        /* renamed from: a */
        final String f31266a;

        private MonetizationContext(String str) {
            this.f31266a = str;
        }

        /* renamed from: a */
        static MonetizationContext m33595a(String str) {
            MonetizationContext[] values;
            for (MonetizationContext monetizationContext : values()) {
                if (monetizationContext.f31266a.equalsIgnoreCase(str)) {
                    return monetizationContext;
                }
            }
            return null;
        }

        public final String toString() {
            return this.f31266a;
        }
    }

    /* synthetic */ InMobiAdRequest(long j, MonetizationContext monetizationContext, int i, int i2, String str, Map map, byte b) {
        this(j, monetizationContext, i, i2, str, map);
    }

    private InMobiAdRequest(long j, MonetizationContext monetizationContext, int i, int i2, String str, Map<String, String> map) {
        this.f31254a = j;
        this.f31255b = monetizationContext;
        this.f31256c = i;
        this.f31257d = i2;
        this.f31258e = str;
        this.f31259f = map;
    }
}
