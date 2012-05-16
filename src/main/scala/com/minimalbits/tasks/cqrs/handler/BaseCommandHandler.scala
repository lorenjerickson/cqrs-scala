package com.minimalbits.tasks.cqrs.handler

import com.minimalbits.tasks.cqrs.command.BaseCommand

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class BaseCommandHandler {
   def handleCommand(command:BaseCommand)
}
