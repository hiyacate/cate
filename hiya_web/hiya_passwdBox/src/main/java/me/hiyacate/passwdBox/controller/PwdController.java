package me.hiyacate.passwdBox.controller;

import com.alibaba.fastjson.JSONObject;
import me.hiyacate.passwdBox.entity.R;
import me.hiyacate.passwdBox.service.PwdService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pwd")
public class PwdController {

    @Resource
    private PwdService pwdService;

    @PostMapping("/save")
    public R save(@RequestBody JSONObject request){
        R result = pwdService.save(request);
        return result;
    }

    @PostMapping("/delete")
    public R delete(@RequestBody JSONObject request){
        R result = pwdService.delete(request);
        return result;
    }

}
