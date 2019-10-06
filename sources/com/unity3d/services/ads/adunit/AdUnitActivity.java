package com.unity3d.services.ads.adunit;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.ads.configuration.IAdsModuleConfiguration;
import com.unity3d.services.core.api.Intent;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

public class AdUnitActivity extends Activity {
    public static final String EXTRA_ACTIVITY_ID = "activityId";
    public static final String EXTRA_DISPLAY_CUTOUT_MODE = "displayCutoutMode";
    public static final String EXTRA_KEEP_SCREEN_ON = "keepScreenOn";
    public static final String EXTRA_KEY_EVENT_LIST = "keyEvents";
    public static final String EXTRA_ORIENTATION = "orientation";
    public static final String EXTRA_SYSTEM_UI_VISIBILITY = "systemUiVisibility";
    public static final String EXTRA_VIEWS = "views";
    private int _activityId;
    private int _displayCutoutMode;
    boolean _keepScreenOn;
    private ArrayList<Integer> _keyEventList;
    protected AdUnitRelativeLayout _layout;
    private int _orientation = -1;
    private int _systemUiVisibility;
    private Map<String, IAdUnitViewHandler> _viewHandlers;
    private String[] _views;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        AdUnitEvent event;
        super.onCreate(savedInstanceState);
        if (WebViewApp.getCurrentApp() == null) {
            DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onCreate");
            finish();
            return;
        }
        AdUnit.setAdUnitActivity(this);
        Intent.setActiveActivity(this);
        createLayout();
        ViewUtilities.removeViewFromParent(this._layout);
        AdUnitRelativeLayout adUnitRelativeLayout = this._layout;
        addContentView(adUnitRelativeLayout, adUnitRelativeLayout.getLayoutParams());
        String str = EXTRA_KEY_EVENT_LIST;
        String str2 = EXTRA_VIEWS;
        String str3 = EXTRA_DISPLAY_CUTOUT_MODE;
        String str4 = EXTRA_ACTIVITY_ID;
        String str5 = EXTRA_SYSTEM_UI_VISIBILITY;
        String str6 = EXTRA_ORIENTATION;
        if (savedInstanceState == null) {
            this._views = getIntent().getStringArrayExtra(str2);
            this._keyEventList = getIntent().getIntegerArrayListExtra(str);
            if (getIntent().hasExtra(str6)) {
                this._orientation = getIntent().getIntExtra(str6, -1);
            }
            if (getIntent().hasExtra(str5)) {
                this._systemUiVisibility = getIntent().getIntExtra(str5, 0);
            }
            if (getIntent().hasExtra(str4)) {
                this._activityId = getIntent().getIntExtra(str4, -1);
            }
            if (getIntent().hasExtra(str3)) {
                this._displayCutoutMode = getIntent().getIntExtra(str3, 0);
            }
            event = AdUnitEvent.ON_CREATE;
        } else {
            this._views = savedInstanceState.getStringArray(str2);
            this._orientation = savedInstanceState.getInt(str6, -1);
            this._systemUiVisibility = savedInstanceState.getInt(str5, 0);
            this._keyEventList = savedInstanceState.getIntegerArrayList(str);
            this._keepScreenOn = savedInstanceState.getBoolean(EXTRA_KEEP_SCREEN_ON);
            this._activityId = savedInstanceState.getInt(str4, -1);
            this._displayCutoutMode = savedInstanceState.getInt(str3, 0);
            setKeepScreenOn(this._keepScreenOn);
            event = AdUnitEvent.ON_RESTORE;
        }
        setOrientation(this._orientation);
        setSystemUiVisibility(this._systemUiVisibility);
        setLayoutInDisplayCutoutMode(this._displayCutoutMode);
        String[] strArr = this._views;
        if (strArr != null) {
            for (String viewName : strArr) {
                IAdUnitViewHandler handler = getViewHandler(viewName);
                if (handler != null) {
                    handler.onCreate(this, savedInstanceState);
                }
            }
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, event, Integer.valueOf(this._activityId));
    }

    public AdUnitRelativeLayout getLayout() {
        return this._layout;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onStart");
                finish();
            }
            return;
        }
        Map<String, IAdUnitViewHandler> map = this._viewHandlers;
        if (map != null) {
            for (Entry<String, IAdUnitViewHandler> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((IAdUnitViewHandler) entry.getValue()).onStart(this);
                }
            }
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_START, Integer.valueOf(this._activityId));
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onStop");
                finish();
            }
            return;
        }
        Map<String, IAdUnitViewHandler> map = this._viewHandlers;
        if (map != null) {
            for (Entry<String, IAdUnitViewHandler> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((IAdUnitViewHandler) entry.getValue()).onStop(this);
                }
            }
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_STOP, Integer.valueOf(this._activityId));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onResume");
                finish();
            }
            return;
        }
        setViews(this._views);
        Map<String, IAdUnitViewHandler> map = this._viewHandlers;
        if (map != null) {
            for (Entry<String, IAdUnitViewHandler> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((IAdUnitViewHandler) entry.getValue()).onResume(this);
                }
            }
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_RESUME, Integer.valueOf(this._activityId));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onPause");
                finish();
            }
            return;
        }
        if (isFinishing()) {
            ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
        }
        Map<String, IAdUnitViewHandler> map = this._viewHandlers;
        if (map != null) {
            for (Entry<String, IAdUnitViewHandler> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((IAdUnitViewHandler) entry.getValue()).onPause(this);
                }
            }
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_PAUSE, Boolean.valueOf(isFinishing()), Integer.valueOf(this._activityId));
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_ORIENTATION, this._orientation);
        outState.putInt(EXTRA_SYSTEM_UI_VISIBILITY, this._systemUiVisibility);
        outState.putIntegerArrayList(EXTRA_KEY_EVENT_LIST, this._keyEventList);
        outState.putBoolean(EXTRA_KEEP_SCREEN_ON, this._keepScreenOn);
        outState.putStringArray(EXTRA_VIEWS, this._views);
        outState.putInt(EXTRA_ACTIVITY_ID, this._activityId);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onDestroy");
                finish();
            }
            return;
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_DESTROY, Boolean.valueOf(isFinishing()), Integer.valueOf(this._activityId));
        Map<String, IAdUnitViewHandler> map = this._viewHandlers;
        if (map != null) {
            for (Entry<String, IAdUnitViewHandler> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((IAdUnitViewHandler) entry.getValue()).onDestroy(this);
                }
            }
        }
        if (AdUnit.getCurrentAdUnitActivityId() == this._activityId) {
            AdUnit.setAdUnitActivity(null);
        }
        Intent.removeActiveActivity(this);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        ArrayList<Integer> arrayList = this._keyEventList;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(keyCode))) {
            return false;
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.KEY_DOWN, Integer.valueOf(keyCode), Long.valueOf(event.getEventTime()), Long.valueOf(event.getDownTime()), Integer.valueOf(event.getRepeatCount()), Integer.valueOf(this._activityId));
        return true;
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_FOCUS_GAINED, Integer.valueOf(this._activityId));
        } else {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_FOCUS_LOST, Integer.valueOf(this._activityId));
        }
        super.onWindowFocusChanged(hasFocus);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        try {
            JSONArray permissionsArray = new JSONArray();
            JSONArray grantResultsArray = new JSONArray();
            for (String permission : permissions) {
                permissionsArray.put(permission);
            }
            for (int grantResult : grantResults) {
                grantResultsArray.put(grantResult);
            }
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.PERMISSIONS, PermissionsEvent.PERMISSIONS_RESULT, Integer.valueOf(requestCode), permissionsArray, grantResultsArray);
        } catch (Exception e) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.PERMISSIONS, PermissionsEvent.PERMISSIONS_ERROR, e.getMessage());
        }
    }

    public void setViewFrame(String view, int x, int y, int width, int height) {
        IAdUnitViewHandler handler = getViewHandler(view);
        View targetView = null;
        if (view.equals("adunit")) {
            LayoutParams params = new LayoutParams(width, height);
            params.setMargins(x, y, 0, 0);
            this._layout.setLayoutParams(params);
        } else if (handler != null) {
            targetView = handler.getView();
        }
        if (targetView != null) {
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(width, height);
            params2.setMargins(x, y, 0, 0);
            targetView.setLayoutParams(params2);
        }
    }

    public Map<String, Integer> getViewFrame(String view) {
        IAdUnitViewHandler handler = getViewHandler(view);
        View targetView = null;
        String str = "height";
        String str2 = "width";
        String str3 = "y";
        String str4 = "x";
        if (view.equals("adunit")) {
            LayoutParams params = (LayoutParams) this._layout.getLayoutParams();
            HashMap<String, Integer> map = new HashMap<>();
            map.put(str4, Integer.valueOf(params.leftMargin));
            map.put(str3, Integer.valueOf(params.topMargin));
            map.put(str2, Integer.valueOf(this._layout.getWidth()));
            map.put(str, Integer.valueOf(this._layout.getHeight()));
            return map;
        }
        if (handler != null) {
            targetView = handler.getView();
        }
        if (targetView == null) {
            return null;
        }
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) targetView.getLayoutParams();
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put(str4, Integer.valueOf(params2.leftMargin));
        map2.put(str3, Integer.valueOf(params2.topMargin));
        map2.put(str2, Integer.valueOf(targetView.getWidth()));
        map2.put(str, Integer.valueOf(targetView.getHeight()));
        return map2;
    }

    public void setViews(String[] views) {
        String[] actualViews;
        if (views == null) {
            actualViews = new String[0];
        } else {
            actualViews = views;
        }
        ArrayList<String> newViews = new ArrayList<>(Arrays.asList(actualViews));
        if (this._views == null) {
            this._views = new String[0];
        }
        ArrayList<String> removedViews = new ArrayList<>(Arrays.asList(this._views));
        removedViews.removeAll(newViews);
        Iterator it = removedViews.iterator();
        while (it.hasNext()) {
            getViewHandler((String) it.next()).destroy();
        }
        this._views = actualViews;
        for (String view : actualViews) {
            if (view != null) {
                IAdUnitViewHandler handler = getViewHandler(view);
                handler.create(this);
                if (!handleViewPlacement(handler.getView())) {
                    return;
                }
            }
        }
    }

    private boolean handleViewPlacement(View view) {
        if (view == null) {
            finish();
            DeviceLog.error("Could not place view because it is null, finishing activity");
            return false;
        }
        if (view.getParent() == null || !view.getParent().equals(this._layout)) {
            ViewUtilities.removeViewFromParent(view);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
            params.addRule(13);
            params.setMargins(0, 0, 0, 0);
            view.setPadding(0, 0, 0, 0);
            this._layout.addView(view, params);
        } else {
            this._layout.bringChildToFront(view);
        }
        return true;
    }

    public String[] getViews() {
        return this._views;
    }

    public void setOrientation(int orientation) {
        this._orientation = orientation;
        setRequestedOrientation(orientation);
    }

    public boolean setKeepScreenOn(boolean keepScreenOn) {
        this._keepScreenOn = keepScreenOn;
        if (getWindow() == null) {
            return false;
        }
        if (keepScreenOn) {
            getWindow().addFlags(128);
        } else {
            getWindow().clearFlags(128);
        }
        return true;
    }

    public boolean setSystemUiVisibility(int flags) {
        this._systemUiVisibility = flags;
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while setting SystemUIVisibility", e);
            return false;
        }
    }

    public void setKeyEventList(ArrayList<Integer> keyevents) {
        this._keyEventList = keyevents;
    }

    public IAdUnitViewHandler getViewHandler(String name) {
        Map<String, IAdUnitViewHandler> map = this._viewHandlers;
        if (map != null && map.containsKey(name)) {
            return (IAdUnitViewHandler) this._viewHandlers.get(name);
        }
        IAdUnitViewHandler viewHandler = createViewHandler(name);
        if (viewHandler == null) {
            return viewHandler;
        }
        if (this._viewHandlers == null) {
            this._viewHandlers = new HashMap();
        }
        this._viewHandlers.put(name, viewHandler);
        return viewHandler;
    }

    public void setLayoutInDisplayCutoutMode(int flags) {
        this._displayCutoutMode = flags;
        if (VERSION.SDK_INT >= 28 && getWindow() != null) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            try {
                lp.getClass().getField("layoutInDisplayCutoutMode").setInt(lp, flags);
            } catch (IllegalAccessException e) {
                DeviceLog.debug("Error setting layoutInDisplayCutoutMode", e);
            } catch (NoSuchFieldException e2) {
                DeviceLog.debug("Error getting layoutInDisplayCutoutMode", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void createLayout() {
        if (this._layout == null) {
            this._layout = new AdUnitRelativeLayout(this);
            this._layout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ViewUtilities.setBackground(this._layout, new ColorDrawable(CtaButton.BACKGROUND_COLOR));
        }
    }

    private IAdUnitViewHandler createViewHandler(String name) {
        if (WebViewApp.getCurrentApp() != null) {
            Configuration configuration = WebViewApp.getCurrentApp().getConfiguration();
            for (String moduleName : configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfig = configuration.getModuleConfiguration(moduleName);
                if (moduleConfig instanceof IAdsModuleConfiguration) {
                    Map<String, Class> adUnitViewHandlers = ((IAdsModuleConfiguration) moduleConfig).getAdUnitViewHandlers();
                    if (adUnitViewHandlers != null && adUnitViewHandlers.containsKey(name)) {
                        IAdUnitViewHandler viewHandler = null;
                        try {
                            viewHandler = (IAdUnitViewHandler) ((Class) adUnitViewHandlers.get(name)).newInstance();
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error creating view: ");
                            sb.append(name);
                            DeviceLog.error(sb.toString());
                        }
                        return viewHandler;
                    }
                }
            }
        }
        return null;
    }
}
