package node;


public class DeclarationNode implements Node {

    private final TypeValue typeValue;
    private final IdentifierNode node;

    public DeclarationNode(TypeValue typeValue, IdentifierNode node) {
        this.typeValue = typeValue;
        this.node = node;
    }

    @Override
    public void accept() {

    }
}
