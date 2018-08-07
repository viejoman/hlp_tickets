package corp.galvan.hlp.ticket.model;

import corp.galvan.hlp.ticket.domain.HistorialTicket;

import java.util.List;

public class HistorialTicketModel {

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<HistorialTicket> getData() {
        return data;
    }

    public void setData(List<HistorialTicket> data) {
        this.data = data;
    }

    private Boolean success;
    private String message;
    private String code;
    private List<HistorialTicket> data;

    public HistorialTicketModel(Boolean success, String message, String code, List<HistorialTicket> data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public HistorialTicketModel() {
    }
}
