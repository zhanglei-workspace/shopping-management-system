/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.model.user;

import java.util.Date;

import net.sf.json.JSONObject;

/**
 * @Description: 用户实体类
 * @ClassName: User
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 下午5:36:03
 * @version: [1.0]
 */
public class UUser
{
    /** 用户名 */
    private String uName;
    /** 用户id */
    private int uId;
    /** 昵称 */
    private String uNickName;
    /** 0:女  1:男 */
    private int uSex;
    /** 密码 */
    private transient String uPassword;
    /** 邮箱 */
    private String uEmail;
    /** -2:未启用  2:启用 */
    private int uState;
    /** -3:非卖家  3:卖家 */
    private int uIsSeller;
    /** 最后登录时间 */
    private Date uLastLoginTime;
    /** 创建日期 */
    private Date uCreateDate;
    
    public UUser() {}
    public UUser(String uName, int uId, String uNickName, int uSex, String uPassword, String uEmail, int uState,
        int uIsSeller, Date ulastLoginTime, Date uCreateDate)
    {
        this.uName = uName;
        this.uId = uId;
        this.uNickName = uNickName;
        this.uSex = uSex;
        this.uPassword = uPassword;
        this.uEmail = uEmail;
        this.uState = uState;
        this.uIsSeller = uIsSeller;
        this.uLastLoginTime = ulastLoginTime;
        this.uCreateDate = uCreateDate;
    }
    
    @Override
    public String toString()
    {
        return JSONObject.fromObject(this).toString();
    }
    
    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }
    public int getuId() {
        return uId;
    }
    public void setuId(int uId) {
        this.uId = uId;
    }
    public String getuNickName() {
        return uNickName;
    }
    public void setuNickName(String uNickName) {
        this.uNickName = uNickName == null ? null : uNickName.trim();
    }
    public int getuSex() {
        return uSex;
    }
    public void setuSex(int uSex) {
        this.uSex = uSex;
    }
    public String getuPassword() {
        return uPassword;
    }
    public void setuPassword(String uPassword) {
        
        this.uPassword = uPassword == null ? null : uPassword.trim();     
    }
    public String getuEmail() {
        return uEmail;
    }
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }
    public int getuState() {
        return uState;
    }
    public void setuState(int uState) {
        this.uState = uState;
    }
    public int getuIsSeller() {
        return uIsSeller;
    }
    public void setuIsSeller(int uIsSeller) {
        this.uIsSeller = uIsSeller;
    }
    public Date getulastLoginTime()
    {
        return uLastLoginTime;
    }
    public void setulastLoginTime(Date ulastLoginTime)
    {
        this.uLastLoginTime = ulastLoginTime;
    }
    public Date getuCreateDate() {
        return uCreateDate;
    }
    public void setuCreateDate(Date uCreateDate) {
        this.uCreateDate = uCreateDate;
    }

}
