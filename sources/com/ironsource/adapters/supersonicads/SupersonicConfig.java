package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p281e.C12827r;

public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String CAMPAIGN_ID = "campaignId";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private Map<String, String> mOfferwallCustomParams;
    C12826q mProviderSettings = new C12826q(C12827r.m41739b().mo41560b("Mediation"));
    private Map<String, String> mRewardedVideoCustomParams;

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    private SupersonicConfig() {
    }

    public void setClientSideCallbacks(boolean status) {
        this.mProviderSettings.mo41545c("useClientSideCallbacks", String.valueOf(status));
    }

    public void setCustomControllerUrl(String url) {
        String str = "controllerUrl";
        this.mProviderSettings.mo41545c(str, url);
        this.mProviderSettings.mo41541b(str, url);
        this.mProviderSettings.mo41535a(str, url);
    }

    public void setDebugMode(int debugMode) {
        String str = "debugMode";
        this.mProviderSettings.mo41545c(str, Integer.valueOf(debugMode));
        this.mProviderSettings.mo41541b(str, Integer.valueOf(debugMode));
        this.mProviderSettings.mo41535a(str, Integer.valueOf(debugMode));
    }

    public void setCampaignId(String id) {
        this.mProviderSettings.mo41545c("campaignId", id);
    }

    public void setLanguage(String language) {
        String str = "language";
        this.mProviderSettings.mo41545c(str, language);
        this.mProviderSettings.mo41541b(str, language);
    }

    public void setRewardedVideoCustomParams(Map<String, String> rvCustomParams) {
        this.mRewardedVideoCustomParams = convertCustomParams(rvCustomParams);
    }

    public void setOfferwallCustomParams(Map<String, String> owCustomParams) {
        this.mOfferwallCustomParams = convertCustomParams(owCustomParams);
    }

    private Map<String, String> convertCustomParams(Map<String, String> customParams) {
        Map<String, String> result = new HashMap<>();
        if (customParams != null) {
            try {
                Set<String> keys = customParams.keySet();
                if (keys != null) {
                    for (String k : keys) {
                        if (!TextUtils.isEmpty(k)) {
                            String value = (String) customParams.get(k);
                            if (!TextUtils.isEmpty(value)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("custom_");
                                sb.append(k);
                                result.put(sb.toString(), value);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                C12802d.m41613c().mo41426a(C12801a.NATIVE, ":convertCustomParams()", (Throwable) e);
            }
        }
        return result;
    }

    public boolean getClientSideCallbacks() {
        C12826q qVar = this.mProviderSettings;
        if (qVar == null || qVar.mo41554k() == null) {
            return false;
        }
        String str = "useClientSideCallbacks";
        if (this.mProviderSettings.mo41554k().has(str)) {
            return this.mProviderSettings.mo41554k().optBoolean(str, false);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public Map<String, String> getOfferwallCustomParams() {
        return this.mOfferwallCustomParams;
    }

    /* access modifiers changed from: 0000 */
    public Map<String, String> getRewardedVideoCustomParams() {
        return this.mRewardedVideoCustomParams;
    }
}
