package org.parceler;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.parceler.C14377B.C14379b;
import org.parceler.p386a.C14433a;
import org.parceler.p386a.C14434b;
import org.parceler.p386a.C14435c;
import org.parceler.p386a.C14436d;
import org.parceler.p386a.C14437e;
import org.parceler.p386a.C14438f;
import org.parceler.p386a.C14439g;
import org.parceler.p386a.C14440h;
import org.parceler.p386a.C14441i;
import org.parceler.p386a.C14443k;
import org.parceler.p386a.C14444l;
import org.parceler.p386a.C14445m;
import org.parceler.p386a.C14446n;

final class NonParcelRepository implements C14381C<C14379b> {

    /* renamed from: a */
    private static final NonParcelRepository f43252a = new NonParcelRepository();

    /* renamed from: b */
    private final Map<Class, C14379b> f43253b = new HashMap();

    public static final class BooleanArrayParcelable extends ConverterParcelable<boolean[]> {
        public static final C14383a CREATOR = new C14383a();

        /* renamed from: c */
        private static final C14434b f43254c = new C14434b();

        /* renamed from: org.parceler.NonParcelRepository$BooleanArrayParcelable$a */
        private static final class C14383a implements Creator<BooleanArrayParcelable> {
            private C14383a() {
            }

            public BooleanArrayParcelable createFromParcel(Parcel parcel) {
                return new BooleanArrayParcelable(parcel);
            }

            public BooleanArrayParcelable[] newArray(int size) {
                return new BooleanArrayParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanArrayParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43254c);
        }

        public BooleanArrayParcelable(boolean[] value) {
            super((Object) value, (C14382D) f43254c);
        }
    }

    public static final class BooleanParcelable extends ConverterParcelable<Boolean> {
        public static final C14384a CREATOR = new C14384a();

        /* renamed from: c */
        private static final C14443k<Boolean> f43255c = new C14453e();

        /* renamed from: org.parceler.NonParcelRepository$BooleanParcelable$a */
        private static final class C14384a implements Creator<BooleanParcelable> {
            private C14384a() {
            }

            public BooleanParcelable createFromParcel(Parcel parcel) {
                return new BooleanParcelable(parcel);
            }

            public BooleanParcelable[] newArray(int size) {
                return new BooleanParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43255c);
        }

        public BooleanParcelable(boolean value) {
            super((Object) Boolean.valueOf(value), (C14382D) f43255c);
        }
    }

    public static final class ByteArrayParcelable extends ConverterParcelable<byte[]> {
        public static final C14385a CREATOR = new C14385a();

        /* renamed from: c */
        private static final C14443k<byte[]> f43256c = new C14454f();

        /* renamed from: org.parceler.NonParcelRepository$ByteArrayParcelable$a */
        private static final class C14385a implements Creator<ByteArrayParcelable> {
            private C14385a() {
            }

            public ByteArrayParcelable createFromParcel(Parcel parcel) {
                return new ByteArrayParcelable(parcel);
            }

            public ByteArrayParcelable[] newArray(int size) {
                return new ByteArrayParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteArrayParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43256c);
        }

        public ByteArrayParcelable(byte[] value) {
            super((Object) value, (C14382D) f43256c);
        }
    }

    public static final class ByteParcelable extends ConverterParcelable<Byte> {
        public static final C14386a CREATOR = new C14386a();

        /* renamed from: c */
        private static final C14443k<Byte> f43257c = new C14455g();

        /* renamed from: org.parceler.NonParcelRepository$ByteParcelable$a */
        private static final class C14386a implements Creator<ByteParcelable> {
            private C14386a() {
            }

            public ByteParcelable createFromParcel(Parcel parcel) {
                return new ByteParcelable(parcel);
            }

            public ByteParcelable[] newArray(int size) {
                return new ByteParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43257c);
        }

        public ByteParcelable(Byte value) {
            super((Object) value, (C14382D) f43257c);
        }
    }

    public static final class CharArrayParcelable extends ConverterParcelable<char[]> {
        public static final C14387a CREATOR = new C14387a();

        /* renamed from: c */
        private static final C14435c f43258c = new C14435c();

        /* renamed from: org.parceler.NonParcelRepository$CharArrayParcelable$a */
        private static final class C14387a implements Creator<CharArrayParcelable> {
            private C14387a() {
            }

