package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.aa */
/* compiled from: TypeAdapters */
class C10096aa extends C10054C<T1> {

    /* renamed from: a */
    final /* synthetic */ Class f30669a;

    /* renamed from: b */
    final /* synthetic */ C10098ba f30670b;

    C10096aa(C10098ba this$0, Class cls) {
        this.f30670b = this$0;
        this.f30669a = cls;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, T1 value) throws IOException {
        this.f30670b.f30675b.mo33198a(out, value);
    }

    /* renamed from: a */
    public T1 mo33197a(JsonReader in) throws IOException {
        T1 result = this.f30670b.f30675b.mo33197a(in);
        if (result == null || this.f30669a.isInstance(result)) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a ");
        sb.append(this.f30669a.getName());
        sb.append(" but was ");
        sb.append(result.getClass().getName());
        throw new JsonSyntaxException(sb.toString());
    }
}
