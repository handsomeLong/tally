package com.tally.api.tallywxalipayaccount;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccount;
import com.tally.service.tallywxalipayaccount.TallyWxAlipayAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信支付宝账号表接口
 * @author 131****2893
 * @date 2020/10/28 15:18
 */
@RestController
@RequestMapping("/api/tallyWxAlipayAccount")
//@Api(tags = "微信支付宝账号接口")
public class TallyWxAlipayAccountController extends BaseController {

    @Autowired
    private TallyWxAlipayAccountService tallyWxAlipayAccountService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyWxAlipayAccount tallyWxAlipayAccount) {
        return ApiResponse.success(tallyWxAlipayAccountService.create(tallyWxAlipayAccount));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyWxAlipayAccountService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyWxAlipayAccount tallyWxAlipayAccount) {
        tallyWxAlipayAccountService.updateById(tallyWxAlipayAccount);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyWxAlipayAccount> pageWrap) {
        return ApiResponse.success(tallyWxAlipayAccountService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyWxAlipayAccountService.findById(id));
    }
}