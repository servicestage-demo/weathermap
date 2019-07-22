package com.service.userservice;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

public class UserApplication 
{
    public static void main( String[] args ) throws Exception
    {
        Log4jUtils.init();
        BeanUtils.init();
    }
}
