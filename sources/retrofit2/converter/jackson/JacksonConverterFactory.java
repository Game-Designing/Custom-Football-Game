package retrofit2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class JacksonConverterFactory extends Factory {
    private final ObjectMapper mapper;

    public static JacksonConverterFactory create() {
        return create(new ObjectMapper());
    }

    public static JacksonConverterFactory create(ObjectMapper mapper2) {
        if (mapper2 != null) {
            return new JacksonConverterFactory(mapper2);
        }
        throw new NullPointerException("mapper == null");
    }

    private JacksonConverterFactory(ObjectMapper mapper2) {
        this.mapper = mapper2;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new JacksonResponseBodyConverter(this.mapper.readerFor(this.mapper.getTypeFactory().constructType(type)));
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JacksonRequestBodyConverter(this.mapper.writerFor(this.mapper.getTypeFactory().constructType(type)));
    }
}
