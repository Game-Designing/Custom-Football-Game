package com.fasterxml.jackson.core.p134io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

/* renamed from: com.fasterxml.jackson.core.io.CharacterEscapes */
public abstract class CharacterEscapes implements Serializable {
    public abstract int[] getEscapeCodesForAscii();

    public abstract SerializableString getEscapeSequence(int i);
}
