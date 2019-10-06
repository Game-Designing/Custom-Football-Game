package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MediaViewBinder {

    /* renamed from: a */
    final int f35798a;

    /* renamed from: b */
    final int f35799b;

    /* renamed from: c */
    final int f35800c;

    /* renamed from: d */
    final int f35801d;

    /* renamed from: e */
    final int f35802e;

    /* renamed from: f */
    final int f35803f;

    /* renamed from: g */
    final int f35804g;

    /* renamed from: h */
    final Map<String, Integer> f35805h;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f35806a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f35807b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f35808c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f35809d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f35810e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f35811f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f35812g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Map<String, Integer> f35813h = Collections.emptyMap();

        public Builder(int layoutId) {
            this.f35806a = layoutId;
            this.f35813h = new HashMap();
        }

        public final Builder mediaLayoutId(int mediaLayoutId) {
            this.f35807b = mediaLayoutId;
            return this;
        }

        public final Builder titleId(int titlteId) {
            this.f35808c = titlteId;
            return this;
        }

        public final Builder textId(int textId) {
            this.f35809d = textId;
            return this;
        }

        public final Builder iconImageId(int iconImageId) {
            this.f35810e = iconImageId;
            return this;
        }

        public final Builder callToActionId(int callToActionId) {
            this.f35811f = callToActionId;
            return this;
        }

        public final Builder privacyInformationIconImageId(int privacyInformationIconImageId) {
            this.f35812g = privacyInformationIconImageId;
            return this;
        }

        public final Builder addExtras(Map<String, Integer> resourceIds) {
            this.f35813h = new HashMap(resourceIds);
            return this;
        }

        public final Builder addExtra(String key, int resourceId) {
            this.f35813h.put(key, Integer.valueOf(resourceId));
            return this;
        }

        public final MediaViewBinder build() {
            return new MediaViewBinder(this);
        }
    }

    private MediaViewBinder(Builder builder) {
        this.f35798a = builder.f35806a;
        this.f35799b = builder.f35807b;
        this.f35800c = builder.f35808c;
        this.f35801d = builder.f35809d;
        this.f35802e = builder.f35811f;
        this.f35803f = builder.f35810e;
        this.f35804g = builder.f35812g;
        this.f35805h = builder.f35813h;
    }
}
