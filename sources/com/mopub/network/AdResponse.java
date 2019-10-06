package com.mopub.network;

import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse implements Serializable {

    /* renamed from: A */
    private final String f36287A;

    /* renamed from: B */
    private final BrowserAgent f36288B;

    /* renamed from: C */
    private final Map<String, String> f36289C;

    /* renamed from: D */
    private final long f36290D;

    /* renamed from: a */
    private final String f36291a;

    /* renamed from: b */
    private final String f36292b;

    /* renamed from: c */
    private final String f36293c;

    /* renamed from: d */
    private final String f36294d;

    /* renamed from: e */
    private final String f36295e;

    /* renamed from: f */
    private final String f36296f;

    /* renamed from: g */
    private final String f36297g;

    /* renamed from: h */
    private final String f36298h;

    /* renamed from: i */
    private final Integer f36299i;

    /* renamed from: j */
    private final boolean f36300j;

    /* renamed from: k */
    private final ImpressionData f36301k;

    /* renamed from: l */
    private final String f36302l;

    /* renamed from: m */
    private final List<String> f36303m;

    /* renamed from: n */
    private final String f36304n;

    /* renamed from: o */
    private final String f36305o;

    /* renamed from: p */
    private final List<String> f36306p;

    /* renamed from: q */
    private final List<String> f36307q;

    /* renamed from: r */
    private final List<String> f36308r;

    /* renamed from: s */
    private final String f36309s;

    /* renamed from: t */
    private final Integer f36310t;

    /* renamed from: u */
    private final Integer f36311u;

    /* renamed from: v */
    private final Integer f36312v;

    /* renamed from: w */
    private final Integer f36313w;

    /* renamed from: x */
    private final String f36314x;

    /* renamed from: y */
    private final String f36315y;

    /* renamed from: z */
    private final JSONObject f36316z;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: A */
        public String f36317A;
        /* access modifiers changed from: private */

        /* renamed from: B */
        public BrowserAgent f36318B;
        /* access modifiers changed from: private */

        /* renamed from: C */
        public Map<String, String> f36319C = new TreeMap();
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f36320a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f36321b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f36322c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f36323d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f36324e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f36325f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public String f36326g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public String f36327h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Integer f36328i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public boolean f36329j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public ImpressionData f36330k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public String f36331l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public List<String> f36332m = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: n */
        public String f36333n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public String f36334o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public List<String> f36335p = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: q */
        public List<String> f36336q = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: r */
        public List<String> f36337r = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: s */
        public String f36338s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public Integer f36339t;
        /* access modifiers changed from: private */

        /* renamed from: u */
        public Integer f36340u;
        /* access modifiers changed from: private */

        /* renamed from: v */
        public Integer f36341v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public Integer f36342w;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public String f36343x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public String f36344y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public JSONObject f36345z;

        public Builder setAdType(String adType) {
            this.f36320a = adType;
            return this;
        }

        public Builder setAdUnitId(String adUnitId) {
            this.f36321b = adUnitId;
            return this;
        }

        public Builder setFullAdType(String fullAdType) {
            this.f36322c = fullAdType;
            return this;
        }

        public Builder setNetworkType(String networkType) {
            this.f36323d = networkType;
            return this;
        }

        public Builder setRewardedVideoCurrencyName(String rewardedVideoCurrencyName) {
            this.f36324e = rewardedVideoCurrencyName;
            return this;
        }

        public Builder setRewardedVideoCurrencyAmount(String rewardedVideoCurrencyAmount) {
            this.f36325f = rewardedVideoCurrencyAmount;
            return this;
        }

        public Builder setRewardedCurrencies(String rewardedCurrencies) {
            this.f36326g = rewardedCurrencies;
            return this;
        }

        public Builder setRewardedVideoCompletionUrl(String rewardedVideoCompletionUrl) {
            this.f36327h = rewardedVideoCompletionUrl;
            return this;
        }

        public Builder setRewardedDuration(Integer rewardedDuration) {
            this.f36328i = rewardedDuration;
            return this;
        }

        public Builder setShouldRewardOnClick(boolean shouldRewardOnClick) {
            this.f36329j = shouldRewardOnClick;
            return this;
        }

        public Builder setImpressionData(ImpressionData impressionData) {
            this.f36330k = impressionData;
            return this;
        }

        public Builder setClickTrackingUrl(String clickTrackingUrl) {
            this.f36331l = clickTrackingUrl;
            return this;
        }

        public Builder setImpressionTrackingUrls(List<String> impressionTrackingUrls) {
            Preconditions.checkNotNull(impressionTrackingUrls);
            this.f36332m = impressionTrackingUrls;
            return this;
        }

        public Builder setFailoverUrl(String failoverUrl) {
            this.f36333n = failoverUrl;
            return this;
        }

        public Builder setBeforeLoadUrl(String beforeLoadUrl) {
            this.f36334o = beforeLoadUrl;
            return this;
        }

        public Builder setAfterLoadUrls(List<String> afterLoadUrls) {
            Preconditions.checkNotNull(afterLoadUrls);
            this.f36335p = afterLoadUrls;
            return this;
        }

        public Builder setAfterLoadSuccessUrls(List<String> afterLoadSuccessUrls) {
            Preconditions.checkNotNull(afterLoadSuccessUrls);
            this.f36336q = afterLoadSuccessUrls;
            return this;
        }

        public Builder setAfterLoadFailUrls(List<String> afterLoadFailUrls) {
            Preconditions.checkNotNull(afterLoadFailUrls);
            this.f36337r = afterLoadFailUrls;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.f36338s = requestId;
            return this;
        }

        public Builder setDimensions(Integer width, Integer height) {
            this.f36339t = width;
            this.f36340u = height;
            return this;
        }

        public Builder setAdTimeoutDelayMilliseconds(Integer adTimeoutDelayMilliseconds) {
            this.f36341v = adTimeoutDelayMilliseconds;
            return this;
        }

        public Builder setRefreshTimeMilliseconds(Integer refreshTimeMilliseconds) {
            this.f36342w = refreshTimeMilliseconds;
            return this;
        }

        public Builder setDspCreativeId(String dspCreativeId) {
            this.f36343x = dspCreativeId;
            return this;
        }

        public Builder setResponseBody(String responseBody) {
            this.f36344y = responseBody;
            return this;
        }

        public Builder setJsonBody(JSONObject jsonBody) {
            this.f36345z = jsonBody;
            return this;
        }

        public Builder setCustomEventClassName(String customEventClassName) {
            this.f36317A = customEventClassName;
            return this;
        }

        public Builder setBrowserAgent(BrowserAgent browserAgent) {
            this.f36318B = browserAgent;
            return this;
        }

        public Builder setServerExtras(Map<String, String> serverExtras) {
            if (serverExtras == null) {
                this.f36319C = new TreeMap();
            } else {
                this.f36319C = new TreeMap(serverExtras);
            }
            return this;
        }

        public AdResponse build() {
            return new AdResponse(this);
        }
    }

    private AdResponse(Builder builder) {
        this.f36291a = builder.f36320a;
        this.f36292b = builder.f36321b;
        this.f36293c = builder.f36322c;
        this.f36294d = builder.f36323d;
        this.f36295e = builder.f36324e;
        this.f36296f = builder.f36325f;
        this.f36297g = builder.f36326g;
        this.f36298h = builder.f36327h;
        this.f36299i = builder.f36328i;
        this.f36300j = builder.f36329j;
        this.f36301k = builder.f36330k;
        this.f36302l = builder.f36331l;
        this.f36303m = builder.f36332m;
        this.f36304n = builder.f36333n;
        this.f36305o = builder.f36334o;
        this.f36306p = builder.f36335p;
        this.f36307q = builder.f36336q;
        this.f36308r = builder.f36337r;
        this.f36309s = builder.f36338s;
        this.f36310t = builder.f36339t;
        this.f36311u = builder.f36340u;
        this.f36312v = builder.f36341v;
        this.f36313w = builder.f36342w;
        this.f36314x = builder.f36343x;
        this.f36315y = builder.f36344y;
        this.f36316z = builder.f36345z;
        this.f36287A = builder.f36317A;
        this.f36288B = builder.f36318B;
        this.f36289C = builder.f36319C;
        this.f36290D = DateAndTime.now().getTime();
    }

    public boolean hasJson() {
        return this.f36316z != null;
    }

    public JSONObject getJsonBody() {
        return this.f36316z;
    }

    public String getStringBody() {
        return this.f36315y;
    }

    public String getAdType() {
        return this.f36291a;
    }

    public String getFullAdType() {
        return this.f36293c;
    }

    public String getAdUnitId() {
        return this.f36292b;
    }

    public String getNetworkType() {
        return this.f36294d;
    }

    public String getRewardedVideoCurrencyName() {
        return this.f36295e;
    }

    public String getRewardedVideoCurrencyAmount() {
        return this.f36296f;
    }

    public String getRewardedCurrencies() {
        return this.f36297g;
    }

    public String getRewardedVideoCompletionUrl() {
        return this.f36298h;
    }

    public Integer getRewardedDuration() {
        return this.f36299i;
    }

    public boolean shouldRewardOnClick() {
        return this.f36300j;
    }

    public ImpressionData getImpressionData() {
        return this.f36301k;
    }

    public String getClickTrackingUrl() {
        return this.f36302l;
    }

    public List<String> getImpressionTrackingUrls() {
        return this.f36303m;
    }

    @Deprecated
    public String getFailoverUrl() {
        return this.f36304n;
    }

    public String getBeforeLoadUrl() {
        return this.f36305o;
    }

    public List<String> getAfterLoadUrls() {
        return this.f36306p;
    }

    public List<String> getAfterLoadSuccessUrls() {
        return this.f36307q;
    }

    public List<String> getAfterLoadFailUrls() {
        return this.f36308r;
    }

    public String getRequestId() {
        return this.f36309s;
    }

    public Integer getWidth() {
        return this.f36310t;
    }

    public Integer getHeight() {
        return this.f36311u;
    }

    public Integer getAdTimeoutMillis(int defaultValue) {
        Integer num = this.f36312v;
        if (num == null || num.intValue() < 1000) {
            return Integer.valueOf(defaultValue);
        }
        return this.f36312v;
    }

    public Integer getRefreshTimeMillis() {
        return this.f36313w;
    }

    public String getDspCreativeId() {
        return this.f36314x;
    }

    public String getCustomEventClassName() {
        return this.f36287A;
    }

    public BrowserAgent getBrowserAgent() {
        return this.f36288B;
    }

    public Map<String, String> getServerExtras() {
        return new TreeMap(this.f36289C);
    }

    public long getTimestamp() {
        return this.f36290D;
    }

    public Builder toBuilder() {
        return new Builder().setAdType(this.f36291a).setNetworkType(this.f36294d).setRewardedVideoCurrencyName(this.f36295e).setRewardedVideoCurrencyAmount(this.f36296f).setRewardedCurrencies(this.f36297g).setRewardedVideoCompletionUrl(this.f36298h).setRewardedDuration(this.f36299i).setShouldRewardOnClick(this.f36300j).setImpressionData(this.f36301k).setClickTrackingUrl(this.f36302l).setImpressionTrackingUrls(this.f36303m).setFailoverUrl(this.f36304n).setBeforeLoadUrl(this.f36305o).setAfterLoadUrls(this.f36306p).setAfterLoadSuccessUrls(this.f36307q).setAfterLoadFailUrls(this.f36308r).setDimensions(this.f36310t, this.f36311u).setAdTimeoutDelayMilliseconds(this.f36312v).setRefreshTimeMilliseconds(this.f36313w).setDspCreativeId(this.f36314x).setResponseBody(this.f36315y).setJsonBody(this.f36316z).setCustomEventClassName(this.f36287A).setBrowserAgent(this.f36288B).setServerExtras(this.f36289C);
    }
}
