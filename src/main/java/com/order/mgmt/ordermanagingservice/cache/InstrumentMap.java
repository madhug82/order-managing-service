package com.order.mgmt.ordermanagingservice.cache;

import com.order.mgmt.ordermanagingservice.model.FinancialInstrument;
import com.order.mgmt.ordermanagingservice.model.InstrumentType;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

public class InstrumentMap {

    public static final Map<Long, FinancialInstrument> instrumentMap = new ConcurrentHashMap<Long, FinancialInstrument>();

    static{
        instrumentMap.put(1L, new FinancialInstrument(1L,"Apple",InstrumentType.EQUITY));
        instrumentMap.put(2L, new FinancialInstrument(2L,"Google",InstrumentType.EQUITY));
        instrumentMap.put(3L, new FinancialInstrument(3L,"Google",InstrumentType.EQUITY));
    }

    public static FinancialInstrument getInstrumentForId(Long id){

        return instrumentMap.get(id);
    }



}
