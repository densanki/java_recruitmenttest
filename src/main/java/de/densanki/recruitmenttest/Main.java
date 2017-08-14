package de.densanki.recruitmenttest;

import de.densanki.recruitmenttest.File.Reader;
import de.densanki.recruitmenttest.Process.Anagrams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    private static final String FILE_NAME = "file/sample.txt";
    private static final String DATA_RESOURCE = "Resource";
    private static final String DATA_FILE = "File";

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Application Main Class
     *
     * @param args Command line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        logger.info("Start Application");

        // Initial
        String inputFile = FILE_NAME;
        String loadFile = DATA_RESOURCE;

        Reader reader = new Reader();

        // Check for extern file or interal
        if (args.length == 1 && !args[0].equals("")) {
            String localfile = reader.getApplicationPath() + File.separator + args[0];
            File file = new File(localfile);
            if (file.exists()) {
                inputFile = localfile;
                loadFile = DATA_FILE;
            } else {
                logger.error("Local file not found");
            }
        }

        logger.info("Loading mechanism=" + loadFile);
        logger.info("Loaded file=" + inputFile);

        // Start processing
        Anagrams anagrams = new Anagrams();

        switch (loadFile) {
            case DATA_RESOURCE:
                reader.readResource(anagrams, inputFile);
                break;
            case DATA_FILE:
                reader.readFile(anagrams, inputFile);
                break;
        }

        anagrams.getResults();

        logger.info("End Application");
    }

}
