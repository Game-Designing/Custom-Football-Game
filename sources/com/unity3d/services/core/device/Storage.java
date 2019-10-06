package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager.StorageType;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.io.File;
import org.json.JSONObject;

public class Storage extends JsonStorage {
    private String _targetFileName;
    private StorageType _type;

    public Storage(String targetFileName, StorageType type) {
        this._targetFileName = targetFileName;
        this._type = type;
    }

    public StorageType getType() {
        return this._type;
    }

    public synchronized boolean readStorage() {
        try {
            byte[] bytes = Utilities.readFileBytes(new File(this._targetFileName));
            if (bytes == null) {
                return false;
            }
            setData(new JSONObject(new String(bytes)));
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error creating storage JSON", e);
            return false;
        }
    }

    public synchronized boolean initStorage() {
        readStorage();
        super.initData();
        return true;
    }

    public synchronized boolean writeStorage() {
        File f = new File(this._targetFileName);
        if (getData() == null) {
            return false;
        }
        return Utilities.writeFile(f, getData().toString());
    }

    public synchronized boolean clearStorage() {
        clearData();
        return new File(this._targetFileName).delete();
    }

    public synchronized boolean storageFileExists() {
        return new File(this._targetFileName).exists();
    }

    public synchronized void sendEvent(StorageEvent eventType, Object value) {
        boolean success = false;
        if (WebViewApp.getCurrentApp() != null) {
            success = WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORAGE, eventType, this._type.name(), value);
        }
        if (!success) {
            DeviceLog.debug("Couldn't send storage event to WebApp");
        }
    }
}
