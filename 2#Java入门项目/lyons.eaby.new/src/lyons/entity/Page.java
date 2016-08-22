package lyons.entity;

/**
 * 
 * 分页实体类
 * 
 * @author  lyons(zhanglei)
 */
public class Page
{
    //总条数
    private int totalNumber ;
    
    //当前页数
    private int currentPage;
    
    //总页数
    private int totalPage;
    
    //单页显示条数
    private int pageNumber = 2;
    
    //从第几条开始取值
    private int dbIndex;
    
    //本次总计取多少条
    private int dbNumber;

    
    public void count()
    {
        //计算总页数
        int totalPageTemp = this.totalNumber/this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber)==0?0:1;//补页计算
        totalPageTemp += plus;
        if (totalPageTemp <= 0)
        {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;
        
        //设置当前页数。当总页数小于当前页数时 当前页数=总页数
        if (this.totalPage < this.currentPage)
        {
            this.currentPage = this.totalPage;
        }
    }
    
    public Page(){}
    
    public int getTotalNumber()
    {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber)
    {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getPageNumber()
    {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public int getDbIndex()
    {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex)
    {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber()
    {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber)
    {
        this.dbNumber = dbNumber;
    }
}