            public CharArrayParcelable createFromParcel(Parcel parcel) {
                return new CharArrayParcelable(parcel);
            }

            public CharArrayParcelable[] newArray(int size) {
                return new CharArrayParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharArrayParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43258c);
        }

        public CharArrayParcelable(char[] value) {
            super((Object) value, (C14382D) f43258c);
        }
    }

    public static final class CharacterParcelable extends ConverterParcelable<Character> {
        public static final C14388a CREATOR = new C14388a();

        /* renamed from: c */
        private static final C14443k<Character> f43259c = new C14456h();

        /* renamed from: org.parceler.NonParcelRepository$CharacterParcelable$a */
        private static final class C14388a implements Creator<CharacterParcelable> {
            private C14388a() {
            }

            public CharacterParcelable createFromParcel(Parcel parcel) {
                return new CharacterParcelable(parcel);
            }

            public CharacterParcelable[] newArray(int size) {
                return new CharacterParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharacterParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43259c);
        }

        public CharacterParcelable(Character value) {
            super((Object) value, (C14382D) f43259c);
        }
    }

    public static final class CollectionParcelable extends ConverterParcelable<Collection> {
        public static final C14389a CREATOR = new C14389a();

        /* renamed from: c */
        private static final C14436d f43260c = new C14457i();

        /* renamed from: org.parceler.NonParcelRepository$CollectionParcelable$a */
        private static final class C14389a implements Creator<CollectionParcelable> {
            private C14389a() {
            }

            public CollectionParcelable createFromParcel(Parcel parcel) {
                return new CollectionParcelable(parcel);
            }

            public CollectionParcelable[] newArray(int size) {
                return new CollectionParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CollectionParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43260c);
        }

        public CollectionParcelable(Collection value) {
            super((Object) value, (C14382D) f43260c);
        }
    }

    private static class ConverterParcelable<T> implements Parcelable, C14474z<T> {

        /* renamed from: a */
        private final T f43261a;

        /* renamed from: b */
        private final C14382D<T, T> f43262b;

        private ConverterParcelable(Parcel parcel, C14382D<T, T> converter) {
            this((T) converter.mo45446a(parcel), converter);
        }

        private ConverterParcelable(T value, C14382D<T, T> converter) {
            this.f43262b = converter;
            this.f43261a = value;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            this.f43262b.mo45447a(this.f43261a, parcel);
        }

        public int describeContents() {
            return 0;
        }

        public T getParcel() {
            return this.f43261a;
        }
    }

    public static final class DoubleParcelable extends ConverterParcelable<Double> {
        public static final C14390a CREATOR = new C14390a();

        /* renamed from: c */
        private static final C14443k<Double> f43263c = new C14458j();

        /* renamed from: org.parceler.NonParcelRepository$DoubleParcelable$a */
        private static final class C14390a implements Creator<DoubleParcelable> {
            private C14390a() {
            }

            public DoubleParcelable createFromParcel(Parcel parcel) {
                return new DoubleParcelable(parcel);
            }

            public DoubleParcelable[] newArray(int size) {
                return new DoubleParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public DoubleParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43263c);
        }

        public DoubleParcelable(Double value) {
            super((Object) value, (C14382D) f43263c);
        }
    }

    public static final class FloatParcelable extends ConverterParcelable<Float> {
        public static final C14391a CREATOR = new C14391a();

        /* renamed from: c */
        private static final C14443k<Float> f43264c = new C14459k();

        /* renamed from: org.parceler.NonParcelRepository$FloatParcelable$a */
        private static final class C14391a implements Creator<FloatParcelable> {
            private C14391a() {
            }

            public FloatParcelable createFromParcel(Parcel parcel) {
                return new FloatParcelable(parcel);
            }

            public FloatParcelable[] newArray(int size) {
                return new FloatParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public FloatParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43264c);
        }

        public FloatParcelable(Float value) {
            super((Object) value, (C14382D) f43264c);
        }
    }

    public static final class IBinderParcelable extends ConverterParcelable<IBinder> {
        public static final C14392a CREATOR = new C14392a();

        /* renamed from: c */
        private static final C14443k<IBinder> f43265c = new C14460l();

        /* renamed from: org.parceler.NonParcelRepository$IBinderParcelable$a */
        private static final class C14392a implements Creator<IBinderParcelable> {
            private C14392a() {
            }

