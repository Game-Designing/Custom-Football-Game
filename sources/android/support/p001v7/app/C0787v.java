package android.support.p001v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.app.v */
/* compiled from: AppCompatDelegateImplV23 */
class C0787v extends C0783t {

    /* renamed from: Y */
    private final UiModeManager f2376Y;

    /* renamed from: android.support.v7.app.v$a */
    /* compiled from: AppCompatDelegateImplV23 */
    class C0788a extends C0784a {
        C0788a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
            if (!C0787v.this.mo6264w() || type != 0) {
                return super.onWindowStartingActionMode(callback, type);
            }
            return mo6265a(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    C0787v(Context context, Window window, C0020o callback) {
        super(context, window, callback);
        this.f2376Y = (UiModeManager) context.getSystemService("uimode");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Callback mo6250a(Callback callback) {
        return new C0788a(callback);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo6263g(int mode) {
        if (mode == 0 && this.f2376Y.getNightMode() == 0) {
            return -1;
        }
        return super.mo6263g(mode);
    }
}
