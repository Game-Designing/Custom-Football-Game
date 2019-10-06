package p005cm.aptoide.p006pt.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UnknownFormatConversionException;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.permissions.ApkPermission;
import p024io.realm.internal.Collection;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.utils.AptoideUtils */
public class AptoideUtils {

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$AlgorithmU */
    public static class AlgorithmU {
        private static final String TAG = AlgorithmU.class.getName();

        public static String computeSha1(String text) {
            try {
                return convToHex(computeSha1(text.getBytes("iso-8859-1")));
            } catch (UnsupportedEncodingException e) {
                Logger.getInstance().mo2141e(TAG, "computeSha1(String)", e);
                return "";
            }
        }

        private static String convToHex(byte[] data) {
            StringBuilder buffer = new StringBuilder();
            for (byte b : data) {
                buffer.append(Integer.toString((b & 255) + Collection.MODE_EMPTY, 16).substring(1));
            }
            return buffer.toString();
        }

        private static byte[] computeSha1(byte[] bytes) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(bytes, 0, bytes.length);
                return md.digest();
            } catch (NoSuchAlgorithmException e) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e);
                return new byte[0];
            }
        }

        public static String computeHmacSha1(String value, String keyString) {
            String str = "HmacSHA1";
            String str2 = "UTF-8";
            try {
                SecretKeySpec key = new SecretKeySpec(keyString.getBytes(str2), str);
                Mac mac = Mac.getInstance(str);
                mac.init(key);
                return convToHex(mac.doFinal(value.getBytes(str2)));
            } catch (NoSuchAlgorithmException e) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e);
                return "";
            } catch (UnsupportedEncodingException e2) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e2);
                return "";
            } catch (InvalidKeyException e3) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e3);
                return "";
            }
        }

        public static String computeSha1WithColon(byte[] bytes) {
            return convToHexWithColon(computeSha1(bytes)).toUpperCase(Locale.ENGLISH);
        }

        private static String convToHexWithColon(byte[] data) {
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                int halfbyte = (data[i] >>> 4) & 15;
                int two_halfs = 0;
                while (true) {
                    if (halfbyte < 0 || halfbyte > 9) {
                        buf.append((char) ((halfbyte - 10) + 97));
                    } else {
                        buf.append((char) (halfbyte + 48));
                    }
                    halfbyte = data[i] & 15;
                    int two_halfs2 = two_halfs + 1;
                    if (two_halfs >= 1) {
                        break;
                    }
                    two_halfs = two_halfs2;
                }
                if (i < data.length - 1) {
                    buf.append(":");
                }
            }
            return buf.toString();
        }

        public static String computeMd5(PackageInfo packageInfo) {
            return computeMd5(new File(packageInfo.applicationInfo.sourceDir));
        }

        public static String computeMd5(File f) {
            long time = System.currentTimeMillis();
            byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream = new FileInputStream(f);
                while (true) {
                    int read = fileInputStream.read(buffer);
                    int read2 = read;
                    if (read <= 0) {
                        break;
                    }
                    digest.update(buffer, 0, read2);
                }
                String md5hash = new BigInteger(1, digest.digest()).toString(16);
                fileInputStream.close();
                if (md5hash.length() != 33) {
                    String tmp = "";
                    for (int i = 1; i < 33 - md5hash.length(); i++) {
                        tmp = tmp.concat(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                    }
                    md5hash = tmp.concat(md5hash);
                }
                Logger instance = Logger.getInstance();
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("computeMd5: duration: ");
                sb.append(System.currentTimeMillis() - time);
                sb.append(" ms");
                instance.mo2146v(str, sb.toString());
                return md5hash;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Deprecated
        public static int randomBetween(int min, int max) {
            int skewedMax = max - min;
            if (skewedMax > 0) {
                return new Random().nextInt(skewedMax + 1) + min;
            }
            throw new IllegalStateException("Minimum < maximum");
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$StringU */
    public static final class StringU {
        public static String join(Iterable<?> iterable, String separator) {
            if (iterable == null) {
                return null;
            }
            return join(iterable.iterator(), separator);
        }

        public static String join(Iterator<?> iterator, String separator) {
            if (iterator == null) {
                return null;
            }
            if (!iterator.hasNext()) {
                return "";
            }
            Object first = iterator.next();
            if (!iterator.hasNext()) {
                return toString(first);
            }
            StringBuilder buf = new StringBuilder(Opcodes.ACC_NATIVE);
            if (first != null) {
                buf.append(first);
            }
            while (iterator.hasNext()) {
                if (separator != null) {
                    buf.append(separator);
                }
                Object obj = iterator.next();
                if (obj != null) {
                    buf.append(obj);
                }
            }
            return buf.toString();
        }

        public static String toString(Object obj) {
            return obj == null ? "" : obj.toString();
        }

        public static String withSuffix(long count) {
            if (count < 1000) {
                return String.valueOf(count);
            }
            int exp = (int) (Math.log((double) count) / Math.log(1000.0d));
            Locale locale = Locale.ENGLISH;
            double d = (double) count;
            double pow = Math.pow(1000.0d, (double) exp);
            Double.isNaN(d);
            return String.format(locale, "%d %c", new Object[]{Integer.valueOf((int) (d / pow)), Character.valueOf("kMBTPE".charAt(exp - 1))});
        }

        public static String formatBytesToBits(long bytes, boolean speed) {
            String str;
            long bytes2 = bytes * 8;
            if (bytes2 < ((long) Opcodes.ACC_ABSTRACT)) {
                StringBuilder sb = new StringBuilder();
                sb.append(bytes2);
                sb.append(" B");
                return sb.toString();
            }
            int exp = (int) (Math.log((double) bytes2) / Math.log((double) Opcodes.ACC_ABSTRACT));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KMGTPE".charAt(exp - 1));
            sb2.append("");
            String pre = sb2.toString();
            Locale locale = Locale.ENGLISH;
            double d = (double) bytes2;
            double pow = Math.pow((double) Opcodes.ACC_ABSTRACT, (double) exp);
            Double.isNaN(d);
            String string = String.format(locale, "%.1f %sb", new Object[]{Double.valueOf(d / pow), pre});
            if (speed) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append("ps");
                str = sb3.toString();
            } else {
                str = string;
            }
            return str;
        }

        public static String formatBytes(long bytes, boolean speed) {
            String str;
            if (bytes < ((long) Opcodes.ACC_ABSTRACT)) {
                StringBuilder sb = new StringBuilder();
                sb.append(bytes);
                sb.append(" B");
                return sb.toString();
            }
            int exp = (int) (Math.log((double) bytes) / Math.log((double) Opcodes.ACC_ABSTRACT));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KMGTPE".charAt(exp - 1));
            sb2.append("");
            String pre = sb2.toString();
            Locale locale = Locale.ENGLISH;
            double d = (double) bytes;
            double pow = Math.pow((double) Opcodes.ACC_ABSTRACT, (double) exp);
            Double.isNaN(d);
            String string = String.format(locale, "%.1f %sB", new Object[]{Double.valueOf(d / pow), pre});
            if (speed) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append("/s");
                str = sb3.toString();
            } else {
                str = string;
            }
            return str;
        }

        public static String getResString(int stringResId, Resources resources) {
            return resources.getString(stringResId);
        }

        public static String getFormattedString(int resId, Resources resources, Object... formatArgs) {
            try {
                return resources.getString(resId, formatArgs);
            } catch (UnknownFormatConversionException e) {
                String resourceEntryName = resources.getResourceEntryName(resId);
                String displayLanguage = Locale.getDefault().getDisplayLanguage();
                Logger instance = Logger.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("String: ");
                sb.append(resourceEntryName);
                sb.append(" Locale: ");
                sb.append(displayLanguage);
                instance.mo2140e("UnknownFormatConversion", sb.toString());
                return ResourseU.getString(resId, resources);
            }
        }

        public static String commaSeparatedValues(List<?> list) {
            String s = "";
            if (list.size() > 0) {
                s = list.get(0).toString();
                for (int i = 1; i < list.size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s);
                    sb.append(",");
                    sb.append(list.get(i).toString());
                    s = sb.toString();
                }
            }
            return s;
        }

        public static Map<String, String> splitQuery(URI uri) throws UnsupportedEncodingException {
            Map<String, String> query_pairs = new LinkedHashMap<>();
            String query = uri.getQuery();
            if (query != null) {
                String[] pairs = query.split("&");
                if (pairs != null) {
                    for (String pair : pairs) {
                        int idx = pair.indexOf("=");
                        if (idx > 0 && idx + 1 < pair.length()) {
                            String str = "UTF-8";
                            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), str), URLDecoder.decode(pair.substring(idx + 1), str));
                        }
                    }
                }
            }
            return query_pairs;
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$SystemU */
    public static class SystemU {
        private static final String TAG = "SystemU";
        public static final String TERMINAL_INFO;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(getModel());
            sb.append("(");
            sb.append(getProduct());
            sb.append(");v");
            sb.append(getRelease());
            sb.append(";");
            sb.append(System.getProperty("os.arch"));
            TERMINAL_INFO = sb.toString();
        }

        public static String getProduct() {
            return Build.PRODUCT.replace(";", " ");
        }

        public static String getModel() {
            return Build.MODEL.replaceAll(";", " ");
        }

        public static String getRelease() {
            return VERSION.RELEASE.replaceAll(";", " ");
        }

        public static String getGlEsVer(ActivityManager activityManager) {
            return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
        }

        @TargetApi(21)
        public static String getAbis() {
            String[] abis = getSdkVer() >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < abis.length; i++) {
                builder.append(abis[i]);
                if (i < abis.length - 1) {
                    builder.append(",");
                }
            }
            return builder.toString();
        }

        public static int getSdkVer() {
            return VERSION.SDK_INT;
        }

        public static String getCountryCode(Resources resources) {
            StringBuilder sb = new StringBuilder();
            sb.append(resources.getConfiguration().locale.getLanguage());
            sb.append("_");
            sb.append(resources.getConfiguration().locale.getCountry());
            return sb.toString();
        }

        public static PackageInfo getPackageInfo(String packageName, PackageManager packageManager) {
            try {
                return packageManager.getPackageInfo(packageName, 64);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Deprecated
        public static List<PackageInfo> getUserInstalledApps(PackageManager packageManager) {
            List<PackageInfo> tmp = new LinkedList<>();
            for (PackageInfo packageInfo : getAllInstalledApps(packageManager)) {
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    tmp.add(packageInfo);
                }
            }
            return tmp;
        }

        public static List<PackageInfo> getAllInstalledApps(PackageManager packageManager) {
            return packageManager.getInstalledPackages(64);
        }

        public static String getApkLabel(PackageInfo packageInfo, PackageManager packageManager) {
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        }

        public static String getApkIconPath(PackageInfo packageInfo) {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(packageInfo.packageName);
            sb.append("/");
            sb.append(packageInfo.applicationInfo.icon);
            return sb.toString();
        }

        public static void openApp(String packageName, PackageManager packageManager, Context context) {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage != null) {
                context.startActivity(launchIntentForPackage);
            }
        }

        public static String getConnectionType(ConnectivityManager connectivityManager) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (!(info == null || info.getTypeName() == null)) {
                int type = info.getType();
                if (type == 0) {
                    return "mobile";
                }
                if (type == 1) {
                    return "wifi";
                }
                if (type == 9) {
                    return "ethernet";
                }
            }
            return "unknown";
        }

        public static String getCarrierName(TelephonyManager telephonyManager) {
            return telephonyManager.getNetworkOperatorName();
        }

        public static File readLogs(String mPath, String fileName, String extraLog) {
            try {
                Process process = Runtime.getRuntime().exec("logcat -d");
                FileUtils.createDir(mPath);
                File logsFile = new File(mPath, fileName);
                StringBuilder log = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                sb.append("Android Build Version: ");
                sb.append(VERSION.SDK_INT);
                String str = "\n";
                sb.append(str);
                log.append(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Build Model: ");
                sb2.append(Build.MODEL);
                sb2.append(str);
                log.append(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Device: ");
                sb3.append(Build.DEVICE);
                sb3.append(str);
                log.append(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Brand: ");
                sb4.append(Build.BRAND);
                sb4.append(str);
                log.append(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CPU: ");
                sb5.append(Build.CPU_ABI);
                sb5.append(str);
                log.append(sb5.toString());
                if (extraLog != null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Extra: ");
                    sb6.append(extraLog);
                    sb6.append(str);
                    log.append(sb6.toString());
                }
                log.append("\nLogs:\n");
                try {
                    FileOutputStream outputStream = new FileOutputStream(logsFile);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    for (int linecount = 0; linecount < 100; linecount++) {
                        String readLine = bufferedReader.readLine();
                        String line = readLine;
                        if (readLine == null) {
                            break;
                        }
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(line);
                        sb7.append(str);
                        log.append(sb7.toString());
                    }
                    outputStream.write(log.toString().getBytes());
                    return logsFile;
                } catch (IOException e) {
                    Logger.getInstance().mo2142e(TAG, (Throwable) e);
                    return logsFile;
                }
            } catch (IOException e2) {
                Logger instance = Logger.getInstance();
                StringBuilder sb8 = new StringBuilder();
                sb8.append("IOException: ");
                sb8.append(e2.getMessage());
                instance.mo2140e("FeedBackActivity-readLogs", sb8.toString());
                return null;
            }
        }

        public static List<ApkPermission> parsePermissions(Context context, List<String> permissionArray) {
            List<ApkPermission> list = new ArrayList<>();
            PackageManager pm = context.getPackageManager();
            List<PermissionGroupInfo> lstGroups = pm.getAllPermissionGroups(0);
            for (String permission : permissionArray) {
                for (PermissionGroupInfo pgi : lstGroups) {
                    try {
                        for (PermissionInfo pi : pm.queryPermissionsByGroup(pgi.name, 0)) {
                            if (pi.name.equals(permission)) {
                                list.add(new ApkPermission(pgi.loadLabel(pm).toString(), pi.loadLabel(pm).toString()));
                            }
                        }
                    } catch (Exception e) {
                        Logger.getInstance().mo2142e(TAG, (Throwable) e);
                        throw new RuntimeException(e);
                    }
                }
            }
            Collections.sort(list, C5184b.f8945a);
            return list;
        }

        @Deprecated
        public static void hideKeyboard(Activity activity) {
            View view = activity.getCurrentFocus();
            if (view != null) {
                ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        }

        public static void clearApplicationData(Context context) {
            String[] children;
            File appDir = new File(context.getCacheDir().getParent());
            if (appDir.exists()) {
                for (String s : appDir.list()) {
                    if (!s.equals("lib")) {
                        deleteDir(new File(appDir, s));
                    }
                }
            }
        }

        public static boolean deleteDir(File dir) {
            boolean z = false;
            if (dir != null && dir.isDirectory()) {
                String[] children = dir.list();
                if (children != null) {
                    for (String child : children) {
                        if (!deleteDir(new File(dir, child))) {
                            return false;
                        }
                    }
                }
            }
            if (dir != null && dir.delete()) {
                z = true;
            }
            return z;
        }

        @Deprecated
        public static boolean hasRoot() {
            boolean exitSu;
            boolean retval;
            String str = "ROOT";
            try {
                Process suProcess = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());
                DataInputStream osRes = new DataInputStream(suProcess.getInputStream());
                os.writeBytes("id\n");
                os.flush();
                String currUid = osRes.readLine();
                if (currUid == null) {
                    retval = false;
                    exitSu = false;
                    Logger.getInstance().mo2136d(str, "Can't get root access or denied by user");
                } else if (currUid.contains("uid=0")) {
                    retval = true;
                    exitSu = true;
                    Logger.getInstance().mo2136d(str, "Root access granted");
                } else {
                    retval = false;
                    exitSu = true;
                    Logger instance = Logger.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Root access rejected: ");
                    sb.append(currUid);
                    instance.mo2136d(str, sb.toString());
                }
                if (!exitSu) {
                    return retval;
                }
                os.writeBytes("exit\n");
                os.flush();
                return retval;
            } catch (Exception e) {
                Logger instance2 = Logger.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Root access rejected [");
                sb2.append(e.getClass().getName());
                sb2.append("] : ");
                sb2.append(e.getMessage());
                instance2.mo2136d(str, sb2.toString());
                return false;
            }
        }
    }

    @Deprecated
    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$Benchmarking */
    public static class Benchmarking {
        private static final String TAG = Benchmarking.class.getSimpleName();
        private String methodName;
        private long startTime;

        public static Benchmarking start(String methodName2) {
            Benchmarking benchmarking = new Benchmarking();
            benchmarking.methodName = methodName2;
            benchmarking.startTime = System.currentTimeMillis();
            return benchmarking;
        }

        public void end() {
            long endTime = System.currentTimeMillis();
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Thread: ");
            sb.append(Thread.currentThread().getId());
            sb.append(" Method:");
            sb.append(this.methodName);
            sb.append(" - Total execution time: ");
            sb.append(endTime - this.startTime);
            sb.append("ms");
            instance.mo2136d(str, sb.toString());
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$Core */
    public static class Core {
        private static final String TAG = "Core";

        public static String getDefaultVername(Context context) {
            String verString = "";
            try {
                verString = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("aptoide-");
            sb.append(verString);
            return sb.toString();
        }

        public static int getVerCode(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (NameNotFoundException e) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e);
                return -1;
            }
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$DateTimeU */
    public static class DateTimeU extends DateUtils {
        private static DateTimeU instance = null;
        private static String mTimestampLabelDaysAgo = null;
        private static String mTimestampLabelHourAgo = null;
        private static String mTimestampLabelHoursAgo = null;
        private static String mTimestampLabelJustNow = null;
        private static String mTimestampLabelMinutesAgo = null;
        private static String mTimestampLabelMonthAgo = null;
        private static String mTimestampLabelMonthsAgo = null;
        private static String mTimestampLabelToday = null;
        private static String mTimestampLabelWeekAgo = null;
        private static String mTimestampLabelWeeksAgo = null;
        private static String mTimestampLabelYearAgo = null;
        private static String mTimestampLabelYearsAgo = null;
        private static String mTimestampLabelYesterday = null;
        private static final long millisInADay = 86400000;
        private static String[] weekdays = new DateFormatSymbols().getWeekdays();
        private final Context context;

        private DateTimeU(Context context2) {
            this.context = context2;
        }

        public static DateTimeU getInstance(Context context2) {
            if (instance == null) {
                instance = new DateTimeU(context2);
                mTimestampLabelYesterday = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_yesterday, context2.getResources());
                mTimestampLabelToday = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_today, context2.getResources());
                mTimestampLabelJustNow = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_just_now, context2.getResources());
                mTimestampLabelMinutesAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_minutes_ago, context2.getResources());
                mTimestampLabelHoursAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_hours_ago, context2.getResources());
                mTimestampLabelHourAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_hour_ago, context2.getResources());
                mTimestampLabelDaysAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_days_ago, context2.getResources());
                mTimestampLabelWeekAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_week_ago2, context2.getResources());
                mTimestampLabelWeeksAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_weeks_ago, context2.getResources());
                mTimestampLabelMonthAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_month_ago, context2.getResources());
                mTimestampLabelMonthsAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_months_ago, context2.getResources());
                mTimestampLabelYearAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_year_ago, context2.getResources());
                mTimestampLabelYearsAgo = ResourseU.getString(C5181R.string.WidgetProvider_timestamp_years_ago, context2.getResources());
            }
            return instance;
        }

        private static boolean isYesterday(long date) {
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTimeInMillis(date);
            Calendar yesterdayDate = Calendar.getInstance();
            yesterdayDate.add(5, -1);
            if (yesterdayDate.get(1) == currentDate.get(1) && yesterdayDate.get(6) == currentDate.get(6)) {
                return true;
            }
            return false;
        }

        public String getTimeDiffAll(Context context2, long time, Resources resources) {
            String str;
            String str2;
            String str3;
            String str4;
            long diffTime = new Date().getTime() - time;
            if (isYesterday(time) || DateUtils.isToday(time)) {
                getTimeDiffString(time, context2, resources);
                return getTimeDiffString(time, context2, resources);
            } else if (diffTime < 604800000) {
                int diffDays = Double.valueOf(Math.ceil((double) (diffTime / 86400000))).intValue();
                if (diffDays == 1) {
                    str4 = mTimestampLabelYesterday;
                } else {
                    str4 = StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_days_ago, resources, Integer.valueOf(diffDays));
                }
                return str4;
            } else if (diffTime < 2419200000L) {
                int diffDays2 = Double.valueOf(Math.ceil((double) (diffTime / 604800000))).intValue();
                if (diffDays2 == 1) {
                    str3 = mTimestampLabelWeekAgo;
                } else {
                    str3 = StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_weeks_ago, resources, Integer.valueOf(diffDays2));
                }
                return str3;
            } else if (diffTime < 29030400000L) {
                int diffDays3 = Double.valueOf(Math.ceil((double) (diffTime / 2419200000L))).intValue();
                if (diffDays3 == 1) {
                    str2 = mTimestampLabelMonthAgo;
                } else {
                    str2 = StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_months_ago, resources, Integer.valueOf(diffDays3));
                }
                return str2;
            } else {
                int diffDays4 = Double.valueOf(Math.ceil((double) (diffTime / 29030400000L))).intValue();
                if (diffDays4 == 1) {
                    str = mTimestampLabelYearAgo;
                } else {
                    str = StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_years_ago, resources, Integer.valueOf(diffDays4));
                }
                return str;
            }
        }

        public String getTimeDiffString(Context context2, long timedate, Resources resources) {
            String str;
            long j = timedate;
            Resources resources2 = resources;
            Calendar startDateTime = Calendar.getInstance();
            Calendar endDateTime = Calendar.getInstance();
            endDateTime.setTimeInMillis(j);
            long milliseconds1 = startDateTime.getTimeInMillis();
            long diff = milliseconds1 - endDateTime.getTimeInMillis();
            long hours = diff / 3600000;
            long minutes = (diff / 60000) - (60 * hours);
            long j2 = diff / 1000;
            boolean isToday = DateUtils.isToday(timedate);
            boolean isYesterday = isYesterday(timedate);
            long j3 = milliseconds1;
            if (hours > 0 && hours < 12) {
                if (hours == 1) {
                    str = StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_hour_ago, resources2, Long.valueOf(hours));
                } else {
                    str = StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_hours_ago, resources2, Long.valueOf(hours));
                }
                return str;
            } else if (hours <= 0) {
                if (minutes <= 0) {
                    return mTimestampLabelJustNow;
                }
                return StringU.getFormattedString(C5181R.string.WidgetProvider_timestamp_minutes_ago, resources2, Long.valueOf(minutes));
            } else if (isToday) {
                return mTimestampLabelToday;
            } else {
                if (isYesterday) {
                    return mTimestampLabelYesterday;
                }
                if (startDateTime.getTimeInMillis() - j < 518400000) {
                    return weekdays[endDateTime.get(7)];
                }
                return DateUtils.formatDateTime(context2, j, Opcodes.ACC_DEPRECATED);
            }
        }

        public String getTimeDiffString(long timedate, Context context2, Resources resources) {
            return getTimeDiffString(context2, timedate, resources);
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$HtmlU */
    public static class HtmlU {
        public static CharSequence parse(String text) {
            return Html.fromHtml(text.replace("\n", "<br/>").replace("&", "&amp;"));
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$IconSizeU */
    public static class IconSizeU {
        private static final String AVATAR_STRING = "_avatar";
        public static final int DEFAULT_SCREEN_DENSITY = -1;
        public static final int ICONS_SIZE_TYPE = 0;
        public static final int STORE_ICONS_SIZE_TYPE = 1;
        private static final String TAG = IconSizeU.class.getName();
        private static final int baseLine = 96;
        private static final int baseLineAvatar = 150;
        private static int baseLineScreenshotLand = Opcodes.ACC_NATIVE;
        private static int baseLineScreenshotPort = 96;
        private static final int baseLineXNotification = 320;
        private static final int baseLineYNotification = 180;
        public static final HashMap<Integer, String> mIconSizes = new HashMap<>();
        public static final HashMap<Integer, String> mStoreIconSizes = new HashMap<>();
        private static final Pattern urlWithDimensionPattern = Pattern.compile("_{1}[1-9]{3}(x|X){1}[1-9]{3}.{1}.{3,4}\\b");

        static {
            HashMap<Integer, String> hashMap = mStoreIconSizes;
            Integer valueOf = Integer.valueOf(480);
            hashMap.put(valueOf, "450x450");
            HashMap<Integer, String> hashMap2 = mStoreIconSizes;
            Integer valueOf2 = Integer.valueOf(baseLineXNotification);
            hashMap2.put(valueOf2, "300x300");
            HashMap<Integer, String> hashMap3 = mStoreIconSizes;
            Integer valueOf3 = Integer.valueOf(240);
            hashMap3.put(valueOf3, "225x225");
            HashMap<Integer, String> hashMap4 = mStoreIconSizes;
            Integer valueOf4 = Integer.valueOf(Opcodes.IF_ICMPNE);
            hashMap4.put(valueOf4, "150x150");
            HashMap<Integer, String> hashMap5 = mStoreIconSizes;
            Integer valueOf5 = Integer.valueOf(Opcodes.ISHL);
            hashMap5.put(valueOf5, "113x113");
            mIconSizes.put(Integer.valueOf(640), "384x384");
            mIconSizes.put(valueOf, "288x288");
            mIconSizes.put(valueOf2, "192x192");
            mIconSizes.put(valueOf3, "144x144");
            mIconSizes.put(valueOf4, "127x127");
            mIconSizes.put(valueOf5, "96x96");
        }

        public static String screenshotToThumb(String imageUrl, String orientation, WindowManager windowManager, Resources resources) {
            String screen = "/";
            try {
                if (imageUrl.contains("_screen")) {
                    return parseScreenshotUrl(imageUrl, orientation, windowManager, resources);
                }
                String[] splitString = imageUrl.split(screen);
                StringBuilder db = new StringBuilder();
                for (int i = 0; i != splitString.length - 1; i++) {
                    db.append(splitString[i]);
                    db.append(screen);
                }
                db.append("thumbs/mobile/");
                db.append(splitString[splitString.length - 1]);
                return db.toString();
            } catch (Exception e) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e);
                throw e;
            }
        }

        private static String parseScreenshotUrl(String screenshotUrl, String orientation, WindowManager windowManager, Resources resources) {
            String sizeString = generateSizeStringScreenshotsdd(orientation, windowManager, resources);
            String[] splitUrl = splitUrlExtension(screenshotUrl);
            StringBuilder sb = new StringBuilder();
            sb.append(splitUrl[0]);
            sb.append("_");
            sb.append(sizeString);
            sb.append(".");
            sb.append(splitUrl[1]);
            return sb.toString();
        }

        private static String generateSizeStringScreenshotsdd(String orient, WindowManager windowManager, Resources resources) {
            int size;
            float densityMultiplier = densityMultiplier(resources).floatValue();
            if (orient == null || !orient.equals("portrait")) {
                size = baseLineScreenshotLand * ((int) densityMultiplier);
            } else {
                size = baseLineScreenshotPort * ((int) densityMultiplier);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(size);
            sb.append("x");
            sb.append(ScreenU.getDensityDpi(windowManager));
            return sb.toString();
        }

        private static String[] splitUrlExtension(String url) {
            return url.split("\\.(?=[^\\.]+$)");
        }

        private static Float densityMultiplier(Resources resources) {
            float densityMultiplier;
            float densityMultiplier2 = resources.getDisplayMetrics().density;
            if (densityMultiplier2 <= 0.75f) {
                densityMultiplier = 0.75f;
            } else if (densityMultiplier2 <= 1.0f) {
                densityMultiplier = 1.0f;
            } else if (densityMultiplier2 <= 1.333f) {
                densityMultiplier = 1.33125f;
            } else if (densityMultiplier2 <= 1.5f) {
                densityMultiplier = 1.5f;
            } else if (densityMultiplier2 <= 2.0f) {
                densityMultiplier = 2.0f;
            } else if (densityMultiplier2 <= 3.0f) {
                densityMultiplier = 3.0f;
            } else {
                densityMultiplier = 4.0f;
            }
            return Float.valueOf(densityMultiplier);
        }

        @Deprecated
        public static String generateStringNotification(String url, Resources resources) {
            if (url == null) {
                return "";
            }
            float densityMultiplier = densityMultiplier(resources).floatValue();
            int sizeX = (int) (320.0f * densityMultiplier);
            int sizeY = (int) (180.0f * densityMultiplier);
            String[] splittedUrl = splitUrlExtension(url);
            StringBuilder sb = new StringBuilder();
            sb.append(splittedUrl[0]);
            sb.append("_");
            sb.append(sizeX);
            sb.append("x");
            sb.append(sizeY);
            sb.append(".");
            sb.append(splittedUrl[1]);
            return sb.toString();
        }

        public static String generateSizeStoreString(String url, Resources resources, WindowManager windowManager) {
            if (url == null) {
                return "";
            }
            String iconRes = (String) mStoreIconSizes.get(Integer.valueOf(resources.getDisplayMetrics().densityDpi));
            String iconRes2 = TextUtils.isEmpty(iconRes) ? getDefaultSize(1, windowManager) : iconRes;
            if (TextUtils.isEmpty(iconRes2)) {
                return url;
            }
            String[] splittedUrl = splitUrlExtension(url);
            StringBuilder sb = new StringBuilder();
            sb.append(splittedUrl[0]);
            sb.append("_");
            sb.append(iconRes2);
            sb.append(".");
            sb.append(splittedUrl[1]);
            return sb.toString();
        }

        private static String getDefaultSize(int varType, WindowManager windowManager) {
            if (varType != 0) {
                if (varType != 1) {
                    return null;
                }
                if (ScreenU.getDensityDpi(windowManager) < 240) {
                    return (String) mStoreIconSizes.get(Integer.valueOf(Opcodes.ISHL));
                }
                return (String) mStoreIconSizes.get(Integer.valueOf(480));
            } else if (ScreenU.getDensityDpi(windowManager) < 240) {
                return (String) mIconSizes.get(Integer.valueOf(Opcodes.ISHL));
            } else {
                return (String) mIconSizes.get(Integer.valueOf(640));
            }
        }

        public static String generateStringAvatar(String url, Resources resources, WindowManager windowManager) {
            if (url == null) {
                return "";
            }
            int round = Math.round(150.0f * densityMultiplier(resources).floatValue());
            String[] splittedUrl = splitUrlExtension(url);
            StringBuilder sb = new StringBuilder();
            sb.append(splittedUrl[0]);
            sb.append("_");
            sb.append(getUserAvatarIconSize(windowManager));
            sb.append(".");
            sb.append(splittedUrl[1]);
            return sb.toString();
        }

        private static String getUserAvatarIconSize(WindowManager windowManager) {
            if (ScreenU.getDensityDpi(windowManager) <= 240) {
                return "50x50";
            }
            return "150x150";
        }

        public static String getNewImageUrl(String imageUrl, Resources resources, WindowManager windowManager) {
            if (TextUtils.isEmpty(imageUrl)) {
                return imageUrl;
            }
            if (imageUrl.contains("portrait")) {
                return parseScreenshots(imageUrl, windowManager);
            }
            if (imageUrl.contains("_icon")) {
                return parseIcon(imageUrl, resources, windowManager);
            }
            return imageUrl;
        }

        private static String parseScreenshots(String orient, WindowManager windowManager) {
            if (orient == null) {
                return "";
            }
            boolean isPortrait = orient != null && orient.equals("portrait");
            int dpi = ScreenU.getDensityDpi(windowManager);
            String[] splittedUrl = splitUrlExtension(orient);
            StringBuilder sb = new StringBuilder();
            sb.append(splittedUrl[0]);
            sb.append("_");
            sb.append(getThumbnailSize(dpi, isPortrait));
            sb.append(".");
            sb.append(splittedUrl[1]);
            return sb.toString();
        }

        private static String parseIcon(String iconUrl, Resources resources, WindowManager windowManager) {
            if (iconUrl == null) {
                return "";
            }
            try {
                if (iconUrl.contains("_icon")) {
                    String sizeString = generateSizeString(resources, windowManager);
                    if (sizeString != null && !sizeString.isEmpty()) {
                        String[] splittedUrl = splitUrlExtension(iconUrl);
                        StringBuilder sb = new StringBuilder();
                        sb.append(splittedUrl[0]);
                        sb.append("_");
                        sb.append(sizeString);
                        sb.append(".");
                        sb.append(splittedUrl[1]);
                        iconUrl = sb.toString();
                    }
                }
                return iconUrl;
            } catch (Exception e) {
                Logger.getInstance().mo2142e(TAG, (Throwable) e);
                throw e;
            }
        }

        private static String getThumbnailSize(int density, boolean isPortrait) {
            if (!isPortrait) {
                if (density >= 640) {
                    return "1024x640";
                }
                if (density >= 480) {
                    return "768x480";
                }
                if (density >= baseLineXNotification) {
                    return "512x320";
                }
                if (density >= 240) {
                    return "384x240";
                }
                if (density >= 213) {
                    return "340x213";
                }
                if (density >= 160) {
                    return "256x160";
                }
                return "192x120";
            } else if (density >= 640) {
                return "384x640";
            } else {
                if (density >= 480) {
                    return "288x480";
                }
                if (density >= baseLineXNotification) {
                    return "192x320";
                }
                if (density >= 240) {
                    return "144x240";
                }
                if (density >= 213) {
                    return "127x213";
                }
                if (density >= 160) {
                    return "96x160";
                }
                return "72x120";
            }
        }

        private static String generateSizeString(Resources resources, WindowManager windowManager) {
            String iconRes = (String) mIconSizes.get(Integer.valueOf(resources.getDisplayMetrics().densityDpi));
            return iconRes != null ? iconRes : getDefaultSize(0, windowManager);
        }

        public static String cleanImageUrl(String originalUrl) {
            int lastUnderScore = originalUrl.lastIndexOf(95);
            if (lastUnderScore == -1) {
                return originalUrl;
            }
            if (!urlWithDimensionPattern.matcher(originalUrl.substring(lastUnderScore)).matches()) {
                return originalUrl;
            }
            int lastDot = originalUrl.lastIndexOf(46);
            StringBuilder sb = new StringBuilder();
            sb.append(originalUrl.substring(0, lastUnderScore));
            sb.append(originalUrl.substring(lastDot));
            return sb.toString();
        }
    }

    @Deprecated
    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$LocaleU */
    public static final class LocaleU {
        public static final Locale DEFAULT = Locale.getDefault();
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$MathU */
    public static final class MathU {
        public static int leastCommonMultiple(int[] input) {
            int result = input[0];
            for (int i = 1; i < input.length; i++) {
                result = leastCommonMultiple(result, input[i]);
            }
            return result;
        }

        private static int leastCommonMultiple(int a, int b) {
            if (a == 0 && b == 0) {
                return 0;
            }
            return (Math.abs(a) / greatestCommonDivisor(a, b)) * Math.abs(b);
        }

        private static int greatestCommonDivisor(int a, int b) {
            while (b > 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public static double mapValueFromRangeToRange(double value, double fromLow, double fromHigh, double toLow, double toHigh) {
            return (((value - fromLow) / (fromHigh - fromLow)) * (toHigh - toLow)) + toLow;
        }

        public static double clamp(double value, double low, double high) {
            return Math.min(Math.max(value, low), high);
        }
    }

    @Deprecated
    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$ObservableU */
    public static class ObservableU {
        public static <T> C0121c<T, T> applySchedulers() {
            return C5183a.f8944a;
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$RegexU */
    public static class RegexU {
        private static final String SPLIT_URL_EXTENSION = "\\.(?=[^\\.]+$)";
        private static final String STORE_ID_FROM_GET_URL = "store_id\\=(\\d+)";
        private static Pattern STORE_ID_FROM_GET_URL_PATTERN = null;
        private static final String STORE_NAME_FROM_GET_URL = "store_name\\/(.*?)\\/";
        private static Pattern STORE_NAME_FROM_GET_URL_PATTERN;

        public static Pattern getStoreIdFromGetUrlPattern() {
            if (STORE_ID_FROM_GET_URL_PATTERN == null) {
                STORE_ID_FROM_GET_URL_PATTERN = Pattern.compile(STORE_ID_FROM_GET_URL);
            }
            return STORE_ID_FROM_GET_URL_PATTERN;
        }

        public static Pattern getStoreNameFromGetUrlPattern() {
            if (STORE_NAME_FROM_GET_URL_PATTERN == null) {
                STORE_NAME_FROM_GET_URL_PATTERN = Pattern.compile(STORE_NAME_FROM_GET_URL);
            }
            return STORE_NAME_FROM_GET_URL_PATTERN;
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$ResourseU */
    public static class ResourseU {
        public static int getInt(int resId, Resources resources) {
            return resources.getInteger(resId);
        }

        public static Drawable getDrawable(int drawableId, Resources resources) {
            return resources.getDrawable(drawableId);
        }

        public static String getString(int stringRes, Resources resources) {
            return StringU.getResString(stringRes, resources);
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$ScreenU */
    public static final class ScreenU {
        public static final float REFERENCE_WIDTH_DPI = 360.0f;
        private static int displayWidthCacheLandscape = -1;
        private static int displayWidthCachePortrait = -1;
        private static ScreenUtilsCache screenWidthInDipCache = new ScreenUtilsCache();

        /* renamed from: cm.aptoide.pt.utils.AptoideUtils$ScreenU$ScreenUtilsCache */
        private static class ScreenUtilsCache {
            /* access modifiers changed from: private */
            public int orientation;
            /* access modifiers changed from: private */
            public float value;

            private ScreenUtilsCache() {
                this.orientation = -1;
            }

            public void set(int currentOrientation, float value2) {
                this.orientation = currentOrientation;
                this.value = value2;
            }
        }

        @Deprecated
        /* renamed from: cm.aptoide.pt.utils.AptoideUtils$ScreenU$Size */
        public enum Size {
            notfound,
            small,
            normal,
            large,
            xlarge;
            
            private static final String TAG = null;

            static {
                TAG = Size.class.getSimpleName();
            }

            public static Size lookup(String screen) {
                try {
                    return valueOf(screen);
                } catch (Exception e) {
                    Logger.getInstance().mo2142e(TAG, (Throwable) e);
                    return notfound;
                }
            }
        }

        public static int getCachedDisplayWidth(int orientation, WindowManager windowManager) {
            if (orientation == 2) {
                if (displayWidthCacheLandscape == -1) {
                    Display display = windowManager.getDefaultDisplay();
                    if (VERSION.SDK_INT >= 13) {
                        Point point = new Point();
                        display.getSize(point);
                        displayWidthCacheLandscape = point.x;
                    } else {
                        displayWidthCacheLandscape = display.getWidth();
                    }
                }
                return displayWidthCacheLandscape;
            }
            if (displayWidthCachePortrait == -1) {
                Display display2 = windowManager.getDefaultDisplay();
                if (VERSION.SDK_INT >= 13) {
                    Point point2 = new Point();
                    display2.getSize(point2);
                    displayWidthCachePortrait = point2.y;
                } else {
                    displayWidthCachePortrait = display2.getHeight();
                }
            }
            return displayWidthCachePortrait;
        }

        public static float getScreenWidthInDip(WindowManager windowManager, Resources resources) {
            if (getCurrentOrientation(resources) != screenWidthInDipCache.orientation) {
                DisplayMetrics dm = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(dm);
                screenWidthInDipCache.set(getCurrentOrientation(resources), ((float) dm.widthPixels) / dm.density);
            }
            return screenWidthInDipCache.value;
        }

        public static int getCurrentOrientation(Resources resources) {
            return resources.getConfiguration().orientation;
        }

        public static int getPixelsForDip(int dipValue, Resources resources) {
            return (int) TypedValue.applyDimension(1, (float) dipValue, resources.getDisplayMetrics());
        }

        public static int getNumericScreenSize(Resources resources) {
            return (getScreenSizeInt(resources) + 1) * 100;
        }

        public static String getScreenSize(Resources resources) {
            return Size.values()[getScreenSizeInt(resources)].name().toLowerCase(Locale.ENGLISH);
        }

        private static int getScreenSizeInt(Resources resources) {
            return resources.getConfiguration().screenLayout & 15;
        }

        public static int getDensityDpi(WindowManager windowManager) {
            DisplayMetrics metrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(metrics);
            int dpi = metrics.densityDpi;
            if (dpi <= 120) {
                return Opcodes.ISHL;
            }
            if (dpi <= 160) {
                return Opcodes.IF_ICMPNE;
            }
            if (dpi <= 213) {
                return 213;
            }
            if (dpi <= 240) {
                return 240;
            }
            if (dpi <= 320) {
                return 320;
            }
            if (dpi <= 480) {
                return 480;
            }
            return 640;
        }

        public static File takeScreenshot(Activity a, String mPath, String fileName) {
            String str = "FeedBackActivity-screenshot";
            FileUtils.createDir(mPath);
            View v1 = a.getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            try {
                Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                v1.setDrawingCacheEnabled(false);
                File imageFile = new File(mPath, fileName);
                try {
                    imageFile.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
                    bitmap.compress(CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return imageFile;
                } catch (FileNotFoundException e) {
                    Logger instance = Logger.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("FileNotFoundException: ");
                    sb.append(e.getMessage());
                    instance.mo2140e(str, sb.toString());
                    return null;
                } catch (IOException e2) {
                    Logger instance2 = Logger.getInstance();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("IOException: ");
                    sb2.append(e2.getMessage());
                    instance2.mo2140e(str, sb2.toString());
                    return null;
                }
            } catch (Exception e3) {
                Logger instance3 = Logger.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Exception: ");
                sb3.append(e3.getMessage());
                instance3.mo2140e(str, sb3.toString());
                return null;
            }
        }

        @Deprecated
        public static String getScreenSizePixels(Resources resources) {
            Configuration config = resources.getConfiguration();
            DisplayMetrics dm = resources.getDisplayMetrics();
            double d = (double) config.screenWidthDp;
            double d2 = (double) dm.density;
            Double.isNaN(d);
            Double.isNaN(d2);
            double screenWidthInPixels = d * d2;
            double d3 = (double) dm.heightPixels;
            Double.isNaN(d3);
            double d4 = d3 * screenWidthInPixels;
            double d5 = (double) dm.widthPixels;
            Double.isNaN(d5);
            double screenHeightInPixels = d4 / d5;
            StringBuilder sb = new StringBuilder();
            sb.append((int) (screenWidthInPixels + 0.5d));
            sb.append("x");
            sb.append((int) (0.5d + screenHeightInPixels));
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$SocialLinksU */
    public static final class SocialLinksU {
        public static String getFacebookPageURL(int version, String facebookUrl) {
            if (version < 3002850) {
                return facebookUrl;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("fb://facewebmodal/f?href=");
            sb.append(facebookUrl);
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.utils.AptoideUtils$ThreadU */
    public static final class ThreadU {
        private static final String TAG = ThreadU.class.getName();

        public static void runOnIoThread(Runnable runnable) {
            C0120S.m652c(null).mo3616a(Schedulers.m776io()).mo3626a((C0129b<? super T>) new C5185c<Object>(runnable), (C0129b<Throwable>) C5189e.f8948a);
        }

        /* renamed from: a */
        static /* synthetic */ void m9456a(Throwable e) {
            Logger.getInstance().mo2142e(TAG, e);
            throw new RuntimeException(e);
        }

        public static void runOnUiThread(Runnable runnable) {
            if (isUiThread()) {
                runnable.run();
            } else {
                C0120S.m652c(null).mo3616a(C14522a.m46170a()).mo3626a((C0129b<? super T>) new C5190f<Object>(runnable), (C0129b<Throwable>) C5186d.f8947a);
            }
        }

        public static String getStack() {
            StringBuilder stringBuilder = new StringBuilder();
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                stringBuilder.append(stackTraceElement);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }

        public static boolean isUiThread() {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }
    }

    public static boolean isDeviceMIUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    @SuppressLint({"PrivateApi"})
    private static String getSystemProperty(String key) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke(null, new Object[]{key});
        } catch (Exception e) {
            Logger.getInstance().mo2148w("AptoideUtils", e.getMessage());
            return null;
        }
    }
}
