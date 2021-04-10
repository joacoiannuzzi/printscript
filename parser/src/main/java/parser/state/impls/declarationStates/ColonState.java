package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class ColonState extends AbstractParserState {

  private Token token;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case NUMBER_TYPE, STRING_TYPE -> new TypeState(this.token, token.getTokenType());
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
