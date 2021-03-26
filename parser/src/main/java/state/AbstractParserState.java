package state;

import lombok.Data;
import node.Node;

import java.util.Optional;

@Data
public abstract class AbstractParserState implements ParserState {

    protected Node node;

    @Override
    public Optional<Node> getNode() {
        return Optional.ofNullable(node);
    }

}