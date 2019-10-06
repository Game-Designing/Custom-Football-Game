package com.google.ads.mediation;

import com.google.android.gms.internal.ads.zzbad;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public class MediationServerParameters {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.google.ads.mediation.MediationServerParameters$a */
    public @interface C0086a {
        String name();

        boolean required() default true;
    }

    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public void mo24944a(Map<String, String> map) throws MappingException {
        Field[] fields;
        String str = "Server option \"";
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            C0086a aVar = (C0086a) field.getAnnotation(C0086a.class);
            if (aVar != null) {
                hashMap.put(aVar.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzbad.m26359d("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    String str2 = (String) entry.getKey();
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 49);
                    sb.append(str);
                    sb.append(str2);
                    sb.append("\" could not be set: Illegal Access");
                    zzbad.m26359d(sb.toString());
                } catch (IllegalArgumentException e2) {
                    String str3 = (String) entry.getKey();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 43);
                    sb2.append(str);
                    sb2.append(str3);
                    sb2.append("\" could not be set: Bad Type");
                    zzbad.m26359d(sb2.toString());
                }
            } else {
                String str4 = (String) entry.getKey();
                String str5 = (String) entry.getValue();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 31 + String.valueOf(str5).length());
                sb3.append("Unexpected server option: ");
                sb3.append(str4);
                sb3.append(" = \"");
                sb3.append(str5);
                sb3.append("\"");
                zzbad.m26352a(sb3.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((C0086a) field3.getAnnotation(C0086a.class)).required()) {
                String str6 = "Required server option missing: ";
                String valueOf = String.valueOf(((C0086a) field3.getAnnotation(C0086a.class)).name());
                zzbad.m26359d(valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
                if (sb4.length() > 0) {
                    sb4.append(", ");
                }
                sb4.append(((C0086a) field3.getAnnotation(C0086a.class)).name());
            }
        }
        if (sb4.length() > 0) {
            String str7 = "Required server option(s) missing: ";
            String valueOf2 = String.valueOf(sb4.toString());
            throw new MappingException(valueOf2.length() != 0 ? str7.concat(valueOf2) : new String(str7));
        }
    }
}
