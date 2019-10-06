package android.support.p001v7.app;

import android.content.Context;
import android.support.p001v7.view.menu.C0873l;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

/* renamed from: android.support.v7.app.s */
/* compiled from: AppCompatDelegateImplN */
class C0781s extends C0787v {

    /* renamed from: android.support.v7.app.s$a */
    /* compiled from: AppCompatDelegateImplN */
    class C0782a extends C0788a {
        C0782a(Callback callback) {
            super(callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
            C0741d panel = C0781s.this.mo6075a(0, true);
            if (panel != null) {
                C0873l lVar = panel.f2222j;
                if (lVar != null) {
                    super.onProvideKeyboardShortcuts(data, lVar, deviceId);
                    return;
                }
            }
            super.onProvideKeyboardShortcuts(data, menu, deviceId);
        }
    }

    C0781s(Context context, Window window, C0020o callback) {
        super(context, window, callback);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Callback mo6250a(Callback callback) {
        return new C0782a(callback);
    }
}
