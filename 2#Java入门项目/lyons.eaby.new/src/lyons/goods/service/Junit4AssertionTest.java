package lyons.goods.service;

import static org.junit.Assert.*;				
import org.junit.Test;

public class Junit4AssertionTest {				

    @Test		
    public void testAssert(){					
        		
        String userName1 = "tuanna";					
        String userName2 = "";					
        String userName3 = null;

        LinkedList<String> car1 = new LinkedList<String>();
        LinkedList<String> car2 = new LinkedList<String>();
        car2.add("Merc");
        car2.add("Atis");
        car2.add("Lambo");
        car2.add("Vin");					
        GoodsServiceImpl goodsServiceImpl = new GoodsServiceImpl();
        
        assertThat(goodsServiceImpl.BuyGoods(userName1, car1))isEqualTo("购物车为空");
        assertThat(goodsServiceImpl.BuyGoods(userName2, car1))isEqualTo("购物车为空");
        assertThat(goodsServiceImpl.BuyGoods(userName3, car1))isEqualTo("购物车为空");
        assertThat(goodsServiceImpl.BuyGoods(userName2, car2))isEqualTo("发生错误");
        assertThat(goodsServiceImpl.BuyGoods(userName3, car2))isEqualTo("发生错误");		
        assertThat(goodsServiceImpl.BuyGoods(userName1, car2))isEqualTo("您已将购物车中的商品买回家了");				
    }		
}		