package com.google.android.exoplayer2.upstream.cache;

import com.mopub.common.Constants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.exoplayer2.upstream.cache.l */
/* compiled from: DefaultContentMetadata */
public final class C8476l implements C8473i {

    /* renamed from: a */
    public static final C8476l f18691a = new C8476l(Collections.emptyMap());

    /* renamed from: b */
    private int f18692b;

    /* renamed from: c */
    private final Map<String, byte[]> f18693c;

    /* renamed from: a */
    public static C8476l m20268a(DataInputStream input) throws IOException {
        int size = input.readInt();
        HashMap<String, byte[]> metadata = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String name = input.readUTF();
            int valueSize = input.readInt();
            if (valueSize < 0 || valueSize > 10485760) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid value size: ");
                sb.append(valueSize);
                throw new IOException(sb.toString());
            }
            byte[] value = new byte[valueSize];
            input.readFully(value);
            metadata.put(name, value);
        }
        return new C8476l(metadata);
    }

    private C8476l(Map<String, byte[]> metadata) {
        this.f18693c = Collections.unmodifiableMap(metadata);
    }

    /* renamed from: a */
    public C8476l mo25996a(C8475k mutations) {
        Map<String, byte[]> mutatedMetadata = m20269a(this.f18693c, mutations);
        if (m20272a(mutatedMetadata)) {
            return this;
        }
        return new C8476l(mutatedMetadata);
    }

    /* renamed from: a */
    public void mo25997a(DataOutputStream output) throws IOException {
        output.writeInt(this.f18693c.size());
        for (Entry<String, byte[]> entry : this.f18693c.entrySet()) {
            output.writeUTF((String) entry.getKey());
            byte[] value = (byte[]) entry.getValue();
            output.writeInt(value.length);
            output.write(value);
        }
    }

    /* renamed from: a */
    public final String mo25990a(String name, String defaultValue) {
        if (this.f18693c.containsKey(name)) {
            return new String((byte[]) this.f18693c.get(name), Charset.forName("UTF-8"));
        }
        return defaultValue;
    }

    /* renamed from: a */
    public final long mo25989a(String name, long defaultValue) {
        if (this.f18693c.containsKey(name)) {
            return ByteBuffer.wrap((byte[]) this.f18693c.get(name)).getLong();
        }
        return defaultValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return m20272a(((C8476l) o).f18693c);
    }

    /* renamed from: a */
    private boolean m20272a(Map<String, byte[]> otherMetadata) {
        if (this.f18693c.size() != otherMetadata.size()) {
            return false;
        }
        for (Entry<String, byte[]> entry : this.f18693c.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) otherMetadata.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.f18692b == 0) {
            int result = 0;
            for (Entry<String, byte[]> entry : this.f18693c.entrySet()) {
                result += ((String) entry.getKey()).hashCode() ^ Arrays.hashCode((byte[]) entry.getValue());
            }
            this.f18692b = result;
        }
        return this.f18692b;
    }

    /* renamed from: a */
    private static Map<String, byte[]> m20269a(Map<String, byte[]> otherMetadata, C8475k mutations) {
        HashMap<String, byte[]> metadata = new HashMap<>(otherMetadata);
        m20270a(metadata, mutations.mo25995b());
        m20271a(metadata, mutations.mo25994a());
        return metadata;
    }

    /* renamed from: a */
    private static void m20270a(HashMap<String, byte[]> metadata, List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            metadata.remove(names.get(i));
        }
    }

    /* renamed from: a */
    private static void m20271a(HashMap<String, byte[]> metadata, Map<String, Object> values) {
        for (String name : values.keySet()) {
            byte[] bytes = m20273a(values.get(name));
            if (bytes.length <= 10485760) {
                metadata.put(name, bytes);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("The size of ");
                sb.append(name);
                sb.append(" (");
                sb.append(bytes.length);
                sb.append(") is greater than maximum allowed: ");
                sb.append(Constants.TEN_MB);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* renamed from: a */
    private static byte[] m20273a(Object value) {
        if (value instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) value).longValue()).array();
        }
        if (value instanceof String) {
            return ((String) value).getBytes(Charset.forName("UTF-8"));
        }
        if (value instanceof byte[]) {
            return (byte[]) value;
        }
        throw new IllegalArgumentException();
    }
}
