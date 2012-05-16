package com.minimalbits.tasks.cqrs.handler

import com.minimalbits.tasks.cqrs.repository.{TaskRepository, BaseRepository}
import com.minimalbits.tasks.cqrs.domain.Task
import com.minimalbits.tasks.cqrs.command.{RenameTaskCommand, CompleteTaskCommand, CreateTaskCommand, BaseCommand}


/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/1/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */

class TaskCommandHandler extends BaseCommandHandler {
  val repository: TaskRepository = new TaskRepository()

  def handleCommand(command: BaseCommand) {
    command match {
      case createCommand: CreateTaskCommand => handleCreate(createCommand)
      case completeCommand: CompleteTaskCommand => handleComplete(completeCommand)
      case renameCommand: RenameTaskCommand => handleRename(renameCommand)
      case _ => throw new InvalidCommandException()
    }
  }

  def handleCreate(createCommand: CreateTaskCommand) {
    val task = new Task()
    task.name = createCommand.name
    task.description = createCommand.description
    task.dueDate = createCommand.dueDate
    task.completed = createCommand.completed

    repository.save(task, 0)
  }

  def handleComplete(completeCommand:CompleteTaskCommand) {
    val task:Task = repository.getById(completeCommand.id)
    task.markComplete()
    repository.save(task, completeCommand.expectedVersion)
  }

  def handleRename(command: RenameTaskCommand) {
    val task:Task = repository.getById(command.id)
    task.rename(command.name)
    repository.save(task, command.expectedVersion)
  }

}
