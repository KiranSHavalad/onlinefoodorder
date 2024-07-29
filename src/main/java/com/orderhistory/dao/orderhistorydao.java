package com.orderhistory.dao;

import java.util.List;

import com.orderhistory.model.Orderhistory;

public interface orderhistorydao {
     int save(Orderhistory oh);
     Orderhistory get(int orderhistoryid);
     List<Orderhistory> getAll(int userid);
     int update(Orderhistory oh);
     int delete(int orderhistoryid);
}
