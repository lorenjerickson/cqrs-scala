package com.minimalbits.tasks.cqrs.bus

import com.minimalbits.tasks.cqrs.handler.BaseCommandHandler
import com.minimalbits.tasks.cqrs.command.BaseCommand
import collection.mutable.{ArrayBuffer, WeakHashMap, Queue}
import com.minimalbits.tasks.cqrs.util.InvalidOperationException

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */

class CommandQueue {
  val handlerMap = new WeakHashMap[String, BaseCommandHandler]()

  def registerHandler(name:String, handler:BaseCommandHandler) {
    val theHandler = handlerMap.get(name)
    theHandler match {
      case any:Any => throw new InvalidOperationException("only one handler can be registered for a command")
      case null => handlerMap.put(name, handler)
    }
  }

  def sendCommand(command:BaseCommand) {
    val entry = handlerMap.get(command.getClass.getName)
    entry match {
      case handler:BaseCommandHandler => {
        handler.handleCommand(command)
      }
      case _ => throw new InvalidOperationException("no handler exists for the command")
    }
  }
}
