package com.kk.srb.core.controller.admin;

import com.kk.common.exception.Assert;
import com.kk.common.result.R;
import com.kk.common.result.ResponseEnum;
import com.kk.srb.core.pojo.entity.IntegralGrade;
import com.kk.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin//允许可访问的域列表
@RestController
@RequestMapping("/admin/core/integralGrade")
@Api(tags = "积分等级管理")
public class AdminIntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("新增积分等级")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade) {
        //如果借款额度为空就手动抛出一个自定义的异常！
//        if(integralGrade.getBorrowAmount() == null){
//            //BORROW_AMOUNT_NULL_ERROR(-201, "借款额度不能为空"),
//            throw new BusinessException (ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
//        }
        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);

        boolean result = integralGradeService.save (integralGrade);
        if (result) {
            return R.ok ( ).message ("保存成功");
        } else {
            return R.error ( ).message ("保存失败");
        }
    }

    @GetMapping("/list")
    @ApiOperation("积分等级列表")
    public List<IntegralGrade> listAll() {
        return integralGradeService.list ( );
    }

    @ApiOperation("更新积分等级")
    @PutMapping("/update")
    public R updateById(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade) {
        boolean result = integralGradeService.updateById (integralGrade);
        if (result) {
            return R.ok ( ).message ("修改成功");
        } else {
            return R.error ( ).message ("修改失败");
        }
    }

    @ApiOperation("根据id获取积分等级")
    @GetMapping("/get/{id}")
    public R getById(
            @ApiParam(value = "数据id", required = true, example = "1")
            @PathVariable Long id
    ) {
        IntegralGrade integralGrade = integralGradeService.getById (id);
        if (integralGrade != null) {
            return R.ok ( ).data ("record", integralGrade);
        } else {
            return R.error ( ).message ("数据不存在");
        }
    }

    @ApiOperation(value = "根据id删除积分等级", notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R removeById(
            @ApiParam(value = "数据id", required = true, example = "1")
            @PathVariable Long id) {
        boolean result = integralGradeService.removeById (id);
        if (result) {
            //return R.setResult(ResponseEnum.UPLOAD_ERROR);
            return R.ok ( ).message ("删除成功");
        } else {
            return R.error ( ).message ("删除失败");
        }
    }
}
