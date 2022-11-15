package com.lening.service;

import com.github.pagehelper.PageInfo;
import com.lening.entity.GoodsBean;

public interface GoodsServce {

    /**
     * 分页查询全部商品信息
     * 根据商品名称模糊查询商品信息
     * @param searchEntity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<GoodsBean> findAllConnAndPage(GoodsBean searchEntity, Integer pageNum, Integer pageSize);
}
