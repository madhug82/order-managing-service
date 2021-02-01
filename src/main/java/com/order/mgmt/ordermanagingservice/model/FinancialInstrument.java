package com.order.mgmt.ordermanagingservice.model;

public class FinancialInstrument {

    private Long instrumentId;
    private String instrumentName;
    private InstrumentType type;

    public FinancialInstrument() {
    }

    public FinancialInstrument(Long instrumentId, String instrumentName, InstrumentType type) {
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.type = type;
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public InstrumentType getType() {
        return type;
    }
}
