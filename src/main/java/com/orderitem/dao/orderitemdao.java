package com.orderitem.dao;

import java.util.List;

import com.orderitem.model.Orderitem;

public interface orderitemdao {
      int save(Orderitem oi);
      Orderitem get(int orderitemid);
      List<Orderitem> getAll();
      int update(Orderitem oi);
      int delete(int orderitemid);
 }