            public IBinderParcelable createFromParcel(Parcel parcel) {
                return new IBinderParcelable(parcel);
            }

            public IBinderParcelable[] newArray(int size) {
                return new IBinderParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IBinderParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43265c);
        }

        public IBinderParcelable(IBinder value) {
            super((Object) value, (C14382D) f43265c);
        }
    }

    public static final class IntegerParcelable extends ConverterParcelable<Integer> {
        public static final C14393a CREATOR = new C14393a();

        /* renamed from: c */
        private static final C14443k<Integer> f43266c = new C14461m();

        /* renamed from: org.parceler.NonParcelRepository$IntegerParcelable$a */
        private static final class C14393a implements Creator<IntegerParcelable> {
            private C14393a() {
            }

            public IntegerParcelable createFromParcel(Parcel parcel) {
                return new IntegerParcelable(parcel);
            }

            public IntegerParcelable[] newArray(int size) {
                return new IntegerParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IntegerParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43266c);
        }

        public IntegerParcelable(Integer value) {
            super((Object) value, (C14382D) f43266c);
        }
    }

    public static final class LinkedHashMapParcelable extends ConverterParcelable<LinkedHashMap> {
        public static final C14394a CREATOR = new C14394a();

        /* renamed from: c */
        private static final C14439g f43267c = new C14462n();

        /* renamed from: org.parceler.NonParcelRepository$LinkedHashMapParcelable$a */
        private static final class C14394a implements Creator<LinkedHashMapParcelable> {
            private C14394a() {
            }

            public LinkedHashMapParcelable createFromParcel(Parcel parcel$$17) {
                return new LinkedHashMapParcelable(parcel$$17);
            }

            public LinkedHashMapParcelable[] newArray(int size) {
                return new LinkedHashMapParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashMapParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43267c);
        }

        public LinkedHashMapParcelable(LinkedHashMap value) {
            super((Object) value, (C14382D) f43267c);
        }
    }

    public static final class LinkedHashSetParcelable extends ConverterParcelable<LinkedHashSet> {
        public static final C14395a CREATOR = new C14395a();

        /* renamed from: c */
        private static final C14440h f43268c = new C14463o();

        /* renamed from: org.parceler.NonParcelRepository$LinkedHashSetParcelable$a */
        private static final class C14395a implements Creator<LinkedHashSetParcelable> {
            private C14395a() {
            }

            public LinkedHashSetParcelable createFromParcel(Parcel parcel) {
                return new LinkedHashSetParcelable(parcel);
            }

            public LinkedHashSetParcelable[] newArray(int size) {
                return new LinkedHashSetParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashSetParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43268c);
        }

        public LinkedHashSetParcelable(LinkedHashSet value) {
            super((Object) value, (C14382D) f43268c);
        }
    }

    public static final class LinkedListParcelable extends ConverterParcelable<LinkedList> {
        public static final C14396a CREATOR = new C14396a();

        /* renamed from: c */
        private static final C14441i f43269c = new C14464p();

        /* renamed from: org.parceler.NonParcelRepository$LinkedListParcelable$a */
        private static final class C14396a implements Creator<LinkedListParcelable> {
            private C14396a() {
            }

            public LinkedListParcelable createFromParcel(Parcel parcel) {
                return new LinkedListParcelable(parcel);
            }

            public LinkedListParcelable[] newArray(int size) {
                return new LinkedListParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedListParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43269c);
        }

        public LinkedListParcelable(LinkedList value) {
            super((Object) value, (C14382D) f43269c);
        }
    }

    public static final class ListParcelable extends ConverterParcelable<List> {
        public static final C14397a CREATOR = new C14397a();

        /* renamed from: c */
        private static final C14433a f43270c = new C14465q();

        /* renamed from: org.parceler.NonParcelRepository$ListParcelable$a */
        private static final class C14397a implements Creator<ListParcelable> {
            private C14397a() {
            }

            public ListParcelable createFromParcel(Parcel parcel) {
                return new ListParcelable(parcel);
            }

            public ListParcelable[] newArray(int size) {
                return new ListParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ListParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43270c);
        }

        public ListParcelable(List value) {
            super((Object) value, (C14382D) f43270c);
        }
    }

