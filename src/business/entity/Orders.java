package business.entity;

import java.util.Date;

public class Orders {
    private int order_id;
    private  String serial_number;
    private int user_id;
    private double total_price;
    private  enum status{
        WAITING,
        CONFIRM,
        DELIVERY,
        SUCCESS,
        CANCEL,
        DENIED,
    };
    private String note;
    private String receive_name;
    private String receive_address;

    private String receive_phone;
    private Date created_at;
    private Date received_at;

}
