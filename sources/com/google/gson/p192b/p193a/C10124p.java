package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField;
import com.google.gson.p016a.C0088b;
import com.google.gson.p016a.C0089c;
import com.google.gson.p192b.C10059A;
import com.google.gson.p192b.C10139b;
import com.google.gson.p192b.C10157q;
import com.google.gson.p192b.C10159s;
import com.google.gson.p192b.C10170z;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.gson.b.a.p */
/* compiled from: ReflectiveTypeAdapterFactory */
public final class C10124p implements C10055D {

    /* renamed from: a */
    private final C10157q f30760a;

    /* renamed from: b */
    private final FieldNamingStrategy f30761b;

    /* renamed from: c */
    private final C10159s f30762c;

    /* renamed from: d */
    private final C10106f f30763d;

    /* renamed from: com.google.gson.b.a.p$a */
    /* compiled from: ReflectiveTypeAdapterFactory */
    public static final class C10125a<T> extends C10054C<T> {

        /* renamed from: a */
        private final C10170z<T> f30764a;

        /* renamed from: b */
        private final Map<String, C10126b> f30765b;

        C10125a(C10170z<T> constructor, Map<String, C10126b> boundFields) {
            this.f30764a = constructor;
            this.f30765b = boundFields;
        }

        /* renamed from: a */
        public T mo33197a(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            T instance = this.f30764a.mo33363a();
            try {
                in.beginObject();
                while (in.hasNext()) {
                    C10126b field = (C10126b) this.f30765b.get(in.nextName());
                    if (field != null) {
                        if (field.f30768c) {
                            field.mo33339a(in, (Object) instance);
                        }
                    }
                    in.skipValue();
                }
                in.endObject();
                return instance;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        /* renamed from: a */
        public void mo33198a(JsonWriter out, T value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.beginObject();
            try {
                for (C10126b boundField : this.f30765b.values()) {
                    if (boundField.mo33341a(value)) {
                        out.name(boundField.f30766a);
                        boundField.mo33340a(out, (Object) value);
                    }
                }
                out.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* renamed from: com.google.gson.b.a.p$b */
    /* compiled from: ReflectiveTypeAdapterFactory */
    static abstract class C10126b {

        /* renamed from: a */
        final String f30766a;

        /* renamed from: b */
        final boolean f30767b;

        /* renamed from: c */
        final boolean f30768c;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo33339a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo33340a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract boolean mo33341a(Object obj) throws IOException, IllegalAccessException;

        protected C10126b(String name, boolean serialized, boolean deserialized) {
            this.f30766a = name;
            this.f30767b = serialized;
            this.f30768c = deserialized;
        }
    }

    public C10124p(C10157q constructorConstructor, FieldNamingStrategy fieldNamingPolicy, C10159s excluder, C10106f jsonAdapterFactory) {
        this.f30760a = constructorConstructor;
        this.f30761b = fieldNamingPolicy;
        this.f30762c = excluder;
        this.f30763d = jsonAdapterFactory;
    }

    /* renamed from: a */
    public boolean mo33342a(Field f, boolean serialize) {
        return m33009a(f, serialize, this.f30762c);
    }

    /* renamed from: a */
    static boolean m33009a(Field f, boolean serialize, C10159s excluder) {
        return !excluder.mo33370a(f.getType(), serialize) && !excluder.mo33371a(f, serialize);
    }

    /* renamed from: a */
    private List<String> m33007a(Field f) {
        C0089c annotation = (C0089c) f.getAnnotation(C0089c.class);
        if (annotation == null) {
            return Collections.singletonList(this.f30761b.translateName(f));
        }
        String name = annotation.value();
        String[] alternates = annotation.alternate();
        if (alternates.length == 0) {
            return Collections.singletonList(name);
        }
        List<String> fieldNames = new ArrayList<>(alternates.length + 1);
        fieldNames.add(name);
        for (String alternate : alternates) {
            fieldNames.add(alternate);
        }
        return fieldNames;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> type) {
        Class<? super T> raw = type.mo33420a();
        if (!Object.class.isAssignableFrom(raw)) {
            return null;
        }
        return new C10125a(this.f30760a.mo33364a(type), m33008a(gson, type, raw));
    }

    /* renamed from: a */
    private C10126b m33006a(Gson context, Field field, String name, C10172a<?> fieldType, boolean serialize, boolean deserialize) {
        Gson gson = context;
        C10172a<?> aVar = fieldType;
        boolean isPrimitive = C10059A.m32831a((Type) fieldType.mo33420a());
        C0088b annotation = (C0088b) field.getAnnotation(C0088b.class);
        C10054C c = null;
        if (annotation != null) {
            c = this.f30763d.mo33293a(this.f30760a, gson, aVar, annotation);
        }
        boolean jsonAdapterPresent = c != null;
        if (c == null) {
            c = gson.getAdapter(aVar);
        }
        C0088b bVar = annotation;
        C10123o oVar = new C10123o(this, name, serialize, deserialize, field, jsonAdapterPresent, c, context, fieldType, isPrimitive);
        return oVar;
    }

    /* renamed from: a */
    private Map<String, C10126b> m33008a(Gson context, C10172a<?> type, Class<?> raw) {
        Map<String, BoundField> result = new LinkedHashMap<>();
        if (raw.isInterface()) {
            return result;
        }
        Type declaredType = type.mo33421b();
        C10172a<?> aVar = type;
        Class<?> raw2 = raw;
        while (raw2 != Object.class) {
            Field[] fields = raw2.getDeclaredFields();
            int length = fields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = fields[i];
                boolean serialize = mo33342a(field, true);
                boolean deserialize = mo33342a(field, z);
                if (serialize || deserialize) {
                    field.setAccessible(true);
                    Type fieldType = C10139b.m33055a(aVar.mo33421b(), raw2, field.getGenericType());
                    List a = m33007a(field);
                    int size = a.size();
                    int i2 = 0;
                    C10126b replaced = null;
                    while (i2 < size) {
                        String name = (String) a.get(i2);
                        if (i2 != 0) {
                            serialize = false;
                        }
                        boolean serialize2 = serialize;
                        String name2 = name;
                        C10126b previous = replaced;
                        int i3 = i2;
                        int size2 = size;
                        List list = a;
                        Field field2 = field;
                        replaced = (C10126b) result.put(name2, m33006a(context, field, name2, C10172a.m33120a(fieldType), serialize2, deserialize));
                        if (previous == null) {
                            C10126b bVar = replaced;
                        } else {
                            replaced = previous;
                        }
                        i2 = i3 + 1;
                        serialize = serialize2;
                        a = list;
                        size = size2;
                        field = field2;
                    }
                    C10126b previous2 = replaced;
                    int i4 = i2;
                    int i5 = size;
                    List list2 = a;
                    Field field3 = field;
                    if (previous2 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(declaredType);
                        sb.append(" declares multiple JSON fields named ");
                        sb.append(previous2.f30766a);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                i++;
                z = false;
            }
            aVar = C10172a.m33120a(C10139b.m33055a(aVar.mo33421b(), raw2, raw2.getGenericSuperclass()));
            raw2 = aVar.mo33420a();
        }
        return result;
    }
}
