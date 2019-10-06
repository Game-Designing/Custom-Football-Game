package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VastMacroHelper {

    /* renamed from: a */
    private final List<String> f34990a;

    /* renamed from: b */
    private final Map<C11309Fa, String> f34991b = new HashMap();

    public VastMacroHelper(List<String> uris) {
        Preconditions.checkNotNull(uris, "uris cannot be null");
        this.f34990a = uris;
        this.f34991b.put(C11309Fa.CACHEBUSTING, m37570a());
    }

    public List<String> getUris() {
        C11309Fa[] values;
        List<String> modifiedUris = new ArrayList<>();
        for (String modifiedUri : this.f34990a) {
            if (!TextUtils.isEmpty(modifiedUri)) {
                for (C11309Fa vastMacro : C11309Fa.values()) {
                    String value = (String) this.f34991b.get(vastMacro);
                    if (value == null) {
                        value = "";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("\\[");
                    sb.append(vastMacro.name());
                    sb.append("\\]");
                    modifiedUri = modifiedUri.replaceAll(sb.toString(), value);
                }
                modifiedUris.add(modifiedUri);
            }
        }
        return modifiedUris;
    }

    public VastMacroHelper withErrorCode(VastErrorCode errorCode) {
        if (errorCode != null) {
            this.f34991b.put(C11309Fa.ERRORCODE, errorCode.mo37219e());
        }
        return this;
    }

    public VastMacroHelper withContentPlayHead(Integer contentPlayHeadMS) {
        if (contentPlayHeadMS != null) {
            String contentPlayHeadMSStr = m37571a(contentPlayHeadMS.intValue());
            if (!TextUtils.isEmpty(contentPlayHeadMSStr)) {
                this.f34991b.put(C11309Fa.CONTENTPLAYHEAD, contentPlayHeadMSStr);
            }
        }
        return this;
    }

    public VastMacroHelper withAssetUri(String assetUri) {
        if (!TextUtils.isEmpty(assetUri)) {
            try {
                assetUri = URLEncoder.encode(assetUri, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                MoPubLog.log(SdkLogEvent.ERROR, "Failed to encode url", e);
            }
            this.f34991b.put(C11309Fa.ASSETURI, assetUri);
        }
        return this;
    }

    /* renamed from: a */
    private String m37570a() {
        return String.format(Locale.US, "%08d", new Object[]{Long.valueOf(Math.round(Math.random() * 1.0E8d))});
    }

    /* renamed from: a */
    private String m37571a(int contentPlayHeadMS) {
        return String.format("%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours((long) contentPlayHeadMS)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) contentPlayHeadMS) % TimeUnit.HOURS.toMinutes(1)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) contentPlayHeadMS) % TimeUnit.MINUTES.toSeconds(1)), Integer.valueOf(contentPlayHeadMS % 1000)});
    }
}
