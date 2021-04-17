package parser.state.util;

import lexer.model.Token;
import parser.exception.ParserException;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.BooleanLiteralValue;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.*;
import parser.node.interfaces.Calculable;

public class CalculableUtils {

  public static int BLOCK_COUNTER = 0;

  static Calculable getNode(Token token) {
    return switch (token.getTokenType()) {
      case PLUS -> new SumNode();
      case MINUS -> new MinusNode();
      case MULTIPLY -> new MultiplyNode();
      case DIVIDE -> new DivisionNode();
      case STRING -> new LiteralNode(new StringLiteralValue(token.getValue()));
      case NUMBER -> new LiteralNode(new NumberLiteralValue(Double.parseDouble(token.getValue())));
      case BOOLEAN -> new LiteralNode(
          new BooleanLiteralValue(Boolean.parseBoolean(token.getValue())));
      case IDENTIFIER -> new IdentifierNode(token.getValue());
      default -> throw ParserException.unexpectedToken(token);
    };
  }

  static Calculable getBoolOpNode(Token token, Calculable left, Calculable right) {
    return switch (token.getTokenType()) {
      case GREATER -> GreaterNode.builder().leftNode(left).rightNode(right).build();
      case GREATER_EQUAL -> GreaterEqualNode.builder().leftNode(left).rightNode(right).build();
      case LESS -> LessNode.builder().leftNode(left).rightNode(right).build();
      case LESS_EQUAL -> LessEqualNode.builder().leftNode(left).rightNode(right).build();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
