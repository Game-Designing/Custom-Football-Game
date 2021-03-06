package com.unity3d.services.banners.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unity3d.services.ads.webplayer.WebPlayer;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class BannerView extends RelativeLayout {
    private static final String VIEW_BANNER = "banner";
    private static final String VIEW_BANNER_PLAYER = "bannerplayer";
    private static final String VIEW_WEB_VIEW = "webview";
    private static BannerView _instance;
    private static JSONObject _webPlayerEventSettings = new JSONObject();
    private static JSONObject _webPlayerSettings = new JSONObject();
    private static JSONObject _webSettings = new JSONObject();
    private int _lastVisibility = -1;
    private List<String> _views;
    private WebPlayer _webPlayer;
    private int height;
    private BannerPosition position;
    private int width;

    public BannerView(Context context) {
        super(context);
        this._webPlayer = new WebPlayer(context, VIEW_BANNER_PLAYER, _webSettings, _webPlayerSettings);
        this._webPlayer.setEventSettings(_webPlayerEventSettings);
        if (VERSION.SDK_INT >= 11) {
            addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    BannerView.this.onLayoutChange(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom);
                }
            });
        }
    }

    public static void setWebPlayerEventSettings(JSONObject webPlayerEventSettings) {
        _webPlayerEventSettings = webPlayerEventSettings;
    }

    public static void setWebPlayerSettings(JSONObject webSettings, JSONObject webPlayerSettings) {
        _webSettings = webSettings;
        _webPlayerSettings = webPlayerSettings;
    }

    public void destroy() {
        removeAllViews();
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        this._webPlayer = null;
        _instance = null;
    }

    public static BannerView getOrCreateInstance() {
        if (_instance == null) {
            _instance = new BannerView(ClientProperties.getApplicationContext());
        }
        return _instance;
    }

    public static BannerView getInstance() {
        return _instance;
    }

    public void setViews(List<String> views) {
        List<String> viewsToAdd = new ArrayList<>(views);
        List<String> viewsToRemove = new ArrayList<>();
        List<String> list = this._views;
        if (list != null) {
            viewsToRemove.addAll(list);
            viewsToRemove.removeAll(views);
            viewsToAdd.removeAll(this._views);
        }
        this._views = views;
        for (String view : viewsToRemove) {
            removeView(view);
        }
        for (String view2 : viewsToAdd) {
            addView(view2);
        }
    }

    private void removeView(String viewName) {
        View view = getViewForName(viewName);
        if (view != null) {
            ViewUtilities.removeViewFromParent(view);
        }
        char c = 65535;
        if (viewName.hashCode() == 1497041165 && viewName.equals(VIEW_BANNER_PLAYER)) {
            c = 0;
        }
        if (c == 0) {
            this._webPlayer = null;
        }
    }

    private void addView(String viewName) {
        View view = getViewForName(viewName);
        if (view != null) {
            addView(view, new LayoutParams(-1, -1));
            return;
        }
        DeviceLog.warning("No view defined for viewName: %s", viewName);
    }

    public WebPlayer getWebPlayer() {
        return this._webPlayer;
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        if (params != null) {
            params.width = this.width;
            params.height = this.height;
            super.setLayoutParams(LayoutParamsHelper.updateLayoutParamsForPosition(params, this.position));
        }
    }

    public void setViewFrame(String viewName, Integer x, Integer y, Integer width2, Integer height2) {
        View view = getViewForName(viewName);
        if (view != null) {
            if (view == this) {
                DeviceLog.warning("Not setting viewFrame for banner, use `setLayoutParams` instead.");
            } else {
                LayoutParams params = new LayoutParams(width2.intValue(), height2.intValue());
                params.setMargins(x.intValue(), y.intValue(), 0, 0);
                view.setLayoutParams(params);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebViewApp app = WebViewApp.getCurrentApp();
        if (app != null) {
            app.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_ATTACHED, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WebViewApp app = WebViewApp.getCurrentApp();
        if (app != null) {
            app.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DETACHED, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (oldw != 0 || oldh != 0) {
            int left = getLeft();
            int right = getRight();
            float alpha = 1.0f;
            if (VERSION.SDK_INT >= 11) {
                alpha = getAlpha();
            }
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_RESIZED, Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(w), Integer.valueOf(h), Float.valueOf(alpha));
            Rect rect = new Rect();
            getHitRect(rect);
            if (((View) getParent()).getLocalVisibleRect(rect)) {
                onVisibilityChanged(this, 8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        if (changedView == this) {
            int i = this._lastVisibility;
            if (i == -1) {
                this._lastVisibility = visibility;
                return;
            }
            if (visibility != 0 && i == 0) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_VISIBILITY_CHANGED, Integer.valueOf(visibility));
            }
            this._lastVisibility = visibility;
        }
    }

    private View getViewForName(String name) {
        if (name.equals(VIEW_BANNER_PLAYER)) {
            return this._webPlayer;
        }
        if (name.equals(VIEW_WEB_VIEW)) {
            return WebViewApp.getCurrentApp().getWebView();
        }
        if (name.equals(VIEW_BANNER)) {
            return this;
        }
        return null;
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        float alpha = 1.0f;
        if (VERSION.SDK_INT >= 11) {
            alpha = getAlpha();
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_RESIZED, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Float.valueOf(alpha));
        if (getParent() != null) {
            Rect rect = new Rect();
            getHitRect(rect);
            if ((getParent() instanceof View) && !((View) getParent()).getLocalVisibleRect(rect)) {
                onVisibilityChanged(this, 8);
            }
        }
    }

    public void setAlpha(float alpha) {
        super.setAlpha(alpha);
        onLayoutChange(this, getLeft(), getTop(), getRight(), getBottom(), getLeft(), getTop(), getRight(), getBottom());
    }

    public void setBannerDimensions(int width2, int height2, BannerPosition position2) {
        this.width = width2;
        this.height = height2;
        this.position = position2;
    }
}
