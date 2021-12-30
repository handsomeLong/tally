package com.tally.api.tallyapplyfriends;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyapplyfriends.model.TallyApplyFriends;
import com.tally.service.tallyapplyfriends.TallyApplyFriendsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 请求添加好友接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyApplyFriends")
//@Api(tags = "申请好友接口")
public class TallyApplyFriendsController extends BaseController {

    @Autowired
    private TallyApplyFriendsService tallyApplyFriendsService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyApplyFriends tallyApplyFriends) {
        return ApiResponse.success(tallyApplyFriendsService.create(tallyApplyFriends));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyApplyFriendsService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyApplyFriends tallyApplyFriends) {
        tallyApplyFriendsService.updateById(tallyApplyFriends);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyApplyFriends> pageWrap) {
        return ApiResponse.success(tallyApplyFriendsService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyApplyFriendsService.findById(id));
    }
}