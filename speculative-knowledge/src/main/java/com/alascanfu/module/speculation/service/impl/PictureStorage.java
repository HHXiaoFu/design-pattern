package com.alascanfu.module.speculation.service.impl;

import com.alascanfu.module.speculation.entity.Image;
import com.alascanfu.module.speculation.entity.Picture;
import com.alascanfu.module.speculation.entity.PictureMetaInfo;
import com.alascanfu.module.speculation.service.IPictureStorage;

/**
 * <p>
 * 图片存储接口类的具体业务实现类
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/7/2 1:19
 **/
public class PictureStorage implements IPictureStorage {
    @Override
    public void savePicture(Picture picture) {
    
    }
    
    @Override
    public Image getPicture(String pictureId) {
        return null;
    }
    
    @Override
    public void deletePicture(String pictureId) {
    
    }
    
    @Override
    public void modifyMetaInfo(String pictureId, PictureMetaInfo metaInfo) {
    
    }
}
