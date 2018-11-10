package ck.mybatis.po;


import java.util.Date;

/**
 * @Titel: UserCustom
 * @Description: User扩展类
 * @Author: CK
 * @CreateDate: 2018/9/4$ 20:11$
 * @Version: 1.0
 */
public class UserCustom extends User {


    //这里添加扩展字段
   /* private Date birthday_start;//起始日期
    private Date birthday_end;//截止日期
*/

   //查询用户姓名 地址 购买商品名称 购买商品时间 购买商品数量
   private String name;
   private Date createtime;
   private Integer items_num;


   public Date getCreatetime() {
      return createtime;
   }

   public void setCreatetime(Date createtime) {
      this.createtime = createtime;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getItems_num() {
      return items_num;
   }

   public void setItems_num(Integer items_num) {
      this.items_num = items_num;
   }
}
