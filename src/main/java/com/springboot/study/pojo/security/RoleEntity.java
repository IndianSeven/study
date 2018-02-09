package com.springboot.study.pojo.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 *security的角色roles实体
 *
 * @create 2018-01-17 15:31
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Table(name = "roles")
@Entity
public class RoleEntity implements Serializable{

    @Id
    @Column(name = "r_id")
    private Long id;

    @Column(name = "r_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
