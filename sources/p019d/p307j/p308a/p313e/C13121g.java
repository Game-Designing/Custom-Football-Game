package p019d.p307j.p308a.p313e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: d.j.a.e.g */
/* compiled from: FileDownloadUtils */
public class C13121g {

    /* renamed from: a */
    private static int f40147a = 65536;

    /* renamed from: b */
    private static long f40148b = 2000;

    /* renamed from: c */
    private static String f40149c;

    /* renamed from: d */
    private static Boolean f40150d;

    /* renamed from: e */
    private static Boolean f40151e = null;

    /* renamed from: f */
    private static final Pattern f40152f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: a */
    public static void m42793a(int minProgressStep) throws IllegalAccessException {
        if (m42799b(C13113c.m42768a())) {
            f40147a = minProgressStep;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    /* renamed from: a */
    public static void m42794a(long minProgressTime) throws IllegalAccessException {
        if (m42799b(C13113c.m42768a())) {
            f40148b = minProgressTime;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    /* renamed from: b */
    public static int m42796b() {
        return f40147a;
    }

    /* renamed from: c */
    public static long m42800c() {
        return f40148b;
    }

    /* renamed from: i */
    public static boolean m42810i(String filename) {
        return true;
    }

    /* renamed from: a */
    public static String m42789a() {
        if (!TextUtils.isEmpty(f40149c)) {
            return f40149c;
        }
        if (C13113c.m42768a().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return C13113c.m42768a().getExternalCacheDir().getAbsolutePath();
    }

    /* renamed from: d */
    public static String m42803d(String url) {
        return m42790a(m42789a(), m42801c(url));
    }

    /* renamed from: c */
    public static String m42801c(String url) {
        return m42812k(url);
    }

    /* renamed from: a */
    public static String m42790a(String directory, String filename) {
        if (filename == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        } else if (directory != null) {
            return m42792a("%s%s%s", directory, File.separator, filename);
        } else {
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
    }

    /* renamed from: g */
    public static String m42808g(String targetPath) {
        return m42792a("%s.temp", targetPath);
    }

    /* renamed from: b */
    public static int m42797b(String url, String path) {
        return m42787a(url, path, false);
    }

    /* renamed from: a */
    public static int m42787a(String url, String path, boolean pathAsDirectory) {
        if (pathAsDirectory) {
            return m42812k(m42792a("%sp%s@dir", url, path)).hashCode();
        }
        return m42812k(m42792a("%sp%s", url, path)).hashCode();
    }

    /* renamed from: k */
    private static String m42812k(String string) {
        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 255) < 16) {
                    hex.append(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                }
                hex.append(Integer.toHexString(b & 255));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    /* renamed from: b */
    public static boolean m42799b(Context context) {
        Boolean bool = f40150d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean result = false;
        if (!C13119f.m42785a().f40143d) {
            int pid = Process.myPid();
            List<RunningAppProcessInfo> runningAppProcessInfoList = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcessInfoList != null && !runningAppProcessInfoList.isEmpty()) {
                Iterator it = runningAppProcessInfoList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                    if (runningAppProcessInfo.pid == pid) {
                        result = runningAppProcessInfo.processName.endsWith(":filedownloader");
                        break;
                    }
                }
            } else {
                C13117d.m42783e(C13121g.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                return false;
            }
        } else {
            result = true;
        }
        f40150d = Boolean.valueOf(result);
        return f40150d.booleanValue();
    }

    /* renamed from: e */
    public static long m42806e(String path) {
        StatFs statFs = new StatFs(path);
        if (VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes();
        }
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: a */
    public static String m42792a(String msg, Object... args) {
        return String.format(Locale.ENGLISH, msg, args);
    }

    /* renamed from: d */
    public static void m42804d(Context context) {
        File file = m42788a(context);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static boolean m42802c(Context context) {
        if (f40151e == null) {
            f40151e = Boolean.valueOf(m42788a(context).exists());
        }
        return f40151e.booleanValue();
    }

    /* renamed from: a */
    public static File m42788a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("filedownloader");
        return new File(sb.toString(), ".old_file_converted");
    }

    /* renamed from: j */
    public static String m42811j(String contentDisposition) {
        if (contentDisposition == null) {
            return null;
        }
        try {
            Matcher m = f40152f.matcher(contentDisposition);
            if (m.find()) {
                return m.group(1);
            }
        } catch (IllegalStateException e) {
        }
        return null;
    }

    /* renamed from: a */
    public static String m42791a(String path, boolean pathAsDirectory, String filename) {
        if (path == null) {
            return null;
        }
        if (!pathAsDirectory) {
            return path;
        }
        if (filename == null) {
            return null;
        }
        return m42790a(path, filename);
    }

    /* renamed from: f */
    public static String m42807f(String path) {
        int length = path.length();
        int firstInPath = 0;
        if (File.separatorChar == '\\' && length > 2 && path.charAt(1) == ':') {
            firstInPath = 2;
        }
        int index = path.lastIndexOf(File.separatorChar);
        if (index == -1 && firstInPath > 0) {
            index = 2;
        }
        if (index != -1) {
            char charAt = path.charAt(length - 1);
            char c = File.separatorChar;
            if (charAt != c) {
                if (path.indexOf(c) == index && path.charAt(firstInPath) == File.separatorChar) {
                    return path.substring(0, index + 1);
                }
                return path.substring(0, index);
            }
        }
        return null;
    }

    /* renamed from: h */
    public static String m42809h(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader-");
        sb.append(name);
        return sb.toString();
    }

    /* renamed from: d */
    public static boolean m42805d() {
        NetworkInfo info = ((ConnectivityManager) C13113c.m42768a().getSystemService("connectivity")).getActiveNetworkInfo();
        return info != null && info.getType() == 1;
    }

    /* renamed from: a */
    public static boolean m42795a(String permission) {
        return C13113c.m42768a().checkCallingOrSelfPermission(permission) == 0;
    }

    /* renamed from: b */
    public static long m42798b(String s) {
        if (s == null) {
            return -1;
        }
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
