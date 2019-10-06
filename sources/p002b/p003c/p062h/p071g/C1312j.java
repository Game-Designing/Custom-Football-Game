package p002b.p003c.p062h.p071g;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* renamed from: b.c.h.g.j */
/* compiled from: WindowCallbackWrapper */
public class C1312j implements Callback {

    /* renamed from: a */
    final Callback f4194a;

    public C1312j(Callback wrapped) {
        if (wrapped != null) {
            this.f4194a = wrapped;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return this.f4194a.dispatchKeyEvent(event);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return this.f4194a.dispatchKeyShortcutEvent(event);
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        return this.f4194a.dispatchTouchEvent(event);
    }

    public boolean dispatchTrackballEvent(MotionEvent event) {
        return this.f4194a.dispatchTrackballEvent(event);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return this.f4194a.dispatchGenericMotionEvent(event);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return this.f4194a.dispatchPopulateAccessibilityEvent(event);
    }

    public View onCreatePanelView(int featureId) {
        return this.f4194a.onCreatePanelView(featureId);
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return this.f4194a.onCreatePanelMenu(featureId, menu);
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return this.f4194a.onPreparePanel(featureId, view, menu);
    }

    public boolean onMenuOpened(int featureId, Menu menu) {
        return this.f4194a.onMenuOpened(featureId, menu);
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return this.f4194a.onMenuItemSelected(featureId, item);
    }

    public void onWindowAttributesChanged(LayoutParams attrs) {
        this.f4194a.onWindowAttributesChanged(attrs);
    }

    public void onContentChanged() {
        this.f4194a.onContentChanged();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        this.f4194a.onWindowFocusChanged(hasFocus);
    }

    public void onAttachedToWindow() {
        this.f4194a.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f4194a.onDetachedFromWindow();
    }

    public void onPanelClosed(int featureId, Menu menu) {
        this.f4194a.onPanelClosed(featureId, menu);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f4194a.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.f4194a.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f4194a.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return this.f4194a.onWindowStartingActionMode(callback, type);
    }

    public void onActionModeStarted(ActionMode mode) {
        this.f4194a.onActionModeStarted(mode);
    }

    public void onActionModeFinished(ActionMode mode) {
        this.f4194a.onActionModeFinished(mode);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        this.f4194a.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
        this.f4194a.onPointerCaptureChanged(hasCapture);
    }
}
