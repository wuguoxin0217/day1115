package com.lening.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.entity.GoodsBean;
import com.lening.entity.TypeBean;
import com.lening.mapper.GoodsMapper;
import com.lening.mapper.TypeMapper;
import com.lening.service.GoodsServce;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServceImpl implements GoodsServce {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private TypeMapper typeMapper;

    /**
     * 分页查询全部商品信息
     * 根据商品名称模糊查询商品信息
     * @param searchEntity
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<GoodsBean> findAllConnAndPage(GoodsBean searchEntity, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(GoodsBean.class);
        Example.Criteria criteria = example.createCriteria();

        if (searchEntity != null){
            if (!StringUtils.isEmpty(searchEntity.getGname())){
                criteria.andLike("gname","%"+searchEntity.getGname()+"%");
            }
        }

        List<GoodsBean> list = goodsMapper.selectByExample(example);

        for (GoodsBean goodsBean : list) {
            TypeBean typeBean = typeMapper.selectByPrimaryKey(goodsBean.getTid());
            goodsBean.setTypeBean(typeBean);
        }

        PageInfo<GoodsBean> pageInfo = new PageInfo<GoodsBean>(list);
        return pageInfo;
    }
}