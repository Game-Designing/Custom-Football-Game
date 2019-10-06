package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class POJOPropertiesCollector {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected LinkedList<AnnotatedMember> _anyGetters;
    protected LinkedList<AnnotatedMember> _anySetterField;
    protected LinkedList<AnnotatedMethod> _anySetters;
    protected final AnnotatedClass _classDef;
    protected boolean _collected;
    protected final MapperConfig<?> _config;
    protected LinkedList<POJOPropertyBuilder> _creatorProperties;
    protected final boolean _forSerialization;
    protected HashSet<String> _ignoredPropertyNames;
    protected LinkedHashMap<Object, AnnotatedMember> _injectables;
    protected LinkedList<AnnotatedMember> _jsonValueAccessors;
    protected final String _mutatorPrefix;
    protected LinkedHashMap<String, POJOPropertyBuilder> _properties;
    protected final boolean _stdBeanNaming;
    protected final JavaType _type;
    protected final boolean _useAnnotations;
    protected final VisibilityChecker<?> _visibilityChecker;

    protected POJOPropertiesCollector(MapperConfig<?> config, boolean forSerialization, JavaType type, AnnotatedClass classDef, String mutatorPrefix) {
        this._config = config;
        this._stdBeanNaming = config.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this._forSerialization = forSerialization;
        this._type = type;
        this._classDef = classDef;
        this._mutatorPrefix = mutatorPrefix == null ? "set" : mutatorPrefix;
        if (config.isAnnotationProcessingEnabled()) {
            this._useAnnotations = true;
            this._annotationIntrospector = this._config.getAnnotationIntrospector();
        } else {
            this._useAnnotations = false;
            this._annotationIntrospector = AnnotationIntrospector.nopInstance();
        }
        this._visibilityChecker = this._config.getDefaultVisibilityChecker(type.getRawClass(), classDef);
    }

    public MapperConfig<?> getConfig() {
        return this._config;
    }

    public JavaType getType() {
        return this._type;
    }

    public AnnotatedClass getClassDef() {
        return this._classDef;
    }

    public List<BeanPropertyDefinition> getProperties() {
        return new ArrayList(getPropertyMap().values());
    }

    public Map<Object, AnnotatedMember> getInjectables() {
        if (!this._collected) {
            collectAll();
        }
        return this._injectables;
    }

    public AnnotatedMember getJsonValueAccessor() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._jsonValueAccessors;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return (AnnotatedMember) this._jsonValueAccessors.get(0);
        }
        reportProblem("Multiple 'as-value' properties defined (%s vs %s)", this._jsonValueAccessors.get(0), this._jsonValueAccessors.get(1));
        throw null;
    }

    public AnnotatedMember getAnyGetter() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._anyGetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return (AnnotatedMember) this._anyGetters.getFirst();
        }
        reportProblem("Multiple 'any-getters' defined (%s vs %s)", this._anyGetters.get(0), this._anyGetters.get(1));
        throw null;
    }

    public AnnotatedMember getAnySetterField() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._anySetterField;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return (AnnotatedMember) this._anySetterField.getFirst();
        }
        reportProblem("Multiple 'any-setter' fields defined (%s vs %s)", this._anySetterField.get(0), this._anySetterField.get(1));
        throw null;
    }

    public AnnotatedMethod getAnySetterMethod() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMethod> linkedList = this._anySetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return (AnnotatedMethod) this._anySetters.getFirst();
        }
        reportProblem("Multiple 'any-setter' methods defined (%s vs %s)", this._anySetters.get(0), this._anySetters.get(1));
        throw null;
    }

    public Set<String> getIgnoredPropertyNames() {
        return this._ignoredPropertyNames;
    }

    public ObjectIdInfo getObjectIdInfo() {
        ObjectIdInfo info = this._annotationIntrospector.findObjectIdInfo(this._classDef);
        if (info != null) {
            return this._annotationIntrospector.findObjectReferenceInfo(this._classDef, info);
        }
        return info;
    }

    /* access modifiers changed from: protected */
    public Map<String, POJOPropertyBuilder> getPropertyMap() {
        if (!this._collected) {
            collectAll();
        }
        return this._properties;
    }

    /* access modifiers changed from: protected */
    public void collectAll() {
        LinkedHashMap<String, POJOPropertyBuilder> props = new LinkedHashMap<>();
        _addFields(props);
        _addMethods(props);
        if (!this._classDef.isNonStaticInnerClass()) {
            _addCreators(props);
        }
        _addInjectables(props);
        _removeUnwantedProperties(props);
        _removeUnwantedAccessor(props);
        _renameProperties(props);
        for (POJOPropertyBuilder property : props.values()) {
            property.mergeAnnotations(this._forSerialization);
        }
        PropertyNamingStrategy naming = _findNamingStrategy();
        if (naming != null) {
            _renameUsing(props, naming);
        }
        for (POJOPropertyBuilder property2 : props.values()) {
            property2.trimByVisibility();
        }
        if (this._config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            _renameWithWrappers(props);
        }
        _sortProperties(props);
        this._properties = props;
        this._collected = true;
    }

    /* access modifiers changed from: protected */
    public void _addFields(Map<String, POJOPropertyBuilder> props) {
        String implName;
        PropertyName pn;
        boolean nameExplicit;
        PropertyName pn2;
        boolean visible;
        boolean ignored;
        AnnotationIntrospector ai = this._annotationIntrospector;
        boolean pruneFinalFields = !this._forSerialization && !this._config.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
        boolean transientAsIgnoral = this._config.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField f : this._classDef.fields()) {
            String implName2 = ai.findImplicitPropertyName(f);
            if (Boolean.TRUE.equals(ai.hasAsValue(f))) {
                if (this._jsonValueAccessors == null) {
                    this._jsonValueAccessors = new LinkedList<>();
                }
                this._jsonValueAccessors.add(f);
            } else if (Boolean.TRUE.equals(ai.hasAnySetter(f))) {
                if (this._anySetterField == null) {
                    this._anySetterField = new LinkedList<>();
                }
                this._anySetterField.add(f);
            } else {
                if (implName2 == null) {
                    implName = f.getName();
                } else {
                    implName = implName2;
                }
                if (this._forSerialization) {
                    pn = ai.findNameForSerialization(f);
                } else {
                    pn = ai.findNameForDeserialization(f);
                }
                boolean nameExplicit2 = pn != null;
                boolean hasName = nameExplicit2;
                if (!nameExplicit2 || !pn.isEmpty()) {
                    pn2 = pn;
                    nameExplicit = nameExplicit2;
                } else {
                    pn2 = _propNameFromSimple(implName);
                    nameExplicit = false;
                }
                boolean visible2 = pn2 != null;
                if (!visible2) {
                    visible2 = this._visibilityChecker.isFieldVisible(f);
                }
                boolean ignored2 = ai.hasIgnoreMarker(f);
                if (!f.isTransient() || hasName) {
                    visible = visible2;
                    ignored = ignored2;
                } else if (transientAsIgnoral) {
                    visible = false;
                    ignored = true;
                } else {
                    visible = false;
                    ignored = ignored2;
                }
                if (!pruneFinalFields || pn2 != null || ignored || !Modifier.isFinal(f.getModifiers())) {
                    _property(props, implName).addField(f, pn2, nameExplicit, visible, ignored);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addCreators(Map<String, POJOPropertyBuilder> props) {
        if (this._useAnnotations) {
            for (AnnotatedConstructor ctor : this._classDef.getConstructors()) {
                if (this._creatorProperties == null) {
                    this._creatorProperties = new LinkedList<>();
                }
                int len = ctor.getParameterCount();
                for (int i = 0; i < len; i++) {
                    _addCreatorParam(props, ctor.getParameter(i));
                }
            }
            for (AnnotatedMethod factory : this._classDef.getFactoryMethods()) {
                if (this._creatorProperties == null) {
                    this._creatorProperties = new LinkedList<>();
                }
                int len2 = factory.getParameterCount();
                for (int i2 = 0; i2 < len2; i2++) {
                    _addCreatorParam(props, factory.getParameter(i2));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addCreatorParam(Map<String, POJOPropertyBuilder> props, AnnotatedParameter param) {
        String impl = this._annotationIntrospector.findImplicitPropertyName(param);
        if (impl == null) {
            impl = "";
        }
        PropertyName pn = this._annotationIntrospector.findNameForDeserialization(param);
        boolean expl = pn != null && !pn.isEmpty();
        if (!expl) {
            if (!impl.isEmpty()) {
                Mode creatorMode = this._annotationIntrospector.findCreatorAnnotation(this._config, param.getOwner());
                if (creatorMode != null && creatorMode != Mode.DISABLED) {
                    pn = PropertyName.construct(impl);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        POJOPropertyBuilder _property = (!expl || !impl.isEmpty()) ? _property(props, impl) : _property(props, pn);
        POJOPropertyBuilder prop = _property;
        _property.addCtor(param, pn, expl, true, false);
        this._creatorProperties.add(prop);
    }

    /* access modifiers changed from: protected */
    public void _addMethods(Map<String, POJOPropertyBuilder> props) {
        AnnotationIntrospector ai = this._annotationIntrospector;
        for (AnnotatedMethod m : this._classDef.memberMethods()) {
            int argCount = m.getParameterCount();
            if (argCount == 0) {
                _addGetterMethod(props, m, ai);
            } else if (argCount == 1) {
                _addSetterMethod(props, m, ai);
            } else if (argCount == 2 && ai != null && Boolean.TRUE.equals(ai.hasAnySetter(m))) {
                if (this._anySetters == null) {
                    this._anySetters = new LinkedList<>();
                }
                this._anySetters.add(m);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addGetterMethod(Map<String, POJOPropertyBuilder> props, AnnotatedMethod m, AnnotationIntrospector ai) {
        boolean visible;
        String implName;
        if (m.hasReturnType()) {
            if (Boolean.TRUE.equals(ai.hasAnyGetter(m))) {
                if (this._anyGetters == null) {
                    this._anyGetters = new LinkedList<>();
                }
                this._anyGetters.add(m);
            } else if (Boolean.TRUE.equals(ai.hasAsValue(m))) {
                if (this._jsonValueAccessors == null) {
                    this._jsonValueAccessors = new LinkedList<>();
                }
                this._jsonValueAccessors.add(m);
            } else {
                PropertyName pn = ai.findNameForSerialization(m);
                boolean nameExplicit = pn != null;
                if (!nameExplicit) {
                    implName = ai.findImplicitPropertyName(m);
                    if (implName == null) {
                        implName = BeanUtil.okNameForRegularGetter(m, m.getName(), this._stdBeanNaming);
                    }
                    if (implName == null) {
                        implName = BeanUtil.okNameForIsGetter(m, m.getName(), this._stdBeanNaming);
                        if (implName != null) {
                            visible = this._visibilityChecker.isIsGetterVisible(m);
                        } else {
                            return;
                        }
                    } else {
                        visible = this._visibilityChecker.isGetterVisible(m);
                    }
                } else {
                    String implName2 = ai.findImplicitPropertyName(m);
                    if (implName2 == null) {
                        implName2 = BeanUtil.okNameForGetter(m, this._stdBeanNaming);
                    }
                    if (implName2 == null) {
                        implName2 = m.getName();
                    }
                    if (pn.isEmpty()) {
                        pn = _propNameFromSimple(implName);
                        nameExplicit = false;
                    }
                    visible = true;
                }
                _property(props, implName).addGetter(m, pn, nameExplicit, visible, ai.hasIgnoreMarker(m));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addSetterMethod(Map<String, POJOPropertyBuilder> props, AnnotatedMethod m, AnnotationIntrospector ai) {
        boolean visible;
        boolean nameExplicit;
        String implName = null;
        PropertyName pn = ai == null ? null : ai.findNameForDeserialization(m);
        boolean nameExplicit2 = pn != null;
        if (!nameExplicit2) {
            if (ai != null) {
                implName = ai.findImplicitPropertyName(m);
            }
            if (implName == null) {
                implName = BeanUtil.okNameForMutator(m, this._mutatorPrefix, this._stdBeanNaming);
            }
            if (implName != null) {
                nameExplicit = nameExplicit2;
                visible = this._visibilityChecker.isSetterVisible(m);
            } else {
                return;
            }
        } else {
            if (ai != null) {
                implName = ai.findImplicitPropertyName(m);
            }
            if (implName == null) {
                implName = BeanUtil.okNameForMutator(m, this._mutatorPrefix, this._stdBeanNaming);
            }
            if (implName == null) {
                implName = m.getName();
            }
            if (pn.isEmpty()) {
                pn = _propNameFromSimple(implName);
                nameExplicit2 = false;
            }
            nameExplicit = nameExplicit2;
            visible = true;
        }
        _property(props, implName).addSetter(m, pn, nameExplicit, visible, ai == null ? false : ai.hasIgnoreMarker(m));
    }

    /* access modifiers changed from: protected */
    public void _addInjectables(Map<String, POJOPropertyBuilder> map) {
        AnnotationIntrospector ai = this._annotationIntrospector;
        for (AnnotatedField f : this._classDef.fields()) {
            _doAddInjectable(ai.findInjectableValue(f), f);
        }
        for (AnnotatedMethod m : this._classDef.memberMethods()) {
            if (m.getParameterCount() == 1) {
                _doAddInjectable(ai.findInjectableValue(m), m);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _doAddInjectable(Value injectable, AnnotatedMember m) {
        if (injectable != null) {
            Object id = injectable.getId();
            if (this._injectables == null) {
                this._injectables = new LinkedHashMap<>();
            }
            AnnotatedMember prev = (AnnotatedMember) this._injectables.put(id, m);
            if (prev != null && prev.getClass() == m.getClass()) {
                String type = id.getClass().getName();
                StringBuilder sb = new StringBuilder();
                sb.append("Duplicate injectable value with id '");
                sb.append(String.valueOf(id));
                sb.append("' (of type ");
                sb.append(type);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    private PropertyName _propNameFromSimple(String simpleName) {
        return PropertyName.construct(simpleName, null);
    }

    /* access modifiers changed from: protected */
    public void _removeUnwantedProperties(Map<String, POJOPropertyBuilder> props) {
        Iterator<POJOPropertyBuilder> it = props.values().iterator();
        while (it.hasNext()) {
            POJOPropertyBuilder prop = (POJOPropertyBuilder) it.next();
            if (!prop.anyVisible()) {
                it.remove();
            } else if (prop.anyIgnorals()) {
                if (!prop.isExplicitlyIncluded()) {
                    it.remove();
                    _collectIgnorals(prop.getName());
                } else {
                    prop.removeIgnored();
                    if (!prop.couldDeserialize()) {
                        _collectIgnorals(prop.getName());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _removeUnwantedAccessor(Map<String, POJOPropertyBuilder> props) {
        boolean inferMutators = this._config.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder prop : props.values()) {
            if (prop.removeNonVisible(inferMutators) == Access.READ_ONLY) {
                _collectIgnorals(prop.getName());
            }
        }
    }

    private void _collectIgnorals(String name) {
        if (!this._forSerialization) {
            if (this._ignoredPropertyNames == null) {
                this._ignoredPropertyNames = new HashSet<>();
            }
            this._ignoredPropertyNames.add(name);
        }
    }

    /* access modifiers changed from: protected */
    public void _renameProperties(Map<String, POJOPropertyBuilder> props) {
        Iterator<Entry<String, POJOPropertyBuilder>> it = props.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder prop = (POJOPropertyBuilder) ((Entry) it.next()).getValue();
            Collection<PropertyName> l = prop.findExplicitNames();
            if (!l.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (l.size() == 1) {
                    linkedList.add(prop.withName((PropertyName) l.iterator().next()));
                } else {
                    linkedList.addAll(prop.explode(l));
                }
            }
        }
        if (linkedList != null) {
            Iterator i$ = linkedList.iterator();
            while (i$.hasNext()) {
                POJOPropertyBuilder prop2 = (POJOPropertyBuilder) i$.next();
                String name = prop2.getName();
                POJOPropertyBuilder old = (POJOPropertyBuilder) props.get(name);
                if (old == null) {
                    props.put(name, prop2);
                } else {
                    old.addAll(prop2);
                }
                _updateCreatorProperty(prop2, this._creatorProperties);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _renameUsing(Map<String, POJOPropertyBuilder> propMap, PropertyNamingStrategy naming) {
        POJOPropertyBuilder[] arr$;
        String simpleName;
        POJOPropertyBuilder[] props = (POJOPropertyBuilder[]) propMap.values().toArray(new POJOPropertyBuilder[propMap.size()]);
        propMap.clear();
        for (POJOPropertyBuilder prop : props) {
            PropertyName fullName = prop.getFullName();
            String rename = null;
            if (!prop.isExplicitlyNamed() || this._config.isEnabled(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                if (this._forSerialization) {
                    if (prop.hasGetter()) {
                        rename = naming.nameForGetterMethod(this._config, prop.getGetter(), fullName.getSimpleName());
                    } else if (prop.hasField()) {
                        rename = naming.nameForField(this._config, prop.getField(), fullName.getSimpleName());
                    }
                } else if (prop.hasSetter()) {
                    rename = naming.nameForSetterMethod(this._config, prop.getSetter(), fullName.getSimpleName());
                } else if (prop.hasConstructorParameter()) {
                    rename = naming.nameForConstructorParameter(this._config, prop.getConstructorParameter(), fullName.getSimpleName());
                } else if (prop.hasField()) {
                    rename = naming.nameForField(this._config, prop.getField(), fullName.getSimpleName());
                } else if (prop.hasGetter()) {
                    rename = naming.nameForGetterMethod(this._config, prop.getGetter(), fullName.getSimpleName());
                }
            }
            if (rename == null || fullName.hasSimpleName(rename)) {
                simpleName = fullName.getSimpleName();
            } else {
                prop = prop.withSimpleName(rename);
                simpleName = rename;
            }
            POJOPropertyBuilder old = (POJOPropertyBuilder) propMap.get(simpleName);
            if (old == null) {
                propMap.put(simpleName, prop);
            } else {
                old.addAll(prop);
            }
            _updateCreatorProperty(prop, this._creatorProperties);
        }
    }

    /* access modifiers changed from: protected */
    public void _renameWithWrappers(Map<String, POJOPropertyBuilder> props) {
        Iterator<Entry<String, POJOPropertyBuilder>> it = props.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder prop = (POJOPropertyBuilder) ((Entry) it.next()).getValue();
            AnnotatedMember member = prop.getPrimaryMember();
            if (member != null) {
                PropertyName wrapperName = this._annotationIntrospector.findWrapperName(member);
                if (wrapperName != null && wrapperName.hasSimpleName() && !wrapperName.equals(prop.getFullName())) {
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                    }
                    linkedList.add(prop.withName(wrapperName));
                    it.remove();
                }
            }
        }
        if (linkedList != null) {
            Iterator i$ = linkedList.iterator();
            while (i$.hasNext()) {
                POJOPropertyBuilder prop2 = (POJOPropertyBuilder) i$.next();
                String name = prop2.getName();
                POJOPropertyBuilder old = (POJOPropertyBuilder) props.get(name);
                if (old == null) {
                    props.put(name, prop2);
                } else {
                    old.addAll(prop2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _sortProperties(Map<String, POJOPropertyBuilder> props) {
        boolean sort;
        Map<String, POJOPropertyBuilder> all;
        Collection<POJOPropertyBuilder> cr;
        String[] arr$;
        AnnotationIntrospector intr = this._annotationIntrospector;
        Boolean alpha = intr.findSerializationSortAlphabetically(this._classDef);
        if (alpha == null) {
            sort = this._config.shouldSortPropertiesAlphabetically();
        } else {
            sort = alpha.booleanValue();
        }
        String[] propertyOrder = intr.findSerializationPropertyOrder(this._classDef);
        if (sort || this._creatorProperties != null || propertyOrder != null) {
            int size = props.size();
            if (sort) {
                all = new TreeMap<>();
            } else {
                all = new LinkedHashMap<>(size + size);
            }
            for (POJOPropertyBuilder prop : props.values()) {
                all.put(prop.getName(), prop);
            }
            Map<String, POJOPropertyBuilder> ordered = new LinkedHashMap<>(size + size);
            if (propertyOrder != null) {
                for (String name : propertyOrder) {
                    POJOPropertyBuilder w = (POJOPropertyBuilder) all.get(name);
                    if (w == null) {
                        Iterator i$ = props.values().iterator();
                        while (true) {
                            if (!i$.hasNext()) {
                                break;
                            }
                            POJOPropertyBuilder prop2 = (POJOPropertyBuilder) i$.next();
                            if (name.equals(prop2.getInternalName())) {
                                w = prop2;
                                name = prop2.getName();
                                break;
                            }
                        }
                    }
                    if (w != null) {
                        ordered.put(name, w);
                    }
                }
            }
            if (this._creatorProperties != null) {
                if (sort) {
                    TreeMap<String, POJOPropertyBuilder> sorted = new TreeMap<>();
                    Iterator i$2 = this._creatorProperties.iterator();
                    while (i$2.hasNext()) {
                        POJOPropertyBuilder prop3 = (POJOPropertyBuilder) i$2.next();
                        sorted.put(prop3.getName(), prop3);
                    }
                    cr = sorted.values();
                } else {
                    cr = this._creatorProperties;
                }
                for (POJOPropertyBuilder prop4 : cr) {
                    String name2 = prop4.getName();
                    if (all.containsKey(name2)) {
                        ordered.put(name2, prop4);
                    }
                }
            }
            ordered.putAll(all);
            props.clear();
            props.putAll(ordered);
        }
    }

    /* access modifiers changed from: protected */
    public void reportProblem(String msg, Object... args) {
        if (args.length > 0) {
            msg = String.format(msg, args);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Problem with definition of ");
        sb.append(this._classDef);
        sb.append(": ");
        sb.append(msg);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> props, PropertyName name) {
        String simpleName = name.getSimpleName();
        POJOPropertyBuilder prop = (POJOPropertyBuilder) props.get(simpleName);
        if (prop != null) {
            return prop;
        }
        POJOPropertyBuilder prop2 = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, name);
        props.put(simpleName, prop2);
        return prop2;
    }

    /* access modifiers changed from: protected */
    public POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> props, String implName) {
        POJOPropertyBuilder prop = (POJOPropertyBuilder) props.get(implName);
        if (prop != null) {
            return prop;
        }
        POJOPropertyBuilder prop2 = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, PropertyName.construct(implName));
        props.put(implName, prop2);
        return prop2;
    }

    private PropertyNamingStrategy _findNamingStrategy() {
        Object namingDef = this._annotationIntrospector.findNamingStrategy(this._classDef);
        if (namingDef == null) {
            return this._config.getPropertyNamingStrategy();
        }
        if (namingDef instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy) namingDef;
        }
        if (namingDef instanceof Class) {
            Class<?> namingClass = (Class) namingDef;
            if (namingClass == PropertyNamingStrategy.class) {
                return null;
            }
            if (PropertyNamingStrategy.class.isAssignableFrom(namingClass)) {
                HandlerInstantiator hi = this._config.getHandlerInstantiator();
                if (hi != null) {
                    PropertyNamingStrategy pns = hi.namingStrategyInstance(this._config, this._classDef, namingClass);
                    if (pns != null) {
                        return pns;
                    }
                }
                return (PropertyNamingStrategy) ClassUtil.createInstance(namingClass, this._config.canOverrideAccessModifiers());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AnnotationIntrospector returned Class ");
            sb.append(namingClass.getName());
            sb.append("; expected Class<PropertyNamingStrategy>");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AnnotationIntrospector returned PropertyNamingStrategy definition of type ");
        sb2.append(namingDef.getClass().getName());
        sb2.append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        throw new IllegalStateException(sb2.toString());
    }

    /* access modifiers changed from: protected */
    public void _updateCreatorProperty(POJOPropertyBuilder prop, List<POJOPropertyBuilder> creatorProperties) {
        if (creatorProperties != null) {
            int len = creatorProperties.size();
            for (int i = 0; i < len; i++) {
                if (((POJOPropertyBuilder) creatorProperties.get(i)).getInternalName().equals(prop.getInternalName())) {
                    creatorProperties.set(i, prop);
                    return;
                }
            }
        }
    }
}
