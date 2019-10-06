package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.Headers;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;

        Body(Converter<T, RequestBody> converter2) {
            this.converter = converter2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) {
            if (value != null) {
                try {
                    builder.setBody((RequestBody) this.converter.convert(value));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(value);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Field(String name2, Converter<T, String> valueConverter2, boolean encoded2) {
            Utils.checkNotNull(name2, "name == null");
            this.name = name2;
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) throws IOException {
            if (value != null) {
                String fieldValue = (String) this.valueConverter.convert(value);
                if (fieldValue != null) {
                    builder.addFormField(this.name, fieldValue, this.encoded);
                }
            }
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Converter<T, String> valueConverter;

        FieldMap(Converter<T, String> valueConverter2, boolean encoded2) {
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, Map<String, T> value) throws IOException {
            if (value != null) {
                for (Entry<String, T> entry : value.entrySet()) {
                    String entryKey = (String) entry.getKey();
                    if (entryKey != null) {
                        T entryValue = entry.getValue();
                        String str = "'.";
                        if (entryValue != null) {
                            String fieldEntry = (String) this.valueConverter.convert(entryValue);
                            if (fieldEntry != null) {
                                builder.addFormField(entryKey, fieldEntry, this.encoded);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Field map value '");
                                sb.append(entryValue);
                                sb.append("' converted to null by ");
                                sb.append(this.valueConverter.getClass().getName());
                                sb.append(" for key '");
                                sb.append(entryKey);
                                sb.append(str);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Field map contained null value for key '");
                            sb2.append(entryKey);
                            sb2.append(str);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Header(String name2, Converter<T, String> valueConverter2) {
            Utils.checkNotNull(name2, "name == null");
            this.name = name2;
            this.valueConverter = valueConverter2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) throws IOException {
            if (value != null) {
                String headerValue = (String) this.valueConverter.convert(value);
                if (headerValue != null) {
                    builder.addHeader(this.name, headerValue);
                }
            }
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> valueConverter;

        HeaderMap(Converter<T, String> valueConverter2) {
            this.valueConverter = valueConverter2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, Map<String, T> value) throws IOException {
            if (value != null) {
                for (Entry<String, T> entry : value.entrySet()) {
                    String headerName = (String) entry.getKey();
                    if (headerName != null) {
                        T headerValue = entry.getValue();
                        if (headerValue != null) {
                            builder.addHeader(headerName, (String) this.valueConverter.convert(headerValue));
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Header map contained null value for key '");
                            sb.append(headerName);
                            sb.append("'.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Headers headers;

        Part(Headers headers2, Converter<T, RequestBody> converter2) {
            this.headers = headers2;
            this.converter = converter2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) {
            if (value != null) {
                try {
                    builder.addPart(this.headers, (RequestBody) this.converter.convert(value));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(value);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e);
                }
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        PartMap(Converter<T, RequestBody> valueConverter2, String transferEncoding2) {
            this.valueConverter = valueConverter2;
            this.transferEncoding = transferEncoding2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, Map<String, T> value) throws IOException {
            if (value != null) {
                for (Entry<String, T> entry : value.entrySet()) {
                    String entryKey = (String) entry.getKey();
                    if (entryKey != null) {
                        T entryValue = entry.getValue();
                        if (entryValue != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("form-data; name=\"");
                            sb.append(entryKey);
                            sb.append("\"");
                            builder.addPart(Headers.m45942of("Content-Disposition", sb.toString(), "Content-Transfer-Encoding", this.transferEncoding), (RequestBody) this.valueConverter.convert(entryValue));
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Part map contained null value for key '");
                            sb2.append(entryKey);
                            sb2.append("'.");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Path(String name2, Converter<T, String> valueConverter2, boolean encoded2) {
            Utils.checkNotNull(name2, "name == null");
            this.name = name2;
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) throws IOException {
            if (value != null) {
                builder.addPathParam(this.name, (String) this.valueConverter.convert(value), this.encoded);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Path parameter \"");
            sb.append(this.name);
            sb.append("\" value must not be null.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Query(String name2, Converter<T, String> valueConverter2, boolean encoded2) {
            Utils.checkNotNull(name2, "name == null");
            this.name = name2;
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) throws IOException {
            if (value != null) {
                String queryValue = (String) this.valueConverter.convert(value);
                if (queryValue != null) {
                    builder.addQueryParam(this.name, queryValue, this.encoded);
                }
            }
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Converter<T, String> valueConverter;

        QueryMap(Converter<T, String> valueConverter2, boolean encoded2) {
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, Map<String, T> value) throws IOException {
            if (value != null) {
                for (Entry<String, T> entry : value.entrySet()) {
                    String entryKey = (String) entry.getKey();
                    if (entryKey != null) {
                        T entryValue = entry.getValue();
                        String str = "'.";
                        if (entryValue != null) {
                            String convertedEntryValue = (String) this.valueConverter.convert(entryValue);
                            if (convertedEntryValue != null) {
                                builder.addQueryParam(entryKey, convertedEntryValue, this.encoded);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Query map value '");
                                sb.append(entryValue);
                                sb.append("' converted to null by ");
                                sb.append(this.valueConverter.getClass().getName());
                                sb.append(" for key '");
                                sb.append(entryKey);
                                sb.append(str);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Query map contained null value for key '");
                            sb2.append(entryKey);
                            sb2.append(str);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        QueryName(Converter<T, String> nameConverter2, boolean encoded2) {
            this.nameConverter = nameConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, T value) throws IOException {
            if (value != null) {
                builder.addQueryParam((String) this.nameConverter.convert(value), null, this.encoded);
            }
        }
    }

    static final class RawPart extends ParameterHandler<okhttp3.MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, okhttp3.MultipartBody.Part value) {
            if (value != null) {
                builder.addPart(value);
            }
        }
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        RelativeUrl() {
        }

        /* access modifiers changed from: 0000 */
        public void apply(RequestBuilder builder, Object value) {
            Utils.checkNotNull(value, "@Url parameter is null.");
            builder.setRelativeUrl(value);
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;

    ParameterHandler() {
    }

    /* access modifiers changed from: 0000 */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            /* access modifiers changed from: 0000 */
            public void apply(RequestBuilder builder, Iterable<T> values) throws IOException {
                if (values != null) {
                    for (T value : values) {
                        ParameterHandler.this.apply(builder, value);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            /* access modifiers changed from: 0000 */
            public void apply(RequestBuilder builder, Object values) throws IOException {
                if (values != null) {
                    int size = Array.getLength(values);
                    for (int i = 0; i < size; i++) {
                        ParameterHandler.this.apply(builder, Array.get(values, i));
                    }
                }
            }
        };
    }
}
