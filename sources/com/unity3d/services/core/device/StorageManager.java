package com.unity3d.services.core.device;

import android.content.Context;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageManager {
    protected static final Map<StorageType, String> _storageFileMap = new HashMap();
    protected static final List<Storage> _storages = new ArrayList();

    public enum StorageType {
        PRIVATE,
        PUBLIC
    }

    public static boolean init(Context context) {
        if (context == null) {
            return false;
        }
        File cacheDir = context.getFilesDir();
        if (cacheDir == null) {
            return false;
        }
        StorageType storageType = StorageType.PUBLIC;
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir);
        String str = "/";
        sb.append(str);
        sb.append(SdkProperties.getLocalStorageFilePrefix());
        sb.append("public-data.json");
        addStorageLocation(storageType, sb.toString());
        if (!setupStorage(StorageType.PUBLIC)) {
            return false;
        }
        StorageType storageType2 = StorageType.PRIVATE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cacheDir);
        sb2.append(str);
        sb2.append(SdkProperties.getLocalStorageFilePrefix());
        sb2.append("private-data.json");
        addStorageLocation(storageType2, sb2.toString());
        if (!setupStorage(StorageType.PRIVATE)) {
            return false;
        }
        return true;
    }

    public static void initStorage(StorageType type) {
        if (hasStorage(type)) {
            Storage s = getStorage(type);
            if (s != null) {
                s.initStorage();
            }
        } else if (_storageFileMap.containsKey(type)) {
            Storage s2 = new Storage((String) _storageFileMap.get(type), type);
            s2.initStorage();
            _storages.add(s2);
        }
    }

    private static boolean setupStorage(StorageType type) {
        if (!hasStorage(type)) {
            initStorage(type);
            Storage s = getStorage(type);
            if (s != null && !s.storageFileExists()) {
                s.writeStorage();
            }
            if (s == null) {
                return false;
            }
        }
        return true;
    }

    public static Storage getStorage(StorageType type) {
        List<Storage> list = _storages;
        if (list != null) {
            for (Storage s : list) {
                if (s.getType().equals(type)) {
                    return s;
                }
            }
        }
        return null;
    }

    public static boolean hasStorage(StorageType type) {
        List<Storage> list = _storages;
        if (list != null) {
            for (Storage s : list) {
                if (s.getType().equals(type)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static synchronized void addStorageLocation(StorageType type, String filename) {
        synchronized (StorageManager.class) {
            if (!_storageFileMap.containsKey(type)) {
                _storageFileMap.put(type, filename);
            }
        }
    }

    public static synchronized void removeStorage(StorageType type) {
        synchronized (StorageManager.class) {
            if (getStorage(type) != null) {
                _storages.remove(getStorage(type));
            }
            if (_storageFileMap != null) {
                _storageFileMap.remove(type);
            }
        }
    }
}
