package com.tally.api.tallyuserfriends;

import com.tally.api.BaseController;
import com.tally.api.outputDto.TallyUserFriendsInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserfriends.model.TallyUserFriends;
import com.tally.service.tallyuserfriends.TallyUserFriendsService;
import com.tally.service.tallyuserpergrant.TallyUserPerGrantService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户好友关系表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyUserFriends")
//@Api(tags = "用户好友关系接口")
public class TallyUserFriendsController extends BaseController {

    @Autowired
    private TallyUserFriendsService tallyUserFriendsService;
    @Autowired
    private TallyUserPerGrantService tallyUserPerGrantService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyUserFriends tallyUserFriends) {
        return ApiResponse.success(tallyUserFriendsService.create(tallyUserFriends));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyUserFriendsService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyUserFriends tallyUserFriends) {
        tallyUserFriendsService.updateById(tallyUserFriends);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/friendsList")
    public ApiResponse friendsList ( Integer page, TallyUserFriendsInputDto tallyUserFriendsInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        tallyUserFriendsInputDto.setUserId(Integer.valueOf(userId));
        Map<String, List> map = tallyUserPerGrantService.getGrantUserIds(userId, "ADD_BILL");
        List userIdList = map.get("userIdList");
        userIdList.add(Integer.valueOf(userId));
        tallyUserFriendsInputDto.setUserIdList(userIdList);
        PageWrap pageWrap = new PageWrap();
        pageWrap.setModel(tallyUserFriendsInputDto);
        pageWrap.setPage(page);
        return ApiResponse.success(tallyUserFriendsService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyUserFriendsService.findById(id));
    }
}