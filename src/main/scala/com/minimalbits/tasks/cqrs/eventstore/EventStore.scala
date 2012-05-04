package com.minimalbits.tasks.cqrs.eventstore

import java.util.ArrayList
import com.minimalbits.tasks.cqrs.domain.AggregateRoot
import com.minimalbits.tasks.cqrs.eventstore.{EventPublisher, EventDescriptor}
import com.minimalbits.tasks.cqrs.event.DomainEvent
import collection.mutable.{ArrayBuffer, Buffer, MutableList}
import com.minimalbits.tasks.cqrs.util.Defense
import com.minimalbits.tasks.cqrs.dao.BaseDao

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/4/12
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */

class EventStore(publisher: EventPublisher, dao: BaseDao) {
  def saveEvents(id: String, events: Buffer[DomainEvent], expectedVersion: Int) {
    Defense.notNull(id)
    Defense.notNull(events)
    Defense.notNull(dao)

    var currentEvents:ArrayBuffer[EventDescriptor] = dao.retrieve(id)
    if (currentEvents == null) {
      currentEvents = new ArrayBuffer[EventDescriptor]()
      dao.create(id, currentEvents)
    } else {
      var count:Int = currentEvents.length
      val lastEvent:EventDescriptor = currentEvents(count-1)
      if (lastEvent.version != expectedVersion)
      {
        throw new ConcurrencyException
      }
    }

    var version:Int = expectedVersion
    for (event <- events) {
      version += 1
      val eventDesc = new EventDescriptor(id, event, version)
      currentEvents += eventDesc
      publisher.publish(event)
    }

    // TODO is this necessary?
    dao.update(id, currentEvents)
  }

  def getEventsForAggregate(id: String):Buffer[DomainEvent] = {
    Defense.notNull(id)
    Defense.notNull(dao)

    var events:Buffer[DomainEvent] = new ArrayBuffer[DomainEvent]()

    val eventDescs = dao.retrieve(id)
    for (eventDesc:EventDescriptor <- eventDescs) {
      events += eventDesc.event
    }

    events
  }
}
