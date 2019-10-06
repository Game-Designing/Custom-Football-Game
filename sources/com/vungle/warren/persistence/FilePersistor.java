package com.vungle.warren.persistence;

import android.util.Log;
import com.vungle.warren.persistence.Persistor.MigrationCallback;
import com.vungle.warren.persistence.Persistor.Transformation;
import com.vungle.warren.utility.FileUtility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FilePersistor implements Persistor {
    /* access modifiers changed from: private */
    public static final String TAG = FilePersistor.class.getSimpleName();
    static final String VUNGLE = "vungle";
    private static final String V_PREFIX = "V";
    private Integer currentVersion;
    private File filesDir;

    private interface TransformationReader {
        byte[] readBytes(File file);
    }

    static class Version implements Memorable {

        /* renamed from: ID */
        public static final String f39029ID = "Data";
        private final String reason;
        private final long timestamp;
        private final int versionInt;

        public Version(int versionInt2, String reason2, long timestamp2) {
            this.versionInt = versionInt2;
            this.reason = reason2;
            this.timestamp = timestamp2;
        }

        public Version(byte[] bytes) {
            ByteBuffer buffy = ByteBuffer.wrap(bytes);
            this.versionInt = buffy.getInt();
            this.reason = MemoryUtils.extractString(buffy);
            this.timestamp = buffy.getLong();
        }

        public byte[] toByteArray() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                out.write(MemoryUtils.toBytes(this.versionInt));
                MemoryUtils.write(this.reason, out);
                MemoryUtils.write(Long.valueOf(this.timestamp), out);
                return out.toByteArray();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to write ");
                sb.append(this);
                sb.append(" to a byte array");
                Log.e("Version#toByteArray()", sb.toString());
                return new byte[0];
            }
        }

        public String getId() {
            return f39029ID;
        }

        public int getVersion() {
            return this.versionInt;
        }
    }

    public FilePersistor(File filesDir2) {
        this.filesDir = new File(filesDir2, "vungle");
    }

    public File getStorageDirectory() throws IllegalStateException {
        return makeWorkingDir();
    }

    private File makeWorkingDir() {
        checkInitialized();
        File file = this.filesDir;
        StringBuilder sb = new StringBuilder();
        sb.append(V_PREFIX);
        sb.append(this.currentVersion);
        File vungleDir = new File(file, sb.toString());
        if (!vungleDir.exists()) {
            vungleDir.mkdirs();
        }
        return vungleDir;
    }

    private void checkInitialized() {
        if (this.filesDir == null || this.currentVersion == null) {
            throw new IllegalStateException("Working dir is null");
        }
    }

    public void init(int currentVersion2, MigrationCallback migrationCallback) {
        this.currentVersion = Integer.valueOf(currentVersion2);
        checkInitialized();
        Version version = (Version) find(Version.f39029ID, Version.class);
        if (version == null || version.getVersion() != currentVersion2) {
            int oldVersion = version == null ? 0 : version.getVersion();
            if (oldVersion > currentVersion2) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("downgrade is not supported performing destructive migration, old version = ");
                sb.append(oldVersion);
                sb.append(" current = ");
                sb.append(currentVersion2);
                Log.e(str, sb.toString());
                migrationCallback.onDowngrade(oldVersion, currentVersion2);
            } else {
                migrationCallback.onUpgrade(oldVersion, currentVersion2);
            }
            save((Memorable) new Version(currentVersion2, "upgrade/new", System.currentTimeMillis()));
            scanAndDeleteNonRelevant();
            return;
        }
        scanAndDeleteNonRelevant();
    }

    private void scanAndDeleteNonRelevant() {
        final File dir = makeWorkingDir();
        File[] filesToDelete = this.filesDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !dir.getName().equals(file.getName());
            }
        });
        if (filesToDelete == null) {
            Log.d(TAG, "nothing was found for deletion during scanning");
            return;
        }
        for (File file : filesToDelete) {
            try {
                FileUtility.delete(file);
            } catch (IOException e) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("error deletion during scanning ");
                sb.append(e.getLocalizedMessage());
                Log.d(str, sb.toString());
            }
        }
    }

    public boolean save(Memorable m) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" Saving ");
        sb.append(m);
        Log.d(str, sb.toString());
        File dir = getStorageDirectory();
        if (dir == null || !dir.isDirectory()) {
            return false;
        }
        FileOutputStream fos = null;
        try {
            File storageDirectory = getStorageDirectory();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m.getId());
            sb2.append(".");
            sb2.append(m.getClass().getSimpleName());
            File out = new File(storageDirectory, sb2.toString());
            if (out.exists()) {
                if (!out.delete()) {
                    throw new IOException("Failed to delete previous version of memorable file!");
                }
            }
            if (out.createNewFile()) {
                fos = new FileOutputStream(out);
                fos.write(m.toByteArray());
                return true;
            }
            throw new IOException("Failed to create file for memorable!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } finally {
            FileUtility.closeQuietly(fos);
        }
    }

    public boolean save(List<Memorable> memorables) {
        if (memorables == null) {
            return false;
        }
        boolean ret = true;
        for (Memorable memorable : memorables) {
            ret &= save(memorable);
        }
        return ret;
    }

    public <T extends Memorable> List<T> extractAll(Class<T> clazz) {
        return extractAll(clazz, null);
    }

    private <T extends Memorable> List<T> extractAll(final Class<T> clazz, final FilenameFilter fileFilter) {
        File dir = getStorageDirectory();
        if (dir == null || !dir.isDirectory() || !dir.exists()) {
            return Collections.emptyList();
        }
        File[] data = dir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String s) {
                FilenameFilter filenameFilter = fileFilter;
                if (!(filenameFilter == null ? true : filenameFilter.accept(file, s)) || !s.endsWith(clazz.getSimpleName())) {
                    return false;
                }
                return true;
            }
        });
        if (data == null || data.length == 0) {
            return Collections.emptyList();
        }
        List<T> items = new ArrayList<>();
        for (File file : data) {
            if (file != null && file.exists()) {
                try {
                    T model = extractFrom(file, clazz);
                    if (model != null) {
                        items.add(model);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return items;
    }

    public <T extends Memorable> T extractFrom(File file, Class<T> clazz) throws IOException {
        try {
            byte[] bytes = FileUtility.extractBytes(file);
            if (bytes.length == 0) {
                return null;
            }
            return (Memorable) clazz.getDeclaredConstructor(new Class[]{byte[].class}).newInstance(new Object[]{bytes});
        } catch (FileNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Memorable> T find(String key, Class<T> clazz) {
        String str = ".";
        if (!key.contains(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append(str);
            sb.append(clazz.getSimpleName());
            key = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getStorageDirectory());
        sb2.append("/");
        sb2.append(key);
        File f = new File(sb2.toString());
        if (!f.exists()) {
            return null;
        }
        try {
            return extractFrom(f, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Memorable> List<T> findAll(Set<String> keys, Class<T> clazz) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> items = new ArrayList<>();
        for (String key : keys) {
            T item = find(key, clazz);
            if (item != null) {
                items.add(item);
            }
        }
        return items;
    }

    public boolean delete(Memorable m) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" Delete ");
        sb.append(m);
        Log.d(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getStorageDirectory());
        sb2.append(File.separator);
        sb2.append(m.getId());
        sb2.append(".");
        sb2.append(m.getClass().getSimpleName());
        File f = new File(sb2.toString());
        return f.exists() && f.delete();
    }

    public void clearCache() {
        File dir = this.filesDir;
        if (dir.exists()) {
            try {
                FileUtility.delete(dir);
            } catch (IOException e) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to delete cached files. Reason: ");
                sb.append(e.getLocalizedMessage());
                Log.e(str, sb.toString());
            }
        }
        makeWorkingDir();
    }

    public <T extends Memorable> void migrateData(int oldVersion, int newVersion, final Class<T> clazz, Transformation<T> transformation) {
        if (oldVersion < 1) {
            TransformationReader reader = new TransformationReader() {
                public byte[] readBytes(File file) {
                    byte[] bytes = null;
                    try {
                        bytes = FileUtility.extractBytes(file);
                    } catch (IOException e) {
                        String access$000 = FilePersistor.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed restore ");
                        sb.append(file.getName());
                        sb.append(" ");
                        sb.append(e.getLocalizedMessage());
                        Log.e(access$000, sb.toString());
                    }
                    if (bytes == null || bytes.length <= 1) {
                        return new byte[0];
                    }
                    return Arrays.copyOfRange(bytes, 1, bytes.length);
                }
            };
            File[] files = this.filesDir.listFiles(new FilenameFilter() {
                public boolean accept(File file, String s) {
                    return s.endsWith(clazz.getSimpleName());
                }
            });
            if (files == null) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot read files during migration for ");
                sb.append(clazz.getSimpleName());
                Log.e(str, sb.toString());
                return;
            }
            for (File modelFile : files) {
                try {
                    byte[] data = reader.readBytes(modelFile);
                    FileUtility.delete(modelFile);
                    if (data.length != 0) {
                        try {
                            T obj = (Memorable) transformation.transform(oldVersion, newVersion, data);
                            if (obj != null) {
                                save((Memorable) obj);
                            }
                        } catch (Throwable th) {
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
