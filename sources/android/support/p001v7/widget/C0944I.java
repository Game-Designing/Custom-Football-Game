package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.p001v7.appcompat.C0793R;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p005cm.aptoide.p006pt.file.CacheHelper;

/* renamed from: android.support.v7.widget.I */
/* compiled from: AppCompatTextViewAutoSizeHelper */
class C0944I {

    /* renamed from: a */
    private static final RectF f3004a = new RectF();

    /* renamed from: b */
    private static ConcurrentHashMap<String, Method> f3005b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private int f3006c = 0;

    /* renamed from: d */
    private boolean f3007d = false;

    /* renamed from: e */
    private float f3008e = -1.0f;

    /* renamed from: f */
    private float f3009f = -1.0f;

    /* renamed from: g */
    private float f3010g = -1.0f;

    /* renamed from: h */
    private int[] f3011h = new int[0];

    /* renamed from: i */
    private boolean f3012i = false;

    /* renamed from: j */
    private TextPaint f3013j;

    /* renamed from: k */
    private final TextView f3014k;

    /* renamed from: l */
    private final Context f3015l;

    C0944I(TextView textView) {
        this.f3014k = textView;
        this.f3015l = this.f3014k.getContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7329a(AttributeSet attrs, int defStyleAttr) {
        float autoSizeMinTextSizeInPx = -1.0f;
        float autoSizeMaxTextSizeInPx = -1.0f;
        float autoSizeStepGranularityInPx = -1.0f;
        TypedArray a = this.f3015l.obtainStyledAttributes(attrs, C0793R.styleable.AppCompatTextView, defStyleAttr, 0);
        if (a.hasValue(C0793R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f3006c = a.getInt(C0793R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        if (a.hasValue(C0793R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
            autoSizeStepGranularityInPx = a.getDimension(C0793R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f);
        }
        if (a.hasValue(C0793R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
            autoSizeMinTextSizeInPx = a.getDimension(C0793R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f);
        }
        if (a.hasValue(C0793R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
            autoSizeMaxTextSizeInPx = a.getDimension(C0793R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f);
        }
        if (a.hasValue(C0793R.styleable.AppCompatTextView_autoSizePresetSizes)) {
            int autoSizeStepSizeArrayResId = a.getResourceId(C0793R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if (autoSizeStepSizeArrayResId > 0) {
                TypedArray autoSizePreDefTextSizes = a.getResources().obtainTypedArray(autoSizeStepSizeArrayResId);
                m4540a(autoSizePreDefTextSizes);
                autoSizePreDefTextSizes.recycle();
            }
        }
        a.recycle();
        if (!m4546k()) {
            this.f3006c = 0;
        } else if (this.f3006c == 1) {
            if (!this.f3012i) {
                DisplayMetrics displayMetrics = this.f3015l.getResources().getDisplayMetrics();
                if (autoSizeMinTextSizeInPx == -1.0f) {
                    autoSizeMinTextSizeInPx = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (autoSizeMaxTextSizeInPx == -1.0f) {
                    autoSizeMaxTextSizeInPx = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (autoSizeStepGranularityInPx == -1.0f) {
                    autoSizeStepGranularityInPx = 1.0f;
                }
                m4539a(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, autoSizeStepGranularityInPx);
            }
            m4544i();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7326a(int autoSizeTextType) {
        if (!m4546k()) {
            return;
        }
        if (autoSizeTextType == 0) {
            m4543h();
        } else if (autoSizeTextType == 1) {
            DisplayMetrics displayMetrics = this.f3015l.getResources().getDisplayMetrics();
            m4539a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (m4544i()) {
                mo7325a();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown auto-size text type: ");
            sb.append(autoSizeTextType);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7328a(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) throws IllegalArgumentException {
        if (m4546k()) {
            DisplayMetrics displayMetrics = this.f3015l.getResources().getDisplayMetrics();
            m4539a(TypedValue.applyDimension(unit, (float) autoSizeMinTextSize, displayMetrics), TypedValue.applyDimension(unit, (float) autoSizeMaxTextSize, displayMetrics), TypedValue.applyDimension(unit, (float) autoSizeStepGranularity, displayMetrics));
            if (m4544i()) {
                mo7325a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7330a(int[] presetSizes, int unit) throws IllegalArgumentException {
        if (m4546k()) {
            int presetSizesLength = presetSizes.length;
            if (presetSizesLength > 0) {
                int[] presetSizesInPx = new int[presetSizesLength];
                if (unit == 0) {
                    presetSizesInPx = Arrays.copyOf(presetSizes, presetSizesLength);
                } else {
                    DisplayMetrics displayMetrics = this.f3015l.getResources().getDisplayMetrics();
                    for (int i = 0; i < presetSizesLength; i++) {
                        presetSizesInPx[i] = Math.round(TypedValue.applyDimension(unit, (float) presetSizes[i], displayMetrics));
                    }
                }
                this.f3011h = m4542a(presetSizesInPx);
                if (!m4545j()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("None of the preset sizes is valid: ");
                    sb.append(Arrays.toString(presetSizes));
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                this.f3012i = false;
            }
            if (m4544i()) {
                mo7325a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo7335f() {
        return this.f3006c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo7333d() {
        return Math.round(this.f3008e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo7332c() {
        return Math.round(this.f3009f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo7331b() {
        return Math.round(this.f3010g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int[] mo7334e() {
        return this.f3011h;
    }

    /* renamed from: a */
    private void m4540a(TypedArray textSizes) {
        int textSizesLength = textSizes.length();
        int[] parsedSizes = new int[textSizesLength];
        if (textSizesLength > 0) {
            for (int i = 0; i < textSizesLength; i++) {
                parsedSizes[i] = textSizes.getDimensionPixelSize(i, -1);
            }
            this.f3011h = m4542a(parsedSizes);
            m4545j();
        }
    }

    /* renamed from: j */
    private boolean m4545j() {
        int sizesLength = this.f3011h.length;
        this.f3012i = sizesLength > 0;
        if (this.f3012i) {
            this.f3006c = 1;
            int[] iArr = this.f3011h;
            this.f3009f = (float) iArr[0];
            this.f3010g = (float) iArr[sizesLength - 1];
            this.f3008e = -1.0f;
        }
        return this.f3012i;
    }

    /* renamed from: a */
    private int[] m4542a(int[] presetValues) {
        if (presetValuesLength == 0) {
            return presetValues;
        }
        Arrays.sort(presetValues);
        List<Integer> uniqueValidSizes = new ArrayList<>();
        for (int currentPresetValue : presetValues) {
            if (currentPresetValue > 0 && Collections.binarySearch(uniqueValidSizes, Integer.valueOf(currentPresetValue)) < 0) {
                uniqueValidSizes.add(Integer.valueOf(currentPresetValue));
            }
        }
        if (presetValuesLength == uniqueValidSizes.size()) {
            return presetValues;
        }
        int uniqueValidSizesLength = uniqueValidSizes.size();
        int[] cleanedUpSizes = new int[uniqueValidSizesLength];
        for (int i = 0; i < uniqueValidSizesLength; i++) {
            cleanedUpSizes[i] = ((Integer) uniqueValidSizes.get(i)).intValue();
        }
        return cleanedUpSizes;
    }

    /* renamed from: a */
    private void m4539a(float autoSizeMinTextSizeInPx, float autoSizeMaxTextSizeInPx, float autoSizeStepGranularityInPx) throws IllegalArgumentException {
        String str = "px) is less or equal to (0px)";
        if (autoSizeMinTextSizeInPx <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Minimum auto-size text size (");
            sb.append(autoSizeMinTextSizeInPx);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (autoSizeMaxTextSizeInPx <= autoSizeMinTextSizeInPx) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Maximum auto-size text size (");
            sb2.append(autoSizeMaxTextSizeInPx);
            sb2.append("px) is less or equal to minimum auto-size ");
            sb2.append("text size (");
            sb2.append(autoSizeMinTextSizeInPx);
            sb2.append("px)");
            throw new IllegalArgumentException(sb2.toString());
        } else if (autoSizeStepGranularityInPx > 0.0f) {
            this.f3006c = 1;
            this.f3009f = autoSizeMinTextSizeInPx;
            this.f3010g = autoSizeMaxTextSizeInPx;
            this.f3008e = autoSizeStepGranularityInPx;
            this.f3012i = false;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("The auto-size step granularity (");
            sb3.append(autoSizeStepGranularityInPx);
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: i */
    private boolean m4544i() {
        if (!m4546k() || this.f3006c != 1) {
            this.f3007d = false;
        } else {
            if (!this.f3012i || this.f3011h.length == 0) {
                int autoSizeValuesLength = 1;
                float currentSize = (float) Math.round(this.f3009f);
                while (Math.round(this.f3008e + currentSize) <= Math.round(this.f3010g)) {
                    autoSizeValuesLength++;
                    currentSize += this.f3008e;
                }
                int[] autoSizeTextSizesInPx = new int[autoSizeValuesLength];
                float sizeToAdd = this.f3009f;
                for (int i = 0; i < autoSizeValuesLength; i++) {
                    autoSizeTextSizesInPx[i] = Math.round(sizeToAdd);
                    sizeToAdd += this.f3008e;
                }
                this.f3011h = m4542a(autoSizeTextSizesInPx);
            }
            this.f3007d = true;
        }
        return this.f3007d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7325a() {
        int availableWidth;
        if (mo7336g()) {
            if (this.f3007d) {
                if (this.f3014k.getMeasuredHeight() > 0 && this.f3014k.getMeasuredWidth() > 0) {
                    if (((Boolean) m4536a((Object) this.f3014k, "getHorizontallyScrolling", (T) Boolean.valueOf(false))).booleanValue()) {
                        availableWidth = CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES;
                    } else {
                        availableWidth = (this.f3014k.getMeasuredWidth() - this.f3014k.getTotalPaddingLeft()) - this.f3014k.getTotalPaddingRight();
                    }
                    int availableHeight = (this.f3014k.getHeight() - this.f3014k.getCompoundPaddingBottom()) - this.f3014k.getCompoundPaddingTop();
                    if (availableWidth > 0 && availableHeight > 0) {
                        synchronized (f3004a) {
                            f3004a.setEmpty();
                            f3004a.right = (float) availableWidth;
                            f3004a.bottom = (float) availableHeight;
                            float optimalTextSize = (float) m4533a(f3004a);
                            if (optimalTextSize != this.f3014k.getTextSize()) {
                                mo7327a(0, optimalTextSize);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f3007d = true;
        }
    }

    /* renamed from: h */
    private void m4543h() {
        this.f3006c = 0;
        this.f3009f = -1.0f;
        this.f3010g = -1.0f;
        this.f3008e = -1.0f;
        this.f3011h = new int[0];
        this.f3007d = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7327a(int unit, float size) {
        Resources res;
        Context context = this.f3015l;
        if (context == null) {
            res = Resources.getSystem();
        } else {
            res = context.getResources();
        }
        m4538a(TypedValue.applyDimension(unit, size, res.getDisplayMetrics()));
    }

    /* renamed from: a */
    private void m4538a(float size) {
        if (size != this.f3014k.getPaint().getTextSize()) {
            this.f3014k.getPaint().setTextSize(size);
            boolean isInLayout = false;
            if (VERSION.SDK_INT >= 18) {
                isInLayout = this.f3014k.isInLayout();
            }
            if (this.f3014k.getLayout() != null) {
                this.f3007d = false;
                String str = "nullLayouts";
                try {
                    Method method = m4537a("nullLayouts");
                    if (method != null) {
                        method.invoke(this.f3014k, new Object[0]);
                    }
                } catch (Exception ex) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", ex);
                }
                if (!isInLayout) {
                    this.f3014k.requestLayout();
                } else {
                    this.f3014k.forceLayout();
                }
                this.f3014k.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m4533a(RectF availableSpace) {
        int sizesCount = this.f3011h.length;
        if (sizesCount != 0) {
            int bestSizeIndex = 0;
            int lowIndex = 0 + 1;
            int highIndex = sizesCount - 1;
            while (lowIndex <= highIndex) {
                int sizeToTryIndex = (lowIndex + highIndex) / 2;
                if (m4541a(this.f3011h[sizeToTryIndex], availableSpace)) {
                    bestSizeIndex = lowIndex;
                    lowIndex = sizeToTryIndex + 1;
                } else {
                    highIndex = sizeToTryIndex - 1;
                    bestSizeIndex = highIndex;
                }
            }
            return this.f3011h[bestSizeIndex];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* renamed from: a */
    private boolean m4541a(int suggestedSizeInPx, RectF availableSpace) {
        StaticLayout layout;
        CharSequence text = this.f3014k.getText();
        TransformationMethod transformationMethod = this.f3014k.getTransformationMethod();
        if (transformationMethod != null) {
            CharSequence transformedText = transformationMethod.getTransformation(text, this.f3014k);
            if (transformedText != null) {
                text = transformedText;
            }
        }
        int maxLines = VERSION.SDK_INT >= 16 ? this.f3014k.getMaxLines() : -1;
        TextPaint textPaint = this.f3013j;
        if (textPaint == null) {
            this.f3013j = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f3013j.set(this.f3014k.getPaint());
        this.f3013j.setTextSize((float) suggestedSizeInPx);
        Alignment alignment = (Alignment) m4536a((Object) this.f3014k, "getLayoutAlignment", (T) Alignment.ALIGN_NORMAL);
        if (VERSION.SDK_INT >= 23) {
            layout = m4535a(text, alignment, Math.round(availableSpace.right), maxLines);
        } else {
            layout = m4534a(text, alignment, Math.round(availableSpace.right));
        }
        return (maxLines == -1 || (layout.getLineCount() <= maxLines && layout.getLineEnd(layout.getLineCount() - 1) == text.length())) && ((float) layout.getHeight()) <= availableSpace.bottom;
    }

    /* renamed from: a */
    private StaticLayout m4535a(CharSequence text, Alignment alignment, int availableWidth, int maxLines) {
        return Builder.obtain(text, 0, text.length(), this.f3013j, availableWidth).setAlignment(alignment).setLineSpacing(this.f3014k.getLineSpacingExtra(), this.f3014k.getLineSpacingMultiplier()).setIncludePad(this.f3014k.getIncludeFontPadding()).setBreakStrategy(this.f3014k.getBreakStrategy()).setHyphenationFrequency(this.f3014k.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? MoPubClientPositioning.NO_REPEAT : maxLines).setTextDirection((TextDirectionHeuristic) m4536a((Object) this.f3014k, "getTextDirectionHeuristic", (T) TextDirectionHeuristics.FIRSTSTRONG_LTR)).build();
    }

    /* renamed from: a */
    private StaticLayout m4534a(CharSequence text, Alignment alignment, int availableWidth) {
        boolean includePad;
        float lineSpacingAdd;
        float lineSpacingMultiplier;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.f3014k.getLineSpacingMultiplier();
            lineSpacingAdd = this.f3014k.getLineSpacingExtra();
            includePad = this.f3014k.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) m4536a((Object) this.f3014k, "getLineSpacingMultiplier", (T) Float.valueOf(1.0f))).floatValue();
            lineSpacingAdd = ((Float) m4536a((Object) this.f3014k, "getLineSpacingExtra", (T) Float.valueOf(0.0f))).floatValue();
            includePad = ((Boolean) m4536a((Object) this.f3014k, "getIncludeFontPadding", (T) Boolean.valueOf(true))).booleanValue();
        }
        StaticLayout staticLayout = new StaticLayout(text, this.f3013j, availableWidth, alignment, lineSpacingMultiplier, lineSpacingAdd, includePad);
        return staticLayout;
    }

    /* renamed from: a */
    private <T> T m4536a(Object object, String methodName, T defaultValue) {
        try {
            Object invoke = m4537a(methodName).invoke(object, new Object[0]);
            if (invoke != null || 0 == 0) {
                return invoke;
            }
        } catch (Exception ex) {
            String str = "ACTVAutoSizeHelper";
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(methodName);
            sb.append("() method");
            Log.w(str, sb.toString(), ex);
            if (0 != 0 || 1 == 0) {
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0 && 1 != 0) {
                T result = defaultValue;
            }
            throw th;
        }
        return defaultValue;
    }

    /* renamed from: a */
    private Method m4537a(String methodName) {
        try {
            Method method = (Method) f3005b.get(methodName);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(methodName, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    f3005b.put(methodName, method);
                }
            }
            return method;
        } catch (Exception ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(methodName);
            sb.append("() method");
            Log.w("ACTVAutoSizeHelper", sb.toString(), ex);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo7336g() {
        return m4546k() && this.f3006c != 0;
    }

    /* renamed from: k */
    private boolean m4546k() {
        return !(this.f3014k instanceof C1104q);
    }
}
