package com.minimalbits.tasks.cqrs.util

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/4/12
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */

object Defense {
  def notNull(any: Any) {
    if (any == null) throw new InvalidOperationException("defense: null reference")
  }

  def inRange(a: Int, min: Int, max: Int) {
    if (a < min || a >= max) throw new InvalidOperationException("defense: index not in expected range")
  }
}
