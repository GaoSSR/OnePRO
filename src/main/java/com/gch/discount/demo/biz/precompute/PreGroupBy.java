package com.gch.discount.demo.biz.precompute;

import com.gch.discount.core.model.common.DiscountWrapper;
import com.gch.discount.core.model.goods.GoodsInfo;
import com.gch.discount.core.model.goods.GoodsItem;
import com.gch.discount.core.precompute.PreCompute;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PreGroupBy implements PreCompute<GoodsItem> {
    @Override
    public Set<String> matchTypes() {
        return Sets.newHashSet("zhekou");
    }

    @Override
    public void preComputeItems(List<GoodsItem> items, DiscountWrapper discount, Map<String, Object> preCompute) {
        preCompute.put("GroupBySkuIdPreCompute", items.stream().collect(Collectors.groupingBy
                (GoodsInfo::getSkuId, Collectors.collectingAndThen(Collectors.toList(),
                        e -> e.stream().sorted().collect(Collectors.toList())))));
    }
}
