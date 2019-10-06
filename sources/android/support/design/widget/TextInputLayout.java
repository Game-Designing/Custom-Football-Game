package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.widget.C0665C;
import android.support.p000v4.widget.C0679I;
import android.support.p000v4.widget.C0722t;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.C0939H;
import android.support.p001v7.widget.C0949Jb;
import android.support.p001v7.widget.C1052ea;
import android.support.p001v7.widget.C1096p;
import android.support.p001v7.widget.C1112sb;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p050d.C1172f;
import p002b.p003c.p050d.C1174h;
import p002b.p003c.p050d.C1175i;
import p002b.p003c.p050d.C1176j;
import p002b.p003c.p050d.C1177k;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p062h.p064b.p065a.C1282b;

public class TextInputLayout extends LinearLayout implements C0949Jb {
    private static final int ANIMATION_DURATION = 200;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator mAnimator;
    final C0224A mCollapsingTextHelper;
    boolean mCounterEnabled;
    private int mCounterMaxLength;
    private int mCounterOverflowTextAppearance;
    private boolean mCounterOverflowed;
    private int mCounterTextAppearance;
    private TextView mCounterView;
    private ColorStateList mDefaultTextColor;
    EditText mEditText;
    private CharSequence mError;
    private boolean mErrorEnabled;
    private boolean mErrorShown;
    private int mErrorTextAppearance;
    TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private boolean mHasPasswordToggleTintList;
    private boolean mHasPasswordToggleTintMode;
    private boolean mHasReconstructedEditTextBackground;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private boolean mHintExpanded;
    private boolean mInDrawableStateChanged;
    private LinearLayout mIndicatorArea;
    private int mIndicatorsAdded;
    private final FrameLayout mInputFrame;
    private Drawable mOriginalEditTextEndDrawable;
    private CharSequence mOriginalHint;
    private CharSequence mPasswordToggleContentDesc;
    private Drawable mPasswordToggleDrawable;
    private Drawable mPasswordToggleDummyDrawable;
    private boolean mPasswordToggleEnabled;
    private ColorStateList mPasswordToggleTintList;
    private Mode mPasswordToggleTintMode;
    private CheckableImageButton mPasswordToggleView;
    private boolean mPasswordToggledVisible;
    /* access modifiers changed from: private */
    public boolean mRestoringSavedState;
    private Paint mTmpPaint;
    private final Rect mTmpRect;
    private Typeface mTypeface;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C0287da();

        /* renamed from: c */
        CharSequence f1059c;

        /* renamed from: d */
        boolean f1060d;

        SavedState(Parcelable superState) {
            super(superState);
        }

        SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.f1059c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            boolean z = true;
            if (source.readInt() != 1) {
                z = false;
            }
            this.f1060d = z;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            TextUtils.writeToParcel(this.f1059c, dest, flags);
            dest.writeInt(this.f1060d ? 1 : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TextInputLayout.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" error=");
            sb.append(this.f1059c);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$a */
    private class C0272a extends C0616c {
        C0272a() {
        }

        /* renamed from: b */
        public void mo4625b(View host, AccessibilityEvent event) {
            super.mo4625b(host, event);
            event.setClassName(TextInputLayout.class.getSimpleName());
        }

        /* renamed from: c */
        public void mo4626c(View host, AccessibilityEvent event) {
            super.mo4626c(host, event);
            CharSequence text = TextInputLayout.this.mCollapsingTextHelper.mo4180h();
            if (!TextUtils.isEmpty(text)) {
                event.getText().add(text);
            }
        }

