package com.minimalbits.tasks.cqrs.repository

import com.minimalbits.tasks.cqrs.domain.AggregateRoot
import com.minimalbits.tasks.cqrs.dao.BaseDao

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class BaseRepository(dao:BaseDao) {
  def save(obj:AggregateRoot)
  def getById(id:String):AggregateRoot
}
