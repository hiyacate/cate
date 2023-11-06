package me.hiyacate.passwdBox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.hiyacate.passwdBox.domain.Pwd;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PwdMapper extends BaseMapper<Pwd> {
}
