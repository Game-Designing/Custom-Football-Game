package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Json;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseAdapterConfiguration implements AdapterConfiguration {

    /* renamed from: a */
    private Map<String, String> f96a;

    public void setCachedInitializationParameters(Context context, Map<String, String> initializationParameters) {
        Preconditions.checkNotNull(context);
        if (initializationParameters != null && !initializationParameters.isEmpty()) {
            SharedPreferences sharedPreferences = SharedPreferencesHelper.getSharedPreferences(context, "mopubCustomEventSettings");
            String serverExtrasJsonString = new JSONObject(initializationParameters).toString();
            String adapterConfigurationClassName = getClass().getName();
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Updating init settings for custom event %s with params %s", new Object[]{adapterConfigurationClassName, serverExtrasJsonString}));
            sharedPreferences.edit().putString(adapterConfigurationClassName, serverExtrasJsonString).apply();
        }
    }

    public Map<String, String> getCachedInitializationParameters(Context context) {
        Map<String, ?> networkInitSettings = SharedPreferencesHelper.getSharedPreferences(context, "mopubCustomEventSettings").getAll();
        MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "fetched init settings for %s networks: %s", new Object[]{Integer.valueOf(networkInitSettings.size()), networkInitSettings.keySet()}));
        String adapterConfigurationClassName = getClass().getName();
        String networkInitParamsJsonString = (String) networkInitSettings.get(adapterConfigurationClassName);
        Map<String, String> networkInitParamsMap = new HashMap<>();
        try {
            return Json.jsonStringToMap(networkInitParamsJsonString);
        } catch (JSONException e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Error fetching init settings for adapter configuration ");
            sb.append(adapterConfigurationClassName);
            MoPubLog.log(sdkLogEvent, sb.toString());
            return networkInitParamsMap;
        }
    }

    public void setMoPubRequestOptions(Map<String, String> moPubRequestOptions) {
        this.f96a = moPubRequestOptions;
    }

    public Map<String, String> getMoPubRequestOptions() {
        return this.f96a;
    }
}
