package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class NativeCallback {
    private static AtomicInteger _callbackCount = new AtomicInteger(0);
    private Method _callback;
    private String _id;

    public NativeCallback(Method callback) {
        this._callback = callback;
        StringBuilder sb = new StringBuilder();
        sb.append(this._callback.getName().toUpperCase(Locale.US));
        sb.append("_");
        sb.append(_callbackCount.getAndIncrement());
        this._id = sb.toString();
    }

    public String getId() {
        return this._id;
    }

    public void invoke(String status, Object... values) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException {
        Object[] values2;
        try {
            CallbackStatus cbs = CallbackStatus.valueOf(status);
            if (values == null) {
                values2 = new Object[]{cbs};
            } else {
                ArrayList<Object> tmpAr = new ArrayList<>(Arrays.asList(values));
                tmpAr.add(0, cbs);
                values2 = tmpAr.toArray();
            }
            this._callback.invoke(null, values2);
            WebViewApp.getCurrentApp().removeCallback(this);
        } catch (Exception e) {
            DeviceLog.error("Illegal status");
            WebViewApp.getCurrentApp().removeCallback(this);
            throw e;
        }
    }
}
