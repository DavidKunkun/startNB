package com.web.start.async;

import java.util.List;

/**
 * Created by web.start
 */
public interface EventHandler {
    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
