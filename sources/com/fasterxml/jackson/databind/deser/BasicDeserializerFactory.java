package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ConstantValueInstantiator;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    private static final Class<?> CLASS_CHAR_BUFFER = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Entry.class;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");
    static final HashMap<String, Class<? extends Collection>> _collectionFallbacks = new HashMap<>();
    static final HashMap<String, Class<? extends Map>> _mapFallbacks = new HashMap<>();
    protected final DeserializerFactoryConfig _factoryConfig;

    /* renamed from: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory$1 */
    static /* synthetic */ class C68181 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode = new int[Mode.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode[Mode.DELEGATING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode[Mode.PROPERTIES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode[Mode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static {
        _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
        _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(NavigableMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
        _collectionFallbacks.put(List.class.getName(), ArrayList.class);
        _collectionFallbacks.put(Set.class.getName(), HashSet.class);
        _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
        _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
        _collectionFallbacks.put("java.util.Deque", LinkedList.class);
        _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig config) {
        this._factoryConfig = config;
    }

    public JavaType mapAbstractType(DeserializationConfig config, JavaType type) throws JsonMappingException {
        JavaType next;
        while (true) {
            next = _mapAbstractType2(config, type);
            if (next == null) {
                return type;
            }
            Class<?> prevCls = type.getRawClass();
            Class<?> nextCls = next.getRawClass();
            if (prevCls == nextCls || !prevCls.isAssignableFrom(nextCls)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid abstract type resolution from ");
                sb.append(type);
                sb.append(" to ");
                sb.append(next);
                sb.append(": latter is not a subtype of former");
            } else {
                type = next;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid abstract type resolution from ");
        sb2.append(type);
        sb2.append(" to ");
        sb2.append(next);
        sb2.append(": latter is not a subtype of former");
        throw new IllegalArgumentException(sb2.toString());
    }

    private JavaType _mapAbstractType2(DeserializationConfig config, JavaType type) throws JsonMappingException {
        Class<?> currClass = type.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver resolver : this._factoryConfig.abstractTypeResolvers()) {
                JavaType concrete = resolver.findTypeMapping(config, type);
                if (ClassUtil.rawClass(concrete) != currClass) {
                    return concrete;
                }
            }
        }
        return null;
    }

    public ValueInstantiator findValueInstantiator(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        ValueInstantiator instantiator = null;
        AnnotatedClass ac = beanDesc.getClassInfo();
        Object instDef = ctxt.getAnnotationIntrospector().findValueInstantiator(ac);
        if (instDef != null) {
            instantiator = _valueInstantiatorInstance(config, ac, instDef);
        }
        if (instantiator == null) {
            instantiator = _findStdValueInstantiator(config, beanDesc);
            if (instantiator == null) {
                instantiator = _constructDefaultValueInstantiator(ctxt, beanDesc);
            }
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators insts : this._factoryConfig.valueInstantiators()) {
                instantiator = insts.findValueInstantiator(config, beanDesc, instantiator);
                if (instantiator == null) {
                    ctxt.reportBadTypeDefinition(beanDesc, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", insts.getClass().getName());
                    throw null;
                }
            }
        }
        if (instantiator.getIncompleteParameter() == null) {
            return instantiator;
        }
        AnnotatedParameter nonAnnotatedParam = instantiator.getIncompleteParameter();
        AnnotatedWithParams ctor = nonAnnotatedParam.getOwner();
        StringBuilder sb = new StringBuilder();
        sb.append("Argument #");
        sb.append(nonAnnotatedParam.getIndex());
        sb.append(" of constructor ");
        sb.append(ctor);
        sb.append(" has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
        throw new IllegalArgumentException(sb.toString());
    }

    private ValueInstantiator _findStdValueInstantiator(DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        Class<?> raw = beanDesc.getBeanClass();
        if (raw == JsonLocation.class) {
            return new JsonLocationInstantiator();
        }
        if (Collection.class.isAssignableFrom(raw)) {
            if (Collections.EMPTY_SET.getClass() == raw) {
                return new ConstantValueInstantiator(Collections.EMPTY_SET);
            }
            if (Collections.EMPTY_LIST.getClass() == raw) {
                return new ConstantValueInstantiator(Collections.EMPTY_LIST);
            }
        } else if (Map.class.isAssignableFrom(raw) && Collections.EMPTY_MAP.getClass() == raw) {
            return new ConstantValueInstantiator(Collections.EMPTY_MAP);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        CreatorCollector creators = new CreatorCollector(beanDesc, ctxt.getConfig());
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        DeserializationConfig config = ctxt.getConfig();
        VisibilityChecker<?> vchecker = config.getDefaultVisibilityChecker(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> creatorDefs = _findCreatorsFromProperties(ctxt, beanDesc);
        _addDeserializerFactoryMethods(ctxt, beanDesc, vchecker, intr, creators, creatorDefs);
        if (beanDesc.getType().isConcrete()) {
            _addDeserializerConstructors(ctxt, beanDesc, vchecker, intr, creators, creatorDefs);
        }
        return creators.constructValueInstantiator(config);
    }

    /* access modifiers changed from: protected */
    public Map<AnnotatedWithParams, BeanPropertyDefinition[]> _findCreatorsFromProperties(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> result = Collections.emptyMap();
        for (BeanPropertyDefinition propDef : beanDesc.findProperties()) {
            Iterator<AnnotatedParameter> it = propDef.getConstructorParameters();
            while (true) {
                if (it.hasNext()) {
                    AnnotatedParameter param = (AnnotatedParameter) it.next();
                    AnnotatedWithParams owner = param.getOwner();
                    BeanPropertyDefinition[] defs = (BeanPropertyDefinition[]) result.get(owner);
                    int index = param.getIndex();
                    if (defs == null) {
                        if (result.isEmpty()) {
                            result = new LinkedHashMap<>();
                        }
                        defs = new BeanPropertyDefinition[owner.getParameterCount()];
                        result.put(owner, defs);
                    } else if (defs[index] != null) {
                        ctxt.reportBadTypeDefinition(beanDesc, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", Integer.valueOf(index), owner, defs[index], propDef);
                        throw null;
                    }
                    defs[index] = propDef;
                }
            }
        }
        return result;
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig config, Annotated annotated, Object instDef) throws JsonMappingException {
        if (instDef == null) {
            return null;
        }
        if (instDef instanceof ValueInstantiator) {
            return (ValueInstantiator) instDef;
        }
        if (instDef instanceof Class) {
            Class<?> instClass = (Class) instDef;
            if (ClassUtil.isBogusClass(instClass)) {
                return null;
            }
            if (ValueInstantiator.class.isAssignableFrom(instClass)) {
                HandlerInstantiator hi = config.getHandlerInstantiator();
                if (hi != null) {
                    ValueInstantiator inst = hi.valueInstantiatorInstance(config, annotated, instClass);
                    if (inst != null) {
                        return inst;
                    }
                }
                return (ValueInstantiator) ClassUtil.createInstance(instClass, config.canOverrideAccessModifiers());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AnnotationIntrospector returned Class ");
            sb.append(instClass.getName());
            sb.append("; expected Class<ValueInstantiator>");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AnnotationIntrospector returned key deserializer definition of type ");
        sb2.append(instDef.getClass().getName());
        sb2.append("; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        throw new IllegalStateException(sb2.toString());
    }

    /* Debug info: failed to restart local var, previous not found, register: 35 */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r22v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r25v3 */
    /* JADX WARNING: type inference failed for: r3v7, types: [com.fasterxml.jackson.databind.PropertyName] */
    /* JADX WARNING: type inference failed for: r7v11, types: [com.fasterxml.jackson.databind.PropertyName] */
    /* JADX WARNING: type inference failed for: r25v10, types: [com.fasterxml.jackson.databind.PropertyName] */
    /* JADX WARNING: type inference failed for: r25v11 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r25v16 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r22v7 */
    /* JADX WARNING: type inference failed for: r22v8 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v3
      assigns: []
      uses: []
      mth insns count: 291
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _addDeserializerConstructors(com.fasterxml.jackson.databind.DeserializationContext r36, com.fasterxml.jackson.databind.BeanDescription r37, com.fasterxml.jackson.databind.introspect.VisibilityChecker<?> r38, com.fasterxml.jackson.databind.AnnotationIntrospector r39, com.fasterxml.jackson.databind.deser.impl.CreatorCollector r40, java.util.Map<com.fasterxml.jackson.databind.introspect.AnnotatedWithParams, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]> r41) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r35 = this;
            r11 = r35
            r12 = r36
            r13 = r37
            r14 = r38
            r15 = r39
            r10 = r40
            r9 = r41
            boolean r16 = r37.isNonStaticInnerClass()
            if (r16 == 0) goto L_0x0015
            return
        L_0x0015:
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r8 = r37.findDefaultConstructor()
            if (r8 == 0) goto L_0x002a
            boolean r0 = r40.hasDefaultCreator()
            if (r0 == 0) goto L_0x0027
            boolean r0 = r11._hasCreatorAnnotation(r12, r8)
            if (r0 == 0) goto L_0x002a
        L_0x0027:
            r10.setDefaultCreator(r8)
        L_0x002a:
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r7 = r0
            r0 = 0
            java.util.List r1 = r37.getConstructors()
            java.util.Iterator r1 = r1.iterator()
            r17 = r0
        L_0x003b:
            boolean r0 = r1.hasNext()
            r6 = 2
            r5 = 0
            r4 = 1
            if (r0 == 0) goto L_0x00a1
            java.lang.Object r0 = r1.next()
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedConstructor) r0
            com.fasterxml.jackson.databind.DeserializationConfig r2 = r36.getConfig()
            com.fasterxml.jackson.annotation.JsonCreator$Mode r2 = r15.findCreatorAnnotation(r2, r0)
            com.fasterxml.jackson.annotation.JsonCreator$Mode r3 = com.fasterxml.jackson.annotation.JsonCreator.Mode.DISABLED
            if (r3 != r2) goto L_0x0057
            goto L_0x003b
        L_0x0057:
            if (r2 != 0) goto L_0x006d
            boolean r3 = r14.isCreatorVisible(r0)
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r9.get(r0)
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r3 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]) r3
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r3 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r3)
            r7.add(r3)
            goto L_0x003b
        L_0x006d:
            int[] r3 = com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.C68181.$SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode
            int r18 = r2.ordinal()
            r3 = r3[r18]
            if (r3 == r4) goto L_0x0095
            if (r3 == r6) goto L_0x0087
            java.lang.Object r3 = r9.get(r0)
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r3 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]) r3
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r3 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r3)
            r11._addExplicitAnyCreator(r12, r13, r10, r3)
            goto L_0x009d
        L_0x0087:
            java.lang.Object r3 = r9.get(r0)
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r3 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]) r3
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r3 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r3)
            r11._addExplicitPropertyCreator(r12, r13, r10, r3)
            goto L_0x009d
        L_0x0095:
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r3 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r5)
            r11._addExplicitDelegatingCreator(r12, r13, r10, r3)
        L_0x009d:
            int r17 = r17 + 1
            goto L_0x003b
        L_0x00a1:
            if (r17 <= 0) goto L_0x00a4
            return
        L_0x00a4:
            r0 = 0
            java.util.Iterator r18 = r7.iterator()
            r19 = r0
        L_0x00ab:
            boolean r0 = r18.hasNext()
            if (r0 == 0) goto L_0x0284
            java.lang.Object r0 = r18.next()
            r3 = r0
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r3 = (com.fasterxml.jackson.databind.deser.impl.CreatorCandidate) r3
            int r2 = r3.paramCount()
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r1 = r3.creator()
            r0 = 0
            if (r2 != r4) goto L_0x0141
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r4 = r3.propertyDef(r0)
            boolean r21 = r11._checkIfCreatorPropertyBased(r15, r1, r4)
            if (r21 == 0) goto L_0x0112
            r20 = r4
            r5 = 1
            com.fasterxml.jackson.databind.deser.SettableBeanProperty[] r4 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[r5]
            com.fasterxml.jackson.databind.PropertyName r23 = r3.paramName(r0)
            r24 = 0
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter r25 = r3.parameter(r0)
            com.fasterxml.jackson.annotation.JacksonInject$Value r26 = r3.injection(r0)
            r0 = r35
            r28 = r1
            r1 = r36
            r29 = r2
            r2 = r37
            r12 = r3
            r3 = r23
            r5 = r4
            r30 = 1
            r4 = r24
            r31 = r5
            r22 = 0
            r5 = r25
            r6 = r26
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r0 = r0.constructCreatorProperty(r1, r2, r3, r4, r5, r6)
            r1 = r31
            r6 = 0
            r1[r6] = r0
            r5 = r28
            r10.addPropertyCreator(r5, r6, r1)
            r25 = r7
            r28 = r8
            r2 = r10
            r7 = r11
            r8 = r36
            goto L_0x0230
        L_0x0112:
            r29 = r2
            r12 = r3
            r20 = r4
            r22 = r5
            r6 = 0
            r30 = 1
            r5 = r1
            boolean r0 = r14.isCreatorVisible(r5)
            r11._handleSingleArgumentCreator(r10, r5, r6, r0)
            if (r20 == 0) goto L_0x0137
            r0 = r20
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r0 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder) r0
            r0.removeConstructors()
            r25 = r7
            r28 = r8
            r2 = r10
            r7 = r11
            r8 = r36
            goto L_0x0230
        L_0x0137:
            r25 = r7
            r28 = r8
            r2 = r10
            r7 = r11
            r8 = r36
            goto L_0x0230
        L_0x0141:
            r29 = r2
            r12 = r3
            r22 = r5
            r6 = 0
            r30 = 1
            r5 = r1
            r0 = -1
            r4 = r29
            com.fasterxml.jackson.databind.deser.SettableBeanProperty[] r2 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[r4]
            r1 = 0
            r20 = 0
            r3 = 0
            r21 = 0
            r34 = r3
            r3 = r0
            r0 = r1
            r1 = r21
            r21 = r34
        L_0x015d:
            if (r1 >= r4) goto L_0x01f9
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter r14 = r5.getParameter(r1)
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r23 = r12.propertyDef(r1)
            com.fasterxml.jackson.annotation.JacksonInject$Value r24 = r15.findInjectableValue(r14)
            if (r23 != 0) goto L_0x0170
            r25 = r22
            goto L_0x0174
        L_0x0170:
            com.fasterxml.jackson.databind.PropertyName r25 = r23.getFullName()
        L_0x0174:
            r26 = r12
            r12 = r3
            r3 = r25
            if (r23 == 0) goto L_0x01a4
            boolean r25 = r23.isExplicitlyNamed()
            if (r25 == 0) goto L_0x01a4
            int r25 = r0 + 1
            r0 = r35
            r27 = r1
            r1 = r36
            r11 = r2
            r2 = r37
            r32 = r4
            r4 = r27
            r33 = r5
            r5 = r14
            r6 = r24
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r0 = r0.constructCreatorProperty(r1, r2, r3, r4, r5, r6)
            r11[r27] = r0
            r28 = r8
            r2 = r10
            r3 = r12
            r0 = r25
            r25 = r7
            goto L_0x01da
        L_0x01a4:
            r27 = r1
            r11 = r2
            r32 = r4
            r33 = r5
            if (r24 == 0) goto L_0x01c8
            int r21 = r21 + 1
            r4 = r35
            r5 = r36
            r6 = r37
            r25 = r7
            r7 = r3
            r28 = r8
            r8 = r27
            r9 = r14
            r2 = r10
            r10 = r24
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r1 = r4.constructCreatorProperty(r5, r6, r7, r8, r9, r10)
            r11[r27] = r1
            r3 = r12
            goto L_0x01da
        L_0x01c8:
            r25 = r7
            r28 = r8
            r2 = r10
            com.fasterxml.jackson.databind.util.NameTransformer r1 = r15.findUnwrappingNameTransformer(r14)
            if (r1 != 0) goto L_0x01f1
            if (r12 >= 0) goto L_0x01d9
            r4 = r27
            r3 = r4
            goto L_0x01da
        L_0x01d9:
            r3 = r12
        L_0x01da:
            int r1 = r27 + 1
            r14 = r38
            r9 = r41
            r10 = r2
            r2 = r11
            r7 = r25
            r12 = r26
            r8 = r28
            r4 = r32
            r5 = r33
            r6 = 0
            r11 = r35
            goto L_0x015d
        L_0x01f1:
            r7 = r35
            r8 = r36
            r7._reportUnwrappedCreatorProperty(r8, r13, r14)
            throw r22
        L_0x01f9:
            r27 = r1
            r32 = r4
            r33 = r5
            r25 = r7
            r28 = r8
            r7 = r11
            r1 = r12
            r8 = r36
            r12 = r3
            r3 = r2
            r2 = r10
            int r4 = r0 + r20
            if (r0 > 0) goto L_0x0216
            if (r21 <= 0) goto L_0x0211
            goto L_0x0216
        L_0x0211:
            r6 = r32
            r5 = r33
            goto L_0x024d
        L_0x0216:
            int r5 = r4 + r21
            r6 = r32
            if (r5 != r6) goto L_0x0223
            r5 = r33
            r9 = 0
            r2.addPropertyCreator(r5, r9, r3)
            goto L_0x0230
        L_0x0223:
            r5 = r33
            r9 = 0
            if (r0 != 0) goto L_0x0241
            int r10 = r21 + 1
            if (r10 != r6) goto L_0x0241
            r2.addDelegatingCreator(r5, r9, r3, r9)
        L_0x0230:
            r14 = r38
            r9 = r41
            r10 = r2
            r11 = r7
            r12 = r8
            r5 = r22
            r7 = r25
            r8 = r28
            r4 = 1
            r6 = 2
            goto L_0x00ab
        L_0x0241:
            com.fasterxml.jackson.databind.PropertyName r10 = r1.findImplicitParamName(r12)
            if (r10 == 0) goto L_0x0273
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0273
        L_0x024d:
            boolean r9 = r40.hasDefaultCreator()
            if (r9 != 0) goto L_0x0262
            if (r19 != 0) goto L_0x025b
            java.util.LinkedList r9 = new java.util.LinkedList
            r9.<init>()
            goto L_0x025d
        L_0x025b:
            r9 = r19
        L_0x025d:
            r9.add(r5)
            r19 = r9
        L_0x0262:
            r14 = r38
            r9 = r41
            r10 = r2
            r11 = r7
            r12 = r8
            r5 = r22
            r7 = r25
            r8 = r28
            r4 = 1
            r6 = 2
            goto L_0x00ab
        L_0x0273:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r0[r9] = r1
            r0[r30] = r5
            java.lang.String r1 = "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator"
            r8.reportBadTypeDefinition(r13, r1, r0)
            throw r22
        L_0x0284:
            r25 = r7
            r28 = r8
            r2 = r10
            r7 = r11
            r8 = r12
            if (r19 == 0) goto L_0x02aa
            boolean r0 = r40.hasDelegatingCreator()
            if (r0 != 0) goto L_0x02aa
            boolean r0 = r40.hasPropertyBasedCreator()
            if (r0 != 0) goto L_0x02aa
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r19
            r0._checkImplicitlyNamedConstructors(r1, r2, r3, r4, r5, r6)
        L_0x02aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory._addDeserializerConstructors(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanDescription, com.fasterxml.jackson.databind.introspect.VisibilityChecker, com.fasterxml.jackson.databind.AnnotationIntrospector, com.fasterxml.jackson.databind.deser.impl.CreatorCollector, java.util.Map):void");
    }

    /* Debug info: failed to restart local var, previous not found, register: 17 */
    /* access modifiers changed from: protected */
    public void _addExplicitDelegatingCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        DeserializationContext deserializationContext = ctxt;
        BeanDescription beanDescription = beanDesc;
        CreatorCollector creatorCollector = creators;
        CreatorCandidate creatorCandidate = candidate;
        int argCount = candidate.paramCount();
        SettableBeanProperty[] properties = new SettableBeanProperty[argCount];
        int ix = -1;
        for (int i = 0; i < argCount; i++) {
            AnnotatedParameter param = creatorCandidate.parameter(i);
            Value injectId = creatorCandidate.injection(i);
            if (injectId != null) {
                properties[i] = constructCreatorProperty(ctxt, beanDesc, null, i, param, injectId);
            } else if (ix < 0) {
                ix = i;
            } else {
                deserializationContext.reportBadTypeDefinition(beanDescription, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(ix), Integer.valueOf(i), creatorCandidate);
                throw null;
            }
        }
        if (ix < 0) {
            deserializationContext.reportBadTypeDefinition(beanDescription, "No argument left as delegating for Creator %s: exactly one required", creatorCandidate);
            throw null;
        } else if (argCount == 1) {
            _handleSingleArgumentCreator(creatorCollector, candidate.creator(), true, true);
            BeanPropertyDefinition paramDef = creatorCandidate.propertyDef(0);
            if (paramDef != null) {
                ((POJOPropertyBuilder) paramDef).removeConstructors();
            }
        } else {
            creatorCollector.addDelegatingCreator(candidate.creator(), true, properties, ix);
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 17 */
    /* access modifiers changed from: protected */
    public void _addExplicitPropertyCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        DeserializationContext deserializationContext = ctxt;
        BeanDescription beanDescription = beanDesc;
        CreatorCandidate creatorCandidate = candidate;
        int paramCount = candidate.paramCount();
        SettableBeanProperty[] properties = new SettableBeanProperty[paramCount];
        for (int i = 0; i < paramCount; i++) {
            Value injectId = creatorCandidate.injection(i);
            AnnotatedParameter param = creatorCandidate.parameter(i);
            PropertyName name = creatorCandidate.paramName(i);
            if (name == null) {
                if (ctxt.getAnnotationIntrospector().findUnwrappingNameTransformer(param) == null) {
                    name = creatorCandidate.findImplicitParamName(i);
                    if (name == null && injectId == null) {
                        deserializationContext.reportBadTypeDefinition(beanDescription, "Argument #%d has no property name, is not Injectable: can not use as Creator %s", Integer.valueOf(i), creatorCandidate);
                        throw null;
                    }
                } else {
                    _reportUnwrappedCreatorProperty(deserializationContext, beanDescription, param);
                    throw null;
                }
            }
            properties[i] = constructCreatorProperty(ctxt, beanDesc, name, i, param, injectId);
        }
        creators.addPropertyCreator(candidate.creator(), true, properties);
    }

    /* access modifiers changed from: protected */
    public void _addExplicitAnyCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        PropertyName paramName;
        boolean useProps;
        CreatorCollector creatorCollector = creators;
        CreatorCandidate creatorCandidate = candidate;
        if (1 != candidate.paramCount()) {
            int oneNotInjected = candidate.findOnlyParamWithoutInjection();
            if (oneNotInjected < 0 || creatorCandidate.paramName(oneNotInjected) != null) {
                _addExplicitPropertyCreator(ctxt, beanDesc, creators, candidate);
            } else {
                _addExplicitDelegatingCreator(ctxt, beanDesc, creators, candidate);
            }
        } else {
            AnnotatedParameter param = creatorCandidate.parameter(0);
            Value injectId = creatorCandidate.injection(0);
            PropertyName paramName2 = creatorCandidate.explicitParamName(0);
            BeanPropertyDefinition paramDef = creatorCandidate.propertyDef(0);
            boolean useProps2 = (paramName2 == null && injectId == null) ? false : true;
            if (useProps2 || paramDef == null) {
                paramName = paramName2;
                useProps = useProps2;
            } else {
                PropertyName paramName3 = creatorCandidate.findImplicitParamName(0);
                paramName = paramName3;
                useProps = paramName3 != null && paramDef.couldSerialize();
            }
            if (useProps) {
                creatorCollector.addPropertyCreator(candidate.creator(), true, new SettableBeanProperty[]{constructCreatorProperty(ctxt, beanDesc, paramName, 0, param, injectId)});
                return;
            }
            _handleSingleArgumentCreator(creatorCollector, candidate.creator(), true, true);
            if (paramDef != null) {
                ((POJOPropertyBuilder) paramDef).removeConstructors();
            }
        }
    }

    private boolean _checkIfCreatorPropertyBased(AnnotationIntrospector intr, AnnotatedWithParams creator, BeanPropertyDefinition propDef) {
        if ((propDef != null && propDef.isExplicitlyNamed()) || intr.findInjectableValue(creator.getParameter(0)) != null) {
            return true;
        }
        if (propDef != null) {
            String implName = propDef.getName();
            return implName != null && !implName.isEmpty() && propDef.couldSerialize();
        }
    }

    private void _checkImplicitlyNamedConstructors(DeserializationContext ctxt, BeanDescription beanDesc, VisibilityChecker<?> vchecker, AnnotationIntrospector intr, CreatorCollector creators, List<AnnotatedWithParams> implicitCtors) throws JsonMappingException {
        SettableBeanProperty[] arr$;
        AnnotatedWithParams found = null;
        SettableBeanProperty[] foundProps = null;
        Iterator i$ = implicitCtors.iterator();
        while (true) {
            if (!i$.hasNext()) {
                VisibilityChecker<?> visibilityChecker = vchecker;
                break;
            }
            AnnotatedWithParams ctor = (AnnotatedWithParams) i$.next();
            if (vchecker.isCreatorVisible(ctor)) {
                int argCount = ctor.getParameterCount();
                SettableBeanProperty[] properties = new SettableBeanProperty[argCount];
                int i = 0;
                while (true) {
                    if (i < argCount) {
                        AnnotatedParameter param = ctor.getParameter(i);
                        PropertyName name = _findParamName(param, intr);
                        if (name == null || name.isEmpty()) {
                            break;
                        }
                        properties[i] = constructCreatorProperty(ctxt, beanDesc, name, param.getIndex(), param, null);
                        i++;
                    } else if (found != null) {
                        found = null;
                        break;
                    } else {
                        found = ctor;
                        foundProps = properties;
                    }
                }
            }
        }
        if (found != null) {
            creators.addPropertyCreator(found, false, foundProps);
            BasicBeanDescription bbd = (BasicBeanDescription) beanDesc;
            for (SettableBeanProperty prop : foundProps) {
                PropertyName pn = prop.getFullName();
                if (!bbd.hasProperty(pn)) {
                    bbd.addProperty(SimpleBeanPropertyDefinition.construct(ctxt.getConfig(), prop.getMember(), pn));
                }
            }
            return;
        }
        CreatorCollector creatorCollector = creators;
    }

    /* Debug info: failed to restart local var, previous not found, register: 34 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r18v1, types: [com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r32v0, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r25v0, types: [com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition] */
    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r3v4, types: [com.fasterxml.jackson.databind.PropertyName] */
    /* JADX WARNING: type inference failed for: r32v1 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r32v2, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r7v5, types: [com.fasterxml.jackson.databind.PropertyName] */
    /* JADX WARNING: type inference failed for: r32v3 */
    /* JADX WARNING: type inference failed for: r27v6, types: [com.fasterxml.jackson.databind.PropertyName] */
    /* JADX WARNING: type inference failed for: r27v7 */
    /* JADX WARNING: type inference failed for: r25v1 */
    /* JADX WARNING: type inference failed for: r25v2 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r32v4 */
    /* JADX WARNING: type inference failed for: r32v5 */
    /* JADX WARNING: type inference failed for: r32v6 */
    /* JADX WARNING: type inference failed for: r27v8 */
    /* JADX WARNING: type inference failed for: r25v3 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v1
      assigns: []
      uses: []
      mth insns count: 198
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _addDeserializerFactoryMethods(com.fasterxml.jackson.databind.DeserializationContext r35, com.fasterxml.jackson.databind.BeanDescription r36, com.fasterxml.jackson.databind.introspect.VisibilityChecker<?> r37, com.fasterxml.jackson.databind.AnnotationIntrospector r38, com.fasterxml.jackson.databind.deser.impl.CreatorCollector r39, java.util.Map<com.fasterxml.jackson.databind.introspect.AnnotatedWithParams, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]> r40) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r34 = this;
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r10 = r39
            r9 = r40
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r8 = r0
            r0 = 0
            java.util.List r1 = r36.getFactoryMethods()
            java.util.Iterator r1 = r1.iterator()
            r16 = r0
        L_0x001f:
            boolean r0 = r1.hasNext()
            r7 = 2
            r6 = 0
            r5 = 1
            if (r0 == 0) goto L_0x008b
            java.lang.Object r0 = r1.next()
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r0
            com.fasterxml.jackson.databind.DeserializationConfig r2 = r35.getConfig()
            com.fasterxml.jackson.annotation.JsonCreator$Mode r2 = r15.findCreatorAnnotation(r2, r0)
            int r3 = r0.getParameterCount()
            if (r2 != 0) goto L_0x004c
            if (r3 != r5) goto L_0x001f
            boolean r4 = r14.isCreatorVisible(r0)
            if (r4 == 0) goto L_0x001f
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r4 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r6)
            r8.add(r4)
            goto L_0x001f
        L_0x004c:
            com.fasterxml.jackson.annotation.JsonCreator$Mode r4 = com.fasterxml.jackson.annotation.JsonCreator.Mode.DISABLED
            if (r2 != r4) goto L_0x0051
            goto L_0x001f
        L_0x0051:
            if (r3 != 0) goto L_0x0057
            r10.setDefaultCreator(r0)
            goto L_0x001f
        L_0x0057:
            int[] r4 = com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.C68181.$SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode
            int r17 = r2.ordinal()
            r4 = r4[r17]
            if (r4 == r5) goto L_0x007f
            if (r4 == r7) goto L_0x0071
            java.lang.Object r4 = r9.get(r0)
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r4 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]) r4
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r4 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r4)
            r11._addExplicitAnyCreator(r12, r13, r10, r4)
            goto L_0x0087
        L_0x0071:
            java.lang.Object r4 = r9.get(r0)
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r4 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]) r4
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r4 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r4)
            r11._addExplicitPropertyCreator(r12, r13, r10, r4)
            goto L_0x0087
        L_0x007f:
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r4 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r15, r0, r6)
            r11._addExplicitDelegatingCreator(r12, r13, r10, r4)
        L_0x0087:
            int r16 = r16 + 1
            goto L_0x001f
        L_0x008b:
            if (r16 <= 0) goto L_0x008e
            return
        L_0x008e:
            java.util.Iterator r17 = r8.iterator()
        L_0x0092:
            boolean r0 = r17.hasNext()
            if (r0 == 0) goto L_0x01cc
            java.lang.Object r0 = r17.next()
            r4 = r0
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r4 = (com.fasterxml.jackson.databind.deser.impl.CreatorCandidate) r4
            int r2 = r4.paramCount()
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r1 = r4.creator()
            java.lang.Object r0 = r9.get(r1)
            r18 = r0
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r18 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]) r18
            if (r2 == r5) goto L_0x00b2
            goto L_0x0092
        L_0x00b2:
            r0 = 0
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r3 = r4.propertyDef(r0)
            boolean r19 = r11._checkIfCreatorPropertyBased(r15, r1, r3)
            if (r19 != 0) goto L_0x00d0
            boolean r5 = r14.isCreatorVisible(r1)
            r11._handleSingleArgumentCreator(r10, r1, r0, r5)
            if (r3 == 0) goto L_0x00ce
            r0 = r3
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r0 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder) r0
            r0.removeConstructors()
            r5 = 1
            goto L_0x0092
        L_0x00ce:
            r5 = 1
            goto L_0x0092
        L_0x00d0:
            r5 = 0
            com.fasterxml.jackson.databind.deser.SettableBeanProperty[] r14 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[r2]
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r33 = r24
            r24 = r5
            r5 = r33
        L_0x00e1:
            if (r5 >= r2) goto L_0x017a
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter r11 = r1.getParameter(r5)
            if (r18 != 0) goto L_0x00ec
            r25 = r6
            goto L_0x00ee
        L_0x00ec:
            r25 = r18[r5]
        L_0x00ee:
            com.fasterxml.jackson.annotation.JacksonInject$Value r26 = r15.findInjectableValue(r11)
            if (r25 != 0) goto L_0x00f7
            r27 = r6
            goto L_0x00fb
        L_0x00f7:
            com.fasterxml.jackson.databind.PropertyName r27 = r25.getFullName()
        L_0x00fb:
            r28 = r3
            r3 = r27
            if (r25 == 0) goto L_0x0129
            boolean r27 = r25.isExplicitlyNamed()
            if (r27 == 0) goto L_0x0129
            int r22 = r22 + 1
            r0 = r34
            r29 = r1
            r1 = r35
            r30 = r2
            r2 = r36
            r27 = r4
            r4 = r5
            r20 = r5
            r31 = 1
            r5 = r11
            r32 = r6
            r6 = r26
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r0 = r0.constructCreatorProperty(r1, r2, r3, r4, r5, r6)
            r14[r20] = r0
            r1 = r8
            r2 = r10
            r0 = 2
            goto L_0x015d
        L_0x0129:
            r29 = r1
            r30 = r2
            r27 = r4
            r20 = r5
            r32 = r6
            r31 = 1
            if (r26 == 0) goto L_0x014f
            int r23 = r23 + 1
            r4 = r34
            r5 = r35
            r6 = r36
            r0 = 2
            r7 = r3
            r1 = r8
            r8 = r20
            r9 = r11
            r2 = r10
            r10 = r26
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r4 = r4.constructCreatorProperty(r5, r6, r7, r8, r9, r10)
            r14[r20] = r4
            goto L_0x015d
        L_0x014f:
            r1 = r8
            r2 = r10
            r0 = 2
            com.fasterxml.jackson.databind.util.NameTransformer r4 = r15.findUnwrappingNameTransformer(r11)
            if (r4 != 0) goto L_0x0173
            if (r24 != 0) goto L_0x015d
            r5 = r11
            r24 = r5
        L_0x015d:
            int r5 = r20 + 1
            r11 = r34
            r9 = r40
            r8 = r1
            r10 = r2
            r4 = r27
            r3 = r28
            r1 = r29
            r2 = r30
            r6 = r32
            r0 = 0
            r7 = 2
            goto L_0x00e1
        L_0x0173:
            r3 = r34
            r0 = r11
            r3._reportUnwrappedCreatorProperty(r12, r13, r0)
            throw r32
        L_0x017a:
            r29 = r1
            r30 = r2
            r28 = r3
            r27 = r4
            r20 = r5
            r32 = r6
            r1 = r8
            r2 = r10
            r3 = r11
            r0 = 2
            r31 = 1
            int r4 = r22 + r21
            if (r22 > 0) goto L_0x0192
            if (r23 <= 0) goto L_0x01ab
        L_0x0192:
            int r5 = r4 + r23
            r6 = r30
            if (r5 != r6) goto L_0x019f
            r5 = r29
            r7 = 0
            r2.addPropertyCreator(r5, r7, r14)
            goto L_0x01ab
        L_0x019f:
            r5 = r29
            r7 = 0
            if (r22 != 0) goto L_0x01b8
            int r8 = r23 + 1
            if (r8 != r6) goto L_0x01b8
            r2.addDelegatingCreator(r5, r7, r14, r7)
        L_0x01ab:
            r14 = r37
            r9 = r40
            r8 = r1
            r10 = r2
            r11 = r3
            r6 = r32
            r5 = 1
            r7 = 2
            goto L_0x0092
        L_0x01b8:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            int r1 = r24.getIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r7] = r1
            r0[r31] = r5
            java.lang.String r1 = "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator"
            r12.reportBadTypeDefinition(r13, r1, r0)
            throw r32
        L_0x01cc:
            r1 = r8
            r2 = r10
            r3 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory._addDeserializerFactoryMethods(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanDescription, com.fasterxml.jackson.databind.introspect.VisibilityChecker, com.fasterxml.jackson.databind.AnnotationIntrospector, com.fasterxml.jackson.databind.deser.impl.CreatorCollector, java.util.Map):void");
    }

    /* access modifiers changed from: protected */
    public boolean _handleSingleArgumentCreator(CreatorCollector creators, AnnotatedWithParams ctor, boolean isCreator, boolean isVisible) {
        Class<?> type = ctor.getRawParameterType(0);
        if (type == String.class || type == CharSequence.class) {
            if (isCreator || isVisible) {
                creators.addStringCreator(ctor, isCreator);
            }
            return true;
        } else if (type == Integer.TYPE || type == Integer.class) {
            if (isCreator || isVisible) {
                creators.addIntCreator(ctor, isCreator);
            }
            return true;
        } else if (type == Long.TYPE || type == Long.class) {
            if (isCreator || isVisible) {
                creators.addLongCreator(ctor, isCreator);
            }
            return true;
        } else if (type == Double.TYPE || type == Double.class) {
            if (isCreator || isVisible) {
                creators.addDoubleCreator(ctor, isCreator);
            }
            return true;
        } else if (type == Boolean.TYPE || type == Boolean.class) {
            if (isCreator || isVisible) {
                creators.addBooleanCreator(ctor, isCreator);
            }
            return true;
        } else if (!isCreator) {
            return false;
        } else {
            creators.addDelegatingCreator(ctor, isCreator, null, 0);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void _reportUnwrappedCreatorProperty(DeserializationContext ctxt, BeanDescription beanDesc, AnnotatedParameter param) throws JsonMappingException {
        ctxt.reportBadDefinition(beanDesc.getType(), String.format("Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", new Object[]{Integer.valueOf(param.getIndex())}));
        throw null;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructCreatorProperty(DeserializationContext ctxt, BeanDescription beanDesc, PropertyName name, int index, AnnotatedParameter param, Value injectable) throws JsonMappingException {
        PropertyMetadata metadata;
        TypeDeserializer typeDeser;
        DeserializationContext deserializationContext = ctxt;
        AnnotatedParameter annotatedParameter = param;
        DeserializationConfig config = ctxt.getConfig();
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            metadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        } else {
            metadata = PropertyMetadata.construct(intr.hasRequiredMarker(annotatedParameter), intr.findPropertyDescription(annotatedParameter), intr.findPropertyIndex(annotatedParameter), intr.findPropertyDefaultValue(annotatedParameter));
        }
        JavaType type = resolveMemberAndTypeAnnotations(deserializationContext, annotatedParameter, param.getType());
        Std std = new Std(name, type, intr.findWrapperName(annotatedParameter), param, metadata);
        Std property = std;
        TypeDeserializer typeDeser2 = (TypeDeserializer) type.getTypeHandler();
        if (typeDeser2 == null) {
            typeDeser = findTypeDeserializer(config, type);
        } else {
            typeDeser = typeDeser2;
        }
        JavaType type2 = type;
        CreatorProperty creatorProperty = new CreatorProperty(name, type, property.getWrapperName(), typeDeser, beanDesc.getClassAnnotations(), param, index, injectable == null ? null : injectable.getId(), metadata);
        JsonDeserializer<?> deser = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        if (deser == null) {
            deser = (JsonDeserializer) type2.getValueHandler();
        }
        if (deser != null) {
            return creatorProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(deser, creatorProperty, type2));
        }
        return creatorProperty;
    }

    private PropertyName _findParamName(AnnotatedParameter param, AnnotationIntrospector intr) {
        if (!(param == null || intr == null)) {
            PropertyName name = intr.findNameForDeserialization(param);
            if (name != null) {
                return name;
            }
            String str = intr.findImplicitPropertyName(param);
            if (str != null && !str.isEmpty()) {
                return PropertyName.construct(str);
            }
        }
        return null;
    }

    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext ctxt, ArrayType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer elemTypeDeser;
        DeserializationConfig config = ctxt.getConfig();
        JavaType elemType = type.getContentType();
        JsonDeserializer<Object> contentDeser = (JsonDeserializer) elemType.getValueHandler();
        TypeDeserializer elemTypeDeser2 = (TypeDeserializer) elemType.getTypeHandler();
        if (elemTypeDeser2 == null) {
            elemTypeDeser = findTypeDeserializer(config, elemType);
        } else {
            elemTypeDeser = elemTypeDeser2;
        }
        JsonDeserializer _findCustomArrayDeserializer = _findCustomArrayDeserializer(type, config, beanDesc, elemTypeDeser, contentDeser);
        if (_findCustomArrayDeserializer == null) {
            if (contentDeser == null) {
                Class<?> raw = elemType.getRawClass();
                if (elemType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(raw);
                }
                if (raw == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            _findCustomArrayDeserializer = new ObjectArrayDeserializer(type, contentDeser, elemTypeDeser);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                _findCustomArrayDeserializer = mod.modifyArrayDeserializer(config, type, beanDesc, _findCustomArrayDeserializer);
            }
        }
        return _findCustomArrayDeserializer;
    }

    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext ctxt, CollectionType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        JavaType contentType = type.getContentType();
        JsonDeserializer<Object> contentDeser = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 == null) {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        } else {
            contentTypeDeser = contentTypeDeser2;
        }
        JsonDeserializer _findCustomCollectionDeserializer = _findCustomCollectionDeserializer(type, config, beanDesc, contentTypeDeser, contentDeser);
        if (_findCustomCollectionDeserializer == null) {
            Class<?> collectionClass = type.getRawClass();
            if (contentDeser == null && EnumSet.class.isAssignableFrom(collectionClass)) {
                _findCustomCollectionDeserializer = new EnumSetDeserializer(contentType, null);
            }
        }
        if (_findCustomCollectionDeserializer == null) {
            if (type.isInterface() || type.isAbstract()) {
                CollectionType implType = _mapAbstractCollectionType(type, config);
                if (implType != null) {
                    type = implType;
                    beanDesc = config.introspectForCreation(type);
                } else if (type.getTypeHandler() != null) {
                    _findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(beanDesc);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot find a deserializer for non-concrete Collection type ");
                    sb.append(type);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (_findCustomCollectionDeserializer == null) {
                ValueInstantiator inst = findValueInstantiator(ctxt, beanDesc);
                if (!inst.canCreateUsingDefault()) {
                    if (type.hasRawClass(ArrayBlockingQueue.class)) {
                        return new ArrayBlockingQueueDeserializer(type, contentDeser, contentTypeDeser, inst);
                    }
                    JsonDeserializer<?> deser = JavaUtilCollectionsDeserializers.findForCollection(ctxt, type);
                    if (deser != null) {
                        return deser;
                    }
                }
                if (contentType.hasRawClass(String.class)) {
                    _findCustomCollectionDeserializer = new StringCollectionDeserializer(type, contentDeser, inst);
                } else {
                    _findCustomCollectionDeserializer = new CollectionDeserializer(type, contentDeser, contentTypeDeser, inst);
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                _findCustomCollectionDeserializer = mod.modifyCollectionDeserializer(config, type, beanDesc, _findCustomCollectionDeserializer);
            }
        }
        return _findCustomCollectionDeserializer;
    }

    /* access modifiers changed from: protected */
    public CollectionType _mapAbstractCollectionType(JavaType type, DeserializationConfig config) {
        Class<?> collectionClass = (Class) _collectionFallbacks.get(type.getRawClass().getName());
        if (collectionClass == null) {
            return null;
        }
        return (CollectionType) config.constructSpecializedType(type, collectionClass);
    }

    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext ctxt, CollectionLikeType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        JavaType contentType = type.getContentType();
        JsonDeserializer<Object> contentDeser = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 == null) {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        } else {
            contentTypeDeser = contentTypeDeser2;
        }
        JsonDeserializer<?> deser = _findCustomCollectionLikeDeserializer(type, config, beanDesc, contentTypeDeser, contentDeser);
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyCollectionLikeDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    /* JADX WARNING: type inference failed for: r16v0, types: [com.fasterxml.jackson.databind.JsonDeserializer] */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r16v2, types: [com.fasterxml.jackson.databind.JsonDeserializer<?>] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.fasterxml.jackson.databind.JsonDeserializer] */
    /* JADX WARNING: type inference failed for: r16v3 */
    /* JADX WARNING: type inference failed for: r2v3, types: [com.fasterxml.jackson.databind.JsonDeserializer] */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* JADX WARNING: type inference failed for: r1v6, types: [com.fasterxml.jackson.databind.deser.std.MapDeserializer] */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r16v7 */
    /* JADX WARNING: type inference failed for: r16v8, types: [com.fasterxml.jackson.databind.deser.AbstractDeserializer] */
    /* JADX WARNING: type inference failed for: r0v17, types: [com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.JsonDeserializer<?>] */
    /* JADX WARNING: type inference failed for: r16v9 */
    /* JADX WARNING: type inference failed for: r0v22, types: [com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer] */
    /* JADX WARNING: type inference failed for: r16v10 */
    /* JADX WARNING: type inference failed for: r16v11 */
    /* JADX WARNING: type inference failed for: r16v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r16v13 */
    /* JADX WARNING: type inference failed for: r16v14 */
    /* JADX WARNING: type inference failed for: r16v15 */
    /* JADX WARNING: type inference failed for: r16v16 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r16v7
      assigns: []
      uses: []
      mth insns count: 128
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext r23, com.fasterxml.jackson.databind.type.MapType r24, com.fasterxml.jackson.databind.BeanDescription r25) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r22 = this;
            r7 = r22
            r8 = r23
            r9 = r24
            com.fasterxml.jackson.databind.DeserializationConfig r10 = r23.getConfig()
            com.fasterxml.jackson.databind.JavaType r11 = r24.getKeyType()
            com.fasterxml.jackson.databind.JavaType r12 = r24.getContentType()
            java.lang.Object r0 = r12.getValueHandler()
            r13 = r0
            com.fasterxml.jackson.databind.JsonDeserializer r13 = (com.fasterxml.jackson.databind.JsonDeserializer) r13
            java.lang.Object r0 = r11.getValueHandler()
            r14 = r0
            com.fasterxml.jackson.databind.KeyDeserializer r14 = (com.fasterxml.jackson.databind.KeyDeserializer) r14
            java.lang.Object r0 = r12.getTypeHandler()
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r0 = (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) r0
            if (r0 != 0) goto L_0x002e
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r0 = r7.findTypeDeserializer(r10, r12)
            r15 = r0
            goto L_0x002f
        L_0x002e:
            r15 = r0
        L_0x002f:
            r0 = r22
            r1 = r24
            r2 = r10
            r3 = r25
            r4 = r14
            r5 = r15
            r6 = r13
            com.fasterxml.jackson.databind.JsonDeserializer r16 = r0._findCustomMapDeserializer(r1, r2, r3, r4, r5, r6)
            if (r16 != 0) goto L_0x0119
            java.lang.Class r6 = r24.getRawClass()
            java.lang.Class<java.util.EnumMap> r0 = java.util.EnumMap.class
            boolean r0 = r0.isAssignableFrom(r6)
            if (r0 == 0) goto L_0x008a
            java.lang.Class<java.util.EnumMap> r0 = java.util.EnumMap.class
            if (r6 != r0) goto L_0x0055
            r0 = 0
            r5 = r25
            r17 = r0
            goto L_0x005d
        L_0x0055:
            r5 = r25
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r7.findValueInstantiator(r8, r5)
            r17 = r0
        L_0x005d:
            java.lang.Class r18 = r11.getRawClass()
            if (r18 == 0) goto L_0x0080
            boolean r0 = r18.isEnum()
            if (r0 == 0) goto L_0x0080
            com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer r19 = new com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer
            r3 = 0
            r20 = 0
            r0 = r19
            r1 = r24
            r2 = r17
            r4 = r13
            r5 = r15
            r21 = r6
            r6 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r16 = r19
            goto L_0x008c
        L_0x0080:
            r21 = r6
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot construct EnumMap; generic (key) type not available"
            r0.<init>(r1)
            throw r0
        L_0x008a:
            r21 = r6
        L_0x008c:
            if (r16 != 0) goto L_0x0116
            boolean r0 = r24.isInterface()
            if (r0 != 0) goto L_0x00a7
            boolean r0 = r24.isAbstract()
            if (r0 == 0) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            com.fasterxml.jackson.databind.JsonDeserializer r0 = com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers.findForMap(r23, r24)
            if (r0 == 0) goto L_0x00a2
            return r0
        L_0x00a2:
            r16 = r0
            r0 = r25
            goto L_0x00d4
        L_0x00a7:
            java.util.HashMap<java.lang.String, java.lang.Class<? extends java.util.Map>> r0 = _mapFallbacks
            java.lang.String r1 = r21.getName()
            java.lang.Object r0 = r0.get(r1)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L_0x00c1
            r6 = r0
            com.fasterxml.jackson.databind.JavaType r1 = r10.constructSpecializedType(r9, r6)
            com.fasterxml.jackson.databind.type.MapType r1 = (com.fasterxml.jackson.databind.type.MapType) r1
            com.fasterxml.jackson.databind.BeanDescription r2 = r10.introspectForCreation(r1)
            goto L_0x00d0
        L_0x00c1:
            java.lang.Object r1 = r24.getTypeHandler()
            if (r1 == 0) goto L_0x00ff
            com.fasterxml.jackson.databind.deser.AbstractDeserializer r16 = com.fasterxml.jackson.databind.deser.AbstractDeserializer.constructForNonPOJO(r25)
            r2 = r25
            r1 = r9
            r6 = r21
        L_0x00d0:
            r9 = r1
            r0 = r2
            r21 = r6
        L_0x00d4:
            if (r16 != 0) goto L_0x011b
            com.fasterxml.jackson.databind.deser.ValueInstantiator r17 = r7.findValueInstantiator(r8, r0)
            com.fasterxml.jackson.databind.deser.std.MapDeserializer r18 = new com.fasterxml.jackson.databind.deser.std.MapDeserializer
            r1 = r18
            r2 = r9
            r3 = r17
            r4 = r14
            r5 = r13
            r6 = r15
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r3 = r0.getClassInfo()
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r2 = r10.getDefaultPropertyIgnorals(r2, r3)
            if (r2 != 0) goto L_0x00f5
            r3 = 0
            goto L_0x00f9
        L_0x00f5:
            java.util.Set r3 = r2.findIgnoredForDeserialization()
        L_0x00f9:
            r1.setIgnorableProperties(r3)
            r16 = r1
            goto L_0x011b
        L_0x00ff:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot find a deserializer for non-concrete Map type "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0116:
            r0 = r25
            goto L_0x011b
        L_0x0119:
            r0 = r25
        L_0x011b:
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = r7._factoryConfig
            boolean r1 = r1.hasDeserializerModifiers()
            if (r1 == 0) goto L_0x0142
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = r7._factoryConfig
            java.lang.Iterable r1 = r1.deserializerModifiers()
            java.util.Iterator r1 = r1.iterator()
            r2 = r16
        L_0x012f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0140
            java.lang.Object r3 = r1.next()
            com.fasterxml.jackson.databind.deser.BeanDeserializerModifier r3 = (com.fasterxml.jackson.databind.deser.BeanDeserializerModifier) r3
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r3.modifyMapDeserializer(r10, r9, r0, r2)
            goto L_0x012f
        L_0x0140:
            r16 = r2
        L_0x0142:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.type.MapType, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext ctxt, MapLikeType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        JavaType keyType = type.getKeyType();
        JavaType contentType = type.getContentType();
        DeserializationConfig config = ctxt.getConfig();
        JsonDeserializer<Object> contentDeser = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDes = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 == null) {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        } else {
            contentTypeDeser = contentTypeDeser2;
        }
        JsonDeserializer<?> deser = _findCustomMapLikeDeserializer(type, config, beanDesc, keyDes, contentTypeDeser, contentDeser);
        if (deser == null) {
            MapLikeType mapLikeType = type;
            BeanDescription beanDescription = beanDesc;
        } else if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyMapLikeDeserializer(config, type, beanDesc, deser);
            }
            MapLikeType mapLikeType2 = type;
            BeanDescription beanDescription2 = beanDesc;
        } else {
            MapLikeType mapLikeType3 = type;
            BeanDescription beanDescription3 = beanDesc;
        }
        return deser;
    }

    public JsonDeserializer<?> createEnumDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        Class<?> enumClass = type.getRawClass();
        JsonDeserializer _findCustomEnumDeserializer = _findCustomEnumDeserializer(enumClass, config, beanDesc);
        if (_findCustomEnumDeserializer == null) {
            ValueInstantiator valueInstantiator = _constructDefaultValueInstantiator(ctxt, beanDesc);
            SettableBeanProperty[] creatorProps = valueInstantiator == null ? null : valueInstantiator.getFromObjectArguments(ctxt.getConfig());
            Iterator i$ = beanDesc.getFactoryMethods().iterator();
            while (true) {
                if (!i$.hasNext()) {
                    break;
                }
                AnnotatedMethod factory = (AnnotatedMethod) i$.next();
                if (_hasCreatorAnnotation(ctxt, factory)) {
                    if (factory.getParameterCount() == 0) {
                        _findCustomEnumDeserializer = EnumDeserializer.deserializerForNoArgsCreator(config, enumClass, factory);
                        break;
                    } else if (factory.getRawReturnType().isAssignableFrom(enumClass)) {
                        _findCustomEnumDeserializer = EnumDeserializer.deserializerForCreator(config, enumClass, factory, valueInstantiator, creatorProps);
                        break;
                    }
                }
            }
            if (_findCustomEnumDeserializer == null) {
                _findCustomEnumDeserializer = new EnumDeserializer(constructEnumResolver(enumClass, config, beanDesc.findJsonValueAccessor()), Boolean.valueOf(config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)));
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                _findCustomEnumDeserializer = mod.modifyEnumDeserializer(config, type, beanDesc, _findCustomEnumDeserializer);
            }
        }
        return _findCustomEnumDeserializer;
    }

    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig config, JavaType nodeType, BeanDescription beanDesc) throws JsonMappingException {
        Class<? extends JsonNode> nodeClass = nodeType.getRawClass();
        JsonDeserializer<?> custom = _findCustomTreeNodeDeserializer(nodeClass, config, beanDesc);
        if (custom != null) {
            return custom;
        }
        return JsonNodeDeserializer.getDeserializer(nodeClass);
    }

    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext ctxt, ReferenceType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        ValueInstantiator inst;
        JavaType contentType = type.getContentType();
        JsonDeserializer<Object> contentDeser = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 == null) {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        } else {
            contentTypeDeser = contentTypeDeser2;
        }
        JsonDeserializer<?> deser = _findCustomReferenceDeserializer(type, config, beanDesc, contentTypeDeser, contentDeser);
        if (deser != null || !type.isTypeOrSubTypeOf(AtomicReference.class)) {
            if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                    deser = mod.modifyReferenceDeserializer(config, type, beanDesc, deser);
                }
            }
            return deser;
        }
        if (type.getRawClass() == AtomicReference.class) {
            inst = null;
        } else {
            inst = findValueInstantiator(ctxt, beanDesc);
        }
        return new AtomicReferenceDeserializer(type, inst, contentTypeDeser, contentDeser);
    }

    public TypeDeserializer findTypeDeserializer(DeserializationConfig config, JavaType baseType) throws JsonMappingException {
        AnnotatedClass ac = config.introspectClassAnnotations(baseType.getRawClass()).getClassInfo();
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findTypeResolver(config, ac, baseType);
        Collection<NamedType> subtypes = null;
        if (b == null) {
            b = config.getDefaultTyper(baseType);
            if (b == null) {
                return null;
            }
        } else {
            subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, ac);
        }
        if (b.getDefaultImpl() == null && baseType.isAbstract()) {
            JavaType defaultType = mapAbstractType(config, baseType);
            if (defaultType != null && !defaultType.hasRawClass(baseType.getRawClass())) {
                b = b.defaultImpl(defaultType.getRawClass());
            }
        }
        return b.buildTypeDeserializer(config, baseType, subtypes);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(type, ctxt.getConfig(), beanDesc);
    }

    public KeyDeserializer createKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        KeyDeserializer deser = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            BeanDescription beanDesc = config.introspectClassAnnotations(type.getRawClass());
            for (KeyDeserializers d : this._factoryConfig.keyDeserializers()) {
                deser = d.findKeyDeserializer(type, config, beanDesc);
                if (deser != null) {
                    break;
                }
            }
        }
        if (deser == null) {
            if (type.isEnumType()) {
                deser = _createEnumKeyDeserializer(ctxt, type);
            } else {
                deser = StdKeyDeserializers.findStringBasedKeyDeserializer(config, type);
            }
        }
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyKeyDeserializer(config, type, deser);
            }
        }
        return deser;
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        Class<?> enumClass = type.getRawClass();
        BeanDescription beanDesc = config.introspect(type);
        KeyDeserializer des = findKeyDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (des != null) {
            return des;
        }
        JsonDeserializer<?> custom = _findCustomEnumDeserializer(enumClass, config, beanDesc);
        if (custom != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, type, custom);
        }
        JsonDeserializer<?> valueDesForKey = findDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (valueDesForKey != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, type, valueDesForKey);
        }
        EnumResolver enumRes = constructEnumResolver(enumClass, config, beanDesc.findJsonValueAccessor());
        for (AnnotatedMethod factory : beanDesc.getFactoryMethods()) {
            if (_hasCreatorAnnotation(ctxt, factory)) {
                if (factory.getParameterCount() != 1 || !factory.getRawReturnType().isAssignableFrom(enumClass)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsuitable method (");
                    sb.append(factory);
                    sb.append(") decorated with @JsonCreator (for Enum type ");
                    sb.append(enumClass.getName());
                    sb.append(")");
                    throw new IllegalArgumentException(sb.toString());
                } else if (factory.getRawParameterType(0) == String.class) {
                    if (config.canOverrideAccessModifiers()) {
                        ClassUtil.checkAndFixAccess(factory.getMember(), ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(enumRes, factory);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parameter #0 type for factory method (");
                    sb2.append(factory);
                    sb2.append(") not suitable, must be java.lang.String");
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumRes);
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig config, JavaType baseType, AnnotatedMember annotated) throws JsonMappingException {
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findPropertyTypeResolver(config, annotated, baseType);
        if (b == null) {
            return findTypeDeserializer(config, baseType);
        }
        return b.buildTypeDeserializer(config, baseType, config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, annotated, baseType));
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig config, JavaType containerType, AnnotatedMember propertyEntity) throws JsonMappingException {
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findPropertyContentTypeResolver(config, propertyEntity, containerType);
        JavaType contentType = containerType.getContentType();
        if (b == null) {
            return findTypeDeserializer(config, contentType);
        }
        return b.buildTypeDeserializer(config, contentType, config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, propertyEntity, contentType));
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        JavaType mt;
        JavaType lt;
        Class<?> rawType = type.getRawClass();
        if (rawType == CLASS_OBJECT) {
            DeserializationConfig config = ctxt.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                lt = _findRemappedType(config, List.class);
                mt = _findRemappedType(config, Map.class);
            } else {
                lt = null;
                mt = null;
            }
            return new UntypedObjectDeserializer(lt, mt);
        } else if (rawType == CLASS_STRING || rawType == CLASS_CHAR_BUFFER) {
            return StringDeserializer.instance;
        } else {
            if (rawType == CLASS_ITERABLE) {
                TypeFactory tf = ctxt.getTypeFactory();
                JavaType[] tps = tf.findTypeParameters(type, CLASS_ITERABLE);
                return createCollectionDeserializer(ctxt, tf.constructCollectionType(Collection.class, (tps == null || tps.length != 1) ? TypeFactory.unknownType() : tps[0]), beanDesc);
            } else if (rawType == CLASS_MAP_ENTRY) {
                JavaType kt = type.containedTypeOrUnknown(0);
                JavaType vt = type.containedTypeOrUnknown(1);
                TypeDeserializer vts = (TypeDeserializer) vt.getTypeHandler();
                if (vts == null) {
                    vts = findTypeDeserializer(ctxt.getConfig(), vt);
                }
                return new MapEntryDeserializer(type, (KeyDeserializer) kt.getValueHandler(), (JsonDeserializer) vt.getValueHandler(), vts);
            } else {
                String clsName = rawType.getName();
                if (rawType.isPrimitive() || clsName.startsWith("java.")) {
                    JsonDeserializer<?> deser = NumberDeserializers.find(rawType, clsName);
                    if (deser == null) {
                        deser = DateDeserializers.find(rawType, clsName);
                    }
                    if (deser != null) {
                        return deser;
                    }
                }
                if (rawType == TokenBuffer.class) {
                    return new TokenBufferDeserializer();
                }
                JsonDeserializer<?> deser2 = findOptionalStdDeserializer(ctxt, type, beanDesc);
                if (deser2 != null) {
                    return deser2;
                }
                return JdkDeserializers.find(rawType, clsName);
            }
        }
    }

    /* access modifiers changed from: protected */
    public JavaType _findRemappedType(DeserializationConfig config, Class<?> rawType) throws JsonMappingException {
        JavaType type = mapAbstractType(config, config.constructType(rawType));
        if (type == null || type.hasRawClass(rawType)) {
            return null;
        }
        return type;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findTreeNodeDeserializer(type, config, beanDesc);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer contentTypeDeserializer, JsonDeserializer<?> contentDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findReferenceDeserializer(type, config, beanDesc, contentTypeDeserializer, contentDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findBeanDeserializer(type, config, beanDesc);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findArrayDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findCollectionDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findCollectionLikeDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findEnumDeserializer(type, config, beanDesc);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findMapDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findMapLikeDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null) {
            Object deserDef = intr.findDeserializer(ann);
            if (deserDef != null) {
                return ctxt.deserializerInstance(ann, deserDef);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null) {
            Object deserDef = intr.findKeyDeserializer(ann);
            if (deserDef != null) {
                return ctxt.keyDeserializerInstance(ann, deserDef);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findContentDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null) {
            Object deserDef = intr.findContentDeserializer(ann);
            if (deserDef != null) {
                return ctxt.deserializerInstance(ann, deserDef);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JavaType resolveMemberAndTypeAnnotations(DeserializationContext ctxt, AnnotatedMember member, JavaType type) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            return type;
        }
        if (type.isMapLikeType() && type.getKeyType() != null) {
            KeyDeserializer kd = ctxt.keyDeserializerInstance(member, intr.findKeyDeserializer(member));
            if (kd != null) {
                type = ((MapLikeType) type).withKeyValueHandler(kd);
                type.getKeyType();
                type = type;
            }
        }
        if (type.hasContentType()) {
            JsonDeserializer<?> cd = ctxt.deserializerInstance(member, intr.findContentDeserializer(member));
            if (cd != null) {
                type = type.withContentValueHandler(cd);
            }
            TypeDeserializer contentTypeDeser = findPropertyContentTypeDeserializer(ctxt.getConfig(), type, member);
            if (contentTypeDeser != null) {
                type = type.withContentTypeHandler(contentTypeDeser);
            }
        }
        TypeDeserializer valueTypeDeser = findPropertyTypeDeserializer(ctxt.getConfig(), type, member);
        if (valueTypeDeser != null) {
            type = type.withTypeHandler(valueTypeDeser);
        }
        return intr.refineDeserializationType(ctxt.getConfig(), member, type);
    }

    /* access modifiers changed from: protected */
    public EnumResolver constructEnumResolver(Class<?> enumClass, DeserializationConfig config, AnnotatedMember jsonValueAccessor) {
        if (jsonValueAccessor == null) {
            return EnumResolver.constructUnsafe(enumClass, config.getAnnotationIntrospector());
        }
        if (config.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(jsonValueAccessor.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return EnumResolver.constructUnsafeUsingMethod(enumClass, jsonValueAccessor, config.getAnnotationIntrospector());
    }

    /* access modifiers changed from: protected */
    public boolean _hasCreatorAnnotation(DeserializationContext ctxt, Annotated ann) {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        boolean z = false;
        if (intr == null) {
            return false;
        }
        Mode mode = intr.findCreatorAnnotation(ctxt.getConfig(), ann);
        if (!(mode == null || mode == Mode.DISABLED)) {
            z = true;
        }
        return z;
    }
}
