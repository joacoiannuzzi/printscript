package parser.node.impl;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operandNodes.OperandNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
@NoArgsConstructor
public class EmptyNode implements Calculable {

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public LiteralValue calculate() {
        return new LiteralValue() {
            @Override
            public Object getValue() {
                return "";
            }

            @Override
            public TypeValue getTypeValue() {
                return TypeValue.STRING;
            }
        };
    }

    @Override
    public Calculable resolveTree(OperandNode operator, Calculable operand) {
        throw new RuntimeException("Aca no puede llegar");
    }
}
