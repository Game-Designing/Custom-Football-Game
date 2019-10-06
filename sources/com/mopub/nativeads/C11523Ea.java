package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;

/* renamed from: com.mopub.nativeads.Ea */
/* compiled from: PlacementData */
class C11523Ea {
    public static final int NOT_FOUND = -1;

    /* renamed from: a */
    private final int[] f35633a = new int[200];

    /* renamed from: b */
    private final int[] f35634b = new int[200];

    /* renamed from: c */
    private int f35635c = 0;

    /* renamed from: d */
    private final int[] f35636d = new int[200];

    /* renamed from: e */
    private final int[] f35637e = new int[200];

    /* renamed from: f */
    private final NativeAd[] f35638f = new NativeAd[200];

    /* renamed from: g */
    private int f35639g = 0;

    private C11523Ea(int[] desiredInsertionPositions) {
        this.f35635c = Math.min(desiredInsertionPositions.length, 200);
        System.arraycopy(desiredInsertionPositions, 0, this.f35634b, 0, this.f35635c);
        System.arraycopy(desiredInsertionPositions, 0, this.f35633a, 0, this.f35635c);
    }

    /* renamed from: a */
    static C11523Ea m38113a(MoPubClientPositioning adPositioning) {
        List<Integer> fixed = adPositioning.mo37942a();
        int interval = adPositioning.mo37944b();
        int size = interval == Integer.MAX_VALUE ? fixed.size() : 200;
        int[] desiredInsertionPositions = new int[size];
        int numAds = 0;
        int lastPos = 0;
        for (Integer position : fixed) {
            lastPos = position.intValue() - numAds;
            int numAds2 = numAds + 1;
            desiredInsertionPositions[numAds] = lastPos;
            numAds = numAds2;
        }
        while (numAds < size) {
            lastPos = (lastPos + interval) - 1;
            int numAds3 = numAds + 1;
            desiredInsertionPositions[numAds] = lastPos;
            numAds = numAds3;
        }
        return new C11523Ea(desiredInsertionPositions);
    }

