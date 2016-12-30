package com.happybaby.happybaby.greendao;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * 表的管理类
 */

public class ShoppoingCartManager {
    private Context context;

    public ShoppoingCartManager(Context context) {
        this.context = context;
    }
    private ShoppingCartBeanDao getshoppingCartBeanDao(){
        DaoSession daoSession = DBManager.getDaoSession(context);
        return daoSession.getShoppingCartBeanDao();
    }

    /**
     * 添加一条数据
     * @param
     */
    public void insert(ShoppingCartBean shoppingCartBean){
        if (null == shoppingCartBean){
            return;
        }
        getshoppingCartBeanDao().insert(shoppingCartBean);
    }

    /**
     * 添加多条数据
     * @param
     */
    public void insertAll(List<ShoppingCartBean> list){
        if(null == list || 0 == list.size()){
            return;
        }
        getshoppingCartBeanDao().insertInTx(list);
    }
    /**
     * 删除一条数据
     * @param
     */
    public void delete(ShoppingCartBean shoppingCartBean){
        if (null == shoppingCartBean){
            return;
        }
        getshoppingCartBeanDao().delete(shoppingCartBean);

    }
    /**
     * 删除所有数据
     */
    public void deleteAll() {
        getshoppingCartBeanDao().deleteAll();
    }
    /**
     * 更新一条数据
     * @param
     */
    public void update (ShoppingCartBean shoppingCartBean){
        if (shoppingCartBean == null) {
            return;
        }
        getshoppingCartBeanDao().update(shoppingCartBean);
    }

    /**
     * 更新多条数据
     * @param list
     */
    public void updateAll(List<ShoppingCartBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        getshoppingCartBeanDao().updateInTx(list);
    }
    /**
     * 根据 id 获得查询数据
     * @param id
     * @return
     */

    public ShoppingCartBean getShoppingCartBean(Long id){
        List<ShoppingCartBean> list = getshoppingCartBeanDao().queryBuilder().where(ShoppingCartBeanDao.Properties.Id.eq(id)).list();
        if (list == null || list.size() == 0){
            return null;
        }

        return list.get(0);
    }
    public List<ShoppingCartBean> getAll(){
        List<ShoppingCartBean> list = getshoppingCartBeanDao().queryBuilder().list();
        return list;
    }
}
