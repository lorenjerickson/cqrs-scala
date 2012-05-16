package com.minimalbits.tasks.cqrs.bus

import com.minimalbits.tasks.cqrs.event.DomainEvent

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */

abstract class BaseEventHandler {
  def handleEvent(event:DomainEvent)
}

