package corp.galvan.hlp.ticket.model;

import corp.galvan.hlp.ticket.domain.AdjuntoDoctoTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AdjuntoDoctoTicketModel {

    private Boolean success;
    private String message;
    private String code;
    private List<AdjuntoDoctoTicket> data;

}
