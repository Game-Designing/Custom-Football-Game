package com.unity3d.services.core.configuration;

import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.NetworkIOException;
import com.unity3d.services.core.request.WebRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

public class Configuration {
    private String[] _moduleConfigurationList = {"com.unity3d.services.core.configuration.CoreModuleConfiguration", "com.unity3d.services.ads.configuration.AdsModuleConfiguration", "com.unity3d.services.monetization.core.configuration.MonetizationModuleConfiguration", "com.unity3d.services.purchasing.core.configuration.PurchasingModuleConfiguration", "com.unity3d.services.analytics.core.configuration.AnalyticsModuleConfiguration", "com.unity3d.services.ar.configuration.ARModuleConfiguration", "com.unity3d.services.banners.configuration.BannersModuleConfiguration"};
    private Map<String, IModuleConfiguration> _moduleConfigurations;
    private String _url;
    private Class[] _webAppApiClassList;
    private String _webViewData;
    private String _webViewHash;
    private String _webViewUrl;
    private String _webViewVersion;

    public Configuration() {
    }

    public Configuration(String configUrl) {
        this._url = configUrl;
    }

    public void setConfigUrl(String url) {
        this._url = url;
    }

    public String getConfigUrl() {
        return this._url;
    }

    public Class[] getWebAppApiClassList() {
        if (this._webAppApiClassList == null) {
            createWebAppApiClassList();
        }
        return this._webAppApiClassList;
    }

    public String[] getModuleConfigurationList() {
        return this._moduleConfigurationList;
    }

    public String getWebViewUrl() {
        return this._webViewUrl;
    }

    public void setWebViewUrl(String url) {
        this._webViewUrl = url;
    }

    public String getWebViewHash() {
        return this._webViewHash;
    }

    public void setWebViewHash(String hash) {
        this._webViewHash = hash;
    }

    public String getWebViewVersion() {
        return this._webViewVersion;
    }

    public String getWebViewData() {
        return this._webViewData;
    }

    public void setWebViewData(String data) {
        this._webViewData = data;
    }

    public IModuleConfiguration getModuleConfiguration(String moduleName) {
        Map<String, IModuleConfiguration> map = this._moduleConfigurations;
        if (map != null && map.containsKey(moduleName)) {
            return (IModuleConfiguration) this._moduleConfigurations.get(moduleName);
        }
        try {
            IModuleConfiguration module = (IModuleConfiguration) Class.forName(moduleName).newInstance();
            if (module == null) {
                return null;
            }
            if (this._moduleConfigurations == null) {
                this._moduleConfigurations = new HashMap();
                this._moduleConfigurations.put(moduleName, module);
            }
            return module;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String buildQueryString() {
        StringBuilder sb = new StringBuilder();
        sb.append("?ts=");
        sb.append(System.currentTimeMillis());
        sb.append("&sdkVersion=");
        sb.append(SdkProperties.getVersionCode());
        sb.append("&sdkVersionName=");
        sb.append(SdkProperties.getVersionName());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void makeRequest() throws IOException, JSONException, IllegalStateException, NetworkIOException, IllegalArgumentException {
        if (this._url != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this._url);
            sb.append(buildQueryString());
            String url = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Requesting configuration with: ");
            sb2.append(url);
            DeviceLog.debug(sb2.toString());
            JSONObject config = new JSONObject(new WebRequest(url, "GET", null).makeRequest());
            this._webViewUrl = config.getString("url");
            String str = Repo.COLUMN_HASH;
            if (!config.isNull(str)) {
                this._webViewHash = config.getString(str);
            }
            String str2 = MediationMetaData.KEY_VERSION;
            if (config.has(str2)) {
                this._webViewVersion = config.getString(str2);
            }
            String str3 = this._webViewUrl;
            if (str3 == null || str3.isEmpty()) {
                throw new MalformedURLException("Invalid data. Web view URL is null or empty");
            }
            return;
        }
        throw new MalformedURLException("Base URL is null");
    }

    private void createWebAppApiClassList() {
        List<Class> apiList = new ArrayList<>();
        for (String moduleConfigClass : getModuleConfigurationList()) {
            IModuleConfiguration moduleConfiguration = getModuleConfiguration(moduleConfigClass);
            if (!(moduleConfiguration == null || moduleConfiguration.getWebAppApiClassList() == null)) {
                apiList.addAll(Arrays.asList(moduleConfiguration.getWebAppApiClassList()));
            }
        }
        this._webAppApiClassList = (Class[]) apiList.toArray(new Class[apiList.size()]);
    }
}
