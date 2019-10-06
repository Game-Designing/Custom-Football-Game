package p019d.p135a.p136a.p142e;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.a.a.e.k */
/* compiled from: Util */
public final class C6913k {
    /* renamed from: a */
    public static JSONObject m14062a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        try {
            for (Entry<String, Object> entry : map.entrySet()) {
                jsonObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /* renamed from: a */
    public static byte[] m14063a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] byteArrayBuffer = new byte[512];
        while (true) {
            int read = inputStream.read(byteArrayBuffer);
            int nRead = read;
            if (read == -1) {
                return output.toByteArray();
            }
            output.write(byteArrayBuffer, 0, nRead);
        }
    }
}
