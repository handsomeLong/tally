package com.tally.service.tallyuser;

import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.service.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * 示例单元测试
 * @author 131****2893
 * @date 2020/10/26 16:38
 */
@Slf4j
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = TallyUserServiceTest.class)
@Transactional
public class TallyUserServiceTest extends BaseTest {

    @Autowired
    private TallyUserService tallyUserService;

    @Test
    public void createTest() {
        TallyUser user = new TallyUser();
        user.setMobile("11111");
        print(tallyUserService.create(user));
    }

    @Test
    public void deleteByIdTest() {
        tallyUserService.deleteById(1);
        print(null);
    }

    @Test
    public void deleteByIdInBatchTest() {
        tallyUserService.deleteByIdInBatch(Arrays.asList(1, 2 ,3));
        print(null);
    }

    @Test
    public void updateByIdTest() {
        TallyUser user = new TallyUser();
        user.setId(1);
//        tallyuser.setNickname("test");
        tallyUserService.updateById(user);
        print(null);
    }

    @Test
    public void updateByIdInBatchTest() {
        TallyUser user1 = new TallyUser();
        user1.setId(1);
        user1.setNickName("test");
        TallyUser user2 = new TallyUser();
        user2.setId(2);
        user2.setNickName("test");
        tallyUserService.updateByIdInBatch(Arrays.asList(user1, user2));
        print(null);
    }

    @Test
    public void findByIdTest() {
        print(tallyUserService.findById(1));
    }

    @Test
    public void findOneTest() {
        TallyUser user = new TallyUser();
        user.setNickName("test");
        print(tallyUserService.findOne(user));
    }

    @Test
    public void findListTest() {
        TallyUser user = new TallyUser();
//        tallyuser.setNickname("test");
        user.setNickName("test");
        print(tallyUserService.findList(user));
    }

    @Test
    public void findPageTest() {
        TallyUser user = new TallyUser();
        user.setNickName("test");
        PageWrap<TallyUser> pageWrap = new PageWrap<>();
        pageWrap.setModel(user);
        print(tallyUserService.findPage(pageWrap));
    }

    @Test
    public void countTest() {
        TallyUser user = new TallyUser();
        user.setNickName("test");
        print(tallyUserService.count(user));
    }
}