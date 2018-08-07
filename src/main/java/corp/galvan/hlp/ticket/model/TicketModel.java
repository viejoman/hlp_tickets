package corp.galvan.hlp.ticket.model;

import corp.galvan.hlp.ticket.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel {

    private Boolean success;
    private String message;
    private String code;
    private Integer total;
    private List<Ticket> data;


}
