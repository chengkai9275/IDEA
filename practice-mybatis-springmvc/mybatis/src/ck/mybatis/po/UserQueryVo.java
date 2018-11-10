package ck.mybatis.po;

import java.util.List;

/**
 * @Titel: UserQueryVo
 * @Description: 用户包装类
 * @Author: CK
 * @CreateDate: 2018/9/4$ 20:07$
 * @Version: 1.0
 */
public class UserQueryVo {
    //包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;

    private User user;

    //传递多个用户id
    private List<Integer> ids;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }


    //可以包装其他的查询条件 订单...

}
