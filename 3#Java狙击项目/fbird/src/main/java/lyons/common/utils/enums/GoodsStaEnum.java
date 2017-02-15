/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.utils.enums;

/**
 * @Description: 商品常量
 * @ClassName: GoodsStaEnum
 * @author: lyons<zhanglei>
 * @date: 2017年2月14日 上午11:39:36
 * @version: [1.0]
 */
public enum GoodsStaEnum
{
    success(200,"操作成功");
    
    
    private int state;
    private String info;

    private GoodsStaEnum(String info)
    {
        this.info = info;
    }
    private GoodsStaEnum(int state, String info)
    {
        this.state = state;
        this.info = info;
    }
    public int getState()
    {
        return state;
    }
    public String getInfo()
    {
        return info;
    }
}
