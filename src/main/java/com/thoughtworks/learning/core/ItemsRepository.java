package com.thoughtworks.learning.core;

import java.util.List;

/**
 * Created by julie on 12/30/15.
 */
public interface ItemsRepository {
    List<Items> findItems();
    void putItems(String barcode);
    List<String> getInputs();
}
