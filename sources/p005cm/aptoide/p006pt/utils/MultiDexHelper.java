package p005cm.aptoide.p006pt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: cm.aptoide.pt.utils.MultiDexHelper */
public final class MultiDexHelper {
    private static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String PREFS_FILE = "multidex.version";
    private static final String SECONDARY_FOLDER_NAME;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("code_cache");
        sb.append(File.separator);
        sb.append("secondary-dexes");
        SECONDARY_FOLDER_NAME = sb.toString();
    }

    public static List<Entry<String, String>> getAllClasses(Context context) throws NameNotFoundException, IOException {
        DexFile dexfile;
        List<Entry<String, String>> classNames = new ArrayList<>();
        for (String path : getSourcePaths(context)) {
            DexFile dexfile2 = null;
            try {
                if (path.endsWith(EXTRACTED_SUFFIX)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(path);
                    sb.append(".tmp");
                    dexfile = DexFile.loadDex(path, sb.toString(), 0);
                } else {
                    dexfile = new DexFile(path);
                }
                Enumeration<String> dexEntries = dexfile.entries();
                while (dexEntries.hasMoreElements()) {
                    classNames.add(new SimpleImmutableEntry(dexEntries.nextElement(), path));
                }
                if (dexfile != null) {
                    dexfile.close();
                }
            } catch (IOException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error at loading dex file '");
                sb2.append(path);
                sb2.append("'");
                throw new IOException(sb2.toString());
            } catch (Throwable th) {
                if (dexfile2 != null) {
                    dexfile2.close();
                }
                throw th;
            }
        }
        return classNames;
    }

    public static List<String> getSourcePaths(Context context) throws NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File sourceApk = new File(applicationInfo.sourceDir);
        File dexDir = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
        List<String> sourcePaths = new ArrayList<>();
        sourcePaths.add(applicationInfo.sourceDir);
        StringBuilder sb = new StringBuilder();
        sb.append(sourceApk.getName());
        sb.append(EXTRACTED_NAME_EXT);
        String extractedFilePrefix = sb.toString();
        int totalDexNumber = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
        int secondaryNumber = 2;
        while (secondaryNumber <= totalDexNumber) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(extractedFilePrefix);
            sb2.append(secondaryNumber);
            sb2.append(EXTRACTED_SUFFIX);
            File extractedFile = new File(dexDir, sb2.toString());
            if (extractedFile.isFile()) {
                sourcePaths.add(extractedFile.getAbsolutePath());
                secondaryNumber++;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Missing extracted secondary dex file '");
                sb3.append(extractedFile.getPath());
                sb3.append("'");
                throw new IOException(sb3.toString());
            }
        }
        return sourcePaths;
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, VERSION.SDK_INT < 11 ? 0 : 4);
    }
}
