package com.ck.dao;

import com.ck.po.Category;

import java.util.List;

/**
 * @Titel: CategoryDao
 * @Description: CategoryDao 列表分类接口
 * @Author: CK
 * @CreateDate: 2018/10/11$ 19:04$
 * @Version: 1.0
 */
public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    List<Category> findAll();
}
