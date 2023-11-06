package me.hiyacate.passwdBox.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.hiyacate.passwdBox.domain.Pwd;
import me.hiyacate.passwdBox.entity.R;
import me.hiyacate.passwdBox.mapper.PwdMapper;
import me.hiyacate.passwdBox.service.PwdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PwdServiceImpl extends ServiceImpl<PwdMapper, Pwd> implements PwdService {
    @Override
    public R save(JSONObject request) {
        String account = request.getString("account");
        String passwd = request.getString("passwd");
        String note = request.getString("note");
        Pwd pwd = new Pwd();
        pwd.setAccount(account);
        pwd.setPasswd(passwd);
        pwd.setNote(note);
        pwd.setCreateTime(new Date());
        pwd.setUpdateTime(new Date());
        boolean result = save(pwd);
        R r = result?R.success():R.error();
        return r;
    }
}