        /* renamed from: a */
        public void mo4150a(View host, C0604b info) {
            super.mo4150a(host, info);
            info.mo5582a((CharSequence) TextInputLayout.class.getSimpleName());
            CharSequence text = TextInputLayout.this.mCollapsingTextHelper.mo4180h();
            if (!TextUtils.isEmpty(text)) {
                info.mo5591c(text);
            }
            EditText editText = TextInputLayout.this.mEditText;
            if (editText != null) {
                info.mo5581a((View) editText);
            }
            TextView textView = TextInputLayout.this.mErrorView;
            CharSequence error = textView != null ? textView.getText() : null;
            if (!TextUtils.isEmpty(error)) {
                info.mo5592c(true);
                info.mo5587b(error);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        this.mTmpRect = new Rect();
        this.mCollapsingTextHelper = new C0224A(this);
        C0289ea.m1678a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.mInputFrame = new FrameLayout(context);
        this.mInputFrame.setAddStatesFromChildren(true);
        addView(this.mInputFrame);
        this.mCollapsingTextHelper.mo4171b(C0280a.f1075b);
        this.mCollapsingTextHelper.mo4162a((Interpolator) new AccelerateInterpolator());
        this.mCollapsingTextHelper.mo4167b(8388659);
        C1112sb a = C1112sb.m5456a(context, attrs, C1177k.TextInputLayout, defStyleAttr, C1176j.Widget_Design_TextInputLayout);
        this.mHintEnabled = a.mo8648a(C1177k.TextInputLayout_hintEnabled, true);
        setHint(a.mo8656e(C1177k.TextInputLayout_android_hint));
        this.mHintAnimationEnabled = a.mo8648a(C1177k.TextInputLayout_hintAnimationEnabled, true);
        if (a.mo8660g(C1177k.TextInputLayout_android_textColorHint)) {
            ColorStateList a2 = a.mo8645a(C1177k.TextInputLayout_android_textColorHint);
            this.mFocusedTextColor = a2;
            this.mDefaultTextColor = a2;
        }
        if (a.mo8659g(C1177k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(a.mo8659g(C1177k.TextInputLayout_hintTextAppearance, 0));
        }
        this.mErrorTextAppearance = a.mo8659g(C1177k.TextInputLayout_errorTextAppearance, 0);
        boolean errorEnabled = a.mo8648a(C1177k.TextInputLayout_errorEnabled, false);
        boolean counterEnabled = a.mo8648a(C1177k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(a.mo8653d(C1177k.TextInputLayout_counterMaxLength, -1));
        this.mCounterTextAppearance = a.mo8659g(C1177k.TextInputLayout_counterTextAppearance, 0);
        this.mCounterOverflowTextAppearance = a.mo8659g(C1177k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.mPasswordToggleEnabled = a.mo8648a(C1177k.TextInputLayout_passwordToggleEnabled, false);
        this.mPasswordToggleDrawable = a.mo8650b(C1177k.TextInputLayout_passwordToggleDrawable);
        this.mPasswordToggleContentDesc = a.mo8656e(C1177k.TextInputLayout_passwordToggleContentDescription);
        if (a.mo8660g(C1177k.TextInputLayout_passwordToggleTint)) {
            this.mHasPasswordToggleTintList = true;
            this.mPasswordToggleTintList = a.mo8645a(C1177k.TextInputLayout_passwordToggleTint);
        }
        if (a.mo8660g(C1177k.TextInputLayout_passwordToggleTintMode)) {
            this.mHasPasswordToggleTintMode = true;
            this.mPasswordToggleTintMode = C0295ha.m1689a(a.mo8653d(C1177k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        a.mo8647a();
        setErrorEnabled(errorEnabled);
        setCounterEnabled(counterEnabled);
        applyPasswordToggleTint();
        if (C0646w.m2973g(this) == 0) {
            C0646w.m2970d(this, 1);
        }
        C0646w.m2955a((View) this, (C0616c) new C0272a());
    }

    public void addView(View child, int index, LayoutParams params) {
        if (child instanceof EditText) {
            FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(params);
            flp.gravity = (flp.gravity & -113) | 16;
            this.mInputFrame.addView(child, flp);
            this.mInputFrame.setLayoutParams(params);
            updateInputLayoutMargins();
            setEditText((EditText) child);
            return;
        }
        super.addView(child, index, params);
    }

    public void setTypeface(Typeface typeface) {
        Typeface typeface2 = this.mTypeface;
        if ((typeface2 != null && !typeface2.equals(typeface)) || (this.mTypeface == null && typeface != null)) {
            this.mTypeface = typeface;
            this.mCollapsingTextHelper.mo4174c(typeface);
            TextView textView = this.mCounterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
            TextView textView2 = this.mErrorView;
            if (textView2 != null) {
                textView2.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public void dispatchProvideAutofillStructure(ViewStructure structure, int flags) {
        if (this.mOriginalHint != null) {
            EditText editText = this.mEditText;
            if (editText != null) {
                CharSequence hint = editText.getHint();
                this.mEditText.setHint(this.mOriginalHint);
                try {
                    super.dispatchProvideAutofillStructure(structure, flags);
                    return;
                } finally {
                    this.mEditText.setHint(hint);
                }
            }
        }
        super.dispatchProvideAutofillStructure(structure, flags);
    }

    private void setEditText(EditText editText) {
        if (this.mEditText == null) {
            if (!(editText instanceof C0277X)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.mEditText = editText;
            if (!hasPasswordTransformation()) {
                this.mCollapsingTextHelper.mo4174c(this.mEditText.getTypeface());
            }
            this.mCollapsingTextHelper.mo4156a(this.mEditText.getTextSize());
            int editTextGravity = this.mEditText.getGravity();
            this.mCollapsingTextHelper.mo4167b((editTextGravity & -113) | 48);
            this.mCollapsingTextHelper.mo4176d(editTextGravity);
            this.mEditText.addTextChangedListener(new C0278Y(this));
            if (this.mDefaultTextColor == null) {
                this.mDefaultTextColor = this.mEditText.getHintTextColors();
            }
            if (this.mHintEnabled && TextUtils.isEmpty(this.mHint)) {
                this.mOriginalHint = this.mEditText.getHint();
                setHint(this.mOriginalHint);
                this.mEditText.setHint(null);
            }
            if (this.mCounterView != null) {
                updateCounter(this.mEditText.getText().length());
            }
            if (this.mIndicatorArea != null) {
                adjustIndicatorPadding();
            }
            updatePasswordToggleView();
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void updateInputLayoutMargins() {
        int newTopMargin;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mInputFrame.getLayoutParams();
        if (this.mHintEnabled) {
            if (this.mTmpPaint == null) {
                this.mTmpPaint = new Paint();
            }
            this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.mo4175d());
            this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.mo4172c());
            newTopMargin = (int) (-this.mTmpPaint.ascent());
        } else {
            newTopMargin = 0;
        }
        if (newTopMargin != lp.topMargin) {
            lp.topMargin = newTopMargin;
            this.mInputFrame.requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateLabelState(boolean animate) {
        updateLabelState(animate, false);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateLabelState(boolean r7, boolean r8) {
        /*
            r6 = this;
            boolean r0 = r6.isEnabled()
            android.widget.EditText r1 = r6.mEditText
            r2 = 1
            if (r1 == 0) goto L_0x0015
            android.text.Editable r1 = r1.getText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0015
            r1 = 1
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            int[] r3 = r6.getDrawableState()
            r4 = 16842908(0x101009c, float:2.3693995E-38)
            boolean r3 = arrayContains(r3, r4)
            java.lang.CharSequence r4 = r6.getError()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r2 = r2 ^ r4
            android.content.res.ColorStateList r4 = r6.mDefaultTextColor
            if (r4 == 0) goto L_0x0033
            android.support.design.widget.A r5 = r6.mCollapsingTextHelper
            r5.mo4169b(r4)
        L_0x0033:
            if (r0 == 0) goto L_0x0047
            boolean r4 = r6.mCounterOverflowed
            if (r4 == 0) goto L_0x0047
            android.widget.TextView r4 = r6.mCounterView
            if (r4 == 0) goto L_0x0047
            android.support.design.widget.A r5 = r6.mCollapsingTextHelper
            android.content.res.ColorStateList r4 = r4.getTextColors()
            r5.mo4159a(r4)
            goto L_0x005e
        L_0x0047:
            if (r0 == 0) goto L_0x0055
            if (r3 == 0) goto L_0x0055
            android.content.res.ColorStateList r4 = r6.mFocusedTextColor
            if (r4 == 0) goto L_0x0055
            android.support.design.widget.A r5 = r6.mCollapsingTextHelper
            r5.mo4159a(r4)
            goto L_0x005e
        L_0x0055:
            android.content.res.ColorStateList r4 = r6.mDefaultTextColor
            if (r4 == 0) goto L_0x005e
            android.support.design.widget.A r5 = r6.mCollapsingTextHelper
            r5.mo4159a(r4)
        L_0x005e:
            if (r1 != 0) goto L_0x0075
            boolean r4 = r6.isEnabled()
            if (r4 == 0) goto L_0x006b
            if (r3 != 0) goto L_0x0075
            if (r2 == 0) goto L_0x006b
            goto L_0x0075
        L_0x006b:
            if (r8 != 0) goto L_0x0071
            boolean r4 = r6.mHintExpanded
            if (r4 != 0) goto L_0x007e
        L_0x0071:
            r6.expandHint(r7)
            goto L_0x007e
        L_0x0075:
            if (r8 != 0) goto L_0x007b
            boolean r4 = r6.mHintExpanded
            if (r4 == 0) goto L_0x007e
        L_0x007b:
            r6.collapseHint(r7)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.updateLabelState(boolean, boolean):void");
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public void setHint(CharSequence hint) {
        if (this.mHintEnabled) {
            setHintInternal(hint);
            sendAccessibilityEvent(Opcodes.ACC_STRICT);
        }
    }

    private void setHintInternal(CharSequence hint) {
        this.mHint = hint;
        this.mCollapsingTextHelper.mo4163a(hint);
    }

    public CharSequence getHint() {
        if (this.mHintEnabled) {
            return this.mHint;
        }
        return null;
    }

    public void setHintEnabled(boolean enabled) {
        if (enabled != this.mHintEnabled) {
            this.mHintEnabled = enabled;
            CharSequence editTextHint = this.mEditText.getHint();
            if (!this.mHintEnabled) {
                if (!TextUtils.isEmpty(this.mHint) && TextUtils.isEmpty(editTextHint)) {
                    this.mEditText.setHint(this.mHint);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(editTextHint)) {
                if (TextUtils.isEmpty(this.mHint)) {
                    setHint(editTextHint);
                }
                this.mEditText.setHint(null);
            }
            if (this.mEditText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.mHintEnabled;
    }

    public void setHintTextAppearance(int resId) {
        this.mCollapsingTextHelper.mo4157a(resId);
        this.mFocusedTextColor = this.mCollapsingTextHelper.mo4155a();
        if (this.mEditText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    private void addIndicator(TextView indicator, int index) {
        if (this.mIndicatorArea == null) {
            this.mIndicatorArea = new LinearLayout(getContext());
            this.mIndicatorArea.setOrientation(0);
            addView(this.mIndicatorArea, -1, -2);
            this.mIndicatorArea.addView(new C0722t(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.mEditText != null) {
                adjustIndicatorPadding();
            }
        }
        this.mIndicatorArea.setVisibility(0);
        this.mIndicatorArea.addView(indicator, index);
        this.mIndicatorsAdded++;
    }

    private void adjustIndicatorPadding() {
        C0646w.m2950a(this.mIndicatorArea, C0646w.m2978l(this.mEditText), 0, C0646w.m2977k(this.mEditText), this.mEditText.getPaddingBottom());
    }

    private void removeIndicator(TextView indicator) {
        LinearLayout linearLayout = this.mIndicatorArea;
        if (linearLayout != null) {
            linearLayout.removeView(indicator);
            int i = this.mIndicatorsAdded - 1;
            this.mIndicatorsAdded = i;
            if (i == 0) {
                this.mIndicatorArea.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean enabled) {
        if (this.mErrorEnabled != enabled) {
            TextView textView = this.mErrorView;
            if (textView != null) {
                textView.animate().cancel();
            }
            if (enabled) {
                this.mErrorView = new C0939H(getContext());
                this.mErrorView.setId(C1172f.textinput_error);
                Typeface typeface = this.mTypeface;
                if (typeface != null) {
                    this.mErrorView.setTypeface(typeface);
                }
                boolean useDefaultColor = false;
                try {
                    C0665C.m3099a(this.mErrorView, this.mErrorTextAppearance);
                    if (VERSION.SDK_INT >= 23 && this.mErrorView.getTextColors().getDefaultColor() == -65281) {
                        useDefaultColor = true;
                    }
                } catch (Exception e) {
                    useDefaultColor = true;
                }
                if (useDefaultColor) {
                    C0665C.m3099a(this.mErrorView, C0793R.style.TextAppearance_AppCompat_Caption);
                    this.mErrorView.setTextColor(C0510b.m2564a(getContext(), C0793R.color.error_color_material));
                }
                this.mErrorView.setVisibility(4);
                C0646w.m2968c(this.mErrorView, 1);
                addIndicator(this.mErrorView, 0);
            } else {
                this.mErrorShown = false;
                updateEditTextBackground();
                removeIndicator(this.mErrorView);
                this.mErrorView = null;
            }
            this.mErrorEnabled = enabled;
        }
    }

    public void setErrorTextAppearance(int resId) {
        this.mErrorTextAppearance = resId;
        TextView textView = this.mErrorView;
        if (textView != null) {
            C0665C.m3099a(textView, resId);
        }
    }

    public boolean isErrorEnabled() {
        return this.mErrorEnabled;
    }

    public void setError(CharSequence error) {
        boolean z;
        if (C0646w.m2987u(this) && isEnabled()) {
            TextView textView = this.mErrorView;
            if (textView == null || !TextUtils.equals(textView.getText(), error)) {
                z = true;
                setError(error, z);
            }
        }
        z = false;
        setError(error, z);
    }

    private void setError(CharSequence error, boolean animate) {
        this.mError = error;
        if (!this.mErrorEnabled) {
            if (!TextUtils.isEmpty(error)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.mErrorShown = !TextUtils.isEmpty(error);
        this.mErrorView.animate().cancel();
        if (this.mErrorShown) {
            this.mErrorView.setText(error);
            this.mErrorView.setVisibility(0);
            if (animate) {
                if (this.mErrorView.getAlpha() == 1.0f) {
                    this.mErrorView.setAlpha(0.0f);
                }
                this.mErrorView.animate().alpha(1.0f).setDuration(200).setInterpolator(C0280a.f1077d).setListener(new C0279Z(this)).start();
            } else {
                this.mErrorView.setAlpha(1.0f);
            }
        } else if (this.mErrorView.getVisibility() == 0) {
            if (animate) {
                this.mErrorView.animate().alpha(0.0f).setDuration(200).setInterpolator(C0280a.f1076c).setListener(new C0281aa(this, error)).start();
            } else {
                this.mErrorView.setText(error);
                this.mErrorView.setVisibility(4);
            }
        }
        updateEditTextBackground();
        updateLabelState(animate);
    }

    public void setCounterEnabled(boolean enabled) {
        if (this.mCounterEnabled != enabled) {
            if (enabled) {
                this.mCounterView = new C0939H(getContext());
                this.mCounterView.setId(C1172f.textinput_counter);
                Typeface typeface = this.mTypeface;
                if (typeface != null) {
                    this.mCounterView.setTypeface(typeface);
                }
                this.mCounterView.setMaxLines(1);
                try {
                    C0665C.m3099a(this.mCounterView, this.mCounterTextAppearance);
                } catch (Exception e) {
                    C0665C.m3099a(this.mCounterView, C0793R.style.TextAppearance_AppCompat_Caption);
                    this.mCounterView.setTextColor(C0510b.m2564a(getContext(), C0793R.color.error_color_material));
                }
                addIndicator(this.mCounterView, -1);
                EditText editText = this.mEditText;
                if (editText == null) {
                    updateCounter(0);
                } else {
                    updateCounter(editText.getText().length());
                }
            } else {
                removeIndicator(this.mCounterView);
                this.mCounterView = null;
            }
            this.mCounterEnabled = enabled;
        }
    }

    public boolean isCounterEnabled() {
        return this.mCounterEnabled;
    }

    public void setCounterMaxLength(int maxLength) {
        if (this.mCounterMaxLength != maxLength) {
            if (maxLength > 0) {
                this.mCounterMaxLength = maxLength;
            } else {
                this.mCounterMaxLength = -1;
            }
            if (this.mCounterEnabled) {
                EditText editText = this.mEditText;
                updateCounter(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setEnabled(boolean enabled) {
        recursiveSetEnabled(this, enabled);
        super.setEnabled(enabled);
    }

    private static void recursiveSetEnabled(ViewGroup vg, boolean enabled) {
        int count = vg.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = vg.getChildAt(i);
            child.setEnabled(enabled);
            if (child instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) child, enabled);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.mCounterMaxLength;
    }

    /* access modifiers changed from: 0000 */
    public void updateCounter(int length) {
        boolean wasCounterOverflowed = this.mCounterOverflowed;
        int i = this.mCounterMaxLength;
        if (i == -1) {
            this.mCounterView.setText(String.valueOf(length));
            this.mCounterOverflowed = false;
        } else {
            this.mCounterOverflowed = length > i;
            boolean z = this.mCounterOverflowed;
            if (wasCounterOverflowed != z) {
                C0665C.m3099a(this.mCounterView, z ? this.mCounterOverflowTextAppearance : this.mCounterTextAppearance);
            }
            this.mCounterView.setText(getContext().getString(C1175i.character_counter_pattern, new Object[]{Integer.valueOf(length), Integer.valueOf(this.mCounterMaxLength)}));
        }
        if (this.mEditText != null && wasCounterOverflowed != this.mCounterOverflowed) {
            updateLabelState(false);
            updateEditTextBackground();
        }
    }

    private void updateEditTextBackground() {
        EditText editText = this.mEditText;
        if (editText != null) {
            Drawable editTextBackground = editText.getBackground();
            if (editTextBackground != null) {
                ensureBackgroundDrawableStateWorkaround();
                if (C1052ea.m5228a(editTextBackground)) {
                    editTextBackground = editTextBackground.mutate();
                }
                if (this.mErrorShown) {
                    TextView textView = this.mErrorView;
                    if (textView != null) {
                        editTextBackground.setColorFilter(C1096p.m5416a(textView.getCurrentTextColor(), Mode.SRC_IN));
                    }
                }
                if (this.mCounterOverflowed) {
                    TextView textView2 = this.mCounterView;
                    if (textView2 != null) {
                        editTextBackground.setColorFilter(C1096p.m5416a(textView2.getCurrentTextColor(), Mode.SRC_IN));
                    }
                }
                C1200a.m5733b(editTextBackground);
                this.mEditText.refreshDrawableState();
            }
        }
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int sdk = VERSION.SDK_INT;
        if (sdk == 21 || sdk == 22) {
            Drawable bg = this.mEditText.getBackground();
            if (bg != null && !this.mHasReconstructedEditTextBackground) {
                Drawable newBg = bg.getConstantState().newDrawable();
                if (bg instanceof DrawableContainer) {
                    this.mHasReconstructedEditTextBackground = C0244F.m1506a((DrawableContainer) bg, newBg.getConstantState());
                }
                if (!this.mHasReconstructedEditTextBackground) {
                    C0646w.m2954a((View) this.mEditText, newBg);
                    this.mHasReconstructedEditTextBackground = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        if (this.mErrorShown) {
            ss.f1059c = getError();
        }
        ss.f1060d = this.mPasswordToggledVisible;
        return ss;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.mo5452a());
        setError(ss.f1059c);
        if (ss.f1060d) {
            passwordVisibilityToggleRequested(true);
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        this.mRestoringSavedState = true;
        super.dispatchRestoreInstanceState(container);
        this.mRestoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.mErrorEnabled) {
            return this.mError;
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean enabled) {
        this.mHintAnimationEnabled = enabled;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mHintEnabled) {
            this.mCollapsingTextHelper.mo4160a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        updatePasswordToggleView();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void updatePasswordToggleView() {
        if (this.mEditText != null) {
            if (shouldShowPasswordIcon()) {
                if (this.mPasswordToggleView == null) {
                    this.mPasswordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C1174h.design_text_input_password_icon, this.mInputFrame, false);
                    this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
                    this.mPasswordToggleView.setContentDescription(this.mPasswordToggleContentDesc);
                    this.mInputFrame.addView(this.mPasswordToggleView);
                    this.mPasswordToggleView.setOnClickListener(new C0283ba(this));
                }
                EditText editText = this.mEditText;
                if (editText != null && C0646w.m2975i(editText) <= 0) {
                    this.mEditText.setMinimumHeight(C0646w.m2975i(this.mPasswordToggleView));
                }
                this.mPasswordToggleView.setVisibility(0);
                this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
                if (this.mPasswordToggleDummyDrawable == null) {
                    this.mPasswordToggleDummyDrawable = new ColorDrawable();
                }
                this.mPasswordToggleDummyDrawable.setBounds(0, 0, this.mPasswordToggleView.getMeasuredWidth(), 1);
                Drawable[] compounds = C0665C.m3102a(this.mEditText);
                if (compounds[2] != this.mPasswordToggleDummyDrawable) {
                    this.mOriginalEditTextEndDrawable = compounds[2];
                }
                C0665C.m3101a((TextView) this.mEditText, compounds[0], compounds[1], this.mPasswordToggleDummyDrawable, compounds[3]);
                this.mPasswordToggleView.setPadding(this.mEditText.getPaddingLeft(), this.mEditText.getPaddingTop(), this.mEditText.getPaddingRight(), this.mEditText.getPaddingBottom());
            } else {
                CheckableImageButton checkableImageButton = this.mPasswordToggleView;
                if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
                    this.mPasswordToggleView.setVisibility(8);
                }
                if (this.mPasswordToggleDummyDrawable != null) {
                    Drawable[] compounds2 = C0665C.m3102a(this.mEditText);
                    if (compounds2[2] == this.mPasswordToggleDummyDrawable) {
                        C0665C.m3101a((TextView) this.mEditText, compounds2[0], compounds2[1], this.mOriginalEditTextEndDrawable, compounds2[3]);
                        this.mPasswordToggleDummyDrawable = null;
                    }
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int resId) {
        setPasswordVisibilityToggleDrawable(resId != 0 ? C1282b.m6000b(getContext(), resId) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable icon) {
        this.mPasswordToggleDrawable = icon;
        CheckableImageButton checkableImageButton = this.mPasswordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(icon);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int resId) {
        setPasswordVisibilityToggleContentDescription(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence description) {
        this.mPasswordToggleContentDesc = description;
        CheckableImageButton checkableImageButton = this.mPasswordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(description);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.mPasswordToggleDrawable;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.mPasswordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.mPasswordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean enabled) {
        if (this.mPasswordToggleEnabled != enabled) {
            this.mPasswordToggleEnabled = enabled;
            if (!enabled && this.mPasswordToggledVisible) {
                EditText editText = this.mEditText;
                if (editText != null) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            this.mPasswordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList tintList) {
        this.mPasswordToggleTintList = tintList;
        this.mHasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.mPasswordToggleTintMode = mode;
        this.mHasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    /* access modifiers changed from: private */
    public void passwordVisibilityToggleRequested(boolean shouldSkipAnimations) {
        if (this.mPasswordToggleEnabled) {
            int selection = this.mEditText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.mEditText.setTransformationMethod(null);
                this.mPasswordToggledVisible = true;
            } else {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mPasswordToggledVisible = false;
            }
            this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
            if (shouldSkipAnimations) {
                this.mPasswordToggleView.jumpDrawablesToCurrentState();
            }
            this.mEditText.setSelection(selection);
        }
    }

    private boolean hasPasswordTransformation() {
        EditText editText = this.mEditText;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.mPasswordToggleEnabled && (hasPasswordTransformation() || this.mPasswordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.mPasswordToggleDrawable == null) {
            return;
        }
        if (this.mHasPasswordToggleTintList || this.mHasPasswordToggleTintMode) {
            this.mPasswordToggleDrawable = C1200a.m5741i(this.mPasswordToggleDrawable).mutate();
            if (this.mHasPasswordToggleTintList) {
                C1200a.m5726a(this.mPasswordToggleDrawable, this.mPasswordToggleTintList);
            }
            if (this.mHasPasswordToggleTintMode) {
                C1200a.m5729a(this.mPasswordToggleDrawable, this.mPasswordToggleTintMode);
            }
            CheckableImageButton checkableImageButton = this.mPasswordToggleView;
            if (checkableImageButton != null) {
                Drawable drawable = checkableImageButton.getDrawable();
                Drawable drawable2 = this.mPasswordToggleDrawable;
                if (drawable != drawable2) {
                    this.mPasswordToggleView.setImageDrawable(drawable2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mHintEnabled) {
            EditText editText = this.mEditText;
            if (editText != null) {
                Rect rect = this.mTmpRect;
                C0679I.m3163a((ViewGroup) this, (View) editText, rect);
                int l = rect.left + this.mEditText.getCompoundPaddingLeft();
                int r = rect.right - this.mEditText.getCompoundPaddingRight();
                this.mCollapsingTextHelper.mo4168b(l, rect.top + this.mEditText.getCompoundPaddingTop(), r, rect.bottom - this.mEditText.getCompoundPaddingBottom());
                this.mCollapsingTextHelper.mo4158a(l, getPaddingTop(), r, (bottom - top) - getPaddingBottom());
                this.mCollapsingTextHelper.mo4183k();
            }
        }
    }

    private void collapseHint(boolean animate) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (!animate || !this.mHintAnimationEnabled) {
            this.mCollapsingTextHelper.mo4166b(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.mHintExpanded = false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.mInDrawableStateChanged) {
            boolean z = true;
            this.mInDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] state = getDrawableState();
            boolean changed = false;
            if (!C0646w.m2987u(this) || !isEnabled()) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            C0224A a = this.mCollapsingTextHelper;
            if (a != null) {
                changed = false | a.mo4164a(state);
            }
            if (changed) {
                invalidate();
            }
            this.mInDrawableStateChanged = false;
        }
    }

    private void expandHint(boolean animate) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (!animate || !this.mHintAnimationEnabled) {
            this.mCollapsingTextHelper.mo4166b(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
        this.mHintExpanded = true;
    }

    /* access modifiers changed from: 0000 */
    public void animateToExpansionFraction(float target) {
        if (this.mCollapsingTextHelper.mo4179g() != target) {
            if (this.mAnimator == null) {
                this.mAnimator = new ValueAnimator();
                this.mAnimator.setInterpolator(C0280a.f1074a);
                this.mAnimator.setDuration(200);
                this.mAnimator.addUpdateListener(new C0285ca(this));
            }
            this.mAnimator.setFloatValues(new float[]{this.mCollapsingTextHelper.mo4179g(), target});
            this.mAnimator.start();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean isHintExpanded() {
        return this.mHintExpanded;
    }

    private static boolean arrayContains(int[] array, int value) {
        for (int v : array) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }
}
