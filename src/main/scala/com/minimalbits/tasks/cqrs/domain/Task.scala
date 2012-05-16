package com.minimalbits.tasks.cqrs.domain

import com.minimalbits.tasks.cqrs.event.{UnsupportedEventException, DomainEvent, TaskCreatedEvent}
import java.util.Date


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

class Task extends AggregateRoot {
  var name = ""
  var description = ""
  var dueDate: Date = new Date()
  var completed: Boolean = false

  val createdEvent: TaskCreatedEvent = new TaskCreatedEvent(id, name, description, dueDate, completed)
  applyChange(createdEvent)

  def applyTaskCreated(event: TaskCreatedEvent) {
    this.name = event.name
    this.description = event.description
    this.dueDate = event.dueDate
    this.completed = event.completed
  }

  def applyChangeInternal(event: DomainEvent, isNew: Boolean) {
    event match {
      case createdEvent: TaskCreatedEvent => applyTaskCreated(createdEvent)
      case _ => throw new UnsupportedEventException()
    }

    if (isNew) {
      changes += event
    }
  }
}
