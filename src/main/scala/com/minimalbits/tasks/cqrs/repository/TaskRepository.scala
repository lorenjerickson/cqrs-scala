package com.minimalbits.tasks.cqrs.repository

import com.minimalbits.tasks.cqrs.domain.AggregateRoot

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */

class TaskRepository(dao:TaskDao) extends BaseRepository(dao) {


  def save(obj: AggregateRoot) {}

  def getById(id: String) = null
}
