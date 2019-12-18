package com.st.smartsecurity.service;

import com.st.smartsecurity.pojo.dto.QdUserDTO;

public interface LoginService {
    QdUserDTO login(String name, Integer workNumber, String openId);
}
