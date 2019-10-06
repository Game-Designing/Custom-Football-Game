package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

final class ServiceMethod<R, T> {
    static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
    static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    private final HttpUrl baseUrl;
    private final CallAdapter<R, T> callAdapter;
    private final Factory callFactory;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    private final String httpMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;
    private final Converter<ResponseBody, R> responseConverter;

    static final class Builder<T, R> {
        CallAdapter<T, R> callAdapter;
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        Converter<ResponseBody, T> responseConverter;
        Type responseType;
        final Retrofit retrofit;

        Builder(Retrofit retrofit3, Method method2) {
            this.retrofit = retrofit3;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        public ServiceMethod build() {
            this.callAdapter = createCallAdapter();
            this.responseType = this.callAdapter.responseType();
            Type type = this.responseType;
            if (type == Response.class || type == Response.class) {
                StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(Utils.getRawType(this.responseType).getName());
                sb.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw methodError(sb.toString(), new Object[0]);
            }
            this.responseConverter = createResponseConverter();
            for (Annotation annotation : this.methodAnnotations) {
                parseMethodAnnotation(annotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int parameterCount = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[parameterCount];
                int p = 0;
                while (p < parameterCount) {
                    Type parameterType = this.parameterTypes[p];
                    if (!Utils.hasUnresolvableType(parameterType)) {
                        Annotation[] parameterAnnotations = this.parameterAnnotationsArray[p];
                        if (parameterAnnotations != null) {
                            this.parameterHandlers[p] = parseParameter(p, parameterType, parameterAnnotations);
                            p++;
                        } else {
                            throw parameterError(p, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw parameterError(p, "Parameter type must not include a type variable or wildcard: %s", parameterType);
                    }
                }
                if (this.relativeUrl == null && !this.gotUrl) {
                    throw methodError("Missing either @%s URL or @Url parameter.", this.httpMethod);
                } else if (!this.isFormEncoded && !this.isMultipart && !this.hasBody && this.gotBody) {
                    throw methodError("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.isFormEncoded && !this.gotField) {
                    throw methodError("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.isMultipart || this.gotPart) {
                    return new ServiceMethod(this);
                } else {
                    throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private CallAdapter<T, R> createCallAdapter() {
            Type returnType = this.method.getGenericReturnType();
            if (Utils.hasUnresolvableType(returnType)) {
                throw methodError("Method return type must not include a type variable or wildcard: %s", returnType);
            } else if (returnType != Void.TYPE) {
                try {
                    return this.retrofit.callAdapter(returnType, this.method.getAnnotations());
                } catch (RuntimeException e) {
                    throw methodError(e, "Unable to create call adapter for %s", returnType);
                }
            } else {
                throw methodError("Service methods cannot return void.", new Object[0]);
            }
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
                if (!Void.class.equals(this.responseType)) {
                    throw methodError("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] headersToParse = ((retrofit2.http.Headers) annotation).value();
                if (headersToParse.length != 0) {
                    this.headers = parseHeaders(headersToParse);
                } else {
                    throw methodError("@Headers annotation is empty.", new Object[0]);
                }
            } else {
                String str = "Only one encoding annotation is allowed.";
                if (annotation instanceof Multipart) {
                    if (!this.isFormEncoded) {
                        this.isMultipart = true;
                        return;
                    }
                    throw methodError(str, new Object[0]);
                } else if (!(annotation instanceof FormUrlEncoded)) {
                } else {
                    if (!this.isMultipart) {
                        this.isFormEncoded = true;
                        return;
                    }
                    throw methodError(str, new Object[0]);
                }
            }
        }

        private void parseHttpMethodAndPath(String httpMethod2, String value, boolean hasBody2) {
            String str = this.httpMethod;
            if (str == null) {
                this.httpMethod = httpMethod2;
                this.hasBody = hasBody2;
                if (!value.isEmpty()) {
                    int question = value.indexOf(63);
                    if (question != -1 && question < value.length() - 1) {
                        String queryParams = value.substring(question + 1);
                        if (ServiceMethod.PARAM_URL_REGEX.matcher(queryParams).find()) {
                            throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", queryParams);
                        }
                    }
                    this.relativeUrl = value;
                    this.relativeUrlParamNames = ServiceMethod.parsePathParameters(value);
                    return;
                }
                return;
            }
            throw methodError("Only one HTTP method is allowed. Found: %s and %s.", str, httpMethod2);
        }

        private Headers parseHeaders(String[] headers2) {
            okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
            for (String header : headers2) {
                int colon = header.indexOf(58);
                if (colon == -1 || colon == 0 || colon == header.length() - 1) {
                    throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", header);
                }
                String headerName = header.substring(0, colon);
                String headerValue = header.substring(colon + 1).trim();
                if ("Content-Type".equalsIgnoreCase(headerName)) {
                    MediaType type = MediaType.parse(headerValue);
                    if (type != null) {
                        this.contentType = type;
                    } else {
                        throw methodError("Malformed content type: %s", headerValue);
                    }
                } else {
                    builder.add(headerName, headerValue);
                }
            }
            return builder.build();
        }

        private ParameterHandler<?> parseParameter(int p, Type parameterType, Annotation[] annotations) {
            ParameterHandler<?> result = null;
            for (Annotation annotation : annotations) {
                ParameterHandler<?> annotationAction = parseParameterAnnotation(p, parameterType, annotations, annotation);
                if (annotationAction != null) {
                    if (result == null) {
                        result = annotationAction;
                    } else {
                        throw parameterError(p, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (result != null) {
                return result;
            }
            throw parameterError(p, "No Retrofit annotation found.", new Object[0]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
            if ("android.net.Uri".equals(((java.lang.Class) r12).getName()) != false) goto L_0x0043;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private retrofit2.ParameterHandler<?> parseParameterAnnotation(int r11, java.lang.reflect.Type r12, java.lang.annotation.Annotation[] r13, java.lang.annotation.Annotation r14) {
            /*
                r10 = this;
                boolean r0 = r14 instanceof retrofit2.http.Url
                java.lang.String r1 = "@Path parameters may not be used with @Url."
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x006f
                boolean r0 = r10.gotUrl
                if (r0 != 0) goto L_0x0066
                boolean r0 = r10.gotPath
                if (r0 != 0) goto L_0x005f
                boolean r0 = r10.gotQuery
                if (r0 != 0) goto L_0x0056
                java.lang.String r0 = r10.relativeUrl
                if (r0 != 0) goto L_0x0049
                r10.gotUrl = r2
                java.lang.Class<okhttp3.HttpUrl> r0 = okhttp3.HttpUrl.class
                if (r12 == r0) goto L_0x0043
                java.lang.Class<java.lang.String> r0 = java.lang.String.class
                if (r12 == r0) goto L_0x0043
                java.lang.Class<java.net.URI> r0 = java.net.URI.class
                if (r12 == r0) goto L_0x0043
                boolean r0 = r12 instanceof java.lang.Class
                if (r0 == 0) goto L_0x003a
                r0 = r12
                java.lang.Class r0 = (java.lang.Class) r0
                java.lang.String r0 = r0.getName()
                java.lang.String r1 = "android.net.Uri"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x003a
                goto L_0x0043
            L_0x003a:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x0043:
                retrofit2.ParameterHandler$RelativeUrl r0 = new retrofit2.ParameterHandler$RelativeUrl
                r0.<init>()
                return r0
            L_0x0049:
                java.lang.Object[] r0 = new java.lang.Object[r2]
                java.lang.String r1 = r10.httpMethod
                r0[r3] = r1
                java.lang.String r1 = "@Url cannot be used with @%s URL"
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x0056:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "A @Url parameter must not come after a @Query"
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x005f:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x0066:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "Multiple @Url method annotations found."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x006f:
                boolean r0 = r14 instanceof retrofit2.http.Path
                if (r0 == 0) goto L_0x00b8
                boolean r0 = r10.gotQuery
                if (r0 != 0) goto L_0x00af
                boolean r0 = r10.gotUrl
                if (r0 != 0) goto L_0x00a8
                java.lang.String r0 = r10.relativeUrl
                if (r0 == 0) goto L_0x009b
                r10.gotPath = r2
                r0 = r14
                retrofit2.http.Path r0 = (retrofit2.http.Path) r0
                java.lang.String r1 = r0.value()
                r10.validatePathName(r11, r1)
                retrofit2.Retrofit r2 = r10.retrofit
                retrofit2.Converter r2 = r2.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Path r3 = new retrofit2.ParameterHandler$Path
                boolean r4 = r0.encoded()
                r3.<init>(r1, r2, r4)
                return r3
            L_0x009b:
                java.lang.Object[] r0 = new java.lang.Object[r2]
                java.lang.String r1 = r10.httpMethod
                r0[r3] = r1
                java.lang.String r1 = "@Path can only be used with relative url on @%s"
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x00a8:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x00af:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "A @Path parameter must not come after a @Query."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x00b8:
                boolean r0 = r14 instanceof retrofit2.http.Query
                java.lang.String r1 = "<String>)"
                java.lang.String r4 = " must include generic type (e.g., "
                if (r0 == 0) goto L_0x0142
                r0 = r14
                retrofit2.http.Query r0 = (retrofit2.http.Query) r0
                java.lang.String r5 = r0.value()
                boolean r6 = r0.encoded()
                java.lang.Class r7 = retrofit2.Utils.getRawType(r12)
                r10.gotQuery = r2
                java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
                boolean r2 = r2.isAssignableFrom(r7)
                if (r2 == 0) goto L_0x0118
                boolean r2 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x00f4
                r1 = r12
                java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
                java.lang.reflect.Type r2 = retrofit2.Utils.getParameterUpperBound(r3, r1)
                retrofit2.Retrofit r3 = r10.retrofit
                retrofit2.Converter r3 = r3.stringConverter(r2, r13)
                retrofit2.ParameterHandler$Query r4 = new retrofit2.ParameterHandler$Query
                r4.<init>(r5, r3, r6)
                retrofit2.ParameterHandler r4 = r4.iterable()
                return r4
            L_0x00f4:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r7.getSimpleName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r4 = r7.getSimpleName()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r1, r2)
                throw r1
            L_0x0118:
                boolean r1 = r7.isArray()
                if (r1 == 0) goto L_0x0136
                java.lang.Class r1 = r7.getComponentType()
                java.lang.Class r1 = retrofit2.ServiceMethod.boxIfPrimitive(r1)
                retrofit2.Retrofit r2 = r10.retrofit
                retrofit2.Converter r2 = r2.stringConverter(r1, r13)
                retrofit2.ParameterHandler$Query r3 = new retrofit2.ParameterHandler$Query
                r3.<init>(r5, r2, r6)
                retrofit2.ParameterHandler r3 = r3.array()
                return r3
            L_0x0136:
                retrofit2.Retrofit r1 = r10.retrofit
                retrofit2.Converter r1 = r1.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Query r2 = new retrofit2.ParameterHandler$Query
                r2.<init>(r5, r1, r6)
                return r2
            L_0x0142:
                boolean r0 = r14 instanceof retrofit2.http.QueryName
                if (r0 == 0) goto L_0x01c4
                r0 = r14
                retrofit2.http.QueryName r0 = (retrofit2.http.QueryName) r0
                boolean r5 = r0.encoded()
                java.lang.Class r6 = retrofit2.Utils.getRawType(r12)
                r10.gotQuery = r2
                java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
                boolean r2 = r2.isAssignableFrom(r6)
                if (r2 == 0) goto L_0x019a
                boolean r2 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x0176
                r1 = r12
                java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
                java.lang.reflect.Type r2 = retrofit2.Utils.getParameterUpperBound(r3, r1)
                retrofit2.Retrofit r3 = r10.retrofit
                retrofit2.Converter r3 = r3.stringConverter(r2, r13)
                retrofit2.ParameterHandler$QueryName r4 = new retrofit2.ParameterHandler$QueryName
                r4.<init>(r3, r5)
                retrofit2.ParameterHandler r4 = r4.iterable()
                return r4
            L_0x0176:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r6.getSimpleName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r4 = r6.getSimpleName()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r1, r2)
                throw r1
            L_0x019a:
                boolean r1 = r6.isArray()
                if (r1 == 0) goto L_0x01b8
                java.lang.Class r1 = r6.getComponentType()
                java.lang.Class r1 = retrofit2.ServiceMethod.boxIfPrimitive(r1)
                retrofit2.Retrofit r2 = r10.retrofit
                retrofit2.Converter r2 = r2.stringConverter(r1, r13)
                retrofit2.ParameterHandler$QueryName r3 = new retrofit2.ParameterHandler$QueryName
                r3.<init>(r2, r5)
                retrofit2.ParameterHandler r3 = r3.array()
                return r3
            L_0x01b8:
                retrofit2.Retrofit r1 = r10.retrofit
                retrofit2.Converter r1 = r1.stringConverter(r12, r13)
                retrofit2.ParameterHandler$QueryName r2 = new retrofit2.ParameterHandler$QueryName
                r2.<init>(r1, r5)
                return r2
            L_0x01c4:
                boolean r0 = r14 instanceof retrofit2.http.QueryMap
                java.lang.String r5 = "Map must include generic types (e.g., Map<String, String>)"
                if (r0 == 0) goto L_0x022a
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0221
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r1 = retrofit2.Utils.getSupertype(r12, r0, r1)
                boolean r4 = r1 instanceof java.lang.reflect.ParameterizedType
                if (r4 == 0) goto L_0x021a
                r4 = r1
                java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
                java.lang.reflect.Type r5 = retrofit2.Utils.getParameterUpperBound(r3, r4)
                java.lang.Class<java.lang.String> r6 = java.lang.String.class
                if (r6 != r5) goto L_0x0202
                java.lang.reflect.Type r2 = retrofit2.Utils.getParameterUpperBound(r2, r4)
                retrofit2.Retrofit r3 = r10.retrofit
                retrofit2.Converter r3 = r3.stringConverter(r2, r13)
                retrofit2.ParameterHandler$QueryMap r6 = new retrofit2.ParameterHandler$QueryMap
                r7 = r14
                retrofit2.http.QueryMap r7 = (retrofit2.http.QueryMap) r7
                boolean r7 = r7.encoded()
                r6.<init>(r3, r7)
                return r6
            L_0x0202:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = "@QueryMap keys must be of type String: "
                r2.append(r6)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r2, r3)
                throw r2
            L_0x021a:
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r5, r2)
                throw r2
            L_0x0221:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.String r2 = "@QueryMap parameter type must be Map."
                java.lang.RuntimeException r1 = r10.parameterError(r11, r2, r1)
                throw r1
            L_0x022a:
                boolean r0 = r14 instanceof retrofit2.http.Header
                if (r0 == 0) goto L_0x02aa
                r0 = r14
                retrofit2.http.Header r0 = (retrofit2.http.Header) r0
                java.lang.String r2 = r0.value()
                java.lang.Class r5 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.lang.Iterable> r6 = java.lang.Iterable.class
                boolean r6 = r6.isAssignableFrom(r5)
                if (r6 == 0) goto L_0x0280
                boolean r6 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r6 == 0) goto L_0x025c
                r1 = r12
                java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
                java.lang.reflect.Type r3 = retrofit2.Utils.getParameterUpperBound(r3, r1)
                retrofit2.Retrofit r4 = r10.retrofit
                retrofit2.Converter r4 = r4.stringConverter(r3, r13)
                retrofit2.ParameterHandler$Header r6 = new retrofit2.ParameterHandler$Header
                r6.<init>(r2, r4)
                retrofit2.ParameterHandler r6 = r6.iterable()
                return r6
            L_0x025c:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = r5.getSimpleName()
                r6.append(r7)
                r6.append(r4)
                java.lang.String r4 = r5.getSimpleName()
                r6.append(r4)
                r6.append(r1)
                java.lang.String r1 = r6.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r1, r3)
                throw r1
            L_0x0280:
                boolean r1 = r5.isArray()
                if (r1 == 0) goto L_0x029e
                java.lang.Class r1 = r5.getComponentType()
                java.lang.Class r1 = retrofit2.ServiceMethod.boxIfPrimitive(r1)
                retrofit2.Retrofit r3 = r10.retrofit
                retrofit2.Converter r3 = r3.stringConverter(r1, r13)
                retrofit2.ParameterHandler$Header r4 = new retrofit2.ParameterHandler$Header
                r4.<init>(r2, r3)
                retrofit2.ParameterHandler r4 = r4.array()
                return r4
            L_0x029e:
                retrofit2.Retrofit r1 = r10.retrofit
                retrofit2.Converter r1 = r1.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Header r3 = new retrofit2.ParameterHandler$Header
                r3.<init>(r2, r1)
                return r3
            L_0x02aa:
                boolean r0 = r14 instanceof retrofit2.http.HeaderMap
                if (r0 == 0) goto L_0x0307
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x02fe
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r1 = retrofit2.Utils.getSupertype(r12, r0, r1)
                boolean r4 = r1 instanceof java.lang.reflect.ParameterizedType
                if (r4 == 0) goto L_0x02f7
                r4 = r1
                java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
                java.lang.reflect.Type r5 = retrofit2.Utils.getParameterUpperBound(r3, r4)
                java.lang.Class<java.lang.String> r6 = java.lang.String.class
                if (r6 != r5) goto L_0x02df
                java.lang.reflect.Type r2 = retrofit2.Utils.getParameterUpperBound(r2, r4)
                retrofit2.Retrofit r3 = r10.retrofit
                retrofit2.Converter r3 = r3.stringConverter(r2, r13)
                retrofit2.ParameterHandler$HeaderMap r6 = new retrofit2.ParameterHandler$HeaderMap
                r6.<init>(r3)
                return r6
            L_0x02df:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = "@HeaderMap keys must be of type String: "
                r2.append(r6)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r2, r3)
                throw r2
            L_0x02f7:
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r5, r2)
                throw r2
            L_0x02fe:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.String r2 = "@HeaderMap parameter type must be Map."
                java.lang.RuntimeException r1 = r10.parameterError(r11, r2, r1)
                throw r1
            L_0x0307:
                boolean r0 = r14 instanceof retrofit2.http.Field
                if (r0 == 0) goto L_0x039a
                boolean r0 = r10.isFormEncoded
                if (r0 == 0) goto L_0x0391
                r0 = r14
                retrofit2.http.Field r0 = (retrofit2.http.Field) r0
                java.lang.String r5 = r0.value()
                boolean r6 = r0.encoded()
                r10.gotField = r2
                java.lang.Class r2 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.lang.Iterable> r7 = java.lang.Iterable.class
                boolean r7 = r7.isAssignableFrom(r2)
                if (r7 == 0) goto L_0x0367
                boolean r7 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r7 == 0) goto L_0x0343
                r1 = r12
                java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
                java.lang.reflect.Type r3 = retrofit2.Utils.getParameterUpperBound(r3, r1)
                retrofit2.Retrofit r4 = r10.retrofit
                retrofit2.Converter r4 = r4.stringConverter(r3, r13)
                retrofit2.ParameterHandler$Field r7 = new retrofit2.ParameterHandler$Field
                r7.<init>(r5, r4, r6)
                retrofit2.ParameterHandler r7 = r7.iterable()
                return r7
            L_0x0343:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r2.getSimpleName()
                r7.append(r8)
                r7.append(r4)
                java.lang.String r4 = r2.getSimpleName()
                r7.append(r4)
                r7.append(r1)
                java.lang.String r1 = r7.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r1, r3)
                throw r1
            L_0x0367:
                boolean r1 = r2.isArray()
                if (r1 == 0) goto L_0x0385
                java.lang.Class r1 = r2.getComponentType()
                java.lang.Class r1 = retrofit2.ServiceMethod.boxIfPrimitive(r1)
                retrofit2.Retrofit r3 = r10.retrofit
                retrofit2.Converter r3 = r3.stringConverter(r1, r13)
                retrofit2.ParameterHandler$Field r4 = new retrofit2.ParameterHandler$Field
                r4.<init>(r5, r3, r6)
                retrofit2.ParameterHandler r4 = r4.array()
                return r4
            L_0x0385:
                retrofit2.Retrofit r1 = r10.retrofit
                retrofit2.Converter r1 = r1.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Field r3 = new retrofit2.ParameterHandler$Field
                r3.<init>(r5, r1, r6)
                return r3
            L_0x0391:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "@Field parameters can only be used with form encoding."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x039a:
                boolean r0 = r14 instanceof retrofit2.http.FieldMap
                if (r0 == 0) goto L_0x040d
                boolean r0 = r10.isFormEncoded
                if (r0 == 0) goto L_0x0404
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x03fb
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r1 = retrofit2.Utils.getSupertype(r12, r0, r1)
                boolean r4 = r1 instanceof java.lang.reflect.ParameterizedType
                if (r4 == 0) goto L_0x03f4
                r4 = r1
                java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
                java.lang.reflect.Type r5 = retrofit2.Utils.getParameterUpperBound(r3, r4)
                java.lang.Class<java.lang.String> r6 = java.lang.String.class
                if (r6 != r5) goto L_0x03dc
                java.lang.reflect.Type r3 = retrofit2.Utils.getParameterUpperBound(r2, r4)
                retrofit2.Retrofit r6 = r10.retrofit
                retrofit2.Converter r6 = r6.stringConverter(r3, r13)
                r10.gotField = r2
                retrofit2.ParameterHandler$FieldMap r2 = new retrofit2.ParameterHandler$FieldMap
                r7 = r14
                retrofit2.http.FieldMap r7 = (retrofit2.http.FieldMap) r7
                boolean r7 = r7.encoded()
                r2.<init>(r6, r7)
                return r2
            L_0x03dc:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = "@FieldMap keys must be of type String: "
                r2.append(r6)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r2, r3)
                throw r2
            L_0x03f4:
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r5, r2)
                throw r2
            L_0x03fb:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.String r2 = "@FieldMap parameter type must be Map."
                java.lang.RuntimeException r1 = r10.parameterError(r11, r2, r1)
                throw r1
            L_0x0404:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "@FieldMap parameters can only be used with form encoding."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x040d:
                boolean r0 = r14 instanceof retrofit2.http.Part
                if (r0 == 0) goto L_0x058f
                boolean r0 = r10.isMultipart
                if (r0 == 0) goto L_0x0586
                r0 = r14
                retrofit2.http.Part r0 = (retrofit2.http.Part) r0
                r10.gotPart = r2
                java.lang.String r5 = r0.value()
                java.lang.Class r6 = retrofit2.Utils.getRawType(r12)
                boolean r7 = r5.isEmpty()
                if (r7 == 0) goto L_0x04ad
                java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
                boolean r2 = r2.isAssignableFrom(r6)
                java.lang.String r7 = "@Part annotation must supply a name or use MultipartBody.Part parameter type."
                if (r2 == 0) goto L_0x047b
                boolean r2 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x0457
                r1 = r12
                java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
                java.lang.reflect.Type r2 = retrofit2.Utils.getParameterUpperBound(r3, r1)
                java.lang.Class<okhttp3.MultipartBody$Part> r4 = okhttp3.MultipartBody.Part.class
                java.lang.Class r8 = retrofit2.Utils.getRawType(r2)
                boolean r4 = r4.isAssignableFrom(r8)
                if (r4 == 0) goto L_0x0450
                retrofit2.ParameterHandler$RawPart r3 = retrofit2.ParameterHandler.RawPart.INSTANCE
                retrofit2.ParameterHandler r3 = r3.iterable()
                return r3
            L_0x0450:
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r3 = r10.parameterError(r11, r7, r3)
                throw r3
            L_0x0457:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r6.getSimpleName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r4 = r6.getSimpleName()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r1, r2)
                throw r1
            L_0x047b:
                boolean r1 = r6.isArray()
                if (r1 == 0) goto L_0x049b
                java.lang.Class r1 = r6.getComponentType()
                java.lang.Class<okhttp3.MultipartBody$Part> r2 = okhttp3.MultipartBody.Part.class
                boolean r2 = r2.isAssignableFrom(r1)
                if (r2 == 0) goto L_0x0494
                retrofit2.ParameterHandler$RawPart r2 = retrofit2.ParameterHandler.RawPart.INSTANCE
                retrofit2.ParameterHandler r2 = r2.array()
                return r2
            L_0x0494:
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r7, r2)
                throw r2
            L_0x049b:
                java.lang.Class<okhttp3.MultipartBody$Part> r1 = okhttp3.MultipartBody.Part.class
                boolean r1 = r1.isAssignableFrom(r6)
                if (r1 == 0) goto L_0x04a6
                retrofit2.ParameterHandler$RawPart r1 = retrofit2.ParameterHandler.RawPart.INSTANCE
                return r1
            L_0x04a6:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r7, r1)
                throw r1
            L_0x04ad:
                r7 = 4
                java.lang.String[] r7 = new java.lang.String[r7]
                java.lang.String r8 = "Content-Disposition"
                r7[r3] = r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "form-data; name=\""
                r8.append(r9)
                r8.append(r5)
                java.lang.String r9 = "\""
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7[r2] = r8
                r2 = 2
                java.lang.String r8 = "Content-Transfer-Encoding"
                r7[r2] = r8
                r2 = 3
                java.lang.String r8 = r0.encoding()
                r7[r2] = r8
                okhttp3.Headers r2 = okhttp3.Headers.m45942of(r7)
                java.lang.Class<java.lang.Iterable> r7 = java.lang.Iterable.class
                boolean r7 = r7.isAssignableFrom(r6)
                java.lang.String r8 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation."
                if (r7 == 0) goto L_0x053a
                boolean r7 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r7 == 0) goto L_0x0516
                r1 = r12
                java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
                java.lang.reflect.Type r4 = retrofit2.Utils.getParameterUpperBound(r3, r1)
                java.lang.Class<okhttp3.MultipartBody$Part> r7 = okhttp3.MultipartBody.Part.class
                java.lang.Class r9 = retrofit2.Utils.getRawType(r4)
                boolean r7 = r7.isAssignableFrom(r9)
                if (r7 != 0) goto L_0x050f
                retrofit2.Retrofit r3 = r10.retrofit
                java.lang.annotation.Annotation[] r7 = r10.methodAnnotations
                retrofit2.Converter r3 = r3.requestBodyConverter(r4, r13, r7)
                retrofit2.ParameterHandler$Part r7 = new retrofit2.ParameterHandler$Part
                r7.<init>(r2, r3)
                retrofit2.ParameterHandler r7 = r7.iterable()
                return r7
            L_0x050f:
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r3 = r10.parameterError(r11, r8, r3)
                throw r3
            L_0x0516:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r6.getSimpleName()
                r7.append(r8)
                r7.append(r4)
                java.lang.String r4 = r6.getSimpleName()
                r7.append(r4)
                r7.append(r1)
                java.lang.String r1 = r7.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r1, r3)
                throw r1
            L_0x053a:
                boolean r1 = r6.isArray()
                if (r1 == 0) goto L_0x0569
                java.lang.Class r1 = r6.getComponentType()
                java.lang.Class r1 = retrofit2.ServiceMethod.boxIfPrimitive(r1)
                java.lang.Class<okhttp3.MultipartBody$Part> r4 = okhttp3.MultipartBody.Part.class
                boolean r4 = r4.isAssignableFrom(r1)
                if (r4 != 0) goto L_0x0562
                retrofit2.Retrofit r3 = r10.retrofit
                java.lang.annotation.Annotation[] r4 = r10.methodAnnotations
                retrofit2.Converter r3 = r3.requestBodyConverter(r1, r13, r4)
                retrofit2.ParameterHandler$Part r4 = new retrofit2.ParameterHandler$Part
                r4.<init>(r2, r3)
                retrofit2.ParameterHandler r4 = r4.array()
                return r4
            L_0x0562:
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r3 = r10.parameterError(r11, r8, r3)
                throw r3
            L_0x0569:
                java.lang.Class<okhttp3.MultipartBody$Part> r1 = okhttp3.MultipartBody.Part.class
                boolean r1 = r1.isAssignableFrom(r6)
                if (r1 != 0) goto L_0x057f
                retrofit2.Retrofit r1 = r10.retrofit
                java.lang.annotation.Annotation[] r3 = r10.methodAnnotations
                retrofit2.Converter r1 = r1.requestBodyConverter(r12, r13, r3)
                retrofit2.ParameterHandler$Part r3 = new retrofit2.ParameterHandler$Part
                r3.<init>(r2, r1)
                return r3
            L_0x057f:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.RuntimeException r1 = r10.parameterError(r11, r8, r1)
                throw r1
            L_0x0586:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "@Part parameters can only be used with multipart encoding."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x058f:
                boolean r0 = r14 instanceof retrofit2.http.PartMap
                if (r0 == 0) goto L_0x0619
                boolean r0 = r10.isMultipart
                if (r0 == 0) goto L_0x0610
                r10.gotPart = r2
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0607
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r1 = retrofit2.Utils.getSupertype(r12, r0, r1)
                boolean r4 = r1 instanceof java.lang.reflect.ParameterizedType
                if (r4 == 0) goto L_0x0600
                r4 = r1
                java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
                java.lang.reflect.Type r5 = retrofit2.Utils.getParameterUpperBound(r3, r4)
                java.lang.Class<java.lang.String> r6 = java.lang.String.class
                if (r6 != r5) goto L_0x05e8
                java.lang.reflect.Type r2 = retrofit2.Utils.getParameterUpperBound(r2, r4)
                java.lang.Class<okhttp3.MultipartBody$Part> r6 = okhttp3.MultipartBody.Part.class
                java.lang.Class r7 = retrofit2.Utils.getRawType(r2)
                boolean r6 = r6.isAssignableFrom(r7)
                if (r6 != 0) goto L_0x05df
                retrofit2.Retrofit r3 = r10.retrofit
                java.lang.annotation.Annotation[] r6 = r10.methodAnnotations
                retrofit2.Converter r3 = r3.requestBodyConverter(r2, r13, r6)
                r6 = r14
                retrofit2.http.PartMap r6 = (retrofit2.http.PartMap) r6
                retrofit2.ParameterHandler$PartMap r7 = new retrofit2.ParameterHandler$PartMap
                java.lang.String r8 = r6.encoding()
                r7.<init>(r3, r8)
                return r7
            L_0x05df:
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r6 = "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead."
                java.lang.RuntimeException r3 = r10.parameterError(r11, r6, r3)
                throw r3
            L_0x05e8:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = "@PartMap keys must be of type String: "
                r2.append(r6)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r2, r3)
                throw r2
            L_0x0600:
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.RuntimeException r2 = r10.parameterError(r11, r5, r2)
                throw r2
            L_0x0607:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.String r2 = "@PartMap parameter type must be Map."
                java.lang.RuntimeException r1 = r10.parameterError(r11, r2, r1)
                throw r1
            L_0x0610:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "@PartMap parameters can only be used with multipart encoding."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x0619:
                boolean r0 = r14 instanceof retrofit2.http.Body
                if (r0 == 0) goto L_0x0658
                boolean r0 = r10.isFormEncoded
                if (r0 != 0) goto L_0x064f
                boolean r0 = r10.isMultipart
                if (r0 != 0) goto L_0x064f
                boolean r0 = r10.gotBody
                if (r0 != 0) goto L_0x0646
                retrofit2.Retrofit r0 = r10.retrofit     // Catch:{ RuntimeException -> 0x063a }
                java.lang.annotation.Annotation[] r1 = r10.methodAnnotations     // Catch:{ RuntimeException -> 0x063a }
                retrofit2.Converter r0 = r0.requestBodyConverter(r12, r13, r1)     // Catch:{ RuntimeException -> 0x063a }
                r10.gotBody = r2
                retrofit2.ParameterHandler$Body r1 = new retrofit2.ParameterHandler$Body
                r1.<init>(r0)
                return r1
            L_0x063a:
                r0 = move-exception
                java.lang.Object[] r1 = new java.lang.Object[r2]
                r1[r3] = r12
                java.lang.String r2 = "Unable to create @Body converter for %s"
                java.lang.RuntimeException r1 = r10.parameterError(r0, r11, r2, r1)
                throw r1
            L_0x0646:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "Multiple @Body method annotations found."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x064f:
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "@Body parameters cannot be used with form or multi-part encoding."
                java.lang.RuntimeException r0 = r10.parameterError(r11, r1, r0)
                throw r0
            L_0x0658:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.Builder.parseParameterAnnotation(int, java.lang.reflect.Type, java.lang.annotation.Annotation[], java.lang.annotation.Annotation):retrofit2.ParameterHandler");
        }

        private void validatePathName(int p, String name) {
            if (!ServiceMethod.PARAM_NAME_REGEX.matcher(name).matches()) {
                throw parameterError(p, "@Path parameter name must match %s. Found: %s", ServiceMethod.PARAM_URL_REGEX.pattern(), name);
            } else if (!this.relativeUrlParamNames.contains(name)) {
                throw parameterError(p, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, name);
            }
        }

        private Converter<ResponseBody, T> createResponseConverter() {
            try {
                return this.retrofit.responseBodyConverter(this.responseType, this.method.getAnnotations());
            } catch (RuntimeException e) {
                throw methodError(e, "Unable to create converter for %s", this.responseType);
            }
        }

        private RuntimeException methodError(String message, Object... args) {
            return methodError(null, message, args);
        }

        private RuntimeException methodError(Throwable cause, String message, Object... args) {
            String message2 = String.format(message, args);
            StringBuilder sb = new StringBuilder();
            sb.append(message2);
            sb.append("\n    for method ");
            sb.append(this.method.getDeclaringClass().getSimpleName());
            sb.append(".");
            sb.append(this.method.getName());
            return new IllegalArgumentException(sb.toString(), cause);
        }

        private RuntimeException parameterError(Throwable cause, int p, String message, Object... args) {
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(" (parameter #");
            sb.append(p + 1);
            sb.append(")");
            return methodError(cause, sb.toString(), args);
        }

        private RuntimeException parameterError(int p, String message, Object... args) {
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(" (parameter #");
            sb.append(p + 1);
            sb.append(")");
            return methodError(sb.toString(), args);
        }
    }

    ServiceMethod(Builder<R, T> builder) {
        this.callFactory = builder.retrofit.callFactory();
        this.callAdapter = builder.callAdapter;
        this.baseUrl = builder.retrofit.baseUrl();
        this.responseConverter = builder.responseConverter;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
    }

    /* access modifiers changed from: 0000 */
    public Call toCall(Object... args) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int argumentCount = args != null ? args.length : 0;
        if (argumentCount == parameterHandlerArr.length) {
            for (int p = 0; p < argumentCount; p++) {
                parameterHandlerArr[p].apply(requestBuilder, args[p]);
            }
            return this.callFactory.newCall(requestBuilder.build());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(argumentCount);
        sb.append(") doesn't match expected count (");
        sb.append(parameterHandlerArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public T adapt(Call<R> call) {
        return this.callAdapter.adapt(call);
    }

    /* access modifiers changed from: 0000 */
    public R toResponse(ResponseBody body) throws IOException {
        return this.responseConverter.convert(body);
    }

    static Set<String> parsePathParameters(String path) {
        Matcher m = PARAM_URL_REGEX.matcher(path);
        Set<String> patterns = new LinkedHashSet<>();
        while (m.find()) {
            patterns.add(m.group(1));
        }
        return patterns;
    }

    static Class<?> boxIfPrimitive(Class<?> type) {
        if (Boolean.TYPE == type) {
            return Boolean.class;
        }
        if (Byte.TYPE == type) {
            return Byte.class;
        }
        if (Character.TYPE == type) {
            return Character.class;
        }
        if (Double.TYPE == type) {
            return Double.class;
        }
        if (Float.TYPE == type) {
            return Float.class;
        }
        if (Integer.TYPE == type) {
            return Integer.class;
        }
        if (Long.TYPE == type) {
            return Long.class;
        }
        if (Short.TYPE == type) {
            return Short.class;
        }
        return type;
    }
}
