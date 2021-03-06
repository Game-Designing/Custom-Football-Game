package com.unity3d.services.core.api;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.util.SparseArray;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.DeviceError;
import com.unity3d.services.core.device.IVolumeChangeListener;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.database.realm.Installed;

public class DeviceInfo {
    private static SparseArray<IVolumeChangeListener> _volumeChangeListeners;

    /* renamed from: com.unity3d.services.core.api.DeviceInfo$2 */
    static /* synthetic */ class C126212 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType = new int[StorageType.values().length];

        static {
            try {
                $SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType[StorageType.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType[StorageType.EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum DeviceInfoEvent {
        VOLUME_CHANGED
    }

    public enum StorageType {
        EXTERNAL,
        INTERNAL
    }

    @WebViewExposed
    public static void getAndroidId(WebViewCallback callback) {
        callback.invoke(Device.getAndroidId());
    }

    @WebViewExposed
    public static void getAdvertisingTrackingId(WebViewCallback callback) {
        callback.invoke(Device.getAdvertisingTrackingId());
    }

    @WebViewExposed
    public static void getLimitAdTrackingFlag(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(Device.isLimitAdTrackingEnabled()));
    }

    @WebViewExposed
    public static void getApiLevel(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getApiLevel()));
    }

    @WebViewExposed
    public static void getOsVersion(WebViewCallback callback) {
        callback.invoke(Device.getOsVersion());
    }

    @WebViewExposed
    public static void getManufacturer(WebViewCallback callback) {
        callback.invoke(Device.getManufacturer());
    }

    @WebViewExposed
    public static void getModel(WebViewCallback callback) {
        callback.invoke(Device.getModel());
    }

    @WebViewExposed
    public static void getScreenLayout(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getScreenLayout()));
    }

    @WebViewExposed
    public static void getScreenDensity(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getScreenDensity()));
    }

    @WebViewExposed
    public static void getScreenWidth(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getScreenWidth()));
    }

    @WebViewExposed
    public static void getScreenHeight(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getScreenHeight()));
    }

    @WebViewExposed
    public static void getTimeZone(Boolean dst, WebViewCallback callback) {
        callback.invoke(TimeZone.getDefault().getDisplayName(dst.booleanValue(), 0, Locale.US));
    }

    @WebViewExposed
    public static void getTimeZoneOffset(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
    }

    @WebViewExposed
    public static void getConnectionType(WebViewCallback callback) {
        String connectionType;
        if (Device.isUsingWifi()) {
            connectionType = "wifi";
        } else if (Device.isActiveNetworkConnected()) {
            connectionType = "cellular";
        } else {
            connectionType = "none";
        }
        callback.invoke(connectionType);
    }

    @WebViewExposed
    public static void getNetworkType(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getNetworkType()));
    }

    @WebViewExposed
    public static void getNetworkMetered(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(Device.getNetworkMetered()));
    }

    @WebViewExposed
    public static void getNetworkOperator(WebViewCallback callback) {
        callback.invoke(Device.getNetworkOperator());
    }

    @WebViewExposed
    public static void getNetworkOperatorName(WebViewCallback callback) {
        callback.invoke(Device.getNetworkOperatorName());
    }

    @WebViewExposed
    public static void isAppInstalled(String pkgname, WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(Device.isAppInstalled(pkgname)));
    }

    @WebViewExposed
    public static void isRooted(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(Device.isRooted()));
    }

    @WebViewExposed
    public static void isAdbEnabled(WebViewCallback callback) {
        Boolean adbEnabled = Device.isAdbEnabled();
        if (adbEnabled != null) {
            callback.invoke(adbEnabled);
            return;
        }
        callback.error(DeviceError.COULDNT_GET_ADB_STATUS, new Object[0]);
    }

    @WebViewExposed
    public static void getInstalledPackages(boolean md5, WebViewCallback callback) {
        callback.invoke(new JSONArray(Device.getInstalledPackages(md5)));
    }

    @WebViewExposed
    public static void getPackageInfo(String packageName, WebViewCallback callback) {
        if (ClientProperties.getApplicationContext() != null) {
            PackageManager pm = ClientProperties.getApplicationContext().getPackageManager();
            try {
                PackageInfo appInfo = pm.getPackageInfo(packageName, 0);
                JSONObject data = new JSONObject();
                try {
                    data.put("installer", pm.getInstallerPackageName(packageName));
                    data.put("firstInstallTime", appInfo.firstInstallTime);
                    data.put("lastUpdateTime", appInfo.lastUpdateTime);
                    data.put("versionCode", appInfo.versionCode);
                    data.put(Installed.VERSION_NAME, appInfo.versionName);
                    data.put("packageName", appInfo.packageName);
                    callback.invoke(data);
                } catch (JSONException e) {
                    callback.error(DeviceError.JSON_ERROR, e.getMessage());
                }
            } catch (NameNotFoundException e2) {
                callback.error(DeviceError.APPLICATION_INFO_NOT_AVAILABLE, packageName);
            }
        } else {
            callback.error(DeviceError.APPLICATION_CONTEXT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getUniqueEventId(WebViewCallback callback) {
        callback.invoke(Device.getUniqueEventId());
    }

    @WebViewExposed
    public static void getHeadset(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(Device.isWiredHeadsetOn()));
    }

    @WebViewExposed
    public static void getSystemProperty(String propertyName, String defaultValue, WebViewCallback callback) {
        callback.invoke(Device.getSystemProperty(propertyName, defaultValue));
    }

    @WebViewExposed
    public static void getRingerMode(WebViewCallback callback) {
        int ringerMode = Device.getRingerMode();
        if (ringerMode > -1) {
            callback.invoke(Integer.valueOf(ringerMode));
        } else if (ringerMode == -2) {
            callback.error(DeviceError.AUDIOMANAGER_NULL, Integer.valueOf(ringerMode));
        } else if (ringerMode != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unhandled ringerMode error: ");
            sb.append(ringerMode);
            DeviceLog.error(sb.toString());
        } else {
            callback.error(DeviceError.APPLICATION_CONTEXT_NULL, Integer.valueOf(ringerMode));
        }
    }

    @WebViewExposed
    public static void getSystemLanguage(WebViewCallback callback) {
        callback.invoke(Locale.getDefault().toString());
    }

    @WebViewExposed
    public static void getDeviceVolume(Integer streamType, WebViewCallback callback) {
        int volume = Device.getStreamVolume(streamType.intValue());
        if (volume > -1) {
            callback.invoke(Integer.valueOf(volume));
        } else if (volume == -2) {
            callback.error(DeviceError.AUDIOMANAGER_NULL, Integer.valueOf(volume));
        } else if (volume != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unhandled deviceVolume error: ");
            sb.append(volume);
            DeviceLog.error(sb.toString());
        } else {
            callback.error(DeviceError.APPLICATION_CONTEXT_NULL, Integer.valueOf(volume));
        }
    }

    @WebViewExposed
    public static void getDeviceMaxVolume(Integer streamType, WebViewCallback callback) {
        int maxVolume = Device.getStreamMaxVolume(streamType.intValue());
        if (maxVolume > -1) {
            callback.invoke(Integer.valueOf(maxVolume));
        } else if (maxVolume == -2) {
            callback.error(DeviceError.AUDIOMANAGER_NULL, Integer.valueOf(maxVolume));
        } else if (maxVolume != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unhandled deviceMaxVolume error: ");
            sb.append(maxVolume);
            DeviceLog.error(sb.toString());
        } else {
            callback.error(DeviceError.APPLICATION_CONTEXT_NULL, Integer.valueOf(maxVolume));
        }
    }

    @WebViewExposed
    public static void registerVolumeChangeListener(final Integer streamType, WebViewCallback callback) {
        if (_volumeChangeListeners == null) {
            _volumeChangeListeners = new SparseArray<>();
        }
        if (_volumeChangeListeners.get(streamType.intValue()) == null) {
            IVolumeChangeListener listener = new IVolumeChangeListener() {
                private int _streamType = streamType.intValue();

                public void onVolumeChanged(int volume) {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.DEVICEINFO, DeviceInfoEvent.VOLUME_CHANGED, Integer.valueOf(getStreamType()), Integer.valueOf(volume), Integer.valueOf(Device.getStreamMaxVolume(this._streamType)));
                }

                public int getStreamType() {
                    return this._streamType;
                }
            };
            _volumeChangeListeners.append(streamType.intValue(), listener);
            VolumeChange.registerListener(listener);
        }
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void unregisterVolumeChangeListener(Integer streamType, WebViewCallback callback) {
        SparseArray<IVolumeChangeListener> sparseArray = _volumeChangeListeners;
        if (!(sparseArray == null || sparseArray.get(streamType.intValue()) == null)) {
            VolumeChange.unregisterListener((IVolumeChangeListener) _volumeChangeListeners.get(streamType.intValue()));
            _volumeChangeListeners.remove(streamType.intValue());
        }
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getScreenBrightness(WebViewCallback callback) {
        int screenBrightness = Device.getScreenBrightness();
        if (screenBrightness > -1) {
            callback.invoke(Integer.valueOf(screenBrightness));
        } else if (screenBrightness != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unhandled screenBrightness error: ");
            sb.append(screenBrightness);
            DeviceLog.error(sb.toString());
        } else {
            callback.error(DeviceError.APPLICATION_CONTEXT_NULL, Integer.valueOf(screenBrightness));
        }
    }

    private static StorageType getStorageTypeFromString(String storageType) {
        try {
            return StorageType.valueOf(storageType);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal argument: ");
            sb.append(storageType);
            DeviceLog.exception(sb.toString(), e);
            return null;
        }
    }

    private static File getFileForStorageType(StorageType storageType) {
        int i = C126212.$SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType[storageType.ordinal()];
        if (i == 1) {
            return ClientProperties.getApplicationContext().getCacheDir();
        }
        if (i == 2) {
            return ClientProperties.getApplicationContext().getExternalCacheDir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unhandled storagetype: ");
        sb.append(storageType);
        DeviceLog.error(sb.toString());
        return null;
    }

    @WebViewExposed
    public static void getFreeSpace(String storageType, WebViewCallback callback) {
        StorageType storage = getStorageTypeFromString(storageType);
        if (storage == null) {
            callback.error(DeviceError.INVALID_STORAGETYPE, storageType);
            return;
        }
        long space = Device.getFreeSpace(getFileForStorageType(storage));
        if (space > -1) {
            callback.invoke(Long.valueOf(space));
        } else {
            callback.error(DeviceError.COULDNT_GET_STORAGE_LOCATION, Long.valueOf(space));
        }
    }

    @WebViewExposed
    public static void getTotalSpace(String storageType, WebViewCallback callback) {
        StorageType storage = getStorageTypeFromString(storageType);
        if (storage == null) {
            callback.error(DeviceError.INVALID_STORAGETYPE, storageType);
            return;
        }
        long space = Device.getTotalSpace(getFileForStorageType(storage));
        if (space > -1) {
            callback.invoke(Long.valueOf(space));
        } else {
            callback.error(DeviceError.COULDNT_GET_STORAGE_LOCATION, Long.valueOf(space));
        }
    }

    @WebViewExposed
    public static void getBatteryLevel(WebViewCallback callback) {
        callback.invoke(Float.valueOf(Device.getBatteryLevel()));
    }

    @WebViewExposed
    public static void getBatteryStatus(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(Device.getBatteryStatus()));
    }

    @WebViewExposed
    public static void getFreeMemory(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getFreeMemory()));
    }

    @WebViewExposed
    public static void getTotalMemory(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getTotalMemory()));
    }

    @WebViewExposed
    public static void getGLVersion(WebViewCallback callback) {
        String glVersion = Device.getGLVersion();
        if (glVersion != null) {
            callback.invoke(glVersion);
            return;
        }
        callback.error(DeviceError.COULDNT_GET_GL_VERSION, new Object[0]);
    }

    @WebViewExposed
    public static void getApkDigest(WebViewCallback callback) {
        try {
            callback.invoke(Device.getApkDigest());
        } catch (Exception e) {
            callback.error(DeviceError.COULDNT_GET_DIGEST, e.toString());
        }
    }

    @WebViewExposed
    public static void getCertificateFingerprint(WebViewCallback callback) {
        String fingerprint = Device.getCertificateFingerprint();
        if (fingerprint != null) {
            callback.invoke(fingerprint);
            return;
        }
        callback.error(DeviceError.COULDNT_GET_FINGERPRINT, new Object[0]);
    }

    @WebViewExposed
    public static void getBoard(WebViewCallback callback) {
        callback.invoke(Device.getBoard());
    }

    @WebViewExposed
    public static void getBootloader(WebViewCallback callback) {
        callback.invoke(Device.getBootloader());
    }

    @WebViewExposed
    public static void getBrand(WebViewCallback callback) {
        callback.invoke(Device.getBrand());
    }

    @WebViewExposed
    public static void getDevice(WebViewCallback callback) {
        callback.invoke(Device.getDevice());
    }

    @WebViewExposed
    public static void getHardware(WebViewCallback callback) {
        callback.invoke(Device.getHardware());
    }

    @WebViewExposed
    public static void getHost(WebViewCallback callback) {
        callback.invoke(Device.getHost());
    }

    @WebViewExposed
    public static void getProduct(WebViewCallback callback) {
        callback.invoke(Device.getProduct());
    }

    @WebViewExposed
    public static void getFingerprint(WebViewCallback callback) {
        callback.invoke(Device.getFingerprint());
    }

    @WebViewExposed
    public static void getSupportedAbis(WebViewCallback callback) {
        JSONArray abis = new JSONArray();
        Iterator it = Device.getSupportedAbis().iterator();
        while (it.hasNext()) {
            abis.put((String) it.next());
        }
        callback.invoke(abis);
    }

    @WebViewExposed
    public static void getSensorList(WebViewCallback callback) {
        JSONArray sensors = new JSONArray();
        List<Sensor> sensorList = Device.getSensorList();
        if (sensorList != null) {
            for (Sensor sensor : sensorList) {
                JSONObject sensorInfo = new JSONObject();
                try {
                    sensorInfo.put("name", sensor.getName());
                    sensorInfo.put("type", sensor.getType());
                    sensorInfo.put(VastExtensionXmlManager.VENDOR, sensor.getVendor());
                    sensorInfo.put("maximumRange", (double) sensor.getMaximumRange());
                    sensorInfo.put("power", (double) sensor.getPower());
                    sensorInfo.put(MediationMetaData.KEY_VERSION, sensor.getVersion());
                    sensorInfo.put("resolution", (double) sensor.getResolution());
                    sensorInfo.put("minDelay", sensor.getMinDelay());
                    sensors.put(sensorInfo);
                } catch (JSONException e) {
                    callback.error(DeviceError.JSON_ERROR, e.getMessage());
                    return;
                }
            }
        }
        callback.invoke(sensors);
    }

    @WebViewExposed
    public static void getProcessInfo(WebViewCallback callback) {
        String str = "uptime";
        String str2 = "stat";
        JSONObject retObj = new JSONObject();
        Map<String, String> processInfo = Device.getProcessInfo();
        if (processInfo != null) {
            try {
                if (processInfo.containsKey(str2)) {
                    retObj.put(str2, processInfo.get(str2));
                }
                if (processInfo.containsKey(str)) {
                    retObj.put(str, processInfo.get(str));
                }
            } catch (Exception e) {
                DeviceLog.exception("Error while constructing process info", e);
            }
        }
        callback.invoke(retObj);
    }

    @WebViewExposed
    public static void isUSBConnected(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(Device.isUSBConnected()));
    }

    @WebViewExposed
    public static void getCPUCount(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getCPUCount()));
    }

    @WebViewExposed
    public static void getUptime(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getUptime()));
    }

    @WebViewExposed
    public static void getElapsedRealtime(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getElapsedRealtime()));
    }

    @WebViewExposed
    public static void getBuildId(WebViewCallback callback) {
        callback.invoke(Device.getBuildId());
    }

    @WebViewExposed
    public static void getBuildVersionIncremental(WebViewCallback callback) {
        callback.invoke(Device.getBuildVersionIncremental());
    }
}
