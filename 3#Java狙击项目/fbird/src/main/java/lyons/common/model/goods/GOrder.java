package lyons.common.model.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static lyons.common.utils.ModelSetterUtil.setFieldWithNotNullValue;

/**
 * @Description: 订单实体类
 * @ClassName: GOrder
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 下午4:58:35
 * @version: [1.0]
 */
@Data
@NoArgsConstructor
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

    public void setgOrderUName(String gOrderUName) {
        this.gOrderUName = setFieldWithNotNullValue(gOrderUName);
    }
    public void setReceiver(String receiver){
        this.receiver = setFieldWithNotNullValue(receiver);
    }
    public void setgOrderPhone(String gOrderPhone) {
        this.gOrderPhone = setFieldWithNotNullValue(gOrderPhone);
    }
    public void setgOrderAddress(String gOrderAddress) {
        this.gOrderAddress = setFieldWithNotNullValue(gOrderAddress);
    }
}