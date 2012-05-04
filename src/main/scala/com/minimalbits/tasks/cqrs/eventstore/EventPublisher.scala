package com.minimalbits.tasks.cqrs.eventstore

import com.minimalbits.tasks.cqrs.bus.EventBus
import com.minimalbits.tasks.cqrs.event.DomainEvent

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/4/12
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */

class EventPublisher(bus: EventBus) {
  def publish(event: DomainEvent) {

  }
}
