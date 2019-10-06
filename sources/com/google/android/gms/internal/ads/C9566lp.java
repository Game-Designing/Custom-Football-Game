package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzc;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: com.google.android.gms.internal.ads.lp */
final class C9566lp {
    /* renamed from: a */
    static String m23859a(zzdpk zzdpk, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        m23861a(zzdpk, sb, 0);
        return sb.toString();
    }

    /* renamed from: a */
    private static void m23861a(zzdpk zzdpk, StringBuilder sb, int i) {
        String str;
        zzdpk zzdpk2 = zzdpk;
        StringBuilder sb2 = sb;
        int i2 = i;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        Method[] declaredMethods = zzdpk.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            str = "get";
            if (i3 >= length) {
                break;
            }
            Method method = declaredMethods[i3];
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(str)) {
                    treeSet.add(method.getName());
                }
            }
            i3++;
        }
        for (String str2 : treeSet) {
            String str3 = "";
            String replaceFirst = str2.replaceFirst(str, str3);
            String str4 = "List";
            boolean z = true;
            if (replaceFirst.endsWith(str4) && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals(str4)) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    m23862a(sb2, i2, m23860a(concat), zzdob.m29886a(method2, (Object) zzdpk2, new Object[0]));
                }
            }
            String str5 = "Map";
            if (replaceFirst.endsWith(str5) && !replaceFirst.equals(str5)) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    m23862a(sb2, i2, m23860a(concat2), zzdob.m29886a(method3, (Object) zzdpk2, new Object[0]));
                }
            }
            String str6 = "set";
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? str6.concat(valueOf5) : new String(str6))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? str.concat(valueOf6) : new String(str))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? str.concat(valueOf9) : new String(str));
                String str7 = "has";
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? str7.concat(valueOf10) : new String(str7));
                if (method4 != null) {
                    Object a = zzdob.m29886a(method4, (Object) zzdpk2, new Object[0]);
                    if (method5 == null) {
                        boolean z2 = a instanceof Boolean ? !((Boolean) a).booleanValue() : a instanceof Integer ? ((Integer) a).intValue() == 0 : a instanceof Float ? ((Float) a).floatValue() == 0.0f : a instanceof Double ? ((Double) a).doubleValue() == 0.0d : a instanceof String ? a.equals(str3) : a instanceof zzdmr ? a.equals(zzdmr.f27972a) : a instanceof zzdpk ? a == ((zzdpk) a).mo31601a() : a instanceof Enum ? ((Enum) a).ordinal() == 0 : false;
                        if (z2) {
                            z = false;
                        }
                    } else {
                        z = ((Boolean) zzdob.m29886a(method5, (Object) zzdpk2, new Object[0])).booleanValue();
                    }
                    if (z) {
                        m23862a(sb2, i2, m23860a(concat3), a);
                    }
                }
            }
        }
        if (zzdpk2 instanceof zzc) {
            Iterator e = ((zzc) zzdpk2).zzhhj.mo28430e();
            if (e.hasNext()) {
                ((Entry) e.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        zzdqu zzdqu = ((zzdob) zzdpk2).zzhhd;
        if (zzdqu != null) {
            zzdqu.mo31650a(sb2, i2);
        }
    }

    /* renamed from: a */
    static final void m23862a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a : (List) obj) {
                m23862a(sb, i, str, a);
            }
        } else if (obj instanceof Map) {
            for (Entry a2 : ((Map) obj).entrySet()) {
                m23862a(sb, i, str, a2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            String str2 = ": \"";
            if (obj instanceof String) {
                sb.append(str2);
                sb.append(C8986Lp.m22799a(zzdmr.m29651a((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzdmr) {
                sb.append(str2);
                sb.append(C8986Lp.m22799a((zzdmr) obj));
                sb.append('\"');
            } else {
                String str3 = "}";
                String str4 = "\n";
                String str5 = " {";
                if (obj instanceof zzdob) {
                    sb.append(str5);
                    m23861a((zzdob) obj, sb, i + 2);
                    sb.append(str4);
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                    sb.append(str3);
                } else if (obj instanceof Entry) {
                    sb.append(str5);
                    Entry entry = (Entry) obj;
                    int i4 = i + 2;
                    m23862a(sb, i4, Notification.KEY, entry.getKey());
                    m23862a(sb, i4, DonationsAnalytics.VALUE, entry.getValue());
                    sb.append(str4);
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                    sb.append(str3);
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private static final String m23860a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
