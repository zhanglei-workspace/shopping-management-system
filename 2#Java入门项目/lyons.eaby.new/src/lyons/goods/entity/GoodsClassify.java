package lyons.goods.entity;

/**
 * 
 * 商品类别实体类
 * 
 * @author  lyons(zhanglei)
 */
public class GoodsClassify
{
    private int gid = -1; //商品分类代号
    private String gname; //商品名字
    
    public GoodsClassify(){};
    
    public int getGid()
    {
        return gid;
    }
    public void setGid(int gid)
    {
        this.gid = gid;
    }
    public String getGname()
    {
        return gname;
    }
    public void setGname(String gname)
    {
        this.gname = gname;
    }
}
