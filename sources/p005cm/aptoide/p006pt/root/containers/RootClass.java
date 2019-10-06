package p005cm.aptoide.p006pt.root.containers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: cm.aptoide.pt.root.containers.RootClass */
public class RootClass {
    static String PATH_TO_DX = "/Users/Chris/Projects/android-sdk-macosx/build-tools/18.0.1/dx";

    /* renamed from: cm.aptoide.pt.root.containers.RootClass$Candidate */
    public @interface Candidate {
    }

    /* renamed from: cm.aptoide.pt.root.containers.RootClass$1 */
    static /* synthetic */ class C46451 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$root$containers$RootClass$READ_STATE = new int[READ_STATE.values().length];

        static {
            try {
                $SwitchMap$cm$aptoide$pt$root$containers$RootClass$READ_STATE[READ_STATE.STARTING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$root$containers$RootClass$READ_STATE[READ_STATE.FOUND_ANNOTATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: cm.aptoide.pt.root.containers.RootClass$AnnotationsFinder */
    public static class AnnotationsFinder {
        private final String AVOIDDIRPATH;
        private List<File> classFiles = new ArrayList();

        public AnnotationsFinder() throws IOException {
            String[] cmd;
            String[] cmd2;
            StringBuilder sb = new StringBuilder();
            String str = "stericson";
            sb.append(str);
            sb.append(File.separator);
            String str2 = "RootShell";
            sb.append(str2);
            sb.append(File.separator);
            this.AVOIDDIRPATH = sb.toString();
            System.out.println("Discovering root class annotations...");
            lookup(new File("src"), this.classFiles);
            System.out.println("Done discovering annotations. Building jar file.");
            File builtPath = getBuiltPath();
            String str3 = "raw";
            if (builtPath != null) {
                StringBuilder sb2 = new StringBuilder();
                String str4 = "com";
                sb2.append(str4);
                sb2.append(File.separator);
                sb2.append(str);
                sb2.append(File.separator);
                sb2.append(str2);
                sb2.append(File.separator);
                String str5 = "containers";
                sb2.append(str5);
                sb2.append(File.separator);
                sb2.append("RootClass.class");
                String rc1 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(File.separator);
                sb3.append(str);
                sb3.append(File.separator);
                sb3.append(str2);
                sb3.append(File.separator);
                sb3.append(str5);
                sb3.append(File.separator);
                sb3.append("RootClass$RootArgs.class");
                String rc2 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str4);
                sb4.append(File.separator);
                sb4.append(str);
                sb4.append(File.separator);
                sb4.append(str2);
                sb4.append(File.separator);
                sb4.append(str5);
                sb4.append(File.separator);
                sb4.append("RootClass$AnnotationsFinder.class");
                String rc3 = sb4.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str4);
                sb5.append(File.separator);
                sb5.append(str);
                sb5.append(File.separator);
                sb5.append(str2);
                sb5.append(File.separator);
                sb5.append(str5);
                sb5.append(File.separator);
                sb5.append("RootClass$AnnotationsFinder$1.class");
                String rc4 = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str4);
                sb6.append(File.separator);
                sb6.append(str);
                sb6.append(File.separator);
                sb6.append(str2);
                sb6.append(File.separator);
                sb6.append(str5);
                sb6.append(File.separator);
                sb6.append("RootClass$AnnotationsFinder$2.class");
                String rc5 = sb6.toString();
                boolean onWindows = -1 != System.getProperty("os.name").toLowerCase().indexOf("win");
                String str6 = "/C";
                String str7 = "cmd";
                String str8 = "anbuild.jar";
                if (onWindows) {
                    StringBuilder sb7 = new StringBuilder();
                    String str9 = " ";
                    sb7.append(str9);
                    sb7.append(rc1);
                    sb7.append(str9);
                    sb7.append(rc2);
                    sb7.append(str9);
                    sb7.append(rc3);
                    sb7.append(str9);
                    sb7.append(rc4);
                    sb7.append(str9);
                    sb7.append(rc5);
                    StringBuilder sb8 = new StringBuilder(sb7.toString());
                    Iterator it = this.classFiles.iterator();
                    while (it.hasNext()) {
                        File file = (File) it.next();
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(str9);
                        Iterator it2 = it;
                        sb9.append(file.getPath());
                        sb8.append(sb9.toString());
                        it = it2;
                    }
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("jar cvf anbuild.jar");
                    sb10.append(sb8.toString());
                    cmd = new String[]{str7, str6, sb10.toString()};
                } else {
                    ArrayList<String> al = new ArrayList<>();
                    al.add("jar");
                    al.add("cf");
                    al.add(str8);
                    al.add(rc1);
                    al.add(rc2);
                    al.add(rc3);
                    al.add(rc4);
                    al.add(rc5);
                    for (File file2 : this.classFiles) {
                        al.add(file2.getPath());
                    }
                    cmd = (String[]) al.toArray(new String[al.size()]);
                }
                ProcessBuilder jarBuilder = new ProcessBuilder(cmd);
                jarBuilder.directory(builtPath);
                try {
                    jarBuilder.start().waitFor();
                } catch (IOException | InterruptedException e) {
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append("res");
                sb11.append(File.separator);
                sb11.append(str3);
                File rawFolder = new File(sb11.toString());
                if (!rawFolder.exists()) {
                    rawFolder.mkdirs();
                }
                System.out.println("Done building jar file. Creating dex file.");
                if (onWindows) {
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append("dx --dex --output=res");
                    sb12.append(File.separator);
                    sb12.append(str3);
                    sb12.append(File.separator);
                    sb12.append("anbuild.dex ");
                    sb12.append(builtPath);
                    sb12.append(File.separator);
                    sb12.append(str8);
                    cmd2 = new String[]{str7, str6, sb12.toString()};
                } else {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append("--output=res");
                    sb13.append(File.separator);
                    sb13.append(str3);
                    sb13.append(File.separator);
                    sb13.append("anbuild.dex");
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(builtPath);
                    sb14.append(File.separator);
                    sb14.append(str8);
                    cmd2 = new String[]{getPathToDx(), "--dex", sb13.toString(), sb14.toString()};
                }
                try {
                    new ProcessBuilder(cmd2).start().waitFor();
                } catch (IOException | InterruptedException e2) {
                }
            }
            PrintStream printStream = System.out;
            StringBuilder sb15 = new StringBuilder();
            sb15.append("All done. ::: anbuild.dex should now be in your project's res");
            sb15.append(File.separator);
            sb15.append(str3);
            sb15.append(File.separator);
            sb15.append(" folder :::");
            printStream.println(sb15.toString());
        }

        /* access modifiers changed from: protected */
        public void lookup(File path, List<File> fileList) {
            AnnotationsFinder annotationsFinder = this;
            List<File> list = fileList;
            String file = path.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("src");
            sb.append(File.separator);
            String str = "";
            String desourcedPath = file.replace(sb.toString(), str);
            File[] files = path.listFiles();
            int length = files.length;
            int i = 0;
            while (i < length) {
                File file2 = files[i];
                if (!file2.isDirectory()) {
                    String str2 = ".java";
                    if (file2.getName().endsWith(str2) && annotationsFinder.hasClassAnnotation(file2)) {
                        final String fileNamePrefix = file2.getName().replace(str2, str);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(getBuiltPath().toString());
                        sb2.append(File.separator);
                        sb2.append(desourcedPath);
                        File[] classAndInnerClassFiles = new File(sb2.toString()).listFiles(new FilenameFilter() {
                            public boolean accept(File dir, String filename) {
                                return filename.startsWith(fileNamePrefix);
                            }
                        });
                        int length2 = classAndInnerClassFiles.length;
                        int i2 = 0;
                        while (i2 < length2) {
                            File matchingFile = classAndInnerClassFiles[i2];
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(desourcedPath);
                            sb3.append(File.separator);
                            sb3.append(matchingFile.getName());
                            list.add(new File(sb3.toString()));
                            i2++;
                        }
                    }
                } else if (-1 == file2.getAbsolutePath().indexOf(annotationsFinder.AVOIDDIRPATH)) {
                    annotationsFinder.lookup(file2, list);
                }
                i++;
                annotationsFinder = this;
            }
        }

        /* access modifiers changed from: protected */
        public boolean hasClassAnnotation(File file) {
            READ_STATE readState = READ_STATE.STARTING;
            Pattern p = Pattern.compile(" class ([A-Za-z0-9_]+)");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = reader.readLine();
                    String line = readLine;
                    if (readLine == null) {
                        break;
                    }
                    int i = C46451.$SwitchMap$cm$aptoide$pt$root$containers$RootClass$READ_STATE[readState.ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            Matcher m = p.matcher(line);
                            if (m.find()) {
                                PrintStream printStream = System.out;
                                StringBuilder sb = new StringBuilder();
                                sb.append(" Found annotated class: ");
                                sb.append(m.group(0));
                                printStream.println(sb.toString());
                                return true;
                            }
                            PrintStream printStream2 = System.err;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Error: unmatched annotation in ");
                            sb2.append(file.getAbsolutePath());
                            printStream2.println(sb2.toString());
                            readState = READ_STATE.STARTING;
                        }
                    } else if (-1 < line.indexOf("@RootClass.Candidate")) {
                        readState = READ_STATE.FOUND_ANNOTATION;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public String getPathToDx() throws IOException {
            File[] files;
            String fileName;
            String androidHome = System.getenv("ANDROID_HOME");
            if (androidHome != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(androidHome);
                sb.append(File.separator);
                sb.append("build-tools");
                int recentSdkVersion = 0;
                String dxPath = null;
                for (File file : new File(sb.toString()).listFiles()) {
                    String str = "-";
                    if (file.getName().contains(str)) {
                        String[] splitFileName = file.getName().split(str);
                        if (splitFileName[1].contains("W")) {
                            fileName = String.valueOf(splitFileName[1].toCharArray()[0]);
                        } else {
                            fileName = splitFileName[1];
                        }
                    } else {
                        fileName = file.getName();
                    }
                    String[] sdkVersionBits = fileName.split("[.]");
                    int sdkVersion = Integer.parseInt(sdkVersionBits[0]) * 10000;
                    if (sdkVersionBits.length > 1) {
                        sdkVersion += Integer.parseInt(sdkVersionBits[1]) * 100;
                        if (sdkVersionBits.length > 2) {
                            sdkVersion += Integer.parseInt(sdkVersionBits[2]);
                        }
                    }
                    if (sdkVersion > recentSdkVersion) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(file.getAbsolutePath());
                        sb2.append(File.separator);
                        sb2.append("dx");
                        String tentativePath = sb2.toString();
                        if (new File(tentativePath).exists()) {
                            recentSdkVersion = sdkVersion;
                            dxPath = tentativePath;
                        }
                    }
                }
                if (dxPath != null) {
                    return dxPath;
                }
                throw new IOException("Error: unable to find dx binary in $ANDROID_HOME");
            }
            throw new IOException("Error: you need to set $ANDROID_HOME globally");
        }

        /* access modifiers changed from: protected */
        public File getBuiltPath() {
            File foundPath = null;
            StringBuilder sb = new StringBuilder();
            sb.append("out");
            sb.append(File.separator);
            sb.append("production");
            File ideaPath = new File(sb.toString());
            if (ideaPath.isDirectory()) {
                File[] children = ideaPath.listFiles(new FileFilter() {
                    public boolean accept(File pathname) {
                        return pathname.isDirectory();
                    }
                });
                if (children.length > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(ideaPath.getAbsolutePath());
                    sb2.append(File.separator);
                    sb2.append(children[0].getName());
                    foundPath = new File(sb2.toString());
                }
            }
            if (foundPath != null) {
                return foundPath;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("bin");
            sb3.append(File.separator);
            sb3.append("classes");
            File eclipsePath = new File(sb3.toString());
            if (eclipsePath.isDirectory()) {
                return eclipsePath;
            }
            return foundPath;
        }
    }

    /* renamed from: cm.aptoide.pt.root.containers.RootClass$READ_STATE */
    enum READ_STATE {
        STARTING,
        FOUND_ANNOTATION
    }

    /* renamed from: cm.aptoide.pt.root.containers.RootClass$RootArgs */
    public class RootArgs {
        public String[] args;

        public RootArgs() {
        }
    }

    public RootClass(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = args[0];
        RootArgs actualArgs = new RootArgs();
        actualArgs.args = new String[(args.length - 1)];
        System.arraycopy(args, 1, actualArgs.args, 0, args.length - 1);
        Class.forName(className).getConstructor(new Class[]{RootArgs.class}).newInstance(new Object[]{actualArgs});
    }

    static void displayError(Exception e) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("##ERR##");
        sb.append(e.getMessage());
        sb.append("##");
        printStream.println(sb.toString());
        e.printStackTrace();
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                new AnnotationsFinder();
            } else {
                new RootClass(args);
            }
        } catch (Exception e) {
            displayError(e);
        }
    }
}
