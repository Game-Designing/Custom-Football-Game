package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public final class AnnotatedClass extends Annotated implements TypeResolutionContext {
    private static final Creators NO_CREATORS = new Creators(null, Collections.emptyList(), Collections.emptyList());
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final TypeBindings _bindings;
    protected final Class<?> _class;
    protected final Annotations _classAnnotations;
    protected Creators _creators;
    protected List<AnnotatedField> _fields;
    protected AnnotatedMethodMap _memberMethods;
    protected final MixInResolver _mixInResolver;
    protected transient Boolean _nonStaticInnerClass;
    protected final Class<?> _primaryMixIn;
    protected final List<JavaType> _superTypes;
    protected final JavaType _type;
    protected final TypeFactory _typeFactory;

    public static final class Creators {
        public final List<AnnotatedConstructor> constructors;
        public final List<AnnotatedMethod> creatorMethods;
        public final AnnotatedConstructor defaultConstructor;

        public Creators(AnnotatedConstructor defCtor, List<AnnotatedConstructor> ctors, List<AnnotatedMethod> ctorMethods) {
            this.defaultConstructor = defCtor;
            this.constructors = ctors;
            this.creatorMethods = ctorMethods;
        }
    }

    AnnotatedClass(JavaType type, Class<?> rawType, List<JavaType> superTypes, Class<?> primaryMixIn, Annotations classAnnotations, TypeBindings bindings, AnnotationIntrospector aintr, MixInResolver mir, TypeFactory tf) {
        this._type = type;
        this._class = rawType;
        this._superTypes = superTypes;
        this._primaryMixIn = primaryMixIn;
        this._classAnnotations = classAnnotations;
        this._bindings = bindings;
        this._annotationIntrospector = aintr;
        this._mixInResolver = mir;
        this._typeFactory = tf;
    }

    AnnotatedClass(Class<?> rawType) {
        this._type = null;
        this._class = rawType;
        this._superTypes = Collections.emptyList();
        this._primaryMixIn = null;
        this._classAnnotations = AnnotationCollector.emptyAnnotations();
        this._bindings = TypeBindings.emptyBindings();
        this._annotationIntrospector = null;
        this._mixInResolver = null;
        this._typeFactory = null;
    }

    public JavaType resolveType(Type type) {
        return this._typeFactory.constructType(type, this._bindings);
    }

    public Class<?> getAnnotated() {
        return this._class;
    }

    public String getName() {
        return this._class.getName();
    }

    public <A extends Annotation> A getAnnotation(Class<A> acls) {
        return this._classAnnotations.get(acls);
    }

    public boolean hasAnnotation(Class<?> acls) {
        return this._classAnnotations.has(acls);
    }

    public boolean hasOneOf(Class<? extends Annotation>[] annoClasses) {
        return this._classAnnotations.hasOneOf(annoClasses);
    }

    public Class<?> getRawType() {
        return this._class;
    }

    public JavaType getType() {
        return this._type;
    }

    public Annotations getAnnotations() {
        return this._classAnnotations;
    }

    public boolean hasAnnotations() {
        return this._classAnnotations.size() > 0;
    }

    public AnnotatedConstructor getDefaultConstructor() {
        return _creators().defaultConstructor;
    }

    public List<AnnotatedConstructor> getConstructors() {
        return _creators().constructors;
    }

    public List<AnnotatedMethod> getFactoryMethods() {
        return _creators().creatorMethods;
    }

    public Iterable<AnnotatedMethod> memberMethods() {
        return _methods();
    }

    public AnnotatedMethod findMethod(String name, Class<?>[] paramTypes) {
        return _methods().find(name, paramTypes);
    }

    public Iterable<AnnotatedField> fields() {
        return _fields();
    }

    public boolean isNonStaticInnerClass() {
        Boolean B = this._nonStaticInnerClass;
        if (B == null) {
            Boolean valueOf = Boolean.valueOf(ClassUtil.isNonStaticInnerClass(this._class));
            B = valueOf;
            this._nonStaticInnerClass = valueOf;
        }
        return B.booleanValue();
    }

    private final List<AnnotatedField> _fields() {
        List<AnnotatedField> f = this._fields;
        if (f == null) {
            JavaType javaType = this._type;
            if (javaType == null) {
                f = Collections.emptyList();
            } else {
                f = AnnotatedFieldCollector.collectFields(this._annotationIntrospector, this, this._mixInResolver, this._typeFactory, javaType);
            }
            this._fields = f;
        }
        return f;
    }

    private final AnnotatedMethodMap _methods() {
        AnnotatedMethodMap m = this._memberMethods;
        if (m == null) {
            JavaType javaType = this._type;
            if (javaType == null) {
                m = new AnnotatedMethodMap();
            } else {
                m = AnnotatedMethodCollector.collectMethods(this._annotationIntrospector, this, this._mixInResolver, this._typeFactory, javaType, this._superTypes, this._primaryMixIn);
            }
            this._memberMethods = m;
        }
        return m;
    }

    private final Creators _creators() {
        Creators c = this._creators;
        if (c == null) {
            JavaType javaType = this._type;
            if (javaType == null) {
                c = NO_CREATORS;
            } else {
                c = AnnotatedCreatorCollector.collectCreators(this._annotationIntrospector, this, javaType, this._primaryMixIn);
            }
            this._creators = c;
        }
        return c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[AnnotedClass ");
        sb.append(this._class.getName());
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this._class.getName().hashCode();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, getClass())) {
            return false;
        }
        if (((AnnotatedClass) o)._class != this._class) {
            z = false;
        }
        return z;
    }
}
