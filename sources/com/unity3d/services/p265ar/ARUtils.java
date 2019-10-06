package com.unity3d.services.p265ar;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.ArCoreApk.Availability;
import com.google.ar.core.Config;
import com.google.ar.core.Config.LightEstimationMode;
import com.google.ar.core.Config.PlaneFindingMode;
import com.google.ar.core.Config.UpdateMode;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableException;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unity3d.services.ar.ARUtils */
public class ARUtils {
    public static final int AR_CHECK_NOT_SUPPORTED = 0;
    public static final int AR_CHECK_SUPPORTED = 1;
    public static final int AR_CHECK_TRANSIENT = 2;
    private static LightEstimationMode[] lightEstimationModes;
    private static PlaneFindingMode[] planeFindingModes;
    private static UpdateMode[] updateModes;

    public static int isSupported(Context context) {
        if (!ARCheck.isFrameworkPresent()) {
            return 0;
        }
        if (planeFindingModes == null) {
            planeFindingModes = PlaneFindingMode.values();
            lightEstimationModes = LightEstimationMode.values();
            updateModes = UpdateMode.values();
        }
        Availability availability = ArCoreApk.getInstance().checkAvailability(context);
        if (availability.isTransient()) {
            return 2;
        }
        if (availability != Availability.SUPPORTED_INSTALLED) {
            return 0;
        }
        try {
            new Session(context);
        } catch (FatalException | UnavailableException e) {
            return 0;
        } catch (SecurityException e2) {
        }
        return 1;
    }

    public static Config createConfiguration(JSONObject properties, Session session) {
        Config config = new Config(session);
        String str = "lightEstimationMode";
        int i = 0;
        if (properties.has(str)) {
            try {
                String lightEstimationMode = properties.getString(str);
                LightEstimationMode[] lightEstimationModeArr = lightEstimationModes;
                int length = lightEstimationModeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    LightEstimationMode lem = lightEstimationModeArr[i2];
                    if (lightEstimationMode.equalsIgnoreCase(lem.name())) {
                        config.setLightEstimationMode(lem);
                        break;
                    }
                    i2++;
                }
            } catch (JSONException e) {
                DeviceLog.warning("lightEstimationEnabled is not a string.");
            }
        }
        String str2 = "planeFindingMode";
        if (properties.has(str2)) {
            try {
                String planeFindingMode = properties.getString(str2);
                PlaneFindingMode[] planeFindingModeArr = planeFindingModes;
                int length2 = planeFindingModeArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    PlaneFindingMode pfm = planeFindingModeArr[i3];
                    if (planeFindingMode.equalsIgnoreCase(pfm.name())) {
                        config.setPlaneFindingMode(pfm);
                        break;
                    }
                    i3++;
                }
            } catch (JSONException e2) {
                DeviceLog.warning("planeFindingMode is not a string.");
            }
        }
        String str3 = "updateMode";
        if (properties.has(str3)) {
            try {
                String updateMode = properties.getString(str3);
                UpdateMode[] updateModeArr = updateModes;
                int length3 = updateModeArr.length;
                while (true) {
                    if (i >= length3) {
                        break;
                    }
                    UpdateMode um = updateModeArr[i];
                    if (updateMode.equalsIgnoreCase(um.name())) {
                        config.setUpdateMode(um);
                        break;
                    }
                    i++;
                }
            } catch (JSONException e3) {
                DeviceLog.warning("updateMode is not a string.");
            }
        }
        return config;
    }

    @TargetApi(19)
    public static JSONObject getConfigEnums() {
        JSONObject enums = new JSONObject();
        try {
            ArrayList<String> values = new ArrayList<>();
            for (LightEstimationMode lem : LightEstimationMode.values()) {
                values.add(lem.name());
            }
            enums.put("lightEstimationMode", new JSONArray(values.toArray()));
            values.clear();
            for (PlaneFindingMode pfm : PlaneFindingMode.values()) {
                values.add(pfm.name());
            }
            enums.put("planeFindingMode", new JSONArray(values.toArray()));
            values.clear();
            for (UpdateMode um : UpdateMode.values()) {
                values.add(um.name());
            }
            enums.put("updateMode", new JSONArray(values.toArray()));
        } catch (JSONException e) {
        }
        return enums;
    }
}
