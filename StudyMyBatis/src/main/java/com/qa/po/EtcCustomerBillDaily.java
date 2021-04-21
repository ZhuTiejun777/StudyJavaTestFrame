package com.qa.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "etc_customer_bill_daily")
public class EtcCustomerBillDaily {

    @Id
    private String id;
}
