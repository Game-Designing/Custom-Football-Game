package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
public abstract class FastJsonResponse {

    @ShowFirstParty
    @KeepForSdk
    @VisibleForTesting
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zai CREATOR = new zai();

        /* renamed from: a */
        private final int f20202a;

        /* renamed from: b */
        protected final int f20203b;

        /* renamed from: c */
        protected final boolean f20204c;

        /* renamed from: d */
        protected final int f20205d;

        /* renamed from: e */
        protected final boolean f20206e;

        /* renamed from: f */
        protected final String f20207f;

        /* renamed from: g */
        protected final int f20208g;

        /* renamed from: h */
        protected final Class<? extends FastJsonResponse> f20209h;

        /* renamed from: i */
        private final String f20210i;

        /* renamed from: j */
        private zak f20211j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public FieldConverter<I, O> f20212k;

        @Constructor
        Field(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) boolean z, @Param(id = 4) int i3, @Param(id = 5) boolean z2, @Param(id = 6) String str, @Param(id = 7) int i4, @Param(id = 8) String str2, @Param(id = 9) zaa zaa) {
            this.f20202a = i;
            this.f20203b = i2;
            this.f20204c = z;
            this.f20205d = i3;
            this.f20206e = z2;
            this.f20207f = str;
            this.f20208g = i4;
            if (str2 == null) {
                this.f20209h = null;
                this.f20210i = null;
            } else {
                this.f20209h = SafeParcelResponse.class;
                this.f20210i = str2;
            }
            if (zaa == null) {
                this.f20212k = null;
            } else {
                this.f20212k = zaa.mo27878a();
            }
        }

        private Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            this.f20202a = 1;
            this.f20203b = i;
            this.f20204c = z;
            this.f20205d = i2;
            this.f20206e = z2;
            this.f20207f = str;
            this.f20208g = i3;
            this.f20209h = cls;
            if (cls == null) {
                this.f20210i = null;
            } else {
                this.f20210i = cls.getCanonicalName();
            }
            this.f20212k = fieldConverter;
        }

        @KeepForSdk
        /* renamed from: a */
        public int mo27889a() {
            return this.f20208g;
        }

        /* renamed from: e */
        private final String m22030e() {
            String str = this.f20210i;
            if (str == null) {
                return null;
            }
            return str;
        }

        /* renamed from: c */
        public final boolean mo27892c() {
            return this.f20212k != null;
        }

        /* renamed from: a */
        public final void mo27891a(zak zak) {
            this.f20211j = zak;
        }

        /* renamed from: f */
        private final zaa m22031f() {
            FieldConverter<I, O> fieldConverter = this.f20212k;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.m22014a(fieldConverter);
        }

        /* renamed from: d */
        public final Map<String, Field<?, ?>> mo27893d() {
            Preconditions.m21857a(this.f20210i);
            Preconditions.m21857a(this.f20211j);
            return this.f20211j.mo27904a(this.f20210i);
        }

        /* renamed from: a */
        public final I mo27890a(O o) {
            return this.f20212k.mo27875a(o);
        }

        @KeepForSdk
        @VisibleForTesting
        /* renamed from: b */
        public static Field<Integer, Integer> m22026b(String str, int i) {
            Field field = new Field(0, false, 0, false, str, i, null, null);
            return field;
        }

        @KeepForSdk
        /* renamed from: c */
        public static Field<String, String> m22028c(String str, int i) {
            Field field = new Field(7, false, 7, false, str, i, null, null);
            return field;
        }

        @KeepForSdk
        /* renamed from: d */
        public static Field<ArrayList<String>, ArrayList<String>> m22029d(String str, int i) {
            Field field = new Field(7, true, 7, true, str, i, null, null);
            return field;
        }

        @KeepForSdk
        @VisibleForTesting
        /* renamed from: a */
        public static Field<byte[], byte[]> m22023a(String str, int i) {
            Field field = new Field(8, false, 8, false, str, i, null, null);
            return field;
        }

        @KeepForSdk
        /* renamed from: a */
        public static <T extends FastJsonResponse> Field<T, T> m22024a(String str, int i, Class<T> cls) {
            Field field = new Field(11, false, 11, false, str, i, cls, null);
            return field;
        }

        @KeepForSdk
        /* renamed from: b */
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> m22027b(String str, int i, Class<T> cls) {
            Field field = new Field(11, true, 11, true, str, i, cls, null);
            return field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = SafeParcelWriter.m21953a(parcel);
            SafeParcelWriter.m21957a(parcel, 1, this.f20202a);
            SafeParcelWriter.m21957a(parcel, 2, this.f20203b);
            SafeParcelWriter.m21968a(parcel, 3, this.f20204c);
            SafeParcelWriter.m21957a(parcel, 4, this.f20205d);
            SafeParcelWriter.m21968a(parcel, 5, this.f20206e);
            SafeParcelWriter.m21965a(parcel, 6, this.f20207f, false);
            SafeParcelWriter.m21957a(parcel, 7, mo27889a());
            SafeParcelWriter.m21965a(parcel, 8, m22030e(), false);
            SafeParcelWriter.m21962a(parcel, 9, (Parcelable) m22031f(), i, false);
            SafeParcelWriter.m21954a(parcel, a);
        }

        public String toString() {
            String str = "typeIn";
            String str2 = "typeInArray";
            String str3 = "typeOut";
            String str4 = "typeOutArray";
            String str5 = "outputFieldName";
            String str6 = "safeParcelFieldId";
            String str7 = "concreteTypeName";
            ToStringHelper a = Objects.m21850a((Object) this).mo27810a("versionCode", Integer.valueOf(this.f20202a)).mo27810a(str, Integer.valueOf(this.f20203b)).mo27810a(str2, Boolean.valueOf(this.f20204c)).mo27810a(str3, Integer.valueOf(this.f20205d)).mo27810a(str4, Boolean.valueOf(this.f20206e)).mo27810a(str5, this.f20207f).mo27810a(str6, Integer.valueOf(this.f20208g)).mo27810a(str7, m22030e());
            Class<? extends FastJsonResponse> cls = this.f20209h;
            if (cls != null) {
                a.mo27810a("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.f20212k;
            if (fieldConverter != null) {
                a.mo27810a("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return a.toString();
        }
    }

    @ShowFirstParty
    public interface FieldConverter<I, O> {
        /* renamed from: a */
        I mo27875a(O o);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public abstract Object mo27886a(String str);

    @KeepForSdk
    /* renamed from: a */
    public abstract Map<String, Field<?, ?>> mo27101a();

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: b */
    public abstract boolean mo27887b(String str);

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: b */
    public boolean mo27102b(Field field) {
        if (field.f20205d != 11) {
            return mo27887b(field.f20207f);
        }
        if (field.f20206e) {
            String str = field.f20207f;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        String str2 = field.f20207f;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* renamed from: a */
    protected static <O, I> I m22016a(Field<I, O> field, Object obj) {
        if (field.f20212k != null) {
            return field.mo27890a(obj);
        }
        return obj;
    }

    @KeepForSdk
    public String toString() {
        Map a = mo27101a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : a.keySet()) {
            Field field = (Field) a.get(str);
            if (mo27102b(field)) {
                Object a2 = m22016a(field, mo27100a(field));
                String str2 = ",";
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(str2);
                }
                String str3 = "\"";
                sb.append(str3);
                sb.append(str);
                sb.append("\":");
                if (a2 != null) {
                    switch (field.f20205d) {
                        case 8:
                            sb.append(str3);
                            sb.append(Base64Utils.m22070a((byte[]) a2));
                            sb.append(str3);
                            break;
                        case 9:
                            sb.append(str3);
                            sb.append(Base64Utils.m22071b((byte[]) a2));
                            sb.append(str3);
                            break;
                        case 10:
                            MapUtils.m22105a(sb, (HashMap) a2);
                            break;
                        default:
                            if (!field.f20204c) {
                                m22017a(sb, field, a2);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) a2;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(str2);
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        m22017a(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public Object mo27100a(Field field) {
        String str = field.f20207f;
        if (field.f20209h == null) {
            return mo27886a(str);
        }
        Preconditions.m21869b(mo27886a(str) == null, "Concrete field shouldn't be value object: %s", field.f20207f);
        boolean z = field.f20206e;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static void m22017a(StringBuilder sb, Field field, Object obj) {
        int i = field.f20203b;
        if (i == 11) {
            sb.append(((FastJsonResponse) field.f20209h.cast(obj)).toString());
        } else if (i == 7) {
            String str = "\"";
            sb.append(str);
            sb.append(JsonUtils.m22104a((String) obj));
            sb.append(str);
        } else {
            sb.append(obj);
        }
    }
}
