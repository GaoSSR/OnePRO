package com.gch.discount.demo.biz;

import com.gch.discount.core.model.common.CalcStage;
import com.gch.discount.core.model.common.CalcState;
import com.gch.discount.core.model.common.DiscountContext;
import com.gch.discount.core.model.goods.GoodsItem;
import com.gch.discount.core.permutation.Permutation;
import com.gch.discount.demo.biz.constant.Constant;

import java.util.List;

public class Flowable extends Permutation<GoodsItem> {
    @Override
    protected boolean enableOptimize(List<Byte> a) {
        return false;
    }

    @Override
    protected boolean sameOptimumCondition(CalcStage[] curStages) {
        return false;
    }

    @Override
    protected void resetContext(DiscountContext<GoodsItem> context) {

    }

    @Override
    protected void resetItems(GoodsItem item) {
        item.getExtra().put(Constant.UPDATEABLEPRICE, item.getSalePrice());
    }

    @Override
    protected void makeSnapshot(CalcState<GoodsItem> state, DiscountContext<GoodsItem> context) {

    }

    @Override
    protected void backToSnapshot(CalcState<GoodsItem> state, DiscountContext<GoodsItem> context) {

    }
}
