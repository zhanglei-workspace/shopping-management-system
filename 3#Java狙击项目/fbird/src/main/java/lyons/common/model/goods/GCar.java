package lyons.common.model.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
        this.gCarUName = gCarUName == null ? null : gCarUName.trim();
    }
    public void setgCarGMade(String gCarGMade) {
        this.gCarGMade = gCarGMade == null ? null : gCarGMade.trim();
    }
    public void setgCarGName(String gCarGName)
    {
        this.gCarGName = gCarGName == null ? null : gCarGName.trim();
    }
}