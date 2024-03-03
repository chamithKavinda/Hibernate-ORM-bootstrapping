package com.company.embedded;

import javax.persistence.Column;
import java.io.Serializable;

public class OrderDetailPK implements Serializable {
    @Column(name = "order_id")
    private  int orderId;

    @Column(name = "item_id")
    private  int itemId;
}
