package com.kk.srb.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.srb.core.listener.ExcelDictDTOListener;
import com.kk.srb.core.mapper.DictMapper;
import com.kk.srb.core.pojo.dto.ExcelDictDTO;
import com.kk.srb.core.pojo.entity.Dict;
import com.kk.srb.core.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author mykk
 * @since 2022-04-27
 */
@Service
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importData(InputStream inputStream) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read (inputStream, ExcelDictDTO.class, new ExcelDictDTOListener (baseMapper)).sheet ( ).doRead ( );
        log.info ("importData finished");
    }

    @Override
    public List<ExcelDictDTO> listDictData() {
        List<Dict> dictList = baseMapper.selectList (null);
        // 创建ExcelDictDTO列表，将Dict列表转换成ExcelDictDTO列表
        ArrayList<ExcelDictDTO> excelDictDTOList = new ArrayList<> (dictList.size ( ));

        dictList.forEach (dict -> {
            ExcelDictDTO excelDictDTO = new ExcelDictDTO ( );
            BeanUtils.copyProperties (dict, excelDictDTO);
            excelDictDTOList.add (excelDictDTO);
        });
        return excelDictDTOList;
    }

    @Override
    public List<Dict> listByParentId(Long parentId) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<Dict> ( ).eq ("parent_id", parentId);
        List<Dict> dictList = baseMapper.selectList (wrapper);
        dictList.forEach (dict -> {
            // 如果有子节点，则是非叶子节点
            boolean children = hasChildren (dict.getId ( ));
            dict.setHasChildren (children);
        });
        return dictList;
    }

    /**
     * 判断该节点是否有子节点
     */
    private boolean hasChildren(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<Dict> ( ).eq ("parent_id", id);
        Integer count = baseMapper.selectCount (wrapper);
        return count > 0;
    }
}
