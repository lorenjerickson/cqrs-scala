/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.query

import com.minimalbits.tasks.cqrs.bus.BaseEventHandler
import com.minimalbits.tasks.cqrs.event.{TaskCompletedEvent, DomainEvent}

object TaskDetailQuery extends BaseEventHandler {

  def handleEvent(event: DomainEvent) {
    event match {
      case taskCompleted:TaskCompletedEvent => handleTaskCompleted(taskCompleted)
    }
  }

  def handleTaskCompleted(event: TaskCompletedEvent) {

  }
}