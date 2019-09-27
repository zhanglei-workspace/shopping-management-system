package lyons.goods.service;

import lyons.goods.service.GoodsServiceImpl;
import static org.junit.Assert.*;				
import org.junit.Test;

public class BuyGoodsTest {				

    @Test		
    public void BuyGoods1(){					
        String username = "!@#tuanna";
        LinkedList<String> car = new LinkedList<String>();
        car.add("Merc");
        car.add("Atis");
        car.add("Lambo");
        car.add("Vin");
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("发生错误");		
    }

    @Test		
    public void BuyGoods2(){
        String username = "";
        LinkedList<String> car = new LinkedList<String>();
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("购物车为空");
    }

    @Test		
    public void BuyGoods3(){
        String username = null;
        LinkedList<String> car = new LinkedList<String>();
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("购物车为空");
    }

    @Test		
    public void BuyGoods4(){
        String username = "tuanna";
        LinkedList<String> car = new LinkedList<String>();
        car.add("Merc");
        car.add("Atis");
        car.add("Lambo");
        car.add("Vin");
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("您已将购物车中的商品买回家了");
    }

    @Test		
    public void BuyGoods5(){
        String username = "tuanna";
        LinkedList<String> car = new LinkedList<String>();
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("购物车为空");
    }

    @Test		
    public void BuyGoods6(){
        String username = "";
        LinkedList<String> car = new LinkedList<String>();
        car.add("Merc");
        car.add("Atis");
        car.add("Lambo");
        car.add("Vin");
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("发生错误");
    }

    @Test		
    public void BuyGoods7(){
        String username = null;
        LinkedList<String> car = new LinkedList<String>();
        car.add("Merc");
        car.add("Atis");
        car.add("Lambo");
        car.add("Vin");
        assertThat(goodsServiceImpl.BuyGoods(userName, car))isEqualTo("发生错误");
    }		
}		