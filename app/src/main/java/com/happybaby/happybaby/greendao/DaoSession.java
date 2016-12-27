package com.happybaby.happybaby.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.happybaby.happybaby.bean.ShoppingCartBean;

import com.happybaby.happybaby.greendao.ShoppingCartBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig shoppingCartBeanDaoConfig;

    private final ShoppingCartBeanDao shoppingCartBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        shoppingCartBeanDaoConfig = daoConfigMap.get(ShoppingCartBeanDao.class).clone();
        shoppingCartBeanDaoConfig.initIdentityScope(type);

        shoppingCartBeanDao = new ShoppingCartBeanDao(shoppingCartBeanDaoConfig, this);

        registerDao(ShoppingCartBean.class, shoppingCartBeanDao);
    }
    
    public void clear() {
        shoppingCartBeanDaoConfig.clearIdentityScope();
    }

    public ShoppingCartBeanDao getShoppingCartBeanDao() {
        return shoppingCartBeanDao;
    }

}