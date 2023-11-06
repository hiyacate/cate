package me.hiyacate.passwdBox.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("pwd")
public class Pwd {
    Integer id;
    String account;
    String passwd;
    String note;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:sss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:sss")
    Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:sss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:sss")
    Date updateTime;
}
