package com.ck.service;


import com.ck.po.Category;

import java.util.List;

/**
 * @Titel: CategoryService
 * @Description: CategoryService 列表业务逻辑
 * @Author: CK
 * @CreateDate: 2018/10/12$ 19:08$
 * @Version: 1.0
 */
public interface CategoryService {

    List<Category> findAll();
}
