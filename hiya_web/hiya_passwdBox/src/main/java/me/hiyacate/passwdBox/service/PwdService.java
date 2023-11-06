package me.hiyacate.passwdBox.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import me.hiyacate.passwdBox.domain.Pwd;
import me.hiyacate.passwdBox.entity.R;

public interface PwdService extends IService<Pwd> {
    R save(JSONObject request);

    R delete(JSONObject request);
}
