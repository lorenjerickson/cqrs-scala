package com.minimalbits.tasks.cqrs.repository

import com.minimalbits.tasks.cqrs.eventstore.EventStore
import com.minimalbits.tasks.cqrs.domain.{Task, AggregateRoot}

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */

class TaskRepository extends BaseRepository[Task] {
  val eventStore = new EventStore

  def save(task: Task, expectedVersion: Int) {
    eventStore.saveEvents(task.id, task.changes, expectedVersion)
  }

  def getById(id: String):Task = {
    val events = eventStore.getEventsForAggregate(id)
    val task = new Task()
    task.loadFromHistory(events)
    task
  }
}
