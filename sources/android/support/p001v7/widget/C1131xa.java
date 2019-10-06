package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p001v7.view.menu.C0872k;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.xa */
/* compiled from: MenuPopupWindow */
public class C1131xa extends C1120va implements C1128wa {

    /* renamed from: K */
    private static Method f3753K;

    /* renamed from: L */
    private C1128wa f3754L;

    /* renamed from: android.support.v7.widget.xa$a */
    /* compiled from: MenuPopupWindow */
    public static class C1132a extends C1058ga {

        /* renamed from: o */
        final int f3755o;

        /* renamed from: p */
        final int f3756p;

        /* renamed from: q */
        private C1128wa f3757q;

        /* renamed from: r */
        private MenuItem f3758r;

        /* renamed from: a */
        public /* bridge */ /* synthetic */ int mo8431a(int i, int i2, int i3, int i4, int i5) {
            return super.mo8431a(i, i2, i3, i4, i5);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo8432a(MotionEvent motionEvent, int i) {
            return super.mo8432a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public C1132a(Context context, boolean hijackFocus) {
            super(context, hijackFocus);
            Configuration config = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != config.getLayoutDirection()) {
                this.f3755o = 22;
                this.f3756p = 21;
                return;
            }
            this.f3755o = 21;
            this.f3756p = 22;
        }

        public void setHoverListener(C1128wa hoverListener) {
            this.f3757q = hoverListener;
        }

        public boolean onKeyDown(int keyCode, KeyEvent event) {
            ListMenuItemView selectedItem = (ListMenuItemView) getSelectedView();
            if (selectedItem != null && keyCode == this.f3755o) {
                if (selectedItem.isEnabled() && selectedItem.getItemData().hasSubMenu()) {
                    performItemClick(selectedItem, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (selectedItem == null || keyCode != this.f3756p) {
                return super.onKeyDown(keyCode, event);
            } else {
                setSelection(-1);
                ((C0872k) getAdapter()).mo6694b().mo6712a(false);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent ev) {
            int headersCount;
            C0872k menuAdapter;
            if (this.f3757q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerAdapter.getHeadersCount();
                    menuAdapter = (C0872k) headerAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (C0872k) adapter;
                }
                MenuItem menuItem = null;
                if (ev.getAction() != 10) {
                    int position = pointToPosition((int) ev.getX(), (int) ev.getY());
                    if (position != -1) {
                        int itemPosition = position - headersCount;
                        if (itemPosition >= 0 && itemPosition < menuAdapter.getCount()) {
                            menuItem = menuAdapter.getItem(itemPosition);
                        }
                    }
                }
                MenuItem oldMenuItem = this.f3758r;
                if (oldMenuItem != menuItem) {
                    C0873l menu = menuAdapter.mo6694b();
                    if (oldMenuItem != null) {
                        this.f3757q.mo6675a(menu, oldMenuItem);
                    }
                    this.f3758r = menuItem;
                    if (menuItem != null) {
                        this.f3757q.mo6676b(menu, menuItem);
                    }
                }
            }
            return super.onHoverEvent(ev);
        }
    }

    static {
        try {
            f3753K = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public C1131xa(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1058ga mo8682a(Context context, boolean hijackFocus) {
        C1132a view = new C1132a(context, hijackFocus);
        view.setHoverListener(this);
        return view;
    }

    /* renamed from: a */
    public void mo8724a(Object enterTransition) {
        if (VERSION.SDK_INT >= 23) {
            this.f3719J.setEnterTransition((Transition) enterTransition);
        }
    }

    /* renamed from: b */
    public void mo8725b(Object exitTransition) {
        if (VERSION.SDK_INT >= 23) {
            this.f3719J.setExitTransition((Transition) exitTransition);
        }
    }

    /* renamed from: a */
    public void mo8723a(C1128wa hoverListener) {
        this.f3754L = hoverListener;
    }

    /* renamed from: c */
    public void mo8726c(boolean touchModal) {
        Method method = f3753K;
        if (method != null) {
            try {
                method.invoke(this.f3719J, new Object[]{Boolean.valueOf(touchModal)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: b */
    public void mo6676b(C0873l menu, MenuItem item) {
        C1128wa waVar = this.f3754L;
        if (waVar != null) {
            waVar.mo6676b(menu, item);
        }
    }

    /* renamed from: a */
    public void mo6675a(C0873l menu, MenuItem item) {
        C1128wa waVar = this.f3754L;
        if (waVar != null) {
            waVar.mo6675a(menu, item);
        }
    }
}
