package p002b.p003c.p004f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* renamed from: b.c.f.a */
/* compiled from: MultiDex */
public final class C0021a {

    /* renamed from: a */
    private static final Set<File> f24a = new HashSet();

    /* renamed from: b */
    private static final boolean f25b = m41a(System.getProperty("java.vm.version"));

    /* renamed from: b.c.f.a$a */
    /* compiled from: MultiDex */
    private static final class C0022a {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m49b(ClassLoader loader, List<? extends File> additionalClassPathEntries, File optimizedDirectory) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object dexPathList = C0021a.m42b(loader, "pathList").get(loader);
            C0021a.m45b(dexPathList, "dexElements", m48a(dexPathList, new ArrayList<>(additionalClassPathEntries), optimizedDirectory));
        }

        /* renamed from: a */
        private static Object[] m48a(Object dexPathList, ArrayList<File> files, File optimizedDirectory) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) C0021a.m43b(dexPathList, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(dexPathList, new Object[]{files, optimizedDirectory});
        }
    }

    /* renamed from: b.c.f.a$b */
    /* compiled from: MultiDex */
    private static final class C0023b {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m52b(ClassLoader loader, List<? extends File> additionalClassPathEntries, File optimizedDirectory) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            IOException[] dexElementsSuppressedExceptions;
            Object dexPathList = C0021a.m42b(loader, "pathList").get(loader);
            ArrayList<IOException> suppressedExceptions = new ArrayList<>();
            C0021a.m45b(dexPathList, "dexElements", m51a(dexPathList, new ArrayList(additionalClassPathEntries), optimizedDirectory, suppressedExceptions));
            if (suppressedExceptions.size() > 0) {
                Iterator it = suppressedExceptions.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field suppressedExceptionsField = C0021a.m42b(dexPathList, "dexElementsSuppressedExceptions");
                IOException[] dexElementsSuppressedExceptions2 = (IOException[]) suppressedExceptionsField.get(dexPathList);
                if (dexElementsSuppressedExceptions2 == null) {
                    dexElementsSuppressedExceptions = (IOException[]) suppressedExceptions.toArray(new IOException[suppressedExceptions.size()]);
                } else {
                    IOException[] combined = new IOException[(suppressedExceptions.size() + dexElementsSuppressedExceptions2.length)];
                    suppressedExceptions.toArray(combined);
                    System.arraycopy(dexElementsSuppressedExceptions2, 0, combined, suppressedExceptions.size(), dexElementsSuppressedExceptions2.length);
                    dexElementsSuppressedExceptions = combined;
                }
                suppressedExceptionsField.set(dexPathList, dexElementsSuppressedExceptions);
            }
        }

        /* renamed from: a */
        private static Object[] m51a(Object dexPathList, ArrayList<File> files, File optimizedDirectory, ArrayList<IOException> suppressedExceptions) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) C0021a.m43b(dexPathList, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(dexPathList, new Object[]{files, optimizedDirectory, suppressedExceptions});
        }
    }

    /* renamed from: b.c.f.a$c */
    /* compiled from: MultiDex */
    private static final class C0024c {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m54b(ClassLoader loader, List<? extends File> additionalClassPathEntries) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int extraSize = additionalClassPathEntries.size();
            Field pathField = C0021a.m42b(loader, "path");
            StringBuilder path = new StringBuilder((String) pathField.get(loader));
            String[] extraPaths = new String[extraSize];
            File[] extraFiles = new File[extraSize];
            ZipFile[] extraZips = new ZipFile[extraSize];
            DexFile[] extraDexs = new DexFile[extraSize];
            ListIterator<? extends File> iterator = additionalClassPathEntries.listIterator();
            while (iterator.hasNext()) {
                File additionalEntry = (File) iterator.next();
                String entryPath = additionalEntry.getAbsolutePath();
                path.append(':');
                path.append(entryPath);
                int index = iterator.previousIndex();
                extraPaths[index] = entryPath;
                extraFiles[index] = additionalEntry;
                extraZips[index] = new ZipFile(additionalEntry);
                StringBuilder sb = new StringBuilder();
                sb.append(entryPath);
                sb.append(".dex");
                extraDexs[index] = DexFile.loadDex(entryPath, sb.toString(), 0);
            }
            pathField.set(loader, path.toString());
            C0021a.m45b((Object) loader, "mPaths", (Object[]) extraPaths);
            C0021a.m45b((Object) loader, "mFiles", (Object[]) extraFiles);
            C0021a.m45b((Object) loader, "mZips", (Object[]) extraZips);
            C0021a.m45b((Object) loader, "mDexs", (Object[]) extraDexs);
        }
    }

    /* renamed from: a */
    public static void m36a(Context context) {
        String str = "MultiDex";
        Log.i(str, "Installing application");
        if (f25b) {
            Log.i(str, "VM has multidex support, MultiDex support library is disabled.");
        } else if (VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo applicationInfo = m46c(context);
                if (applicationInfo == null) {
                    Log.i(str, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                m37a(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "");
                Log.i(str, "install done");
            } catch (Exception e) {
                Log.e(str, "MultiDex installation failure", e);
                StringBuilder sb = new StringBuilder();
                sb.append("MultiDex installation failed (");
                sb.append(e.getMessage());
                sb.append(").");
                throw new RuntimeException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MultiDex installation failed. SDK ");
            sb2.append(VERSION.SDK_INT);
            sb2.append(" is unsupported. Min SDK version is ");
            sb2.append(4);
            sb2.append(".");
            throw new RuntimeException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static void m37a(Context mainContext, File sourceApk, File dataDir, String secondaryFolderName, String prefsKeyPrefix) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        synchronized (f24a) {
            if (!f24a.contains(sourceApk)) {
                f24a.add(sourceApk);
                if (VERSION.SDK_INT > 20) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("MultiDex is not guaranteed to work in SDK version ");
                    sb.append(VERSION.SDK_INT);
                    sb.append(": SDK version higher than ");
                    sb.append(20);
                    sb.append(" should be backed by ");
                    sb.append("runtime with built-in multidex capabilty but it's not the ");
                    sb.append("case here: java.vm.version=\"");
                    sb.append(System.getProperty("java.vm.version"));
                    sb.append("\"");
                    Log.w("MultiDex", sb.toString());
                }
                try {
                    ClassLoader loader = mainContext.getClassLoader();
                    if (loader == null) {
                        Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                        return;
                    }
                    try {
                        m44b(mainContext);
                    } catch (Throwable t) {
                        Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", t);
                    }
                    File dexDir = m33a(mainContext, dataDir, secondaryFolderName);
                    m39a(loader, dexDir, C0026c.m58a(mainContext, sourceApk, dexDir, prefsKeyPrefix, false));
                } catch (RuntimeException e) {
                    Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
                }
            }
        }
    }

    /* renamed from: c */
    private static ApplicationInfo m46c(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    /* renamed from: a */
    static boolean m41a(String versionString) {
        boolean isMultidexCapable = false;
        if (versionString != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(versionString);
            if (matcher.matches()) {
                boolean z = true;
                try {
                    int major = Integer.parseInt(matcher.group(1));
                    int minor = Integer.parseInt(matcher.group(2));
                    if (major <= 2 && (major != 2 || minor < 1)) {
                        z = false;
                    }
                    isMultidexCapable = z;
                } catch (NumberFormatException e) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(versionString);
        sb.append(isMultidexCapable ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        return isMultidexCapable;
    }

    /* renamed from: a */
    private static void m39a(ClassLoader loader, File dexDir, List<? extends File> files) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (!files.isEmpty()) {
            int i = VERSION.SDK_INT;
            if (i >= 19) {
                C0023b.m52b(loader, files, dexDir);
            } else if (i >= 14) {
                C0022a.m49b(loader, files, dexDir);
            } else {
                C0024c.m54b(loader, files);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Field m42b(Object instance, String name) throws NoSuchFieldException {
        Class<?> clazz = instance.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(name);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field ");
        sb.append(name);
        sb.append(" not found in ");
        sb.append(instance.getClass());
        throw new NoSuchFieldException(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Method m43b(Object instance, String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Class<?> clazz = instance.getClass();
        while (clazz != null) {
            try {
                Method method = clazz.getDeclaredMethod(name, parameterTypes);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(name);
        sb.append(" with parameters ");
        sb.append(Arrays.asList(parameterTypes));
        sb.append(" not found in ");
        sb.append(instance.getClass());
        throw new NoSuchMethodException(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m45b(Object instance, String fieldName, Object[] extraElements) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field jlrField = m42b(instance, fieldName);
        Object[] original = (Object[]) jlrField.get(instance);
        Object[] combined = (Object[]) Array.newInstance(original.getClass().getComponentType(), original.length + extraElements.length);
        System.arraycopy(original, 0, combined, 0, original.length);
        System.arraycopy(extraElements, 0, combined, original.length, extraElements.length);
        jlrField.set(instance, combined);
    }

    /* renamed from: b */
    private static void m44b(Context context) throws Exception {
        File dexDir = new File(context.getFilesDir(), "secondary-dexes");
        if (dexDir.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing old secondary dex dir (");
            sb.append(dexDir.getPath());
            String str = ").";
            sb.append(str);
            String str2 = "MultiDex";
            Log.i(str2, sb.toString());
            File[] files = dexDir.listFiles();
            if (files == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to list secondary dex dir content (");
                sb2.append(dexDir.getPath());
                sb2.append(str);
                Log.w(str2, sb2.toString());
                return;
            }
            for (File oldFile : files) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to delete old file ");
                sb3.append(oldFile.getPath());
                sb3.append(" of size ");
                sb3.append(oldFile.length());
                Log.i(str2, sb3.toString());
                if (!oldFile.delete()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete old file ");
                    sb4.append(oldFile.getPath());
                    Log.w(str2, sb4.toString());
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(oldFile.getPath());
                    Log.i(str2, sb5.toString());
                }
            }
            if (!dexDir.delete()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Failed to delete secondary dex dir ");
                sb6.append(dexDir.getPath());
                Log.w(str2, sb6.toString());
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Deleted old secondary dex dir ");
                sb7.append(dexDir.getPath());
                Log.i(str2, sb7.toString());
            }
        }
    }

    /* renamed from: a */
    private static File m33a(Context context, File dataDir, String secondaryFolderName) throws IOException {
        String str = "code_cache";
        File cache = new File(dataDir, str);
        try {
            m38a(cache);
        } catch (IOException e) {
            cache = new File(context.getFilesDir(), str);
            m38a(cache);
        }
        File dexDir = new File(cache, secondaryFolderName);
        m38a(dexDir);
        return dexDir;
    }

    /* renamed from: a */
    private static void m38a(File dir) throws IOException {
        dir.mkdir();
        if (!dir.isDirectory()) {
            File parent = dir.getParentFile();
            String str = "Failed to create dir ";
            String str2 = "MultiDex";
            if (parent == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(dir.getPath());
                sb.append(". Parent file is null.");
                Log.e(str2, sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(dir.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parent.isDirectory());
                sb2.append(", a file ");
                sb2.append(parent.isFile());
                sb2.append(", exists ");
                sb2.append(parent.exists());
                sb2.append(", readable ");
                sb2.append(parent.canRead());
                sb2.append(", writable ");
                sb2.append(parent.canWrite());
                Log.e(str2, sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory ");
            sb3.append(dir.getPath());
            throw new IOException(sb3.toString());
        }
    }
}
