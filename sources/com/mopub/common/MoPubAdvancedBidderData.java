package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubAdvancedBidderData {

    /* renamed from: a */
    final String f34339a;

    /* renamed from: b */
    final String f34340b;

    public MoPubAdvancedBidderData(String token, String creativeNetworkName) {
        Preconditions.checkNotNull(token);
        Preconditions.checkNotNull(creativeNetworkName);
        this.f34339a = token;
        this.f34340b = creativeNetworkName;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("token", this.f34339a);
        } catch (JSONException e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid token format: ");
            sb.append(this.f34339a);
            MoPubLog.log(sdkLogEvent, sb.toString());
        }
        return jsonObject;
    }
}
