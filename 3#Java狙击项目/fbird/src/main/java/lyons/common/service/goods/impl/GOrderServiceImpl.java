/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyons.common.mapper.goods.GOrderMapper;
import lyons.common.model.goods.GOrder;
import lyons.common.service.goods.GOrderService;

/**
 * @Description: 订单实现类
 * @ClassName: GOrderServiceImpl
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 下午7:04:06
 * @version: [1.0]
 */
@Service
public class GOrderServiceImpl implements GOrderService
{
    @Autowired
    private GOrderMapper OrderMapper;
    
    @Override
    public int buyInsertsOrder(List<GOrder> listOrders)
    {
        return OrderMapper.insertsBatchOrder(listOrders);
    }
    
}
