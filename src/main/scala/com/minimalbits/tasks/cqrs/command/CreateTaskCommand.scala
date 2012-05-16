package com.minimalbits.tasks.cqrs.command

import com.minimalbits.tasks.cqrs.util.GuidFactory
import java.util.Date

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */

case class CreateTaskCommand(name:String, description:String, dueDate:Date, completed:Boolean) extends BaseCommand {
  val id:String = GuidFactory.generateGuid()
}
