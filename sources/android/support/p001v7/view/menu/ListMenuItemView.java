package android.support.p001v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.support.p001v7.widget.C1112sb;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* renamed from: android.support.v7.view.menu.ListMenuItemView */
public class ListMenuItemView extends LinearLayout implements C0893a {

    /* renamed from: a */
    private C0879p f2604a;

    /* renamed from: b */
    private ImageView f2605b;

    /* renamed from: c */
    private RadioButton f2606c;

    /* renamed from: d */
    private TextView f2607d;

    /* renamed from: e */
    private CheckBox f2608e;

    /* renamed from: f */
    private TextView f2609f;

    /* renamed from: g */
    private ImageView f2610g;

    /* renamed from: h */
    private Drawable f2611h;

    /* renamed from: i */
    private int f2612i;

    /* renamed from: j */
    private Context f2613j;

    /* renamed from: k */
    private boolean f2614k;

    /* renamed from: l */
    private Drawable f2615l;

    /* renamed from: m */
    private int f2616m;

    /* renamed from: n */
    private LayoutInflater f2617n;

    /* renamed from: o */
    private boolean f2618o;

    public ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        C1112sb a = C1112sb.m5456a(getContext(), attrs, C0793R.styleable.MenuView, defStyleAttr, 0);
        this.f2611h = a.mo8650b(C0793R.styleable.MenuView_android_itemBackground);
        this.f2612i = a.mo8659g(C0793R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f2614k = a.mo8648a(C0793R.styleable.MenuView_preserveIconSpacing, false);
        this.f2613j = context;
        this.f2615l = a.mo8650b(C0793R.styleable.MenuView_subMenuArrow);
        a.mo8647a();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C0646w.m2954a((View) this, this.f2611h);
        this.f2607d = (TextView) findViewById(C0793R.C0794id.title);
        int i = this.f2612i;
        if (i != -1) {
            this.f2607d.setTextAppearance(this.f2613j, i);
        }
        this.f2609f = (TextView) findViewById(C0793R.C0794id.shortcut);
        this.f2610g = (ImageView) findViewById(C0793R.C0794id.submenuarrow);
        ImageView imageView = this.f2610g;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2615l);
        }
    }

    /* renamed from: a */
    public void mo4088a(C0879p itemData, int menuType) {
        this.f2604a = itemData;
        this.f2616m = menuType;
        setVisibility(itemData.isVisible() ? 0 : 8);
        setTitle(itemData.mo6768a((C0893a) this));
        setCheckable(itemData.isCheckable());
        mo6593a(itemData.mo6804m(), itemData.mo6776d());
        setIcon(itemData.getIcon());
        setEnabled(itemData.isEnabled());
        setSubMenuArrowVisible(itemData.hasSubMenu());
        setContentDescription(itemData.getContentDescription());
    }

    public void setForceShowIcon(boolean forceShow) {
        this.f2618o = forceShow;
        this.f2614k = forceShow;
    }

    public void setTitle(CharSequence title) {
        if (title != null) {
            this.f2607d.setText(title);
            if (this.f2607d.getVisibility() != 0) {
                this.f2607d.setVisibility(0);
            }
        } else if (this.f2607d.getVisibility() != 8) {
            this.f2607d.setVisibility(8);
        }
    }

    public C0879p getItemData() {
        return this.f2604a;
    }

    public void setCheckable(boolean checkable) {
        CompoundButton otherCompoundButton;
        CompoundButton compoundButton;
        if (checkable || this.f2606c != null || this.f2608e != null) {
            if (this.f2604a.mo6796i()) {
                if (this.f2606c == null) {
                    m4053c();
                }
                compoundButton = this.f2606c;
                otherCompoundButton = this.f2608e;
            } else {
                if (this.f2608e == null) {
                    m4051a();
                }
                compoundButton = this.f2608e;
                otherCompoundButton = this.f2606c;
            }
            if (checkable) {
                compoundButton.setChecked(this.f2604a.isChecked());
                int newVisibility = checkable ? 0 : 8;
                if (compoundButton.getVisibility() != newVisibility) {
                    compoundButton.setVisibility(newVisibility);
                }
                if (!(otherCompoundButton == null || otherCompoundButton.getVisibility() == 8)) {
                    otherCompoundButton.setVisibility(8);
                }
            } else {
                CheckBox checkBox = this.f2608e;
                if (checkBox != null) {
                    checkBox.setVisibility(8);
                }
                RadioButton radioButton = this.f2606c;
                if (radioButton != null) {
                    radioButton.setVisibility(8);
                }
            }
        }
    }

    public void setChecked(boolean checked) {
        CompoundButton compoundButton;
        if (this.f2604a.mo6796i()) {
            if (this.f2606c == null) {
                m4053c();
            }
            compoundButton = this.f2606c;
        } else {
            if (this.f2608e == null) {
                m4051a();
            }
            compoundButton = this.f2608e;
        }
        compoundButton.setChecked(checked);
    }

    private void setSubMenuArrowVisible(boolean hasSubmenu) {
        ImageView imageView = this.f2610g;
        if (imageView != null) {
            imageView.setVisibility(hasSubmenu ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void mo6593a(boolean showShortcut, char shortcutKey) {
        int newVisibility = (!showShortcut || !this.f2604a.mo6804m()) ? 8 : 0;
        if (newVisibility == 0) {
            this.f2609f.setText(this.f2604a.mo6778e());
        }
        if (this.f2609f.getVisibility() != newVisibility) {
            this.f2609f.setVisibility(newVisibility);
        }
    }

    public void setIcon(Drawable icon) {
        boolean showIcon = this.f2604a.mo6803l() || this.f2618o;
        if (!showIcon && !this.f2614k) {
            return;
        }
        if (this.f2605b != null || icon != null || this.f2614k) {
            if (this.f2605b == null) {
                m4052b();
            }
            if (icon != null || this.f2614k) {
                this.f2605b.setImageDrawable(showIcon ? icon : null);
                if (this.f2605b.getVisibility() != 0) {
                    this.f2605b.setVisibility(0);
                }
            } else {
                this.f2605b.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f2605b != null && this.f2614k) {
            LayoutParams lp = getLayoutParams();
            LinearLayout.LayoutParams iconLp = (LinearLayout.LayoutParams) this.f2605b.getLayoutParams();
            if (lp.height > 0 && iconLp.width <= 0) {
                iconLp.width = lp.height;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* renamed from: b */
    private void m4052b() {
        this.f2605b = (ImageView) getInflater().inflate(C0793R.layout.abc_list_menu_item_icon, this, false);
        addView(this.f2605b, 0);
    }

    /* renamed from: c */
    private void m4053c() {
        this.f2606c = (RadioButton) getInflater().inflate(C0793R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f2606c);
    }

    /* renamed from: a */
    private void m4051a() {
        this.f2608e = (CheckBox) getInflater().inflate(C0793R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f2608e);
    }

    /* renamed from: h */
    public boolean mo4090h() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f2617n == null) {
            this.f2617n = LayoutInflater.from(getContext());
        }
        return this.f2617n;
    }
}
