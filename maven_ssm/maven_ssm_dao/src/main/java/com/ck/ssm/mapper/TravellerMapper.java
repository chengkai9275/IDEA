package com.ck.ssm.mapper;


import com.ck.ssm.pojo.Traveller;

import java.util.List;

/**
 * @Titel: TravellerMapper
 * @Description: TravellerMapper 旅客接口
 * @Author: CK
 * @CreateDate: 2018/11/15 10:35
 * @Version: 1.0
 */
public interface TravellerMapper {

    /**
     * 根据Id查询订单
     * @param id
     * @return
     * @throws Exception
     */
    List<Traveller> findTraById(String id) throws Exception;
}
