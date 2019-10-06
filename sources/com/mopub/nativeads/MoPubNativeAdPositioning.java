package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MoPubNativeAdPositioning {

    public static class MoPubClientPositioning {
        public static final int NO_REPEAT = Integer.MAX_VALUE;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final ArrayList<Integer> f35879a = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f35880b = NO_REPEAT;

        public MoPubClientPositioning addFixedPosition(int position) {
            if (!NoThrow.checkArgument(position >= 0)) {
                return this;
            }
            int index = Collections.binarySearch(this.f35879a, Integer.valueOf(position));
            if (index < 0) {
                this.f35879a.add(index ^ -1, Integer.valueOf(position));
            }
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public List<Integer> mo37942a() {
            return this.f35879a;
        }

        public MoPubClientPositioning enableRepeatingPositions(int interval) {
            boolean z = true;
            if (interval <= 1) {
                z = false;
            }
            if (!NoThrow.checkArgument(z, "Repeating interval must be greater than 1")) {
                this.f35880b = NO_REPEAT;
                return this;
            }
            this.f35880b = interval;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo37944b() {
            return this.f35880b;
        }
    }

    public static class MoPubServerPositioning {
    }

    /* renamed from: a */
    static MoPubClientPositioning m38276a(MoPubClientPositioning positioning) {
        Preconditions.checkNotNull(positioning);
        MoPubClientPositioning clone = new MoPubClientPositioning();
        clone.f35879a.addAll(positioning.f35879a);
        clone.f35880b = positioning.f35880b;
        return clone;
    }

    public static MoPubClientPositioning clientPositioning() {
        return new MoPubClientPositioning();
    }

    public static MoPubServerPositioning serverPositioning() {
        return new MoPubServerPositioning();
    }
}
