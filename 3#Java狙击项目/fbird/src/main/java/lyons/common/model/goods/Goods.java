package lyons.common.model.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static lyons.common.utils.ModelSetterUtil.setFieldWithNotNullValue;

/**
 * @Description: 商品实体类
 * @ClassName: Goods
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 下午4:57:33
 * @version: [1.0]
 */

@Data
@NoArgsConstructor
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

    public void setgName(String gName) {
        this.gName = setFieldWithNotNullValue(gName);
    }
    public void setgDescribe(String gDescribe) {
        this.gDescribe = setFieldWithNotNullValue(gDescribe);
    }
    public void setgMade(String gMade) {
        this.gMade = setFieldWithNotNullValue(gMade);
    }
    public void setgPic(String gPic) {
        this.gPic = setFieldWithNotNullValue(gPic);
    }
}