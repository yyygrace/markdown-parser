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
}
