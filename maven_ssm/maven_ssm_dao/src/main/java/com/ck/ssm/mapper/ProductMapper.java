package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Permission;
import com.ck.ssm.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Titel: ProductMapper
 * @Description: ProductMapper 产品
 * @Author: CK
 * @CreateDate: 2018/11/13 19:05
 * @Version: 1.0
 */
public interface ProductMapper {
    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    List<Product> findAllPro() throws Exception;

    /**
     * 根据ID查询产品
     * @param id
     * @return
     * @throws Exception
     */
    Product findProById(String id) throws Exception;

    /**
     * 查询角色可关联权限
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPerById(String roleId) throws Exception;

    /**
     * 添加产品
     * @param product
     * @return
     * @throws Exception
     */
     Boolean insertPro(Product product) throws Exception;

    /**
     * 删除产品
     * @param ids
     * @return
     * @throws Exception
     */
    Boolean deleteProById(List<String> ids) throws Exception;
}
