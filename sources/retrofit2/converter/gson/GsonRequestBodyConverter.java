package retrofit2.converter.gson;

import com.google.gson.C10054C;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p362h.C14191g;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final C10054C<T> adapter;
    private final Gson gson;

    GsonRequestBodyConverter(Gson gson2, C10054C<T> adapter2) {
        this.gson = gson2;
        this.adapter = adapter2;
    }

    public RequestBody convert(T value) throws IOException {
        C14191g buffer = new C14191g();
        JsonWriter jsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(buffer.mo44222c(), UTF_8));
        this.adapter.mo33198a(jsonWriter, value);
        jsonWriter.close();
        return RequestBody.create(MEDIA_TYPE, buffer.mo44225d());
    }
}
