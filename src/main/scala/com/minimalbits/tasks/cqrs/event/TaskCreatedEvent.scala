package com.minimalbits.tasks.cqrs.event

import org.joda.time.DateTime

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */

case class TaskCreatedEvent(id: String, name: String, description: String, dueDate: DateTime, completed: Boolean) extends DomainEvent {

}
