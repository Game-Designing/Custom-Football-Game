package p005cm.aptoide.p006pt.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0590K;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.view.p039b.C0611b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.view.CustomTextInputLayout */
public class CustomTextInputLayout extends TextInputLayout {
    private static transient /* synthetic */ boolean[] $jacocoData;
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new C0611b();
    private boolean errorEnabled = false;
    private CharSequence helperText;
    private int helperTextAppearance;
    private ColorStateList helperTextColor;
    private boolean helperTextEnabled = false;
    private TextView helperView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1440821425848078650L, "cm/aptoide/pt/view/CustomTextInputLayout", 78);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ TextView access$000(CustomTextInputLayout x0) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = x0.helperView;
        $jacocoInit[76] = true;
        return textView;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[77] = true;
    }

    public CustomTextInputLayout(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[1] = true;
        TypedArray a = getContext().obtainStyledAttributes(attrs, C1375R.styleable.CustomTextInputLayout, 0, 0);
        try {
            $jacocoInit[2] = true;
            try {
                this.helperTextColor = a.getColorStateList(1);
                $jacocoInit[3] = true;
                this.helperText = a.getText(0);
                $jacocoInit[4] = true;
                a.recycle();
                $jacocoInit[6] = true;
            } catch (Throwable th) {
                th = th;
                a.recycle();
                $jacocoInit[5] = true;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            a.recycle();
            $jacocoInit[5] = true;
            throw th;
        }
    }

    public void addView(View child, int index, LayoutParams params) {
        boolean[] $jacocoInit = $jacocoInit();
        super.addView(child, index, params);
        if (!(child instanceof EditText)) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            if (TextUtils.isEmpty(this.helperText)) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                setHelperText(this.helperText);
                $jacocoInit[11] = true;
            }
        }
        $jacocoInit[12] = true;
    }

    public void setErrorEnabled(boolean enabled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.errorEnabled == enabled) {
            $jacocoInit[13] = true;
            return;
        }
        this.errorEnabled = enabled;
        if (!enabled) {
            $jacocoInit[14] = true;
        } else if (!this.helperTextEnabled) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            setHelperTextEnabled(false);
            $jacocoInit[17] = true;
        }
        super.setErrorEnabled(enabled);
        $jacocoInit[18] = true;
        if (enabled) {
            $jacocoInit[19] = true;
        } else if (TextUtils.isEmpty(this.helperText)) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            setHelperText(this.helperText);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    private void setHelperText(CharSequence helperText2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.helperText = helperText2;
        if (this.helperTextEnabled) {
            $jacocoInit[24] = true;
        } else {
            $jacocoInit[25] = true;
            if (TextUtils.isEmpty(helperText2)) {
                $jacocoInit[26] = true;
                return;
            } else {
                setHelperTextEnabled(true);
                $jacocoInit[27] = true;
            }
        }
        if (!TextUtils.isEmpty(helperText2)) {
            $jacocoInit[28] = true;
            this.helperView.setText(helperText2);
            $jacocoInit[29] = true;
            this.helperView.setVisibility(0);
            $jacocoInit[30] = true;
            C0646w.m2947a((View) this.helperView, 0.0f);
            $jacocoInit[31] = true;
            C0587I a = C0646w.m2945a(this.helperView);
            $jacocoInit[32] = true;
            a.mo5470a(1.0f);
            $jacocoInit[33] = true;
            a.mo5471a(200);
            Interpolator interpolator = FAST_OUT_SLOW_IN_INTERPOLATOR;
            $jacocoInit[34] = true;
            a.mo5474a(interpolator);
            $jacocoInit[35] = true;
            a.mo5472a((C0589J) null);
            $jacocoInit[36] = true;
            a.mo5479c();
            $jacocoInit[37] = true;
        } else if (this.helperView.getVisibility() != 0) {
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
            C0587I a2 = C0646w.m2945a(this.helperView);
            $jacocoInit[40] = true;
            a2.mo5470a(0.0f);
            $jacocoInit[41] = true;
            a2.mo5471a(200);
            Interpolator interpolator2 = FAST_OUT_SLOW_IN_INTERPOLATOR;
            $jacocoInit[42] = true;
            a2.mo5474a(interpolator2);
            C52141 r3 = new C0590K(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ CustomTextInputLayout this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(-5061773822860985277L, "cm/aptoide/pt/view/CustomTextInputLayout$1", 3);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public void onAnimationEnd(View view) {
                    boolean[] $jacocoInit = $jacocoInit();
                    CustomTextInputLayout.access$000(this.this$0).setText(null);
                    $jacocoInit[1] = true;
                    CustomTextInputLayout.access$000(this.this$0).setVisibility(4);
                    $jacocoInit[2] = true;
                }
            };
            $jacocoInit[43] = true;
            a2.mo5472a((C0589J) r3);
            $jacocoInit[44] = true;
            a2.mo5479c();
            $jacocoInit[45] = true;
        }
        sendAccessibilityEvent(Opcodes.ACC_STRICT);
        $jacocoInit[46] = true;
    }

    public int getHelperTextAppearance() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.helperTextAppearance;
        $jacocoInit[47] = true;
        return i;
    }

    public void setHelperTextAppearance(int helperTextAppearance2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.helperTextAppearance = helperTextAppearance2;
        $jacocoInit[48] = true;
    }

    public void setHelperTextColor(ColorStateList helperTextColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.helperTextColor = helperTextColor2;
        $jacocoInit[49] = true;
    }

    public void setHelperTextEnabled(boolean enabled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.helperTextEnabled == enabled) {
            $jacocoInit[50] = true;
            return;
        }
        if (!enabled) {
            $jacocoInit[51] = true;
        } else if (!this.errorEnabled) {
            $jacocoInit[52] = true;
        } else {
            $jacocoInit[53] = true;
            setErrorEnabled(false);
            $jacocoInit[54] = true;
        }
        if (this.helperTextEnabled == enabled) {
            $jacocoInit[55] = true;
        } else {
            if (enabled) {
                $jacocoInit[56] = true;
                this.helperView = new TextView(getContext());
                $jacocoInit[57] = true;
                this.helperView.setTextSize(2, 12.0f);
                $jacocoInit[58] = true;
                this.helperView.setTextAppearance(getContext(), this.helperTextAppearance);
                ColorStateList colorStateList = this.helperTextColor;
                if (colorStateList == null) {
                    $jacocoInit[59] = true;
                } else {
                    $jacocoInit[60] = true;
                    this.helperView.setTextColor(colorStateList);
                    $jacocoInit[61] = true;
                }
                this.helperView.setText(this.helperText);
                $jacocoInit[62] = true;
                this.helperView.setVisibility(0);
                $jacocoInit[63] = true;
                addView(this.helperView);
                TextView textView = this.helperView;
                if (textView == null) {
                    $jacocoInit[64] = true;
                } else {
                    $jacocoInit[65] = true;
                    int l = C0646w.m2978l(getEditText());
                    $jacocoInit[66] = true;
                    int k = C0646w.m2977k(getEditText());
                    int paddingBottom = getEditText().getPaddingBottom();
                    $jacocoInit[67] = true;
                    C0646w.m2950a(textView, l, 0, k, paddingBottom);
                    $jacocoInit[68] = true;
                }
            } else {
                removeView(this.helperView);
                this.helperView = null;
                $jacocoInit[69] = true;
            }
            this.helperTextEnabled = enabled;
            $jacocoInit[70] = true;
        }
        $jacocoInit[71] = true;
    }

    public void setHelperTextVisibility(boolean visible) {
        boolean[] $jacocoInit = $jacocoInit();
        if (visible) {
            $jacocoInit[72] = true;
        } else {
            $jacocoInit[73] = true;
            this.helperView.setVisibility(8);
            $jacocoInit[74] = true;
        }
        $jacocoInit[75] = true;
    }
}
