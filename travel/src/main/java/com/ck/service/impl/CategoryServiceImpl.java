package com.ck.service.impl;

import com.ck.dao.CategoryDao;
import com.ck.dao.impl.CategoryDaoImpl;
import com.ck.po.Category;
import com.ck.service.CategoryService;
import com.ck.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Titel: CategoryServiceImpl
 * @Description: CategoryServiceImpl 列表业务逻辑实现类
 * @Author: CK
 * @CreateDate: 2018/10/14$ 8:34$
 * @Version: 1.0
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1.从redis中查询
        //1.1获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //1.3查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;
        //2.判断查询的集合是否为空
        if (categorys == null || categorys.size() == 0) {
            System.out.println("从数据库查询....");
            //3.如果为空,需要从数据库查询,在将数据存入redis
            //3.1 从数据库查询
            cs = categoryDao.findAll();
            //3.2 将集合数据存储到redis中的 category的key
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            System.out.println("从redis中查询.....");
            //4.如果不为空,将set的数据存入list
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }
        }
        return cs;
    }
}
