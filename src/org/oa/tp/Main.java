package org.oa.tp;

import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Order;

public class Main {
    public static void main(String[] args) {
        DaoFacade daoFacade = new DaoFacade();
        daoFacade.getOrderDao().add(new Order("Album", "qwert", "5-7 days"));
        daoFacade.getOrderDao().findById(2);
        daoFacade.getOrderDao().loadAll();
        daoFacade.closeConnection();
    }
}