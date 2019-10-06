package com.vungle.warren.persistence;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MemoryUtils {
    @Deprecated
    public static void writeString(String s, ByteArrayOutputStream out) throws IOException {
        if (s == null) {
            out.write(toBytes(0));
            return;
        }
        byte[] bytes = s.getBytes();
        out.write(toBytes(bytes.length));
        out.write(bytes);
    }

    public static <T> void write(T value, ByteArrayOutputStream out) throws IOException {
        byte[] bytes;
        if (value == null) {
            out.write(toBytes(0));
            return;
        }
        if (value instanceof String) {
            bytes = ((String) value).getBytes();
        } else {
            String str = "Value type not supported!";
            if (value instanceof Number) {
                if (value instanceof Integer) {
                    bytes = toBytes(((Integer) value).intValue());
                } else if (value instanceof Long) {
                    bytes = toBytes(((Long) value).longValue());
                } else {
                    throw new IllegalArgumentException(str);
                }
            } else if (value instanceof Boolean) {
                bytes = new byte[]{((Boolean) value).booleanValue() ? (byte) 1 : 0};
            } else {
                throw new IllegalArgumentException(str);
            }
        }
        out.write(toBytes(bytes.length));
        out.write(bytes);
    }

    public static String extractString(ByteBuffer buffy) {
        int byteCount = buffy.getInt();
        if (byteCount == 0) {
            return "";
        }
        byte[] stringBytes = new byte[byteCount];
        buffy.get(stringBytes);
        return new String(stringBytes);
    }

    public static <T> T extract(ByteBuffer buffy, Class<T> clazz) {
        int byteCount = buffy.getInt();
        if (byteCount == 0) {
            if (clazz == String.class) {
                return "";
            }
            return null;
        } else if (clazz == String.class) {
            byte[] valueBytes = new byte[byteCount];
            buffy.get(valueBytes);
            return new String(valueBytes);
        } else if (clazz == Integer.class) {
            return Integer.valueOf(buffy.getInt());
        } else {
            if (clazz == Long.class) {
                return Long.valueOf(buffy.getLong());
            }
            if (clazz == Boolean.class) {
                boolean z = true;
                if (buffy.get() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Class type ");
            sb.append(clazz.getCanonicalName());
            sb.append(" not supported!");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void writeStringArray(String[] strings, ByteArrayOutputStream out) throws IOException {
        out.write(toBytes(strings.length));
        for (String s : strings) {
            writeString(s, out);
        }
    }

    public static <T> void writeArray(T[] values, ByteArrayOutputStream out) throws IOException {
        out.write(toBytes(values.length));
        for (T t : values) {
            write(t, out);
        }
    }

    public static String[] extractStringArray(ByteBuffer buffer) {
        int stringCount = buffer.getInt();
        String[] result = new String[stringCount];
        for (int x = 0; x < stringCount; x++) {
            result[x] = extractString(buffer);
        }
        return result;
    }

    public static <T> T[] extractArray(ByteBuffer buffy, Class<T> clazz) {
        int count = buffy.getInt();
        T[] result = (Object[]) Array.newInstance(clazz, count);
        for (int x = 0; x < count; x++) {
            result[x] = extract(buffy, clazz);
        }
        return result;
    }

    public static void writeStringMap(Map<String, String> map, ByteArrayOutputStream out) throws IOException {
        int entryCount = map.size();
        String[] keys = new String[entryCount];
        String[] values = new String[entryCount];
        int x = 0;
        for (Entry<String, String> entry : map.entrySet()) {
            keys[x] = (String) entry.getKey();
            values[x] = (String) entry.getValue();
            x++;
        }
        writeStringArray(keys, out);
        writeStringArray(values, out);
    }

    public static <T> void writeMap(Map<String, T> map, ByteArrayOutputStream out) throws IOException {
        int entryCount = map.size();
        String[] keys = new String[entryCount];
        T[] values = null;
        int x = 0;
        for (Entry<String, T> entry : map.entrySet()) {
            keys[x] = (String) entry.getKey();
            if (values == null) {
                values = (Object[]) Array.newInstance(entry.getValue().getClass(), entryCount);
            }
            values[x] = entry.getValue();
            x++;
        }
        writeArray(keys, out);
        writeArray(values != null ? values : new Object[0], out);
    }

    public static Map<String, String> extractStringMap(ByteBuffer buffy) {
        String[] keys = extractStringArray(buffy);
        String[] values = extractStringArray(buffy);
        Map<String, String> ret = new HashMap<>(keys.length);
        for (int x = 0; x < keys.length; x++) {
            ret.put(keys[x], values[x]);
        }
        return ret;
    }

    public static <T> Map<String, T> extractMap(ByteBuffer buffy, Class<T> clazz) {
        String[] keys = (String[]) extractArray(buffy, String.class);
        T[] values = extractArray(buffy, clazz);
        Map<String, T> ret = new HashMap<>(keys.length);
        for (int x = 0; x < keys.length; x++) {
            ret.put(keys[x], values[x]);
        }
        return ret;
    }

    public static <T extends Memorable> void writeMemorable(T memorable, ByteArrayOutputStream out) throws IOException {
        if (memorable == null) {
            out.write(toBytes(0));
            return;
        }
        byte[] bytes = memorable.toByteArray();
        out.write(toBytes(bytes.length));
        out.write(bytes);
    }

    public static <T extends Memorable> T extractMemorable(ByteBuffer buffy, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int byteCount = buffy.getInt();
        if (byteCount == 0) {
            return null;
        }
        byte[] bytes = new byte[byteCount];
        buffy.get(bytes);
        return (Memorable) clazz.getDeclaredConstructor(new Class[]{byte[].class}).newInstance(new Object[]{bytes});
    }

    public static byte[] toBytes(int value) {
        return new byte[]{(byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value};
    }

    public static byte[] toBytes(long value) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) ((int) (255 & value));
            value >>= 8;
        }
        return result;
    }
}
