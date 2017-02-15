package lyons.common.model.goods;

import java.util.Date;

/**
 * @Description: 商品实体类
 * @ClassName: Goods
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 下午4:57:33
 * @version: [1.0]
 */
public class Goods {
    
    /** 商品 id */
    private int gId;
    /** 商品 名字 */
    private String gName;
    /** 商品 描述 */
    private String gDescribe;
    /** 商品 价格 */
    private double gPrice;
    /** 商品 产地 */
    private String gMade;
    /** 商品 数量 */
    private Integer gAmount;
    /** 商品 输入时间 */
    private Date gCreateDate;
    /** 商品 图片路径 */
    private String gPic;
    
    
    public Goods(){}
    public Goods(int gId, String gName, String gDescribe, double gPrice, String gMade, Integer gAmount,
        Date gCreateDate, String gPic)
    {
        super();
        this.gId = gId;
        this.gName = gName;
        this.gDescribe = gDescribe;
        this.gPrice = gPrice;
        this.gMade = gMade;
        this.gAmount = gAmount;
        this.gCreateDate = gCreateDate;
        this.gPic = gPic;
    }
    

    public int getgId() {
        return gId;
    }
    public void setgId(int gId) {
        this.gId = gId;
    }
    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }
    public String getgDescribe() {
        return gDescribe;
    }
    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe == null ? null : gDescribe.trim();
    }
    public double getgPrice() {
        return gPrice;
    }
    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }
    public String getgMade() {
        return gMade;
    }
    public void setgMade(String gMade) {
        this.gMade = gMade == null ? null : gMade.trim();
    }
    public Integer getgAmount() {
        return gAmount;
    }
    public void setgAmount(Integer gAmount) {
        this.gAmount = gAmount;
    }
    public Date getgCreateDate() {
        return gCreateDate;
    }
    public void setgCreateDate(Date gCreateDate) {
        this.gCreateDate = gCreateDate;
    }
    public String getgPic() {
        return gPic;
    }
    public void setgPic(String gPic) {
        this.gPic = gPic == null ? null : gPic.trim();
    }
}