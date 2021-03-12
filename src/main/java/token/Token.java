package token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.Position;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    private String value;
    private TokenType tokenType;
    private Position position;

}
