package com.euro.digital.utility;

/**
 * Enum {@link StatusEnum} is used to construct On Time and Delayed in Response
 *
 * @author MKushwaha
 */
public enum StatusEnum {

    OT("On Time"),
    DL("Delayed");

    private String status;
    StatusEnum (String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

}
