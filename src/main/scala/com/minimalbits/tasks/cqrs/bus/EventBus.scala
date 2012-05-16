package com.minimalbits.tasks.cqrs.bus

import com.minimalbits.tasks.cqrs.event.DomainEvent
import collection.mutable.{ArrayBuffer, Buffer, WeakHashMap}

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */

class EventBus {
  val handlerMap = new WeakHashMap[String, ArrayBuffer[BaseEventHandler]]()

  def registerHandler(name: String, handler: BaseEventHandler) {
    var handlers = handlerMap.get(name)
    handlers match {
      case buffer: Buffer[BaseEventHandler] => buffer += handler
      case _ => {
        var newBuffer = new ArrayBuffer[BaseEventHandler]()
        newBuffer += handler
        handlerMap.put(name, newBuffer)
      }
    }
  }

  def publishEvent(event: DomainEvent) {
    val entry = handlerMap.get(event.eventName)
    entry match {
      case handlers: List[BaseEventHandler] => for (handler: BaseEventHandler <- handlers) {
        handler.handleEvent(event)
      }
      case _ => // TODO log warning: event triggered without handlers
    }
  }
}
