/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.handler

import com.minimalbits.tasks.cqrs.domain.Task
import com.minimalbits.tasks.cqrs.dto.{TaskDetailDto, TaskListDto}
import java.util.Date
import collection.mutable.{Buffer, ArrayBuffer}

class TaskListQueryHandler extends BaseListQueryHandler[TaskListDto] {
  def list():Buffer[TaskListDto] =
    new ArrayBuffer[TaskListDto]()
}
