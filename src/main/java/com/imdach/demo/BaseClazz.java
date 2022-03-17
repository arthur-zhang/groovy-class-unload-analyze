package com.imdach.demo;


import java.util.List;
import java.util.Map;

/**
 * 数据模型的公共属性
 * 数据模型都必须继承该类
 */
public abstract class BaseClazz {


    private String id;


    private String enterpriseCode;

    private String version;


    public abstract List<String> verify();

    public abstract Map<String,List> enums();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
