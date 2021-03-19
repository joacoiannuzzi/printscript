import fileReader.FileReaderPS;
import lombok.SneakyThrows;
import model.Token;
import node.Node;

import java.util.List;

public class Main {

    final private Lexer lexer = new LexerImpl();
    final private Parser parser = new ParserImpl();
    final private Validator validator = new ValidatorImpl();
    final private Interpreter interpreter = new InterpreterImpl();

    public static void main(String[] args) {
        System.out.println("This is the main");

    }

    @SneakyThrows
    void run(final String path) {
        String text = FileReaderPS.readFile(path);
        List<Token> tokens = lexer.createTokens(text);
        List<Node> nodes = parser.createNodes(tokens);
    }
}