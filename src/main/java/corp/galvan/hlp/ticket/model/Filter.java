package corp.galvan.hlp.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor()
@NoArgsConstructor
@ToString
public class Filter implements Serializable {
    private String operator;
    private String value;
    private String property;
}
