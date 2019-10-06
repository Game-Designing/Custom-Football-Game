package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;

public class WebViewBridge {
    private static HashMap<String, HashMap<String, HashMap<Integer, Method>>> _classTable;

    public static void setClassTable(Class[] apiClassList) {
        Method[] methods;
        HashMap<Integer, Method> overrideTable;
        if (apiClassList != null) {
            _classTable = new HashMap<>();
            for (Class cls : apiClassList) {
                if (cls != null && (cls.getPackage().getName().startsWith("com.unity3d.services") || cls.getPackage().getName().startsWith("com.unity3d.ads.test"))) {
                    HashMap<String, HashMap<Integer, Method>> methodTable = new HashMap<>();
                    for (Method method : cls.getMethods()) {
                        if (method.getAnnotation(WebViewExposed.class) != null) {
                            String methodName = method.getName();
                            if (methodTable.containsKey(methodName)) {
                                overrideTable = (HashMap) methodTable.get(methodName);
                            } else {
                                overrideTable = new HashMap<>();
                            }
                            overrideTable.put(Integer.valueOf(Arrays.deepHashCode(method.getParameterTypes())), method);
                            methodTable.put(methodName, overrideTable);
                        }
                    }
                    _classTable.put(cls.getName(), methodTable);
                }
            }
        }
    }

    private static Method findMethod(String className, String methodName, Object[] parameters) throws JSONException, NoSuchMethodException {
        if (_classTable.containsKey(className)) {
            HashMap<String, HashMap<Integer, Method>> methodTable = (HashMap) _classTable.get(className);
            if (methodTable.containsKey(methodName)) {
                return (Method) ((HashMap) methodTable.get(methodName)).get(Integer.valueOf(Arrays.deepHashCode(getTypes(parameters))));
            }
            throw new NoSuchMethodException();
        }
        throw new NoSuchMethodException();
    }

    private static Class<?>[] getTypes(Object[] parameters) throws JSONException {
        Class<?>[] types;
        if (parameters == null) {
            types = new Class[1];
        } else {
            types = new Class[(parameters.length + 1)];
        }
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                types[i] = parameters[i].getClass();
            }
        }
        types[types.length - 1] = WebViewCallback.class;
        return types;
    }

    private static Object[] getValues(Object[] parameters, WebViewCallback callback) throws JSONException {
        Object[] values;
        if (parameters != null) {
            values = new Object[(parameters.length + (callback != null ? 1 : 0))];
        } else if (callback == null) {
            return null;
        } else {
            values = new Object[1];
        }
        if (parameters != null) {
            System.arraycopy(parameters, 0, values, 0, parameters.length);
        }
        if (callback != null) {
            values[values.length - 1] = callback;
        }
        return values;
    }

    public static void handleInvocation(String className, String methodName, Object[] parameters, WebViewCallback callback) throws Exception {
        try {
            try {
                findMethod(className, methodName, parameters).invoke(null, getValues(parameters, callback));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e) {
                callback.error(WebViewBridgeError.INVOCATION_FAILED, className, methodName, parameters, e.getMessage());
                throw e;
            }
        } catch (NoSuchMethodException | JSONException e2) {
            callback.error(WebViewBridgeError.METHOD_NOT_FOUND, className, methodName, parameters);
            throw e2;
        }
    }

    public static void handleCallback(String callbackId, String callbackStatus, Object[] parameters) throws Exception {
        try {
            WebViewApp.getCurrentApp().getCallback(callbackId).invoke(callbackStatus, getValues(parameters, null));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e) {
            DeviceLog.error("Error while invoking method");
            throw e;
        }
    }
}
