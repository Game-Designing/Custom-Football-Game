package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmi;
import com.google.android.gms.internal.ads.zzdmj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzdmi<MessageType extends zzdmi<MessageType, BuilderType>, BuilderType extends zzdmj<MessageType, BuilderType>> implements zzdpk {
    private static boolean zzhcg = false;
    protected int zzhcf = 0;

    /* renamed from: b */
    public final zzdmr mo31531b() {
        try {
            C9800wo i = zzdmr.m29657i(mo31603c());
            mo31602a(i.mo29255b());
            return i.mo29254a();
        } catch (IOException e) {
            String str = "ByteString";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf(str).length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[mo31603c()];
            zzdni a = zzdni.m29704a(bArr);
            mo31602a(a);
            a.mo31569c();
            return bArr;
        } catch (IOException e) {
            String str = "byte array";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf(str).length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo31532h() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo31530a(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    protected static <T> void m29642a(Iterable<T> iterable, List<? super T> list) {
        zzdod.m29915a(iterable);
        String str = " is null.";
        String str2 = "Element at index ";
        if (iterable instanceof zzdot) {
            List x = ((zzdot) iterable).mo31632x();
            zzdot zzdot = (zzdot) list;
            int size = list.size();
            for (Object next : x) {
                if (next == null) {
                    int size2 = zzdot.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append(str2);
                    sb.append(size2);
                    sb.append(str);
                    String sb2 = sb.toString();
                    for (int size3 = zzdot.size() - 1; size3 >= size; size3--) {
                        zzdot.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzdmr) {
                    zzdot.mo31625a((zzdmr) next);
                } else {
                    zzdot.add((String) next);
                }
            }
        } else if (iterable instanceof C9696rp) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size() - size4;
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append(str2);
                    sb3.append(size5);
                    sb3.append(str);
                    String sb4 = sb3.toString();
                    for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                        list.remove(size6);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
