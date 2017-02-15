/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyons.common.mapper.goods.GCarMapper;
import lyons.common.model.goods.GCar;
import lyons.common.model.goods.Goods;
import lyons.common.service.goods.GCarService;
import lyons.common.service.goods.GoodsService;

/**
 * @Description: 购物车服务实现类
 * @ClassName: GCarServiceImpl
 * @author: lyons<zhanglei>
 * @date: 2017年2月13日 下午8:12:39
 * @version: [1.0]
 */
@Service
public class GCarServiceImpl implements GCarService
{
    @Autowired
    private GCarMapper gCarMapper;
    @Autowired
    private GoodsService goodsService;

    @Override
    public List<GCar> findMyCar(String username)
    {
        return gCarMapper.selectByuName(username);
    }

    @Override
    public int carDelete(String username, String gCarGId)
    {
        return gCarMapper.deleteByCondition(username,gCarGId);
    }

    @Override
    public int carAdd(GCar car)
    {
        Goods goods = goodsService.findDetail(car.getgCarId()+"");
        car.setgCarGName(goods.getgName());
        car.setgCarPrice(goods.getgPrice());
        car.setgCarGMade(goods.getgMade());
        return gCarMapper.addGoods(car);
    }
    
}
