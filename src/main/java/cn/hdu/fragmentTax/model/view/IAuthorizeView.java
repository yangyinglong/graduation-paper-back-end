package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.dto.response.UserRespDto;

public interface IAuthorizeView {
    GUserEntity getUserEntity(RegisterRestDto registerRestDto);

    UserRespDto getUserResp(GUserEntity userEntityRegister);
}
