package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            int dataSize = parcel.dataSize();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(dataPosition);
            sb.append(" size=");
            sb.append(dataSize);
            super(sb.toString());
        }
    }

    private SafeParcelReader() {
    }

    /* renamed from: a */
    public static int m21920a(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: a */
    public static int m21919a(int i) {
        return i & 65535;
    }

    /* renamed from: B */
    public static int m21917B(Parcel parcel, int i) {
        if ((i & -65536) != -65536) {
            return (i >> 16) & 65535;
        }
        return parcel.readInt();
    }

    /* renamed from: C */
    public static void m21918C(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m21917B(parcel, i));
    }

    /* renamed from: a */
    private static void m21923a(Parcel parcel, int i, int i2) {
        int B = m21917B(parcel, i);
        if (B != i2) {
            String hexString = Integer.toHexString(B);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(B);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    /* renamed from: a */
    private static void m21924a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String hexString = Integer.toHexString(i2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(i2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    /* renamed from: b */
    public static int m21925b(Parcel parcel) {
        int a = m21920a(parcel);
        int B = m21917B(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (m21919a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new ParseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        int i = B + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    /* renamed from: s */
    public static boolean m21945s(Parcel parcel, int i) {
        m21923a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: A */
    public static short m21916A(Parcel parcel, int i) {
        m21923a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* renamed from: w */
    public static int m21949w(Parcel parcel, int i) {
        m21923a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: x */
    public static Integer m21950x(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        if (B == 0) {
            return null;
        }
        m21924a(parcel, i, B, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: y */
    public static long m21951y(Parcel parcel, int i) {
        m21923a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: z */
    public static Long m21952z(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        if (B == 0) {
            return null;
        }
        m21924a(parcel, i, B, 8);
        return Long.valueOf(parcel.readLong());
    }

    /* renamed from: c */
    public static BigInteger m21928c(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + B);
        return new BigInteger(createByteArray);
    }

    /* renamed from: u */
    public static float m21947u(Parcel parcel, int i) {
        m21923a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: t */
    public static double m21946t(Parcel parcel, int i) {
        m21923a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: a */
    public static BigDecimal m21922a(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + B);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    /* renamed from: o */
    public static String m21941o(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + B);
        return readString;
    }

    /* renamed from: v */
    public static IBinder m21948v(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + B);
        return readStrongBinder;
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m21921a(Parcel parcel, int i, Creator<T> creator) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + B);
        return t;
    }

    /* renamed from: f */
    public static Bundle m21932f(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + B);
        return readBundle;
    }

    /* renamed from: g */
    public static byte[] m21933g(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + B);
        return createByteArray;
    }

    /* renamed from: e */
    public static boolean[] m21931e(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + B);
        return createBooleanArray;
    }

    /* renamed from: j */
    public static int[] m21936j(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + B);
        return createIntArray;
    }

    /* renamed from: l */
    public static long[] m21938l(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + B);
        return createLongArray;
    }

    /* renamed from: d */
    public static BigInteger[] m21930d(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + B);
        return bigIntegerArr;
    }

    /* renamed from: i */
    public static float[] m21935i(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + B);
        return createFloatArray;
    }

    /* renamed from: h */
    public static double[] m21934h(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + B);
        return createDoubleArray;
    }

    /* renamed from: b */
    public static BigDecimal[] m21927b(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + B);
        return bigDecimalArr;
    }

    /* renamed from: p */
    public static String[] m21942p(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + B);
        return createStringArray;
    }

    /* renamed from: k */
    public static ArrayList<Integer> m21937k(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + B);
        return arrayList;
    }

    /* renamed from: q */
    public static ArrayList<String> m21943q(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + B);
        return createStringArrayList;
    }

    /* renamed from: b */
    public static <T> T[] m21926b(Parcel parcel, int i, Creator<T> creator) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + B);
        return createTypedArray;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m21929c(Parcel parcel, int i, Creator<T> creator) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + B);
        return createTypedArrayList;
    }

    /* renamed from: m */
    public static Parcel m21939m(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, B);
        parcel.setDataPosition(dataPosition + B);
        return obtain;
    }

    /* renamed from: n */
    public static Parcel[] m21940n(Parcel parcel, int i) {
        int B = m21917B(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (B == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + B);
        return parcelArr;
    }

    /* renamed from: r */
    public static void m21944r(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i);
            throw new ParseException(sb.toString(), parcel);
        }
    }
}
