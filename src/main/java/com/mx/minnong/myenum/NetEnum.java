package com.mx.minnong.myenum;

import lombok.Getter;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 18:57  2018/11/16
 * @Description:全局异常状态
 */
@Getter
public enum NetEnum {
    CREATEUSER_PARAM_ISEMPTY(50071,"用户参数不能为空!"),
    USER_IDPARAM_ISEMPTY(403,"用户id不能为空"),
    FILENAME_ISEMPTY(50021,"文件名不能为空"),
    CLASS_ID_ISNOTEMPTY(403,"父类id不能为空"),
    ID_ISEMPTY(403,"主键不能为空"),
    PRO_RECOMMEND_ISNOTEMPTY(403,"推荐标识不能为空"),
    PRODUCE_ID_ISNOTEMPTY(403,"产品id不能为空"),
    PROIMGPRO_ISNOTEMPTY(403,"产品id不能为空")
    ;
    private Integer code;

    private String msg;

    NetEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
