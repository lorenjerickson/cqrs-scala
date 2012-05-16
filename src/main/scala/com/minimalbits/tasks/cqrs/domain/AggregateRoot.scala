package com.minimalbits.tasks.cqrs.domain

import com.minimalbits.tasks.cqrs.event.DomainEvent
import com.minimalbits.tasks.cqrs.util.GuidFactory
import collection.mutable.{Buffer, ArrayBuffer}


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class AggregateRoot() {
  val id = GuidFactory.generateGuid()
  val changes = new ArrayBuffer[DomainEvent]()
  var version = 0;

  def uncommittedChanges = changes

  def markChangesCommitted() {
    changes.clear()
  }

  def applyChange(event: DomainEvent) {
    applyChangeInternal(event, true)
  }

  def loadFromHistory(history: Buffer[DomainEvent]) {
    for (event <- history) {
      applyChangeInternal(event, false)
    }
  }

  /**
   * NOTE: to be overridden by derived classes
   * @param event a concrete implementation of the DomainEvent class
   * @param isNew a flag indicating whether the event should be dispatched to the query side
   */
  def applyChangeInternal(event: DomainEvent, isNew: Boolean)
}
