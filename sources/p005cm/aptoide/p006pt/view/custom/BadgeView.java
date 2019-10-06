package p005cm.aptoide.p006pt.view.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.custom.BadgeView */
public class BadgeView extends TextView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int DEFAULT_BADGE_COLOR = -1;
    private static final int DEFAULT_CORNER_RADIUS_DIP = 8;
    private static final int DEFAULT_LR_PADDING_DIP = 5;
    private static final int DEFAULT_MARGIN_DIP = 5;
    private static final int DEFAULT_POSITION = 2;
    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("#CCFF0000");
    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 4;
    public static final int POSITION_CENTER = 5;
    public static final int POSITION_TOP_LEFT = 1;
    public static final int POSITION_TOP_RIGHT = 2;
    private ShapeDrawable badgeBg;
    private int badgeColor;
    private int badgeMarginH;
    private int badgeMarginV;
    private int badgePosition;
    private Context context;
    private Animation fadeIn;
    private Animation fadeOut;
    private boolean isShown;
    private View target;
    private int targetTabIndex;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9071620251070744491L, "cm/aptoide/pt/view/custom/BadgeView", 110);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[109] = true;
    }

    public BadgeView(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context2, (AttributeSet) null, 16842884);
        $jacocoInit[0] = true;
    }

    public BadgeView(Context context2, AttributeSet attrs, int defStyle) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context2, attrs, defStyle, null, 0);
        $jacocoInit[1] = true;
    }

    public BadgeView(Context context2, AttributeSet attrs, int defStyle, View target2, int tabIndex) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context2, attrs, defStyle);
        $jacocoInit[2] = true;
        init(context2, target2, tabIndex);
        $jacocoInit[3] = true;
    }

    public BadgeView(Context context2, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context2, attrs, 16842884);
        $jacocoInit[4] = true;
    }

    public BadgeView(Context context2, View target2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context2, null, 16842884, target2, 0);
        $jacocoInit[5] = true;
    }

    public BadgeView(Context context2, TabWidget target2, int index) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context2, null, 16842884, target2, index);
        $jacocoInit[6] = true;
    }

    private void init(Context context2, View target2, int tabIndex) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.target = target2;
        this.targetTabIndex = tabIndex;
        this.badgePosition = 2;
        $jacocoInit[7] = true;
        this.badgeMarginH = dipToPixels(5);
        this.badgeMarginV = this.badgeMarginH / 2;
        this.badgeColor = -1;
        $jacocoInit[8] = true;
        setTypeface(Typeface.DEFAULT_BOLD);
        $jacocoInit[9] = true;
        int paddingPixels = dipToPixels(5);
        $jacocoInit[10] = true;
        setPadding(paddingPixels, 0, paddingPixels, 0);
        $jacocoInit[11] = true;
        setTextColor(DEFAULT_TEXT_COLOR);
        $jacocoInit[12] = true;
        this.fadeIn = new AlphaAnimation(0.0f, 1.0f);
        $jacocoInit[13] = true;
        this.fadeIn.setInterpolator(new DecelerateInterpolator());
        $jacocoInit[14] = true;
        this.fadeIn.setDuration(200);
        $jacocoInit[15] = true;
        this.fadeOut = new AlphaAnimation(1.0f, 0.0f);
        $jacocoInit[16] = true;
        this.fadeOut.setInterpolator(new AccelerateInterpolator());
        $jacocoInit[17] = true;
        this.fadeOut.setDuration(200);
        this.isShown = false;
        View view = this.target;
        if (view != null) {
            $jacocoInit[18] = true;
            applyTo(view);
            $jacocoInit[19] = true;
        } else {
            show();
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
    }

    private int dipToPixels(int dip) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources r = getResources();
        $jacocoInit[22] = true;
        int applyDimension = (int) TypedValue.applyDimension(1, (float) dip, r.getDisplayMetrics());
        $jacocoInit[23] = true;
        return applyDimension;
    }

    private void applyTo(View target2) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutParams lp = target2.getLayoutParams();
        $jacocoInit[24] = true;
        ViewParent parent = target2.getParent();
        $jacocoInit[25] = true;
        FrameLayout container = new FrameLayout(this.context);
        if (target2 instanceof TabWidget) {
            $jacocoInit[26] = true;
            View target3 = ((TabWidget) target2).getChildTabViewAt(this.targetTabIndex);
            this.target = target3;
            $jacocoInit[27] = true;
            ((ViewGroup) target3).addView(container, new LayoutParams(-1, -1));
            $jacocoInit[28] = true;
            setVisibility(8);
            $jacocoInit[29] = true;
            container.addView(this);
            $jacocoInit[30] = true;
        } else {
            ViewGroup group = (ViewGroup) parent;
            $jacocoInit[31] = true;
            int index = group.indexOfChild(target2);
            $jacocoInit[32] = true;
            group.removeView(target2);
            $jacocoInit[33] = true;
            group.addView(container, index, lp);
            $jacocoInit[34] = true;
            container.addView(target2);
            $jacocoInit[35] = true;
            setVisibility(8);
            $jacocoInit[36] = true;
            container.addView(this);
            $jacocoInit[37] = true;
            group.invalidate();
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
    }

    public void show() {
        boolean[] $jacocoInit = $jacocoInit();
        show(false, null);
        $jacocoInit[40] = true;
    }

    private void show(boolean animate, Animation anim) {
        boolean[] $jacocoInit = $jacocoInit();
        if (getBackground() != null) {
            $jacocoInit[41] = true;
        } else {
            if (this.badgeBg != null) {
                $jacocoInit[42] = true;
            } else {
                $jacocoInit[43] = true;
                this.badgeBg = getDefaultBackground();
                $jacocoInit[44] = true;
            }
            setBackgroundDrawable(this.badgeBg);
            $jacocoInit[45] = true;
        }
        applyLayoutParams();
        if (!animate) {
            $jacocoInit[46] = true;
        } else {
            $jacocoInit[47] = true;
            startAnimation(anim);
            $jacocoInit[48] = true;
        }
        setVisibility(0);
        this.isShown = true;
        $jacocoInit[49] = true;
    }

    private ShapeDrawable getDefaultBackground() {
        boolean[] $jacocoInit = $jacocoInit();
        int r = dipToPixels(8);
        float[] outerR = {(float) r, (float) r, (float) r, (float) r, (float) r, (float) r, (float) r, (float) r};
        $jacocoInit[50] = true;
        RoundRectShape rr = new RoundRectShape(outerR, null, null);
        $jacocoInit[51] = true;
        ShapeDrawable drawable = new ShapeDrawable(rr);
        $jacocoInit[52] = true;
        Paint paint = drawable.getPaint();
        int i = this.badgeColor;
        $jacocoInit[53] = true;
        paint.setColor(i);
        $jacocoInit[54] = true;
        return drawable;
    }

    private void applyLayoutParams() {
        boolean[] $jacocoInit = $jacocoInit();
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        int i = this.badgePosition;
        if (i == 1) {
            lp.gravity = 51;
            $jacocoInit[56] = true;
            lp.setMargins(this.badgeMarginH, this.badgeMarginV, 0, 0);
            $jacocoInit[57] = true;
        } else if (i == 2) {
            lp.gravity = 53;
            $jacocoInit[58] = true;
            lp.setMargins(0, this.badgeMarginV, this.badgeMarginH, 0);
            $jacocoInit[59] = true;
        } else if (i == 3) {
            lp.gravity = 83;
            $jacocoInit[60] = true;
            lp.setMargins(this.badgeMarginH, 0, 0, this.badgeMarginV);
            $jacocoInit[61] = true;
        } else if (i == 4) {
            lp.gravity = 85;
            $jacocoInit[62] = true;
            lp.setMargins(0, 0, this.badgeMarginH, this.badgeMarginV);
            $jacocoInit[63] = true;
        } else if (i != 5) {
            $jacocoInit[55] = true;
        } else {
            lp.gravity = 17;
            $jacocoInit[64] = true;
            lp.setMargins(0, 0, 0, 0);
            $jacocoInit[65] = true;
        }
        setLayoutParams(lp);
        $jacocoInit[66] = true;
    }

    public void show(boolean animate) {
        boolean[] $jacocoInit = $jacocoInit();
        show(animate, this.fadeIn);
        $jacocoInit[67] = true;
    }

    public void show(Animation anim) {
        boolean[] $jacocoInit = $jacocoInit();
        show(true, anim);
        $jacocoInit[68] = true;
    }

    public void hide() {
        boolean[] $jacocoInit = $jacocoInit();
        hide(false, null);
        $jacocoInit[69] = true;
    }

    private void hide(boolean animate, Animation anim) {
        boolean[] $jacocoInit = $jacocoInit();
        setVisibility(8);
        if (!animate) {
            $jacocoInit[70] = true;
        } else {
            $jacocoInit[71] = true;
            startAnimation(anim);
            $jacocoInit[72] = true;
        }
        this.isShown = false;
        $jacocoInit[73] = true;
    }

    public void hide(boolean animate) {
        boolean[] $jacocoInit = $jacocoInit();
        hide(animate, this.fadeOut);
        $jacocoInit[74] = true;
    }

    public void hide(Animation anim) {
        boolean[] $jacocoInit = $jacocoInit();
        hide(true, anim);
        $jacocoInit[75] = true;
    }

    public void toggle() {
        boolean[] $jacocoInit = $jacocoInit();
        toggle(false, null, null);
        $jacocoInit[76] = true;
    }

    private void toggle(boolean animate, Animation animIn, Animation animOut) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (this.isShown) {
            $jacocoInit[77] = true;
            if (!animate) {
                $jacocoInit[78] = true;
            } else if (animOut == null) {
                $jacocoInit[79] = true;
            } else {
                $jacocoInit[80] = true;
                z = true;
                hide(z, animOut);
                $jacocoInit[82] = true;
            }
            $jacocoInit[81] = true;
            hide(z, animOut);
            $jacocoInit[82] = true;
        } else {
            if (!animate) {
                $jacocoInit[83] = true;
            } else if (animIn == null) {
                $jacocoInit[84] = true;
            } else {
                $jacocoInit[85] = true;
                z = true;
                show(z, animIn);
                $jacocoInit[87] = true;
            }
            $jacocoInit[86] = true;
            show(z, animIn);
            $jacocoInit[87] = true;
        }
        $jacocoInit[88] = true;
    }

    public void toggle(boolean animate) {
        boolean[] $jacocoInit = $jacocoInit();
        toggle(animate, this.fadeIn, this.fadeOut);
        $jacocoInit[89] = true;
    }

    public void toggle(Animation animIn, Animation animOut) {
        boolean[] $jacocoInit = $jacocoInit();
        toggle(true, animIn, animOut);
        $jacocoInit[90] = true;
    }

    public int decrement(int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        int increment = increment(-offset);
        $jacocoInit[91] = true;
        return increment;
    }

    public int increment(int offset) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence txt = getText();
        if (txt != null) {
            try {
                $jacocoInit[92] = true;
                i = Integer.parseInt(txt.toString());
                $jacocoInit[93] = true;
            } catch (NumberFormatException e) {
                i = 0;
                $jacocoInit[94] = true;
            }
        } else {
            i = 0;
            $jacocoInit[95] = true;
        }
        int i2 = i + offset;
        $jacocoInit[96] = true;
        setText(String.valueOf(i2));
        $jacocoInit[97] = true;
        return i2;
    }

    public View getTarget() {
        boolean[] $jacocoInit = $jacocoInit();
        View view = this.target;
        $jacocoInit[98] = true;
        return view;
    }

    public boolean isShown() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isShown;
        $jacocoInit[99] = true;
        return z;
    }

    public int getBadgePosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.badgePosition;
        $jacocoInit[100] = true;
        return i;
    }

    public void setBadgePosition(int layoutPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        this.badgePosition = layoutPosition;
        $jacocoInit[101] = true;
    }

    public int getHorizontalBadgeMargin() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.badgeMarginH;
        $jacocoInit[102] = true;
        return i;
    }

    public int getVerticalBadgeMargin() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.badgeMarginV;
        $jacocoInit[103] = true;
        return i;
    }

    public void setBadgeMargin(int badgeMargin) {
        boolean[] $jacocoInit = $jacocoInit();
        this.badgeMarginH = badgeMargin;
        this.badgeMarginV = badgeMargin;
        $jacocoInit[104] = true;
    }

    public void setBadgeMargin(int horizontal, int vertical) {
        boolean[] $jacocoInit = $jacocoInit();
        this.badgeMarginH = horizontal;
        this.badgeMarginV = vertical;
        $jacocoInit[105] = true;
    }

    public int getBadgeBackgroundColor() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.badgeColor;
        $jacocoInit[106] = true;
        return i;
    }

    public void setBadgeBackgroundColor(int badgeColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.badgeColor = badgeColor2;
        $jacocoInit[107] = true;
        this.badgeBg = getDefaultBackground();
        $jacocoInit[108] = true;
    }
}
