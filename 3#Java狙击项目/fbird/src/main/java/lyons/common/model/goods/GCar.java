package lyons.common.model.goods;

import java.util.Date;

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

    public GCar(){}
    public GCar(int gCarId, String gCarUName, int gCarGId, String gCarGName, double gCarPrice, 
        int gCarNumber,String gCarGMade, Date gCarCreateDate)
    {
        super();
        this.gCarId = gCarId;
        this.gCarUName = gCarUName;
        this.gCarGId = gCarGId;
        this.setgCarGName(gCarGName);
        this.gCarPrice = gCarPrice;
        this.gCarNumber = gCarNumber;
        this.gCarGMade = gCarGMade;
        this.gCarCreateDate = gCarCreateDate;
    }

    
    
    public int getgCarId() {
        return gCarId;
    }
    public void setgCarId(int gCarId) {
        this.gCarId = gCarId;
    }
    public String getgCarUName() {
        return gCarUName;
    }
    public void setgCarUName(String gCarUName) {
        this.gCarUName = gCarUName == null ? null : gCarUName.trim();
    }
    public int getgCarGId() {
        return gCarGId;
    }
    public void setgCarGId(int gCarGId) {
        this.gCarGId = gCarGId;
    }
    public double getgCarPrice() {
        return gCarPrice;
    }
    public void setgCarPrice(double gCarPrice) {
        this.gCarPrice = gCarPrice;
    }
    public int getgCarNumber() {
        return gCarNumber;
    }
    public void setgCarNumber(int gCarNumber) {
        this.gCarNumber = gCarNumber;
    }
    public String getgCarGMade() {
        return gCarGMade;
    }
    public void setgCarGMade(String gCarGMade) {
        this.gCarGMade = gCarGMade == null ? null : gCarGMade.trim();
    }
    public Date getgCarCreateDate() {
        return gCarCreateDate;
    }
    public void setgCarCreateDate(Date gCarCreateDate) {
        this.gCarCreateDate = gCarCreateDate;
    }
    public String getgCarGName(){
        return gCarGName;
    }
    public void setgCarGName(String gCarGName)
    {
        this.gCarGName = gCarGName == null ? null : gCarGName.trim();
    }
}