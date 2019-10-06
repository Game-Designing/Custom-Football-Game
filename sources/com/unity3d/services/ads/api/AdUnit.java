package com.unity3d.services.ads.api;

import android.content.Intent;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.WindowInsets;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.ads.adunit.AdUnitError;
import com.unity3d.services.ads.adunit.AdUnitMotionEvent;
import com.unity3d.services.ads.adunit.AdUnitSoftwareActivity;
import com.unity3d.services.ads.adunit.AdUnitTransparentActivity;
import com.unity3d.services.ads.adunit.AdUnitTransparentSoftwareActivity;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdUnit {
    private static AdUnitActivity _adUnitActivity;
    private static int _currentActivityId = -1;

    private AdUnit() {
    }

    public static void setAdUnitActivity(AdUnitActivity activity) {
        _adUnitActivity = activity;
    }

    public static AdUnitActivity getAdUnitActivity() {
        return _adUnitActivity;
    }

    public static int getCurrentAdUnitActivityId() {
        return _currentActivityId;
    }

    public static void setCurrentAdUnitActivityId(int activityId) {
        _currentActivityId = activityId;
    }

    @WebViewExposed
    public static void open(Integer activityId, JSONArray views, Integer orientation, WebViewCallback callback) {
        open(activityId, views, orientation, null, callback);
    }

    @WebViewExposed
    public static void open(Integer activityId, JSONArray views, Integer orientation, JSONArray keyevents, WebViewCallback callback) {
        open(activityId, views, orientation, keyevents, Integer.valueOf(0), Boolean.valueOf(true), callback);
    }

    @WebViewExposed
    public static void open(Integer activityId, JSONArray views, Integer orientation, JSONArray keyevents, Integer systemUiVisibility, Boolean hardwareAcceleration, WebViewCallback callback) {
        open(activityId, views, orientation, keyevents, systemUiVisibility, hardwareAcceleration, Boolean.valueOf(false), callback);
    }

    @WebViewExposed
    public static void open(Integer activityId, JSONArray views, Integer orientation, JSONArray keyevents, Integer systemUiVisibility, Boolean hardwareAcceleration, Boolean isTransparent, WebViewCallback callback) {
        open(activityId, views, orientation, keyevents, systemUiVisibility, hardwareAcceleration, isTransparent, Integer.valueOf(0), callback);
    }

    @WebViewExposed
    public static void open(Integer activityId, JSONArray views, Integer orientation, JSONArray keyevents, Integer systemUiVisibility, Boolean hardwareAcceleration, Boolean isTransparent, Integer displayCutoutMode, WebViewCallback callback) {
        Intent intent;
        WebViewCallback webViewCallback = callback;
        String str = "Error parsing views from viewList";
        if (!hardwareAcceleration.booleanValue() && isTransparent.booleanValue()) {
            DeviceLog.debug("Unity Ads opening new transparent ad unit activity, hardware acceleration disabled");
            intent = new Intent(ClientProperties.getActivity(), AdUnitTransparentSoftwareActivity.class);
        } else if (hardwareAcceleration.booleanValue() && !isTransparent.booleanValue()) {
            DeviceLog.debug("Unity Ads opening new hardware accelerated ad unit activity");
            intent = new Intent(ClientProperties.getActivity(), AdUnitActivity.class);
        } else if (!hardwareAcceleration.booleanValue() || !isTransparent.booleanValue()) {
            DeviceLog.debug("Unity Ads opening new ad unit activity, hardware acceleration disabled");
            intent = new Intent(ClientProperties.getActivity(), AdUnitSoftwareActivity.class);
        } else {
            DeviceLog.debug("Unity Ads opening new hardware accelerated transparent ad unit activity");
            intent = new Intent(ClientProperties.getActivity(), AdUnitTransparentActivity.class);
        }
        intent.addFlags(268500992);
        if (activityId != null) {
            try {
                intent.putExtra(AdUnitActivity.EXTRA_ACTIVITY_ID, activityId.intValue());
                setCurrentAdUnitActivityId(activityId.intValue());
                try {
                    intent.putExtra(AdUnitActivity.EXTRA_VIEWS, getViewList(views));
                    if (keyevents != null) {
                        try {
                            intent.putExtra(AdUnitActivity.EXTRA_KEY_EVENT_LIST, getKeyEventList(keyevents));
                        } catch (Exception e) {
                            DeviceLog.exception(str, e);
                            webViewCallback.error(AdUnitError.CORRUPTED_KEYEVENTLIST, keyevents, e.getMessage());
                            return;
                        }
                    }
                    intent.putExtra(AdUnitActivity.EXTRA_SYSTEM_UI_VISIBILITY, systemUiVisibility);
                    Integer num = orientation;
                    intent.putExtra(AdUnitActivity.EXTRA_ORIENTATION, orientation);
                    intent.putExtra(AdUnitActivity.EXTRA_DISPLAY_CUTOUT_MODE, displayCutoutMode);
                    ClientProperties.getActivity().startActivity(intent);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Opened AdUnitActivity with: ");
                    sb.append(views.toString());
                    DeviceLog.debug(sb.toString());
                    webViewCallback.invoke(new Object[0]);
                } catch (Exception e2) {
                    Integer num2 = orientation;
                    Integer num3 = systemUiVisibility;
                    Integer num4 = displayCutoutMode;
                    DeviceLog.exception(str, e2);
                    webViewCallback.error(AdUnitError.CORRUPTED_VIEWLIST, views, e2.getMessage());
                }
            } catch (Exception e3) {
                Integer num5 = orientation;
                Integer num6 = systemUiVisibility;
                Integer num7 = displayCutoutMode;
                DeviceLog.exception("Could not set activityId for intent", e3);
                webViewCallback.error(AdUnitError.ACTIVITY_ID, Integer.valueOf(activityId.intValue()), e3.getMessage());
            }
        } else {
            Integer num8 = orientation;
            Integer num9 = systemUiVisibility;
            Integer num10 = displayCutoutMode;
            DeviceLog.error("Activity ID is NULL");
            webViewCallback.error(AdUnitError.ACTIVITY_ID, "Activity ID NULL");
        }
    }

    @WebViewExposed
    public static void close(WebViewCallback callback) {
        if (getAdUnitActivity() != null) {
            getAdUnitActivity().finish();
            callback.invoke(new Object[0]);
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setViews(final JSONArray views, WebViewCallback callback) {
        boolean corrupted = false;
        try {
            String[] viewList = getViewList(views);
        } catch (JSONException e) {
            callback.error(AdUnitError.CORRUPTED_VIEWLIST, views);
            corrupted = true;
        }
        if (!corrupted) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    if (AdUnit.getAdUnitActivity() != null) {
                        try {
                            AdUnit.getAdUnitActivity().setViews(AdUnit.getViewList(views));
                        } catch (Exception e) {
                            DeviceLog.exception("Corrupted viewlist", e);
                        }
                    }
                }
            });
        }
        if (getAdUnitActivity() != null) {
            callback.invoke(views);
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void getViews(WebViewCallback callback) {
        if (getAdUnitActivity() != null) {
            callback.invoke(new JSONArray(Arrays.asList(getAdUnitActivity().getViews())));
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setOrientation(final Integer orientation, WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setOrientation(orientation.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            callback.invoke(orientation);
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void getOrientation(WebViewCallback callback) {
        if (getAdUnitActivity() != null) {
            callback.invoke(Integer.valueOf(getAdUnitActivity().getRequestedOrientation()));
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setKeepScreenOn(final Boolean screenOn, WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setKeepScreenOn(screenOn.booleanValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setSystemUiVisibility(final Integer systemUiVisibility, WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setSystemUiVisibility(systemUiVisibility.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            callback.invoke(systemUiVisibility);
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setKeyEventList(JSONArray keyevents, WebViewCallback callback) {
        if (getAdUnitActivity() != null) {
            try {
                getAdUnitActivity().setKeyEventList(getKeyEventList(keyevents));
                callback.invoke(keyevents);
            } catch (Exception e) {
                DeviceLog.exception("Error parsing views from viewList", e);
                callback.error(AdUnitError.CORRUPTED_KEYEVENTLIST, keyevents, e.getMessage());
            }
        } else {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setViewFrame(String view, Integer x, Integer y, Integer width, Integer height, WebViewCallback callback) {
        final String str = view;
        final Integer num = x;
        final Integer num2 = y;
        final Integer num3 = width;
        final Integer num4 = height;
        C125665 r0 = new Runnable() {
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setViewFrame(str, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }
            }
        };
        Utilities.runOnUiThread(r0);
        if (getAdUnitActivity() != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getViewFrame(String view, WebViewCallback callback) {
        if (getAdUnitActivity() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getViewFrame(view) != null) {
            Map<String, Integer> map = getAdUnitActivity().getViewFrame(view);
            callback.invoke(map.get("x"), map.get("y"), map.get("width"), map.get("height"));
        } else {
            callback.error(AdUnitError.UNKNOWN_VIEW, new Object[0]);
        }
    }

    @WebViewExposed
    public static void startMotionEventCapture(Integer maxEvents, WebViewCallback callback) {
        if (getAdUnitActivity() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout() != null) {
            getAdUnitActivity().getLayout().startCapture(maxEvents.intValue());
            callback.invoke(new Object[0]);
        } else {
            callback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void endMotionEventCapture(WebViewCallback callback) {
        if (getAdUnitActivity() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout() != null) {
            getAdUnitActivity().getLayout().endCapture();
            callback.invoke(new Object[0]);
        } else {
            callback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void clearMotionEventCapture(WebViewCallback callback) {
        if (getAdUnitActivity() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout() != null) {
            getAdUnitActivity().getLayout().clearCapture();
            callback.invoke(new Object[0]);
        } else {
            callback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getMotionEventCount(JSONArray eventTypes, WebViewCallback callback) {
        ArrayList<Integer> requestedEventTypes = new ArrayList<>();
        for (int i = 0; i < eventTypes.length(); i++) {
            try {
                requestedEventTypes.add(Integer.valueOf(eventTypes.getInt(i)));
            } catch (Exception e) {
                DeviceLog.exception("Error retrieving int from eventTypes", e);
            }
        }
        if (getAdUnitActivity() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout() == null) {
            callback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout().getCurrentEventCount() >= getAdUnitActivity().getLayout().getMaxEventCount()) {
            callback.error(AdUnitError.MAX_MOTION_EVENT_COUNT_REACHED, new Object[0]);
        } else {
            SparseIntArray counts = getAdUnitActivity().getLayout().getEventCount(requestedEventTypes);
            JSONObject retObj = new JSONObject();
            for (int i2 = 0; i2 < counts.size(); i2++) {
                int key = counts.keyAt(i2);
                try {
                    retObj.put(Integer.toString(key), counts.get(key));
                } catch (Exception e2) {
                    DeviceLog.exception("Error building response JSON", e2);
                }
            }
            callback.invoke(retObj);
        }
    }

    @WebViewExposed
    public static void getMotionEventData(JSONObject infoIndices, WebViewCallback callback) {
        int key;
        WebViewCallback webViewCallback = callback;
        Iterator<String> infoIterator = infoIndices.keys();
        SparseArray sparseArray = new SparseArray();
        while (infoIterator.hasNext()) {
            String key2 = (String) infoIterator.next();
            int keyInt = Integer.parseInt(key2);
            if (sparseArray.get(keyInt) == null) {
                sparseArray.put(keyInt, new ArrayList());
            }
            JSONArray keyIndices = null;
            try {
                keyIndices = infoIndices.getJSONArray(key2);
            } catch (Exception e) {
                DeviceLog.exception("Couldn't fetch keyIndices", e);
            }
            if (keyIndices != null) {
                for (int i = 0; i < keyIndices.length(); i++) {
                    try {
                        ((ArrayList) sparseArray.get(keyInt)).add(Integer.valueOf(keyIndices.getInt(i)));
                    } catch (Exception e2) {
                        DeviceLog.exception("Couldn't add value to requested infos", e2);
                    }
                }
            }
        }
        JSONObject jSONObject = infoIndices;
        if (getAdUnitActivity() == null) {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout() == null) {
            webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout().getCurrentEventCount() >= getAdUnitActivity().getLayout().getMaxEventCount()) {
            webViewCallback.error(AdUnitError.MAX_MOTION_EVENT_COUNT_REACHED, new Object[0]);
        } else {
            SparseArray<SparseArray<AdUnitMotionEvent>> eventInfos = getAdUnitActivity().getLayout().getEvents(sparseArray);
            JSONObject infoObj = new JSONObject();
            for (int eventTypeIndex = 0; eventTypeIndex < eventInfos.size(); eventTypeIndex++) {
                int key3 = eventInfos.keyAt(eventTypeIndex);
                SparseArray<AdUnitMotionEvent> values = (SparseArray) eventInfos.get(key3);
                JSONObject typeObj = new JSONObject();
                int motionEventIndex = 0;
                while (motionEventIndex < values.size()) {
                    JSONObject eventObj = new JSONObject();
                    int eventKey = values.keyAt(motionEventIndex);
                    AdUnitMotionEvent motionEvent = (AdUnitMotionEvent) values.get(eventKey);
                    try {
                        eventObj.put("action", motionEvent.getAction());
                        eventObj.put("isObscured", motionEvent.isObscured());
                        eventObj.put("toolType", motionEvent.getToolType());
                        eventObj.put("source", motionEvent.getSource());
                        eventObj.put("deviceId", motionEvent.getDeviceId());
                        key = key3;
                        try {
                            eventObj.put("x", (double) motionEvent.getX());
                            eventObj.put("y", (double) motionEvent.getY());
                            eventObj.put("eventTime", motionEvent.getEventTime());
                            eventObj.put("pressure", (double) motionEvent.getPressure());
                            eventObj.put("size", (double) motionEvent.getSize());
                            typeObj.put(Integer.toString(eventKey), eventObj);
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        key = key3;
                        DeviceLog.debug("Couldn't construct event info", e);
                        motionEventIndex++;
                        key3 = key;
                    }
                    motionEventIndex++;
                    key3 = key;
                }
                try {
                    infoObj.put(Integer.toString(key3), typeObj);
                } catch (Exception e5) {
                    DeviceLog.debug("Couldn't construct info object", e5);
                }
            }
            webViewCallback.invoke(infoObj);
        }
    }

    @WebViewExposed
    public static void getCurrentMotionEventCount(WebViewCallback callback) {
        if (getAdUnitActivity() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (getAdUnitActivity().getLayout() != null) {
            callback.invoke(Integer.valueOf(getAdUnitActivity().getLayout().getCurrentEventCount()));
        } else {
            callback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getSafeAreaInsets(WebViewCallback callback) {
        if (getAdUnitActivity() == null || getAdUnitActivity().getLayout() == null) {
            callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        } else if (VERSION.SDK_INT >= 28) {
            WindowInsets windowInsets = getAdUnitActivity().getLayout().getRootWindowInsets();
            if (windowInsets != null) {
                JSONObject displayCutoutObject = new JSONObject();
                try {
                    Object displayCutout = windowInsets.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(windowInsets, new Object[0]);
                    if (displayCutout != null) {
                        Object safeInsetTop = displayCutout.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(displayCutout, new Object[0]);
                        Object safeInsetRight = displayCutout.getClass().getMethod("getSafeInsetRight", new Class[0]).invoke(displayCutout, new Object[0]);
                        Object safeInsetBottom = displayCutout.getClass().getMethod("getSafeInsetBottom", new Class[0]).invoke(displayCutout, new Object[0]);
                        Object safeInsetLeft = displayCutout.getClass().getMethod("getSafeInsetLeft", new Class[0]).invoke(displayCutout, new Object[0]);
                        displayCutoutObject.put("top", safeInsetTop);
                        displayCutoutObject.put("right", safeInsetRight);
                        displayCutoutObject.put("bottom", safeInsetBottom);
                        displayCutoutObject.put("left", safeInsetLeft);
                        callback.invoke(displayCutoutObject);
                        return;
                    }
                    callback.error(AdUnitError.NO_DISPLAY_CUTOUT_AVAILABLE, new Object[0]);
                } catch (NoSuchMethodException e) {
                    callback.error(AdUnitError.DISPLAY_CUTOUT_METHOD_NOT_AVAILABLE, new Object[0]);
                    DeviceLog.debug("Method getDisplayCutout not found", e);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    callback.error(AdUnitError.DISPLAY_CUTOUT_INVOKE_FAILED, new Object[0]);
                    DeviceLog.debug("Error while calling displayCutout getter", e2);
                } catch (JSONException e3) {
                    callback.error(AdUnitError.DISPLAY_CUTOUT_JSON_ERROR, new Object[0]);
                    DeviceLog.debug("JSON error while constructing display cutout object", e3);
                }
            } else {
                callback.error(AdUnitError.NO_DISPLAY_CUTOUT_AVAILABLE, new Object[0]);
            }
        } else {
            callback.error(AdUnitError.API_LEVEL_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setLayoutInDisplayCutoutMode(final Integer displayCutoutMode, WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setLayoutInDisplayCutoutMode(displayCutoutMode.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            callback.invoke(displayCutoutMode);
            return;
        }
        callback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    /* access modifiers changed from: private */
    public static String[] getViewList(JSONArray views) throws JSONException {
        String[] viewList = new String[views.length()];
        for (int viewidx = 0; viewidx < views.length(); viewidx++) {
            viewList[viewidx] = views.getString(viewidx);
        }
        return viewList;
    }

    private static ArrayList<Integer> getKeyEventList(JSONArray keyevents) throws JSONException {
        ArrayList<Integer> keyEvents = new ArrayList<>();
        for (Integer idx = Integer.valueOf(0); idx.intValue() < keyevents.length(); idx = Integer.valueOf(idx.intValue() + 1)) {
            keyEvents.add(Integer.valueOf(keyevents.getInt(idx.intValue())));
        }
        return keyEvents;
    }
}
