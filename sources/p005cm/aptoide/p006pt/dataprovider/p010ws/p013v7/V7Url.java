package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import java.util.regex.Matcher;
import p005cm.aptoide.p006pt.utils.AptoideUtils.RegexU;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.V7Url */
public class V7Url {
    private String url;

    public V7Url(String url2) {
        this.url = url2;
    }

    public String get() {
        return this.url;
    }

    public String getStoreName() {
        Matcher matcher = RegexU.getStoreNameFromGetUrlPattern().matcher(this.url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public Long getStoreId() {
        Matcher matcher = RegexU.getStoreIdFromGetUrlPattern().matcher(this.url);
        if (matcher.find()) {
            return Long.valueOf(Long.parseLong(matcher.group(1)));
        }
        return null;
    }

    public V7Url remove(String toRemove) {
        this.url = this.url.replace(toRemove, "");
        return this;
    }

    public boolean containsLimit() {
        return this.url.contains("limit=");
    }
}
