package retrofit2.converter.gson;

import com.google.gson.C10054C;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final C10054C<T> adapter;
    private final Gson gson;

    GsonResponseBodyConverter(Gson gson2, C10054C<T> adapter2) {
        this.gson = gson2;
        this.adapter = adapter2;
    }

    public T convert(ResponseBody value) throws IOException {
        try {
            return this.adapter.mo33197a(this.gson.newJsonReader(value.charStream()));
        } finally {
            value.close();
        }
    }
}
