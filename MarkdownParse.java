//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;

public class MarkdownParse {
//
    public static ArrayList<String> getLinks(String markdown) {
        Parser parser = Parser.builder().build();
        Node node = parser.parse(markdown);
        LinkVistor linkVisitor = new LinkVistor();
        node.accept(linkVisitor);

        return linkVisitor.linkList;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

class LinkVistor extends AbstractVisitor{
    ArrayList<String> linkList = new ArrayList<>();

    @Override
    public void visit(Link link){
        linkList.add(link.getDestination());
    }
}