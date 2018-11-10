package com.ck.dao;

import com.ck.po.RouteImg;

import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: 接口作用描述
 * @Author: CK
 * @CreateDate: 2018/10/14$ 19:07$
 * @Version: 1.0
 */
public interface RouteImgDao {

    /**
     * 通过 Id查新图片信息
     * @param rid
     * @return
     */
    List<RouteImg> findImgByRid(int rid);
}
