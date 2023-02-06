// This is JUnit test program stub
// DO NOT CHANGE THE NAME OF THE METHODS GIVEN
// 0) test0 is by the instructor as example to test your validate() method
// 1) You are to reproduce testing validate() method with test1.html-test8.html and
//    match the expected output
// 2) You are to add your own JUnit test for testing your removeAll method (At least 4)
// 3) Feel free to add more test cases to test any of your public methods in HtmlValidator (No extra credit, but for your own benefit)

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class HtmlValidatorTest {
    /**
     * Below code returns the String format
     * of the content of the given file
     *
     * @param expectedFileName The name of the file that has expected output
     *                         Make sure put relative path in front of
     *                         the file name
     *                         (For example, if your files under tst folder,
     *                         expectedFileName should be "tst/YOUR_FILE_NAME"
     * @return The String format of what the expectedFileName contains
     */
    private static String expectedOutputToString(String expectedFileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner fileScanner = new Scanner(new File(expectedFileName));
            while (fileScanner.hasNextLine()) {
                sb.append(fileScanner.nextLine() + System.lineSeparator());
            }
        } catch (FileNotFoundException ex) {
            Assert.fail(expectedFileName + "not found. Make sure this file exists. Use relative path to root in front of the file name");
        }
        return sb.toString();
    }

    /**
     * Below code returns the String format
     * of what your validator's validate prints to the console
     * Feel free to use it so that you can compare it with the expected string
     *
     * @param validator HtmlValidator to test
     * @return String format of what HtmlValidator's validate outputs
     */
    private static String validatorOutputToString(HtmlValidator validator) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;
        System.setOut(ps);
        validator.validate();
        System.out.flush();
        System.setOut(oldOut);
        return baos.toString();
    }

    Queue<HtmlTag> tags = new LinkedList<HtmlTag>();

    private static void test1(Queue<HtmlTag> tags) {
        if (!tags.isEmpty()) {
            System.out.println("Test 1: Pass");
        } else {
            System.out.println("Test 1: Fail");
        }
    }

    private static void test2(Queue<HtmlTag> tags) {
        if (tags.isEmpty()) {
            System.out.println("Test 2: Pass");
        } else {
            System.out.println("Test 2: Fail");
        }
    }

    private static void test3(Queue<HtmlTag> tags) {
        Queue<HtmlTag> tagsBase = sameTags();
        while (!tags.isEmpty() && !tagsBase.isEmpty()) {
            if (!tags.remove().equals(tagsBase.remove())) {
                System.out.println("Test 3: Fail");

            }
        }
        if (!tags.isEmpty() || !tagsBase.isEmpty()) {
            System.out.println("Test 3: Fail");
        } else {
            System.out.println("Test 3: Pass");
        }
    }

    public static Queue<HtmlTag> removeAll(String element, Queue<HtmlTag> list) {
        int counter = list.size();
        while (list.size() != 0 && counter > 0) {
            if (list.peek().getElement().equals(element)) {
                counter--;
                list.remove();
            } else {
                list.add(list.remove());
                counter--;
            }
        }
        return list;
    }

    private static Queue<HtmlTag> sameTags() {
        Queue<HtmlTag> tags3 = new LinkedList<HtmlTag>();
        tags3.add(new HtmlTag("b", true));
        tags3.add(new HtmlTag("b", false));
        tags3.add(new HtmlTag("b", true));
        tags3.add(new HtmlTag("b", false));
        tags3.add(new HtmlTag("b", true));
        tags3.add(new HtmlTag("b", false));
        tags3.add(new HtmlTag("b", true));
        tags3.add(new HtmlTag("b", false));
        return tags3;
    }
}