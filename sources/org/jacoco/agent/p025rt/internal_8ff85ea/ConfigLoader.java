package org.jacoco.agent.p025rt.internal_8ff85ea;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.ConfigLoader */
final class ConfigLoader {
    private static final Pattern SUBST_PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
    private static final String SYS_PREFIX = "jacoco-agent.";

    static Properties load(String resource, Properties system) {
        Properties result = new Properties();
        loadResource(resource, result);
        loadSystemProperties(system, result);
        substSystemProperties(result, system);
        return result;
    }

    private static void loadResource(String resource, Properties result) {
        InputStream file = Offline.class.getResourceAsStream(resource);
        if (file != null) {
            try {
                result.load(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void loadSystemProperties(Properties system, Properties result) {
        for (Entry<Object, Object> entry : system.entrySet()) {
            String keystr = entry.getKey().toString();
            String str = SYS_PREFIX;
            if (keystr.startsWith(str)) {
                result.put(keystr.substring(str.length()), entry.getValue());
            }
        }
    }

    private static void substSystemProperties(Properties result, Properties system) {
        for (Entry<Object, Object> entry : result.entrySet()) {
            String oldValue = (String) entry.getValue();
            StringBuilder newValue = new StringBuilder();
            Matcher m = SUBST_PATTERN.matcher(oldValue);
            int pos = 0;
            while (m.find()) {
                newValue.append(oldValue.substring(pos, m.start()));
                String sub = system.getProperty(m.group(1));
                newValue.append(sub == null ? m.group(0) : sub);
                pos = m.end();
            }
            newValue.append(oldValue.substring(pos));
            entry.setValue(newValue.toString());
        }
    }

    private ConfigLoader() {
    }
}
