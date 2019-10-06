package com.google.gson.p192b;

import com.google.gson.C10188s;
import com.google.gson.C10190t;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.p192b.p193a.C10118ka;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.gson.b.B */
/* compiled from: Streams */
public final class C10060B {

    /* renamed from: com.google.gson.b.B$a */
    /* compiled from: Streams */
    private static final class C10061a extends Writer {

        /* renamed from: a */
        private final Appendable f30648a;

        /* renamed from: b */
        private final C10062a f30649b = new C10062a();

        /* renamed from: com.google.gson.b.B$a$a */
        /* compiled from: Streams */
        static class C10062a implements CharSequence {

            /* renamed from: a */
            char[] f30650a;

            C10062a() {
            }

            public int length() {
                return this.f30650a.length;
            }

            public char charAt(int i) {
                return this.f30650a[i];
            }

            public CharSequence subSequence(int start, int end) {
                return new String(this.f30650a, start, end - start);
            }
        }

        C10061a(Appendable appendable) {
            this.f30648a = appendable;
        }

        public void write(char[] chars, int offset, int length) throws IOException {
            C10062a aVar = this.f30649b;
            aVar.f30650a = chars;
            this.f30648a.append(aVar, offset, offset + length);
        }

        public void write(int i) throws IOException {
            this.f30648a.append((char) i);
        }

        public void flush() {
        }

        public void close() {
        }
    }

    /* renamed from: a */
    public static C10188s m32832a(JsonReader reader) throws JsonParseException {
        boolean isEmpty = true;
        try {
            reader.peek();
            isEmpty = false;
            return (C10188s) C10118ka.f30719X.mo33197a(reader);
        } catch (EOFException e) {
            if (isEmpty) {
                return C10190t.f30874a;
            }
            throw new JsonSyntaxException((Throwable) e);
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        } catch (IOException e3) {
            throw new JsonIOException((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException((Throwable) e4);
        }
    }

    /* renamed from: a */
    public static void m32834a(C10188s element, JsonWriter writer) throws IOException {
        C10118ka.f30719X.mo33198a(writer, element);
    }

    /* renamed from: a */
    public static Writer m32833a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C10061a(appendable);
    }
}
