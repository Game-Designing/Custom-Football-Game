package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ViewBinder {

    /* renamed from: a */
    final int f36081a;

    /* renamed from: b */
    final int f36082b;

    /* renamed from: c */
    final int f36083c;

    /* renamed from: d */
    final int f36084d;

    /* renamed from: e */
    final int f36085e;

    /* renamed from: f */
    final int f36086f;

    /* renamed from: g */
    final int f36087g;

    /* renamed from: h */
    final Map<String, Integer> f36088h;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f36089a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f36090b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f36091c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f36092d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f36093e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f36094f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f36095g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Map<String, Integer> f36096h = Collections.emptyMap();

        public Builder(int layoutId) {
            this.f36089a = layoutId;
            this.f36096h = new HashMap();
        }

        public final Builder titleId(int titleId) {
            this.f36090b = titleId;
            return this;
        }

        public final Builder textId(int textId) {
            this.f36091c = textId;
            return this;
        }

        public final Builder callToActionId(int callToActionId) {
            this.f36092d = callToActionId;
            return this;
        }

        public final Builder mainImageId(int mediaLayoutId) {
            this.f36093e = mediaLayoutId;
            return this;
        }

        public final Builder iconImageId(int iconImageId) {
            this.f36094f = iconImageId;
            return this;
        }

        public final Builder privacyInformationIconImageId(int privacyInformationIconImageId) {
            this.f36095g = privacyInformationIconImageId;
            return this;
        }

        public final Builder addExtras(Map<String, Integer> resourceIds) {
            this.f36096h = new HashMap(resourceIds);
            return this;
        }

        public final Builder addExtra(String key, int resourceId) {
            this.f36096h.put(key, Integer.valueOf(resourceId));
            return this;
        }

        public final ViewBinder build() {
            return new ViewBinder(this);
        }
    }

    private ViewBinder(Builder builder) {
        this.f36081a = builder.f36089a;
        this.f36082b = builder.f36090b;
        this.f36083c = builder.f36091c;
        this.f36084d = builder.f36092d;
        this.f36085e = builder.f36093e;
        this.f36086f = builder.f36094f;
        this.f36087g = builder.f36095g;
        this.f36088h = builder.f36096h;
    }
}
