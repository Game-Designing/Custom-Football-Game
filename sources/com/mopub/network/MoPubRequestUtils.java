package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubRequestUtils {
    public static String truncateQueryParamsIfPost(String url) {
        Preconditions.checkNotNull(url);
        if (!isMoPubRequest(url)) {
            return url;
        }
        int queryPosition = url.indexOf(63);
        if (queryPosition == -1) {
            return url;
        }
        return url.substring(0, queryPosition);
    }

    public static boolean isMoPubRequest(String url) {
        Preconditions.checkNotNull(url);
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(Constants.HOST);
        String httpHost = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://");
        sb2.append(Constants.HOST);
        return url.startsWith(httpHost) || url.startsWith(sb2.toString());
    }

    public static int chooseMethod(String url) {
        if (isMoPubRequest(url)) {
            return 1;
        }
        return 0;
    }

    public static Map<String, String> convertQueryToMap(Context context, String url) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(url);
        return getQueryParamMap(Uri.parse(Networking.getUrlRewriter(context).rewriteUrl(url)));
    }

    public static Map<String, String> getQueryParamMap(Uri uri) {
        Preconditions.checkNotNull(uri);
        Map<String, String> params = new HashMap<>();
        for (String queryParam : uri.getQueryParameterNames()) {
            params.put(queryParam, TextUtils.join(",", uri.getQueryParameters(queryParam)));
        }
        return params;
    }

    public static String generateBodyFromParams(Map<String, String> params, String url) {
        Preconditions.checkNotNull(url);
        if (!isMoPubRequest(url) || params == null || params.isEmpty()) {
            return null;
        }
        JSONObject jsonBody = new JSONObject();
        for (String queryName : params.keySet()) {
            try {
                jsonBody.put(queryName, params.get(queryName));
            } catch (JSONException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to add ");
                sb.append(queryName);
                sb.append(" to JSON body.");
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
        return jsonBody.toString();
    }

    private MoPubRequestUtils() {
    }
}
