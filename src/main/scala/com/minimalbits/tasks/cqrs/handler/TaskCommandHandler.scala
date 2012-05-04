package com.minimalbits.tasks.cqrs.handler

import com.minimalbits.tasks.cqrs.repository.{TaskRepository, BaseRepository}
import com.minimalbits.tasks.cqrs.command.{CreateTaskCommand, BaseCommand}
import com.minimalbits.tasks.cqrs.domain.Task


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */

class TaskCommandHandler extends BaseCommandHandler {
  val repository:BaseRepository = new TaskRepository()

  def handleCommand(command:BaseCommand) {
    command match {
      case createCommand:CreateTaskCommand => handleCreate(createCommand)
      case _ => throw new InvalidCommandException()
    }
  }

  def handleCreate(createCommand:CreateTaskCommand) {
    val task = new Task(createCommand.id, createCommand.name, createCommand.description, createCommand.dueDate, createCommand.completed)
    repository.save(task)
  }
}
