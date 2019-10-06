package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import p019d.p151c.p152a.C7285h;
import p019d.p151c.p152a.C7286i;
import p019d.p151c.p152a.C7288k;
import p019d.p151c.p152a.p153a.C7274d;
import p019d.p151c.p152a.p153a.C7276f;

/* renamed from: com.braintreepayments.cardform.view.g */
/* compiled from: ExpirationDateDialog */
public class C5906g extends Dialog implements OnShowListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final List<String> f10319a = Arrays.asList(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f10320b = (Calendar.getInstance().get(2) + 1);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f10321c = Calendar.getInstance().get(1);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<String> f10322d = new ArrayList();

    /* renamed from: e */
    private int f10323e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ExpirationDateEditText f10324f;

    /* renamed from: g */
    private C7274d f10325g;

    /* renamed from: h */
    private GridView f10326h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f10327i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f10328j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f10329k = -1;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f10330l = -1;

    protected C5906g(Context context, int themeResId) {
        super(context, themeResId);
    }

    /* renamed from: a */
    public static C5906g m10780a(Activity activity, ExpirationDateEditText editText) {
        C5906g dialog;
        C7274d theme = C7274d.m15835a(activity);
        if (theme == C7274d.LIGHT) {
            dialog = new C5906g(activity, C7288k.bt_expiration_date_dialog_light);
        } else {
            dialog = new C5906g(activity, C7288k.bt_expiration_date_dialog_dark);
        }
        dialog.setOwnerActivity(activity);
        dialog.f10325g = theme;
        dialog.f10324f = editText;
        return dialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C7286i.bt_expiration_date_sheet);
        this.f10323e = getContext().getResources().getInteger(17694720);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setOnShowListener(this);
        for (int i = 0; i < 20; i++) {
            this.f10322d.add(Integer.toString(this.f10321c + i));
        }
        C7276f monthAdapter = new C7276f(getContext(), this.f10325g, f10319a);
        C7276f yearAdapter = new C7276f(getContext(), this.f10325g, this.f10322d);
        ((GridView) findViewById(C7285h.bt_expiration_month_grid_view)).setAdapter(monthAdapter);
        monthAdapter.mo23503a((OnItemClickListener) new C5901b(this, yearAdapter));
        this.f10326h = (GridView) findViewById(C7285h.bt_expiration_year_grid_view);
        this.f10326h.setAdapter(yearAdapter);
        yearAdapter.mo23503a((OnItemClickListener) new C5902c(this, monthAdapter));
        this.f10329k = f10319a.indexOf(this.f10324f.getMonth());
        int i2 = this.f10329k;
        if (i2 >= 0) {
            monthAdapter.mo23502a(i2);
        }
        this.f10330l = this.f10322d.indexOf(this.f10324f.getYear());
        int i3 = this.f10330l;
        if (i3 >= 0) {
            yearAdapter.mo23502a(i3);
        }
    }

    public void show() {
        new Handler().postDelayed(new C5903d(this), (long) this.f10323e);
    }

    public void onShow(DialogInterface dialog) {
        int i = this.f10330l;
        if (i > 0) {
            this.f10326h.smoothScrollToPosition(i);
        }
        this.f10327i = false;
        this.f10328j = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10786b() {
        String expirationDate;
        String expirationDate2;
        int i = this.f10329k;
        if (i == -1) {
            expirationDate = "  ";
        } else {
            expirationDate = (String) f10319a.get(i);
        }
        if (this.f10330l == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(expirationDate);
            sb.append("    ");
            expirationDate2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(expirationDate);
            sb2.append((String) this.f10322d.get(this.f10330l));
            expirationDate2 = sb2.toString();
        }
        this.f10324f.setText(expirationDate2);
        if (this.f10327i && this.f10328j) {
            View focusedView = this.f10324f.mo18492i();
            if (focusedView != null) {
                new Handler().postDelayed(new C5904e(this, focusedView), (long) this.f10323e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        View selectedView;
        boolean closeOnTouch = event.getAction() == 0 && m10783a(event) && getWindow().peekDecorView() != null;
        if (!isShowing() || !closeOnTouch) {
            return false;
        }
        View rootView = getOwnerActivity().getWindow().getDecorView().getRootView();
        if (rootView instanceof ViewGroup) {
            selectedView = m10779a((ViewGroup) rootView, (int) event.getRawX(), (int) event.getRawY());
        } else {
            selectedView = null;
        }
        if (selectedView != null && selectedView != this.f10324f) {
            dismiss();
            if (selectedView instanceof EditText) {
                selectedView.requestFocus();
                new Handler().postDelayed(new C5905f(this, selectedView), (long) this.f10323e);
            } else if (selectedView instanceof Button) {
                selectedView.callOnClick();
            }
        } else if (selectedView == null) {
            dismiss();
        }
        return true;
    }

    /* renamed from: a */
    private View m10779a(ViewGroup viewGroup, int x, int y) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                View foundView = m10779a((ViewGroup) child, x, y);
                if (foundView != null && foundView.isShown()) {
                    return foundView;
                }
            } else {
                int[] location = new int[2];
                child.getLocationOnScreen(location);
                if (new Rect(location[0], location[1], location[0] + child.getWidth(), location[1] + child.getHeight()).contains(x, y)) {
                    return child;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m10783a(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int slop = ViewConfiguration.get(getContext()).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        return x < (-slop) || y < (-slop) || x > decorView.getWidth() + slop || y > decorView.getHeight() + slop;
    }
}
