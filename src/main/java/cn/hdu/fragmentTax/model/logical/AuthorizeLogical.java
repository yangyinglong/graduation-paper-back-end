package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dao.mapper.IGUserMapper;
import cn.hdu.fragmentTax.dto.request.LoginRestDto;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeLogical implements IAuthorizeLogical{

    @Autowired
    private IGUserMapper userMapper;

    @Override
    public GUserEntity getUserEntity(RegisterRestDto registerRestDto) {
        try {
            // todo 根据手机号码查找
            return userMapper.queryByKey(registerRestDto.getId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addUser(GUserEntity userEntityRegister) {
        userMapper.insert(userEntityRegister);
    }

    @Override
    public GUserEntity getUserEntity(LoginRestDto loginRestDto) {
        GUserEntity userEntity = null;
        try {
            // todo 根据手机号码查找
            userEntity = userMapper.queryByKey(loginRestDto.getId());
            if (FormatUtil.isEmpty(userEntity)) {
                userEntity = userMapper.queryByPhone(loginRestDto.getId());            }
            return userEntity;
        } catch (Exception e) {
            return null;
        }
    }
}
