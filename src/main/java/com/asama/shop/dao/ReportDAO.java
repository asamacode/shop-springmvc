package com.asama.shop.dao;

import java.util.List;

public interface ReportDAO {

    List<Object[]> inventory();
    List<Object[]> revenueByCategory();
    List<Object[]> revenueByCustomer();
    List<Object[]> revenueByYear();
    List<Object[]> revenueByQuarter();
    List<Object[]> revenueByMonth();
}
