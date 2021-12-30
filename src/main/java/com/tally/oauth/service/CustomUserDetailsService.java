package com.tally.oauth.service;
import com.tally.dao.tallyrole.model.TallyRole;
import com.tally.dao.tallyuser.TallyUserMapper;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.dao.tallyuserrole.model.TallyUserRole;
import com.tally.oauth.config.SecurityProps;
import com.tally.oauth.model.UserDetail;
import com.tally.service.tallyrole.TallyRoleService;
import com.tally.service.tallyuser.TallyUserService;
import com.tally.service.tallyuserrole.TallyUserRoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 登陆身份认证
 * @author: JoeTao
 * createAt: 2018/9/14
 */
@Component(value="userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   @Resource
   private TallyUserService tallyUserService;
   @Resource
   private TallyUserRoleService tallyUserRoleService;
//   @Resource
//   private TallyRoleService tallyRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TallyUser tallyUser = new TallyUser();
        tallyUser.setMobile(username);
        TallyUser user = tallyUserService.findOne(tallyUser);
         if (null==user){
            throw new UsernameNotFoundException("用户名不存在");
        }
        TallyUserRole tallyUserRole = new TallyUserRole();
         tallyUserRole.setUserId(Integer.valueOf(user.getId()+""));
        List<TallyUserRole> list = tallyUserRoleService.findList(tallyUserRole);
//        Set<GrantedAuthority> grantedAuthorities = list.stream()
//                .map(role -> new SimpleGrantedAuthority(tallyRoleService.findById(role.getRoleId()).getName()))
//                .collect(Collectors.toSet());
//        if(grantedAuthorities.size()==0){
//            grantedAuthorities = new HashSet<>();
//            TallyRole role = new TallyRole();
//            role.setId(0);
//            role.setName(SecurityProps.ROLE_ANONYMOUS);
//            role.setAlias("匿名用户");
//            role.setDescription("匿名用户");
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
//            grantedAuthorities.add(simpleGrantedAuthority);
//        }
        Set<GrantedAuthority> grantedAuthorities  = new HashSet<>();
            TallyRole role = new TallyRole();
            role.setId(0);
            role.setName(SecurityProps.ROLE_ANONYMOUS);
            role.setAlias("匿名用户");
            role.setDescription("匿名用户");
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorities.add(simpleGrantedAuthority);
//        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwdEncode = encoder.encode("123456");
        return UserDetail.builder()
                .id(Long.valueOf(user.getId()+""))
                .username(user.getMobile())
                .password(pwdEncode)
                .nickname(user.getNickName())
                .enabled(user.getUserStatus()!=101)
                .authorities(Collections.unmodifiableSet(grantedAuthorities))
                .build();
    }
}
