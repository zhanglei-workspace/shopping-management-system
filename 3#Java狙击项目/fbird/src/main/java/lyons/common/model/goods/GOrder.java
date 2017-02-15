package lyons.common.model.goods;

import java.util.Date;

/**
 * @Description: 订单实体类
 * @ClassName: GOrder
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 下午4:58:35
 * @version: [1.0]
 */
public class GOrder {
            
    /** 订单id */
    private int gOrderId;
    /** 订购者名字 */
    private String gOrderUName;
    /** 商品id */
    private int gOrderGId;
    /** 商品价格 */
    private double gOrderPrice;
    /** 订单数量 */
    private int gOrderNumber;
    /** 订单时间 */
    private Date gOrderCreateDate;
    /** 收货人名字 */
    private String receiver;
    /** 联系电话 */
    private String gOrderPhone;
    /** 配送地址 */
    private String gOrderAddress;

    public GOrder(){}
    public GOrder(int gOrderId, String gOrderUName, int gOrderGId, double gOrderPrice, int gOrderNumber,
        Date gOrderCreateDate, String receiver, String gOrderPhone, String gOrderAddress)
    {
        this.gOrderId = gOrderId;
        this.gOrderUName = gOrderUName;
        this.gOrderGId = gOrderGId;
        this.gOrderPrice = gOrderPrice;
        this.gOrderNumber = gOrderNumber;
        this.gOrderCreateDate = gOrderCreateDate;
        this.receiver = receiver;
        this.gOrderPhone = gOrderPhone;
        this.gOrderAddress = gOrderAddress;
    }
    
    public int getgOrderId() {
        return gOrderId;
    }
    public void setgOrderId(int gOrderId) {
        this.gOrderId = gOrderId;
    }
    public String getgOrderUName() {
        return gOrderUName;
    }
    public void setgOrderUName(String gOrderUName) {
        this.gOrderUName = gOrderUName == null ? null : gOrderUName.trim();
    }
    public int getgOrderGId() {
        return gOrderGId;
    }
    public void setgOrderGId(int gOrderGId) {
        this.gOrderGId = gOrderGId;
    }
    public double getgOrderPrice() {
        return gOrderPrice;
    }
    public void setgOrderPrice(double gOrderPrice) {
        this.gOrderPrice = gOrderPrice;
    }
    public int getgOrderNumber() {
        return gOrderNumber;
    }
    public void setgOrderNumber(int gOrderNumber) {
        this.gOrderNumber = gOrderNumber;
    }
    public String getReceiver(){
        return receiver;
    }
    public void setReceiver(String receiver){
        this.receiver = receiver == null ? null : receiver.trim();
    }
    public Date getgOrderCreateDate() {
        return gOrderCreateDate;
    }
    public void setgOrderCreateDate(Date gOrderCreateDate) {
        this.gOrderCreateDate = gOrderCreateDate;
    }
    public String getgOrderPhone() {
        return gOrderPhone;
    }
    public void setgOrderPhone(String gOrderPhone) {
        this.gOrderPhone = gOrderPhone == null ? null : gOrderPhone.trim();
    }
    public String getgOrderAddress() {
        return gOrderAddress;
    }
    public void setgOrderAddress(String gOrderAddress) {
        this.gOrderAddress = gOrderAddress == null ? null : gOrderAddress.trim();
    }
}