    public static final class LongParcelable extends ConverterParcelable<Long> {
        public static final C14398a CREATOR = new C14398a();

        /* renamed from: c */
        private static final C14443k<Long> f43271c = new C14466r();

        /* renamed from: org.parceler.NonParcelRepository$LongParcelable$a */
        private static final class C14398a implements Creator<LongParcelable> {
            private C14398a() {
            }

            public LongParcelable createFromParcel(Parcel parcel) {
                return new LongParcelable(parcel);
            }

            public LongParcelable[] newArray(int size) {
                return new LongParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LongParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43271c);
        }

        public LongParcelable(Long value) {
            super((Object) value, (C14382D) f43271c);
        }
    }

    public static final class MapParcelable extends ConverterParcelable<Map> {
        public static final C14399a CREATOR = new C14399a();

        /* renamed from: c */
        private static final C14437e f43272c = new C14467s();

        /* renamed from: org.parceler.NonParcelRepository$MapParcelable$a */
        private static final class C14399a implements Creator<MapParcelable> {
            private C14399a() {
            }

            public MapParcelable createFromParcel(Parcel parcel$$17) {
                return new MapParcelable(parcel$$17);
            }

            public MapParcelable[] newArray(int size) {
                return new MapParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public MapParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43272c);
        }

        public MapParcelable(Map value) {
            super((Object) value, (C14382D) f43272c);
        }
    }

    public static final class ParcelableParcelable implements Parcelable, C14474z<Parcelable> {
        public static final C14400a CREATOR = new C14400a();

        /* renamed from: a */
        private Parcelable f43273a;

        /* renamed from: org.parceler.NonParcelRepository$ParcelableParcelable$a */
        private static final class C14400a implements Creator<ParcelableParcelable> {
            private C14400a() {
            }

            public ParcelableParcelable createFromParcel(Parcel parcel) {
                return new ParcelableParcelable(parcel);
            }

            public ParcelableParcelable[] newArray(int size) {
                return new ParcelableParcelable[size];
            }
        }

        private ParcelableParcelable(Parcel parcel) {
            this.f43273a = parcel.readParcelable(ParcelableParcelable.class.getClassLoader());
        }

        private ParcelableParcelable(Parcelable parcelable) {
            this.f43273a = parcelable;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeParcelable(this.f43273a, flags);
        }

        public int describeContents() {
            return 0;
        }

        public Parcelable getParcel() {
            return this.f43273a;
        }
    }

    public static final class SetParcelable extends ConverterParcelable<Set> {
        public static final C14401a CREATOR = new C14401a();

        /* renamed from: c */
        private static final C14438f f43274c = new C14468t();

        /* renamed from: org.parceler.NonParcelRepository$SetParcelable$a */
        private static final class C14401a implements Creator<SetParcelable> {
            private C14401a() {
            }

            public SetParcelable createFromParcel(Parcel parcel) {
                return new SetParcelable(parcel);
            }

            public SetParcelable[] newArray(int size) {
                return new SetParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SetParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43274c);
        }

        public SetParcelable(Set value) {
            super((Object) value, (C14382D) f43274c);
        }
    }

    public static final class SparseArrayParcelable extends ConverterParcelable<SparseArray> {
        public static final C14402a CREATOR = new C14402a();

        /* renamed from: c */
        private static final C14444l f43275c = new C14469u();

        /* renamed from: org.parceler.NonParcelRepository$SparseArrayParcelable$a */
        private static final class C14402a implements Creator<SparseArrayParcelable> {
            private C14402a() {
            }

            public SparseArrayParcelable createFromParcel(Parcel parcel) {
                return new SparseArrayParcelable(parcel);
            }

            public SparseArrayParcelable[] newArray(int size) {
                return new SparseArrayParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseArrayParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43275c);
        }

        public SparseArrayParcelable(SparseArray value) {
            super((Object) value, (C14382D) f43275c);
        }
    }

    public static final class SparseBooleanArrayParcelable extends ConverterParcelable<SparseBooleanArray> {
        public static final C14403a CREATOR = new C14403a();

        /* renamed from: c */
        private static final C14443k<SparseBooleanArray> f43276c = new C14470v();

        /* renamed from: org.parceler.NonParcelRepository$SparseBooleanArrayParcelable$a */
        private static final class C14403a implements Creator<SparseBooleanArrayParcelable> {
            private C14403a() {
            }

