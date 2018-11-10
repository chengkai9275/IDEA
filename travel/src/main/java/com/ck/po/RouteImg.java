package com.ck.po;

import java.io.Serializable;

/**
 * @Titel: Routelmg
 * @Description: Routelmg 旅游线路图片实体类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 9:21$
 * @Version: 1.0
 */
public class RouteImg implements Serializable {
    /**
     * 商品图片id
     */
    private int rgid;
    /**
     * 旅游商品id
     */
    private int rid;
    /**
     * 详情商品大图
     */
    private String bigPic;
    /**
     * 详情商品小图
     */
    private String smallPic;

    /**
     * 无参构造方法
     */
    public RouteImg() {
    }

    /**
     * 有参构造方法
     *
     * @param rgid
     * @param rid
     * @param bigPic
     * @param smallPic
     */
    public RouteImg(int rgid, int rid, String bigPic, String smallPic) {
        this.rgid = rgid;
        this.rid = rid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    public int getRgid() {
        return rgid;
    }

    public void setRgid(int rgid) {
        this.rgid = rgid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    @Override
    public String toString() {
        return "RouteImg{" +
                "rgid=" + rgid +
                ", rid=" + rid +
                ", bigPic='" + bigPic + '\'' +
                ", smallPic='" + smallPic + '\'' +
                '}';
    }
}
