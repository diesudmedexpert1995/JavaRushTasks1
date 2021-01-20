package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public interface EventDataRow {
    void register(EventDataRow data);
    EventType getType();
    Date getDate();
    int getTime();

}
