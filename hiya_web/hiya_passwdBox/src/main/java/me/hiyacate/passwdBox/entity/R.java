package me.hiyacate.passwdBox.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class R {
    String code;
    String message;
    JSONObject data;

    public static R success(){
        R r = new R();
        r.setCode("200");
        r.setMessage("操作成功");
        r.setData(null);
        return r;
    }

    public static R error(){
        R r = new R();
        r.setCode("400");
        r.setMessage("操作失败");
        r.setData(null);
        return r;
    }

    public static R error(String message){
        R r = new R();
        r.setCode("400");
        r.setMessage(message);
        r.setData(null);
        return r;
    }
}

