package com.web.start.async;

import java.util.List;

/**
 * Created by web.start on 2016/7/30.
 */
public interface EventHandler {
    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
