package com.yujuncheng.clothing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    int id;
    String name;
    String phone;
    int sex;
    String password;
    String address;
}
