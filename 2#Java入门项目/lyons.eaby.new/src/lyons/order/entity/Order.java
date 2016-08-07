package lyons.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 订单实体类
 * 
 * @author  lyons(zhanglei)
 * 
 */
public class Order
{
    private int id;                 //商品唯一标识
    private String userName;        //用户名
    private Date orderDate;         //订单日期
    private String commodity_name;  //商品名字
    private Double commodity_price; //商品价格
    private int sum;                //订单数量
    
    private List<Order> orderList = null;
    
    private String keyWord = "";    //关键字查询
    
    public Order()
    {
        orderList = new ArrayList<Order>();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public String getCommodity_name()
    {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name)
    {
        this.commodity_name = commodity_name;
    }

    public Double getCommodity_price()
    {
        return commodity_price;
    }

    public void setCommodity_price(Double commodity_price)
    {
        this.commodity_price = commodity_price;
    }

    public int getSum()
    {
        return sum;
    }

    public void setSum(int sum)
    {
        this.sum = sum;
    }

    public List<Order> getOrderList()
    {
        return orderList;
    }

    public void setOrderList(List<Order> orderList)
    {
        this.orderList = orderList;
    }

    public String getKeyWord()
    {
        return keyWord;
    }

    public void setKeyWord(String keyWord)
    {
        this.keyWord = keyWord;
    }
    
    
    
    
}
