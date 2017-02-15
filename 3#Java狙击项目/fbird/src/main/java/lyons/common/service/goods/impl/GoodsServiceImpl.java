/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyons.common.mapper.goods.GoodsMapper;
import lyons.common.model.goods.Goods;
import lyons.common.service.goods.GoodsService;

/**
 * @Description: 商品服务实现类
 * @ClassName: GoodsServiceImpl
 * @author: lyons<zhanglei>
 * @date: 2017年2月6日 下午6:50:22
 * @version: [1.0]
 */
@Service
public class GoodsServiceImpl implements GoodsService
{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllGoods()
    {
        return goodsMapper.selectAll();
    }

    @Override
    public List<Goods> queryByKeyword(String keyword)
    {
        return goodsMapper.selectByCondition(keyword);
    }
    
    @Override
    public Goods findDetail(String gId)
    {
        return goodsMapper.selectBygId(Integer.parseInt(gId));
    }
    
}
