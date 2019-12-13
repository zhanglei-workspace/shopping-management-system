package lyons.common.model.goods;

import lombok.Data;
import lombok.NoArgsConstructor;
import lyons.common.utils.ModelSetterUtil;

import java.util.Date;

import static lyons.common.utils.ModelSetterUtil.setFieldWithNotNullValue;

@Data
@NoArgsConstructor
public class GCar {
    
    /** 购物车编号 */
    private int gCarId;
    /** 储存者名字 */
    private String gCarUName;
    /** 商品id */
    private int gCarGId;
    /** 商品名字 */
    private String gCarGName;
    /** 商品价格 */
    private double gCarPrice;
    /** 购物车数量 */
    private int gCarNumber;
    /** 产地 */
    private String gCarGMade;
    /** 创建时间 */
    private Date gCarCreateDate;

    public GCar(int gCarId, String gCarUName, int gCarGId, String gCarGName, double gCarPrice, 
        int gCarNumber,String gCarGMade, Date gCarCreateDate)
    {
        super();
        this.gCarId = gCarId;
        this.setgCarUName(gCarUName);
        this.gCarGId = gCarGId;
        this.setgCarGName(gCarGName);
        this.gCarPrice = gCarPrice;
        this.gCarNumber = gCarNumber;
        this.setgCarGMade(gCarGMade);
        this.gCarCreateDate = gCarCreateDate;
    }


    public void setgCarUName(String gCarUName) {
        this.gCarUName = setFieldWithNotNullValue(gCarUName);
    }
    public void setgCarGMade(String gCarGMade) {
        this.gCarGMade = setFieldWithNotNullValue(gCarGMade);
    }
    public void setgCarGName(String gCarGName)
    {
        this.gCarGName = setFieldWithNotNullValue(gCarGName);
    }
}