package com.st.smartsecurity.service;

import com.st.smartsecurity.pojo.po.QdUser;

public interface LoginService {
    QdUser login(String name, int workNumber, String openId);
}
