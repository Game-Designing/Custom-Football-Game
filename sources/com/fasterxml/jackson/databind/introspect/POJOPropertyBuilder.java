package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter.Value;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyMetadata.MergeInfo;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {
    private static final ReferenceProperty NOT_REFEFERENCE_PROP = ReferenceProperty.managed("");
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final MapperConfig<?> _config;
    protected Linked<AnnotatedParameter> _ctorParameters;
    protected Linked<AnnotatedField> _fields;
    protected final boolean _forSerialization;
    protected Linked<AnnotatedMethod> _getters;
    protected final PropertyName _internalName;
    protected transient PropertyMetadata _metadata;
    protected final PropertyName _name;
    protected transient ReferenceProperty _referenceInfo;
    protected Linked<AnnotatedMethod> _setters;

    /* renamed from: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$10 */
    static /* synthetic */ class C682510 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonProperty$Access = new int[Access.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonProperty$Access[Access.READ_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonProperty$Access[Access.READ_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonProperty$Access[Access.WRITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonProperty$Access[Access.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    protected static final class Linked<T> {
        public final boolean isMarkedIgnored;
        public final boolean isNameExplicit;
        public final boolean isVisible;
        public final PropertyName name;
        public final Linked<T> next;
        public final T value;

        public Linked(T v, Linked<T> n, PropertyName name2, boolean explName, boolean visible, boolean ignored) {
            this.value = v;
            this.next = n;
            this.name = (name2 == null || name2.isEmpty()) ? null : name2;
            if (explName) {
                if (this.name == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                } else if (!name2.hasSimpleName()) {
                    explName = false;
                }
            }
            this.isNameExplicit = explName;
            this.isVisible = visible;
            this.isMarkedIgnored = ignored;
        }

        public Linked<T> withoutNext() {
            if (this.next == null) {
                return this;
            }
            Linked linked = new Linked(this.value, null, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
            return linked;
        }

        public Linked<T> withValue(T newValue) {
            if (newValue == this.value) {
                return this;
            }
            Linked linked = new Linked(newValue, this.next, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
            return linked;
        }

        public Linked<T> withNext(Linked<T> newNext) {
            if (newNext == this.next) {
                return this;
            }
            Linked linked = new Linked(this.value, newNext, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
            return linked;
        }

        public Linked<T> withoutIgnored() {
            if (this.isMarkedIgnored) {
                Linked<T> linked = this.next;
                return linked == null ? null : linked.withoutIgnored();
            }
            Linked<T> linked2 = this.next;
            if (linked2 != null) {
                Linked<T> newNext = linked2.withoutIgnored();
                if (newNext != this.next) {
                    return withNext(newNext);
                }
            }
            return this;
        }

        public Linked<T> withoutNonVisible() {
            Linked<T> linked = this.next;
            Linked<T> newNext = linked == null ? null : linked.withoutNonVisible();
            return this.isVisible ? withNext(newNext) : newNext;
        }

        /* access modifiers changed from: protected */
        public Linked<T> append(Linked<T> appendable) {
            Linked<T> linked = this.next;
            if (linked == null) {
                return withNext(appendable);
            }
            return withNext(linked.append(appendable));
        }

        public Linked<T> trimByVisibility() {
            Linked<T> linked = this.next;
            if (linked == null) {
                return this;
            }
            Linked<T> newNext = linked.trimByVisibility();
            if (this.name != null) {
                if (newNext.name == null) {
                    return withNext(null);
                }
                return withNext(newNext);
            } else if (newNext.name != null) {
                return newNext;
            } else {
                boolean z = this.isVisible;
                if (z == newNext.isVisible) {
                    return withNext(newNext);
                }
                return z ? withNext(null) : newNext;
            }
        }

        public String toString() {
            String msg = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", new Object[]{this.value.toString(), Boolean.valueOf(this.isVisible), Boolean.valueOf(this.isMarkedIgnored), Boolean.valueOf(this.isNameExplicit)});
            if (this.next == null) {
                return msg;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(msg);
            sb.append(", ");
            sb.append(this.next.toString());
            return sb.toString();
        }
    }

    protected static class MemberIterator<T extends AnnotatedMember> implements Iterator<T> {
        private Linked<T> next;

        public MemberIterator(Linked<T> first) {
            this.next = first;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public T next() {
            Linked<T> linked = this.next;
            if (linked != null) {
                T result = (AnnotatedMember) linked.value;
                this.next = linked.next;
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private interface WithMember<T> {
        T withMember(AnnotatedMember annotatedMember);
    }

    public POJOPropertyBuilder(MapperConfig<?> config, AnnotationIntrospector ai, boolean forSerialization, PropertyName internalName) {
        this(config, ai, forSerialization, internalName, internalName);
    }

    protected POJOPropertyBuilder(MapperConfig<?> config, AnnotationIntrospector ai, boolean forSerialization, PropertyName internalName, PropertyName name) {
        this._config = config;
        this._annotationIntrospector = ai;
        this._internalName = internalName;
        this._name = name;
        this._forSerialization = forSerialization;
    }

    protected POJOPropertyBuilder(POJOPropertyBuilder src, PropertyName newName) {
        this._config = src._config;
        this._annotationIntrospector = src._annotationIntrospector;
        this._internalName = src._internalName;
        this._name = newName;
        this._fields = src._fields;
        this._ctorParameters = src._ctorParameters;
        this._getters = src._getters;
        this._setters = src._setters;
        this._forSerialization = src._forSerialization;
    }

    public POJOPropertyBuilder withName(PropertyName newName) {
        return new POJOPropertyBuilder(this, newName);
    }

    public POJOPropertyBuilder withSimpleName(String newSimpleName) {
        PropertyName newName = this._name.withSimpleName(newSimpleName);
        return newName == this._name ? this : new POJOPropertyBuilder(this, newName);
    }

    public int compareTo(POJOPropertyBuilder other) {
        if (this._ctorParameters != null) {
            if (other._ctorParameters == null) {
                return -1;
            }
        } else if (other._ctorParameters != null) {
            return 1;
        }
        return getName().compareTo(other.getName());
    }

    public String getName() {
        PropertyName propertyName = this._name;
        if (propertyName == null) {
            return null;
        }
        return propertyName.getSimpleName();
    }

    public PropertyName getFullName() {
        return this._name;
    }

    public boolean hasName(PropertyName name) {
        return this._name.equals(name);
    }

    public String getInternalName() {
        return this._internalName.getSimpleName();
    }

    public PropertyName getWrapperName() {
        AnnotatedMember member = getPrimaryMember();
        if (member != null) {
            AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
            if (annotationIntrospector != null) {
                return annotationIntrospector.findWrapperName(member);
            }
        }
        return null;
    }

    public boolean isExplicitlyIncluded() {
        return _anyExplicits(this._fields) || _anyExplicits(this._getters) || _anyExplicits(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    public boolean isExplicitlyNamed() {
        return _anyExplicitNames(this._fields) || _anyExplicitNames(this._getters) || _anyExplicitNames(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    public PropertyMetadata getMetadata() {
        if (this._metadata == null) {
            Boolean b = _findRequired();
            String desc = _findDescription();
            Integer idx = _findIndex();
            String def = _findDefaultValue();
            if (b == null && idx == null && def == null) {
                this._metadata = desc == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : PropertyMetadata.STD_REQUIRED_OR_OPTIONAL.withDescription(desc);
            } else {
                this._metadata = PropertyMetadata.construct(b, desc, idx, def);
            }
            if (!this._forSerialization) {
                this._metadata = _getSetterInfo(this._metadata);
            }
        }
        return this._metadata;
    }

    /* access modifiers changed from: protected */
    public PropertyMetadata _getSetterInfo(PropertyMetadata metadata) {
        boolean needMerge = true;
        Nulls valueNulls = null;
        Nulls contentNulls = null;
        AnnotatedMember prim = getPrimaryMember();
        AnnotatedMember acc = getAccessor();
        if (prim != null) {
            AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
            if (annotationIntrospector != null) {
                if (acc != null) {
                    Boolean b = annotationIntrospector.findMergeInfo(prim);
                    if (b != null) {
                        needMerge = false;
                        if (b.booleanValue()) {
                            metadata = metadata.withMergeInfo(MergeInfo.createForPropertyOverride(acc));
                        }
                    }
                }
                Value setterInfo = this._annotationIntrospector.findSetterInfo(prim);
                if (setterInfo != null) {
                    valueNulls = setterInfo.nonDefaultValueNulls();
                    contentNulls = setterInfo.nonDefaultContentNulls();
                }
            }
            if (needMerge || valueNulls == null || contentNulls == null) {
                ConfigOverride co = this._config.getConfigOverride(getRawPrimaryType());
                Value setterInfo2 = co.getSetterInfo();
                if (setterInfo2 != null) {
                    if (valueNulls == null) {
                        valueNulls = setterInfo2.nonDefaultValueNulls();
                    }
                    if (contentNulls == null) {
                        contentNulls = setterInfo2.nonDefaultContentNulls();
                    }
                }
                if (needMerge && acc != null) {
                    Boolean b2 = co.getMergeable();
                    if (b2 != null) {
                        needMerge = false;
                        if (b2.booleanValue()) {
                            metadata = metadata.withMergeInfo(MergeInfo.createForTypeOverride(acc));
                        }
                    }
                }
            }
        }
        if (needMerge || valueNulls == null || contentNulls == null) {
            Value setterInfo3 = this._config.getDefaultSetterInfo();
            if (valueNulls == null) {
                valueNulls = setterInfo3.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo3.nonDefaultContentNulls();
            }
            if (needMerge) {
                if (Boolean.TRUE.equals(this._config.getDefaultMergeable()) && acc != null) {
                    metadata = metadata.withMergeInfo(MergeInfo.createForDefaults(acc));
                }
            }
        }
        if (valueNulls == null && contentNulls == null) {
            return metadata;
        }
        return metadata.withNulls(valueNulls, contentNulls);
    }

    public JavaType getPrimaryType() {
        if (this._forSerialization) {
            AnnotatedMethod getter = getGetter();
            if (getter != null) {
                return getter.getType();
            }
            AnnotatedField field = getField();
            if (field == null) {
                return TypeFactory.unknownType();
            }
            return field.getType();
        }
        AnnotatedMember m = getConstructorParameter();
        if (m == null) {
            AnnotatedMethod setter = getSetter();
            if (setter != null) {
                return setter.getParameterType(0);
            }
            m = getField();
        }
        if (m == null) {
            m = getGetter();
            if (m == null) {
                return TypeFactory.unknownType();
            }
        }
        return m.getType();
    }

    public Class<?> getRawPrimaryType() {
        return getPrimaryType().getRawClass();
    }

    public boolean hasGetter() {
        return this._getters != null;
    }

    public boolean hasSetter() {
        return this._setters != null;
    }

    public boolean hasField() {
        return this._fields != null;
    }

    public boolean hasConstructorParameter() {
        return this._ctorParameters != null;
    }

    public boolean couldDeserialize() {
        return (this._ctorParameters == null && this._setters == null && this._fields == null) ? false : true;
    }

    public boolean couldSerialize() {
        return (this._getters == null && this._fields == null) ? false : true;
    }

    public AnnotatedMethod getGetter() {
        Linked linked = this._getters;
        if (linked == null) {
            return null;
        }
        Linked linked2 = linked.next;
        if (linked2 == null) {
            return (AnnotatedMethod) linked.value;
        }
        while (linked2 != null) {
            Class<?> currClass = ((AnnotatedMethod) linked.value).getDeclaringClass();
            Class<?> nextClass = ((AnnotatedMethod) linked2.value).getDeclaringClass();
            if (currClass != nextClass) {
                if (currClass.isAssignableFrom(nextClass)) {
                    linked = linked2;
                } else if (nextClass.isAssignableFrom(currClass)) {
                    continue;
                }
                linked2 = linked2.next;
            }
            int priNext = _getterPriority((AnnotatedMethod) linked2.value);
            int priCurr = _getterPriority((AnnotatedMethod) linked.value);
            if (priNext != priCurr) {
                if (priNext < priCurr) {
                    linked = linked2;
                }
                linked2 = linked2.next;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Conflicting getter definitions for property \"");
                sb.append(getName());
                sb.append("\": ");
                sb.append(((AnnotatedMethod) linked.value).getFullName());
                sb.append(" vs ");
                sb.append(((AnnotatedMethod) linked2.value).getFullName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this._getters = linked.withoutNext();
        return (AnnotatedMethod) linked.value;
    }

    public AnnotatedMethod getSetter() {
        Linked linked = this._setters;
        if (linked == null) {
            return null;
        }
        Linked linked2 = linked.next;
        if (linked2 == null) {
            return (AnnotatedMethod) linked.value;
        }
        while (linked2 != null) {
            Class<?> currClass = ((AnnotatedMethod) linked.value).getDeclaringClass();
            Class<?> nextClass = ((AnnotatedMethod) linked2.value).getDeclaringClass();
            if (currClass != nextClass) {
                if (currClass.isAssignableFrom(nextClass)) {
                    linked = linked2;
                } else if (nextClass.isAssignableFrom(currClass)) {
                    continue;
                }
                linked2 = linked2.next;
            }
            AnnotatedMethod nextM = (AnnotatedMethod) linked2.value;
            AnnotatedMethod currM = (AnnotatedMethod) linked.value;
            int priNext = _setterPriority(nextM);
            int priCurr = _setterPriority(currM);
            if (priNext == priCurr) {
                AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
                if (annotationIntrospector != null) {
                    AnnotatedMethod pref = annotationIntrospector.resolveSetterConflict(this._config, currM, nextM);
                    if (pref == currM) {
                        continue;
                    } else if (pref == nextM) {
                        linked = linked2;
                    }
                }
                throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", new Object[]{getName(), ((AnnotatedMethod) linked.value).getFullName(), ((AnnotatedMethod) linked2.value).getFullName()}));
            } else if (priNext < priCurr) {
                linked = linked2;
            }
            linked2 = linked2.next;
        }
        this._setters = linked.withoutNext();
        return (AnnotatedMethod) linked.value;
    }

    public AnnotatedField getField() {
        Linked<AnnotatedField> linked = this._fields;
        if (linked == null) {
            return null;
        }
        AnnotatedField field = (AnnotatedField) linked.value;
        Linked<T> linked2 = linked.next;
        while (linked2 != null) {
            AnnotatedField nextField = (AnnotatedField) linked2.value;
            Class<?> fieldClass = field.getDeclaringClass();
            Class<?> nextClass = nextField.getDeclaringClass();
            if (fieldClass != nextClass) {
                if (fieldClass.isAssignableFrom(nextClass)) {
                    field = nextField;
                } else if (nextClass.isAssignableFrom(fieldClass)) {
                }
                linked2 = linked2.next;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Multiple fields representing property \"");
            sb.append(getName());
            sb.append("\": ");
            sb.append(field.getFullName());
            sb.append(" vs ");
            sb.append(nextField.getFullName());
            throw new IllegalArgumentException(sb.toString());
        }
        return field;
    }

    public AnnotatedParameter getConstructorParameter() {
        if (this._ctorParameters == null) {
            return null;
        }
        Linked linked = this._ctorParameters;
        while (!(((AnnotatedParameter) linked.value).getOwner() instanceof AnnotatedConstructor)) {
            linked = linked.next;
            if (linked == null) {
                return (AnnotatedParameter) this._ctorParameters.value;
            }
        }
        return (AnnotatedParameter) linked.value;
    }

    public Iterator<AnnotatedParameter> getConstructorParameters() {
        Linked<AnnotatedParameter> linked = this._ctorParameters;
        if (linked == null) {
            return ClassUtil.emptyIterator();
        }
        return new MemberIterator(linked);
    }

    public AnnotatedMember getPrimaryMember() {
        if (this._forSerialization) {
            return getAccessor();
        }
        AnnotatedMember m = getMutator();
        if (m == null) {
            m = getAccessor();
        }
        return m;
    }

    /* access modifiers changed from: protected */
    public int _getterPriority(AnnotatedMethod m) {
        String name = m.getName();
        if (name.startsWith("get") && name.length() > 3) {
            return 1;
        }
        if (!name.startsWith("is") || name.length() <= 2) {
            return 3;
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public int _setterPriority(AnnotatedMethod m) {
        String name = m.getName();
        if (!name.startsWith("set") || name.length() <= 3) {
            return 2;
        }
        return 1;
    }

    public Class<?>[] findViews() {
        return (Class[]) fromMemberAnnotations(new WithMember<Class<?>[]>() {
            public Class<?>[] withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findViews(member);
            }
        });
    }

    public ReferenceProperty findReferenceType() {
        ReferenceProperty result = this._referenceInfo;
        if (result == null) {
            ReferenceProperty result2 = (ReferenceProperty) fromMemberAnnotations(new WithMember<ReferenceProperty>() {
                public ReferenceProperty withMember(AnnotatedMember member) {
                    return POJOPropertyBuilder.this._annotationIntrospector.findReferenceType(member);
                }
            });
            this._referenceInfo = result2 == null ? NOT_REFEFERENCE_PROP : result2;
            return result2;
        } else if (result == NOT_REFEFERENCE_PROP) {
            return null;
        } else {
            return result;
        }
    }

    public boolean isTypeId() {
        Boolean b = (Boolean) fromMemberAnnotations(new WithMember<Boolean>() {
            public Boolean withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.isTypeId(member);
            }
        });
        return b != null && b.booleanValue();
    }

    /* access modifiers changed from: protected */
    public Boolean _findRequired() {
        return (Boolean) fromMemberAnnotations(new WithMember<Boolean>() {
            public Boolean withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.hasRequiredMarker(member);
            }
        });
    }

    /* access modifiers changed from: protected */
    public String _findDescription() {
        return (String) fromMemberAnnotations(new WithMember<String>() {
            public String withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyDescription(member);
            }
        });
    }

    /* access modifiers changed from: protected */
    public Integer _findIndex() {
        return (Integer) fromMemberAnnotations(new WithMember<Integer>() {
            public Integer withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyIndex(member);
            }
        });
    }

    /* access modifiers changed from: protected */
    public String _findDefaultValue() {
        return (String) fromMemberAnnotations(new WithMember<String>() {
            public String withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyDefaultValue(member);
            }
        });
    }

    public ObjectIdInfo findObjectIdInfo() {
        return (ObjectIdInfo) fromMemberAnnotations(new WithMember<ObjectIdInfo>() {
            public ObjectIdInfo withMember(AnnotatedMember member) {
                ObjectIdInfo info = POJOPropertyBuilder.this._annotationIntrospector.findObjectIdInfo(member);
                if (info != null) {
                    return POJOPropertyBuilder.this._annotationIntrospector.findObjectReferenceInfo(member, info);
                }
                return info;
            }
        });
    }

    public JsonInclude.Value findInclusion() {
        AnnotatedMember a = getAccessor();
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        JsonInclude.Value v = annotationIntrospector == null ? null : annotationIntrospector.findPropertyInclusion(a);
        return v == null ? JsonInclude.Value.empty() : v;
    }

    public Access findAccess() {
        return (Access) fromMemberAnnotationsExcept(new WithMember<Access>() {
            public Access withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyAccess(member);
            }
        }, Access.AUTO);
    }

    public void addField(AnnotatedField a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        Linked linked = new Linked(a, this._fields, name, explName, visible, ignored);
        this._fields = linked;
    }

    public void addCtor(AnnotatedParameter a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        Linked linked = new Linked(a, this._ctorParameters, name, explName, visible, ignored);
        this._ctorParameters = linked;
    }

    public void addGetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        Linked linked = new Linked(a, this._getters, name, explName, visible, ignored);
        this._getters = linked;
    }

    public void addSetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        Linked linked = new Linked(a, this._setters, name, explName, visible, ignored);
        this._setters = linked;
    }

    public void addAll(POJOPropertyBuilder src) {
        this._fields = merge(this._fields, src._fields);
        this._ctorParameters = merge(this._ctorParameters, src._ctorParameters);
        this._getters = merge(this._getters, src._getters);
        this._setters = merge(this._setters, src._setters);
    }

    private static <T> Linked<T> merge(Linked<T> chain1, Linked<T> chain2) {
        if (chain1 == null) {
            return chain2;
        }
        if (chain2 == null) {
            return chain1;
        }
        return chain1.append(chain2);
    }

    public void removeIgnored() {
        this._fields = _removeIgnored(this._fields);
        this._getters = _removeIgnored(this._getters);
        this._setters = _removeIgnored(this._setters);
        this._ctorParameters = _removeIgnored(this._ctorParameters);
    }

    public Access removeNonVisible(boolean inferMutators) {
        Access acc = findAccess();
        if (acc == null) {
            acc = Access.AUTO;
        }
        int i = C682510.$SwitchMap$com$fasterxml$jackson$annotation$JsonProperty$Access[acc.ordinal()];
        if (i == 1) {
            this._setters = null;
            this._ctorParameters = null;
            if (!this._forSerialization) {
                this._fields = null;
            }
        } else if (i != 2) {
            if (i != 3) {
                this._getters = _removeNonVisible(this._getters);
                this._ctorParameters = _removeNonVisible(this._ctorParameters);
                if (!inferMutators || this._getters == null) {
                    this._fields = _removeNonVisible(this._fields);
                    this._setters = _removeNonVisible(this._setters);
                }
            } else {
                this._getters = null;
                if (this._forSerialization) {
                    this._fields = null;
                }
            }
        }
        return acc;
    }

    public void removeConstructors() {
        this._ctorParameters = null;
    }

    public void trimByVisibility() {
        this._fields = _trimByVisibility(this._fields);
        this._getters = _trimByVisibility(this._getters);
        this._setters = _trimByVisibility(this._setters);
        this._ctorParameters = _trimByVisibility(this._ctorParameters);
    }

    public void mergeAnnotations(boolean forSerialization) {
        if (forSerialization) {
            Linked<AnnotatedMethod> linked = this._getters;
            if (linked != null) {
                this._getters = _applyAnnotations(this._getters, _mergeAnnotations(0, linked, this._fields, this._ctorParameters, this._setters));
                return;
            }
            Linked<AnnotatedField> linked2 = this._fields;
            if (linked2 != null) {
                this._fields = _applyAnnotations(this._fields, _mergeAnnotations(0, linked2, this._ctorParameters, this._setters));
                return;
            }
            return;
        }
        Linked<AnnotatedParameter> linked3 = this._ctorParameters;
        if (linked3 != null) {
            this._ctorParameters = _applyAnnotations(this._ctorParameters, _mergeAnnotations(0, linked3, this._setters, this._fields, this._getters));
            return;
        }
        Linked<AnnotatedMethod> linked4 = this._setters;
        if (linked4 != null) {
            this._setters = _applyAnnotations(this._setters, _mergeAnnotations(0, linked4, this._fields, this._getters));
            return;
        }
        Linked<AnnotatedField> linked5 = this._fields;
        if (linked5 != null) {
            this._fields = _applyAnnotations(this._fields, _mergeAnnotations(0, linked5, this._getters));
        }
    }

    private AnnotationMap _mergeAnnotations(int index, Linked<? extends AnnotatedMember>... nodes) {
        AnnotationMap ann = _getAllAnnotations(nodes[index]);
        do {
            index++;
            if (index >= nodes.length) {
                return ann;
            }
        } while (nodes[index] == null);
        return AnnotationMap.merge(ann, _mergeAnnotations(index, nodes));
    }

    private <T extends AnnotatedMember> AnnotationMap _getAllAnnotations(Linked<T> node) {
        AnnotationMap ann = ((AnnotatedMember) node.value).getAllAnnotations();
        Linked<T> linked = node.next;
        if (linked != null) {
            return AnnotationMap.merge(ann, _getAllAnnotations(linked));
        }
        return ann;
    }

    private <T extends AnnotatedMember> Linked<T> _applyAnnotations(Linked<T> node, AnnotationMap ann) {
        T value = (AnnotatedMember) ((AnnotatedMember) node.value).withAnnotations(ann);
        Linked<T> linked = node.next;
        if (linked != null) {
            node = node.withNext(_applyAnnotations(linked, ann));
        }
        return node.withValue(value);
    }

    private <T> Linked<T> _removeIgnored(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.withoutIgnored();
    }

    private <T> Linked<T> _removeNonVisible(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.withoutNonVisible();
    }

    private <T> Linked<T> _trimByVisibility(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.trimByVisibility();
    }

    private <T> boolean _anyExplicits(Linked<T> n) {
        while (n != null) {
            PropertyName propertyName = n.name;
            if (propertyName != null && propertyName.hasSimpleName()) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    private <T> boolean _anyExplicitNames(Linked<T> n) {
        while (n != null) {
            if (n.name != null && n.isNameExplicit) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean anyVisible() {
        return _anyVisible(this._fields) || _anyVisible(this._getters) || _anyVisible(this._setters) || _anyVisible(this._ctorParameters);
    }

    private <T> boolean _anyVisible(Linked<T> n) {
        while (n != null) {
            if (n.isVisible) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean anyIgnorals() {
        return _anyIgnorals(this._fields) || _anyIgnorals(this._getters) || _anyIgnorals(this._setters) || _anyIgnorals(this._ctorParameters);
    }

    private <T> boolean _anyIgnorals(Linked<T> n) {
        while (n != null) {
            if (n.isMarkedIgnored) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public Set<PropertyName> findExplicitNames() {
        Set<PropertyName> renamed = _findExplicitNames(this._ctorParameters, _findExplicitNames(this._setters, _findExplicitNames(this._getters, _findExplicitNames(this._fields, null))));
        if (renamed == null) {
            return Collections.emptySet();
        }
        return renamed;
    }

    public Collection<POJOPropertyBuilder> explode(Collection<PropertyName> newNames) {
        HashMap<PropertyName, POJOPropertyBuilder> props = new HashMap<>();
        _explode(newNames, props, this._fields);
        _explode(newNames, props, this._getters);
        _explode(newNames, props, this._setters);
        _explode(newNames, props, this._ctorParameters);
        return props.values();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<?>, code=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked, for r14v0, types: [com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<?>, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _explode(java.util.Collection<com.fasterxml.jackson.databind.PropertyName> r12, java.util.Map<com.fasterxml.jackson.databind.PropertyName, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder> r13, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked r14) {
        /*
            r11 = this;
            r0 = r14
            r1 = r14
        L_0x0002:
            if (r1 == 0) goto L_0x00aa
            com.fasterxml.jackson.databind.PropertyName r8 = r1.name
            boolean r2 = r1.isNameExplicit
            if (r2 == 0) goto L_0x0079
            if (r8 != 0) goto L_0x000e
            goto L_0x0079
        L_0x000e:
            java.lang.Object r2 = r13.get(r8)
            r9 = r2
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r9 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder) r9
            if (r9 != 0) goto L_0x002a
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r10 = new com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r3 = r11._config
            com.fasterxml.jackson.databind.AnnotationIntrospector r4 = r11._annotationIntrospector
            boolean r5 = r11._forSerialization
            com.fasterxml.jackson.databind.PropertyName r6 = r11._internalName
            r2 = r10
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r9 = r10
            r13.put(r8, r9)
        L_0x002a:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedField> r2 = r11._fields
            if (r0 != r2) goto L_0x0038
            r2 = r1
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedField> r3 = r9._fields
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r3 = r2.withNext(r3)
            r9._fields = r3
            goto L_0x007e
        L_0x0038:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r2 = r11._getters
            if (r0 != r2) goto L_0x0046
            r2 = r1
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r3 = r9._getters
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r3 = r2.withNext(r3)
            r9._getters = r3
            goto L_0x007e
        L_0x0046:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r2 = r11._setters
            if (r0 != r2) goto L_0x0054
            r2 = r1
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r3 = r9._setters
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r3 = r2.withNext(r3)
            r9._setters = r3
            goto L_0x007e
        L_0x0054:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedParameter> r2 = r11._ctorParameters
            if (r0 != r2) goto L_0x0062
            r2 = r1
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedParameter> r3 = r9._ctorParameters
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r3 = r2.withNext(r3)
            r9._ctorParameters = r3
            goto L_0x007e
        L_0x0062:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Internal error: mismatched accessors, property: "
            r3.append(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0079:
            boolean r2 = r1.isVisible
            if (r2 != 0) goto L_0x0081
        L_0x007e:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<T> r1 = r1.next
            goto L_0x0002
        L_0x0081:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Conflicting/ambiguous property name definitions (implicit name '"
            r3.append(r4)
            com.fasterxml.jackson.databind.PropertyName r4 = r11._name
            r3.append(r4)
            java.lang.String r4 = "'): found multiple explicit names: "
            r3.append(r4)
            r3.append(r12)
            java.lang.String r4 = ", but also implicit accessor: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder._explode(java.util.Collection, java.util.Map, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked):void");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<? extends com.fasterxml.jackson.databind.introspect.AnnotatedMember>, code=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked, for r2v0, types: [com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<? extends com.fasterxml.jackson.databind.introspect.AnnotatedMember>, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<com.fasterxml.jackson.databind.PropertyName> _findExplicitNames(com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked r2, java.util.Set<com.fasterxml.jackson.databind.PropertyName> r3) {
        /*
            r1 = this;
        L_0x0000:
            if (r2 == 0) goto L_0x001b
            boolean r0 = r2.isNameExplicit
            if (r0 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.PropertyName r0 = r2.name
            if (r0 != 0) goto L_0x000b
            goto L_0x0018
        L_0x000b:
            if (r3 != 0) goto L_0x0013
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3 = r0
        L_0x0013:
            com.fasterxml.jackson.databind.PropertyName r0 = r2.name
            r3.add(r0)
        L_0x0018:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<T> r2 = r2.next
            goto L_0x0000
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder._findExplicitNames(com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked, java.util.Set):java.util.Set");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Property '");
        sb.append(this._name);
        sb.append("'; ctors: ");
        sb.append(this._ctorParameters);
        sb.append(", field(s): ");
        sb.append(this._fields);
        sb.append(", getter(s): ");
        sb.append(this._getters);
        sb.append(", setter(s): ");
        sb.append(this._setters);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public <T> T fromMemberAnnotations(WithMember<T> func) {
        T result = null;
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (this._forSerialization) {
            Linked<AnnotatedMethod> linked = this._getters;
            if (linked != null) {
                result = func.withMember((AnnotatedMember) linked.value);
            }
        } else {
            Linked<AnnotatedParameter> linked2 = this._ctorParameters;
            if (linked2 != null) {
                result = func.withMember((AnnotatedMember) linked2.value);
            }
            if (result == null) {
                Linked<AnnotatedMethod> linked3 = this._setters;
                if (linked3 != null) {
                    result = func.withMember((AnnotatedMember) linked3.value);
                }
            }
        }
        if (result != null) {
            return result;
        }
        Linked<AnnotatedField> linked4 = this._fields;
        if (linked4 != null) {
            return func.withMember((AnnotatedMember) linked4.value);
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public <T> T fromMemberAnnotationsExcept(WithMember<T> func, T defaultValue) {
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (this._forSerialization) {
            Linked<AnnotatedMethod> linked = this._getters;
            if (linked != null) {
                T result = func.withMember((AnnotatedMember) linked.value);
                if (!(result == null || result == defaultValue)) {
                    return result;
                }
            }
            T result2 = this._fields;
            if (result2 != null) {
                T result3 = func.withMember((AnnotatedMember) result2.value);
                if (!(result3 == null || result3 == defaultValue)) {
                    return result3;
                }
            }
            T result4 = this._ctorParameters;
            if (result4 != null) {
                T result5 = func.withMember((AnnotatedMember) result4.value);
                if (!(result5 == null || result5 == defaultValue)) {
                    return result5;
                }
            }
            T result6 = this._setters;
            if (result6 != null) {
                T result7 = func.withMember((AnnotatedMember) result6.value);
                if (result7 == null || result7 == defaultValue) {
                    return null;
                }
                return result7;
            }
            return null;
        }
        Linked<AnnotatedParameter> linked2 = this._ctorParameters;
        if (linked2 != null) {
            T result8 = func.withMember((AnnotatedMember) linked2.value);
            if (!(result8 == null || result8 == defaultValue)) {
                return result8;
            }
        }
        T result9 = this._setters;
        if (result9 != null) {
            T result10 = func.withMember((AnnotatedMember) result9.value);
            if (!(result10 == null || result10 == defaultValue)) {
                return result10;
            }
        }
        T result11 = this._fields;
        if (result11 != null) {
            T result12 = func.withMember((AnnotatedMember) result11.value);
            if (!(result12 == null || result12 == defaultValue)) {
                return result12;
            }
        }
        T result13 = this._getters;
        if (result13 != null) {
            T result14 = func.withMember((AnnotatedMember) result13.value);
            if (result14 == null || result14 == defaultValue) {
                return null;
            }
            return result14;
        }
        return null;
    }
}
