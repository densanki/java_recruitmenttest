package de.densanki.recruitmenttest.Process;

import java.util.Arrays;

public class Anagrams extends Abstract {

    public void process(String line) {

        String orginal = line;

        // Remove spaces
        line = line.replace(" ", "");

        // Text normalisieren | Kleinschreibung
        line = line.toLowerCase();

        // Zeichenkette sortieren
        char[] c = line.toCharArray();
        Arrays.sort(c);
        String sorted = new String(c);

        // Place line into hashmap
        if (results.containsKey(sorted)) {
            String temp = results.get(sorted);
            temp = temp + " " + orginal;
            results.put(sorted, temp);
        } else {
            results.put(sorted, orginal);
        }

        logger.info("process line=" + line + " sorted=" + sorted);
    }

}
