package retrofit2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class JacksonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final ObjectReader adapter;

    JacksonResponseBodyConverter(ObjectReader adapter2) {
        this.adapter = adapter2;
    }

    public T convert(ResponseBody value) throws IOException {
        try {
            return this.adapter.readValue(value.charStream());
        } finally {
            value.close();
        }
    }
}
