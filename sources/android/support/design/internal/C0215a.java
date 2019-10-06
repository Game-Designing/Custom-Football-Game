package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0643t;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.support.p001v7.widget.C0901Ab;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p050d.C1171e;
import p002b.p003c.p050d.C1172f;
import p002b.p003c.p050d.C1174h;
import p002b.p003c.p053g.p054a.p055a.C1200a;

/* renamed from: android.support.design.internal.a */
/* compiled from: BottomNavigationItemView */
public class C0215a extends FrameLayout implements C0893a {

    /* renamed from: a */
    private static final int[] f730a = {16842912};

    /* renamed from: b */
    private final int f731b;

    /* renamed from: c */
    private final int f732c;

    /* renamed from: d */
    private final float f733d;

    /* renamed from: e */
    private final float f734e;

    /* renamed from: f */
    private boolean f735f;

    /* renamed from: g */
    private ImageView f736g;

    /* renamed from: h */
    private final TextView f737h;

    /* renamed from: i */
    private final TextView f738i;

    /* renamed from: j */
    private int f739j;

    /* renamed from: k */
    private C0879p f740k;

    /* renamed from: l */
    private ColorStateList f741l;

    public C0215a(Context context) {
        this(context, null);
    }

    public C0215a(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C0215a(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f739j = -1;
        Resources res = getResources();
        int inactiveLabelSize = res.getDimensionPixelSize(C1170d.design_bottom_navigation_text_size);
        int activeLabelSize = res.getDimensionPixelSize(C1170d.design_bottom_navigation_active_text_size);
        this.f731b = res.getDimensionPixelSize(C1170d.design_bottom_navigation_margin);
        this.f732c = inactiveLabelSize - activeLabelSize;
        this.f733d = (((float) activeLabelSize) * 1.0f) / ((float) inactiveLabelSize);
        this.f734e = (((float) inactiveLabelSize) * 1.0f) / ((float) activeLabelSize);
        LayoutInflater.from(context).inflate(C1174h.design_bottom_navigation_item, this, true);
        setBackgroundResource(C1171e.design_bottom_navigation_item_background);
        this.f736g = (ImageView) findViewById(C1172f.icon);
        this.f737h = (TextView) findViewById(C1172f.smallLabel);
        this.f738i = (TextView) findViewById(C1172f.largeLabel);
    }

    /* renamed from: a */
    public void mo4088a(C0879p itemData, int menuType) {
        this.f740k = itemData;
        setCheckable(itemData.isCheckable());
        setChecked(itemData.isChecked());
        setEnabled(itemData.isEnabled());
        setIcon(itemData.getIcon());
        setTitle(itemData.getTitle());
        setId(itemData.getItemId());
        setContentDescription(itemData.getContentDescription());
        C0901Ab.m4307a(this, itemData.getTooltipText());
    }

    public void setItemPosition(int position) {
        this.f739j = position;
    }

    public int getItemPosition() {
        return this.f739j;
    }

    public void setShiftingMode(boolean enabled) {
        this.f735f = enabled;
    }

    public C0879p getItemData() {
        return this.f740k;
    }

    public void setTitle(CharSequence title) {
        this.f737h.setText(title);
        this.f738i.setText(title);
    }

    public void setCheckable(boolean checkable) {
        refreshDrawableState();
    }

    public void setChecked(boolean checked) {
        TextView textView = this.f738i;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.f738i;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.f737h;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.f737h;
        textView4.setPivotY((float) textView4.getBaseline());
        if (this.f735f) {
            if (checked) {
                LayoutParams iconParams = (LayoutParams) this.f736g.getLayoutParams();
                iconParams.gravity = 49;
                iconParams.topMargin = this.f731b;
                this.f736g.setLayoutParams(iconParams);
                this.f738i.setVisibility(0);
                this.f738i.setScaleX(1.0f);
                this.f738i.setScaleY(1.0f);
            } else {
                LayoutParams iconParams2 = (LayoutParams) this.f736g.getLayoutParams();
                iconParams2.gravity = 17;
                iconParams2.topMargin = this.f731b;
                this.f736g.setLayoutParams(iconParams2);
                this.f738i.setVisibility(4);
                this.f738i.setScaleX(0.5f);
                this.f738i.setScaleY(0.5f);
            }
            this.f737h.setVisibility(4);
        } else if (checked) {
            LayoutParams iconParams3 = (LayoutParams) this.f736g.getLayoutParams();
            iconParams3.gravity = 49;
            iconParams3.topMargin = this.f731b + this.f732c;
            this.f736g.setLayoutParams(iconParams3);
            this.f738i.setVisibility(0);
            this.f737h.setVisibility(4);
            this.f738i.setScaleX(1.0f);
            this.f738i.setScaleY(1.0f);
            this.f737h.setScaleX(this.f733d);
            this.f737h.setScaleY(this.f733d);
        } else {
            LayoutParams iconParams4 = (LayoutParams) this.f736g.getLayoutParams();
            iconParams4.gravity = 49;
            iconParams4.topMargin = this.f731b;
            this.f736g.setLayoutParams(iconParams4);
            this.f738i.setVisibility(4);
            this.f737h.setVisibility(0);
            this.f738i.setScaleX(this.f734e);
            this.f738i.setScaleY(this.f734e);
            this.f737h.setScaleX(1.0f);
            this.f737h.setScaleY(1.0f);
        }
        refreshDrawableState();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.f737h.setEnabled(enabled);
        this.f738i.setEnabled(enabled);
        this.f736g.setEnabled(enabled);
        if (enabled) {
            C0646w.m2957a((View) this, C0643t.m2943a(getContext(), 1002));
        } else {
            C0646w.m2957a((View) this, (C0643t) null);
        }
    }

    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        C0879p pVar = this.f740k;
        if (pVar != null && pVar.isCheckable() && this.f740k.isChecked()) {
            FrameLayout.mergeDrawableStates(drawableState, f730a);
        }
        return drawableState;
    }

    public void setIcon(Drawable icon) {
        if (icon != null) {
            ConstantState state = icon.getConstantState();
            icon = C1200a.m5741i(state == null ? icon : state.newDrawable()).mutate();
            C1200a.m5726a(icon, this.f741l);
        }
        this.f736g.setImageDrawable(icon);
    }

    /* renamed from: h */
    public boolean mo4090h() {
        return false;
    }

    public void setIconTintList(ColorStateList tint) {
        this.f741l = tint;
        C0879p pVar = this.f740k;
        if (pVar != null) {
            setIcon(pVar.getIcon());
        }
    }

    public void setTextColor(ColorStateList color) {
        this.f737h.setTextColor(color);
        this.f738i.setTextColor(color);
    }

    public void setItemBackground(int background) {
        Drawable backgroundDrawable;
        if (background == 0) {
            backgroundDrawable = null;
        } else {
            backgroundDrawable = C0510b.m2572c(getContext(), background);
        }
        C0646w.m2954a((View) this, backgroundDrawable);
    }
}
