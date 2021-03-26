package parser.state.impls.declarationStates;

import lexer.model.Token;
import lexer.model.TokenType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.DeclarationNode;
import parser.node.impl.IdentifierNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.AssignationState;
import parser.state.impls.EmptyState;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeState extends AbstractParserState {

    private final Token token;
    private final TokenType tokenType;

    public TypeState(Token token, TokenType tokenType) {
        this.token = token;
        this.tokenType = tokenType;
    }

    @Override
    public ParserState nextToken(Token t) {
        return switch (t.getTokenType()) {
            case ASSIGNATION -> new AssignationState(getDeclarationNode());
            case SEMICOLON -> {
                node = getDeclarationNode();
                yield new EmptyState();
            }
            default -> throw new IllegalStateException("Unexpected value: " + t.getTokenType());
        };
    }

    private DeclarationNode getDeclarationNode() {
        TypeValue typeValue = switch (tokenType) {
            case STRING_TYPE -> TypeValue.STRING;
            case NUMBER_TYPE -> TypeValue.NUMBER;
            default -> throw new IllegalStateException("Unexpected value: " + tokenType);
        };
        return new DeclarationNode(typeValue, new IdentifierNode(token.getValue()));
    }

}