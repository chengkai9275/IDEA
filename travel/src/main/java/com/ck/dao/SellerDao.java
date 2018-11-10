package com.ck.dao;

import com.ck.po.Seller;

/**
 * @Titel: SellerDao
 * @Description: SellerDao 商家接口
 * @Author: CK
 * @CreateDate: 2018/10/14$ 19:29$
 * @Version: 1.0
 */
public interface SellerDao {

    /**
     * 通过ID查询商家信息
     * @param id
     * @return
     */
    Seller findSellerById(int id);
}
