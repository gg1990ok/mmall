package com.mmall.service.Impl;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.service.iProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("iProductService")
public class ProductServiceImpl implements iProductService {

    public ServerResponse saveOrUpdateProduct(Product product) {
        if(product != null) {
            // set main image
            if(StringUtils.isNotBlank(product.getSubImages())) {
                String[] subImageArray = product.getSubImages().split(",");
                if(subImageArray.length > 0) {
                    product.setMainImage(subImageArray[0]);
                }
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数错误！");
    }
}