            public SparseBooleanArrayParcelable createFromParcel(Parcel parcel) {
                return new SparseBooleanArrayParcelable(parcel);
            }

            public SparseBooleanArrayParcelable[] newArray(int size) {
                return new SparseBooleanArrayParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseBooleanArrayParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43276c);
        }

        public SparseBooleanArrayParcelable(SparseBooleanArray value) {
            super((Object) value, (C14382D) f43276c);
        }
    }

    public static final class StringParcelable implements Parcelable, C14474z<String> {
        public static final C14404a CREATOR = new C14404a();

        /* renamed from: a */
        private String f43277a;

        /* renamed from: org.parceler.NonParcelRepository$StringParcelable$a */
        private static final class C14404a implements Creator<StringParcelable> {
            private C14404a() {
            }

            public StringParcelable createFromParcel(Parcel parcel) {
                return new StringParcelable(parcel);
            }

            public StringParcelable[] newArray(int size) {
                return new StringParcelable[size];
            }
        }

        private StringParcelable(Parcel parcel) {
            this.f43277a = parcel.readString();
        }

        private StringParcelable(String contents) {
            this.f43277a = contents;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeString(this.f43277a);
        }

        public int describeContents() {
            return 0;
        }

        public String getParcel() {
            return this.f43277a;
        }
    }

    public static final class TreeMapParcelable extends ConverterParcelable<Map> {
        public static final C14405a CREATOR = new C14405a();

        /* renamed from: c */
        private static final C14445m f43278c = new C14471w();

        /* renamed from: org.parceler.NonParcelRepository$TreeMapParcelable$a */
        private static final class C14405a implements Creator<TreeMapParcelable> {
            private C14405a() {
            }

            public TreeMapParcelable createFromParcel(Parcel parcel$$17) {
                return new TreeMapParcelable(parcel$$17);
            }

            public TreeMapParcelable[] newArray(int size) {
                return new TreeMapParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeMapParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43278c);
        }

        public TreeMapParcelable(Map value) {
            super((Object) value, (C14382D) f43278c);
        }
    }

    public static final class TreeSetParcelable extends ConverterParcelable<Set> {
        public static final C14406a CREATOR = new C14406a();

        /* renamed from: c */
        private static final C14446n f43279c = new C14472x();

        /* renamed from: org.parceler.NonParcelRepository$TreeSetParcelable$a */
        private static final class C14406a implements Creator<TreeSetParcelable> {
            private C14406a() {
            }

            public TreeSetParcelable createFromParcel(Parcel parcel) {
                return new TreeSetParcelable(parcel);
            }

