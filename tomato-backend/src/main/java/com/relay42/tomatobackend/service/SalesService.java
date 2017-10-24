package com.relay42.tomatobackend.service;

import com.relay42.tomatobackend.domain.Sale;

import java.util.Collection;

public interface SalesService {
    Collection<Sale> getSales(int size);
}
