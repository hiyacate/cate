package me.hiyacate.passwdBox.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Override
    public R delete(JSONObject request) {
        Integer id = request.getInteger("id");
        Pwd passwd = getById(id);
        if(passwd==null){
            return R.error("根据id未查得要删除的内容");
        }
        if(id==null){
            return R.error("缺少删除主键");
        }

        boolean result = removeById(id);
        R r = result?R.success():R.error("删除失败");
        return r;
    }
}
