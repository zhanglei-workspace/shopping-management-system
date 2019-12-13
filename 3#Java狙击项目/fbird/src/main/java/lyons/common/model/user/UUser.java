/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.model.user;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

import static lyons.common.utils.ModelSetterUtil.setFieldWithNotNullValue;

/**
 * @Description: 用户实体类
 * @ClassName: User
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 下午5:36:03
 * @version: [1.0]
 */
@Data
@NoArgsConstructor
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
    

    public void setuName(String uName) {
        this.uName = setFieldWithNotNullValue(uName);
    }

    public void setuNickName(String uNickName) {
        this.uNickName = setFieldWithNotNullValue(uNickName);
    }

    public void setuPassword(String uPassword) {
        
        this.uPassword = setFieldWithNotNullValue(uPassword);
    }

    public void setuEmail(String uEmail) {
        this.uEmail = setFieldWithNotNullValue(uEmail);
    }
}
