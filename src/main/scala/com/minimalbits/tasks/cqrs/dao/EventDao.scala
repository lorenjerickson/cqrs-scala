package com.minimalbits.tasks.cqrs.dao

import com.minimalbits.tasks.cqrs.eventstore.EventDescriptor
import collection.mutable.ArrayBuffer

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/4/12
 * Time: 2:08 PM
 * To change this template use File | Settings | File Templates.
 */

class EventDao extends BaseDao {
  val cfg = new DaoConfig("localhost:3000", "sa", "root", "cqrs-scala", "events")

  def create(id: String, events: ArrayBuffer[EventDescriptor]) {}

  def retrieve(id: String) = null

  def update(id: String, events: ArrayBuffer[EventDescriptor]) {}

  def delete(id: String) {}
}
