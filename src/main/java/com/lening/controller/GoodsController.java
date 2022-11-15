package com.lening.controller;

import com.github.pagehelper.PageInfo;
import com.lening.entity.GoodsBean;
import com.lening.service.GoodsServce;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsServce goodsServce;

    /**
     * 分页查询全部商品信息
     * 根据商品名称模糊查询商品信息
     *
     * @param searchEntity
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllConnAndPage")
    public PageInfo<GoodsBean> findAllConnAndPage(@RequestBody GoodsBean searchEntity,
                                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "3") Integer pageSize) {
        return goodsServce.findAllConnAndPage(searchEntity, pageNum, pageSize);
    }
}
