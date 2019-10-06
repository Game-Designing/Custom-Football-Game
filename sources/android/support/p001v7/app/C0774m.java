package android.support.p001v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p001v7.app.AlertController.C0730a;
import android.support.p001v7.appcompat.C0793R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.app.m */
/* compiled from: AlertDialog */
public class C0774m extends C0744F implements DialogInterface {

    /* renamed from: b */
    final AlertController f2338b = new AlertController(getContext(), this, getWindow());

    /* renamed from: android.support.v7.app.m$a */
    /* compiled from: AlertDialog */
    public static class C0775a {

        /* renamed from: a */
        private final C0730a f2339a;

        /* renamed from: b */
        private final int f2340b;

        public C0775a(Context context) {
            this(context, C0774m.m3609a(context, 0));
        }

        public C0775a(Context context, int themeResId) {
            this.f2339a = new C0730a(new ContextThemeWrapper(context, C0774m.m3609a(context, themeResId)));
            this.f2340b = themeResId;
        }

        /* renamed from: b */
        public Context mo6232b() {
            return this.f2339a.f2145a;
        }

        /* renamed from: c */
        public C0775a mo6238c(int titleId) {
            C0730a aVar = this.f2339a;
            aVar.f2150f = aVar.f2145a.getText(titleId);
            return this;
        }

        /* renamed from: b */
        public C0775a mo6236b(CharSequence title) {
            this.f2339a.f2150f = title;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6224a(View customTitleView) {
            this.f2339a.f2151g = customTitleView;
            return this;
        }

        /* renamed from: b */
        public C0775a mo6233b(int messageId) {
            C0730a aVar = this.f2339a;
            aVar.f2152h = aVar.f2145a.getText(messageId);
            return this;
        }

        /* renamed from: a */
        public C0775a mo6226a(CharSequence message) {
            this.f2339a.f2152h = message;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6219a(int iconId) {
            this.f2339a.f2147c = iconId;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6223a(Drawable icon) {
            this.f2339a.f2148d = icon;
            return this;
        }

        /* renamed from: c */
        public C0775a mo6239c(int textId, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2153i = aVar.f2145a.getText(textId);
            this.f2339a.f2155k = listener;
            return this;
        }

        /* renamed from: c */
        public C0775a mo6240c(CharSequence text, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2153i = text;
            aVar.f2155k = listener;
            return this;
        }

        /* renamed from: b */
        public C0775a mo6234b(int textId, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2156l = aVar.f2145a.getText(textId);
            this.f2339a.f2158n = listener;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6227a(CharSequence text, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2156l = text;
            aVar.f2158n = listener;
            return this;
        }

        /* renamed from: b */
        public C0775a mo6237b(CharSequence text, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2159o = text;
            aVar.f2161q = listener;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6228a(boolean cancelable) {
            this.f2339a.f2162r = cancelable;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6221a(OnCancelListener onCancelListener) {
            this.f2339a.f2163s = onCancelListener;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6222a(OnKeyListener onKeyListener) {
            this.f2339a.f2165u = onKeyListener;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6220a(int itemsId, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2166v = aVar.f2145a.getResources().getTextArray(itemsId);
            this.f2339a.f2168x = listener;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6225a(ListAdapter adapter, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2167w = adapter;
            aVar.f2168x = listener;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6230a(CharSequence[] items, boolean[] checkedItems, OnMultiChoiceClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2166v = items;
            aVar.f2138J = listener;
            aVar.f2134F = checkedItems;
            aVar.f2135G = true;
            return this;
        }

        /* renamed from: a */
        public C0775a mo6229a(CharSequence[] items, int checkedItem, OnClickListener listener) {
            C0730a aVar = this.f2339a;
            aVar.f2166v = items;
            aVar.f2168x = listener;
            aVar.f2137I = checkedItem;
            aVar.f2136H = true;
            return this;
        }

        /* renamed from: d */
        public C0775a mo6241d(int layoutResId) {
            C0730a aVar = this.f2339a;
            aVar.f2170z = null;
            aVar.f2169y = layoutResId;
            aVar.f2133E = false;
            return this;
        }

        /* renamed from: b */
        public C0775a mo6235b(View view) {
            C0730a aVar = this.f2339a;
            aVar.f2170z = view;
            aVar.f2169y = 0;
            aVar.f2133E = false;
            return this;
        }

        /* renamed from: a */
        public C0774m mo6231a() {
            C0774m dialog = new C0774m(this.f2339a.f2145a, this.f2340b);
            this.f2339a.mo6053a(dialog.f2338b);
            dialog.setCancelable(this.f2339a.f2162r);
            if (this.f2339a.f2162r) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(this.f2339a.f2163s);
            dialog.setOnDismissListener(this.f2339a.f2164t);
            OnKeyListener onKeyListener = this.f2339a.f2165u;
            if (onKeyListener != null) {
                dialog.setOnKeyListener(onKeyListener);
            }
            return dialog;
        }
    }

    protected C0774m(Context context, int themeResId) {
        super(context, m3609a(context, themeResId));
    }

    /* renamed from: a */
    static int m3609a(Context context, int resid) {
        if (((resid >>> 24) & 255) >= 1) {
            return resid;
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(C0793R.attr.alertDialogTheme, outValue, true);
        return outValue.resourceId;
    }

    public void setTitle(CharSequence title) {
        super.setTitle(title);
        this.f2338b.mo6048b(title);
    }

    /* renamed from: a */
    public void mo6216a(Drawable icon) {
        this.f2338b.mo6042a(icon);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f2338b.mo6040a();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.f2338b.mo6045a(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.f2338b.mo6049b(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
