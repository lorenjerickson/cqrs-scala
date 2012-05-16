/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.handler

import com.minimalbits.tasks.cqrs.dto.TaskDetailDto
import java.util.Date

class TaskDetailQueryHandler extends BaseDetailQueryHandler[TaskDetailDto] {
  def retrieve(id: String):TaskDetailDto =
    new TaskDetailDto(id, "","",new Date(), false)

}
