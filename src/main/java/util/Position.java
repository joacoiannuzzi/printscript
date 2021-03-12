package util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private int lineStart;
    private int lineFinish;
    private int columnStart;
    private int columnFinish;

}
