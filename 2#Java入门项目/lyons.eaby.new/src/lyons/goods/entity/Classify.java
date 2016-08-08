package lyons.goods.entity;

/**
 * 
 * 商品类别实体类
 * 
 * @author  lyons(zhanglei)
 */
public class Classify
{
    private int gid;      //商品分类代号
    private String gname; //商品名字
    
    public Classify(){};
    
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
