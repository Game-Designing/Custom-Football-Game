package com.google.gson;

import com.google.gson.p192b.C10068a;
import com.google.gson.p192b.C10159s;
import com.google.gson.p192b.p193a.C10118ka;
import com.google.gson.p192b.p193a.C10132v;
import com.google.gson.p195c.C10172a;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    private boolean complexMapKeySerialization = false;
    private String datePattern;
    private int dateStyle = 2;
    private boolean escapeHtmlChars = true;
    private C10159s excluder = C10159s.f30826a;
    private final List<C10055D> factories = new ArrayList();
    private FieldNamingStrategy fieldNamingPolicy = C10178i.IDENTITY;
    private boolean generateNonExecutableJson = false;
    private final List<C10055D> hierarchyFactories = new ArrayList();
    private final Map<Type, C10184o<?>> instanceCreators = new HashMap();
    private boolean lenient = false;
    private C10052A longSerializationPolicy = C10052A.DEFAULT;
    private boolean prettyPrinting = false;
    private boolean serializeNulls = false;
    private boolean serializeSpecialFloatingPointValues = false;
    private int timeStyle = 2;

    public GsonBuilder setVersion(double ignoreVersionsAfter) {
        this.excluder = this.excluder.mo33367a(ignoreVersionsAfter);
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... modifiers) {
        this.excluder = this.excluder.mo33369a(modifiers);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.mo33372b();
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.mo33366a();
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(C10052A serializationPolicy) {
        this.longSerializationPolicy = serializationPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(C10178i namingConvention) {
        this.fieldNamingPolicy = namingConvention;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setExclusionStrategies(C10058b... strategies) {
        for (C10058b strategy : strategies) {
            this.excluder = this.excluder.mo33368a(strategy, true, true);
        }
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(C10058b strategy) {
        this.excluder = this.excluder.mo33368a(strategy, true, false);
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(C10058b strategy) {
        this.excluder = this.excluder.mo33368a(strategy, false, true);
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder setDateFormat(String pattern) {
        this.datePattern = pattern;
        return this;
    }

    public GsonBuilder setDateFormat(int style) {
        this.dateStyle = style;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int dateStyle2, int timeStyle2) {
        this.dateStyle = dateStyle2;
        this.timeStyle = timeStyle2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object typeAdapter) {
        C10068a.m32843a((typeAdapter instanceof C10194x) || (typeAdapter instanceof C10187r) || (typeAdapter instanceof C10184o) || (typeAdapter instanceof C10054C));
        if (typeAdapter instanceof C10184o) {
            this.instanceCreators.put(type, (C10184o) typeAdapter);
        }
        if ((typeAdapter instanceof C10194x) || (typeAdapter instanceof C10187r)) {
            this.factories.add(C10132v.m33027a((C10172a<?>) C10172a.m33120a(type), typeAdapter));
        }
        if (typeAdapter instanceof C10054C) {
            this.factories.add(C10118ka.m32991a(C10172a.m33120a(type), (C10054C) typeAdapter));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(C10055D factory) {
        this.factories.add(factory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> baseType, Object typeAdapter) {
        C10068a.m32843a((typeAdapter instanceof C10194x) || (typeAdapter instanceof C10187r) || (typeAdapter instanceof C10054C));
        if ((typeAdapter instanceof C10187r) || (typeAdapter instanceof C10194x)) {
            this.hierarchyFactories.add(C10132v.m33028a(baseType, typeAdapter));
        }
        if (typeAdapter instanceof C10054C) {
            this.factories.add(C10118ka.m32994b(baseType, (C10054C) typeAdapter));
        }
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public Gson create() {
        ArrayList arrayList = new ArrayList(this.factories.size() + this.hierarchyFactories.size() + 3);
        arrayList.addAll(this.factories);
        Collections.reverse(arrayList);
        List<TypeAdapterFactory> hierarchyFactories2 = new ArrayList<>(this.hierarchyFactories);
        Collections.reverse(hierarchyFactories2);
        arrayList.addAll(hierarchyFactories2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        Gson gson = new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, arrayList);
        return gson;
    }

    private void addTypeAdaptersForDate(String datePattern2, int dateStyle2, int timeStyle2, List<C10055D> factories2) {
        TypeAdapter<Date> javaSqlDateTypeAdapter;
        TypeAdapter<Timestamp> timestampTypeAdapter;
        C10057a dateTypeAdapter;
        if (datePattern2 != null) {
            if (!"".equals(datePattern2.trim())) {
                dateTypeAdapter = new C10057a(java.util.Date.class, datePattern2);
                timestampTypeAdapter = new C10057a<>(Timestamp.class, datePattern2);
                javaSqlDateTypeAdapter = new C10057a<>(Date.class, datePattern2);
                factories2.add(C10118ka.m32992a(java.util.Date.class, (C10054C<TT>) dateTypeAdapter));
                factories2.add(C10118ka.m32992a(Timestamp.class, (C10054C<TT>) timestampTypeAdapter));
                factories2.add(C10118ka.m32992a(Date.class, (C10054C<TT>) javaSqlDateTypeAdapter));
            }
        }
        if (dateStyle2 != 2 && timeStyle2 != 2) {
            dateTypeAdapter = new C10057a(java.util.Date.class, dateStyle2, timeStyle2);
            timestampTypeAdapter = new C10057a<>(Timestamp.class, dateStyle2, timeStyle2);
            javaSqlDateTypeAdapter = new C10057a<>(Date.class, dateStyle2, timeStyle2);
            factories2.add(C10118ka.m32992a(java.util.Date.class, (C10054C<TT>) dateTypeAdapter));
            factories2.add(C10118ka.m32992a(Timestamp.class, (C10054C<TT>) timestampTypeAdapter));
            factories2.add(C10118ka.m32992a(Date.class, (C10054C<TT>) javaSqlDateTypeAdapter));
        }
    }
}
