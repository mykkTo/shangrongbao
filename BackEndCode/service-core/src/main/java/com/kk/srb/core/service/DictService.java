package com.kk.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kk.srb.core.pojo.dto.ExcelDictDTO;
import com.kk.srb.core.pojo.entity.Dict;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author mykk
 * @since 2022-04-27
 */
public interface DictService extends IService<Dict> {
    void importData(InputStream inputStream);

    List<ExcelDictDTO> listDictData();

    List<Dict> listByParentId(Long parentId);
}
