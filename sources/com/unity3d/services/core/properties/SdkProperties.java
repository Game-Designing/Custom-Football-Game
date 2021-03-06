package com.unity3d.services.core.properties;

import android.content.Context;
import com.unity3d.ads.BuildConfig;
import com.unity3d.services.IUnityServicesListener;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class SdkProperties {
    private static final String CACHE_DIR_NAME = "UnityAdsCache";
    private static final String LOCAL_CACHE_FILE_PREFIX = "UnityAdsCache-";
    private static final String LOCAL_STORAGE_FILE_PREFIX = "UnityAdsStorage-";
    private static CacheDirectory _cacheDirectory = null;
    private static String _configUrl = getDefaultConfigUrl("release");
    private static boolean _debugMode = false;
    private static long _initializationTime = 0;
    private static boolean _initialized = false;
    private static IUnityServicesListener _listener;
    private static boolean _reinitialized = false;
    private static boolean _testMode = false;

    public static boolean isInitialized() {
        return _initialized;
    }

    public static void setInitialized(boolean initialized) {
        _initialized = initialized;
    }

    public static boolean isTestMode() {
        return _testMode;
    }

    public static void setTestMode(boolean testMode) {
        _testMode = testMode;
    }

    public static int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getVersionName() {
        return "3.0.1";
    }

    public static String getCacheDirectoryName() {
        return CACHE_DIR_NAME;
    }

    public static String getCacheFilePrefix() {
        return LOCAL_CACHE_FILE_PREFIX;
    }

    public static String getLocalStorageFilePrefix() {
        return LOCAL_STORAGE_FILE_PREFIX;
    }

    public static void setConfigUrl(String url) throws URISyntaxException, MalformedURLException {
        if (url == null) {
            throw new MalformedURLException();
        } else if (url.startsWith("http://") || url.startsWith("https://")) {
            new URL(url).toURI();
            _configUrl = url;
        } else {
            throw new MalformedURLException();
        }
    }

    public static String getConfigUrl() {
        return _configUrl;
    }

    public static String getDefaultConfigUrl(String flavor) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://config.unityads.unity3d.com/webview/");
        sb.append(getWebViewBranch());
        sb.append("/");
        sb.append(flavor);
        sb.append("/config.json");
        return sb.toString();
    }

    private static String getWebViewBranch() {
        return getVersionName();
    }

    public static String getLocalWebViewFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCacheDirectory().getAbsolutePath());
        sb.append("/UnityAdsWebApp.html");
        return sb.toString();
    }

    public static File getCacheDirectory() {
        return getCacheDirectory(ClientProperties.getApplicationContext());
    }

    public static File getCacheDirectory(Context context) {
        if (_cacheDirectory == null) {
            setCacheDirectory(new CacheDirectory(CACHE_DIR_NAME));
        }
        return _cacheDirectory.getCacheDirectory(context);
    }

    public static void setCacheDirectory(CacheDirectory cacheDirectory) {
        _cacheDirectory = cacheDirectory;
    }

    public static CacheDirectory getCacheDirectoryObject() {
        return _cacheDirectory;
    }

    public static void setInitializationTime(long milliseconds) {
        _initializationTime = milliseconds;
    }

    public static long getInitializationTime() {
        return _initializationTime;
    }

    public static void setReinitialized(boolean status) {
        _reinitialized = status;
    }

    public static boolean isReinitialized() {
        return _reinitialized;
    }

    public static void setDebugMode(boolean debugMode) {
        _debugMode = debugMode;
        if (debugMode) {
            DeviceLog.setLogLevel(8);
        } else {
            DeviceLog.setLogLevel(4);
        }
    }

    public static boolean getDebugMode() {
        return _debugMode;
    }

    public static void setListener(IUnityServicesListener listener) {
        _listener = listener;
    }

    public static IUnityServicesListener getListener() {
        return _listener;
    }
}
