package com.minimalbits.cqrs.tasks.model

import com.minimalbits.cqrs.tasks.event.DomainEvent
import collection.mutable.ArrayBuffer


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class AggregateRoot(id:String) {
  val changes = new ArrayBuffer[DomainEvent]()

  def uncommittedChanges = changes

  def markChangesCommitted() {
    changes.clear()
  }

  def applyChange(event:DomainEvent) {
    applyChangeInternal(event, true)
  }

  def loadFromHistory(history:List[DomainEvent]) {
    for (event <- history) {
      applyChangeInternal(event, false)
    }
  }

  /**
   * NOTE: to be overridden by derived classes
   * @param event a concrete implementation of the DomainEvent class
   * @param isNew a flag indicating whether the event should be dispatched to the query side
   */
  def applyChangeInternal(event:DomainEvent, isNew:Boolean)
}
