/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.handler

abstract class BaseDetailQueryHandler[T] {
  def retrieve(id:String):T
}
