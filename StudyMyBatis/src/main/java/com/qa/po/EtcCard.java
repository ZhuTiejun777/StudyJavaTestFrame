package com.qa.po;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Table(name = "etc_card") // 指定对应的表
public class EtcCard {

    @Id
    private String id;

    @Column(name = "vehicle_code")
    private String vehicle_code;

    @Column(name = "create_time")
    private Date create_time;

    private int card_status;

    // 需要在get方法上使用
    // 数据库表字段与result不一致时用@Column注解，例如：
    // @Column(name = "card_status")
    // 字段值为只读的，不允许插入和修改。通常用于主键和外键 insertable = false, updatable = false
    // 指定建表时SQL语句 如“varchar(50) NOT NULL” columnDefinition = "varchar(50) not null"
    // 精度（长度）为10，小数点位数为2位 precision = 10, scale = 2
    // 长度为50 length = 50
    // 且值不能为nullnullable = false
    //@Column(name = "id")
    /*@Column(name = "card_status")
    public int getCardStatus() {
        return cardStatus;
    }*/

    private String card_code;

    @Column(scale = 2)
    private double banlance;

    @Override
    public String toString () {
        return "id=" + getId() + ";" + "vehicle_code=" + getVehicle_code() + ";" +
                "create_time=" + getCreate_time() + ";" + "card_status=" + getCard_status() + ";" +
                "card_code=" + getCard_code() + ";" + "banlance=" + getBanlance() + ";";
    }

}
