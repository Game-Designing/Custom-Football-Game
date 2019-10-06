package android.support.p001v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0445Y;
import android.support.p000v4.app.C0453b;
import android.support.p000v4.app.C0473ia;
import android.support.p000v4.app.C0473ia.C0013a;
import android.support.p001v7.widget.C0930Fb;
import android.support.p001v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;

/* renamed from: android.support.v7.app.n */
/* compiled from: AppCompatActivity */
public class C0019n extends C0014p implements C0020o, C0013a, C0018c {
    private C0776p mDelegate;
    private Resources mResources;
    private int mThemeId = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        C0776p delegate = getDelegate();
        delegate.mo6105f();
        delegate.mo6082a(savedInstanceState);
        if (delegate.mo6243a()) {
            int i = this.mThemeId;
            if (i != 0) {
                if (VERSION.SDK_INT >= 23) {
                    onApplyThemeResource(getTheme(), this.mThemeId, false);
                } else {
                    setTheme(i);
                }
            }
        }
        super.onCreate(savedInstanceState);
    }

    public void setTheme(int resid) {
        super.setTheme(resid);
        this.mThemeId = resid;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().mo6094b(savedInstanceState);
    }

    public C0760a getSupportActionBar() {
        return getDelegate().mo6247e();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().mo6084a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().mo6246d();
    }

    public void setContentView(int layoutResID) {
        getDelegate().mo6100c(layoutResID);
    }

    public void setContentView(View view) {
        getDelegate().mo6085a(view);
    }

    public void setContentView(View view, LayoutParams params) {
        getDelegate().mo6096b(view, params);
    }

    public void addContentView(View view, LayoutParams params) {
        getDelegate().mo6086a(view, params);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDelegate().mo6081a(newConfig);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(newConfig, super.getResources().getDisplayMetrics());
        }
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().mo6108j();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().mo6248k();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().mo6109l();
    }

    public <T extends View> T findViewById(int id) {
        return getDelegate().mo6077a(id);
    }

    public final boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        C0760a ab = getSupportActionBar();
        if (item.getItemId() != 16908332 || ab == null || (ab.mo6158g() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().mo6107i();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        getDelegate().mo6242a(title);
    }

    public boolean supportRequestWindowFeature(int featureId) {
        return getDelegate().mo6098b(featureId);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().mo6106g();
    }

    public void invalidateOptionsMenu() {
        getDelegate().mo6106g();
    }

    public void onSupportActionModeStarted(C1300b mode) {
    }

    public void onSupportActionModeFinished(C1300b mode) {
    }

    public C1300b onWindowStartingSupportActionMode(C1301a callback) {
        return null;
    }

    public C1300b startSupportActionMode(C1301a callback) {
        return getDelegate().mo6079a(callback);
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean visible) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean indeterminate) {
    }

    @Deprecated
    public void setSupportProgress(int progress) {
    }

    public void onCreateSupportNavigateUpTaskStack(C0473ia builder) {
        builder.mo5172a((Activity) this);
    }

    public void onPrepareSupportNavigateUpTaskStack(C0473ia builder) {
    }

    public boolean onSupportNavigateUp() {
        Intent upIntent = getSupportParentActivityIntent();
        if (upIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(upIntent)) {
            C0473ia b = C0473ia.m2409a((Context) this);
            onCreateSupportNavigateUpTaskStack(b);
            onPrepareSupportNavigateUpTaskStack(b);
            b.mo5175a();
            try {
                C0453b.m2337a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(upIntent);
        }
        return true;
    }

    public Intent getSupportParentActivityIntent() {
        return C0445Y.m2292a(this);
    }

    public boolean supportShouldUpRecreateTask(Intent targetIntent) {
        return C0445Y.m2297b((Activity) this, targetIntent);
    }

    public void supportNavigateUpTo(Intent upIntent) {
        C0445Y.m2294a((Activity) this, upIntent);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public C0764b getDrawerToggleDelegate() {
        return getDelegate().mo6244c();
    }

    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getDelegate().mo6245c(outState);
    }

    public C0776p getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0776p.m3634a((Activity) this, (C0020o) this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        C0760a actionBar = getSupportActionBar();
        if (keyCode != 82 || actionBar == null || !actionBar.mo6149a(event)) {
            return super.dispatchKeyEvent(event);
        }
        return true;
    }

    public Resources getResources() {
        if (this.mResources == null && C0930Fb.m4471a()) {
            this.mResources = new C0930Fb(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    private boolean performMenuItemShortcut(int keycode, KeyEvent event) {
        if (VERSION.SDK_INT < 26 && !event.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(event.getMetaState()) && event.getRepeatCount() == 0 && !KeyEvent.isModifierKey(event.getKeyCode())) {
            Window currentWindow = getWindow();
            if (!(currentWindow == null || currentWindow.getDecorView() == null || !currentWindow.getDecorView().dispatchKeyShortcutEvent(event))) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (performMenuItemShortcut(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void openOptionsMenu() {
        C0760a actionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (actionBar == null || !actionBar.mo6163k()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        C0760a actionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (actionBar == null || !actionBar.mo6155e()) {
            super.closeOptionsMenu();
        }
    }
}