            public TreeSetParcelable[] newArray(int size) {
                return new TreeSetParcelable[size];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeSetParcelable(Parcel parcel) {
            super(parcel, (C14382D) f43279c);
        }

        public TreeSetParcelable(Set value) {
            super((Object) value, (C14382D) f43279c);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$a */
    private static class C14407a implements C14379b<boolean[]> {
        private C14407a() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(boolean[] input) {
            return new BooleanArrayParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$b */
    private static class C14408b implements C14379b<Boolean> {
        private C14408b() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Boolean input) {
            return new BooleanParcelable(input.booleanValue());
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$c */
    private static class C14409c implements C14379b<Bundle> {
        private C14409c() {
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ Parcelable mo45444a(Object obj) {
            Bundle bundle = (Bundle) obj;
            mo45504a(bundle);
            return bundle;
        }

        /* renamed from: a */
        public Parcelable mo45504a(Bundle input) {
            return input;
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$d */
    private static class C14410d implements C14379b<byte[]> {
        private C14410d() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(byte[] input) {
            return new ByteArrayParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$e */
    private static class C14411e implements C14379b<Byte> {
        private C14411e() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Byte input) {
            return new ByteParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$f */
    private static class C14412f implements C14379b<char[]> {
        private C14412f() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(char[] input) {
            return new CharArrayParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$g */
    private static class C14413g implements C14379b<Character> {
        private C14413g() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Character input) {
            return new CharacterParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$h */
    private static class C14414h implements C14379b<Collection> {
        private C14414h() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Collection input) {
            return new CollectionParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$i */
    private static class C14415i implements C14379b<Double> {
        private C14415i() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Double input) {
            return new DoubleParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$j */
    private static class C14416j implements C14379b<Float> {
        private C14416j() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Float input) {
            return new FloatParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$k */
    private static class C14417k implements C14379b<IBinder> {
        private C14417k() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(IBinder input) {
            return new IBinderParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$l */
    private static class C14418l implements C14379b<Integer> {
        private C14418l() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Integer input) {
            return new IntegerParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$m */
    private static class C14419m implements C14379b<LinkedHashMap> {
        private C14419m() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(LinkedHashMap input) {
            return new LinkedHashMapParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$n */
    private static class C14420n implements C14379b<LinkedHashSet> {
        private C14420n() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(LinkedHashSet input) {
            return new LinkedHashSetParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$o */
    private static class C14421o implements C14379b<LinkedList> {
        private C14421o() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(LinkedList input) {
            return new LinkedListParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$p */
    private static class C14422p implements C14379b<List> {
        private C14422p() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(List input) {
            return new ListParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$q */
    private static class C14423q implements C14379b<Long> {
        private C14423q() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Long input) {
            return new LongParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$r */
    private static class C14424r implements C14379b<Map> {
        private C14424r() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Map input) {
            return new MapParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$s */
    static class C14425s implements C14379b<Parcelable> {
        C14425s() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Parcelable input) {
            return new ParcelableParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$t */
    private static class C14426t implements C14379b<Set> {
        private C14426t() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Set input) {
            return new SetParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$u */
    private static class C14427u implements C14379b<SparseArray> {
        private C14427u() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(SparseArray input) {
            return new SparseArrayParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$v */
    private static class C14428v implements C14379b<SparseBooleanArray> {
        private C14428v() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(SparseBooleanArray input) {
            return new SparseBooleanArrayParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$w */
    private static class C14429w implements C14379b<String> {
        private C14429w() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(String input) {
            return new StringParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$x */
    private static class C14430x implements C14379b<Map> {
        private C14430x() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Map input) {
            return new TreeMapParcelable(input);
        }
    }

    /* renamed from: org.parceler.NonParcelRepository$y */
    private static class C14431y implements C14379b<Set> {
        private C14431y() {
        }

        /* renamed from: a */
        public Parcelable mo45444a(Set input) {
            return new TreeSetParcelable(input);
        }
    }

    private NonParcelRepository() {
        this.f43253b.put(Collection.class, new C14414h());
        this.f43253b.put(List.class, new C14422p());
        this.f43253b.put(ArrayList.class, new C14422p());
        this.f43253b.put(Set.class, new C14426t());
        this.f43253b.put(HashSet.class, new C14426t());
        this.f43253b.put(TreeSet.class, new C14431y());
        this.f43253b.put(SparseArray.class, new C14427u());
        this.f43253b.put(Map.class, new C14424r());
        this.f43253b.put(HashMap.class, new C14424r());
        this.f43253b.put(TreeMap.class, new C14430x());
        this.f43253b.put(Integer.class, new C14418l());
        this.f43253b.put(Long.class, new C14423q());
        this.f43253b.put(Double.class, new C14415i());
        this.f43253b.put(Float.class, new C14416j());
        this.f43253b.put(Byte.class, new C14411e());
        this.f43253b.put(String.class, new C14429w());
        this.f43253b.put(Character.class, new C14413g());
        this.f43253b.put(Boolean.class, new C14408b());
        this.f43253b.put(byte[].class, new C14410d());
        this.f43253b.put(char[].class, new C14412f());
        this.f43253b.put(boolean[].class, new C14407a());
        this.f43253b.put(IBinder.class, new C14417k());
        this.f43253b.put(Bundle.class, new C14409c());
        this.f43253b.put(SparseBooleanArray.class, new C14428v());
        this.f43253b.put(LinkedList.class, new C14421o());
        this.f43253b.put(LinkedHashMap.class, new C14419m());
        this.f43253b.put(SortedMap.class, new C14430x());
        this.f43253b.put(SortedSet.class, new C14431y());
        this.f43253b.put(LinkedHashSet.class, new C14420n());
    }

    /* renamed from: a */
    public static NonParcelRepository m45954a() {
        return f43252a;
    }

    public Map<Class, C14379b> get() {
        return this.f43253b;
    }
}
