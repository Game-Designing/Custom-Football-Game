package org.jacoco.agent.p025rt.internal_8ff85ea;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.instr.Instrumenter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.IRuntime;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.WildcardMatcher;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.CoverageTransformer */
public class CoverageTransformer implements ClassFileTransformer {
    private static final String AGENT_PREFIX;
    private final ClassFileDumper classFileDumper;
    private final WildcardMatcher exclClassloader;
    private final WildcardMatcher excludes;
    private final boolean inclBootstrapClasses;
    private final boolean inclNoLocationClasses;
    private final WildcardMatcher includes;
    private final Instrumenter instrumenter;
    private final IExceptionLogger logger;

    static {
        String name = CoverageTransformer.class.getName();
        AGENT_PREFIX = toVMName(name.substring(0, name.lastIndexOf(46)));
    }

    public CoverageTransformer(IRuntime runtime, AgentOptions options, IExceptionLogger logger2) {
        this.instrumenter = new Instrumenter(runtime);
        this.logger = logger2;
        this.includes = new WildcardMatcher(toVMName(options.getIncludes()));
        this.excludes = new WildcardMatcher(toVMName(options.getExcludes()));
        this.exclClassloader = new WildcardMatcher(options.getExclClassloader());
        this.classFileDumper = new ClassFileDumper(options.getClassDumpDir());
        this.inclBootstrapClasses = options.getInclBootstrapClasses();
        this.inclNoLocationClasses = options.getInclNoLocationClasses();
    }

    public byte[] transform(ClassLoader loader, String classname, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (classBeingRedefined != null || !filter(loader, classname, protectionDomain)) {
            return null;
        }
        try {
            this.classFileDumper.dump(classname, classfileBuffer);
            return this.instrumenter.instrument(classfileBuffer, classname);
        } catch (Exception ex) {
            IllegalClassFormatException wrapper = new IllegalClassFormatException(ex.getMessage());
            wrapper.initCause(ex);
            this.logger.logExeption(wrapper);
            throw wrapper;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean filter(ClassLoader loader, String classname, ProtectionDomain protectionDomain) {
        boolean z = false;
        if (loader == null) {
            if (!this.inclBootstrapClasses) {
                return false;
            }
        } else if ((!this.inclNoLocationClasses && !hasSourceLocation(protectionDomain)) || this.exclClassloader.matches(loader.getClass().getName())) {
            return false;
        }
        if (!classname.startsWith(AGENT_PREFIX) && this.includes.matches(classname) && !this.excludes.matches(classname)) {
            z = true;
        }
        return z;
    }

    private boolean hasSourceLocation(ProtectionDomain protectionDomain) {
        boolean z = false;
        if (protectionDomain == null) {
            return false;
        }
        CodeSource codeSource = protectionDomain.getCodeSource();
        if (codeSource == null) {
            return false;
        }
        if (codeSource.getLocation() != null) {
            z = true;
        }
        return z;
    }

    private static String toVMName(String srcName) {
        return srcName.replace('.', '/');
    }
}
