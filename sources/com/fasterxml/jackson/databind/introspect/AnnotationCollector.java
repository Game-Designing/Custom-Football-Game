package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.Annotations;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class AnnotationCollector {
    protected static final Annotations NO_ANNOTATIONS = new NoAnnotations();
    protected final Object _data;

    static class EmptyCollector extends AnnotationCollector {
        public static final EmptyCollector instance = new EmptyCollector(null);

        EmptyCollector(Object data) {
            super(data);
        }

        public Annotations asAnnotations() {
            return AnnotationCollector.NO_ANNOTATIONS;
        }

        public AnnotationMap asAnnotationMap() {
            return new AnnotationMap();
        }

        public boolean isPresent(Annotation ann) {
            return false;
        }

        public AnnotationCollector addOrOverride(Annotation ann) {
            return new OneCollector(this._data, ann.annotationType(), ann);
        }
    }

    static class NCollector extends AnnotationCollector {
        protected final HashMap<Class<?>, Annotation> _annotations = new HashMap<>();

        public NCollector(Object data, Class<?> type1, Annotation value1, Class<?> type2, Annotation value2) {
            super(data);
            this._annotations.put(type1, value1);
            this._annotations.put(type2, value2);
        }

        public Annotations asAnnotations() {
            if (this._annotations.size() != 2) {
                return new AnnotationMap(this._annotations);
            }
            Iterator<Entry<Class<?>, Annotation>> it = this._annotations.entrySet().iterator();
            Entry<Class<?>, Annotation> en1 = (Entry) it.next();
            Entry<Class<?>, Annotation> en2 = (Entry) it.next();
            return new TwoAnnotations((Class) en1.getKey(), (Annotation) en1.getValue(), (Class) en2.getKey(), (Annotation) en2.getValue());
        }

        public AnnotationMap asAnnotationMap() {
            AnnotationMap result = new AnnotationMap();
            for (Annotation ann : this._annotations.values()) {
                result.add(ann);
            }
            return result;
        }

        public boolean isPresent(Annotation ann) {
            return this._annotations.containsKey(ann.annotationType());
        }

        public AnnotationCollector addOrOverride(Annotation ann) {
            this._annotations.put(ann.annotationType(), ann);
            return this;
        }
    }

    public static class NoAnnotations implements Annotations, Serializable {
        NoAnnotations() {
        }

        public <A extends Annotation> A get(Class<A> cls) {
            return null;
        }

        public boolean has(Class<?> cls) {
            return false;
        }

        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            return false;
        }

        public int size() {
            return 0;
        }
    }

    public static class OneAnnotation implements Annotations, Serializable {
        private final Class<?> _type;
        private final Annotation _value;

        public OneAnnotation(Class<?> type, Annotation value) {
            this._type = type;
            this._value = value;
        }

        public <A extends Annotation> A get(Class<A> cls) {
            if (this._type == cls) {
                return this._value;
            }
            return null;
        }

        public boolean has(Class<?> cls) {
            return this._type == cls;
        }

        public boolean hasOneOf(Class<? extends Annotation>[] annoClasses) {
            for (Class cls : annoClasses) {
                if (cls == this._type) {
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return 1;
        }
    }

    static class OneCollector extends AnnotationCollector {
        private Class<?> _type;
        private Annotation _value;

        public OneCollector(Object data, Class<?> type, Annotation value) {
            super(data);
            this._type = type;
            this._value = value;
        }

        public Annotations asAnnotations() {
            return new OneAnnotation(this._type, this._value);
        }

        public AnnotationMap asAnnotationMap() {
            return AnnotationMap.m13918of(this._type, this._value);
        }

        public boolean isPresent(Annotation ann) {
            return ann.annotationType() == this._type;
        }

        public AnnotationCollector addOrOverride(Annotation ann) {
            Class<?> type = ann.annotationType();
            Class<?> cls = this._type;
            if (cls == type) {
                this._value = ann;
                return this;
            }
            NCollector nCollector = new NCollector(this._data, cls, this._value, type, ann);
            return nCollector;
        }
    }

    public static class TwoAnnotations implements Annotations, Serializable {
        private final Class<?> _type1;
        private final Class<?> _type2;
        private final Annotation _value1;
        private final Annotation _value2;

        public TwoAnnotations(Class<?> type1, Annotation value1, Class<?> type2, Annotation value2) {
            this._type1 = type1;
            this._value1 = value1;
            this._type2 = type2;
            this._value2 = value2;
        }

        public <A extends Annotation> A get(Class<A> cls) {
            if (this._type1 == cls) {
                return this._value1;
            }
            if (this._type2 == cls) {
                return this._value2;
            }
            return null;
        }

        public boolean has(Class<?> cls) {
            return this._type1 == cls || this._type2 == cls;
        }

        public boolean hasOneOf(Class<? extends Annotation>[] annoClasses) {
            Class[] arr$;
            for (Class cls : annoClasses) {
                if (cls == this._type1 || cls == this._type2) {
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return 2;
        }
    }

    public abstract AnnotationCollector addOrOverride(Annotation annotation);

    public abstract AnnotationMap asAnnotationMap();

    public abstract Annotations asAnnotations();

    public abstract boolean isPresent(Annotation annotation);

    protected AnnotationCollector(Object d) {
        this._data = d;
    }

    public static Annotations emptyAnnotations() {
        return NO_ANNOTATIONS;
    }

    public static AnnotationCollector emptyCollector() {
        return EmptyCollector.instance;
    }
}
