import java.util.ArrayList;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class TryCommonMark {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        System.out.println(renderer);

        // this part actually does the computation
        Node node = parser.parse("Example\n=======\n\nSome more text [link](.url)");
        //WordCountVisitor visitor = new WordCountVisitor();
        //node.accept(visitor);
        //System.out.println(visitor.wordCount);  // 4

        LinkVistor linkVisitor = new LinkVistor();
        node.accept(linkVisitor);
        System.out.print(linkVisitor.linkList);
    }
}

class LinkVistor extends AbstractVisitor{
    //int linkCount = 0;
    ArrayList<String> linkList = new ArrayList<>();

    @Override
    public void visit(Link link){
        //linkCount++;
        linkList.add(link.getDestination());
    }
}

// this class can be defined anywhere in the file
class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }
}