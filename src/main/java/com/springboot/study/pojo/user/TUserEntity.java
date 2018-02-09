package com.springboot.study.pojo.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:13
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Data
@Entity
@Table(name = "t_user")
public class TUserEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name="t_age")
    private Integer age;

    @Column(name = "t_address")
    private String address;

}

