package com.unity3d.services.p265ar.view;

import android.os.Bundle;
import android.view.View;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.ads.adunit.IAdUnitViewHandler;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.p265ar.ARCheck;

/* renamed from: com.unity3d.services.ar.view.ARViewHandler */
public class ARViewHandler implements IAdUnitViewHandler {
    private ARView _arView;

    public boolean create(AdUnitActivity activity) {
        if (ARCheck.isFrameworkPresent() && this._arView == null) {
            this._arView = new ARView(activity);
        }
        return true;
    }

    public boolean destroy() {
        ARView aRView = this._arView;
        if (aRView != null) {
            ViewUtilities.removeViewFromParent(aRView);
        }
        this._arView = null;
        return true;
    }

    public View getView() {
        return this._arView;
    }

    public void onCreate(AdUnitActivity activity, Bundle savedInstanceState) {
        create(activity);
    }

    public void onStart(AdUnitActivity activity) {
    }

    public void onStop(AdUnitActivity activity) {
    }

    public void onResume(AdUnitActivity activity) {
        ARView aRView = this._arView;
        if (aRView != null) {
            aRView.onResume();
        }
    }

    public void onPause(AdUnitActivity activity) {
        ARView aRView = this._arView;
        if (aRView != null) {
            aRView.onPause();
        }
    }

    public void onDestroy(AdUnitActivity activity) {
        if (activity.isFinishing()) {
            destroy();
        }
    }
}
