package ck.mybatis.mapper;

import ck.mybatis.po.User;
import ck.mybatis.po.UserCustom;
import ck.mybatis.po.UserQueryVo;

import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: mapper接口，相当于dao接口 用户管理
 * @Author: CK
 * @CreateDate: 2018/8/31$ 21:11$
 * @Version: 1.0
 */

public interface UserMapper {

    /**
     * 用户信息综合查询
     * 条件 地址是：北京 生日
     * 姓名 性别
     *
     * @param userQueryVo
     * @return List<UserCustom>
     * @throws Exception
     */
    public List<UserCustom> findUserListES(UserQueryVo userQueryVo) throws Exception;

    /**
     * 用户信息综合查询
     *
     * @param userQueryVo
     * @return List<UserCustom>
     * @throws Exception
     */
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    /**
     * 用户信息综合查询总数
     *
     * @param userQueryVo
     * @return int
     * @throws Exception
     */
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    /**
     * 通过id查询用户
     *
     * @param id
     * @return user
     * @throws Exception
     */
    public User findUserById(int id) throws Exception;

    /**
     * 通过id查询用户
     *
     * @param id
     * @return resultMap类型
     * @throws Exception
     */
    public User findUserByIdResultMap(int id) throws Exception;

    /**
     * 通过名称模糊查询
     * 为什么用 List  返回单个 代理对象内部调用selectOne 否则 selectList
     *
     * @param name
     * @return List<User>
     * @throws Exception
     */
    public List<User> findUserByName(String name) throws Exception;

    /**
     * 添加用户
     *
     * @param user
     * @throws Exception
     */
    public void insertUser(User user) throws Exception;

    /**
     * 通过id删除用户
     *
     * @param id
     * @throws Exception
     */
    public void deleteUser(int id) throws Exception;

    /**
     * 更新用户
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

}
