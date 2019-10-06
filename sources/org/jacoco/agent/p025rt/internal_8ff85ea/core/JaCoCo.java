package org.jacoco.agent.p025rt.internal_8ff85ea.core;

import java.util.ResourceBundle;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.JaCoCo */
public final class JaCoCo {
    public static final String HOMEURL;
    public static final String RUNTIMEPACKAGE;
    public static final String VERSION;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("org.jacoco.agent.rt.internal_8ff85ea.core.jacoco");
        VERSION = bundle.getString("VERSION");
        HOMEURL = bundle.getString("HOMEURL");
        RUNTIMEPACKAGE = bundle.getString("RUNTIMEPACKAGE");
    }

    private JaCoCo() {
    }
}
