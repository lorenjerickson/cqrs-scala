package com.minimalbits.tasks.cqrs.domain

import java.util.Date
import com.minimalbits.tasks.cqrs.event._


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

  //----------------------------------------------------------------
  // domain methods
  //----------------------------------------------------------------

  def markComplete() {
    val completedEvent = new TaskCompletedEvent(id, true)
    applyChange(completedEvent)
  }

  def rename(newName:String) {
    val event = new TaskRenamedEvent(id, newName)
    applyChange(event)
  }

  //----------------------------------------------------------------
  // internal apply methods
  //----------------------------------------------------------------

  private def applyTaskCreated(event: TaskCreatedEvent) {
    this.name = event.name
    this.description = event.description
    this.dueDate = event.dueDate
    this.completed = event.completed
  }

  private def applyTaskCompleted(event: TaskCompletedEvent) {
    this.completed = event.completed
  }

  private def applyTaskRenamed(event: TaskRenamedEvent) {
    this.name = event.name;
  }

  //----------------------------------------------------------------
  // domain object specific apply method router
  //----------------------------------------------------------------

  // TODO this should be protected, but...
  def applyChangeInternal(event: DomainEvent, isNew: Boolean) {
    event match {
      case createdEvent: TaskCreatedEvent => applyTaskCreated(createdEvent)
      case completedEvent: TaskCompletedEvent => applyTaskCompleted(completedEvent)
      case renameEvent:TaskRenamedEvent => applyTaskRenamed(renameEvent)
      case _ => throw new UnsupportedEventException()
    }

    if (isNew) {
      changes += event
    }
  }
}
