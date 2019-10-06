package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter.Factory;

public final class Retrofit {
    final HttpUrl baseUrl;
    final List<Factory> callAdapterFactories;
    final Call.Factory callFactory;
    final Executor callbackExecutor;
    final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?, ?>> serviceMethodCache = new ConcurrentHashMap();
    final boolean validateEagerly;

    public static final class Builder {
        private HttpUrl baseUrl;
        private final List<Factory> callAdapterFactories;
        private Call.Factory callFactory;
        private Executor callbackExecutor;
        private final List<Converter.Factory> converterFactories;
        private final Platform platform;
        private boolean validateEagerly;

        Builder(Platform platform2) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = platform2;
        }

        public Builder() {
            this(Platform.get());
        }

        Builder(Retrofit retrofit) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = Platform.get();
            this.callFactory = retrofit.callFactory;
            this.baseUrl = retrofit.baseUrl;
            this.converterFactories.addAll(retrofit.converterFactories);
            this.converterFactories.remove(0);
            this.callAdapterFactories.addAll(retrofit.callAdapterFactories);
            List<Factory> list = this.callAdapterFactories;
            list.remove(list.size() - 1);
            this.callbackExecutor = retrofit.callbackExecutor;
            this.validateEagerly = retrofit.validateEagerly;
        }

        public Builder client(OkHttpClient client) {
            Utils.checkNotNull(client, "client == null");
            return callFactory(client);
        }

        public Builder callFactory(Call.Factory factory) {
            Utils.checkNotNull(factory, "factory == null");
            this.callFactory = factory;
            return this;
        }

        public Builder baseUrl(String baseUrl2) {
            Utils.checkNotNull(baseUrl2, "baseUrl == null");
            HttpUrl httpUrl = HttpUrl.parse(baseUrl2);
            if (httpUrl != null) {
                return baseUrl(httpUrl);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal URL: ");
            sb.append(baseUrl2);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder baseUrl(HttpUrl baseUrl2) {
            Utils.checkNotNull(baseUrl2, "baseUrl == null");
            List<String> pathSegments = baseUrl2.pathSegments();
            if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                this.baseUrl = baseUrl2;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("baseUrl must end in /: ");
            sb.append(baseUrl2);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder addConverterFactory(Converter.Factory factory) {
            List<Converter.Factory> list = this.converterFactories;
            Utils.checkNotNull(factory, "factory == null");
            list.add(factory);
            return this;
        }

        public Builder addCallAdapterFactory(Factory factory) {
            List<Factory> list = this.callAdapterFactories;
            Utils.checkNotNull(factory, "factory == null");
            list.add(factory);
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            Utils.checkNotNull(executor, "executor == null");
            this.callbackExecutor = executor;
            return this;
        }

        public List<Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder validateEagerly(boolean validateEagerly2) {
            this.validateEagerly = validateEagerly2;
            return this;
        }

        public Retrofit build() {
            Executor callbackExecutor2;
            if (this.baseUrl != null) {
                Call.Factory callFactory2 = this.callFactory;
                if (callFactory2 == null) {
                    callFactory2 = new OkHttpClient();
                }
                Executor callbackExecutor3 = this.callbackExecutor;
                if (callbackExecutor3 == null) {
                    callbackExecutor2 = this.platform.defaultCallbackExecutor();
                } else {
                    callbackExecutor2 = callbackExecutor3;
                }
                List<Factory> callAdapterFactories2 = new ArrayList<>(this.callAdapterFactories);
                callAdapterFactories2.add(this.platform.defaultCallAdapterFactory(callbackExecutor2));
                List<Converter.Factory> converterFactories2 = new ArrayList<>(this.converterFactories.size() + 1);
                converterFactories2.add(new BuiltInConverters());
                converterFactories2.addAll(this.converterFactories);
                Retrofit retrofit = new Retrofit(callFactory2, this.baseUrl, Collections.unmodifiableList(converterFactories2), Collections.unmodifiableList(callAdapterFactories2), callbackExecutor2, this.validateEagerly);
                return retrofit;
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    Retrofit(Call.Factory callFactory2, HttpUrl baseUrl2, List<Converter.Factory> converterFactories2, List<Factory> callAdapterFactories2, Executor callbackExecutor2, boolean validateEagerly2) {
        this.callFactory = callFactory2;
        this.baseUrl = baseUrl2;
        this.converterFactories = converterFactories2;
        this.callAdapterFactories = callAdapterFactories2;
        this.callbackExecutor = callbackExecutor2;
        this.validateEagerly = validateEagerly2;
    }

    public <T> T create(final Class<T> service) {
        Utils.validateServiceInterface(service);
        if (this.validateEagerly) {
            eagerlyValidateMethods(service);
        }
        return Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            private final Platform platform = Platform.get();

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, args);
                }
                if (this.platform.isDefaultMethod(method)) {
                    return this.platform.invokeDefaultMethod(method, service, proxy, args);
                }
                ServiceMethod<Object, Object> serviceMethod = Retrofit.this.loadServiceMethod(method);
                return serviceMethod.adapt(new OkHttpCall<>(serviceMethod, args));
            }
        });
    }

    private void eagerlyValidateMethods(Class<?> service) {
        Method[] declaredMethods;
        Platform platform = Platform.get();
        for (Method method : service.getDeclaredMethods()) {
            if (!platform.isDefaultMethod(method)) {
                loadServiceMethod(method);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ServiceMethod<?, ?> loadServiceMethod(Method method) {
        ServiceMethod serviceMethod;
        ServiceMethod<?, ?> result = (ServiceMethod) this.serviceMethodCache.get(method);
        if (result != null) {
            return result;
        }
        synchronized (this.serviceMethodCache) {
            serviceMethod = (ServiceMethod) this.serviceMethodCache.get(method);
            if (serviceMethod == null) {
                serviceMethod = new Builder(this, method).build();
                this.serviceMethodCache.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    public Call.Factory callFactory() {
        return this.callFactory;
    }

    public HttpUrl baseUrl() {
        return this.baseUrl;
    }

    public List<Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public CallAdapter<?, ?> callAdapter(Type returnType, Annotation[] annotations) {
        return nextCallAdapter(null, returnType, annotations);
    }

    public CallAdapter<?, ?> nextCallAdapter(Factory skipPast, Type returnType, Annotation[] annotations) {
        Utils.checkNotNull(returnType, "returnType == null");
        Utils.checkNotNull(annotations, "annotations == null");
        int start = this.callAdapterFactories.indexOf(skipPast) + 1;
        int count = this.callAdapterFactories.size();
        for (int i = start; i < count; i++) {
            CallAdapter<?, ?> adapter = ((Factory) this.callAdapterFactories.get(i)).get(returnType, annotations, this);
            if (adapter != null) {
                return adapter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(returnType);
        StringBuilder builder = sb.append(".\n");
        String str = "\n   * ";
        if (skipPast != null) {
            builder.append("  Skipped:");
            for (int i2 = 0; i2 < start; i2++) {
                builder.append(str);
                builder.append(((Factory) this.callAdapterFactories.get(i2)).getClass().getName());
            }
            builder.append(10);
        }
        builder.append("  Tried:");
        int count2 = this.callAdapterFactories.size();
        for (int i3 = start; i3 < count2; i3++) {
            builder.append(str);
            builder.append(((Factory) this.callAdapterFactories.get(i3)).getClass().getName());
        }
        throw new IllegalArgumentException(builder.toString());
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations) {
        return nextRequestBodyConverter(null, type, parameterAnnotations, methodAnnotations);
    }

    public <T> Converter<T, RequestBody> nextRequestBodyConverter(Converter.Factory skipPast, Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations) {
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(parameterAnnotations, "parameterAnnotations == null");
        Utils.checkNotNull(methodAnnotations, "methodAnnotations == null");
        int start = this.converterFactories.indexOf(skipPast) + 1;
        int count = this.converterFactories.size();
        for (int i = start; i < count; i++) {
            Converter<?, RequestBody> converter = ((Converter.Factory) this.converterFactories.get(i)).requestBodyConverter(type, parameterAnnotations, methodAnnotations, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        StringBuilder builder = sb.append(".\n");
        String str = "\n   * ";
        if (skipPast != null) {
            builder.append("  Skipped:");
            for (int i2 = 0; i2 < start; i2++) {
                builder.append(str);
                builder.append(((Converter.Factory) this.converterFactories.get(i2)).getClass().getName());
            }
            builder.append(10);
        }
        builder.append("  Tried:");
        int count2 = this.converterFactories.size();
        for (int i3 = start; i3 < count2; i3++) {
            builder.append(str);
            builder.append(((Converter.Factory) this.converterFactories.get(i3)).getClass().getName());
        }
        throw new IllegalArgumentException(builder.toString());
    }

    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotations) {
        return nextResponseBodyConverter(null, type, annotations);
    }

    public <T> Converter<ResponseBody, T> nextResponseBodyConverter(Converter.Factory skipPast, Type type, Annotation[] annotations) {
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(annotations, "annotations == null");
        int start = this.converterFactories.indexOf(skipPast) + 1;
        int count = this.converterFactories.size();
        for (int i = start; i < count; i++) {
            Converter<ResponseBody, ?> converter = ((Converter.Factory) this.converterFactories.get(i)).responseBodyConverter(type, annotations, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        StringBuilder builder = sb.append(".\n");
        String str = "\n   * ";
        if (skipPast != null) {
            builder.append("  Skipped:");
            for (int i2 = 0; i2 < start; i2++) {
                builder.append(str);
                builder.append(((Converter.Factory) this.converterFactories.get(i2)).getClass().getName());
            }
            builder.append(10);
        }
        builder.append("  Tried:");
        int count2 = this.converterFactories.size();
        for (int i3 = start; i3 < count2; i3++) {
            builder.append(str);
            builder.append(((Converter.Factory) this.converterFactories.get(i3)).getClass().getName());
        }
        throw new IllegalArgumentException(builder.toString());
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotations) {
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(annotations, "annotations == null");
        int count = this.converterFactories.size();
        for (int i = 0; i < count; i++) {
            Converter<?, String> converter = ((Converter.Factory) this.converterFactories.get(i)).stringConverter(type, annotations, this);
            if (converter != null) {
                return converter;
            }
        }
        return ToStringConverter.INSTANCE;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }
}
