package com.ck.po;

import java.io.Serializable;

/**
 * @Titel: Category
 * @Description: Category 分类实体类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 9:22$
 * @Version: 1.0
 */
public class Category implements Serializable {
    /**
     * 分类id
     */
    private int cid;
    /**
     * 分类名称
     */
    private String cname;

    /**
     * 无参构造
     */
    public Category() {
    }

    /**
     * 有参构造
     * @param cid
     * @param cname
     */
    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
