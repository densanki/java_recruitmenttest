package de.densanki.recruitmenttest.File;

import de.densanki.recruitmenttest.Process.Abstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.CodeSource;

public class Reader {

    private static final Logger logger = LoggerFactory.getLogger(Reader.class);
    private ClassLoader classLoader = getClass().getClassLoader();
    private CodeSource codeSource = getClass().getProtectionDomain().getCodeSource();

    /**
     * Constructor
     */
    public Reader() {

    }

    /**
     * Read text file from local drive
     *
     * @param object
     * @param filename
     */
    public void readFile(Abstract object, String filename) {
        try {
            // new FileReader(filename)
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.ISO_8859_1))) {
                for (String line; (line = br.readLine()) != null; ) {
                    object.process(line);
                }
            }
        } catch (IOException e) {
            logger.error("IOException " + e.getMessage());
        }
    }

    /**
     * Read file of jar resources
     *
     * @param object
     * @param filename
     */
    public void readResource(Abstract object, String filename) {

        InputStream i = classLoader.getResourceAsStream(filename);
        BufferedReader r = new BufferedReader(new InputStreamReader(i, StandardCharsets.ISO_8859_1));

        try {
            // reads each line
            String line;
            while ((line = r.readLine()) != null) {
                object.process(line);
            }
            i.close();
        } catch (IOException e) {
            logger.error("IOException " + e.getMessage());
        }
    }

    /**
     * Application path
     *
     * @return Application Path
     */
    public String getApplicationPath() {
        File jarFile;
        String jarDir = "";
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
            jarDir = jarFile.getParentFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String decodedPath = null;
        try {
            decodedPath = URLDecoder.decode(jarDir, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return decodedPath;
    }


}

