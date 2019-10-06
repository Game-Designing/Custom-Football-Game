package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.SignatureRemover */
public class SignatureRemover {
    private static final String DIGEST_SUFFIX = "-Digest";
    private static final String MANIFEST_MF = "META-INF/MANIFEST.MF";
    private static final Pattern SIGNATURE_FILES = Pattern.compile("META-INF/[^/]*\\.SF|META-INF/[^/]*\\.DSA|META-INF/[^/]*\\.RSA|META-INF/SIG-[^/]*");
    private boolean active = true;

    public void setActive(boolean active2) {
        this.active = active2;
    }

    public boolean removeEntry(String name) {
        return this.active && SIGNATURE_FILES.matcher(name).matches();
    }

    public boolean filterEntry(String name, InputStream in, OutputStream out) throws IOException {
        if (!this.active || !MANIFEST_MF.equals(name)) {
            return false;
        }
        Manifest mf = new Manifest(in);
        filterManifestEntry(mf.getEntries().values());
        mf.write(out);
        return true;
    }

    private void filterManifestEntry(Collection<Attributes> entry) {
        Iterator<Attributes> i = entry.iterator();
        while (i.hasNext()) {
            Attributes attributes = (Attributes) i.next();
            filterManifestEntryAttributes(attributes);
            if (attributes.isEmpty()) {
                i.remove();
            }
        }
    }

    private void filterManifestEntryAttributes(Attributes attrs) {
        Iterator<Object> i = attrs.keySet().iterator();
        while (i.hasNext()) {
            if (String.valueOf(i.next()).endsWith(DIGEST_SUFFIX)) {
                i.remove();
            }
        }
    }
}
