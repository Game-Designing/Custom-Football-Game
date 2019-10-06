package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class InternCache extends ConcurrentHashMap<String, String> {
    public static final InternCache instance = new InternCache();
    private final Object lock = new Object();

    private InternCache() {
        super(Opcodes.GETFIELD, 0.8f, 4);
    }

    public String intern(String input) {
        String result = (String) get(input);
        if (result != null) {
            return result;
        }
        if (size() >= 180) {
            synchronized (this.lock) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String result2 = input.intern();
        put(result2, result2);
        return result2;
    }
}
