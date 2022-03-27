package com.programacion.dto;

import lombok.Getter;
import lombok.Setter;

public class Order {
    @Getter@Setter private Integer id;
    @Getter@Setter private String item;
    @Getter@Setter private String price;
    @Getter@Setter private String customer_id;
}
