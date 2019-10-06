package android.support.p001v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v7.view.menu.m */
/* compiled from: MenuDialogHelper */
class C0876m implements OnKeyListener, OnClickListener, OnDismissListener, C0891a {

    /* renamed from: a */
    private C0873l f2735a;

    /* renamed from: b */
    private C0774m f2736b;

    /* renamed from: c */
    C0870j f2737c;

    /* renamed from: d */
    private C0891a f2738d;

    public C0876m(C0873l menu) {
        this.f2735a = menu;
    }

    /* renamed from: a */
    public void mo6764a(IBinder windowToken) {
        C0873l menu = this.f2735a;
        C0775a builder = new C0775a(menu.mo6739e());
        this.f2737c = new C0870j(builder.mo6232b(), C0793R.layout.abc_list_menu_item_layout);
        this.f2737c.mo6548a((C0891a) this);
        this.f2735a.mo6708a((C0890v) this.f2737c);
        builder.mo6225a(this.f2737c.mo6684c(), (OnClickListener) this);
        View headerView = menu.mo6747i();
        if (headerView != null) {
            builder.mo6224a(headerView);
        } else {
            builder.mo6223a(menu.mo6743g());
            builder.mo6236b(menu.mo6745h());
        }
        builder.mo6222a((OnKeyListener) this);
        this.f2736b = builder.mo6231a();
        this.f2736b.setOnDismissListener(this);
        LayoutParams lp = this.f2736b.getWindow().getAttributes();
        lp.type = 1003;
        if (windowToken != null) {
            lp.token = windowToken;
        }
        lp.flags |= Opcodes.ACC_DEPRECATED;
        this.f2736b.show();
    }

    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if (keyCode == 82 || keyCode == 4) {
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                Window win = this.f2736b.getWindow();
                if (win != null) {
                    View decor = win.getDecorView();
                    if (decor != null) {
                        DispatcherState ds = decor.getKeyDispatcherState();
                        if (ds != null) {
                            ds.startTracking(event, this);
                            return true;
                        }
                    }
                }
            } else if (event.getAction() == 1 && !event.isCanceled()) {
                Window win2 = this.f2736b.getWindow();
                if (win2 != null) {
                    View decor2 = win2.getDecorView();
                    if (decor2 != null) {
                        DispatcherState ds2 = decor2.getKeyDispatcherState();
                        if (ds2 != null && ds2.isTracking(event)) {
                            this.f2735a.mo6712a(true);
                            dialog.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f2735a.performShortcut(keyCode, event, 0);
    }

    /* renamed from: a */
    public void mo6763a() {
        C0774m mVar = this.f2736b;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialog) {
        this.f2737c.mo4078a(this.f2735a, true);
    }

    /* renamed from: a */
    public void mo6117a(C0873l menu, boolean allMenusAreClosing) {
        if (allMenusAreClosing || menu == this.f2735a) {
            mo6763a();
        }
        C0891a aVar = this.f2738d;
        if (aVar != null) {
            aVar.mo6117a(menu, allMenusAreClosing);
        }
    }

    /* renamed from: a */
    public boolean mo6118a(C0873l subMenu) {
        C0891a aVar = this.f2738d;
        if (aVar != null) {
            return aVar.mo6118a(subMenu);
        }
        return false;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.f2735a.mo6713a((MenuItem) (C0879p) this.f2737c.mo6684c().getItem(which), 0);
    }
}
