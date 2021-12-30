package com.tally.api.tallyinouttype;
import com.tally.api.BaseController;
import com.tally.api.outputDto.TallyTypeOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallyinouttype.model.TallyInOutType;
import com.tally.service.tallybusinesstype.TallyBusinessTypeService;
import com.tally.service.tallyinouttype.TallyInOutTypeService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 收支类型接口
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@RestController
@RequestMapping("/api/tallyInOutType")
@Api(tags = "收支类型")
public class TallyInOutTypeController extends BaseController {

    @Autowired
    private TallyInOutTypeService tallyInOutTypeService;
    @Autowired
    private TallyBusinessTypeService tallyBusinessTypeService;

    @PostMapping("/list")
    public ApiResponse findList (TallyInOutType tallyInOutType, @RequestParam(value="isb",defaultValue="true")boolean isb, HttpServletRequest request) {
        String userId = getUserId(request);
        tallyInOutType.setUserId(Integer.valueOf(userId));
        List<TallyTypeOutputDto> resultList = null;
        try {
            TallyBusinessType businessType = new TallyBusinessType();
            businessType.setIsEnable(1);
            List<TallyBusinessType> typeList = tallyBusinessTypeService.findList(businessType);
            TallyInOutType tallyInOutType1 = new TallyInOutType();
            tallyInOutType1.setUserId(Integer.valueOf(userId));
            List<TallyInOutType> inOutTypes = tallyInOutTypeService.findList(tallyInOutType1);
            resultList = new ArrayList<>();
            for (TallyBusinessType btype:typeList) {
                if("SR".equals(btype.getTypeCode())||"ZC".equals(btype.getTypeCode())){
                    for (TallyInOutType inOutType:inOutTypes) {
                        if(inOutType.getType()==btype.getType()){
                            TallyTypeOutputDto tallyTypeOutputDto = new TallyTypeOutputDto();
                            tallyTypeOutputDto.setCollectTypeName(btype.getTypeName()+"-"+inOutType.getTypeName());
                            tallyTypeOutputDto.setInOutTypeId(inOutType.getId());
                            tallyTypeOutputDto.setInOutTypeName(inOutType.getTypeName());
                            tallyTypeOutputDto.setSubClassType(btype.getSubClassType());
                            tallyTypeOutputDto.setType(btype.getType());
                            tallyTypeOutputDto.setTypeCode(btype.getTypeCode());
                            tallyTypeOutputDto.setTypeId(btype.getId());
                            tallyTypeOutputDto.setTypeName(btype.getTypeName());
                            resultList.add(tallyTypeOutputDto);
                        }
                    }
                }else if(isb){
                    TallyTypeOutputDto tallyTypeOutputDto = new TallyTypeOutputDto();
                    tallyTypeOutputDto.setCollectTypeName(btype.getTypeName());
                    tallyTypeOutputDto.setSubClassType(btype.getSubClassType());
                    tallyTypeOutputDto.setType(btype.getType());
                    tallyTypeOutputDto.setTypeCode(btype.getTypeCode());
                    tallyTypeOutputDto.setTypeId(btype.getId());
                    tallyTypeOutputDto.setTypeName(btype.getTypeName());
                    resultList.add(tallyTypeOutputDto);
                }
            }
            //条件查询
            resultList = resultList.stream().filter(new Predicate<TallyTypeOutputDto>() {
                @Override
                public boolean test(TallyTypeOutputDto tallyTypeOutputDto) {
                    if(StringUtils.isNotBlank(tallyInOutType.getTypeName())){
                        if(tallyTypeOutputDto.getCollectTypeName().contains(tallyInOutType.getTypeName())){
                            return true;
                        }else {
                            return false;
                        }
                    }
                    return true;
                }
            }).filter(new Predicate<TallyTypeOutputDto>() {
                @Override
                public boolean test(TallyTypeOutputDto tallyTypeOutputDto) {
                    if(null!=tallyInOutType.getType()){
                        if(tallyInOutType.getType()==tallyTypeOutputDto.getType()){
                            return true;
                        }else {
                            return false;
                        }
                    }
                    return true;
                }
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.failed(e.getMessage());
        }
        return ApiResponse.success(resultList);
    }
    @PostMapping("/add")
    public ApiResponse add(TallyInOutType tallyInOutType, HttpServletRequest request) {
        String userId = getUserId(request);
        tallyInOutType.setUserId(Integer.valueOf(userId));
        TallyTypeOutputDto typeOutputDto = tallyInOutTypeService.save(tallyInOutType);
        return ApiResponse.success(typeOutputDto);
    }
//    /**
//     * 创建
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyInOutType tallyInOutType) {
//        return ApiResponse.success(tallyInOutTypeService.create(tallyInOutType));
//    }
//
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyInOutTypeService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyInOutType tallyInOutType) {
//        tallyInOutTypeService.updateById(tallyInOutType);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 分页查询
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @PostMapping("/page")
//    public ApiResponse findPage (@RequestBody PageWrap<TallyInOutType> pageWrap) {
//        return ApiResponse.success(tallyInOutTypeService.findPage(pageWrap));
//    }
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyInOutTypeService.findById(id));
//    }
}