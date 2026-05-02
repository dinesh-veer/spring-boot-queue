package com.dinesh.springbootrabbitmq.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {
    private String orderId;
    private String product;
    private int quantity;
}