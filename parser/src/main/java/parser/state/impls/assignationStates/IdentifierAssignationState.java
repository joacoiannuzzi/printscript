package parser.state.impls.assignationStates;

import lexer.model.Token;
import lombok.*;
import parser.node.impl.IdentifierNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierAssignationState extends AbstractParserState {

  private Token token;

  @Override
  public ParserState nextToken(Token t) {
    return switch (t.getTokenType()) {
      case ASSIGNATION -> new AssignationState(new IdentifierNode(token.getValue()));
      default -> throw new IllegalStateException("Unexpected value: " + t.getTokenType());
    };
  }
}