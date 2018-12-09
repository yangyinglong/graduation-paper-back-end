package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.LoginRestDto;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;

public interface IAuthorizeLogical {
    GUserEntity getUserEntity(RegisterRestDto registerRestDto);

    void addUser(GUserEntity userEntityRegister);

    GUserEntity getUserEntity(LoginRestDto loginRestDto);
}
