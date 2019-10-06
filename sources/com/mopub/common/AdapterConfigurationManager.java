package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.MoPubErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AdapterConfigurationManager implements C11240a {

    /* renamed from: a */
    private volatile Map<String, AdapterConfiguration> f34223a;

    /* renamed from: b */
    private SdkInitializationListener f34224b;

    /* renamed from: com.mopub.common.AdapterConfigurationManager$a */
    private static class C11217a extends AsyncTask<Void, Void, Map<String, AdapterConfiguration>> {

        /* renamed from: a */
        private final WeakReference<Context> f34225a;

        /* renamed from: b */
        private final Set<String> f34226b;

        /* renamed from: c */
        private final Map<String, Map<String, String>> f34227c;

        /* renamed from: d */
        private final Map<String, Map<String, String>> f34228d;

        /* renamed from: e */
        private final C11240a f34229e;

        C11217a(Context context, Set<String> adapterConfigurationClasses, Map<String, Map<String, String>> networkMediationConfigurations, Map<String, Map<String, String>> moPubRequestOptions, C11240a adapterConfigurationsInitializationListener) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(adapterConfigurationClasses);
            Preconditions.checkNotNull(networkMediationConfigurations);
            Preconditions.checkNotNull(moPubRequestOptions);
            Preconditions.checkNotNull(adapterConfigurationsInitializationListener);
            this.f34225a = new WeakReference<>(context);
            this.f34226b = adapterConfigurationClasses;
            this.f34227c = networkMediationConfigurations;
            this.f34228d = moPubRequestOptions;
            this.f34229e = adapterConfigurationsInitializationListener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Map<String, AdapterConfiguration> doInBackground(Void... voids) {
            Map<String, AdapterConfiguration> adapterConfigurations = new HashMap<>();
            for (String adapterConfigurationClass : this.f34226b) {
                try {
                    AdapterConfiguration adapterConfiguration = (AdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(adapterConfigurationClass, AdapterConfiguration.class);
                    Context context = (Context) this.f34225a.get();
                    if (context == null) {
                        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Context null. Unable to initialize adapter configuration ");
                        sb.append(adapterConfigurationClass);
                        MoPubLog.log(sdkLogEvent, sb.toString());
                    } else {
                        Map<String, String> networkMediationConfiguration = (Map) this.f34227c.get(adapterConfigurationClass);
                        Map<String, String> mergedParameters = new HashMap<>(adapterConfiguration.getCachedInitializationParameters(context));
                        if (networkMediationConfiguration != null) {
                            mergedParameters.putAll(networkMediationConfiguration);
                            adapterConfiguration.setCachedInitializationParameters(context, mergedParameters);
                        }
                        Map<String, String> moPubRequestOption = (Map) this.f34228d.get(adapterConfigurationClass);
                        if (moPubRequestOption != null) {
                            adapterConfiguration.setMoPubRequestOptions(moPubRequestOption);
                        }
                        MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Initializing %s version %s with network sdk version %s and with params %s", new Object[]{adapterConfigurationClass, adapterConfiguration.getAdapterVersion(), adapterConfiguration.getNetworkSdkVersion(), mergedParameters}));
                        adapterConfiguration.initializeNetwork(context, mergedParameters, this.f34229e);
                        adapterConfigurations.put(adapterConfigurationClass, adapterConfiguration);
                    }
                } catch (Exception e) {
                    SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM_WITH_THROWABLE;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to find class ");
                    sb2.append(adapterConfigurationClass);
                    MoPubLog.log(sdkLogEvent2, sb2.toString(), e);
                }
            }
            return adapterConfigurations;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Map<String, AdapterConfiguration> adapterConfigurations) {
            this.f34229e.onAdapterConfigurationsInitialized(adapterConfigurations);
        }
    }

    AdapterConfigurationManager(SdkInitializationListener sdkInitializationListener) {
        this.f34224b = sdkInitializationListener;
    }

    public void initialize(Context context, Set<String> adapterConfigurationClasses, Map<String, Map<String, String>> networkMediationConfigurations, Map<String, Map<String, String>> moPubRequestOptions) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adapterConfigurationClasses);
        Preconditions.checkNotNull(networkMediationConfigurations);
        Preconditions.checkNotNull(moPubRequestOptions);
        C11217a aVar = new C11217a(context.getApplicationContext(), adapterConfigurationClasses, networkMediationConfigurations, moPubRequestOptions, this);
        AsyncTasks.safeExecuteOnExecutor(aVar, new Void[0]);
    }

    public List<String> getAdvancedBidderNames() {
        Map<String, AdapterConfiguration> adapterConfigurations = this.f34223a;
        if (adapterConfigurations == null || adapterConfigurations.isEmpty()) {
            return null;
        }
        List<String> abNames = new ArrayList<>();
        for (AdapterConfiguration adapterConfiguration : adapterConfigurations.values()) {
            abNames.add(adapterConfiguration.getMoPubNetworkName());
        }
        return abNames;
    }

    public List<String> getAdapterConfigurationInfo() {
        Map<String, AdapterConfiguration> adapterConfigurations = this.f34223a;
        if (adapterConfigurations == null || adapterConfigurations.isEmpty()) {
            return null;
        }
        List<String> abNames = new ArrayList<>();
        for (Entry<String, AdapterConfiguration> entry : adapterConfigurations.entrySet()) {
            StringBuilder configDetails = new StringBuilder();
            String adapterName = (String) entry.getKey();
            configDetails.append(adapterName.substring(adapterName.lastIndexOf(".") + 1));
            configDetails.append(": Adapter version ");
            configDetails.append(((AdapterConfiguration) entry.getValue()).getAdapterVersion());
            configDetails.append(", SDK version ");
            configDetails.append(((AdapterConfiguration) entry.getValue()).getNetworkSdkVersion());
            abNames.add(configDetails.toString());
        }
        return abNames;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36429a(Context context) {
        Preconditions.checkNotNull(context);
        JSONObject tokens = m36933b(context);
        if (tokens == null) {
            return null;
        }
        return tokens.toString();
    }

    /* renamed from: b */
    private JSONObject m36933b(Context context) {
        Preconditions.checkNotNull(context);
        Map<String, AdapterConfiguration> adapterConfigurations = this.f34223a;
        if (adapterConfigurations == null || adapterConfigurations.isEmpty()) {
            return null;
        }
        JSONObject jsonObject = null;
        for (AdapterConfiguration adapterConfiguration : adapterConfigurations.values()) {
            try {
                String token = adapterConfiguration.getBiddingToken(context);
                if (!TextUtils.isEmpty(token)) {
                    JSONObject bidderJsonObject = new JSONObject();
                    bidderJsonObject.put("token", token);
                    if (jsonObject == null) {
                        jsonObject = new JSONObject();
                    }
                    jsonObject.put(adapterConfiguration.getMoPubNetworkName(), bidderJsonObject);
                }
            } catch (JSONException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.ERROR;
                StringBuilder sb = new StringBuilder();
                sb.append("JSON parsing failed for MoPub network name: ");
                sb.append(adapterConfiguration.getMoPubNetworkName());
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
        return jsonObject;
    }

    public void onAdapterConfigurationsInitialized(Map<String, AdapterConfiguration> adapterConfigurations) {
        Preconditions.checkNotNull(adapterConfigurations);
        this.f34223a = adapterConfigurations;
        SdkInitializationListener sdkInitializationListener = this.f34224b;
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
            this.f34224b = null;
        }
    }

    public void onNetworkInitializationFinished(Class<? extends AdapterConfiguration> adapterConfigurationClass, MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(adapterConfigurationClass);
        Preconditions.checkNotNull(moPubErrorCode);
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append(adapterConfigurationClass);
        sb.append(" initialized with error code ");
        sb.append(moPubErrorCode);
        MoPubLog.log(sdkLogEvent, sb.toString());
    }
}
