package cn.syrena.system.test.mapper;

import cn.syrena.system.test.domain.TestDomain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<TestDomain> {
}
