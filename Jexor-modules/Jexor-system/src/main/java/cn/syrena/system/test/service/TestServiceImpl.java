package cn.syrena.system.test.service;

import cn.syrena.system.test.domain.TestDomain;
import cn.syrena.system.test.mapper.TestMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements ITestService{

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<?> list() {
        return testMapper.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public String add() {
        TestDomain testDomain = new TestDomain();
        testDomain.setTitle("测试");
        testDomain.setContent("测试uuid主键生成");
        testMapper.insert(testDomain);
        return "插入成功";
    }
}
