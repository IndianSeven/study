package com.springboot.study.pojo.validate;

import com.springboot.study.validator.FlagValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 19:18
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Data
public class DemoEntity implements Serializable {

    @NotBlank
    @Length(min = 2,max = 10,message = "")
    private String name;

    @Min(value = 1)
    private int age;

    @NotBlank
    @Email
    private String mail;

    @FlagValidator(values = "1,2,3")
    private String flag;

}