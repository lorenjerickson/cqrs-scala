package com.minimalbits.tasks.cqrs.command

import org.joda.time.DateTime
import com.minimalbits.tasks.cqrs.util.GuidFactory

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */

case class CreateTaskCommand(name:String, description:String, dueDate:DateTime, completed:Boolean) extends BaseCommand {
  val id:String = GuidFactory.generateGuid()
}
