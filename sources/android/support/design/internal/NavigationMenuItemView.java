package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.p000v4.content.p036a.C0507d;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0665C;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.support.p001v7.widget.C0901Ab;
import android.support.p001v7.widget.C1101pa.C1102a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p050d.C1171e;
import p002b.p003c.p050d.C1172f;
import p002b.p003c.p050d.C1174h;
import p002b.p003c.p053g.p054a.p055a.C1200a;

public class NavigationMenuItemView extends C0220f implements C0893a {

    /* renamed from: g */
    private static final int[] f715g = {16842912};

    /* renamed from: h */
    private final int f716h;

    /* renamed from: i */
    private boolean f717i;

    /* renamed from: j */
    boolean f718j;

    /* renamed from: k */
    private final CheckedTextView f719k;

    /* renamed from: l */
    private FrameLayout f720l;

    /* renamed from: m */
    private C0879p f721m;

    /* renamed from: n */
    private ColorStateList f722n;

    /* renamed from: o */
    private boolean f723o;

    /* renamed from: p */
    private Drawable f724p;

    /* renamed from: q */
    private final C0616c f725q;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f725q = new C0221g(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C1174h.design_navigation_menu_item, this, true);
        this.f716h = context.getResources().getDimensionPixelSize(C1170d.design_navigation_icon_size);
        this.f719k = (CheckedTextView) findViewById(C1172f.design_menu_item_text);
        this.f719k.setDuplicateParentStateEnabled(true);
        C0646w.m2955a((View) this.f719k, this.f725q);
    }

    /* renamed from: a */
    public void mo4088a(C0879p itemData, int menuType) {
        this.f721m = itemData;
        setVisibility(itemData.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            C0646w.m2954a((View) this, (Drawable) m1228b());
        }
        setCheckable(itemData.isCheckable());
        setChecked(itemData.isChecked());
        setEnabled(itemData.isEnabled());
        setTitle(itemData.getTitle());
        setIcon(itemData.getIcon());
        setActionView(itemData.getActionView());
        setContentDescription(itemData.getContentDescription());
        C0901Ab.m4307a(this, itemData.getTooltipText());
        m1227a();
    }

    /* renamed from: c */
    private boolean m1229c() {
        return this.f721m.getTitle() == null && this.f721m.getIcon() == null && this.f721m.getActionView() != null;
    }

    /* renamed from: a */
    private void m1227a() {
        if (m1229c()) {
            this.f719k.setVisibility(8);
            FrameLayout frameLayout = this.f720l;
            if (frameLayout != null) {
                C1102a params = (C1102a) frameLayout.getLayoutParams();
                params.width = -1;
                this.f720l.setLayoutParams(params);
                return;
            }
            return;
        }
        this.f719k.setVisibility(0);
        FrameLayout frameLayout2 = this.f720l;
        if (frameLayout2 != null) {
            C1102a params2 = (C1102a) frameLayout2.getLayoutParams();
            params2.width = -2;
            this.f720l.setLayoutParams(params2);
        }
    }

    private void setActionView(View actionView) {
        if (actionView != null) {
            if (this.f720l == null) {
                this.f720l = (FrameLayout) ((ViewStub) findViewById(C1172f.design_menu_item_action_area_stub)).inflate();
            }
            this.f720l.removeAllViews();
            this.f720l.addView(actionView);
        }
    }

    /* renamed from: b */
    private StateListDrawable m1228b() {
        TypedValue value = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0793R.attr.colorControlHighlight, value, true)) {
            return null;
        }
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(f715g, new ColorDrawable(value.data));
        drawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return drawable;
    }

    public C0879p getItemData() {
        return this.f721m;
    }

    public void setTitle(CharSequence title) {
        this.f719k.setText(title);
    }

    public void setCheckable(boolean checkable) {
        refreshDrawableState();
        if (this.f718j != checkable) {
            this.f718j = checkable;
            this.f725q.mo5631a((View) this.f719k, (int) Opcodes.ACC_STRICT);
        }
    }

    public void setChecked(boolean checked) {
        refreshDrawableState();
        this.f719k.setChecked(checked);
    }

    public void setIcon(Drawable icon) {
        if (icon != null) {
            if (this.f723o) {
                ConstantState state = icon.getConstantState();
                icon = C1200a.m5741i(state == null ? icon : state.newDrawable()).mutate();
                C1200a.m5726a(icon, this.f722n);
            }
            int i = this.f716h;
            icon.setBounds(0, 0, i, i);
        } else if (this.f717i) {
            if (this.f724p == null) {
                this.f724p = C0507d.m2542a(getResources(), C1171e.navigation_empty_icon, getContext().getTheme());
                Drawable drawable = this.f724p;
                if (drawable != null) {
                    int i2 = this.f716h;
                    drawable.setBounds(0, 0, i2, i2);
                }
            }
            icon = this.f724p;
        }
        C0665C.m3101a((TextView) this.f719k, icon, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* renamed from: h */
    public boolean mo4090h() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        C0879p pVar = this.f721m;
        if (pVar != null && pVar.isCheckable() && this.f721m.isChecked()) {
            ViewGroup.mergeDrawableStates(drawableState, f715g);
        }
        return drawableState;
    }

    /* access modifiers changed from: 0000 */
    public void setIconTintList(ColorStateList tintList) {
        this.f722n = tintList;
        this.f723o = this.f722n != null;
        C0879p pVar = this.f721m;
        if (pVar != null) {
            setIcon(pVar.getIcon());
        }
    }

    public void setTextAppearance(int textAppearance) {
        C0665C.m3099a(this.f719k, textAppearance);
    }

    public void setTextColor(ColorStateList colors) {
        this.f719k.setTextColor(colors);
    }

    public void setNeedsEmptyIcon(boolean needsEmptyIcon) {
        this.f717i = needsEmptyIcon;
    }
}
