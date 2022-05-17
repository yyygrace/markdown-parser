import static org.junit.Assert.*;       // imports Assert
import org.junit.*;                     // imports JUnit
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {        // class header
    @Test                               // tells Java that the following method will be a test
    public void addition() {            // method header
        assertEquals(2, 1 + 1);         // checks between the expected and actual output
    }

    @Test
    public void testFileTester() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://something.com");
        exp.add("some-thing.html");
        assertEquals(exp, links);
    }

    @Test
    public void test2() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://something.com");
        exp.add("some-page.html");
        assertEquals(exp, links);
    }

    @Test
    public void test3() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file3.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }

    @Test
    public void test4() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file4.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }

    @Test
    public void test5() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file5.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }
/*
    @Test
    public void test6() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file6.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("page.com");
        assertEquals(exp, links);
    }
    */

    @Test
    public void test7() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file7.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }

    @Test
    public void test8() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file8.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }

    @Test
    public void imageTester() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("image-tester.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }

    @Test
    public void newTesterTester() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("new-tester.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("www.google.com");
        assertEquals(exp, links);
    }

    @Test
    public void noLinksTester() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("no-links.md")));
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(empty, links);
    }

    @Test
    public void testSnipper1() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("snippet1.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("`www.google.com");
        exp.add("google.com");
        exp.add("ucsd.edu");
        assertEquals(exp, links);
    }

    @Test
    public void testSnipper2() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("snippet2.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("a.com");
        exp.add("a.com(())");
        exp.add("example.com");
        assertEquals(exp, links);
    }

    @Test
    public void testSnipper3() throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("snippet3.md")));
        ArrayList<String> exp = new ArrayList<String>();
        exp.add("https://www.twitter.com");
        exp.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        exp.add("https://cse.ucsd.edu/");
        assertEquals(exp, links);
    }
}
