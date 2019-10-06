package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @KeepForSdk
    public static final Creator<SafeParcelResponse> CREATOR = new zap();

    /* renamed from: a */
    private final int f20233a;

    /* renamed from: b */
    private final Parcel f20234b;

    /* renamed from: c */
    private final int f20235c = 2;

    /* renamed from: d */
    private final zak f20236d;

    /* renamed from: e */
    private final String f20237e;

    /* renamed from: f */
    private int f20238f;

    /* renamed from: g */
    private int f20239g;

    @Constructor
    SafeParcelResponse(@Param(id = 1) int i, @Param(id = 2) Parcel parcel, @Param(id = 3) zak zak) {
        this.f20233a = i;
        Preconditions.m21857a(parcel);
        this.f20234b = parcel;
        this.f20236d = zak;
        zak zak2 = this.f20236d;
        if (zak2 == null) {
            this.f20237e = null;
        } else {
            this.f20237e = zak2.mo27906c();
        }
        this.f20238f = 2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zak zak;
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20233a);
        SafeParcelWriter.m21961a(parcel, 2, m22042b(), false);
        int i2 = this.f20235c;
        if (i2 == 0) {
            zak = null;
        } else if (i2 == 1) {
            zak = this.f20236d;
        } else if (i2 == 2) {
            zak = this.f20236d;
        } else {
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) zak, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        if (r0 != 1) goto L_0x001a;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Parcel m22042b() {
        /*
            r2 = this;
            int r0 = r2.f20238f
            if (r0 == 0) goto L_0x0008
            r1 = 1
            if (r0 == r1) goto L_0x0010
            goto L_0x001a
        L_0x0008:
            android.os.Parcel r0 = r2.f20234b
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.m21953a(r0)
            r2.f20239g = r0
        L_0x0010:
            android.os.Parcel r0 = r2.f20234b
            int r1 = r2.f20239g
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.m21954a(r0, r1)
            r0 = 2
            r2.f20238f = r0
        L_0x001a:
            android.os.Parcel r0 = r2.f20234b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.m22042b():android.os.Parcel");
    }

    /* renamed from: a */
    public Map<String, Field<?, ?>> mo27101a() {
        zak zak = this.f20236d;
        if (zak == null) {
            return null;
        }
        return zak.mo27904a(this.f20237e);
    }

    /* renamed from: a */
    public Object mo27886a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* renamed from: b */
    public boolean mo27887b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public String toString() {
        Preconditions.m21858a(this.f20236d, (Object) "Cannot convert to JSON on client side.");
        Parcel b = m22042b();
        b.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m22041a(sb, this.f20236d.mo27904a(this.f20237e), b);
        return sb.toString();
    }

    /* renamed from: a */
    private final void m22041a(StringBuilder sb, Map<String, Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Entry entry : map.entrySet()) {
            sparseArray.put(((Field) entry.getValue()).mo27889a(), entry);
        }
        sb.append('{');
        int b = SafeParcelReader.m21925b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            Entry entry2 = (Entry) sparseArray.get(SafeParcelReader.m21919a(a));
            if (entry2 != null) {
                String str = ",";
                if (z) {
                    sb.append(str);
                }
                String str2 = (String) entry2.getKey();
                Field field = (Field) entry2.getValue();
                String str3 = "\"";
                sb.append(str3);
                sb.append(str2);
                sb.append("\":");
                if (field.mo27892c()) {
                    int i = field.f20205d;
                    switch (i) {
                        case 0:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, Integer.valueOf(SafeParcelReader.m21949w(parcel, a))));
                            break;
                        case 1:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, SafeParcelReader.m21928c(parcel, a)));
                            break;
                        case 2:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, Long.valueOf(SafeParcelReader.m21951y(parcel, a))));
                            break;
                        case 3:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, Float.valueOf(SafeParcelReader.m21947u(parcel, a))));
                            break;
                        case 4:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, Double.valueOf(SafeParcelReader.m21946t(parcel, a))));
                            break;
                        case 5:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, SafeParcelReader.m21922a(parcel, a)));
                            break;
                        case 6:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, Boolean.valueOf(SafeParcelReader.m21945s(parcel, a))));
                            break;
                        case 7:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, SafeParcelReader.m21941o(parcel, a)));
                            break;
                        case 8:
                        case 9:
                            m22043b(sb, field, FastJsonResponse.m22016a(field, SafeParcelReader.m21933g(parcel, a)));
                            break;
                        case 10:
                            Bundle f = SafeParcelReader.m21932f(parcel, a);
                            HashMap hashMap = new HashMap();
                            for (String str4 : f.keySet()) {
                                hashMap.put(str4, f.getString(str4));
                            }
                            m22043b(sb, field, FastJsonResponse.m22016a(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f20206e) {
                    sb.append("[");
                    switch (field.f20205d) {
                        case 0:
                            ArrayUtils.m22064a(sb, SafeParcelReader.m21936j(parcel, a));
                            break;
                        case 1:
                            ArrayUtils.m22066a(sb, (T[]) SafeParcelReader.m21930d(parcel, a));
                            break;
                        case 2:
                            ArrayUtils.m22065a(sb, SafeParcelReader.m21938l(parcel, a));
                            break;
                        case 3:
                            ArrayUtils.m22063a(sb, SafeParcelReader.m21935i(parcel, a));
                            break;
                        case 4:
                            ArrayUtils.m22062a(sb, SafeParcelReader.m21934h(parcel, a));
                            break;
                        case 5:
                            ArrayUtils.m22066a(sb, (T[]) SafeParcelReader.m21927b(parcel, a));
                            break;
                        case 6:
                            ArrayUtils.m22068a(sb, SafeParcelReader.m21931e(parcel, a));
                            break;
                        case 7:
                            ArrayUtils.m22067a(sb, SafeParcelReader.m21942p(parcel, a));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] n = SafeParcelReader.m21940n(parcel, a);
                            int length = n.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (i2 > 0) {
                                    sb.append(str);
                                }
                                n[i2].setDataPosition(0);
                                m22041a(sb, field.mo27893d(), n[i2]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f20205d) {
                        case 0:
                            sb.append(SafeParcelReader.m21949w(parcel, a));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.m21928c(parcel, a));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.m21951y(parcel, a));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.m21947u(parcel, a));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.m21946t(parcel, a));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.m21922a(parcel, a));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.m21945s(parcel, a));
                            break;
                        case 7:
                            String o = SafeParcelReader.m21941o(parcel, a);
                            sb.append(str3);
                            sb.append(JsonUtils.m22104a(o));
                            sb.append(str3);
                            break;
                        case 8:
                            byte[] g = SafeParcelReader.m21933g(parcel, a);
                            sb.append(str3);
                            sb.append(Base64Utils.m22070a(g));
                            sb.append(str3);
                            break;
                        case 9:
                            byte[] g2 = SafeParcelReader.m21933g(parcel, a);
                            sb.append(str3);
                            sb.append(Base64Utils.m22071b(g2));
                            sb.append(str3);
                            break;
                        case 10:
                            Bundle f2 = SafeParcelReader.m21932f(parcel, a);
                            Set<String> keySet = f2.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str5 : keySet) {
                                if (!z2) {
                                    sb.append(str);
                                }
                                sb.append(str3);
                                sb.append(str5);
                                sb.append(str3);
                                sb.append(":");
                                sb.append(str3);
                                sb.append(JsonUtils.m22104a(f2.getString(str5)));
                                sb.append(str3);
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel m = SafeParcelReader.m21939m(parcel, a);
                            m.setDataPosition(0);
                            m22041a(sb, field.mo27893d(), m);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == b) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(b);
        throw new ParseException(sb3.toString(), parcel);
    }

    /* renamed from: b */
    private final void m22043b(StringBuilder sb, Field<?, ?> field, Object obj) {
        if (field.f20204c) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                m22040a(sb, field.f20203b, arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        m22040a(sb, field.f20203b, obj);
    }

    /* renamed from: a */
    private static void m22040a(StringBuilder sb, int i, Object obj) {
        String str = "\"";
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append(str);
                sb.append(JsonUtils.m22104a(obj.toString()));
                sb.append(str);
                return;
            case 8:
                sb.append(str);
                sb.append(Base64Utils.m22070a((byte[]) obj));
                sb.append(str);
                return;
            case 9:
                sb.append(str);
                sb.append(Base64Utils.m22071b((byte[]) obj));
                sb.append(str);
                return;
            case 10:
                MapUtils.m22105a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }
}