    /* renamed from: b */
    static C11523Ea m38115b() {
        return new C11523Ea(new int[0]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo37775j(int position) {
        if (m38112a(this.f35634b, 0, this.f35635c, position) >= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo37773h(int position) {
        int index = m38114b(this.f35634b, this.f35635c, position);
        if (index == this.f35635c) {
            return -1;
        }
        return this.f35634b[index];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37764a(int adjustedPosition, NativeAd nativeAd) {
        int desiredIndex = m38111a(this.f35634b, this.f35635c, adjustedPosition);
        if (desiredIndex == this.f35635c || this.f35634b[desiredIndex] != adjustedPosition) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Attempted to insert an ad at an invalid position");
            return;
        }
        int originalPosition = this.f35633a[desiredIndex];
        int placeIndex = m38114b(this.f35636d, this.f35639g, originalPosition);
        int i = this.f35639g;
        if (placeIndex < i) {
            int num = i - placeIndex;
            int[] iArr = this.f35636d;
            System.arraycopy(iArr, placeIndex, iArr, placeIndex + 1, num);
            int[] iArr2 = this.f35637e;
            System.arraycopy(iArr2, placeIndex, iArr2, placeIndex + 1, num);
            NativeAd[] nativeAdArr = this.f35638f;
            System.arraycopy(nativeAdArr, placeIndex, nativeAdArr, placeIndex + 1, num);
        }
        this.f35636d[placeIndex] = originalPosition;
        this.f35637e[placeIndex] = adjustedPosition;
        this.f35638f[placeIndex] = nativeAd;
        this.f35639g++;
        int num2 = (this.f35635c - desiredIndex) - 1;
        int[] iArr3 = this.f35634b;
        System.arraycopy(iArr3, desiredIndex + 1, iArr3, desiredIndex, num2);
        int[] iArr4 = this.f35633a;
        System.arraycopy(iArr4, desiredIndex + 1, iArr4, desiredIndex, num2);
        this.f35635c--;
        for (int i2 = desiredIndex; i2 < this.f35635c; i2++) {
            int[] iArr5 = this.f35634b;
            iArr5[i2] = iArr5[i2] + 1;
        }
        for (int i3 = placeIndex + 1; i3 < this.f35639g; i3++) {
            int[] iArr6 = this.f35637e;
            iArr6[i3] = iArr6[i3] + 1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo37772g(int position) {
        if (m38112a(this.f35637e, 0, this.f35639g, position) >= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public NativeAd mo37770e(int position) {
        int index = m38112a(this.f35637e, 0, this.f35639g, position);
        if (index < 0) {
            return null;
        }
        return this.f35638f[index];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int[] mo37768c() {
        int i = this.f35639g;
        int[] positions = new int[i];
        System.arraycopy(this.f35637e, 0, positions, 0, i);
        return positions;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo37769d(int position) {
        int index = m38112a(this.f35637e, 0, this.f35639g, position);
        if (index < 0) {
            return position - (index ^ -1);
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo37765b(int originalPosition) {
        return originalPosition + m38114b(this.f35636d, this.f35639g, originalPosition);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo37767c(int count) {
        if (count == 0) {
            return 0;
        }
        int originalPos = mo37769d(count - 1);
        int i = -1;
        if (originalPos != -1) {
            i = originalPos + 1;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo37761a(int originalCount) {
        if (originalCount == 0) {
            return 0;
        }
        return mo37765b(originalCount - 1) + 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo37762a(int adjustedStartRange, int adjustedEndRange) {
        int i = this.f35639g;
        int[] clearOriginalPositions = new int[i];
        int[] clearAdjustedPositions = new int[i];
        int clearCount = 0;
        for (int i2 = 0; i2 < this.f35639g; i2++) {
            int originalPosition = this.f35636d[i2];
            int adjustedPosition = this.f35637e[i2];
            if (adjustedStartRange <= adjustedPosition && adjustedPosition < adjustedEndRange) {
                clearOriginalPositions[clearCount] = originalPosition;
                clearAdjustedPositions[clearCount] = adjustedPosition - clearCount;
                this.f35638f[i2].destroy();
                this.f35638f[i2] = null;
                clearCount++;
            } else if (clearCount > 0) {
                int newIndex = i2 - clearCount;
                this.f35636d[newIndex] = originalPosition;
                this.f35637e[newIndex] = adjustedPosition - clearCount;
                NativeAd[] nativeAdArr = this.f35638f;
                nativeAdArr[newIndex] = nativeAdArr[i2];
            }
        }
        if (clearCount == 0) {
            return 0;
        }
        int desiredIndex = m38111a(this.f35634b, this.f35635c, clearAdjustedPositions[0]);
        for (int i3 = this.f35635c - 1; i3 >= desiredIndex; i3--) {
            int[] iArr = this.f35633a;
            iArr[i3 + clearCount] = iArr[i3];
            int[] iArr2 = this.f35634b;
            iArr2[i3 + clearCount] = iArr2[i3] - clearCount;
        }
        for (int i4 = 0; i4 < clearCount; i4++) {
            this.f35633a[desiredIndex + i4] = clearOriginalPositions[i4];
            this.f35634b[desiredIndex + i4] = clearAdjustedPositions[i4];
        }
        this.f35635c += clearCount;
        this.f35639g -= clearCount;
        return clearCount;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37763a() {
        int i = this.f35639g;
        if (i != 0) {
            mo37762a(0, this.f35637e[i - 1] + 1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo37771f(int originalPosition) {
        for (int i = m38111a(this.f35633a, this.f35635c, originalPosition); i < this.f35635c; i++) {
            int[] iArr = this.f35633a;
            iArr[i] = iArr[i] + 1;
            int[] iArr2 = this.f35634b;
            iArr2[i] = iArr2[i] + 1;
        }
        for (int i2 = m38111a(this.f35636d, this.f35639g, originalPosition); i2 < this.f35639g; i2++) {
            int[] iArr3 = this.f35636d;
            iArr3[i2] = iArr3[i2] + 1;
            int[] iArr4 = this.f35637e;
            iArr4[i2] = iArr4[i2] + 1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo37774i(int originalPosition) {
        for (int i = m38114b(this.f35633a, this.f35635c, originalPosition); i < this.f35635c; i++) {
            int[] iArr = this.f35633a;
            iArr[i] = iArr[i] - 1;
            int[] iArr2 = this.f35634b;
            iArr2[i] = iArr2[i] - 1;
        }
        for (int i2 = m38114b(this.f35636d, this.f35639g, originalPosition); i2 < this.f35639g; i2++) {
            int[] iArr3 = this.f35636d;
            iArr3[i2] = iArr3[i2] - 1;
            int[] iArr4 = this.f35637e;
            iArr4[i2] = iArr4[i2] - 1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37766b(int originalPosition, int newPosition) {
        mo37774i(originalPosition);
        mo37771f(newPosition);
    }

    /* renamed from: a */
    private static int m38111a(int[] array, int count, int value) {
        int index = m38112a(array, 0, count, value);
        if (index < 0) {
            return index ^ -1;
        }
        int duplicateValue = array[index];
        while (index >= 0 && array[index] == duplicateValue) {
            index--;
        }
        return index + 1;
    }

    /* renamed from: b */
    private static int m38114b(int[] array, int count, int value) {
        int index = m38112a(array, 0, count, value);
        if (index < 0) {
            return index ^ -1;
        }
        int duplicateValue = array[index];
        while (index < count && array[index] == duplicateValue) {
            index++;
        }
        return index;
    }

    /* renamed from: a */
    private static int m38112a(int[] array, int startIndex, int endIndex, int value) {
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal <= value) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo ^ -1;
    }
}
