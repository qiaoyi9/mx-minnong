package com.mx.minnong.exception;

import com.mx.minnong.myenum.NetEnum;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 18:42  2018/11/16
 * @Description: 用户异常处理类
 */
public class NetException extends RuntimeException {

    private Integer code;

    public NetException(NetEnum netEnum){
        super(netEnum.getMsg());
        this.code=netEnum.getCode();
    }

    public NetException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
