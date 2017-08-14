package de.densanki.recruitmenttest.Process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by densanki on 22.01.2017.
 */
public abstract class Abstract {

    private final Throwable t = new Throwable();
    private final StackTraceElement methodCaller = t.getStackTrace()[1];
    protected final Logger logger = LoggerFactory.getLogger(methodCaller.getClassName());
    protected Map<String, String> results = new HashMap<>();

    /*
    Process lines
     */
    public void process(String line) {

    }

    /*
    Print results
     */
    public void getResults() {
        logger.info("Results:");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            logger.info(entry.getValue());
        }
    }

}
