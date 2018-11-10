package com.ck.po;

import java.util.List;

/**
 * @Titel: PageBean
 * @Description: PageBean 分页实体类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 9:22$
 * @Version: 1.0
 */
public class PageBean<T> {

    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页显示的条数
     */
    private int pageSize;
    /**
     * 每页显示的数据集合
     */
    private List<T> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
