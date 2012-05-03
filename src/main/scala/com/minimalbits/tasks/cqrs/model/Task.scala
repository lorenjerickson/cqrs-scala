package com.minimalbits.tasks.cqrs.model

import org.joda.time.DateTime
import com.minimalbits.tasks.cqrs.event.{UnsupportedEventException, DomainEvent, TaskCreatedEvent}


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

class Task(id:String, name:String, description:String, dueDate:DateTime, completed:Boolean) extends AggregateRoot(id) {

  def createTask(id: String, name: String, description: String, dueDate: DateTime, completed: Boolean) {
    val event = new TaskCreatedEvent(id, name, description, dueDate, completed)
    applyChange(event)
  }

  def applyChangeInternal(event: DomainEvent, isNew: Boolean) {
    event match {
      case createdEvent: TaskCreatedEvent => createTask(
        createdEvent.id, createdEvent.name, createdEvent.description, createdEvent.dueDate, createdEvent.completed)
      case _ => throw new UnsupportedEventException()
    }

    if (isNew) {
      changes += event
    }
  }
}
