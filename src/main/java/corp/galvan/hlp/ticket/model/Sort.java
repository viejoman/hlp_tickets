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
public class Sort implements Serializable {

    private String property;
    private String direction;

}
