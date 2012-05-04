package com.minimalbits.tasks.cqrs.dao

import com.minimalbits.tasks.cqrs.eventstore.EventDescriptor
import collection.mutable.{ArrayBuffer, Buffer}

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class BaseDao(dbconfig:DaoConfig) {
  def create(id:String, events:ArrayBuffer[EventDescriptor])
  def retrieve(id:String):ArrayBuffer[EventDescriptor]
  def update(id:String, events:ArrayBuffer[EventDescriptor])
  def delete(id:String)
}
