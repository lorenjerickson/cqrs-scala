package com.minimalbits.tasks.cqrs.domain

import org.joda.time.DateTime
import com.minimalbits.tasks.cqrs.event.{UnsupportedEventException, DomainEvent, TaskCreatedEvent}


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

class Task(id:String, var name:String, var description:String, var dueDate:DateTime, var completed:Boolean) extends AggregateRoot(id) {
  val createdEvent:TaskCreatedEvent = new TaskCreatedEvent(id, name, description, dueDate, completed)
  applyChange(createdEvent)

  def applyTaskCreated(event:TaskCreatedEvent) {
    this.id = event.id          // TODO hmmmm
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
