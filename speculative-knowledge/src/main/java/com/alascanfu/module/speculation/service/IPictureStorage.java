package com.alascanfu.module.speculation.service;

import com.alascanfu.module.speculation.entity.Image;
import com.alascanfu.module.speculation.entity.Picture;
import com.alascanfu.module.speculation.entity.PictureMetaInfo;

/**
 * <p>
 * 图片存储接口类
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/7/2 1:17
 **/
public interface IPictureStorage {
    void savePicture(Picture picture);
    Image getPicture(String pictureId);
    void deletePicture(String pictureId);
    void modifyMetaInfo(String pictureId, PictureMetaInfo metaInfo);
}
