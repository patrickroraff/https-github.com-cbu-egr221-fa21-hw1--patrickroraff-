/**
 * This is the code for HOMEWORK 1- STACKS AND QUEUES ARE ADDED BELOW
 * PATRICK RORAFF
 * PROFESSOR BENJAMIN KNISLEY
 * ASSIGNMENT EXTENDED DUE DATE DO TO CHANGED COURSE SECTION B TO A
 * This class is used to read HtmlValidator code created in the file HtmlValidator.java
 * This method is provided a class for the testing
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class HtmlReader {

    public static Queue<HtmlTag> getTagsFromHtmlFile(String filename) throws IOException {
        InputStream stream = new FileInputStream(filename);
        StringBuffer buffer = new StringBuffer();
        int ch;
        while ((ch = stream.read()) > 0) {
            buffer.append((char) ch);
        }
        stream.close();
        String htmlFileString = buffer.toString();
        return HtmlTag.tokenize(htmlFileString);
    }

}