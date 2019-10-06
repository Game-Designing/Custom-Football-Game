package com.crashlytics.android.p126c;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.crashlytics.android.c.Ha */
/* compiled from: RemoveRepeatsStrategy */
class C6422Ha implements C6442Oa {

    /* renamed from: a */
    private final int f11506a;

    public C6422Ha(int maxRepetitions) {
        this.f11506a = maxRepetitions;
    }

    /* renamed from: a */
    public StackTraceElement[] mo19452a(StackTraceElement[] stacktrace) {
        StackTraceElement[] trimmed = m12446a(stacktrace, this.f11506a);
        if (trimmed.length < stacktrace.length) {
            return trimmed;
        }
        return stacktrace;
    }

    /* renamed from: a */
    private static StackTraceElement[] m12446a(StackTraceElement[] stacktrace, int maxRepetitions) {
        Map<StackTraceElement, Integer> mostRecentIndices = new HashMap<>();
        StackTraceElement[] buffer = new StackTraceElement[stacktrace.length];
        int trimmedLength = 0;
        int numRepeats = 1;
        int i = 0;
        while (i < stacktrace.length) {
            int currentIndex = i;
            StackTraceElement currentFrame = stacktrace[i];
            Integer previousIndex = (Integer) mostRecentIndices.get(currentFrame);
            if (previousIndex == null || !m12445a(stacktrace, previousIndex.intValue(), i)) {
                numRepeats = 1;
                buffer[trimmedLength] = stacktrace[i];
                trimmedLength++;
            } else {
                int windowSize = i - previousIndex.intValue();
                if (numRepeats < maxRepetitions) {
                    System.arraycopy(stacktrace, i, buffer, trimmedLength, windowSize);
                    trimmedLength += windowSize;
                    numRepeats++;
                }
                i += windowSize - 1;
            }
            mostRecentIndices.put(currentFrame, Integer.valueOf(currentIndex));
            i++;
        }
        StackTraceElement[] trimmed = new StackTraceElement[trimmedLength];
        System.arraycopy(buffer, 0, trimmed, 0, trimmed.length);
        return trimmed;
    }

    /* renamed from: a */
    private static boolean m12445a(StackTraceElement[] stacktrace, int prevIndex, int currentIndex) {
        int windowSize = currentIndex - prevIndex;
        if (currentIndex + windowSize > stacktrace.length) {
            return false;
        }
        for (int i = 0; i < windowSize; i++) {
            if (!stacktrace[prevIndex + i].equals(stacktrace[currentIndex + i])) {
                return false;
            }
        }
        return true;
    }
}
