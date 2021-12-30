package com.tally.api.tallyusergrade;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyusergrade.model.TallyUserGrade;
import com.tally.service.tallyusergrade.TallyUserGradeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户等级接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyUserGrade")
//@Api(tags = "用户等级接口")
public class TallyUserGradeController extends BaseController {

    @Autowired
    private TallyUserGradeService tallyUserGradeService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyUserGrade tallyUserGrade) {
        return ApiResponse.success(tallyUserGradeService.create(tallyUserGrade));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyUserGradeService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyUserGrade tallyUserGrade) {
        tallyUserGradeService.updateById(tallyUserGrade);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyUserGrade> pageWrap) {
        return ApiResponse.success(tallyUserGradeService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyUserGradeService.findById(id));
    }
}