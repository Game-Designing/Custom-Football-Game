package p002b.p003c.p062h.p064b.p065a;

import java.lang.reflect.Array;

/* renamed from: b.c.h.b.a.c */
/* compiled from: GrowingArrayUtils */
final class C1284c {
    /* renamed from: a */
    public static <T> T[] m6006a(T[] array, int currentSize, T element) {
        if (currentSize + 1 > array.length) {
            T[] newArray = (Object[]) Array.newInstance(array.getClass().getComponentType(), m6004a(currentSize));
            System.arraycopy(array, 0, newArray, 0, currentSize);
            array = newArray;
        }
        array[currentSize] = element;
        return array;
    }

    /* renamed from: a */
    public static int[] m6005a(int[] array, int currentSize, int element) {
        if (currentSize + 1 > array.length) {
            int[] newArray = new int[m6004a(currentSize)];
            System.arraycopy(array, 0, newArray, 0, currentSize);
            array = newArray;
        }
        array[currentSize] = element;
        return array;
    }

    /* renamed from: a */
    public static int m6004a(int currentSize) {
        if (currentSize <= 4) {
            return 8;
        }
        return currentSize * 2;
    }
}
