/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.goods;

import java.util.List;

import lyons.common.model.goods.GCar;

/**
 * @Description: 购物车服务类
 * @ClassName: GCarService
 * @author: lyons<zhanglei>
 * @date: 2017年2月13日 下午8:10:23
 * @version: [1.0]
 */
public interface GCarService
{
    /** find all goods **/
    List<GCar> findMyCar(String username);

    /** delete goods from my car */
    int carDelete(String username, String gCarGId);

    /** add goods to car*/
    int carAdd(GCar car);

}
