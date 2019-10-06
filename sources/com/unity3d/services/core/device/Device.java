package com.unity3d.services.core.device;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Device {

    /* renamed from: com.unity3d.services.core.device.Device$1 */
    static /* synthetic */ class C126311 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType */
        static final /* synthetic */ int[] f39023x950c1f09 = new int[MemoryInfoType.values().length];

        static {
            try {
                f39023x950c1f09[MemoryInfoType.TOTAL_MEMORY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f39023x950c1f09[MemoryInfoType.FREE_MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum MemoryInfoType {
        TOTAL_MEMORY,
        FREE_MEMORY
    }

    public static int getApiLevel() {
        return VERSION.SDK_INT;
    }

    public static String getOsVersion() {
        return VERSION.RELEASE;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static int getScreenLayout() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getConfiguration().screenLayout;
        }
        return -1;
    }

    @SuppressLint({"DefaultLocale"})
    public static String getAndroidId() {
        try {
            return Secure.getString(ClientProperties.getApplicationContext().getContentResolver(), "android_id");
        } catch (Exception e) {
            DeviceLog.exception("Problems fetching androidId", e);
            return null;
        }
    }

    public static String getAdvertisingTrackingId() {
        return AdvertisingId.getAdvertisingTrackingId();
    }

    public static boolean isLimitAdTrackingEnabled() {
        return AdvertisingId.getLimitedAdTracking();
    }

    public static boolean isUsingWifi() {
        boolean z = false;
        if (ClientProperties.getApplicationContext() == null) {
            return false;
        }
        ConnectivityManager mConnectivity = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
        if (mConnectivity == null) {
            return false;
        }
        TelephonyManager mTelephony = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        NetworkInfo info = mConnectivity.getActiveNetworkInfo();
        if (info == null || !mConnectivity.getBackgroundDataSetting() || !mConnectivity.getActiveNetworkInfo().isConnected() || mTelephony == null) {
            return false;
        }
        if (info.getType() == 1 && info.isConnected()) {
            z = true;
        }
        return z;
    }

    public static int getNetworkType() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
        }
        return -1;
    }

    public static boolean getNetworkMetered() {
        if (ClientProperties.getApplicationContext() == null || VERSION.SDK_INT < 16) {
            return false;
        }
        ConnectivityManager mConnectivity = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
        if (mConnectivity == null) {
            return false;
        }
        return mConnectivity.isActiveNetworkMetered();
    }

    public static String getNetworkOperator() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkOperator();
        }
        return "";
    }

    public static String getNetworkOperatorName() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkOperatorName();
        }
        return "";
    }

    public static int getScreenDensity() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return -1;
    }

    public static int getScreenWidth() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        }
        return -1;
    }

    public static int getScreenHeight() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        }
        return -1;
    }

    public static boolean isActiveNetworkConnected() {
        boolean z = false;
        if (ClientProperties.getApplicationContext() != null) {
            ConnectivityManager cm = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null && activeNetwork.isConnected()) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public static boolean isAppInstalled(String pkgname) {
        if (ClientProperties.getApplicationContext() != null) {
            try {
                PackageInfo pkgInfo = ClientProperties.getApplicationContext().getPackageManager().getPackageInfo(pkgname, 0);
                if (!(pkgInfo == null || pkgInfo.packageName == null || !pkgname.equals(pkgInfo.packageName))) {
                    return true;
                }
            } catch (NameNotFoundException e) {
                return false;
            }
        }
        return false;
    }

    public static List<Map<String, Object>> getInstalledPackages(boolean hash) {
        List<Map<String, Object>> returnList = new ArrayList<>();
        if (ClientProperties.getApplicationContext() != null) {
            PackageManager pm = ClientProperties.getApplicationContext().getPackageManager();
            for (PackageInfo pkg : pm.getInstalledPackages(0)) {
                HashMap<String, Object> packageEntry = new HashMap<>();
                String str = "name";
                if (hash) {
                    packageEntry.put(str, Utilities.Sha256(pkg.packageName));
                } else {
                    packageEntry.put(str, pkg.packageName);
                }
                long j = pkg.firstInstallTime;
                if (j > 0) {
                    packageEntry.put("time", Long.valueOf(j));
                }
                String installer = pm.getInstallerPackageName(pkg.packageName);
                if (installer != null && !installer.isEmpty()) {
                    packageEntry.put("installer", installer);
                }
                returnList.add(packageEntry);
            }
        }
        return returnList;
    }

    public static String getUniqueEventId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isWiredHeadsetOn() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((AudioManager) ClientProperties.getApplicationContext().getSystemService("audio")).isWiredHeadsetOn();
        }
        return false;
    }

    public static String getSystemProperty(String propertyName, String defaultValue) {
        if (defaultValue != null) {
            return System.getProperty(propertyName, defaultValue);
        }
        return System.getProperty(propertyName);
    }

    public static int getRingerMode() {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager am = (AudioManager) ClientProperties.getApplicationContext().getSystemService("audio");
        if (am != null) {
            return am.getRingerMode();
        }
        return -2;
    }

    public static int getStreamVolume(int streamType) {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager am = (AudioManager) ClientProperties.getApplicationContext().getSystemService("audio");
        if (am != null) {
            return am.getStreamVolume(streamType);
        }
        return -2;
    }

    public static int getStreamMaxVolume(int streamType) {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager am = (AudioManager) ClientProperties.getApplicationContext().getSystemService("audio");
        if (am != null) {
            return am.getStreamMaxVolume(streamType);
        }
        return -2;
    }

    public static int getScreenBrightness() {
        if (ClientProperties.getApplicationContext() != null) {
            return System.getInt(ClientProperties.getApplicationContext().getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    public static long getFreeSpace(File file) {
        if (file == null || !file.exists()) {
            return -1;
        }
        return (long) Math.round((float) (file.getFreeSpace() / 1024));
    }

    public static long getTotalSpace(File file) {
        if (file == null || !file.exists()) {
            return -1;
        }
        return (long) Math.round((float) (file.getTotalSpace() / 1024));
    }

    public static float getBatteryLevel() {
        if (ClientProperties.getApplicationContext() != null) {
            Intent i = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (i != null) {
                return ((float) i.getIntExtra("level", -1)) / ((float) i.getIntExtra("scale", -1));
            }
        }
        return -1.0f;
    }

    public static int getBatteryStatus() {
        if (ClientProperties.getApplicationContext() != null) {
            Intent i = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (i != null) {
                return i.getIntExtra("status", -1);
            }
        }
        return -1;
    }

    public static long getTotalMemory() {
        return getMemoryInfo(MemoryInfoType.TOTAL_MEMORY);
    }

    public static long getFreeMemory() {
        return getMemoryInfo(MemoryInfoType.FREE_MEMORY);
    }

    private static long getMemoryInfo(MemoryInfoType infoType) {
        String str = "Error closing RandomAccessFile";
        int lineNumber = -1;
        int i = C126311.f39023x950c1f09[infoType.ordinal()];
        if (i == 1) {
            lineNumber = 1;
        } else if (i == 2) {
            lineNumber = 2;
        }
        RandomAccessFile reader = null;
        String line = null;
        try {
            reader = new RandomAccessFile("/proc/meminfo", "r");
            for (int i2 = 0; i2 < lineNumber; i2++) {
                line = reader.readLine();
            }
            long memoryValueFromString = getMemoryValueFromString(line);
            try {
            } catch (IOException e) {
                DeviceLog.exception(str, e);
            }
            return memoryValueFromString;
        } catch (IOException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error while reading memory info: ");
            sb.append(infoType);
            DeviceLog.exception(sb.toString(), e2);
            try {
            } catch (IOException e3) {
                DeviceLog.exception(str, e3);
            }
            return -1;
        } finally {
            try {
                reader.close();
            } catch (IOException e4) {
                DeviceLog.exception(str, e4);
            }
        }
    }

    private static long getMemoryValueFromString(String memVal) {
        if (memVal == null) {
            return -1;
        }
        Matcher m = Pattern.compile("(\\d+)").matcher(memVal);
        String value = "";
        while (m.find()) {
            value = m.group(1);
        }
        return Long.parseLong(value);
    }

    public static boolean isRooted() {
        try {
            return searchPathForBinary("su");
        } catch (Exception e) {
            DeviceLog.exception("Rooted check failed", e);
            return false;
        }
    }

    public static Boolean isAdbEnabled() {
        if (getApiLevel() < 17) {
            return oldAdbStatus();
        }
        return newAdbStatus();
    }

    private static Boolean oldAdbStatus() {
        try {
            boolean z = true;
            if (1 != Secure.getInt(ClientProperties.getApplicationContext().getContentResolver(), "adb_enabled", 0)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            DeviceLog.exception("Problems fetching adb enabled status", e);
            return null;
        }
    }

    @TargetApi(17)
    private static Boolean newAdbStatus() {
        try {
            boolean z = true;
            if (1 != Global.getInt(ClientProperties.getApplicationContext().getContentResolver(), "adb_enabled", 0)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            DeviceLog.exception("Problems fetching adb enabled status", e);
            return null;
        }
    }

    private static boolean searchPathForBinary(String binary) {
        for (String path : System.getenv("PATH").split(":")) {
            File pathDir = new File(path);
            if (pathDir.exists() && pathDir.isDirectory()) {
                File[] pathDirFiles = pathDir.listFiles();
                if (pathDirFiles != null) {
                    for (File fileInPath : pathDirFiles) {
                        if (fileInPath.getName().equals(binary)) {
                            return true;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public static String getGLVersion() {
        if (ClientProperties.getApplicationContext() != null) {
            ActivityManager activityManager = (ActivityManager) ClientProperties.getApplicationContext().getSystemService("activity");
            if (activityManager != null) {
                ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
                if (configurationInfo != null) {
                    return configurationInfo.getGlEsVersion();
                }
            }
        }
        return null;
    }

    public static String getApkDigest() throws Exception {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(ClientProperties.getApplicationContext().getPackageCodePath()));
            String apkDigest = Utilities.Sha256((InputStream) fileInputStream2);
            try {
                fileInputStream2.close();
            } catch (IOException e) {
            }
            return apkDigest;
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    public static String getCertificateFingerprint() {
        try {
            Signature[] signatures = ClientProperties.getApplicationContext().getPackageManager().getPackageInfo(ClientProperties.getApplicationContext().getPackageName(), 64).signatures;
            if (signatures == null || signatures.length < 1) {
                return null;
            }
            return Utilities.toHexString(MessageDigest.getInstance("SHA-1").digest(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception e) {
            DeviceLog.exception("Exception when signing certificate fingerprint", e);
            return null;
        }
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getHardware() {
        return Build.HARDWARE;
    }

    public static String getHost() {
        return Build.HOST;
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static ArrayList<String> getSupportedAbis() {
        if (getApiLevel() < 21) {
            return getOldAbiList();
        }
        return getNewAbiList();
    }

    public static List<Sensor> getSensorList() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((SensorManager) ClientProperties.getApplicationContext().getSystemService("sensor")).getSensorList(-1);
        }
        return null;
    }

    public static boolean isUSBConnected() {
        if (ClientProperties.getApplicationContext() != null) {
            Intent intent = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"));
            if (intent != null) {
                return intent.getBooleanExtra("connected", false);
            }
        }
        return false;
    }

    public static long getCPUCount() {
        return (long) Runtime.getRuntime().availableProcessors();
    }

    public static long getUptime() {
        return SystemClock.uptimeMillis();
    }

    public static long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public static String getBuildId() {
        return Build.ID;
    }

    public static String getBuildVersionIncremental() {
        return VERSION.INCREMENTAL;
    }

    private static ArrayList<String> getOldAbiList() {
        ArrayList<String> abiList = new ArrayList<>();
        abiList.add(Build.CPU_ABI);
        abiList.add(Build.CPU_ABI2);
        return abiList;
    }

    @TargetApi(21)
    private static ArrayList<String> getNewAbiList() {
        ArrayList<String> abiList = new ArrayList<>();
        abiList.addAll(Arrays.asList(Build.SUPPORTED_ABIS));
        return abiList;
    }

    public static Map<String, String> getProcessInfo() {
        String str = "Error closing RandomAccessFile";
        HashMap<String, String> retData = new HashMap<>();
        RandomAccessFile reader = null;
        try {
            reader = new RandomAccessFile("/proc/self/stat", "r");
            retData.put("stat", reader.readLine());
            try {
            } catch (IOException e) {
                DeviceLog.exception(str, e);
            }
        } catch (IOException e2) {
            DeviceLog.exception("Error while reading processor info: ", e2);
        } finally {
            try {
                reader.close();
            } catch (IOException e3) {
                DeviceLog.exception(str, e3);
            }
        }
        return retData;
    }
}
