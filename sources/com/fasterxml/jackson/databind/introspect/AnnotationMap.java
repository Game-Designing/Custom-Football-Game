package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public final class AnnotationMap implements Annotations {
    protected HashMap<Class<?>, Annotation> _annotations;

    public AnnotationMap() {
    }

    /* renamed from: of */
    public static AnnotationMap m13918of(Class<?> type, Annotation value) {
        HashMap<Class<?>, Annotation> ann = new HashMap<>(4);
        ann.put(type, value);
        return new AnnotationMap(ann);
    }

    AnnotationMap(HashMap<Class<?>, Annotation> a) {
        this._annotations = a;
    }

    public <A extends Annotation> A get(Class<A> cls) {
        HashMap<Class<?>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return null;
        }
        return (Annotation) hashMap.get(cls);
    }

    public boolean has(Class<?> cls) {
        HashMap<Class<?>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(cls);
    }

    public boolean hasOneOf(Class<? extends Annotation>[] annoClasses) {
        if (this._annotations != null) {
            for (Class<? extends Annotation> containsKey : annoClasses) {
                if (this._annotations.containsKey(containsKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static AnnotationMap merge(AnnotationMap primary, AnnotationMap secondary) {
        if (primary != null) {
            HashMap<Class<?>, Annotation> hashMap = primary._annotations;
            if (hashMap != null && !hashMap.isEmpty()) {
                if (secondary != null) {
                    HashMap<Class<?>, Annotation> hashMap2 = secondary._annotations;
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        HashMap<Class<?>, Annotation> annotations = new HashMap<>();
                        for (Annotation ann : secondary._annotations.values()) {
                            annotations.put(ann.annotationType(), ann);
                        }
                        for (Annotation ann2 : primary._annotations.values()) {
                            annotations.put(ann2.annotationType(), ann2);
                        }
                        return new AnnotationMap(annotations);
                    }
                }
                return primary;
            }
        }
        return secondary;
    }

    public int size() {
        HashMap<Class<?>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public boolean add(Annotation ann) {
        return _add(ann);
    }

    public String toString() {
        HashMap<Class<?>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return "[null]";
        }
        return hashMap.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean _add(Annotation ann) {
        if (this._annotations == null) {
            this._annotations = new HashMap<>();
        }
        Annotation previous = (Annotation) this._annotations.put(ann.annotationType(), ann);
        return previous == null || !previous.equals(ann);
    }
}
