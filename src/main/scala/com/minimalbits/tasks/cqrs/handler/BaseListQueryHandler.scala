/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.handler

import collection.mutable.Buffer

abstract class BaseListQueryHandler[T] {
  def list(): Buffer[T]
}

