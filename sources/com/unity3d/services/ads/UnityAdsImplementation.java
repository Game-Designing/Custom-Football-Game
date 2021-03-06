package com.unity3d.services.ads;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.services.IUnityServicesListener;
import com.unity3d.services.UnityServices;
import com.unity3d.services.UnityServices.UnityServicesError;
import com.unity3d.services.ads.adunit.AdUnitOpen;
import com.unity3d.services.ads.placement.Placement;
import com.unity3d.services.ads.properties.AdsProperties;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import org.json.JSONException;
import org.json.JSONObject;

public final class UnityAdsImplementation {
    public static void initialize(Activity activity, String gameId, IUnityAdsListener listener) {
        initialize(activity, gameId, listener, false);
    }

    public static void initialize(Activity activity, String gameId, final IUnityAdsListener listener, boolean testMode) {
        DeviceLog.entered();
        AdsProperties.setListener(listener);
        UnityServices.initialize(activity, gameId, new IUnityServicesListener() {
            public void onUnityServicesError(UnityServicesError error, String message) {
                if (error == UnityServicesError.INIT_SANITY_CHECK_FAIL) {
                    listener.onUnityAdsError(UnityAdsError.INIT_SANITY_CHECK_FAIL, message);
                } else if (error == UnityServicesError.INVALID_ARGUMENT) {
                    listener.onUnityAdsError(UnityAdsError.INVALID_ARGUMENT, message);
                }
            }
        }, testMode);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    public static void setListener(IUnityAdsListener listener) {
        AdsProperties.setListener(listener);
    }

    public static IUnityAdsListener getListener() {
        return AdsProperties.getListener();
    }

    public static boolean isSupported() {
        return UnityServices.isSupported();
    }

    public static String getVersion() {
        return UnityServices.getVersion();
    }

    public static boolean isReady() {
        return isSupported() && isInitialized() && Placement.isReady();
    }

    public static boolean isReady(String placementId) {
        return isSupported() && isInitialized() && placementId != null && Placement.isReady(placementId);
    }

    public static PlacementState getPlacementState() {
        if (!isSupported() || !isInitialized()) {
            return PlacementState.NOT_AVAILABLE;
        }
        return Placement.getPlacementState();
    }

    public static PlacementState getPlacementState(String placementId) {
        if (!isSupported() || !isInitialized() || placementId == null) {
            return PlacementState.NOT_AVAILABLE;
        }
        return Placement.getPlacementState(placementId);
    }

    public static void show(Activity activity) {
        if (Placement.getDefaultPlacement() != null) {
            show(activity, Placement.getDefaultPlacement());
            return;
        }
        handleShowError("", UnityAdsError.NOT_INITIALIZED, "Unity Ads default placement is not initialized");
    }

    public static void show(final Activity activity, final String placementId) {
        if (activity == null) {
            handleShowError(placementId, UnityAdsError.INVALID_ARGUMENT, "Activity must not be null");
            return;
        }
        if (isReady(placementId)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads opening new ad unit for placement ");
            sb.append(placementId);
            DeviceLog.info(sb.toString());
            ClientProperties.setActivity(activity);
            new Thread(new Runnable() {
                public void run() {
                    Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                    JSONObject options = new JSONObject();
                    try {
                        options.put("requestedOrientation", activity.getRequestedOrientation());
                        JSONObject display = new JSONObject();
                        display.put("rotation", defaultDisplay.getRotation());
                        String str = "height";
                        String str2 = "width";
                        if (VERSION.SDK_INT >= 13) {
                            Point displaySize = new Point();
                            defaultDisplay.getSize(displaySize);
                            display.put(str2, displaySize.x);
                            display.put(str, displaySize.y);
                        } else {
                            display.put(str2, defaultDisplay.getWidth());
                            display.put(str, defaultDisplay.getHeight());
                        }
                        options.put("display", display);
                    } catch (JSONException e) {
                        DeviceLog.exception("JSON error while constructing show options", e);
                    }
                    try {
                        if (!AdUnitOpen.open(placementId, options)) {
                            UnityAdsImplementation.handleShowError(placementId, UnityAdsError.INTERNAL_ERROR, "Webapp timeout, shutting down Unity Ads");
                        }
                    } catch (NoSuchMethodException exception) {
                        DeviceLog.exception("Could not get callback method", exception);
                        UnityAdsImplementation.handleShowError(placementId, UnityAdsError.SHOW_ERROR, "Could not get com.unity3d.ads.properties.showCallback method");
                    }
                }
            }).start();
        } else if (!isSupported()) {
            handleShowError(placementId, UnityAdsError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
        } else if (!isInitialized()) {
            handleShowError(placementId, UnityAdsError.NOT_INITIALIZED, "Unity Ads is not initialized");
        } else {
            UnityAdsError unityAdsError = UnityAdsError.SHOW_ERROR;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Placement \"");
            sb2.append(placementId);
            sb2.append("\" is not ready");
            handleShowError(placementId, unityAdsError, sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public static void handleShowError(final String placementId, final UnityAdsError error, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unity Ads show failed: ");
        sb.append(message);
        final String errorMessage = sb.toString();
        DeviceLog.error(errorMessage);
        final IUnityAdsListener listener = AdsProperties.getListener();
        if (listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    listener.onUnityAdsError(error, errorMessage);
                    String str = placementId;
                    if (str != null) {
                        listener.onUnityAdsFinish(str, FinishState.ERROR);
                        return;
                    }
                    listener.onUnityAdsFinish("", FinishState.ERROR);
                }
            });
        }
    }

    public static void setDebugMode(boolean debugMode) {
        UnityServices.setDebugMode(debugMode);
    }

    public static boolean getDebugMode() {
        return UnityServices.getDebugMode();
    }
}
