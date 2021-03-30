package parser;

import java.util.ArrayList;
import java.util.List;
import lexer.model.Token;
import lombok.val;
import parser.node.Node;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

public class ParserImpl implements Parser {

  private final List<Node> nodes = new ArrayList<>();
  private ParserState state = new EmptyState();

  public static List<Node> parse(List<Token> tokens) {
    return new ParserImpl().createNodes(tokens);
  }

  @Override
  public List<Node> createNodes(List<Token> tokens) {
    tokens.forEach(this::consumeToken);
    consumeToken(Token.end()); // last character, end of file
    return nodes;
  }

  private void consumeToken(Token t) {
    val nextState = state.nextToken(t);
    state.getNode().ifPresent(nodes::add);
    state = nextState;
  }
}
