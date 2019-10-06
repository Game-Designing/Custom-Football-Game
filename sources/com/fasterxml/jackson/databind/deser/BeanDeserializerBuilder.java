package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.Annotations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BeanDeserializerBuilder {
    protected SettableAnyProperty _anySetter;
    protected HashMap<String, SettableBeanProperty> _backRefProperties;
    protected final BeanDescription _beanDesc;
    protected AnnotatedMethod _buildMethod;
    protected Value _builderConfig;
    protected final DeserializationConfig _config;
    protected final DeserializationContext _context;
    protected HashSet<String> _ignorableProps;
    protected boolean _ignoreAllUnknown;
    protected List<ValueInjector> _injectables;
    protected ObjectIdReader _objectIdReader;
    protected final Map<String, SettableBeanProperty> _properties = new LinkedHashMap();
    protected ValueInstantiator _valueInstantiator;

    public BeanDeserializerBuilder(BeanDescription beanDesc, DeserializationContext ctxt) {
        this._beanDesc = beanDesc;
        this._context = ctxt;
        this._config = ctxt.getConfig();
    }

    public void addOrReplaceProperty(SettableBeanProperty prop, boolean allowOverride) {
        this._properties.put(prop.getName(), prop);
    }

    public void addProperty(SettableBeanProperty prop) {
        SettableBeanProperty old = (SettableBeanProperty) this._properties.put(prop.getName(), prop);
        if (old != null && old != prop) {
            StringBuilder sb = new StringBuilder();
            sb.append("Duplicate property '");
            sb.append(prop.getName());
            sb.append("' for ");
            sb.append(this._beanDesc.getType());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void addBackReferenceProperty(String referenceName, SettableBeanProperty prop) {
        if (this._backRefProperties == null) {
            this._backRefProperties = new HashMap<>(4);
        }
        prop.fixAccess(this._config);
        this._backRefProperties.put(referenceName, prop);
    }

    public void addInjectable(PropertyName propName, JavaType propType, Annotations contextAnnotations, AnnotatedMember member, Object valueId) {
        if (this._injectables == null) {
            this._injectables = new ArrayList();
        }
        boolean fixAccess = this._config.canOverrideAccessModifiers();
        boolean forceAccess = fixAccess && this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
        if (fixAccess) {
            member.fixAccess(forceAccess);
        }
        this._injectables.add(new ValueInjector(propName, propType, member, valueId));
    }

    public void addIgnorable(String propName) {
        if (this._ignorableProps == null) {
            this._ignorableProps = new HashSet<>();
        }
        this._ignorableProps.add(propName);
    }

    public void addCreatorProperty(SettableBeanProperty prop) {
        addProperty(prop);
    }

    public void setAnySetter(SettableAnyProperty s) {
        if (this._anySetter == null || s == null) {
            this._anySetter = s;
            return;
        }
        throw new IllegalStateException("_anySetter already set to non-null");
    }

    public void setIgnoreUnknownProperties(boolean ignore) {
        this._ignoreAllUnknown = ignore;
    }

    public void setValueInstantiator(ValueInstantiator inst) {
        this._valueInstantiator = inst;
    }

    public void setObjectIdReader(ObjectIdReader r) {
        this._objectIdReader = r;
    }

    public void setPOJOBuilder(AnnotatedMethod buildMethod, Value config) {
        this._buildMethod = buildMethod;
        this._builderConfig = config;
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return (SettableBeanProperty) this._properties.get(propertyName.getSimpleName());
    }

    public SettableAnyProperty getAnySetter() {
        return this._anySetter;
    }

    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public List<ValueInjector> getInjectables() {
        return this._injectables;
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public AnnotatedMethod getBuildMethod() {
        return this._buildMethod;
    }

    public boolean hasIgnorable(String name) {
        HashSet<String> hashSet = this._ignorableProps;
        return hashSet != null && hashSet.contains(name);
    }

    public JsonDeserializer<?> build() {
        Collection<SettableBeanProperty> props = this._properties.values();
        _fixAccess(props);
        BeanPropertyMap propertyMap = BeanPropertyMap.construct(props, this._config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES), _collectAliases(props));
        propertyMap.assignIndexes();
        boolean anyViews = !this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        if (!anyViews) {
            Iterator i$ = props.iterator();
            while (true) {
                if (i$.hasNext()) {
                    if (((SettableBeanProperty) i$.next()).hasViews()) {
                        anyViews = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null) {
            propertyMap = propertyMap.withProperty(new ObjectIdValueProperty(objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        BeanDeserializer beanDeserializer = new BeanDeserializer(this, this._beanDesc, propertyMap, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, anyViews);
        return beanDeserializer;
    }

    public AbstractDeserializer buildAbstract() {
        return new AbstractDeserializer(this, this._beanDesc, this._backRefProperties, this._properties);
    }

    public JsonDeserializer<?> buildBuilderBased(JavaType valueType, String expBuildMethodName) throws JsonMappingException {
        boolean anyViews;
        BeanPropertyMap propertyMap;
        AnnotatedMethod annotatedMethod = this._buildMethod;
        boolean z = true;
        if (annotatedMethod != null) {
            Class<?> rawBuildType = annotatedMethod.getRawReturnType();
            Class<?> rawValueType = valueType.getRawClass();
            if (rawBuildType != rawValueType && !rawBuildType.isAssignableFrom(rawValueType) && !rawValueType.isAssignableFrom(rawBuildType)) {
                this._context.reportBadDefinition(this._beanDesc.getType(), String.format("Build method '%s' has wrong return type (%s), not compatible with POJO type (%s)", new Object[]{this._buildMethod.getFullName(), rawBuildType.getName(), valueType.getRawClass().getName()}));
                throw null;
            }
        } else if (!expBuildMethodName.isEmpty()) {
            this._context.reportBadDefinition(this._beanDesc.getType(), String.format("Builder class %s does not have build method (name: '%s')", new Object[]{this._beanDesc.getBeanClass().getName(), expBuildMethodName}));
            throw null;
        }
        Collection<SettableBeanProperty> props = this._properties.values();
        _fixAccess(props);
        BeanPropertyMap propertyMap2 = BeanPropertyMap.construct(props, this._config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES), _collectAliases(props));
        propertyMap2.assignIndexes();
        if (this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
            z = false;
        }
        boolean anyViews2 = z;
        if (!anyViews2) {
            Iterator i$ = props.iterator();
            while (true) {
                if (i$.hasNext()) {
                    if (((SettableBeanProperty) i$.next()).hasViews()) {
                        anyViews = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        anyViews = anyViews2;
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null) {
            propertyMap = propertyMap2.withProperty(new ObjectIdValueProperty(objectIdReader, PropertyMetadata.STD_REQUIRED));
        } else {
            propertyMap = propertyMap2;
        }
        BuilderBasedDeserializer builderBasedDeserializer = new BuilderBasedDeserializer(this, this._beanDesc, valueType, propertyMap, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, anyViews);
        return builderBasedDeserializer;
    }

    /* access modifiers changed from: protected */
    public void _fixAccess(Collection<SettableBeanProperty> mainProps) {
        for (SettableBeanProperty prop : mainProps) {
            prop.fixAccess(this._config);
        }
        SettableAnyProperty settableAnyProperty = this._anySetter;
        if (settableAnyProperty != null) {
            settableAnyProperty.fixAccess(this._config);
        }
        AnnotatedMethod annotatedMethod = this._buildMethod;
        if (annotatedMethod != null) {
            annotatedMethod.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, List<PropertyName>> _collectAliases(Collection<SettableBeanProperty> props) {
        Map<String, List<PropertyName>> mapping = null;
        AnnotationIntrospector intr = this._config.getAnnotationIntrospector();
        if (intr != null) {
            for (SettableBeanProperty prop : props) {
                List<PropertyName> aliases = intr.findPropertyAliases(prop.getMember());
                if (aliases != null && !aliases.isEmpty()) {
                    if (mapping == null) {
                        mapping = new HashMap<>();
                    }
                    mapping.put(prop.getName(), aliases);
                }
            }
        }
        if (mapping == null) {
            return Collections.emptyMap();
        }
        return mapping;
    }
}
