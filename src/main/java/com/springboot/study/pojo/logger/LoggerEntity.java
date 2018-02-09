package com.springboot.study.pojo.logger;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * 拦截请求的实体类
 *
 * @create 2018-01-08 17:46
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Entity
@Table(name="t_logger_infos")
@Data
public class LoggerEntity implements Serializable {

    /** 编号.  */
    @Id
    @GeneratedValue
    @Column(name = "ali_id")
    private Integer id;

    /** 客户端请求ip.  */
    @Column(name = "ali_client_ip")
    private String clientIp;

    /** 客户端请求路径.  */
    @Column(name = "ali_uri")
    private String uri;

    /** 终端请求方式普通请求 ajax请求.  */
    @Column(name = "ali_type")
    private String type;

    /** 请求方式method get post等.  */
    @Column(name = "ali_method")
    private String method;

    /** 请求参数内容json.  */
    @Column(name = "ali_param_data")
    private String paramData;

    /** 请求接口唯一sesion标识.  */
    @Column(name = "ali_session_id")
    private String sessionId;

    /** 请求时间.  */
    @Column(name = "ali_time")
    private Timestamp time;

    /** 接口返回时间.  */
    @Column(name = "ali_return_time")
    private String returnTime;

    /** 接口返回数据json.  */
    @Column(name = "ali_return_data")
    private String returnData;

    /** 返回的状态码.  */
    @Column(name = "ali_http_status_code")
    private String httpStatusCode;

    /** 耗时.  */
    @Column(name = "ali_time_consuming")
    private Integer timeConsuming;
}
