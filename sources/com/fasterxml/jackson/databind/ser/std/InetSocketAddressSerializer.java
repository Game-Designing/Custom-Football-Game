package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    public void serialize(InetSocketAddress value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        String str;
        InetAddress addr = value.getAddress();
        String str2 = addr == null ? value.getHostName() : addr.toString().trim();
        int ix = str2.indexOf(47);
        if (ix >= 0) {
            if (ix == 0) {
                if (addr instanceof Inet6Address) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    sb.append(str2.substring(1));
                    sb.append("]");
                    str = sb.toString();
                } else {
                    str = str2.substring(1);
                }
                str2 = str;
            } else {
                str2 = str2.substring(0, ix);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(":");
        sb2.append(value.getPort());
        jgen.writeString(sb2.toString());
    }

    public void serializeWithType(InetSocketAddress value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId((Object) value, InetSocketAddress.class, JsonToken.VALUE_STRING));
        serialize(value, g, provider);
        typeSer.writeTypeSuffix(g, typeIdDef);
    }
}
